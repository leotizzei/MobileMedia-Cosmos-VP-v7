package br.unicamp.ic.sed.mobilemedia.mainuimidlet_connector_VP.impl;

import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.captureMedia.spec.req.IMobileResources;

class AdapterResourcesCaptureMedia implements IMobileResources{

	public MIDlet getMainMIDlet() {
		IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.main.IMobileResources iMobileResources = (br.unicamp.ic.sed.mobilemedia.main.IMobileResources)manager.getRequiredInterface("IMobileResources");
		return iMobileResources.getMainMIDlet();
	}	
}