package br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;



class VideoMediaAccessor  extends ImageAccessor{
	
	private MusicUtil musicUtil;
	
	public VideoMediaAccessor() {
		super("vvp-","vvpi-","My Video Album");
		musicUtil = new MusicUtil(); 
	}
	
	public void resetImageRecordStore() throws InvalidImageDataException, PersistenceMechanismException {
		removeRecords();
		
		// Now, create a new default album for testing
		//	addVideoData("Fish", default_album_name, this.getClass().getResourceAsStream(name))
		
		IImageData media = null;
		InputStream is = (InputStream) this.getClass().getResourceAsStream("/images/fish.mpg");
		byte[] video = null;
		try {
			video = inputStreamToBytes(is);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		addVideoData("Fish", default_album_name, "mpeg", video);
		loadImageDataFromRMS(default_album_name);

		try {
			System.out.println("[VideoMediaAccessor:resetRecordStore] default_album_name="+default_album_name);
			media = this.getImageInfo("Fish");
			
			media.setType("video");
			
			
			this.updateImageInfo(media, media);
		} catch (ImageNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void addVideoData(String videoname, String albumname, String fileExtension, byte[] video)
		throws InvalidImageDataException, PersistenceMechanismException {
		try {
			addMediaArrayOfBytes(videoname, albumname, "video", fileExtension, video);
		} catch (RecordStoreException e) {
			throw new PersistenceMechanismException();
		}
	}
	
	protected void addMediaArrayOfBytes(String mediaName, String albumName, String mediaType, String fileExtension, byte[] data1) throws RecordStoreException,
	RecordStoreFullException, RecordStoreNotFoundException,
	RecordStoreNotOpenException, InvalidImageDataException {


		RecordStore mediaRS = RecordStore.openRecordStore(album_label + albumName, true);

		//System.out.println("[MediaAccessor:addMediaArrayOfBytes]"+info_label + albumName);
		RecordStore mediaInfoRS = RecordStore.openRecordStore(info_label + albumName, true);

		int rid = 0; // new record ID for Image (bytes)
		int rid2; // new record ID for ImageData (metadata)
		try{
			rid = mediaRS.addRecord(data1, 0, data1.length);
		}catch( Exception e ){ e.printStackTrace(); }
		IImageData ii = new ImageData(rid, album_label + albumName, mediaName);
		rid2 = mediaInfoRS.getNextRecordID();

		ii.setRecordId(rid2);

		ii.setType(mediaType);
		
		data1 = musicUtil.getBytesFromImageInfo(ii);

		mediaInfoRS.addRecord(data1, 0, data1.length);
		mediaRS.closeRecordStore();
		mediaInfoRS.closeRecordStore();
	}
	
	protected byte[] inputStreamToBytes(InputStream inputStream) throws IOException {
		return this.readBytes(inputStream);
	}
	
	private byte[] readBytes( InputStream in ){
		try {	
			String b = in.toString();
			byte[] bytes = new byte[ in.available() ];
		
			in.read( bytes , 0 , in.available() );
			System.out.println("Size: " + b.length() );
			
		return bytes;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 */
	private void removeRecords() {
		String storeName = null;
		String infoStoreName = null;

		// remove any existing album stores...
		if (albumNames != null) {
			for (int i = 0; i < albumNames.length; i++) {
				try {
					// Delete all existing stores containing Image objects as
					// well as the associated ImageInfo objects
					// Add the prefixes labels to the info store

					storeName = album_label + albumNames[i];
					infoStoreName = info_label + albumNames[i];

					System.out.println("<* ImageAccessor.resetVideoRecordStore() *> delete "+storeName);
					
					RecordStore.deleteRecordStore(storeName);
					RecordStore.deleteRecordStore(infoStoreName);

				} catch (RecordStoreException e) {
					System.out.println("No record store named " + storeName
							+ " to delete.");
					System.out.println("...or...No record store named "
							+ infoStoreName + " to delete.");
					System.out.println("Ignoring Exception: " + e);
					// ignore any errors...
				}
			}
		} else {
			// Do nothing for now
			System.out
					.println("ImageAccessor::resetVideoRecordStore: albumNames array was null. Nothing to delete.");
		}
	}	
}