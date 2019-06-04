package com.oes.entity;

public class User {
	private int Uid;
	private String UserName;
	private String UserPwd;
	private int UserPower;
	private String UserSchool;
	private String UserGrade;
	private String UserClass;
	private String UserSex;
	private String UserTel;
	private String UserAdr;
	private String Introduction;
	public int getUid() {
		return Uid;
	}
	public String getUserGrade() {
		return UserGrade;
	}
	public void setUserGrade(String userGrade) {
		UserGrade = userGrade;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getUserTel() {
		return UserTel;
	}
	public void setUserTel(String userTel) {
		UserTel = userTel;
	}
	public String getUserAdr() {
		return UserAdr;
	}
	public void setUserAdr(String userAdr) {
		UserAdr = userAdr;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getUserSchool() {
		return UserSchool;
	}
	public void setUserSchool(String userSchool) {
		UserSchool = userSchool;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserClass() {
		return UserClass;
	}
	public void setUserClass(String userClass) {
		UserClass = userClass;
	}
	public String getUserPwd() {
		return UserPwd;
	}
	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}
	public int getUserPower() {
		return UserPower;
	}
	public void setUserPower(int userPower) {
		UserPower = userPower;
	}

	public User(int uid, String userName, String userPwd, int userPower, String userSchool, String userGrade,
			String userClass, String userSex, String userTel, String userAdr, String introduction) {
		super();
		Uid = uid;
		UserName = userName;
		UserPwd = userPwd;
		UserPower = userPower;
		UserSchool = userSchool;
		UserGrade = userGrade;
		UserClass = userClass;
		UserSex = userSex;
		UserTel = userTel;
		UserAdr = userAdr;
		Introduction = introduction;
	}
	
	public User(String userName, String userPwd, int userPower, String userSchool, String userGrade,
			String userClass, String userSex, String userTel, String userAdr, String introduction) {
		super();
		UserName = userName;
		UserPwd = userPwd;
		UserPower = userPower;
		UserSchool = userSchool;
		UserGrade = userGrade;
		UserClass = userClass;
		UserSex = userSex;
		UserTel = userTel;
		UserAdr = userAdr;
		Introduction = introduction;
	}
	
	public User(String userName, String userPwd, int userPower, String userSchool, String userGrade,
			String userClass) {
		super();
		UserName = userName;
		UserPwd = userPwd;
		UserPower = userPower;
		UserSchool = userSchool;
		UserGrade = userGrade;
		UserClass = userClass;
	}
	
	public User() {

	}
	

}
