package com.grade.calculator;

import java.nio.file.Paths;

import com.grade.calculator.template.StudentGradeTemplate;

public class Solution {

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Run using filepath: <filepath>");
		}
		String path = args[0];
		StudentGradeTemplate sgt = new StudentGradeTemplate(Paths.get(path));
		sgt.calculateGrade();
	}
}
