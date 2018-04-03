package com.grade.calculator.model;

public class StudentGrade {

	private String name;
	private String hw1;
	private String hw2;
	private String hw3;
	private String midterm;
	private String project;
	private String terminal;
	private Double finalGrade;
	private Character letterGrade;

	public StudentGrade() {
	}

	public StudentGrade(String name, String hw1, String hw2, String hw3, String midterm, String project,
			String terminal) {
		this.name = name;
		this.hw1 = hw1;
		this.hw2 = hw2;
		this.hw3 = hw3;
		this.midterm = midterm;
		this.project = project;
		this.terminal = terminal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHw1() {
		return hw1;
	}

	public void setHw1(String hw1) {
		this.hw1 = hw1;
	}

	public String getHw2() {
		return hw2;
	}

	public void setHw2(String hw2) {
		this.hw2 = hw2;
	}

	public String getHw3() {
		return hw3;
	}

	public void setHw3(String hw3) {
		this.hw3 = hw3;
	}

	public String getMidterm() {
		return midterm;
	}

	public void setMidterm(String midterm) {
		this.midterm = midterm;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public Double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(Double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public Character getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(Character letterGrade) {
		this.letterGrade = letterGrade;
	}

}
