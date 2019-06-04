package com.oes.dao;

import java.util.ArrayList;

import com.oes.entity.ExamWithoutTest;

public interface EOTDao {
	public int add(ExamWithoutTest EOT);
	public ArrayList<ExamWithoutTest> findAll();
	public ExamWithoutTest find(int eid);
}
