package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LoginTestDataProvider")
 
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		//Reading json file with the help of gson
		
		Gson gson=new Gson();
		File testDataFile=new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
	    FileReader fileReader=new FileReader(testDataFile);
	    TestData data=gson.fromJson(fileReader,TestData.class); //map the file reader to the java class deserialization
	
	    //Retrieving the data from testdata and we were having json array we had stored it in arraylist and we are attaching it to dataToreturn array list which is of object type
	List <Object[]> dataToReturn=new ArrayList<Object[]>();
	for (User user:data.getData()) {
		dataToReturn.add(new Object[] {user});
	}
	
	return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginTestCSV/DataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
		
	}
	
	@DataProvider(name="LoginTestExcel/DataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
		
	}
	
	
	
}
