package com.airtel.assigment.service;

import static com.airtel.assigment.utils.AssignmentUtils.isRecordNotEmpty;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.airtel.assigment.exception.ProcessException;
import com.airtel.assigment.model.Record;

public class StopProcessor implements Processor<Record> {

	private String[] stopWords = new String[] { "the", "this", "of", "on", "a", "an", "is", "to", "as" };
	private static final String DELIMITER = " ";

	@Override
	public void process(Record record) throws ProcessException {
		Supplier<Stream<String>> supplier = () -> Arrays.stream(stopWords);
		if (isRecordNotEmpty(record)) {
			String[] spaceSeparedWords = record.getRecord().split(DELIMITER);

			StringJoiner sj = new StringJoiner(DELIMITER);
			for (String wrd : spaceSeparedWords) {
				boolean found = supplier.get().anyMatch(wrd::equals);
				if (!found) {
					sj.add(wrd);
				}
			}
			record.setRecord(sj.toString());
		}
	}

}
