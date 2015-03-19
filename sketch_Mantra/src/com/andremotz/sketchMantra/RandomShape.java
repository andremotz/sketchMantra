package com.andremotz.sketchMantra;

import java.util.ArrayList;
import java.util.Random;

/*
 * Klasse beinhaltet Steuerdaten von einem Random Shape
 */
public class RandomShape{

	ArrayList<Vertice> vertices;
	Random rand;
	
	private float getNextRandomFloat(float max) {
		float n = rand.nextFloat()* max;
		return n;
	}
	
	RandomShape(float size) {
		
		rand = new Random();
		vertices = new ArrayList<Vertice>();
		Vertice vertice;
		
		for (int i=0; i < getNextRandomFloat(4)+3; i++) {
			vertice = new Vertice();
			vertice.setX(getNextRandomFloat(size)*500);
			vertice.setY(getNextRandomFloat(size)*500);
			vertices.add(vertice);
			
		}
	}

	/**
	 * @return the vertices
	 */
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

}
