package com.oes.entity;

import java.util.Date;

public class SingleChoiceProblem {
	
	private int sPid;
	private String content;
	private int owner;
	private Date provideTime;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	public int getsPid() {
		return sPid;
	}
	public void setsPid(int sPid) {
		this.sPid = sPid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public Date getProvideTime() {
		return provideTime;
	}
	public void setProvideTime(Date provideTime) {
		this.provideTime = provideTime;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public SingleChoiceProblem(int sPid, String content, int owner, Date provideTime, String optionA, String optionB,
			String optionC, String optionD, String answer) {
		super();
		this.sPid = sPid;
		this.content = content;
		this.owner = owner;
		this.provideTime = provideTime;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
	}
	public SingleChoiceProblem(String content, int owner, Date provideTime, String optionA, String optionB,
			String optionC, String optionD, String answer) {
		super();
		this.content = content;
		this.owner = owner;
		this.provideTime = provideTime;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
	}
	public SingleChoiceProblem() {
		super();
	}
	
}
