package com.excel.utility;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader1 reader = new Xls_Reader1(
				"D:\\eclipse oxyzen\\eclipse\\CHARI\\SeliniumSessions\\src\\com\\testdata\\Ebay.xslx.xlsx");
		if (!reader.isSheetExist("homepage")) {
			reader.addSheet("homepage");
		}
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("total no of columns present in the sheet:===" + colCount);
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "panuganti"));

	}

}
