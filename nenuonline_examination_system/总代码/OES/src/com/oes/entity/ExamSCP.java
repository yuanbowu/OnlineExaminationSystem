package com.oes.entity;

public class ExamSCP {
	
	private int SPid;
	private int Eid;
	private int EPid;
	private int Score;
	public int getSPid() {
		return SPid;
	}
	public void setSPid(int sPid) {
		SPid = sPid;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public int getEPid() {
		return EPid;
	}
	public void setEPid(int ePid) {
		EPid = ePid;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public ExamSCP(int sPid, int eid, int ePid, int score) {
		super();
		SPid = sPid;
		Eid = eid;
		EPid = ePid;
		Score = score;
	}
	public ExamSCP() {
		
	}
	
}
