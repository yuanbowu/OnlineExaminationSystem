package com.oes.dao;

import java.util.ArrayList;

import com.oes.entity.SingleChoiceProblem;

public interface SCPDao {
	public void add(SingleChoiceProblem SCP);
	public ArrayList<SingleChoiceProblem> findAll();
	public SingleChoiceProblem find(int pid);
	public ArrayList<SingleChoiceProblem> findSome(int uid);
	public void delete(int sPid);
}
