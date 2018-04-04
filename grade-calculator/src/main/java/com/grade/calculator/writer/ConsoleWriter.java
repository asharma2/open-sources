package com.grade.calculator.writer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.grade.calculator.exception.WriterException;
import com.grade.calculator.model.StudentGrade;

public class ConsoleWriter implements Writer<StudentGrade> {

	private Map<Character, Integer> gradeCounts = new HashMap<>();

	@Override
	public void writer(Collection<StudentGrade> items) throws WriterException {
		items.forEach(i -> {
			System.out.println(String.format("Student: %s, FinalGrade: %.2f , Grade: %s", i.getName(),
					i.getFinalGrade(), i.getLetterGrade()));
			if (!gradeCounts.containsKey(i.getLetterGrade())) {
				gradeCounts.put(i.getLetterGrade(), 1);
			} else {
				gradeCounts.put(i.getLetterGrade(), gradeCounts.get(i.getLetterGrade()) + 1);
			}
		});
		gradeCounts.forEach((k, v) -> {
			System.out.println("Grade: " + k + ", Count: " + v);
		});
	}

}
