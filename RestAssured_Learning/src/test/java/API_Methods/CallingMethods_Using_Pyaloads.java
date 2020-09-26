package API_Methods;

import org.junit.Assert;
import org.testng.annotations.Test;

import Payloads.All_Methods_Payloads;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CallingMethods_Using_Pyaloads {

	@Test(enabled = false)
	public void PostMethod() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given().
					log().all().queryParam("key", "qaclick123").body(All_Methods_Payloads.postPayload())
					.when().
					post("/maps/api/place/add/json")
					.then().log().all().statusCode(200);
					
	}

	@Test
	public void GettMethod() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "463e6756e9d51583d930cb781c2f41a4")
					.when().get("/maps/api/place/get/json")
					.then().
					log().all().statusCode(200);

	}

	@Test(enabled = false)
	public void PutMthod() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response response = RestAssured.given().
					log().all().queryParam("key", "qaclick123")
					.body(All_Methods_Payloads.putPayload())
					.when().
					put("/maps/api/place/update/json");
	
		String body = response.body().asString();
		int status = response.getStatusCode();
		System.out.println("the status code is "+status);
		
		Assert.assertEquals(200, status);

	}

	@Test(enabled = false)
	public void DeleteMthod() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = RestAssured.given().
					log().all().queryParam("key", "qaclick123").body(All_Methods_Payloads.deletePayload())
					.when().
					delete("/maps/api/place/delete/json")
					.then().
					log().all().assertThat().statusCode(200).toString();
		

	}

	
}
