package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC003_AssignIncident extends ProjectSpecificMethods  {
	
	@BeforeTest
	public void setFileName() {
		fileName = "ServiceNow_IncidentNumber";
	}

	@Test(dataProvider="sendData")
	public void runAssignIncident(String inciNumber,String notes) throws InterruptedException {
		// TODO Auto-generated method stub
		
		new LoginPage(driver, prop)
		.switchToFrame()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.enterIncidentInFilter()
		.clickOpenLink()
		.searchForIncident(inciNumber)
		.clickOnSearchedIncident(inciNumber)
		.clickAssignGroupLookUp()
		.selectAssignedGroup()
		.enterWorkNotes(notes)
		.clickUpdateButton()
		.enterIncidentNumberInSearch(inciNumber)
		.checkIncidentAssigned();

	}
	
}
