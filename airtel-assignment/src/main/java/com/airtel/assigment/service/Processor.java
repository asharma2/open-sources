package com.airtel.assigment.service;

import com.airtel.assigment.exception.ProcessException;

public interface Processor<R> {

	void process(R record) throws ProcessException;

}
