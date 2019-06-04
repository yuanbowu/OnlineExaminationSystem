package com.oes.service;

import java.util.ArrayList;

import com.oes.entity.SingleChoiceProblem;

public interface ProblemService {
	public void addSingleChoiceProblem(SingleChoiceProblem SCP);
	public ArrayList<SingleChoiceProblem> findAllProblem();
	public ArrayList<SingleChoiceProblem> find(int eid);
	public SingleChoiceProblem findSCPProblem( int spid );
	public ArrayList<SingleChoiceProblem> findSomeProblem(int Uid);
	public void deleteSCP(int sPid);
}
