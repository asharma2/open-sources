package com.thougtworks.model;

import com.thougtworks.constants.ShipType;

public class Ship {

	protected ShipType shipType;
	protected Integer width;
	protected Integer height;
	protected Coordinate coordinate;
	private int life;

	public Ship(ShipType shipType, Integer width, Integer height, Coordinate coordinate) {
		this.shipType = shipType;
		this.width = width;
		this.height = height;
		this.coordinate = coordinate;
		setLife(shipType == ShipType.P ? 2 : 1);
	}

	public ShipType getShipType() {
		return shipType;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getLife() {
		return this.life;
	}

	public void removeLife() {
		this.life = (this.life == 0) ? 0 : --this.life;
	}

	@Override
	public String toString() {
		return "Ship [shipType=" + shipType + ", life=" + life + "]";
	}

}
