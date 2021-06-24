package testcase;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;


public class TC002_CreateLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setFileName() {
		// TODO Auto-generated method stub
		fileName="CreateLead";

	}
	
	@Test(dataProvider="sendData")
	public void runCreateLead(String companyName,String fName,String lName,String phNumber) {
		//nameof the parameters can be anything but should maintain order
		
		new LoginPage(driver)
		.enterUserName()
		.enterUserName()
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.enterPhoneNumber(phNumber)
		.clickCreateLeadButton()
		.verifyFirstName();
			

	}

}
