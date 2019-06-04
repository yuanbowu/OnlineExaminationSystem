package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oes.dao.UserDao;
import com.oes.entity.User;
import com.oes.util.DBUtil;

public class UserDaoImpl implements UserDao {

	public User LoginDao(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		conn = DBUtil.getConnection();
		String sql = "select * from user where UserName = ? and UserPwd = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(ps, rs, conn);
		}

		return user;
	}

	
	public int UpdateUserDao(User user) {
		
		int uid = user.getUid();
		String username = user.getUserName();
		String password = user.getUserPwd();
		int power = user.getUserPower();
		String school = user.getUserSchool();
		JudgeAndInitialize(school);
		String grade = user.getUserGrade();
		JudgeAndInitialize(grade);
		String stuclass = user.getUserClass();
		JudgeAndInitialize(stuclass);
		String sex = user.getUserSex();

		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update user set UserName = ?,UserPwd = ?,UserPower = ?,"
				+ "UserSchool = ?,UserGrade = ?,"
				+ " UserClass = ?"
				+ " where Uid = ?";
		
		int sign = 0;
				
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, power);
			ps.setString(4, school);
			ps.setString(5, grade);
			ps.setString(6, stuclass);
			ps.setInt(7, uid);
			sign = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sign;
	}

	public String JudgeAndInitialize( String str ){
		
		String str1;
		if( str==null ){
			str1 = "null";
		}else{
			str1 = str;
		}
		
		return str1;
		
	}

	public List<User> FindPersonByPowerAndSchoolDao(String school, int power) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserSchool = ? and UserPower = ?";
		List<User> list = new ArrayList<User>();
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, school);
			ps.setInt(2, power);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public List<User> FindPersonBySchoolDao(String school) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserSchool = ? ";
		List<User> list = new ArrayList<User>();
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, school);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
			int i;
//			System.out.println(list);
			for( i=0;i<list.size();i++ ){
				System.out.println(list.get(i).getUserName()+" "+list.get(i).getUserSchool());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<User> FindPersonByUserNameDao(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserName = ? ";
		List<User> list = new ArrayList<User>();
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
//			int i;
//			System.out.println(list);
//			for( i=0;i<list.size();i++ ){
//				System.out.println(list.get(i).getUserName()+" "+list.get(i).getUserSchool());
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("dao"+list.size());
		return list;
	}

	public List<User> FindPersonByPowerDao(int power) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserPower = ? ";
		List<User> list = new ArrayList<User>();
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, power);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
//			int i;
//			System.out.println(list);
//			for( i=0;i<list.size();i++ ){
//				System.out.println(list.get(i).getUserName()+" "+list.get(i).getUserSchool());
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}



	public List<User> FindPersonDetailDao(String username, String school, int power) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserName = ? and UserSchool = ? and UserPower = ?";
		User user  = null;
		List<User> list = new ArrayList<User>();
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, school);
			ps.setInt(3, power);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		
//		System.out.println("dao"+list.size());
		
		return list;
	}



	public List<User> FindPersonByUserNameAndPowerDao(String username, int power) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserName = ? and UserPower = ?";
		List<User> list = new ArrayList<User>();
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, power);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}



	public List<User> FindPersonByUserNameAndSchoolDao(String username, String school) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserName = ? and UserSchool = ?";
		List<User> list = new ArrayList<User>();
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, school);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("dao"+list.size());
		
		return list;
	}



	public List<User> FindPersonDetailDao(String username, String school, int power, String myclass,String grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where UserName = ? and UserSchool = ? and UserPower = ? and UserClass = ? and UserGrade = ?";
		User user  = null;
		List<User> list = new ArrayList<User>();
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, school);
			ps.setInt(3, power);
			ps.setString(4, myclass);
			ps.setString(5, grade);
			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		
//		System.out.println("dao"+list.size());
		
		return list;
	}

	public int InsertPerson(User user) {
		
		String username = user.getUserName();
		String password = user.getUserPwd();
		int power = user.getUserPower();
		
		String school = user.getUserSchool();
		JudgeAndInitialize(school);
		String grade = user.getUserGrade();
		JudgeAndInitialize(grade);
		String stuclass = user.getUserClass();
		JudgeAndInitialize(stuclass);
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into user (UserName,UserPwd,UserPower,UserSchool,UserGrade,UserClass)"
				+ " values(?,?,?,?,?,?) ";
		
		int sign = 0;
				
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, power);
			ps.setString(4, school);
			ps.setString(5, grade);
			ps.setString(6, stuclass);
			
			sign = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sign;
	}

	public User FindByUid(int Uid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where Uid=?";
		User user = null;
		
		conn = DBUtil.getConnection();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Uid);

			rs = ps.executeQuery();
			while( rs.next() ){
				user = new User();
				user.setUid(rs.getInt("Uid"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserPower(rs.getInt("UserPower"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserGrade(rs.getString("UserGrade"));
				user.setUserClass(rs.getString("UserClass"));
				user.setUserSex(rs.getString("UserSex"));
				user.setUserTel(rs.getString("UserTel"));
				user.setUserAdr(rs.getString("UserAdr"));
				user.setIntroduction(rs.getString("Introduction"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}


}
