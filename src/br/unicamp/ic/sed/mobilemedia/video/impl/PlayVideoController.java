/**
 * University of Campinas - Brazil
 * Institute of Computing
 * SED group
 *
 * date: March 2009

 * Changed in MM-Cosmos-v7
 */
//#ifdef includeVideo
package br.unicamp.ic.sed.mobilemedia.video.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.video.spec.prov.IManager;

class PlayVideoController extends AbstractController{

	private String mediaName;
	
	private PlayVideoScreen pmscreen;

	private String currentAlbumName = null;
	
	public PlayVideoController(MIDlet midlet,PlayVideoScreen pmscreen) {
		super( midlet );
		this.pmscreen = pmscreen;
		IManager mgr = ComponentFactory.createInstance();
	}

	protected void setCurrentStoreName(String albumName){
		this.currentAlbumName = albumName;
	}

	public boolean handleCommand(Command command){
		String label = command.getLabel();
		System.out.println( "<* PlayVideoController.handleCommand() *> " + label);
		
		/** Case: Copy photo to a different album */
		if (label.equals("Start")) {
			pmscreen.startVideo();
			return true;
		}else if (label.equals("Stop")) {
			pmscreen.stopVideo();
			return true;
		}else if ((label.equals("Back"))||(label.equals("Cancel"))){
			pmscreen.stopVideo();
			pmscreen.dispose();
			return true;
		}
		
		return false;
	}

	protected String getMediaName() {
		return mediaName;
	}

	protected void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
}

