package googleAPI;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractJSONfromResponse {
	
	@BeforeTest
	public void setBaseUri () {

		RestAssured.baseURI = "https://maps.googleapis.com";
	}
	
	@Test
	public void ExtractJSON() throws IOException  {

		RequestSpecification rs=RestAssured
				.given()
				.body("")
				.when()
				.contentType(ContentType.JSON)
				.param("query", "Scarborough")
				.param("key", "AIzaSyBINqV6SmhKubjrvr0XL_bIRP0Yfro9yDY");
		Response resp=rs.request(Method.GET, "/maps/api/place/textsearch/json")
		
				.then()
				.extract()
				.response();
		System.out.println(resp.asString());

}
}