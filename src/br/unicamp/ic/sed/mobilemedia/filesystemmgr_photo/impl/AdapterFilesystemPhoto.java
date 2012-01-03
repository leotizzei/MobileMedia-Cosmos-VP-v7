package br.unicamp.ic.sed.mobilemedia.filesystemmgr_photo.impl;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.photo.spec.req.IFilesystem;

class AdapterFilesystemPhoto implements IFilesystem {

	public void addNewPhotoToAlbum(String imageName, String imagePath,
			String albumName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidImageDataException, br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.addNewPhotoToAlbum(imageName, imagePath, albumName);
		} catch (InvalidImageDataException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidImageDataException(e.getMessage());
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());		}
	}

	public void createNewPhotoAlbum(String albumName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException, br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidPhotoAlbumNameException {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.createNewPhotoAlbum(albumName);
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());
		} catch (InvalidPhotoAlbumNameException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidPhotoAlbumNameException(e.getMessage());
		}
	}

	public void deleteImage(String imageName, String albumName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException, br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.deleteImage(imageName, albumName);
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());
		} catch (ImageNotFoundException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException(e.getMessage());
		}
	}

	public void deletePhotoAlbum(String albumName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.deletePhotoAlbum(albumName);
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());
		}
	}

	public String[] getAlbumNames() {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		return filesystem.getAlbumNames();
	}

	public Image getImageFromRecordStore(String albumName, String imageName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException, br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException  {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImageFromRecordStore(albumName, imageName);
		} catch (ImageNotFoundException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException(e.getMessage());
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());
		}
	}

	public IImageData getImageInfo(String imageName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException, br.unicamp.ic.sed.mobilemedia.photo.spec.excep.NullAlbumDataReference {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImageInfo(imageName);
		} catch (ImageNotFoundException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException(e.getMessage());
		} catch (NullAlbumDataReference e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.NullAlbumDataReference(e.getMessage());
		}
	}

	public IImageData[] getImages(String albumName) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.UnavailablePhotoAlbumException {
		System.out.println(this.getClass().getName());
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImages(albumName);
		} catch (UnavailablePhotoAlbumException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.UnavailablePhotoAlbumException(e.getMessage());
		}
	}

	public void resetImageData() throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.resetImageData();
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());
		}
	}

	public boolean updateImageInfo(IImageData velhoID, IImageData novoID) throws br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidImageDataException, br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.updateImageInfo(velhoID, novoID);
		} catch (InvalidImageDataException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidImageDataException(e.getMessage());
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException(e.getMessage());
		}
		
	}

}
