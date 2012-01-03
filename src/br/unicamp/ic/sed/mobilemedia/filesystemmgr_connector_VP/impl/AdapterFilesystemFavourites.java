package br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl;

import br.unicamp.ic.sed.mobilemedia.favourites.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.favourites.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.favourites.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.favourites.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

class AdapterFilesystemFavourites implements IFilesystem {

	private IManager manager = ComponentFactory.createInstance();
	
	public IImageData[] getImages(String albumName)
			throws UnavailablePhotoAlbumException {
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem) manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImages(albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException e) {
			e.printStackTrace();
			throw new UnavailablePhotoAlbumException(e.getMessage());
		}
	}

	
	public boolean updateImageInfo(IImageData oldData, IImageData newData)
			throws InvalidImageDataException, PersistenceMechanismException {
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem) manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.updateImageInfo(oldData, newData);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e) {
			throw new InvalidImageDataException(e.getMessage());
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException(e.getMessage());
		}
		
	}

}
