package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.oes.dao.EOTSCPDao;
import com.oes.entity.EOTSCP;
import com.oes.entity.SingleChoiceProblem;
import com.oes.util.DBUtil;

public class EOTSCPDaoImpl implements EOTSCPDao{
	public void add(EOTSCP ep){
		String sql = "insert into examsinglechoiceproblem (SPid, Eid, EPid, Score) values(?, ?, ?, ?)";
		Object[] pars = {ep.getSPid(), ep.getEid(), ep.getEPid(), ep.getScore()};
		DBUtil.executeUpdate(sql, pars);
	}
	public ArrayList<Integer> find(int eid){
		ArrayList<Integer> IDList = new ArrayList<Integer>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from examsinglechoiceproblem where Eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			while(rs.next()){
				Integer pid = rs.getInt("SPid");
				IDList.add(pid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return IDList;
	}
}
