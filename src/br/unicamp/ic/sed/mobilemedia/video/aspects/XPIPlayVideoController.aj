package br.unicamp.ic.sed.mobilemedia.video.aspects;

import javax.microedition.lcdui.Command;

public aspect XPIPlayVideoController {
	
	public pointcut postCommand( Command command ) :
		execution( public boolean br.unicamp.ic.sed.mobilemedia.video.impl.PlayVideoController.handleCommand( Command ))
		&& args( command );
}
