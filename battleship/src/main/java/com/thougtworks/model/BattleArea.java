package com.thougtworks.model;

import com.thougtworks.exception.IllegalValueException;

public class BattleArea implements GameAttribute {

	private Character height;
	private Integer width;
	private Ship[][] areaMatrix;

	public BattleArea(Integer width, Character height) {
		this.height = height;
		this.width = width;
		validate();
		this.areaMatrix = new Ship[getWidth()][getHeight()];
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height - 64;
	}

	public void addShip(Ship ship) {
		int w = ship.getHeight() + ship.getCoordinate().getX();
		int h = ship.getWidth() + ship.getCoordinate().getY();
		for (int i = ship.getCoordinate().getX(); i < w; i++) {
			for (int j = ship.getCoordinate().getY(); j < h; j++) {
				areaMatrix[i][j] = ship;
			}
		}
	}

	public boolean fireMissile(Player player, Missile missile) {
		int w = missile.getCoordinate().getX();
		int h = missile.getCoordinate().getY();
		Ship ship = areaMatrix[w][h];
		if (ship != null) {
			ship.removeLife();
			System.out.printf("%s fires a missile with target %s which got hit%n", player.getName(),
					missile.getCoordinate().getCoord());
			return true;
		}
		System.out.printf("%s fires a missile with target %s which got miss%n", player.getName(),
				missile.getCoordinate().getCoord());
		return false;
	}

	public boolean hasLife() {
		for (int i = 0; i < areaMatrix.length; i++) {
			for (int j = 0; j < areaMatrix[i].length; j++) {
				if (areaMatrix[i][j] != null) {
					if (areaMatrix[i][j].getLife() > 0)
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public void validate() throws IllegalValueException {
		if (height < 'A' || height > 'Z') {
			throw new IllegalValueException("Battlearea height should be between A-Z");
		}
		if (width < 1 || width > 9) {
			throw new IllegalValueException("Battlearea width should be between 1-9");
		}
	}

	@Override
	public String toString() {
		return "BattleArea [height=" + height + ", width=" + width + "]";
	}

	public void displayBattleArea() {
		System.out.println("############################################");
		for (int i = 0; i < areaMatrix.length; i++) {
			for (int j = 0; j < areaMatrix[i].length; j++) {
				if (areaMatrix[i][j] == null) {
					System.out.print("-");
				} else {
					System.out.print(areaMatrix[i][j].getShipType().name());
				}
			}
			System.out.println();
		}
		System.out.println("############################################");
	}

}
