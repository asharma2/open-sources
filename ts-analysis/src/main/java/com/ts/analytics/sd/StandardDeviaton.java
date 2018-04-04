package com.ts.analytics.sd;

import java.util.List;
import java.util.OptionalDouble;

public class StandardDeviaton {

	public Number average(List<Number> numbers) {
		OptionalDouble od = numbers.stream().mapToDouble(n -> n.doubleValue()).average();
		return od.isPresent() ? od.getAsDouble() : 0;
	}

	public Number variance(List<Number> numbers, Number average) {
		OptionalDouble od = numbers.stream().mapToDouble(n -> Math.pow((n.doubleValue() - average.doubleValue()), 2))
				.average();
		return od.isPresent() ? od.getAsDouble() : 0;
	}

	public Number standardDeviation(List<Number> numbers) {
		Number average = average(numbers);
		Number variance = variance(numbers, average);
		return Math.sqrt(variance.doubleValue());
	}
}
