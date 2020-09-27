package API_Methods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Payloads.All_Methods_Payloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Using_JsonPath {
	
	@Test
	public void Post_JsonPath() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given().
					log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123")
					.body(jsonobject().toJSONString())
					.when().
					post("/maps/api/place/add/json")
					.then().log().all();
		
	}
	
	public JSONObject jsonobject() {
		
		JSONObject location = new JSONObject();
		location.put("lat", 33.427362);
		location.put("lng", 33.427362);
		
		JSONObject json = new JSONObject();
		json.put("location", location);
		json.put("accuracy", 50);
		json.put("name", "Franklin");
		json.put("phone_number", "(+91) 983 893 3937");
		json.put("address", "29, side layout, cohen 09");
		
		JSONArray list = new JSONArray();
		list.add("Shop");
		list.add("Shoe Shop");
		
		json.put("types", list);
		json.put("website", "http://google.com");
		json.put("language", "French-IN");
		
		return json;
		
	}

}
