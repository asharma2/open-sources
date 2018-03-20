package com.airtel.assigment.service;

import java.io.File;
import java.nio.file.Path;

import com.airtel.assigment.exception.ApplicationException;

public interface CommonWordService {

	String[] retrieve(File file) throws ApplicationException;

	String[] retrieve(Path path) throws ApplicationException;
}
