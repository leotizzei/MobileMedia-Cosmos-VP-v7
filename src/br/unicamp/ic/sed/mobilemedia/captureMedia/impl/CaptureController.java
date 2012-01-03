package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IFilesystem;

class CaptureController extends AbstractController {

	private IManager manager = ComponentFactory.createInstance();
	private AddMediaToAlbum addScreen = null;
	private byte[] media;
	private Display display;
	private Displayable lastScreen;
	
	public CaptureController( MIDlet midlet ){
		super( midlet );
		display = Display.getDisplay( midlet );
		lastScreen = display.getCurrent();
	}
	
	public boolean handleCommand(Command command) {
		System.out.println("CaptureController -> " + command.getLabel() );
		
		
		String label = command.getLabel();
		if( label.equals("Back")){
			
			disposeCaptureScreen();
			
			return true;
		}else if( label.equals("Save Item")){
			IFilesystem filesystem = (IFilesystem) manager.getRequiredInterface("IFilesystem");
			String mediaName = addScreen.getMediaName();
			String albumName = addScreen.getAlbumName();
			String mediaType = addScreen.getTypeOfMedia();
			filesystem.addNewMediaToAlbum( albumName , mediaName , mediaType , media );
			
			disposeCaptureScreen();
			return true;
		}
		return false;
	}


	public void setMedia(byte[] media) {
		this.media = media;
	}

	public byte[] getMedia() {
		return media;
	}


	public void setAddScreen(AddMediaToAlbum addScreen) {
		this.addScreen = addScreen;
	}


	public AddMediaToAlbum getAddScreen() {
		return addScreen;
	}
	
	public void disposeCaptureScreen(){
		display.setCurrent( lastScreen );
	}
	
}
