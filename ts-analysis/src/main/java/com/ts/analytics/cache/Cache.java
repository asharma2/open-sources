package com.ts.analytics.cache;

import com.ts.analytics.model.Event;

/**
 * Forecast =>
 * https://docs.oracle.com/cd/E26228_01/doc.93/e20706/ap_forcst_calc_ex.htm#WEAFC317
 * 
 * @author root
 *
 */
public interface Cache {

	enum Deviation {
		SECONDS, MINUTES, HOURS, DAYS, MONTHS, YEARS
	}

	void put(Event event);

	void calculateDeviations();
}
