package com.ts.analytics.model;

import java.util.Date;

import com.ts.analytics.constants.Events;

public abstract class Event {

	protected Date recordedTimestamp;

	public Event(Date recordedTimestamp) {
		this.recordedTimestamp = recordedTimestamp;
	}

	public Date getRecordedTimestamp() {
		return recordedTimestamp;
	}

	protected abstract Events events();
}
