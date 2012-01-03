package br.unicamp.ic.sed.mobilemedia.video.impl;

import java.io.InputStream;

import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.video.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.video.spec.prov.IVideo;
import br.unicamp.ic.sed.mobilemedia.video.spec.req.IFilesystemVideo;
import br.unicamp.ic.sed.mobilemedia.video.spec.req.IMobileResources;

class IVideoFacade implements IVideo {

	private PlayVideoController playVideoController;
	private MIDlet midlet;
	private IManager manager = ComponentFactory.createInstance();
	
	IVideoFacade() { }
	
	private PlayVideoController getPlayVideoController(String albumName, String videoName){
		System.out.println("[IVideoFacade:getPlayVideoController]AlbumName: " + albumName + " : VideoName:  "+ videoName );
	
		this.midlet = this.getMidlet();
		//get video inputstream
		IFilesystemVideo filesystem = (IFilesystemVideo) this.manager.getRequiredInterface("IFilesystemVideo");
		
		InputStream videoStream = null;
		
		videoStream = filesystem.getVideoFromRecordStore( albumName , videoName );	
		
		System.out.println("AlbumNameFACADE: " +  albumName );
		
		IImageData mediaData = null;
		
		mediaData = filesystem.getMediaInfo(videoName);
		
		String fileExtension = mediaData.getType();
				
		//create video controller
		PlayVideoScreen playVideoScreen = new PlayVideoScreen(midlet,videoStream,"video/"+fileExtension);
		this.playVideoController = new PlayVideoController(midlet,playVideoScreen);		
		playVideoScreen.setController( this.playVideoController );
		
		this.playVideoController.setCurrentStoreName( albumName );
		
		playVideoScreen.setVisibleVideo( this.getMidlet() );
	
		return playVideoController;
	}

	private MIDlet getMidlet() {
		System.out.println("[IVideoFacade:getMidlet]");
		if( this.midlet == null){
			IMobileResources mobileResources = (IMobileResources) manager.getRequiredInterface("IMobileResources");
			this.midlet = mobileResources.getMainMIDlet();
		}
		return midlet;
	}

	public boolean playVideo(String albumName, String videoName){
		this.playVideoController = this.getPlayVideoController( albumName , videoName );
		this.playVideoController.setMediaName(videoName);
		return true;
	}

}
