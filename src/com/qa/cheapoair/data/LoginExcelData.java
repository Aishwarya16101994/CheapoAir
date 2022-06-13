package com.qa.cheapoair.data;

import com.qa.cheapoair.utilities.Xls_Reader;

public class LoginExcelData {

	Xls_Reader d = new Xls_Reader("C:\\Users\\sbuddhe_aditya\\Desktop\\QA AUTOMATON\\Selenium_WorkSpace\\CheapoAir\\src\\com\\qa\\cheapoair\\utilities\\Aishwarya1.xlsx");
	
	public String wrongEmail = d.getCellData("Data1", "wrongEmail", 8);
	public String Emailwithspecialchar = d.getCellData("Data1", "Emailwithspecialchar", 8);
	public String GlobalErr = d.getCellData("Data1", "GlobalErr", 8);
	public String emptyemailErr = d.getCellData("Data1", "emptyemailErr", 8);
}
