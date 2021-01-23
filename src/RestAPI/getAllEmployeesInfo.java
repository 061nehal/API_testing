package RestAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePack.baseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class getAllEmployeesInfo extends baseClass {
	
	@BeforeClass
	public void getAllEmployess() {
		logger.info("=======getAllEmployeesInfo========");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET, "/employees");
	}
	
	@Test
	public void checkResponseBody() {
		
		logger.info("********Checking Response Body*********");
		String responseBody=response.getBody().asString();
		logger.info("Response Body: "+responseBody );
		Assert.assertTrue(responseBody !=null);
	}
	
	@Test
	public void checkStatusCode() {
		
		logger.info("********Checking Status Code********");
		int statusCode=response.getStatusCode();
		logger.info("Status Code: "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void checkStatusLine() {
		
		logger.info("********Chekcing Status Line********");
		String statusLine=response.getStatusLine();
		logger.info("Status Line: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	

}
