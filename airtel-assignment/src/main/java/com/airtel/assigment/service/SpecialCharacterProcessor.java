package com.airtel.assigment.service;

import com.airtel.assigment.exception.ProcessException;
import com.airtel.assigment.model.Record;
import com.airtel.assigment.utils.AssignmentUtils;

public class SpecialCharacterProcessor implements Processor<Record> {

	@Override
	public void process(Record record) throws ProcessException {
		if (AssignmentUtils.isRecordNotEmpty(record)) {
			record.setRecord(record.getRecord().replaceAll("[^A-Za-z0-9 \\-]", ""));
		}
	}

}
