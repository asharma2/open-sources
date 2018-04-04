package com.ts.analytics.cache;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
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
		LocalDateTime localDate = LocalDateTime.ofInstant(record.toInstant(), ZoneId.systemDefault());
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
		if (!monthData.containsKey(localDate.getDayOfMonth())) {
			Map<Integer, Map<Integer, Map<Integer, List<Event>>>> dayData = new TreeMap<>();
			monthData.put(localDate.getDayOfMonth(), dayData);
		}
		Map<Integer, Map<Integer, Map<Integer, List<Event>>>> dayData = monthData.get(localDate.getDayOfMonth());
		if (!dayData.containsKey(localDate.getHour())) {
			Map<Integer, Map<Integer, List<Event>>> hourData = new TreeMap<>();
			dayData.put(localDate.getHour(), hourData);
		}
		Map<Integer, Map<Integer, List<Event>>> hourData = dayData.get(localDate.getHour());
		if (!hourData.containsKey(localDate.getMinute())) {
			Map<Integer, List<Event>> minuteData = new TreeMap<>();
			hourData.put(localDate.getMinute(), minuteData);
		}
		Map<Integer, List<Event>> minuteData = hourData.get(localDate.getMinute());
		if (!minuteData.containsKey(localDate.getSecond())) {
			minuteData.put(localDate.getSecond(), new LinkedList<Event>());
		}
		List<Event> events = minuteData.get(localDate.getSecond());
		events.add(event);
	}

}
