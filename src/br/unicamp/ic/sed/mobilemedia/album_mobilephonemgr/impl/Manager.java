package br.unicamp.ic.sed.mobilemedia.album_mobilephonemgr.impl;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;



class Manager implements IManager{

	private Hashtable requiredInterfaces = new Hashtable();
	private Hashtable providedInterfaces = new Hashtable();
	


	public Manager() {
	
		providedInterfaces.put("IAlbum", new IAlbumAdapter());
		providedInterfaces.put("IMobilePhone", new IMobilePhoneAdapter());
	}
	
	public String[] getProvidedInterfaces(){
	        
	   return convertListToArray(providedInterfaces.keys());
	}
	
	public String[] getRequiredInterfaces(){
	
		return convertListToArray(requiredInterfaces.keys());
	}
	
	public Object getProvidedInterface(String name){

	   return this.providedInterfaces.get(name);
	}
	
	public void setRequiredInterface(String name, Object facade){
		
		requiredInterfaces.put(name,facade);
	}
	
	public Object getRequiredInterface(String name){
	   return requiredInterfaces.get(name);
	}
	
	private String[] convertListToArray(Enumeration stringEnum){
		Vector stringVector = new Vector();
		for (Enumeration iter = stringEnum; iter.hasMoreElements();) {
			String element = (String) iter.nextElement();
			stringVector.addElement(element);
		}
		
		String[] stringArray = new String[stringVector.size()];
		for (int i=0; i < stringVector.size(); i++){
			stringArray[i] = (String) stringVector.elementAt(i);
		}
		return stringArray;
	}
}



