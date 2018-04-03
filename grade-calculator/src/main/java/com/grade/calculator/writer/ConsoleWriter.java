package com.grade.calculator.writer;

import java.util.Collection;

import com.grade.calculator.exception.WriterException;
import com.grade.calculator.model.StudentGrade;

public class ConsoleWriter implements Writer<StudentGrade> {

	@Override
	public void writer(Collection<StudentGrade> items) throws WriterException {
		items.forEach(i -> {
			System.out.println(String.format("Student: %s, FinalGrade: %.2f , Grade: %s", i.getName(), i.getFinalGrade(),
					i.getLetterGrade()));
		});
	}

}
