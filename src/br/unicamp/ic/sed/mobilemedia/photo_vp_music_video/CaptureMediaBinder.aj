package br.unicamp.ic.sed.mobilemedia.photo_vp_music_video;

import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Command;

import br.unicamp.ic.sed.mobilemedia.captureMedia.aspects.CapturePhotoOrVideo;


public aspect CaptureMediaBinder extends CapturePhotoOrVideo {

	public pointcut postCommand( Command c ) : 
		execution( public boolean CaptureMediaStub.postCommand( Command ))
		&& args( c );
	
	public pointcut addCommandPhoto( Displayable display ) :
		execution( public void addPhotoCaptureCommand( Displayable ))
		&& args( display );
	
	public pointcut addCommandVideo( Displayable display ) :
		execution( public void addVideoCaptureCommand( Displayable ))
		&& args( display );
	
}
