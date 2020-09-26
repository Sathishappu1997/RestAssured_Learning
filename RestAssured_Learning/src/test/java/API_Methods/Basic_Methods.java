package API_Methods;

import org.testng.annotations.Test;
import org.hamcrest.*;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic_Methods {

	// 1. Post
	// 2. Get
	// 3. Put
	// 4. Delete

	String Place_id;
	
	@Test(priority = 0)
	public void PostMethod() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response respone = RestAssured.given().
					log().all().queryParam("key", "qaclick123").body("{\r\n" + 
							"  \"location\": {\r\n" + 
							"    \"lat\": -38.383494,\r\n" + 
							"    \"lng\": 33.427362\r\n" + 
							"  },\r\n" + 
							"  \"accuracy\": 50,\r\n" + 
							"  \"name\": \"Frontline house\",\r\n" + 
							"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
							"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
							"  \"types\": [\r\n" + 
							"    \"shoe park\",\r\n" + 
							"    \"shop\"\r\n" + 
							"  ],\r\n" + 
							"  \"website\": \"http://google.com\",\r\n" + 
							"  \"language\": \"French-IN\"\r\n" + 
							"}\r\n" + 
							"")
					.when().
					post("/maps/api/place/add/json");
		
		Place_id = respone.jsonPath().getString("place_id");
		
					
	}

	public void GettMethod() {

	}

	@Test(priority = 1)
	public void PutMthod() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response response = RestAssured.given().
					log().all().queryParam("key", "qaclick123").body("{\r\n" + 
							"\"place_id\":\""+Place_id+"\",\r\n" + 
							"\"address\":\"46 SomeWhere, IDNIA\",\r\n" + 
							"\"key\":\"qaclick123\"\r\n" + 
							"}")
					.when().
					put("/maps/api/place/update/json");
	
		String body = response.body().asString();
		int status = response.getStatusCode();
		System.out.println("the status code is "+status);
		
		Assert.assertEquals(200, status);

	}

	@Test(priority = 2)
	public void DeleteMthod() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = RestAssured.given().
					log().all().queryParam("key", "qaclick123").body("{\r\n" + 
							"    \"place_id\":\""+Place_id+"\" \r\n" + 
							"}\r\n" + 
							"")
					.when().
					delete("/maps/api/place/delete/json")
					.then().
					log().all().assertThat().statusCode(200).toString();
		

	}

}
