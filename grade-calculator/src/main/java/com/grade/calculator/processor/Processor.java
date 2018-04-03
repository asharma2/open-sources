package com.grade.calculator.processor;

import com.grade.calculator.exception.ProcessorException;

public interface Processor<T> {

	void process(T item) throws ProcessorException;
}
