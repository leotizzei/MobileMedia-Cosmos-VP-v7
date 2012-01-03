package br.unicamp.ic.sed.mobilemedia.photo_vp_music_video;

import javax.microedition.lcdui.Command;

import br.unicamp.ic.sed.mobilemedia.video.aspects.Photo;

public aspect VideoBinder extends Photo{

	public pointcut handleCommand( Command c , String recordName , String musicName ):
		execution( public boolean VideoStub.postCommand( Command , String , String ))
		&& args( c , recordName , musicName );

	public pointcut addCommand( String command , int type , int posi ):
		execution( public Command VideoStub.addCommand( String , int , int ))
		&& args( command , type , posi );
	
}
