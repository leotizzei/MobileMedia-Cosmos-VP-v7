package br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.excep.PersistenceMechanismException;

public interface IFilesystem{
	
	public void addNewMediaToAlbum(String albumName, String mediaName,String mediaType, byte[] media) throws PersistenceMechanismException , InvalidImageDataException;
	
}