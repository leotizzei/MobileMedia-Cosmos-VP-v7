package br.unicamp.ic.sed.mobilemedia.sms.aspects;

import br.unicamp.ic.sed.mobilemedia.sms.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.main.spec.dt.IImageData;
import br.unicamp.ic.sed.mobilemedia.sms.spec.excep.NullAlbumDataReference;

public aspect XPISenderController {
	
	public pointcut getImageInfoToSend(): call(public IImageData IFilesystem.getImageInfo(String));
	
	declare soft : ImageNotFoundException : getImageInfoToSend();
	declare soft : NullAlbumDataReference : getImageInfoToSend();

}
