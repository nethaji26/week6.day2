package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead1 extends ProjectSpecificMethods1 {
	
	
	@Test(dataProvider ="testData")

	public void duplicateLead(String usernmae, String pwd, String phnum) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(usernmae);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider
	public String[][] testData()
	{
		String[][]array1=new String[2][3];
		array1[0][0] = "Demosalesmanager";
		array1[0][1]= "crmsfa";
		array1[0][2] = "9788";
		array1[1][0]= "Demosalesmanager";
		array1[1][1]= "crmsfa";
		array1[1][2]= "91";
		return array1;
		
	}
	
	
	
	
	
}






