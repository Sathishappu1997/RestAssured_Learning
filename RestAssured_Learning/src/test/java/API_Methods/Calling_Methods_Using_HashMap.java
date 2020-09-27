package API_Methods;

import org.junit.Assert;
import org.testng.annotations.Test;

import HashMap.All_Method_HashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Calling_Methods_Using_HashMap {

	All_Method_HashMap map;

	String Place_id;

	@Test(priority = 0)
	public void PostMethod() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		map = new All_Method_HashMap();
		
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123").body(map.Post_HashMap("franklin","English")).when()
				.post("/maps/api/place/add/json");
		
		System.out.println(response.body().toString());
		
		Place_id = response.jsonPath().getString("place_id");

	}

	@Test(priority = 2)
	public void GettMethod() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		RestAssured.given().log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123")
				.queryParam("place_id", Place_id).when().get("/maps/api/place/get/json")
				.then().log().all().statusCode(200);

	}

	@Test(priority = 1)
	public void PutMthod() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123")
				.body(map.Put_HashMap(Place_id)).when().put("/maps/api/place/update/json");

		String body = response.body().asString();
		int status = response.getStatusCode();
		System.out.println("the status code is " + status);

		Assert.assertEquals(200, status);

	}

	@Test(priority = 3)
	public void DeleteMthod() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = RestAssured.given().log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123")
				.body(map.Delete_HashMap(Place_id)).when().delete("/maps/api/place/delete/json").then().log()
				.all().assertThat().statusCode(200).toString();

	}

}
