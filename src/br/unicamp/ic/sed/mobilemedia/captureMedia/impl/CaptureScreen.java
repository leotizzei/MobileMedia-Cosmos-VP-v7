package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.RecordControl;
import javax.microedition.media.control.VideoControl;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.CommandListener;

public class CaptureScreen extends GameCanvas{
	
	Player capturePlayer = null;

	Display display = null;
	
	VideoControl videoControl = null;
	RecordControl rControl = null;
	ByteArrayOutputStream byteOfArray = new ByteArrayOutputStream();
	
	Command back = new Command("Back", Command.ITEM, 1);

	boolean recording = false;
	public final static int CAPTUREPHOTO = 1;
	public final static int CAPTUREVIDEO = 2;

	public CaptureScreen(MIDlet midlet) {
		super(false);
		display = Display.getDisplay(midlet);
		
		try {
			capturePlayer = Manager.createPlayer("capture://video");
			capturePlayer.realize();
		} catch (IOException e1) {
//			Error while loading the camera.
			e1.printStackTrace();
		} catch (MediaException e1) {
//			Error while loading the camera.
			e1.printStackTrace();
		}
		
		

		videoControl = (VideoControl) capturePlayer
				.getControl("javax.microedition.media.control.VideoControl");
		try {
			if (videoControl == null)
				throw new Exception("No Video Control for capturing!");

			videoControl.initDisplayMode(VideoControl.USE_DIRECT_VIDEO, this);
			videoControl.setDisplayFullScreen(true);
		} catch (MediaException me) {
			videoControl.setDisplayLocation(5, 5);
			try {
				videoControl.setDisplaySize(getWidth() - 10, getHeight() - 10);
			} catch (Exception e) {
//				Error while loading the camera.
				e.printStackTrace();
			}
			repaint();
		} catch (Exception e) {
//			Error while loading the camera.
			e.printStackTrace();
		}	

		this.initMenu();
	}
	
	private void initMenu(){
		this.addCommand(back);
	}

	public void keyPressed(int keyCode) {

	}

	public void paint(Graphics g) {
		g.setColor(0xffffff);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0x44ff66);
		g.drawRect(2, 2, getWidth() - 4, getHeight() - 4);
	}

	public void setVisibleVideo() {
		display.setCurrent(this);
		videoControl.setVisible(true);
		try {
			capturePlayer.start();
		} catch (Exception e) {
//			Error while starting the camera.
			e.printStackTrace();
		}
	}
}
