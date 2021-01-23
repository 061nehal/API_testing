package RestAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class checkBrokenLink {
	
	WebDriver driver;
	
	@Test
	public void checkBrokenLinkTest()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nehal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("file:///D:/ITTraining/WebSite/SuperTech.html");
		driver.get("https://www.facebook.com/");
		
		List<String>hrefs=new ArrayList<String>();
		List<WebElement>links=driver.findElements(By.tagName("a"));
		
		for (WebElement link:links) {
			if (link.getAttribute("href")!=null) {
				hrefs.add(link.getAttribute("href"));
			}
			
		}
		for(String href:hrefs) {
			try {
				int responseCode=returnStatusCode(new URL(href));
				if(responseCode!=200) {
					System.out.println("The Broken links --->" +href);
				}
				else {
					System.out.println("The Working links---->" +href);
				}
			} catch (Exception e) {
				
				System.out.println("URL: "+href+"Return "+e.getMessage());
			}
			
		}
	}
	public int returnStatusCode(URL url) {
		Response resp=RestAssured
				.given()
				.get(url);
		return resp.getStatusCode();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
