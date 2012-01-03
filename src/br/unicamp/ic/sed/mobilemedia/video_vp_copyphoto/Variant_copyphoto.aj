package br.unicamp.ic.sed.mobilemedia.video_vp_copyphoto;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.game.GameCanvas;

import br.unicamp.ic.sed.mobilemedia.video.aspects.XPIFacade;
import br.unicamp.ic.sed.mobilemedia.video.aspects.XPIPlayVideoController;
import br.unicamp.ic.sed.mobilemedia.video.aspects.XPIPlayVideoScreen;

public privileged aspect Variant_copyphoto {

	private CopyphotoStub copyphoto = new CopyphotoStub(); 
	
	public pointcut postCommand(Command c):XPIPlayVideoController.postCommand(c);
		
	boolean around( Command c ) : postCommand( c ){
		if( !copyphoto.postCommand( c ))
			return proceed( c );
		return true;
	}
	
	public pointcut setButtons(GameCanvas photoViewScreen):
		XPIPlayVideoScreen.setButtons(photoViewScreen);
	
	after( GameCanvas photoViewScreen ) :  setButtons(photoViewScreen){
		copyphoto.addCopyCommand( photoViewScreen );
	}
	
	public pointcut playVideo(String albumName , String musicName):
		XPIFacade.playVideo(albumName,musicName);
	
	after( String albumName , String musicName ) : playVideo(albumName, musicName){
		copyphoto.showImage( musicName );
	}
}
