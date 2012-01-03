
package br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl;

import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.copyphoto.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

class AdapterFilesystemCopyPhoto implements IFilesystem{

	private IManager manager = ComponentFactory.createInstance();
 
	public IImageData[] getImages ( String albumName ) throws UnavailablePhotoAlbumException {

		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		
		try {
			return filesystem.getImages(albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException e) {
			e.printStackTrace();
			throw new UnavailablePhotoAlbumException(e.getMessage());
		}
		
	}


	public byte[] getBytesFromImageInfo(IImageData ii)
			throws InvalidImageDataException {

		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getBytesFromImageInfo(ii);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e) {
			e.printStackTrace();
			throw new InvalidImageDataException(e);
		}
	}

	
	public IImageData getImageInfo(String imageName)
			throws ImageNotFoundException, NullAlbumDataReference {
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImageInfo(imageName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e) {
			e.printStackTrace();
			throw new ImageNotFoundException(e);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference e) {
			e.printStackTrace();
			throw new NullAlbumDataReference(e);
		}
	}

	 
	public void addImageData(String imageName, IImageData imageData,
			String albumName) throws InvalidImageDataException, PersistenceMechanismException {


		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.addImageData(imageName, imageData, albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e) {
			throw new InvalidImageDataException(e);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException(e);
		}
		
	} 


}