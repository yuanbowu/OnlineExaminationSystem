package com.oes.entity;

import java.sql.Timestamp;

public class ExamWithTest {
	
	private int Eid;
	private String Name;
	private String Password;
	private int TestId;
	private Timestamp StartTime;
	private Timestamp EndTime;
	private int Owner;
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getTestId() {
		return TestId;
	}
	public void setTestId(int testId) {
		TestId = testId;
	}
	public Timestamp getStartTime() {
		return StartTime;
	}
	public void setStartTime(Timestamp startTime) {
		StartTime = startTime;
	}
	public int getOwner() {
		return Owner;
	}
	public void setOwner(int owner) {
		Owner = owner;
	}

	
	public Timestamp getEndTime() {
		return EndTime;
	}
	public void setEndTime(Timestamp endTime) {
		EndTime = endTime;
	}
	public ExamWithTest(int eid, String name, String password, int testId, Timestamp startTime, Timestamp endTime,
			int owner) {
		super();
		Eid = eid;
		Name = name;
		Password = password;
		TestId = testId;
		StartTime = startTime;
		EndTime = endTime;
		Owner = owner;
	}
	public ExamWithTest() {
		
	}
}
