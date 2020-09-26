package API_Methods;

import org.testng.annotations.Test;

import Pojo_Class.Set_Values_for_Pojo;
import io.restassured.RestAssured;

public class Post_Method_Using_Pojo {
	
	Set_Values_for_Pojo post;
	
	@Test
	public void Post_Using_Pojo() {
		
		post = new Set_Values_for_Pojo();
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given().
					log().all().queryParam("key", "qaclick123").body(post.setValues_post_Pojo())
					.when().
					post("/maps/api/place/add/json")
					.then().log().all().statusCode(200);
	}

}
