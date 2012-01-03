// [NC] Added in the scenario 08
package br.unicamp.ic.sed.mobilemedia.video.impl;


import java.io.InputStream;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VideoControl;
import javax.microedition.midlet.MIDlet;


public class PlayVideoScreen extends GameCanvas {

	  private Player player = null;
	  private VideoControl videoControl = null;
	  
	  private Command start = new Command("Start", Command.EXIT, 1);
	  private Command back = new Command("Back", Command.ITEM, 1);
	  private Command stop = new Command("Stop", Command.ITEM, 1);
	  
	  
	  private boolean error = false;

	  private int dy = 2;  
	    
	  public void startVideo(){
	    if(error) return;   
	        
	    try {
			player.start();
		} catch (MediaException e) {
			e.printStackTrace();
		}
	    System.out.println("start!!!!");
	       
	  }
	  
	  public void stopVideo(){
	      if(player != null){
	    	  try {
				player.stop();
			} catch (MediaException e) {
				e.printStackTrace();
			}
	      }
	  }
	  
	  public void close(){
		  player.close();
	  }
	  
	  public void setController( AbstractController controller ){
		  this.setCommandListener(controller);
	  }
	  
	  
	  public PlayVideoScreen(MIDlet midlet,InputStream storedVideo, String type){
	    super(false); // do not supress key events
	    
	    // create the alerts, canvas and displays
	    
	    System.out.println("Stream: "+ storedVideo + "type: " + type);
	   
	    this.setButtons();
	    
	    
    	String types[] = Manager.getSupportedContentTypes("http");
    	for(int i = 0 ; i< types.length ; i++ ){
    		System.out.println(types[i]);
    	}
    	
    	// change content type for different devices, mp4 for C975, mpeg4 for M75
    	// #if simulatePlayVideo
    	player = Manager.createPlayer( getClass().getResourceAsStream("/images/fish.mpg"), "video/mpeg");	
    	//#else
    	player = Manager.createPlayer(storedVideo, "video/mpeg");
    	//#endif
      
    	player.realize();

    	videoControl = (VideoControl)player.getControl("VideoControl");      
    	videoControl.initDisplayMode(VideoControl.USE_DIRECT_VIDEO, this);
	    int halfCanvasWidth = this.getWidth();
	    int halfCanvasHeight = this.getHeight();
    	videoControl.setDisplayFullScreen(false);
    	videoControl.setDisplaySize(halfCanvasWidth-10, halfCanvasHeight-10);
    	videoControl.setDisplayLocation(5, 5);      
          
	  }

	  public void paint(Graphics g) { 
			g.setColor(0xffffff);
			g.fillRect(0, 0, getWidth(), getHeight());  
			flushGraphics();
	  }
	  
	  public void keyPressed(int keyCode) {
		int gameAction = getGameAction(keyCode);
	    int y = videoControl.getDisplayY();
	    if(gameAction == UP) {
	    	y -= dy;
	    } else if(gameAction == DOWN) {
	    	y += dy;
	    }
	    videoControl.setDisplayLocation(videoControl.getDisplayX(), y);   
	    repaint();     
	  } 
	  
	  private void setButtons(){
		  System.out.println("PlayVideoScreen: " + this);
		  this.addCommand(start);
		  this.addCommand(stop);
		  this.addCommand(back);
	  }
	  
	  private Displayable lastDisplay;
	  private MIDlet midlet;
	  
	  public void setVisibleVideo( MIDlet midlet ){
		  this.midlet = midlet;
		  lastDisplay = Display.getDisplay( midlet ).getCurrent();
		  Display.getDisplay( midlet ).setCurrent( this );
		  videoControl.setVisible(true);
	  
	  }
	  
	  public void dispose(){
		  Display.getDisplay( midlet ).setCurrent( lastDisplay );
	  }
	 
}