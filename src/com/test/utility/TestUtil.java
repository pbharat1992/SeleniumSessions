package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader1;

public class TestUtil {
	static Xls_Reader1 reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader1(
					"D:\\\\eclipse oxyzen\\\\eclipse\\\\CHARI\\\\SeliniumSessions\\\\src\\\\com\\\\testdata\\\\Ebay.xslx.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++) {

			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
			String Password = reader.getCellData("RegTestData", "Password", rowNum);

			Object ob[] = { firstName, lastName, emailaddress, Password };
			myData.add(ob);

		}
		return myData;

	}

}
