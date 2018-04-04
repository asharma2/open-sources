package com.ts.analytics.cache;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.ts.analytics.model.Event;
import com.ts.analytics.model.Weather;
import com.ts.analytics.sd.StandardDeviaton;

public class TimeSeriesCache implements Cache {

	// year month day hour minute seconds
	private Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>>>> tsData = new TreeMap<>();

	@Override
	public void put(Event event) {
		Date record = event.getRecordedTimestamp();
		LocalDateTime localDate = LocalDateTime.ofInstant(record.toInstant(), ZoneId.systemDefault());
		int years = localDate.getYear();
		if (!tsData.containsKey(years)) {
			Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>>> yrData = new TreeMap<>();
			tsData.put(years, yrData);
		}
		Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>>> yrData = tsData.get(years);
		int months = localDate.getMonthValue();
		if (!yrData.containsKey(months)) {
			Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>> monthData = new TreeMap<>();
			yrData.put(months, monthData);
		}
		Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<Event>>>>> monthData = yrData.get(months);
		int days = localDate.getDayOfMonth();
		if (!monthData.containsKey(days)) {
			Map<Integer, Map<Integer, Map<Integer, List<Event>>>> dayData = new TreeMap<>();
			monthData.put(days, dayData);
		}
		Map<Integer, Map<Integer, Map<Integer, List<Event>>>> dayData = monthData.get(days);
		int hours = localDate.getHour();
		if (!dayData.containsKey(hours)) {
			Map<Integer, Map<Integer, List<Event>>> hourData = new TreeMap<>();
			dayData.put(hours, hourData);
		}
		Map<Integer, Map<Integer, List<Event>>> hourData = dayData.get(hours);
		int minutes = localDate.getMinute();
		if (!hourData.containsKey(minutes)) {
			Map<Integer, List<Event>> minuteData = new TreeMap<>();
			hourData.put(minutes, minuteData);
		}
		Map<Integer, List<Event>> minuteData = hourData.get(minutes);
		int seconds = localDate.getSecond();
		if (!minuteData.containsKey(seconds)) {
			minuteData.put(seconds, new LinkedList<Event>());
		}
		// System.out.println(years + " => " + months + " => " + days + " => " + hours +
		// " => " + minutes + " => "
		// + seconds + " => " + event);
		List<Event> events = minuteData.get(seconds);
		events.add(event);
	}

	@Override
	public void calculateDeviations() {
		StandardDeviaton sd = new StandardDeviaton();
		List<Number> yearly = new LinkedList<>();
		List<Number> monthly = new LinkedList<>();
		List<Number> daily = new LinkedList<>();
		List<Number> hourly = new LinkedList<>();
		List<Number> minutely = new LinkedList<>();
		tsData.forEach((y, m) -> {
			yearly.clear();
			m.forEach((m1, d) -> {
				monthly.clear();
				d.forEach((d1, h) -> {
					daily.clear();
					h.forEach((h1, mi) -> {
						hourly.clear();
						mi.forEach((mi1, s) -> {
							minutely.clear();
							s.forEach((s1, e) -> {
								List<Number> secVariation = e.stream().map(w -> ((Weather) w).getTemperature())
										.collect(Collectors.toList());
								yearly.addAll(secVariation);
								monthly.addAll(secVariation);
								daily.addAll(secVariation);
								hourly.addAll(secVariation);
								minutely.addAll(secVariation);
								// Number secondsDeviation = sd.standardDeviation(secVariation);
								// System.out.println(y + " => " + m1 + " => " + d1 + " => " + h1 + " => " + mi1
								// + " => "
								// + si + " => " + secondsDeviation);
								// System.out.println("Secondly: " + s1 + " => " + secondsDeviation);
							});
							System.out.println("Minutely: " + mi1 + " => " + sd.standardDeviation(minutely));
						});
						System.out.println("Hourly: " + h1 + " => " + sd.standardDeviation(hourly));
					});
					System.out.println("Daily: " + d1 + " => " + sd.standardDeviation(daily));
				});
				System.out.println("Monthly: " + m1 + " => " + sd.standardDeviation(monthly));
			});
			System.out.println("Yearly: " + y + " => " + sd.standardDeviation(yearly));
		});

	}

}
