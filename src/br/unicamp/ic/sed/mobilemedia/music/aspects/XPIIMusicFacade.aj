package br.unicamp.ic.sed.mobilemedia.music.aspects;

import br.unicamp.ic.sed.mobilemedia.music.impl.MusicController;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.ImageNotFoundException; 
import br.unicamp.ic.sed.mobilemedia.music.spec.excep.NullAlbumDataReference;; 

public aspect XPIIMusicFacade {
	
	public pointcut play( String albumName, String musicName ) :
		call( public void MusicController.playMusic(String,String))
		&& args( albumName , musicName );
	
	public pointcut playMusic() : execution( public void MusicController.playMusic(String,String));
	
	declare soft : PersistenceMechanismException : playMusic();
	declare soft : ImageNotFoundException : playMusic();
	declare soft : NullAlbumDataReference : playMusic();
}
