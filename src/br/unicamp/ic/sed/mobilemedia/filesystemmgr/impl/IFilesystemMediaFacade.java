package br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl;

import java.io.InputStream;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystemMedia;

public class IFilesystemMediaFacade extends IFilesystemFacade implements IFilesystemMedia{

	public IFilesystemMediaFacade(){
		super();
	}
	
	public InputStream getMusicFromRecordStore(String recordStore, String musicName) 
		throws ImageNotFoundException,PersistenceMechanismException {
		
		return new MusicAlbumData().getMusicFromRecordStore(recordStore, musicName);
		
	}

	public InputStream getVideoFromRecordStore(String recordStore,String videoName) 
	throws PersistenceMechanismException,ImageNotFoundException {
		
		return new VideoAlbumData().getVideoFromRecordStore(recordStore, videoName);
	}

}
