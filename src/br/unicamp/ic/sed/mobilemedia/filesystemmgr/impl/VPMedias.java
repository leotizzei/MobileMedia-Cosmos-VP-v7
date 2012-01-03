package br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl;

import java.util.Hashtable;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

public class VPMedias implements IAlbumData{	
	
	private AlbumData albumData = new AlbumData();
	private MusicAlbumData musicAlbumData = new MusicAlbumData();
	private VideoAlbumData videoAlbumData = new VideoAlbumData();
	
	private static String currentMedia = "Photos";
	
	public static void setMedia( String media ){
		System.out.println("========Mudou: " + media );
		currentMedia = media;
	}
	
	public void addNewPhotoToAlbum(String label, String path, String album)
			throws InvalidImageDataException, PersistenceMechanismException {
	
		if( currentMedia.equals( "Photos" ) )
			albumData.addNewPhotoToAlbum(label, path, album);
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.addNewPhotoToAlbum(label, path, album);
		else
			videoAlbumData.addNewPhotoToAlbum(label, path, album);
		
	}

	public void createNewPhotoAlbum(String albumName)
			throws PersistenceMechanismException,
			InvalidPhotoAlbumNameException {
		
		if( currentMedia.equals( "Photos" ) )
			albumData.createNewPhotoAlbum(albumName);
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.createNewPhotoAlbum(albumName);
		else
			videoAlbumData.createNewPhotoAlbum(albumName);
	}

	public void deleteImage(String imageName, String storeName)
			throws PersistenceMechanismException, ImageNotFoundException {
		
		if( currentMedia.equals( "Photos" ) )
			albumData.deleteImage(imageName, storeName);
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.deleteImage(imageName, storeName);
		else
			videoAlbumData.deleteImage(imageName, storeName);
	}

	public void deletePhotoAlbum(String albumName)
			throws PersistenceMechanismException {
		
		if( currentMedia.equals( "Photos" ) )
			albumData.deletePhotoAlbum(albumName);
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.deletePhotoAlbum(albumName);
		else
			videoAlbumData.deletePhotoAlbum(albumName);
	}

	public String[] getAlbumNames() {
		if( currentMedia.equals( "Photos" ) )
			return albumData.getAlbumNames();
		else if( currentMedia.equals( "Music" ) )
			return musicAlbumData.getAlbumNames();
		else
			return videoAlbumData.getAlbumNames();
				
	}

	public Image getImageFromRecordStore(String recordStore, String imageName)
			throws ImageNotFoundException, PersistenceMechanismException {
		
		if( currentMedia.equals( "Photos" ) ){
			return albumData.getImageFromRecordStore(recordStore, imageName);
		}
		return null;
	}

	public IImageData getImageInfo(String imageName)
			throws ImageNotFoundException {
		
		if( currentMedia.equals( "Photos" ) )
			return albumData.getImageInfo(imageName);
		else if( currentMedia.equals( "Music" ) )
			return musicAlbumData.getImageInfo(imageName);
		else
			return videoAlbumData.getImageInfo(imageName);
		
				
	}

	public Hashtable getImageInfoTable() {
		if( currentMedia.equals( "Photos" ) )
			return albumData.getImageInfoTable();
		else if( currentMedia.equals( "Music" ) )
			return musicAlbumData.getImageInfoTable();
		else
			return videoAlbumData.getImageInfoTable();
				
	}

	public void resetImageData() throws PersistenceMechanismException {
		
		if( currentMedia.equals( "Photos" ) )
			albumData.resetImageData();
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.resetImageData();
		else
			videoAlbumData.resetImageData();
				
	}

	public void setImageInfoTable(Hashtable imageInfoTable) {
		
		if( currentMedia.equals( "Photos" ) )
			albumData.setImageInfoTable(imageInfoTable);
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.setImageInfoTable(imageInfoTable);
		else
			videoAlbumData.setImageInfoTable(imageInfoTable);
				
				
	}

	public boolean updateImageInfo(IImageData oldData, IImageData newData)
			throws InvalidImageDataException, PersistenceMechanismException {

		if( currentMedia.equals( "Photos" ) )
			return albumData.updateImageInfo(oldData, newData);
		else if( currentMedia.equals( "Music" ) )
			return musicAlbumData.updateImageInfo(oldData, newData);
		else
			return videoAlbumData.updateImageInfo(oldData, newData);
				
	}
	
	public IImageData[] getImages( String recordName ) throws UnavailablePhotoAlbumException{
		if( currentMedia.equals( "Photos" ) )
			return albumData.getImages( recordName );
		else if( currentMedia.equals( "Music" ) )
			return musicAlbumData.getImages( recordName );
		else
			return videoAlbumData.getImages( recordName );
	}
	
	public void addImageData( String imageName , IImageData imageData , String albumName ) throws InvalidImageDataException, PersistenceMechanismException{
		if( currentMedia.equals( "Photos" ) )
			albumData.addImageData(imageName, imageData, albumName);
		else if( currentMedia.equals( "Music" ) )
			musicAlbumData.addImageData(imageName, imageData, albumName);
		else
			videoAlbumData.addImageData(imageName, imageData, albumName);
	}
	
	public void addNewMediaToAlbum(String albumName, String mediaName, String mediaType, byte[] media) throws PersistenceMechanismException, InvalidImageDataException{
		if( currentMedia.equals( "Photos" ) )
			albumData.addNewMediaToAlbum(albumName, mediaName, mediaType, media);
		else 
			videoAlbumData.addNewMediaToAlbum(albumName, mediaName, mediaType, media);
			
	} 

}
