package com.oes.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.oes.entity.User;

public interface ImportService {
	
	public boolean ImportExcel( List<User> list );
	public boolean ImportUser( User user );
	public List<User> AnalysisExcel(String path);
	public List<User> GetContentHSSFSheet(HSSFSheet sheet);
	public List<User> GetContentXSSFSheet(XSSFSheet sheet);
	public String GetContentHSSFCell(HSSFCell cell);
	public String GetContentXSSFCell(XSSFCell cell);
	public String RemoveZeroAndDot(String s);
	
}
