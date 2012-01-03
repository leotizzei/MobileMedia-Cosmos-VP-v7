package br.unicamp.ic.sed.mobilemedia.filesystemmgr_connector_VP.impl;

import java.io.InputStream;

import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.music.spec.req.IFilesystemMusic;

class AdapterFilesystemMusic implements IFilesystemMusic{

	public InputStream getMusicFromRecordStore(String recordStore,
			String musicName) throws ImageNotFoundException,
			PersistenceMechanismException {
		try{
			IManager manager = ComponentFactory.createInstance();
			
			br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystemMedia filesystem =
				(br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystemMedia)
				manager.getRequiredInterface( "IFilesystem" );
		
			return filesystem.getMusicFromRecordStore(recordStore, musicName);
		}catch( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e ){
			throw new ImageNotFoundException( e.getMessage() );
		}catch( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e ){
			throw new PersistenceMechanismException( e.getMessage() );
		}
	}
	
	public IImageData getMediaInfo(String imageName)
			throws ImageNotFoundException, NullAlbumDataReference {
	
		try{
			IManager manager = ComponentFactory.createInstance();
			
			br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystemMedia filesystem =
				(br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystemMedia)
				manager.getRequiredInterface( "IFilesystem" );
		
			return filesystem.getImageInfo(imageName);
		}catch( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e ){
			throw new ImageNotFoundException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference e) {
			throw new NullAlbumDataReference( e.getMessage() );
		}

	}
	
}
