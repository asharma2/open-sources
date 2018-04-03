package com.grade.calculator.main;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.grade.calculator.template.StudentGradeTemplate;

public class SolutionTest {

	@Test
	public void solution() throws Exception {
		URL url = SolutionTest.class.getClassLoader().getResource("student_grade.txt");
		String path = url.getPath();
		Path p = Paths.get(path);
		StudentGradeTemplate gradeTemplate = new StudentGradeTemplate(p);
		gradeTemplate.calculateGrade();
	}
}
