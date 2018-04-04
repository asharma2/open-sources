package com.ts.analytics.sd;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StandardDeviatonTest {

	@Test
	public void sd() throws Exception {
		List<Number> numbers = Arrays.asList(2, 4, 4, 4, 5, 5, 7, 9);
		StandardDeviaton sd = new StandardDeviaton();
		Number d = sd.standardDeviation(numbers);
		System.out.println(d.doubleValue());
	}
}
