package RestAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import getterSetterPack.GetterSetterClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPputRequest {
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="http://localhost:9090";
		//RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	}
	
	@Test
	public void putRequestTest() {
		GetterSetterClass gsc=new GetterSetterClass();
		
		gsc.setFirstName("Nafis");
		gsc.setLastName("Hasnain");
		gsc.setEmail("xyz@gmail.com");
		
		RequestSpecification requestspeci=RestAssured.given()
										.body(gsc)
										.when()
										.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.PUT, "/employees/1");
		
		System.out.println("Response body is "+rsp.asString());

}
}
