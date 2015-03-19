package com.andremotz.sketchMantra;

/*
 * Klasse beinhaltet "Stress"-Status
 */
public class StatusObject {
	
	StatusObject() {
		this.globalStress = 0f;
		this.globalRotation = 0f;
	}
	
	private float globalRotation;
	private float globalStress;

	/**
	 * @return the globalStress
	 */
	public float getGlobalStress() {
		return globalStress;
	}

	/**
	 * @param globalStress the globalStress to set
	 */
	public void setGlobalStress(float globalStress) {
		this.globalStress = globalStress;
	}

	/**
	 * @return the globalRotation
	 */
	public float getGlobalRotation() {
		return globalRotation;
	}

	/**
	 * @param globalRotation the globalRotation to set
	 */
	public void setGlobalRotation(float globalRotation) {
		this.globalRotation = globalRotation;
	}

	public void rotateGlobal(float input) {

		this.globalRotation = this.globalRotation + input;
	}
	

}
