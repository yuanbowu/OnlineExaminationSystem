package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.oes.dao.SCPDao;
import com.oes.entity.ExamWithoutTest;
import com.oes.entity.SingleChoiceProblem;
import com.oes.util.DBUtil;

public class SCPDaoImpl implements SCPDao{
	public void add(SingleChoiceProblem SCP){
		String sql = "insert into singlechoiceproblem (Content, Owner, ProvideTime, OptionA, OptionB, OptionC, OptionD, Answer) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] pars = {SCP.getContent(), SCP.getOwner(), SCP.getProvideTime(),
				         SCP.getOptionA(), SCP.getOptionB(), SCP.getOptionC(), SCP.getOptionD(),
				         SCP.getAnswer()
						};
		DBUtil.executeUpdate(sql, pars);
	}
	public ArrayList<SingleChoiceProblem> findAll(){
		ArrayList<SingleChoiceProblem> SCPList = new ArrayList<SingleChoiceProblem>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from singlechoiceproblem";
			ps = conn.prepareStatement(sql);
		
			rs = ps.executeQuery();
			while(rs.next()){
				int sPid = rs.getInt("SPid");
				String content = rs.getString("Content");
				int owner = rs.getInt("Owner");
				Date provideTime = rs.getDate("ProvideTime");
				String optionA = rs.getString("OptionA");
				String optionB = rs.getString("OptionB");
				String optionC = rs.getString("OptionC");
				String optionD = rs.getString("OptionD");
				String answer = rs.getString("Answer");
				SingleChoiceProblem SCP = new SingleChoiceProblem(sPid, content, owner, provideTime, optionA, optionB, optionC, optionD, answer);
				SCPList.add(SCP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return SCPList;
	}
	@Override
	public SingleChoiceProblem find(int pid) {
		// TODO Auto-generated method stub
		SingleChoiceProblem SCP = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from singlechoiceproblem where SPid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			if(rs.next()){
				SCP = new SingleChoiceProblem();
				SCP.setsPid(rs.getInt("SPid"));
				SCP.setContent(rs.getString("Content"));
				SCP.setOwner(rs.getInt("Owner"));
				SCP.setOptionA(rs.getString("OptionA"));
				SCP.setOptionB(rs.getString("OptionB"));
				SCP.setOptionC(rs.getString("OptionC"));
				SCP.setOptionD(rs.getString("OptionD"));
				SCP.setAnswer(rs.getString("Answer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return SCP;
	}
	@Override
	public ArrayList<SingleChoiceProblem> findSome(int uid) {
		ArrayList<SingleChoiceProblem> SCPList = new ArrayList<SingleChoiceProblem>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from singlechoiceproblem where Owner = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()){
				int sPid = rs.getInt("SPid");
				String content = rs.getString("Content");
				int owner = rs.getInt("Owner");
				Date provideTime = rs.getDate("ProvideTime");
				String optionA = rs.getString("OptionA");
				String optionB = rs.getString("OptionB");
				String optionC = rs.getString("OptionC");
				String optionD = rs.getString("OptionD");
				String answer = rs.getString("Answer");
				SingleChoiceProblem SCP = new SingleChoiceProblem(sPid, content, owner, provideTime, optionA, optionB, optionC, optionD, answer);
				SCPList.add(SCP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(ps, rs, conn);
		}
		return SCPList;
	}
	public void delete(int sPid) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from singlechoiceproblem where SPid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sPid);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}
}
