package com.thougtworks.main;

import org.junit.Test;

import com.thougtworks.constants.ShipType;
import com.thougtworks.model.BattleArea;
import com.thougtworks.model.Coordinate;
import com.thougtworks.model.Game;
import com.thougtworks.model.Missile;
import com.thougtworks.model.Player;
import com.thougtworks.model.Ship;

public class SolutionTest {

	@Test
	public void solution() throws Exception {
		BattleArea ba1 = new BattleArea(5, 'E');
		BattleArea ba2 = new BattleArea(5, 'E');

		Player p1 = new Player("Player#1", ba1);
		Player p2 = new Player("Player#2", ba2);

		p1.addShip(new Ship(ShipType.Q, 1, 1, new Coordinate("A1")));
		p2.addShip(new Ship(ShipType.Q, 1, 1, new Coordinate("B2")));

		p1.addShip(new Ship(ShipType.P, 2, 1, new Coordinate("D4")));
		p2.addShip(new Ship(ShipType.P, 2, 1, new Coordinate("C3")));

//		ba1.displayBattleArea();
//		ba2.displayBattleArea();

		p1.addMissile(new Missile(new Coordinate("A1")));
		p1.addMissile(new Missile(new Coordinate("B2")));
		p1.addMissile(new Missile(new Coordinate("B2")));
		p1.addMissile(new Missile(new Coordinate("B3")));

		p2.addMissile(new Missile(new Coordinate("A1")));
		p2.addMissile(new Missile(new Coordinate("B2")));
		p2.addMissile(new Missile(new Coordinate("B3")));
		p2.addMissile(new Missile(new Coordinate("A1")));
		p2.addMissile(new Missile(new Coordinate("D1")));
		p2.addMissile(new Missile(new Coordinate("E1")));
		p2.addMissile(new Missile(new Coordinate("D4")));
		p2.addMissile(new Missile(new Coordinate("D4")));
		p2.addMissile(new Missile(new Coordinate("D5")));
		p2.addMissile(new Missile(new Coordinate("D5")));

		Game game = new Game(p1, p2);
		game.start();
	}
}
