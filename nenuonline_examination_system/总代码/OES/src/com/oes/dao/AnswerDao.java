package com.oes.dao;


import java.util.ArrayList;

import com.oes.entity.Answer;
import com.oes.entity.AnswerSCP;

public interface AnswerDao {
	
	public void add(Answer ans);
	public Answer exist(int Uid, int Eid);
	public ArrayList<Answer> findAll(int Uid);
	public ArrayList<AnswerSCP> findAllUE(int Uid, int Eid);
}
