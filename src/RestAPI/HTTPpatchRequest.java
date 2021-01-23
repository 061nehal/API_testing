package RestAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import getterSetterPack.GetterSetterClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPpatchRequest {

	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="http://localhost:9090";
		//RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	}
	
	@Test
	public void patchRequestTest() {
		GetterSetterClass gsc=new GetterSetterClass();
		
		
		gsc.setEmail("newemail@gmail.com");
		
		RequestSpecification requestspeci=RestAssured.given()
										.body(gsc)
										.when()
										.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.PATCH, "/employees/2");
		
		System.out.println("Response body is "+rsp.asString());

}
}

