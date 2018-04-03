package com.grade.calculator.template;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import com.grade.calculator.converter.StudentGradeConverter;
import com.grade.calculator.exception.ProcessorException;
import com.grade.calculator.exception.StudentGradeException;
import com.grade.calculator.model.StudentGrade;
import com.grade.calculator.processor.Processor;
import com.grade.calculator.processor.StudentGradeProcessor;
import com.grade.calculator.reader.StudentGradeReader;
import com.grade.calculator.writer.ConsoleWriter;
import com.grade.calculator.writer.Writer;

public final class StudentGradeTemplate {

	protected Path path;

	public StudentGradeTemplate(Path path) {
		this.path = path;
	}

	public StudentGradeTemplate(File file) {
		this.path = file.toPath();
	}

	public final void calculateGrade() throws StudentGradeException {
		try {
			StudentGradeConverter studentGradeConverter = new StudentGradeConverter(",");
			StudentGradeReader studentGradeReader = new StudentGradeReader(studentGradeConverter);
			List<StudentGrade> studentGrades = studentGradeReader.read(path);
			List<Processor<StudentGrade>> processors = new LinkedList<>();
			processors.add(new StudentGradeProcessor());
			studentGrades.forEach(s -> {
				processors.forEach(p -> {
					try {
						p.process(s);
					} catch (ProcessorException e) {
						System.err.println(e);
					}
				});
			});
			Writer<StudentGrade> writer = new ConsoleWriter();
			writer.writer(studentGrades);
		} catch (Exception e) {
			throw new StudentGradeException(e);
		}
	}
}
