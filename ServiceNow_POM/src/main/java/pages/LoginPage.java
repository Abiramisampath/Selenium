package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	public LoginPage(ChromeDriver driver,Properties prop) {
		
		this.driver=driver;
		this.prop=prop;
	}
	
	public LoginPage switchToFrame() {
		// TODO Auto-generated method stub
		driver.switchTo().frame("gsft_main");
		return this;

	}
	
	public LoginPage enterUsername() {
		
		driver.findElementById("user_name").sendKeys(prop.getProperty("username"));
		return this;
		
	}
	
	public LoginPage enterPassword() {
		// TODO Auto-generated method stub
		driver.findElementById("user_password").sendKeys(prop.getProperty("password"));
		return this;

	}
	
	public HomePage clickLoginButton() {
		// TODO Auto-generated method stub
		driver.findElementById("sysverb_login").click();
		return new HomePage(driver,prop);

	}

}
