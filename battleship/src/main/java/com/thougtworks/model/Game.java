package com.thougtworks.model;

import com.thougtworks.exception.GameException;

public class Game {

	private Player playerA;
	private Player playerB;

	public Game(Player playerA, Player playerB) {
		this.playerA = playerA;
		this.playerB = playerB;
	}

	public void start() throws GameException {
		boolean pa = true;
		x: while (playerA.hasMissile() || playerB.hasMissile()) {
			Player source = (pa) ? playerA : playerB;
			Player target = (!pa) ? playerA : playerB;
			if (!source.hasMissile()) {
				System.out.printf("%s has no more missiles left to launch%n", source.getName());
				pa = !pa;
				continue x;
			}
			while (source.hasMissile()) {
				Missile missile = source.nextMissile();
				boolean hit = target.fireMissile(source, missile);
				if (!target.hasLife()) {
					System.out.printf("%s won the battle%n", source.getName());
					return;
				}
				if (!hit) {
					pa = !pa;
					break;
				}
			}
		}
	}

}
