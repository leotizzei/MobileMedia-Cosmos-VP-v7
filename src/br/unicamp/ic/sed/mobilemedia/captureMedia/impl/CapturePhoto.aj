package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.game.GameCanvas;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IMobileResources;

public aspect CapturePhoto {
	
	private IManager manager = ComponentFactory.createInstance(); 
	private Command takephoto = new Command("Take Photo", Command.EXIT, 1);
	
	after( GameCanvas screen ) : XPICaptureMedia.initMenu( screen ){
		screen.addCommand( takephoto );
	}
	
	public byte[] CaptureScreen.takePicture() {
		
		Alert alert = new Alert("Error", "The mobile database is full", null, AlertType.INFO);
		alert.setTimeout(5000);
		display.setCurrent(alert);
		byte[] imageArray = null;
		
		imageArray = videoControl.getSnapshot(null);

		return imageArray;
		
	}
	
	/****************************************************************************/
	private pointcut handleCommand( Command command ) : execution(public boolean CaptureController.handleCommand( Command ))
		&& args( command );
	
	boolean around( Command command ): handleCommand( command ){
		if( command.getLabel().equals("Take Photo")){
			IMobileResources mobile = (IMobileResources)manager.getRequiredInterface("IMobileResources");
						
			CaptureScreen screen = (CaptureScreen)Display.getDisplay( mobile.getMainMIDlet() ).getCurrent();
			byte[] photo = screen.takePicture();
			
			AddMediaToAlbum addScreen = new AddMediaToAlbum("Add media to album");
			CaptureController controller = new CaptureController( mobile.getMainMIDlet() );
			addScreen.setCommandListener( controller );
			controller.setMedia( photo );
			controller.setAddScreen( addScreen );
			
			Display.getDisplay( mobile.getMainMIDlet() ).setCurrent( addScreen );
			return true;
		}
		return proceed( command ); 
	}
	
}
