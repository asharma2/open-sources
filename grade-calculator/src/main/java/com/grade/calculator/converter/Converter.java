package com.grade.calculator.converter;

import com.grade.calculator.exception.ConverterException;

public interface Converter<T, R> {

	R convert(T item) throws ConverterException;
}
