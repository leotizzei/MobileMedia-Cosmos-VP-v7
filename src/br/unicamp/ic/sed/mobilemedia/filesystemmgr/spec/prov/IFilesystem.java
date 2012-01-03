package br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

public interface IFilesystem{
	

	public IImageData[] getImages ( String albumName ) throws UnavailablePhotoAlbumException ; 
	
	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException; 
	
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException; 
	
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException; 
		
	public String[] getAlbumNames (  ) ; 
	
	public void resetImageData (  ) throws PersistenceMechanismException /*throws PersistenceMechanismException, InvalidImageDataException*/; 
	
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException; 
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException;
		
	public boolean updateImageInfo(IImageData oldData, IImageData newData) throws InvalidImageDataException, PersistenceMechanismException;

	//[cosmos][add Sce 2. Edit Label]
	public IImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;
	
	
	/**
	 * This method was exposed to support the implementation of
	 * the copyPhoto aspect
	 * @param imageFile
	 * @return
	 * @throws InvalidImageDataException 
	 */
	public byte[] getBytesFromImageInfo(IImageData ii) throws InvalidImageDataException; 
	
	public void addImageData( String imageName , IImageData imageData , String albumName ) throws InvalidImageDataException, PersistenceMechanismException;
	
	public void addNewMediaToAlbum(String albumName, String mediaName,String mediaType, byte[] media) throws PersistenceMechanismException, InvalidImageDataException;
}