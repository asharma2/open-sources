package com.thougtworks.model;

public class Coordinate {

	private String coord;
	protected int x;
	protected int y;

	public Coordinate(String coord) {
		this.coord = coord;
		x = (int) coord.charAt(0);
		y = Integer.parseInt(coord.substring(1));
	}

	public int getX() {
		return x - 65;
	}

	public int getY() {
		return y - 1;
	}

	public String getCoord() {
		return coord;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

}
