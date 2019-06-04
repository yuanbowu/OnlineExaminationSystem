package com.oes.entity;

public class AnswerSCP {
	
	private int SPid;
	private int Uid;
	private String Choice;
	private int Score;
	private int Eid;
	public int getSPid() {
		return SPid;
	}
	public void setSPid(int sPid) {
		SPid = sPid;
	}
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getChoice() {
		return Choice;
	}
	public void setChoice(String choice) {
		Choice = choice;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public AnswerSCP(int sPid, int uid, String choice, int score, int eid) {
		super();
		SPid = sPid;
		Uid = uid;
		Choice = choice;
		Score = score;
		Eid = eid;
	}
	public AnswerSCP() {
		super();
	}
	

	
}
