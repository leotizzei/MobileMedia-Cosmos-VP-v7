package br.unicamp.ic.sed.mobilemedia.excep_connector_VP.impl.variants;

import br.unicamp.ic.sed.mobilemedia.excep_connector_VP.impl.ExceptionAdapter;

import br.unicamp.ic.sed.mobilemedia.captureMedia.aspects.XPICaptureController;
import br.unicamp.ic.sed.mobilemedia.captureMedia.aspects.XPIInternalCapturePhoto;

public aspect CaptureMediaBinder extends ExceptionAdapter {
	
	public pointcut handleException() : XPICaptureController.addNewMediaToAlbum()
										|| XPIInternalCapturePhoto.takePicture();

}
