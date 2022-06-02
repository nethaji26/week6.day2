package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead1 extends ProjectSpecificMethods1{
	
	@BeforeTest
	public void setValues()
	{
		
		fileName ="tc001";
	}
	
	@Test(dataProvider="testData")

	public  void createLead(String username, String Password, String cName, String fName, String lName)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
	
}
	/*
	@DataProvider
	public String[][] testData()
	{
		String[][] array = new String[2][5];
		
		array[0][0] = "Demosalesmanager";
		array[0][1] = "crmsfa";
		array[0][2] ="TL";
		array[0][3] ="Hari";
		array[0][4] ="R";
		
		array[1][0] = "Demosalesmanager";
		array[1][1] = "crmsfa";
		array[1][2] ="TL";
		array[1][3] ="Guru";
		array[1][4] ="Ram";
		
		return array;
		
		
	}*/
	
	/*@DataProvider
	public String[][] testData() throws IOException
	{		
		String[][] data = ReadExcelData.readDataFromExcel();
		return data;
		
	}*/
	
	
	
}






