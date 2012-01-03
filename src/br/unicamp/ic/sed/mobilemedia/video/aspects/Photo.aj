package br.unicamp.ic.sed.mobilemedia.video.aspects;

import javax.microedition.lcdui.Command;

import br.unicamp.ic.sed.mobilemedia.video.impl.ComponentFactory;
import br.unicamp.ic.sed.mobilemedia.video.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.video.spec.prov.IVideo;

public abstract aspect Photo {
	private IManager manager = ComponentFactory.createInstance();
	
	public abstract pointcut handleCommand( Command c , String recordName , String videoName );
	
	boolean around( Command c , String recordName , String videoName ) : handleCommand( c , recordName , videoName ){	
				
		if( c.getLabel().equals("Play Video")){
			
			IVideo video = (IVideo)manager.getProvidedInterface("IVideo");
			video.playVideo( recordName , videoName );
			return true; 
		
		}
		
		return proceed( c , recordName, videoName);
	}
	
	
	
	public abstract pointcut addCommand( String command , int type , int posi );
	
	Command around( String command , int type , int posi ) : addCommand( command , type , posi ){
		if( command.equals("View") )
			command = "Play Video";
		
		return new Command( command , type , posi );
		
	}
}
