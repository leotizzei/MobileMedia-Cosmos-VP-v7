package br.unicamp.ic.sed.mobilemedia.favourites.spec.req;

import br.unicamp.ic.sed.mobilemedia.favourites.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.favourites.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.favourites.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

public interface IFilesystem{
	

	public IImageData[] getImages ( String albumName ) throws UnavailablePhotoAlbumException ; 
	
	
	public boolean updateImageInfo(IImageData oldData, IImageData newData) throws InvalidImageDataException, PersistenceMechanismException;

	
}