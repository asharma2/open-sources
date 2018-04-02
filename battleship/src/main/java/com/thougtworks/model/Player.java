package com.thougtworks.model;

import java.util.LinkedList;
import java.util.Queue;

import com.thougtworks.exception.IllegalValueException;

public class Player implements GameAttribute {

	protected final String name;
	private BattleArea battleArea;
	private Queue<Missile> missiles = new LinkedList<>();

	public Player(String name, BattleArea battleArea) {
		this.name = name;
		this.battleArea = battleArea;
	}

	@Override
	public void validate() throws IllegalValueException {

	}

	public boolean fireMissile(Player player, Missile missile) {
		return battleArea.fireMissile(player, missile);
	}

	public void addShip(Ship ship) {
		battleArea.addShip(ship);
	}

	public void addMissile(Missile missile) {
		missiles.add(missile);
	}

	public String getName() {
		return name;
	}

	public boolean hasMissile() {
		return !missiles.isEmpty();
	}

	public Missile nextMissile() {
		return missiles.poll();
	}

	public boolean hasLife() {
		return battleArea.hasLife();
	}

}
