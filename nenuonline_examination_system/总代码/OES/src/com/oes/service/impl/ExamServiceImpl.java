package com.oes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.oes.dao.EOTDao;
import com.oes.dao.EOTSCPDao;
import com.oes.dao.ExamSCPDao;
import com.oes.dao.impl.EOTDaoImpl;
import com.oes.dao.impl.EOTSCPDaoImpl;
import com.oes.dao.impl.ExamSCPDaoImpl;
import com.oes.entity.EOTSCP;
import com.oes.entity.ExamSCP;
import com.oes.entity.ExamWithoutTest;
import com.oes.service.ExamService;

public class ExamServiceImpl implements ExamService{

	@Override
	public int addExamWithoutTest(ExamWithoutTest EOT) {
		EOTDaoImpl eDao = new EOTDaoImpl();
		return eDao.add(EOT);
	}

	@Override
	public ArrayList<ExamWithoutTest> findAllExam() {
		EOTDao eDao = new EOTDaoImpl();
		return eDao.findAll();
	}
	@Override
	public void addEOTSCP(EOTSCP ep) {
		EOTSCPDao epDao = new EOTSCPDaoImpl();
		epDao.add(ep);
	}

	@Override
	public ExamWithoutTest find(int eid) {
		EOTDao eDao = new EOTDaoImpl();
		return eDao.find(eid);
	}

	@Override
	public List<ExamSCP> findProblemByExam(int eid) {
		
		ExamSCPDao escpd = new ExamSCPDaoImpl();
		
		return escpd.find(eid);
	}
}
