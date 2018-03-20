package com.airtel.assigment.utils;

import com.airtel.assigment.model.Record;

public final class AssignmentUtils {

	private AssignmentUtils() {
	}

	public static final boolean isEmpty(String txt) {
		return txt == null || txt.isEmpty();
	}

	public static final boolean isNotEmpty(String txt) {
		return !isEmpty(txt);
	}

	public static final boolean isRecordNotEmpty(Record record) {
		return record != null && !isEmpty(record.getRecord());
	}
	
}
