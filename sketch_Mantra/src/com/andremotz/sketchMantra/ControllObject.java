package com.andremotz.sketchMantra;

/*
 * Klasse hält Controller-Daten von Keyboard und Co
 */
public class ControllObject {
	
	int currentNumberKey;
	
	ControllObject() {
		this.currentNumberKey = 1;
		
	}

	/**
	 * @return the currentNumberKey
	 */
	public int getCurrentNumberKey() {
		return currentNumberKey;
	}

	/**
	 * @param currentNumberKey the currentNumberKey to set
	 */
	public void setCurrentNumberKey(int currentNumberKey) {
		this.currentNumberKey = currentNumberKey;
	}
}
