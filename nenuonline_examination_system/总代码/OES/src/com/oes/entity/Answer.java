package com.oes.entity;

public class Answer {
	
	private int Aid;
	private int Owner;
	private int Score;
	private int Exam;
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public int getOwner() {
		return Owner;
	}
	public void setOwner(int owner) {
		Owner = owner;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public int getExam() {
		return Exam;
	}
	public void setExam(int exam) {
		Exam = exam;
	}
	public Answer(int aid, int owner, int score, int exam) {
		super();
		Aid = aid;
		Owner = owner;
		Score = score;
		Exam = exam;
	}
	
	public Answer() {
		
	}
	
}
