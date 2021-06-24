package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage enterUserName() {
		
		// TODO Auto-generated method stub
		driver.findElementById("username").sendKeys("DemoSalesManager");
		return this;

	}
	
	public LoginPage enterPassword() {
		// TODO Auto-generated method stub
		driver.findElementById("password").sendKeys("crmsfa");
		return this;
	}
	
	public HomePage clickLogin() {
		// TODO Auto-generated method stub
		driver.findElementByClassName("decorativeSubmit").click();
		return new HomePage(driver);

	}

}
