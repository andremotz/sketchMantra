package com.andremotz.sketchMantra;

import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;

import processing.core.PApplet;

public class SketchMantra extends PApplet {

	public static void main(String[] args) {
		PApplet.main(new String[] { "--present",
				"com.andremotz.sketchMantra.SketchMantra" });
	}

	Timer timer;
	boolean timerBPMhasFinished;
	float bpm;
	
	ControllObject controllObject;
	StatusObject statusObject;

	ArrayList<RandomShape> shapes;

	/*
	 * Initialize everything
	 */
	public void setup() {
		size(1440, 900);
		bpm = 172f;
		timer = new Timer();
		timerBPMhasFinished = true;
		controllObject = new ControllObject();
		statusObject = new StatusObject();
		generateShape();

	}

	/*
	 * Erzeugt neues Shape
	 */
	private void generateShape() {
		shapes = new ArrayList<RandomShape>();
		shapes.add(new RandomShape(statusObject.getGlobalStress()));
	}

	/*
	 * Processing-Main Loop
	 * (non-Javadoc)
	 * @see processing.core.PApplet#draw()
	 */
	public void draw() {
		if (timerBPMhasFinished) {
			createScheduleTimer(60000 / bpm);
			//generateShape();
		}

		background(0);
		evaluateInput();
		mapControlObjectToStatusObject();

		drawRandomShape();
		


	}

	/*
	 * Mappt Controller-Daten zu abstrakten Status
	 */
	private void mapControlObjectToStatusObject() {
		
		int currentNumberKey = controllObject.getCurrentNumberKey();
		float currentStress = map(currentNumberKey, 0, 9, 0, 1);
		statusObject.setGlobalStress(currentStress);
		
		statusObject.rotateGlobal(currentStress / 32);
		
	}

	/*
	 * Methode reagiert auf jeglichen Controller-Input
	 */
	private void evaluateInput() {
		if (keyPressed) {
			if (key == '1')
				controllObject.setCurrentNumberKey(1);
			if (key == '2')
				controllObject.setCurrentNumberKey(2);
			if (key == '3')
				controllObject.setCurrentNumberKey(3);
			if (key == '4')
				controllObject.setCurrentNumberKey(4);
			if (key == '5')
				controllObject.setCurrentNumberKey(5);
			if (key == '6')
				controllObject.setCurrentNumberKey(6);
			if (key == '7')
				controllObject.setCurrentNumberKey(7);
			if (key == '8')
				controllObject.setCurrentNumberKey(8);
			if (key == '9')
				controllObject.setCurrentNumberKey(9);
			
		}
		
	}
	
	public void keyReleased() {
		generateShape();
	}

	private void createScheduleTimer(float milliSec) {
		timerBPMhasFinished = false;
		timer.schedule(new TimerTask() {
			public void run() {
				timerBPMhasFinished = true;
			}
		}, (long) (milliSec));

	}

	private void drawRandomShape() {
		int steps = 8;
		int stepCounter = 0;
		translate(width / 2, height / 2);
		rotate(statusObject.getGlobalRotation());
		pushMatrix();

		while (stepCounter < steps) {
			rotate(2 * PI / steps);

			for (RandomShape currentShape : shapes) {
				beginShape();
				ArrayList<Vertice> vertices = currentShape.getVertices();
				for (Vertice currentVertice : vertices) {
					float x = currentVertice.getX();
					float y = currentVertice.getY();
					vertex(x, y);
				}
				endShape(CLOSE);
			}
			stepCounter++;
		}
		popMatrix();
	}

}
