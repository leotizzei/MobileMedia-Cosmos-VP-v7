package br.unicamp.ic.sed.mobilemedia.photo.spec.req;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidImageDataException;

import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

public interface IFilesystem{
	

	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException; 
		
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException; 
				
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException; 
	
	/**[cosmos][add Sce 2. Edit Label]
	 * 
	 * @param imageName
	 * @return
	 * @throws ImageNotFoundException
	 * @throws NullAlbumDataReference
	 */
	public IImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference; 
	
	public IImageData[] getImages ( String albumName ) throws UnavailablePhotoAlbumException ;
		
	public boolean updateImageInfo(IImageData oldData, IImageData newData) throws InvalidImageDataException, PersistenceMechanismException;

}