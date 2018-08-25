package com.yahoo.mail;


import java.util.ArrayList;



public class TestUtil {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("D:\\eclipse-workspace\\thaismile\\testData.xlsx");

		} catch (Exception e) {

			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {

			String firstname = reader.getCellData("Sheet1", "firstname", rowNum);
			String lastname = reader.getCellData("Sheet1", "lastname", rowNum);
			String emailaddress = reader.getCellData("Sheet1", "emailaddress", rowNum);
			String password = reader.getCellData("Sheet1", "password", rowNum);
			String cell = reader.getCellData("Sheet1", "cell", rowNum);
			String month = reader.getCellData("Sheet1", "month", rowNum);
			String day = reader.getCellData("Sheet1", "day", rowNum);
			String year = reader.getCellData("Sheet1", "year", rowNum);
			String gender = reader.getCellData("Sheet1", "gender", rowNum);

			Object obj[] = { firstname, lastname, emailaddress, password, cell, month, day, year, gender };

			myData.add(obj);

		}

		return myData;
	}
}
