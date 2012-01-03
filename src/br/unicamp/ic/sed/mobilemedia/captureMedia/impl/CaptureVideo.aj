package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.control.RecordControl;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IMobileResources;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.IManager;
import java.io.ByteArrayOutputStream;

aspect CaptureVideo {
	
	private Command start = new Command("Start", Command.EXIT, 1);
	private Command pause = new Command("Stop", Command.ITEM, 1);
	
	after( GameCanvas screen ) : XPICaptureMedia.initMenu( screen ) {
		screen.addCommand( start );
		screen.addCommand( pause );
	} 
	
	//========================================================================
	public void CaptureScreen.startCapture() {		
		if (!recording) {
			rControl = (RecordControl) capturePlayer.getControl("RecordControl");
			byteOfArray = new ByteArrayOutputStream();
			rControl.setRecordStream(byteOfArray);
			rControl.startRecord();
			recording = true;
		}
		
	}
	
	public void CaptureScreen.pauseCapture() {
		try {
			if (recording) {
				rControl.stopRecord();
				rControl.commit();
				recording = false;
			}
		} catch (Exception e) {
//			Error while stoping capturing video.
			e.printStackTrace();
		}
	}
	public byte[] CaptureScreen.getByteArrays() {
		return byteOfArray.toByteArray();
	}
	
	//====================================================================
	private IManager manager = ComponentFactory.createInstance();
	
	private pointcut handleCommand( Command command ) : execution(public boolean CaptureController.handleCommand( Command ))
	&& args( command );
	
	boolean around( Command command ) : handleCommand( command ){
		if( command.getLabel().equals("Start")){
			IMobileResources mobile = (IMobileResources)manager.getRequiredInterface("IMobileResources");
			
			CaptureScreen screen = (CaptureScreen)Display.getDisplay( mobile.getMainMIDlet() ).getCurrent();
			screen.startCapture();
			return true;
		}else if( command.getLabel().equals("Stop")){
			IMobileResources mobile = (IMobileResources)manager.getRequiredInterface("IMobileResources");
			
			CaptureScreen screen = (CaptureScreen)Display.getDisplay( mobile.getMainMIDlet() ).getCurrent();
			screen.pauseCapture();
			byte[] video = screen.getByteArrays();
			
			AddMediaToAlbum addScreen = new AddMediaToAlbum("Add media to album");
			CaptureController controller = new CaptureController( mobile.getMainMIDlet() );
			addScreen.setCommandListener( controller );
			controller.setAddScreen( addScreen );
			controller.setMedia( video );
			
			Display.getDisplay( mobile.getMainMIDlet() ).setCurrent( addScreen );
			return true;
		}
		return proceed( command );
	}
	
}
