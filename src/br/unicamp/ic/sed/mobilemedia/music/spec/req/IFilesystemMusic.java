package br.unicamp.ic.sed.mobilemedia.music.spec.req;

import java.io.InputStream;

import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.PersistenceMechanismException;

public interface IFilesystemMusic{

	public InputStream getMusicFromRecordStore(String recordStore, String musicName) throws ImageNotFoundException, PersistenceMechanismException ;
	public IImageData getMediaInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;
}
