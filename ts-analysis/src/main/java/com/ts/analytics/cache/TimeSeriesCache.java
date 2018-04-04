package com.ts.analytics.cache;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ts.analytics.model.Event;

public class TimeSeriesCache implements Cache {

	String DATE_FORMAT = "yyyy-MM-dd-HH-mm-ss";

	// year month day hour minute seconds
	private Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>>>> tsData = new TreeMap<>();

	@Override
	public void put(Event event) {
		Date record = event.getRecordedTimestamp();
		LocalDate localDate = record.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if (!tsData.containsKey(localDate.getYear())) {
			Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>>> yrData = new TreeMap<>();
			tsData.put(localDate.getYear(), yrData);
		}
		Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>>> yrData = tsData
				.get(localDate.getYear());
		if (!yrData.containsKey(localDate.getMonthValue())) {
			Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>> monthData = new TreeMap<>();
			yrData.put(localDate.getMonthValue(), monthData);
		}
		Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>> monthData = yrData
				.get(localDate.getMonthValue());
		
	}

}
