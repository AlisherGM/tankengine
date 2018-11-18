package com.testenv.models;

/**
 * 18.11.18
 *
 * @author Dinar Rafikov
 * @version 1.0
 */
public class Coordinate {
	private double x;
	private double y;

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Coordinate setX(double x) {
		this.x = x;
		return this;
	}

	public Coordinate setY(double y) {
		this.y = y;
		return this;
	}
}
