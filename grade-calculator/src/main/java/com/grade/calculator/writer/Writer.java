package com.grade.calculator.writer;

import java.util.Collection;

import com.grade.calculator.exception.WriterException;

public interface Writer<T> {

	void writer(Collection<T> items) throws WriterException;
}
