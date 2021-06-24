package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC001_Login extends ProjectSpecificMethods{
	
	@Test
	public void runLogin() {
		// TODO Auto-generated method stub
		
		new LoginPage(driver,prop)
		.switchToFrame()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.verifyHomePage();
	}

}
