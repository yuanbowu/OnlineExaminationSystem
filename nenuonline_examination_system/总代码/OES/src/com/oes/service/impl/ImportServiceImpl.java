package com.oes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.oes.dao.UserDao;
import com.oes.dao.impl.UserDaoImpl;
import com.oes.entity.User;
import com.oes.service.ImportService;

public class ImportServiceImpl implements ImportService {

	UserDao ud = new UserDaoImpl();

	public boolean ImportExcel(List<User> list) {

		int i;
		int count = 0;
		for (i = 0; i < list.size(); i++) {

			User user = list.get(i);
			count = count + ud.InsertPerson(user);

		}
		if (count == list.size()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ImportUser(User user) {

		int count = ud.InsertPerson(user);
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> AnalysisExcel(String path) {

		List<User> list = new ArrayList<User>();
		if (path != "") {
			String suffix = path.substring(path.lastIndexOf("."), path.length());
			InputStream is = null;
			try {
				is = new FileInputStream(path);
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}

			if (".xls".equals(suffix)) {

				POIFSFileSystem fs;
				HSSFWorkbook wb;
				HSSFSheet hssfSheet;
				try {
					fs = new POIFSFileSystem(is);
					wb = new HSSFWorkbook(fs);
					hssfSheet = wb.getSheetAt(0);
					if (hssfSheet == null) {
						System.out.println("sheetΪ��");
						return null;
					} else {

						list = GetContentHSSFSheet(hssfSheet);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (".xlsx".equals(suffix)) {
				try {
					XSSFWorkbook xwb = new XSSFWorkbook(is);
					XSSFSheet xssfSheet = xwb.getSheetAt(0);
					if (xssfSheet == null) {
						System.out.println("sheetΪ��");
						return null;
					} else {
						list = GetContentXSSFSheet(xssfSheet);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				is = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("·����Ч��");
		}

		return list;

	}

	public List<User> GetContentHSSFSheet(HSSFSheet sheet) {

		List<User> list = new ArrayList<User>();

		// ����sheetҳ�е�ÿһ�У��ӵڶ��п�ʼ������������
		for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
			User user = new User();
			HSSFRow hssfRow = sheet.getRow(rowNum);

			if (hssfRow == null) {
				continue;
			}
			for (int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++) {// �������е�ÿ����Ԫ��
				HSSFCell hssfCell = hssfRow.getCell(cellNum);
				if (hssfCell == null) {
					continue;
				}
				// System.out.print(" "+getValue(hssfCell));
				switch (cellNum) {
				case 0:
					user.setUserName(GetContentHSSFCell(hssfCell));
					break;
				case 1:
					user.setUserPwd(GetContentHSSFCell(hssfCell));
					break;
				case 2:
					user.setUserPower(Integer.parseInt(GetContentHSSFCell(hssfCell)));
					break;
				case 3:
					user.setUserSchool(GetContentHSSFCell(hssfCell));
					break;
				case 4:
					user.setUserGrade(GetContentHSSFCell(hssfCell));
					break;
				case 5:
					user.setUserClass(GetContentHSSFCell(hssfCell));
					break;
				}
			}

			list.add(user);

		}

		return list;
	}

	public List<User> GetContentXSSFSheet(XSSFSheet sheet) {

		List<User> list = new ArrayList<User>();

		for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
			User user = new User();
			XSSFRow xssfRow = sheet.getRow(rowNum);

			if (xssfRow == null) {
				continue;
			}
			for (int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++) {// �������е�ÿ����Ԫ��
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				if (xssfCell == null) {
					continue;
				}
				switch (cellNum) {
				case 0:
					user.setUserName(GetContentXSSFCell(xssfCell));
					break;
				case 1:
					user.setUserPwd(GetContentXSSFCell(xssfCell));
					break;
				case 2:
					user.setUserPower((int) Double.parseDouble(GetContentXSSFCell(xssfCell)));
					break;
				case 3:
					user.setUserSchool(GetContentXSSFCell(xssfCell));
					break;
				case 4:
					user.setUserGrade(GetContentXSSFCell(xssfCell));
					break;
				case 5:
					user.setUserClass(GetContentXSSFCell(xssfCell));
					break;
				}
			}
//			System.out.println("sheet�У�" + user);
			list.add(user);
		}
//		System.out.println("sheet��:" + list);
		return list;

	}

	public String GetContentHSSFCell(HSSFCell cell) {

		if (cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return RemoveZeroAndDot(String.valueOf(cell.getNumericCellValue()));
		} else {
			return String.valueOf(cell.getStringCellValue());
		}

	}

	public String GetContentXSSFCell(XSSFCell cell) {

		if (cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return RemoveZeroAndDot(String.valueOf(cell.getNumericCellValue()));
		} else {
			return String.valueOf(cell.getStringCellValue());
		}

	}

	public String RemoveZeroAndDot(String s) {
		if (s.indexOf(".") > 0) {
			// ȥ�������0
			s = s.replaceAll("0+?$", "");
			// ȥ�������С����
			s = s.replaceAll("[.]$", "");
		}
		return s;
	}

}
