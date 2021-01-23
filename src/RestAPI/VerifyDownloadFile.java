package RestAPI;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class VerifyDownloadFile {
	
	@Test
	public void verifyFileDownload() {
		int fileSize;
		File filePath=new File(System.getProperty("user.dir")+"/downloadFile//rest-assured-3.0.5-dist.zip");
		fileSize=(int)filePath.length();
		System.out.println("File Size "+fileSize);
		 byte [] expectedValue =given ()
			     .get("http://dl.bintray.com/johanhaleby/generic/rest-assured-3.0.5-dist.zip")
			     .asByteArray();
			   
			     System.out.println("The expected value is "+expectedValue.length);

			   Assert.assertEquals(fileSize, expectedValue.length); 
	}

}
