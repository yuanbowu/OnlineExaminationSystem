package com.oes.dao;

import java.util.List;

import com.oes.entity.User;

public interface UserDao {
	
	public User LoginDao( String username,String password );
	public int UpdateUserDao( User user );
	public List<User> FindPersonDetailDao( String username,String school,int power,String myclass,String grade );
	public List<User> FindPersonDetailDao( String username,String school,int power );
	public List<User> FindPersonByPowerAndSchoolDao( String school,int power );
	public List<User> FindPersonByUserNameAndPowerDao( String username,int power );
	public List<User> FindPersonByUserNameAndSchoolDao( String username,String school );
	public List<User> FindPersonBySchoolDao( String school );
	public List<User> FindPersonByUserNameDao( String username );
	public List<User> FindPersonByPowerDao( int power );
	public int InsertPerson( User user );
	public User FindByUid( int Uid );
	
}
