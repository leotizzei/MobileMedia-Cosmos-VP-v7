package br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov;

import java.io.InputStream;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;

public interface IFilesystemMedia extends IFilesystem{

	public InputStream getMusicFromRecordStore(String recordStore, String musicName) throws ImageNotFoundException, PersistenceMechanismException ;
	public InputStream getVideoFromRecordStore(String recordStore, String videoName) throws PersistenceMechanismException, ImageNotFoundException;
}
