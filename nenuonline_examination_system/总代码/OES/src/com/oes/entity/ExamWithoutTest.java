package com.oes.entity;

import java.sql.Timestamp;

public class ExamWithoutTest {
	private int eid;
	private String name;
	private String password;
	private Timestamp startTime;
	private Timestamp endTime;
	private int owner;
	public ExamWithoutTest(String name, String password, Timestamp startTime, Timestamp endTime, int owner) {
		super();
		this.name = name;
		this.password = password;
		this.startTime = startTime;
		this.endTime = endTime;
		this.owner = owner;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public ExamWithoutTest() {
		super();
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public ExamWithoutTest(int eid, String name, String password, Timestamp startTime, Timestamp endTime, int owner) {
		super();
		this.eid = eid;
		this.name = name;
		this.password = password;
		this.startTime = startTime;
		this.endTime = endTime;
		this.owner = owner;
	}
	
}
