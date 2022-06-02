package week6.day2;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods1 {
	public RemoteWebDriver driver; //since we are going to user multiple web browsers here, declaring the remote web driver, as its parent of all browsers driver.
	public  String fileName;
	
	@DataProvider(name ="testData")
	public String[][] testData() throws IOException
	{		
		String[][] data = ReadExcelData.readDataFromExcel(fileName);
		return data;
		
	}
	
	@Parameters({"URL","browserName"})
    @BeforeMethod
	public void startBrowser(String url, String browserName)
	{
if(browserName.equals("Chrome"))
{
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		

	}
else if ( browserName.equals("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	}

driver.get(url);
driver.manage().window().maximize();

	}

	@AfterMethod
	
	public void closebrowser() 
	{
		driver.close();

	}

}
