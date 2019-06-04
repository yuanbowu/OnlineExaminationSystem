package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oes.dao.ExamSCPDao;
import com.oes.entity.ExamSCP;
import com.oes.entity.ExamWithTest;
import com.oes.util.DBUtil;

public class ExamSCPDaoImpl implements ExamSCPDao{

	public List<ExamSCP> find(int eid) {
		List<ExamSCP> list = new ArrayList<ExamSCP>();
		ExamSCP eSCP = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from examsinglechoiceproblem where Eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			while (rs.next()) {
				eSCP = new ExamSCP();
				eSCP.setEid(rs.getInt("Eid"));
				eSCP.setEPid(rs.getInt("EPid"));
				eSCP.setScore(rs.getInt("Score"));
				eSCP.setSPid(rs.getInt("SPid"));
				list.add(eSCP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(ps, rs, conn);
		}
		return list;
	}
	

}
