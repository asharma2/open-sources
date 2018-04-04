package com.ts.analytics.model;

import java.util.Date;

import com.ts.analytics.constants.Events;

public class Weather extends Event {

	protected String countryCode;
	private Double temperature;

	public Weather(Date recordedTimestamp, String countryCode, Double temperature) {
		super(recordedTimestamp);
		this.countryCode = countryCode;
		this.temperature = temperature;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public Double getTemperature() {
		return temperature;
	}

	public Events events() {
		return Events.Weather;
	}

}
