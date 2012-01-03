package br.unicamp.ic.sed.mobilemedia.photo.impl;

import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.photo.spec.excep.PersistenceMechanismException;

public interface IPhotoControllerDHandler {

	public void setCurrentStoreName( String currentStoreName );
	public void setController( AbstractController controller );
	public void showImage(String name ) throws ImageNotFoundException, PersistenceMechanismException ;
	
}
