package com.oes.service;

import java.util.ArrayList;
import java.util.List;

import com.oes.entity.EOTSCP;
import com.oes.entity.ExamSCP;
import com.oes.entity.ExamWithoutTest;


public interface ExamService {
	public int addExamWithoutTest(ExamWithoutTest EOT);
	public ArrayList<ExamWithoutTest> findAllExam();
	public void addEOTSCP(EOTSCP ep);
	public ExamWithoutTest find(int eid);
	public List<ExamSCP> findProblemByExam( int eid );
}
