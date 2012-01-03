package br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl;

import javax.microedition.rms.RecordStore;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;

public aspect CaptureMediaVariant {

	public void AlbumData.addNewMediaToAlbum(String albumName, String mediaName, String mediaType, byte[] media) throws PersistenceMechanismException, InvalidImageDataException{
		imageAccessor.addNewMediaToAlbum( albumName , mediaName , mediaType, media );
	}
	
	public void ImageAccessor.addNewMediaToAlbum(String albumName, String mediaName, String mediaType, byte[] media) throws PersistenceMechanismException, InvalidImageDataException {
		
		imageRS = RecordStore.openRecordStore(album_label + albumName, true);
		
		imageInfoRS = RecordStore.openRecordStore(info_label + albumName, true);

		int rid; // new record ID for Image (bytes)
		int rid2; // new record ID for ImageData (metadata)

		ImageUtil converter = new ImageUtil();

		rid = imageRS.addRecord(media, 0, media.length);
		IImageData ii = new ImageData(rid, album_label + albumName, mediaName);
		ii.setType( mediaType );
		rid2 = imageInfoRS.getNextRecordID();
		ii.setRecordId(rid2);
		
		
		byte[] data1 = converter.getBytesFromImageInfo(ii);
		imageInfoRS.addRecord(data1, 0, data1.length);

		imageRS.closeRecordStore(); 

		imageInfoRS.closeRecordStore();
		
	}
	
}
