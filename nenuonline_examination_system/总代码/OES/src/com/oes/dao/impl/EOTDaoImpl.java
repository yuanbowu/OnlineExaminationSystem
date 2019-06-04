package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.oes.dao.EOTDao;
import com.oes.entity.ExamWithoutTest;
import com.oes.entity.SingleChoiceProblem;
import com.oes.util.DBUtil;

public class EOTDaoImpl implements EOTDao{

	public int add(ExamWithoutTest EOT) {
		String sql = "insert into examwithouttest (Name, Password, StartTime, EndTime, Owner) values(?, ?, ?, ?, ?)";
		Object[] pars = {EOT.getName(), EOT.getPassword(), EOT.getStartTime(), EOT.getEndTime(), EOT.getOwner()};
		DBUtil.executeUpdate(sql, pars);
		int eid = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			sql = "select * from examwithouttest where Name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, EOT.getName());
			rs = ps.executeQuery();
			if(rs.next()) eid = rs.getInt("Eid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return eid;
	}

	@Override
	public ArrayList<ExamWithoutTest> findAll() {
		ArrayList<ExamWithoutTest> EOTList = new ArrayList<ExamWithoutTest>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from examwithouttest";
			ps = conn.prepareStatement(sql);
		
			rs = ps.executeQuery();
			while(rs.next()){
				int eid = rs.getInt("eid");
				String name = rs.getString("Name");
				String password = rs.getString("Password");
				Timestamp startTime = rs.getTimestamp("StartTime");
				Timestamp endTime = rs.getTimestamp("EndTime");
				int owner = rs.getInt("Owner");
				ExamWithoutTest EOT = new ExamWithoutTest(eid, name, password, startTime, endTime, owner);
				EOTList.add(EOT);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return EOTList;
	}

	@Override
	public ExamWithoutTest find(int eid) {
		// TODO Auto-generated method stub
		ExamWithoutTest EOT = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from examwithouttest where Eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			if(rs.next()){
				EOT = new ExamWithoutTest();
				EOT.setEid(rs.getInt("Eid"));
				EOT.setName(rs.getString("Name"));
				EOT.setPassword(rs.getString("Password"));
				EOT.setStartTime(rs.getTimestamp("StartTime"));
				EOT.setEndTime(rs.getTimestamp("EndTime"));
				EOT.setOwner(rs.getInt("Owner"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return EOT;
	}
	
}
