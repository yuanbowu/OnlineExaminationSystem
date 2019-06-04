package com.oes.service;


import java.util.ArrayList;

import com.oes.entity.Answer;
import com.oes.entity.AnswerSCP;

public interface AnswerService {
	
	public void addAnswerPaper(Answer ans);
	public void addAnswerSCP(AnswerSCP aSCP);
	public Answer verifyUser(int Uid, int Eid);
	public ArrayList<Answer> findAllAnswer(int Uid);
	public ArrayList<AnswerSCP> findAllAnswerSCP(int Uid, int Eid);
}
