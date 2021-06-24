package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public MyHomePage clickCrmsfa() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);

	}
	
}
