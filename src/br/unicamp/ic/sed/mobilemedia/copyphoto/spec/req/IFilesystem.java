package br.unicamp.ic.sed.mobilemedia.copyphoto.spec.req;

import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

public interface IFilesystem{
	

	
	//[cosmos][add Sce 2. Edit Label]
	public IImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;
	public byte[] getBytesFromImageInfo(IImageData ii) throws InvalidImageDataException;
	public void addImageData( String imageName , IImageData imageData , String albumName ) throws InvalidImageDataException, PersistenceMechanismException;
	
}