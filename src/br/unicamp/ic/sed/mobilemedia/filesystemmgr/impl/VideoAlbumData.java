// #ifdef includeVideo
// [NC] Added in the scenario 08
package br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;


class VideoAlbumData extends AlbumData{
	
	public VideoAlbumData() {
		imageAccessor = new VideoMediaAccessor();
	}
	
	public InputStream getVideoFromRecordStore(String recordStore, String videoName) throws PersistenceMechanismException, ImageNotFoundException{
		IImageData mediaInfo = null;
		mediaInfo = imageAccessor.getImageInfo( videoName );
		//Find the record ID and store name of the image to retrieve
		int mediaId = mediaInfo.getForeignRecordId();
		String album = mediaInfo.getParentAlbumName();
		//Now, load the image (on demand) from RMS and cache it in the hashtable
		
		byte[] videoData = imageAccessor.loadImageBytesFromRMS(album, videoName, mediaId);
		
		
		return new ByteArrayInputStream(videoData);

	}
}