package gettingstarted;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class ValidatingJSONResponseBody {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.itbook.store";
		
		given().
			param("key", "qaclick123");

	}

}
