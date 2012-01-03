package br.unicamp.ic.sed.mobilemedia.video.aspects;

import br.unicamp.ic.sed.mobilemedia.video.spec.req.IFilesystemVideo;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.video.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.video.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.video.spec.excep.NullAlbumDataReference;

import java.io.InputStream;

public aspect XPIFacade {
	
	public pointcut playVideo( String albumName , String videoName ) : 
		execution( public boolean br.unicamp.ic.sed.mobilemedia.video.impl.IVideoFacade.playVideo(String , String ) )
		&& args( albumName , videoName );
	
	public pointcut getMedia( ) : call( public IImageData IFilesystemVideo.getMediaInfo(String))
		&& withincode( private br.unicamp.ic.sed.mobilemedia.video.impl.PlayVideoController 
				br.unicamp.ic.sed.mobilemedia.video.impl.IVideoFacade.getPlayVideoController(String ,String) 
			);
	
	public pointcut getVideo( ) : call( public InputStream IFilesystemVideo.getVideoFromRecordStore( String , String ))
	&& withincode( private br.unicamp.ic.sed.mobilemedia.video.impl.PlayVideoController 
			br.unicamp.ic.sed.mobilemedia.video.impl.IVideoFacade.getPlayVideoController(String ,String) 
		);
	
	
	declare soft : ImageNotFoundException : getMedia();
	declare soft : NullAlbumDataReference : getMedia();
	declare soft : ImageNotFoundException : getVideo();
	declare soft : PersistenceMechanismException : getVideo();
	
}
