package basicstoolsqa;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unchecked")
public class SimplePOSTTest {
	
	@Test(enabled=true)
	public void postTest() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a simple
		// JSON. We can add Key - Value pairs using the put method
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "John");
		requestParams.put("LastName", "Smith");
		requestParams.put("UserName", "JS0811");
		requestParams.put("Password", "test@abc");
		requestParams.put("Email", "test@abc.com");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		
		// Post the request and check the response
		Response response = request.post("/register");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Success Code does not match");
		
	}
	
	@Test(enabled=false)
	public void invalidPOSTTest() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a simple
		// JSON. We can add Key - Value pairs using the put method
		
		JSONObject requestParams = new JSONObject ();
		requestParams.put("FirstName", "Mehavarnan");
		requestParams.put("LastName", "Murugan");
		requestParams.put("UserName", "MEHAMGN0810");
		requestParams.put("Password", "test@123");
		requestParams.put("Email", "test@email.com");
		
		request.header("Content-Type", "application/json");
		
		request.body(requestParams.toJSONString());
		
		// sending GET instead of POST for a post request
		Response response = request.get("/register");
		
		
		String body = response.asString();
		System.out.println(body);
		
	}
}
