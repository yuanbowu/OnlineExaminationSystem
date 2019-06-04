package com.oes.dao;

import java.util.ArrayList;

import com.oes.entity.EOTSCP;
import com.oes.entity.ExamWithoutTest;

public interface EOTSCPDao {
	public void add(EOTSCP ep);
	public ArrayList<Integer> find(int eid);
}
