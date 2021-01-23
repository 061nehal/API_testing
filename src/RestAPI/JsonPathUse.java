package RestAPI;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import getterSetterPack.GetterSetterClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonPathUse {

	@BeforeTest
	public void setUp() {
		//RestAssured.baseURI="http://localhost:9090";
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	}

	//@Test
	public void jsonPathTest1() {


		RequestSpecification requestspeci=RestAssured.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.GET, "/employees");

		JsonPath jp=rsp.jsonPath();
		List<String>allFN=jp.getList("firstName");

		for(String afn: allFN) {
			System.out.println("First Name are: "+afn);

		}

		//System.out.println("Response body is "+rsp.asString());

	}
	//@Test
	public void jsonPathTest2() {


		RequestSpecification requestspeci=RestAssured.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.GET, "/employees");

		JsonPath jp=rsp.jsonPath();

		List<GetterSetterClass>allData=jp.getList("", GetterSetterClass.class );

		for(GetterSetterClass data: allData) {
			System.out.println("First Name are: ");
			System.out.println(data.getFirstName());
			System.out.println("Last Name are: ");
			System.out.println(data.getLastName());
		}

	}

	//@Test
	public void jsonPathTest3() {


		RequestSpecification requestspeci=RestAssured.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.GET, "/employees");

		JsonPath jp=rsp.jsonPath();
		System.out.println("IDs are: "+jp.get("id"));
		System.out.println("First Names are: "+jp.get("firstName"));
		System.out.println("Last Names are: "+jp.get("lastName"));
		System.out.println("Emails are: "+jp.get("email"));

	}

	@Test
	public void jsonPathWeather() {


		RequestSpecification requestspeci=RestAssured.given()
				.body("")
				.when()
				.contentType(ContentType.JSON);
		Response rsp=requestspeci.request(Method.GET, "/New York");

		JsonPath jp=rsp.jsonPath();
		System.out.println("City : "+jp.get("City"));
		System.out.println("Temparature is:"+jp.get("Temperature"));
		System.out.println("Humidity is: "+jp.get("Humidity"));
		System.out.println("Wind speed is: "+jp.get("WindSpeed"));

	}
}