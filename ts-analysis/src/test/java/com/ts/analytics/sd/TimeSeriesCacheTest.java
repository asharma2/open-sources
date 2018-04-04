package com.ts.analytics.sd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ts.analytics.cache.Cache;
import com.ts.analytics.cache.TimeSeriesCache;
import com.ts.analytics.model.Event;
import com.ts.analytics.model.Weather;

public class TimeSeriesCacheTest {

	@Test
	public void checkEvents() throws Exception {
		Cache ts = new TimeSeriesCache();
		_09Nov86(ts);
		_09Nov87(ts);
		_09Nov88(ts);
		// _09Nov89(ts);
		// _09Nov90(ts);
		ts.calculateDeviations();
	}

	private void _09Nov90(Cache ts) throws Exception {
		Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("09-11-1990 10:11:00");
		prepareTsData(ts, dt);
	}

	private void _09Nov89(Cache ts) throws Exception {
		Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("09-11-1989 10:11:00");
		prepareTsData(ts, dt);
	}

	private void _09Nov88(Cache ts) throws Exception {
		Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("09-11-1988 10:11:00");
		prepareTsData(ts, dt);
	}

	private void _09Nov87(Cache ts) throws Exception {
		Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("09-11-1987 10:11:00");
		prepareTsData(ts, dt);
	}

	private void _09Nov86(Cache ts) throws ParseException {
		Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("09-11-1986 10:11:00");
		prepareTsData(ts, dt);
	}

	private void prepareTsData(Cache ts, Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		for (int i = 0; i < 360; i++) {
			cal.add(Calendar.SECOND, 1);
			Event e = new Weather(cal.getTime(), "IN", Math.random() * 49 + 1);
			Event e1 = new Weather(cal.getTime(), "IN", Math.random() * 49 + 1);
			Event e2 = new Weather(cal.getTime(), "IN", Math.random() * 49 + 1);
			ts.put(e);
			ts.put(e1);
			ts.put(e2);
		}
	}
}
