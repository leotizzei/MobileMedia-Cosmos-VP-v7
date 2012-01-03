package br.unicamp.ic.sed.mobilemedia.video.spec.req;

import java.io.InputStream;

import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.video.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.video.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.video.spec.excep.PersistenceMechanismException;

public interface IFilesystemVideo{
	public IImageData getMediaInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference; 
	public InputStream getVideoFromRecordStore(String recordStore, String videoName) throws PersistenceMechanismException, ImageNotFoundException;
}