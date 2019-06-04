package com.oes.service.impl;

import java.util.ArrayList;

import com.oes.dao.EOTDao;
import com.oes.dao.EOTSCPDao;
import com.oes.dao.SCPDao;
import com.oes.dao.impl.EOTSCPDaoImpl;
import com.oes.dao.impl.SCPDaoImpl;
import com.oes.entity.SingleChoiceProblem;
import com.oes.service.ProblemService;

public class ProblemServiceImpl implements ProblemService{
	public void addSingleChoiceProblem(SingleChoiceProblem SCP){
		SCPDaoImpl pDao = new SCPDaoImpl();
		pDao.add(SCP);
	}
	public ArrayList<SingleChoiceProblem> findAllProblem(){
		SCPDao pDao = new SCPDaoImpl();
		return pDao.findAll();
	}
	@Override
	public ArrayList<SingleChoiceProblem> find(int eid) {
		// TODO Auto-generated method stub
		EOTSCPDao epDao = new EOTSCPDaoImpl();
		ArrayList<Integer> IDList = epDao.find(eid);
		SCPDao pDao = new SCPDaoImpl();
		ArrayList<SingleChoiceProblem> SCPList = new ArrayList<SingleChoiceProblem>();
		int sz = IDList.size();
		for(int i = 0; i < sz; ++i){
			int pid = IDList.get(i);
			SCPList.add(pDao.find(pid));
		}
		return SCPList;
	}
	@Override
	public SingleChoiceProblem findSCPProblem(int spid) {
		
		SCPDao scpd = new SCPDaoImpl();
		
		return scpd.find(spid);
	}
	@Override
	public ArrayList<SingleChoiceProblem> findSomeProblem(int Uid) {
		SCPDao SCPD = new SCPDaoImpl();
		
		return SCPD.findSome(Uid);
	}
	@Override
	public void deleteSCP(int sPid) {
		SCPDaoImpl pDao = new SCPDaoImpl();
		pDao.delete(sPid);
	}
	
}
