package br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl;


import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.sorting.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.sorting.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.sorting.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.sorting.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl.IManager;

public class AdapterFilesystemSorting implements IFilesystem {

	private IManager manager = ComponentFactory.createInstance();

	public IImageData[] getImages(String albumName)
	throws UnavailablePhotoAlbumException{
		try{
			System.out.println("[AdapterSortingFilesystem:getImages]");
			br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
			filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
			return filesystem.getImages(albumName);
		}catch( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException  e){
			throw new UnavailablePhotoAlbumException(e.getMessage());
		}

	}


	public boolean updateImageInfo(IImageData oldData, IImageData newData)
	throws InvalidImageDataException, PersistenceMechanismException {
		try{
			br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
			filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
			return filesystem.updateImageInfo(oldData, newData);
		}catch( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e){
			throw new PersistenceMechanismException(e.getMessage());
		}catch(br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e){
			throw new InvalidImageDataException(e.getMessage());
		}


	}


}
