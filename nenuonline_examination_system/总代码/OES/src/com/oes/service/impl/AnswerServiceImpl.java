package com.oes.service.impl;

import java.util.ArrayList;

import com.oes.dao.AnswerDao;
import com.oes.dao.AnswerSCPDao;
import com.oes.dao.impl.AnswerDaoImpl;
import com.oes.dao.impl.AnswerSCPDaoImpl;
import com.oes.entity.Answer;
import com.oes.entity.AnswerSCP;
import com.oes.service.AnswerService;

public class AnswerServiceImpl implements AnswerService{

	@Override
	public void addAnswerPaper(Answer ans) {
		// TODO Auto-generated method stub
		AnswerDao aDao = new AnswerDaoImpl();
		aDao.add(ans);
	}

	@Override
	public void addAnswerSCP(AnswerSCP aSCP) {
		// TODO Auto-generated method stub
		AnswerSCPDao aSCPDao = new AnswerSCPDaoImpl();
		aSCPDao.add(aSCP);
	}
	


	@Override
	public Answer verifyUser(int Uid, int Eid) {
		// TODO Auto-generated method stub
		AnswerDao aDao = new AnswerDaoImpl();
		Answer ret = aDao.exist(Uid, Eid);
		return ret;
	}

	@Override
	public ArrayList<Answer> findAllAnswer(int Uid) {
		// TODO Auto-generated method stub
		AnswerDao aDao = new AnswerDaoImpl();
		ArrayList<Answer> ret = aDao.findAll(Uid);
		return ret;
	}
	@Override
	public ArrayList<AnswerSCP> findAllAnswerSCP(int Uid, int Eid) {
		// TODO Auto-generated method stub
		AnswerDao aDao = new AnswerDaoImpl();
		ArrayList<AnswerSCP> ret = aDao.findAllUE(Uid, Eid);
		return ret;
	}
	
	
}
