package com.grade.calculator.reader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import com.grade.calculator.converter.StudentGradeConverter;
import com.grade.calculator.exception.ConverterException;
import com.grade.calculator.exception.ReaderException;
import com.grade.calculator.model.StudentGrade;

public class StudentGradeReader implements Reader<StudentGrade> {

	private StudentGradeConverter studentGradeConverter;

	public StudentGradeReader(StudentGradeConverter studentGradeConverter) {
		this.studentGradeConverter = studentGradeConverter;
	}

	@Override
	public List<StudentGrade> read(Path path) throws ReaderException {
		List<StudentGrade> studentGrades = new LinkedList<>();
		try {
			Stream<String> lines = Files.readAllLines(path).stream().skip(1);
			lines.forEach(l -> {
				try {
					studentGrades.add(studentGradeConverter.convert(l));
				} catch (ConverterException e) {
					System.err.println(e);
				}
			});
		} catch (Exception e) {
		}
		return studentGrades;
	}

	@Override
	public List<StudentGrade> read(File file) throws ReaderException {
		return read(file.toPath());
	}

}
