package br.unicamp.ic.sed.mobilemedia.captureMedia.aspects;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.InvalidImageDataException;

import javax.microedition.lcdui.Command;

public aspect XPICaptureController {

	public pointcut addNewMediaToAlbum() : call( public void IFilesystem.addNewMediaToAlbum(String,String,String,byte[]))
		&& withincode( public boolean br.unicamp.ic.sed.mobilemedia.captureMedia.impl.CaptureController.handleCommand( Command ) );
	
	declare soft : PersistenceMechanismException : addNewMediaToAlbum();
	declare soft : InvalidImageDataException : addNewMediaToAlbum();
	
}
