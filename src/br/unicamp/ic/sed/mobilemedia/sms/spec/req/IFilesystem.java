
 
package br.unicamp.ic.sed.mobilemedia.sms.spec.req;

import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

/**
 * In MobileMedia-Cosmos-v4, it was exchanged the usage of the datatype ImageData by the interface IImageData
 * that is implemented by the ImageData datatype.
 * 
 *
 */
public interface IFilesystem{
	
	public String[] getAlbumNames (  );  
	public IImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;

	public byte[] getBytesFromImageInfo(IImageData ii) throws InvalidImageDataException;
}

