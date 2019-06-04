package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oes.dao.ExamWithTestDao;
import com.oes.entity.ExamWithTest;
import com.oes.entity.ExamWithoutTest;
import com.oes.util.DBUtil;

public class ExamWithTestDaoImpl implements ExamWithTestDao {

	public ExamWithTest find(int eid) {
		
		ExamWithTest EOT = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from examwithtest where Eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			if (rs.next()) {
				EOT = new ExamWithTest();
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
		} finally {
			DBUtil.closeAll(ps, rs, conn);
		}
		return EOT;

	}

}
