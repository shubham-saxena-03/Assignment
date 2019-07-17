package question3;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Question3 {
	
	@Before
	public void setUp() {
		RestAssured.baseURI = "https://itunes.apple.com";
	}
	
	
	@Test
	public void ResponseCodeForAPI1Is200() {
		validateResponseCode("/search?term=jack+johnson",200);
	}
	
	@Test
	public void ResponseCodeForAPI2Is200() {
		validateResponseCode("/search?term=jack+johnson&entity=musicVideo",200);
	}

	@Test
	public void API1hasJsonResponse() {
		validateContentType("/search?term=jack+johnson",ContentType.JSON);
	}
	
	@Test
	public void API2hasJsonResponse() {
		validateContentType("/search?term=jack+johnson&entity=musicVideo",ContentType.JSON);
	}
	
	@Test
	public void ValidateJsonSchemaForAPI2() {
		validateJsonSchema("/search?term=jack+johnson&entity=musicVideo","API2Schema.JSON");
	}
	
	@Test
	public void APIContainsGivenKeyValuePair() {
		validateResponseContains("/search?term=jack+johnson","resultCount","50");
	}
	
	
	
	/**
	 * Function to Validate the API Response code
	 * @param api
	 * @param RespCode
	 */
	private void validateResponseCode(String api, int RespCode) {
		given().
	    when().
	        get(api).
	    then().
	        assertThat().
	        statusCode(RespCode);
	}
	
	/**
	 * Function to validate API Response Type
	 * @param api
	 * @param ContentType type
	 */
	private void validateContentType(String api, ContentType type) {
		given().
	    when().
	        get(api).
	    then().
	        assertThat().
	        contentType(type);
	}
	
	/**
	 * Function to validate json schema of given API
	 * @param api
	 * @param schemaFileName in classpath
	 */
	private void validateJsonSchema(String api,String schemaFileName) {
		given().
		when().
			get(api).
		then().
			assertThat().body(matchesJsonSchemaInClasspath(schemaFileName));
	}
	
	/**
	 * Function to validate if part of response contains given key value pair
	 * @param api
	 * @param key
	 * @param Value
	 */
	private void validateResponseContains(String api,String key, String Value) {
		String ResponseBody =
		given().
		when().
			get(api).getBody().asString();
		
		Assert.assertTrue(ResponseBody.contains(key));
		
		JsonPath json =
		given().
		when().
		get(api).jsonPath();
		
		String value = String.valueOf(json.get(key));
		Assert.assertTrue(value.equalsIgnoreCase(Value));
	}
	
	
}
