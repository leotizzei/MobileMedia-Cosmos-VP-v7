package br.unicamp.ic.sed.mobilemedia.video.aspects;

import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;
import java.io.InputStream;
import java.io.IOException;
import javax.microedition.media.MediaException;

public aspect XPIPlayVideoScreen {
	public pointcut setButtons( GameCanvas screen ) :
		call( private void br.unicamp.ic.sed.mobilemedia.video.impl.PlayVideoScreen.setButtons())
		&& target( screen );
	
	public pointcut createVideoScreen() :
		execution( public br.unicamp.ic.sed.mobilemedia.video.impl.PlayVideoScreen.new(MIDlet , InputStream , String ));
	
	declare soft : IOException : createVideoScreen();
	declare soft : MediaException : createVideoScreen();
}
