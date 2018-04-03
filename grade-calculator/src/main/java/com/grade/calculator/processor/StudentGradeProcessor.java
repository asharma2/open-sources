package com.grade.calculator.processor;

import com.grade.calculator.exception.ProcessorException;
import com.grade.calculator.model.StudentGrade;

public class StudentGradeProcessor implements Processor<StudentGrade> {

	@Override
	public void process(StudentGrade sg) throws ProcessorException {
		Double finalGrade = 0.45
				* ((Double.parseDouble(sg.getHw1()) + Double.parseDouble(sg.getHw2()) + Double.parseDouble(sg.getHw3()))
						/ 3)
				+ 0.25 * Double.parseDouble(sg.getProject())
				+ 0.30 * ((Double.parseDouble(sg.getMidterm()) + Double.parseDouble(sg.getTerminal())) / 2);
		sg.setFinalGrade(finalGrade);
		if (finalGrade >= 90) {
			sg.setLetterGrade('A');
		} else if (finalGrade >= 80) {
			sg.setLetterGrade('B');
		} else if (finalGrade >= 70) {
			sg.setLetterGrade('C');
		} else if (finalGrade >= 60) {
			sg.setLetterGrade('D');
		} else {
			sg.setLetterGrade('F');
		}
	}

}
