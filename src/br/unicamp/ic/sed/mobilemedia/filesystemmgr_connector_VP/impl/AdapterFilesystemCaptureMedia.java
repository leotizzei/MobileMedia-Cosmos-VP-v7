package br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;


class AdapterFilesystemCaptureMedia implements IFilesystem {
 
	public void addNewMediaToAlbum(String albumName, String mediaName, String mediaType, byte[] media) 
	throws br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.PersistenceMechanismException,
	br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.InvalidImageDataException{
		
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem
			= (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)
			manager.getRequiredInterface("IFilesystem");
			
		try {
			filesystem.addNewMediaToAlbum(albumName, mediaName, mediaType, media);
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.PersistenceMechanismException( e.getMessage() );
		} catch (InvalidImageDataException e) {
			throw new br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.InvalidImageDataException( e.getMessage() );
		} 
		
	}
}
