package br.unicamp.ic.sed.mobilemedia.captureMedia.impl;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.ICaptureMedia;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IMobileResources;

class ICaptureMediaFacade implements ICaptureMedia{
	
	private IManager manager = ComponentFactory.createInstance();
	private CaptureController controller = null;
	private CaptureScreen screen = null;
	
	public void startCapturing() {
		IMobileResources mobile = (IMobileResources)manager.getRequiredInterface("IMobileResources");
		controller = new CaptureController( mobile.getMainMIDlet() );
		screen = new CaptureScreen( mobile.getMainMIDlet() );
		screen.setCommandListener( controller );
		screen.setVisibleVideo();
	}
}
