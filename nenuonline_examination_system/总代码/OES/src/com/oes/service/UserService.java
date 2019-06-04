package com.oes.service;

import java.util.List;

import com.oes.entity.User;

public interface UserService {
	
	public User LoginService( String username, String password );
	public boolean UpdatePersonalInformation( User user );
	public List<User> FindPersons( String username,String school,int power,String myclass,String grade );
	public int UpdateUserInformation( User user );
	public User FindUserByUid( int Uid );
}
