package com.airtel.assignment.processor;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.airtel.assigment.model.Record;
import com.airtel.assigment.service.LowerCaseProcessor;
import com.airtel.assigment.service.Processor;
import com.airtel.assigment.service.SpecialCharacterProcessor;
import com.airtel.assigment.service.StopProcessor;

public class ProcessorTest {

	@Test
	public void validateProcessor() throws Exception {
		String record = "this is same as T@he";
		List<Processor<Record>> processors = new LinkedList<>();
		processors.add(new LowerCaseProcessor());
		processors.add(new SpecialCharacterProcessor());
		processors.add(new StopProcessor());
		Record rec = new Record(record);
		for (Processor<Record> processor : processors) {
			processor.process(rec);
		}
		System.out.println(rec.getRecord());
	}
}
