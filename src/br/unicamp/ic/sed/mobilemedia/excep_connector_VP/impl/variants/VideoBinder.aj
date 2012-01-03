package br.unicamp.ic.sed.mobilemedia.excep_connector_VP.impl.variants;

import br.unicamp.ic.sed.mobilemedia.excep_connector_VP.impl.ExceptionAdapter;

import br.unicamp.ic.sed.mobilemedia.video.aspects.XPIFacade;
import br.unicamp.ic.sed.mobilemedia.video.aspects.XPIPlayVideoScreen;

public aspect VideoBinder extends ExceptionAdapter{

	public pointcut handleException() : XPIFacade.getMedia()
									||  XPIFacade.getVideo()

									|| XPIPlayVideoScreen.createVideoScreen();
}
