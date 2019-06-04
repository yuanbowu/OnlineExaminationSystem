package com.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oes.dao.AnswerSCPDao;
import com.oes.entity.AnswerSCP;
import com.oes.entity.ExamWithoutTest;
import com.oes.util.DBUtil;

public class AnswerSCPDaoImpl implements AnswerSCPDao {

	public void add(AnswerSCP aSCP){
		String sql = "insert into answersinglechoiceproblem (SPid, Uid, Choice, Score, Eid) values(?, ?, ?, ?, ?)";
		Object[] pars = {aSCP.getSPid(), aSCP.getUid(), aSCP.getChoice(), aSCP.getScore(), aSCP.getEid()};
		DBUtil.executeUpdate(sql, pars);
	}

}
