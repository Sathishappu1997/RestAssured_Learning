package StepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import HashMap.All_Method_HashMap;
import Payloads.All_Methods_Payloads;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class StepDefinition_AllMethods {

		All_Method_HashMap map;
		Response response;
		RequestSpecification res;
	
		@Given("Initilise Base URI link")
		public void initilise_base_uri_link() {
			RestAssured.baseURI="https://rahulshettyacademy.com";	
		}

		@When("call he hashmap for post method")
		public void call_he_hashmap_for_post_method() {
			map = new All_Method_HashMap();
		}

		@Then("get the response for post method with {string} and {string}")
		public void get_the_response_for_post_method_with_and(String name, String lang) throws FileNotFoundException {
			
			PrintStream log = new PrintStream(new File("src/test/resources/Log/All_Log.txt"));
			
			if(res==null) {
				
			res = RestAssured.given().contentType(ContentType.JSON).filter(RequestLoggingFilter.logRequestTo(log))
					.filter(ResponseLoggingFilter.logResponseTo(log)).
					log().all().queryParam("key", "qaclick123");
			}
			
			response = res.body(map.Post_HashMap(name, lang))
						.when().
						post("/maps/api/place/add/json");
						
		}

		@Then("Validate Post response")
		public void validate_post_response() {
			
			String expectedstatus = "OK";
			String actualstatus = response.jsonPath().getString("status");
			
			Assert.assertEquals(expectedstatus, actualstatus);
		}
	
}
