package com.grade.calculator.converter;

import com.grade.calculator.exception.ConverterException;
import com.grade.calculator.model.StudentGrade;

public class StudentGradeConverter implements Converter<String, StudentGrade> {

	private String delimiter;

	public StudentGradeConverter(String delimiter) {
		this.delimiter = delimiter;
	}

	@Override
	public StudentGrade convert(String line) throws ConverterException {
		if (line != null) {
			String[] columns = line.split(delimiter);
			if (columns.length == 7) {
				return new StudentGrade(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5],
						columns[6]);
			}
		}
		throw new ConverterException("Unable to parse and convert the line: " + line);
	}

}
