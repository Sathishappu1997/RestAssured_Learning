package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pojo_Class.All_Methods_Pojo;
import Pojo_Class.Location;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestMethod_DataProvier {
	
	ReadExcelData excel = null;
	All_Methods_Pojo pojo;
	Location location;
	String filepath = "C:\\Users\\Hp\\Desktop\\API_TestData.xlsx";
	String Sheetname = "Sheet1";
	
	@Test(dataProvider = "API")
	public void PostMethod(String lat, String lng, String accuracy, String name, String phonenumber, String address, String item1, String item2, String website, String lang) {
			
		pojo = new All_Methods_Pojo();
		location = new Location();
		
		location.setLat(lat);
		location.setLng(lng);
		
		pojo.setLocation(location);
		pojo.setAccuracy(accuracy);
		pojo.setName(name);
		pojo.setPhone_number(phonenumber);
		pojo.setAddress(address);
		
		List<String> list = new ArrayList<String>();
		list.add(item1);
		list.add(item2);
		
		pojo.setTypes(list);
		pojo.setWebsite(website);
		pojo.setLanguage(lang);

		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given().
					log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123")
					.body(pojo)
					.when().
					post("/maps/api/place/add/json")
					.then().log().all();
		
	}
	
	@DataProvider(name = "API")
	public Object[][] RequestMEthod() throws Exception{
		
		Object[][] data = testData(filepath, Sheetname);
		return data;
		
	}
	
	
	public Object[][] testData(String xlFilePath, String sheetname) throws Exception{
		
		Object[][] excelData = null;
		excel = new ReadExcelData(xlFilePath);
		
		int rows = excel.getRowCount(sheetname);
		int columns = excel.getColumnCount(sheetname);
		
		excelData = new Object[rows-1][columns];
		
		for(int i=1;i<rows;i++) {
			
			for(int j=0;j<columns;j++) {
				
				excelData[i-1][j] = excel.getCellData(sheetname, j, i);
			}
		}
		return excelData;
	}
}
