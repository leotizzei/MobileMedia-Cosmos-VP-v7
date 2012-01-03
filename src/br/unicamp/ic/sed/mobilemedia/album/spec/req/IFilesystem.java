package br.unicamp.ic.sed.mobilemedia.album.spec.req;

import br.unicamp.ic.sed.mobilemedia.album.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.album.spec.excep.PersistenceMechanismException;

public interface IFilesystem{
	
		
	public String[] getAlbumNames (  ) ; 
	
	public void resetImageData (  ) throws PersistenceMechanismException /*throws PersistenceMechanismException, InvalidImageDataException*/; 
	
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException; 
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException;
		
}