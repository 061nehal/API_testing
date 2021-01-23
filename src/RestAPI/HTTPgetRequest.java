package RestAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPgetRequest {

	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="http://localhost:9090";
		//RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	}
	//@Test
	public void getRequestTest() {
		RequestSpecification requestspeci=RestAssured.given()
									.body("")
									.when()
									.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.GET, "/employees");
		
		System.out.println("Response body is "+rsp.asString());
		
		int statusCode=rsp.statusCode();
		
		System.out.println("Status Code is "+statusCode);
		
		
		
		
	}
	
	@Test
	public void getWeatherRequestTest() {
		RequestSpecification requestspeci=RestAssured.given()
									.body("")
									.when()
									.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.GET, "/New York");
		
		System.out.println("Response body is "+rsp.asString());
		
		int statusCode=rsp.statusCode();
		
		System.out.println("Status Code is "+statusCode);
		
		
		
		
	}
	
	
	}
