package com.grade.calculator.reader;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import com.grade.calculator.exception.ReaderException;

public interface Reader<T> {

	List<T> read(Path path) throws ReaderException;

	List<T> read(File file) throws ReaderException;
}
