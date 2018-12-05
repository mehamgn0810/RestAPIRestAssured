package gettingstarted;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class ValidatingJSONResponseBody {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI = "https://www.metaweather.com";
		
		given().
			param("query", "san").
			
		when().
			get("/api/location/search").
		
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("woeid", equalTo("2487796"));

	}

}
