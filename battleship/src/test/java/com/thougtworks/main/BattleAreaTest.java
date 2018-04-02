package com.thougtworks.main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.thougtworks.exception.IllegalValueException;
import com.thougtworks.model.BattleArea;

public class BattleAreaTest {

	@Test
	public void ba_5xE() throws Exception {
		BattleArea ba = new BattleArea(5, 'E');
		assertTrue(5 == ba.getHeight());
		assertTrue(5 == ba.getWidth());
	}

	@Test
	public void ba_5xZ() throws Exception {
		BattleArea ba = new BattleArea(5, 'Z');
		assertTrue(26 == ba.getHeight());
		assertTrue(5 == ba.getWidth());
	}

	@Test(expected = IllegalValueException.class)
	public void ba_5xa() throws Exception {
		BattleArea ba = new BattleArea(5, 'a');
		assertTrue(26 == ba.getHeight());
		assertTrue(5 == ba.getWidth());
	}
}
