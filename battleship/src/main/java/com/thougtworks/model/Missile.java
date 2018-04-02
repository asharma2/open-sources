package com.thougtworks.model;

import com.thougtworks.exception.IllegalValueException;

public class Missile implements GameAttribute {

	private Coordinate coordinate;

	public Missile(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public void validate() throws IllegalValueException {

	}

}
