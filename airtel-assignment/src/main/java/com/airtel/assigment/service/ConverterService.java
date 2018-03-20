package com.airtel.assigment.service;

import com.airtel.assigment.exception.ApplicationException;

public interface ConverterService<T, R> {

	R convert(T entity) throws ApplicationException;
}
