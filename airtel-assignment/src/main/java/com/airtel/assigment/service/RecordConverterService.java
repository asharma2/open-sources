package com.airtel.assigment.service;

import java.nio.file.Files;
import java.nio.file.Path;

import com.airtel.assigment.exception.ApplicationException;
import com.airtel.assigment.model.Record;

public class RecordConverterService implements ConverterService<Path, Record> {

	@Override
	public Record convert(Path path) throws ApplicationException {
		try {
			return new Record(Files.readAllBytes(path));
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

}
