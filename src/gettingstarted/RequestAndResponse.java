package gettingstarted;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RequestAndResponse {
	
	//GetBookByID

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		given().
			param("ID", "bczd227").
		
		//Request
		when().
			get("/Library/GetBook.php").
		
		/**
		 * Response
		 * Asserting Status and Header
		 */
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON);

	}

}
