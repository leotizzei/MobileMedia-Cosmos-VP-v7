package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;

import javax.microedition.lcdui.game.GameCanvas;

aspect XPICaptureMedia {

	pointcut initMenu( GameCanvas  screen ) : call( private void CaptureScreen.initMenu( ) )
		&& target(screen);
	
}
