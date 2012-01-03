package br.unicamp.ic.sed.mobilemedia.captureMedia.aspects;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;

import br.unicamp.ic.sed.mobilemedia.captureMedia.impl.ComponentFactory;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.ICaptureMedia;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.IManager;

public abstract aspect CapturePhotoOrVideo {

	public final Command takePhoto = new Command("Capture Photo", Command.ITEM, 1);
	public final Command captureVideo = new Command("Capture Video", Command.ITEM, 1);
	
	public abstract pointcut addCommandPhoto( Displayable screen );
	
	
	after( Displayable screen ) : addCommandPhoto( screen ){
		screen.addCommand( takePhoto );
	}
	
	public abstract pointcut addCommandVideo( Displayable screen );
	
	after( Displayable screen ) : addCommandVideo( screen ){
		screen.addCommand( captureVideo );
	}
	
	private IManager manager = ComponentFactory.createInstance();
	
	public abstract pointcut postCommand( Command command );
	
	boolean around( Command command ) : postCommand( command ){
		if( command.getLabel().equals("Capture Photo")){
			ICaptureMedia capture = (ICaptureMedia)manager.getProvidedInterface("ICaptureMedia");
			capture.startCapturing();
			return true;
		}else if( command.getLabel().equals("Capture Video")){
			ICaptureMedia capture = (ICaptureMedia)manager.getProvidedInterface("ICaptureMedia");
			capture.startCapturing();
			return true;
		}else
			return proceed( command );
	}
	
} 
