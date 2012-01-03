package br.unicamp.ic.sed.mobilemedia.captureMedia.aspects;

import javax.microedition.media.MediaException;

public aspect XPIInternalCapturePhoto {

	public pointcut takePicture() : execution( public byte[] br.unicamp.ic.sed.mobilemedia.captureMedia.impl.CaptureScreen.takePicture());

	declare soft : MediaException : takePicture();
}
