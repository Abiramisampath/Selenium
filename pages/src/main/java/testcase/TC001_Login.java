package testcase;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC001_Login extends ProjectSpecificMethods{
	
	@Test
	public void runLogin() {
		// TODO Auto-generated method stub
		
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLogin();
		

	}

}
