package br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl;

import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.sms.spec.req.IFilesystem;

public class AdapterFilesystemSms implements IFilesystem {

	public String[] getAlbumNames() {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem
			= (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)
				manager.getRequiredInterface("IFilesystem");
		
		return filesystem.getAlbumNames();
	}

	public IImageData getImageInfo(String imageName)
			throws ImageNotFoundException, NullAlbumDataReference {
		
		try{
			IManager manager = ComponentFactory.createInstance();
			br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem
				= (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)
					manager.getRequiredInterface("IFilesystem");
			
			return filesystem.getImageInfo(imageName);
		
		}catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e.getMessage() );
		}catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference e) {
			throw new NullAlbumDataReference( e.getMessage() );
		}
		
	}

	
	public byte[] getBytesFromImageInfo(IImageData ii)
			throws InvalidImageDataException {
		try{
			IManager manager = ComponentFactory.createInstance();
			br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem
				= (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)
					manager.getRequiredInterface("IFilesystem");
			
			return filesystem.getBytesFromImageInfo(ii);
		}catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e) {
			throw new InvalidImageDataException( e.getMessage() );
		}
		
	}

}