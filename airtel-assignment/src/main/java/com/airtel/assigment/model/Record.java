package com.airtel.assigment.model;

import java.nio.charset.StandardCharsets;

public class Record {

	private String record;

	public Record() {
	}

	public Record(String record) {
		this.record = record;
	}

	public Record(byte[] bytes) {
		this.record = new String(bytes, StandardCharsets.UTF_8);
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String[] words() {
		return (record != null) ? record.split(" ") : null;
	}

}
