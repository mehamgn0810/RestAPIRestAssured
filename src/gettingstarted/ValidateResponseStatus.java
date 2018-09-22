package gettingstarted;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseStatus {
	
	@Test(enabled = false)
	public void validateStatusCode_valid() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have received from the server
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200, "Status not 200");

	}
	
	@Test(enabled = false)
	public void validateStatusCode_inValid() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "789456123");

		// Now let us print the body of the message to see what response
		// we have received from the server
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200, "Status not as expected");

	}
	
	@Test(enabled = true)
	public void validateStatusLine() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have received from the server
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "StatusLine not as expected");

	}
}
