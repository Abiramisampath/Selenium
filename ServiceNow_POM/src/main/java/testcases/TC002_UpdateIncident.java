package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	
import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC002_UpdateIncident extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setFileName() {
		fileName = "incidentnumber";
	}
	
	@Test(dataProvider="sendData")
	public void runUpdateIncident(String inciNumber) throws InterruptedException {
		// TODO Auto-generated method stub
		new  LoginPage(driver, prop)
		.switchToFrame()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.enterIncidentInFilter()
		.clickOnIncidentsUnderSelfService()
		.searchForIncident(inciNumber)
		.clickOnSearchedIncident(inciNumber)
		.selectStateAsInProgress()
		.selectUrgencyValueasHigh()
		.clickUpdateButton()
		.enterIncidentNumberInSearch(inciNumber)
		.clickOnIncidentId(inciNumber)
		.checkUpdatedIncident();
	}

}
