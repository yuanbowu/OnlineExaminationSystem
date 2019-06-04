package com.oes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.oes.dao.UserDao;
import com.oes.dao.impl.UserDaoImpl;
import com.oes.entity.User;
import com.oes.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao ud = new UserDaoImpl();
	
	public User LoginService(String username, String password) {
		
		return ud.LoginDao(username, password);
	}

	public boolean UpdatePersonalInformation(User user) {
		
		int count = ud.UpdateUserDao(user);
		boolean sign = false;
		if( count==1 ){
			sign = true;
		}else{
			sign = false;
		}
		
		return sign;
	}

	public List<User> FindPersons( String username,String school,int power,String myclass,String grade ) {
		
		List<User> list = new ArrayList<User>();
		
//		System.out.println("username"+username);
//		System.out.println("school"+school);
//		System.out.println("power"+power);
//		System.out.println("myclass"+myclass);
//		System.out.println("grade"+grade);
		
		if( username != "" && school != "" && power != 0 && myclass != null && grade != null&&username !=null && school != null  ){
			list = ud.FindPersonDetailDao(username, school, power,myclass,grade);
		}else if( username != "" && school != "" && power != 0 &&username !=null && school != null ){
			list = ud.FindPersonDetailDao(username, school, power);
		}else if( username != "" && school != "" &&username !=null && school != null ){
			list = ud.FindPersonByUserNameAndSchoolDao(username, school);
		}else if( school != "" && power != 0 && school != null ){

			list = ud.FindPersonByPowerAndSchoolDao(school, power);
		}else if( username != "" && power != 0 && username !=null ){

			list = ud.FindPersonByUserNameAndPowerDao(username, power);
		}else if( username != ""&& username !=null ){

			list = ud.FindPersonByUserNameDao(username);
		}else if( school != ""&& school != null ){
			list = ud.FindPersonBySchoolDao(school);
		}else if( power != 0 ){
			list = ud.FindPersonByPowerDao(power);
		}
		
//		System.out.println("9");
		
		return list;
	}

	public int UpdateUserInformation(User user) {
		
		return ud.UpdateUserDao(user);
	}


	public User FindUserByUid(int Uid) {
		
		return ud.FindByUid(Uid);
	}

}
