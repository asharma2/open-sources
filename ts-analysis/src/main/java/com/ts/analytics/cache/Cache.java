package com.ts.analytics.cache;

import com.ts.analytics.model.Event;

public interface Cache {

	void put(Event event);
}
