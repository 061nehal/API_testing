package basePack;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class baseClass {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public  String empID="";
	public Logger logger;
	
	@BeforeTest
	public void setUp()
	{
		logger=Logger.getLogger("APITesting");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

}
