package gettingstarted;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidatingJSONResponse {

	@Test
	public void test1() {

		RestAssured.baseURI = "https://www.metaweather.com";

		//@formatter:off
		given().
			param("query", "San Antonio").

		when().
			get("/api/location/search").

		then().
			assertThat().statusCode(200).and(). // validating statusCode
			contentType(ContentType.JSON).and().
			body("woeid", equalTo("2487796")). // validating body
			header("Server", "Google Frontend"); // validating header
		//@formatter:on
	}

}
