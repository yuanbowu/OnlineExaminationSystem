package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oes.dao.AnswerDao;
import com.oes.entity.Answer;
import com.oes.entity.AnswerSCP;
import com.oes.util.DBUtil;

public class AnswerDaoImpl implements AnswerDao{

	public void add(Answer ans){
		String sql = "insert into answer (Owner, Score, Exam) values(?, ?, ?)";
		Object[] pars = {ans.getOwner(), ans.getScore(), ans.getExam()};
		DBUtil.executeUpdate(sql, pars);
	}

	@Override
	public Answer exist(int Uid, int Eid) {
		// TODO Auto-generated method stub
		Answer ret = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
//		System.out.println("Uid: " + Uid + " Eid: " + Eid);
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from answer where Owner = ? and Exam = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Uid);
			ps.setInt(2, Eid);
			rs = ps.executeQuery();
			if(rs.next()){
				ret = new Answer();
				ret.setAid(rs.getInt("Aid"));
				ret.setOwner(rs.getInt("Owner"));
				ret.setScore(rs.getInt("Score"));
				ret.setExam(rs.getInt("Exam"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return ret;
	}

	@Override
	public ArrayList<Answer> findAll(int Uid) {
		// TODO Auto-generated method stub
		ArrayList<Answer> aList = new ArrayList<Answer>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from answer where Owner = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Uid);
			rs = ps.executeQuery();
			while(rs.next()){
				Answer ans = new Answer();
				ans.setAid(rs.getInt("Aid"));
				ans.setOwner(rs.getInt("Owner"));
				ans.setScore(rs.getInt("Score"));
				ans.setExam(rs.getInt("Exam"));
				aList.add(ans);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return aList;
	}
	
	@Override
	public ArrayList<AnswerSCP> findAllUE(int Uid, int Eid) {
		// TODO Auto-generated method stub
		ArrayList<AnswerSCP> aList = new ArrayList<AnswerSCP>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from answersinglechoiceproblem where Uid = ? and Eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Uid);
			ps.setInt(2, Eid);
			rs = ps.executeQuery();
			while(rs.next()){
				AnswerSCP aSCP = new AnswerSCP();
				aSCP.setSPid(rs.getInt("SPid"));
				aSCP.setUid(rs.getInt("Uid"));
				aSCP.setEid(rs.getInt("Eid"));
				aSCP.setChoice(rs.getString("Choice"));
				aSCP.setScore(rs.getInt("Score"));
				aList.add(aSCP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return aList;
	}
}
