package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC001_CreateNewIncident extends ProjectSpecificMethods {
	
		
	@Test
	public void runCreateNewIncident() throws InterruptedException {
		// TODO Auto-generated method stub
		
		new LoginPage(driver,prop)
		.switchToFrame()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.enterIncidentInFilter()
		.clickCreateNewLink()
		.switchToFrame()
		.clickCallerLookupIcon()
		.selectFirstCaller()
		.switchToFrame()
		.enterShortDescription()
		.getIncidentNumber()
		.clickSubmitButton()
		.enterIncidentIdInSearch()
		.getIncidentNumberFromList()
		.checkIncidentCreated();
	}

}
