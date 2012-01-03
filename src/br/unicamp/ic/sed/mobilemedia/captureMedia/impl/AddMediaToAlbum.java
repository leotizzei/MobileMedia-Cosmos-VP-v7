package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

class AddMediaToAlbum extends Form {
	
	TextField mediaNametxt = new TextField("Media label", "", 15, TextField.ANY);
	TextField albumNametxt = new TextField("Album name", "", 20, TextField.ANY);
	TextField itemtype = new TextField("Type of media", "", 20, TextField.ANY);
	
	Command ok;
	Command cancel;

	protected AddMediaToAlbum(String title) {
		super(title);
		this.append(mediaNametxt);
		this.append(albumNametxt);
		this.append(itemtype);
		ok = new Command("Save Item", Command.SCREEN, 0);
		cancel = new Command("Back", Command.EXIT, 1);
		this.addCommand(ok);
		this.addCommand(cancel);
	}
	
	protected String getMediaName(){
		return mediaNametxt.getString();
	}
	
	protected String getAlbumName(){
		return albumNametxt.getString();
	}
	
	protected String getTypeOfMedia(){
		return itemtype.getString();
	}
}
