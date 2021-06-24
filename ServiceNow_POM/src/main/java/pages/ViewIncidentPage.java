package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class ViewIncidentPage extends ProjectSpecificMethods{
	
	public ViewIncidentPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	String incNumber;
	String incidentId;
	
	public ViewIncidentPage getIncidentNumberFromList() {
		// TODO Auto-generated method stub
		incNumber=driver.findElementByXPath("//table[@id='table_clone']").getAttribute("query").toString();
		return this;

	}
	
	public ViewIncidentPage checkIncidentCreated() {
		// TODO Auto-generated method stub
		if(incNumber.contains(incidentNumber)) {
			System.out.println("Fetched correct incident number");
		}
		else {
			System.out.println("Incorrect incident number");
		}
		return this;

	}
	
	public UpdateIncidentPage clickOnSearchedIncident(String inciNumber) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		incidentId= driver.findElementByXPath("(//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a)[1]").getText();
		if(incidentId.contains(inciNumber)) {
			driver.findElementByXPath("(//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a)[1]").click();
		}
		else
		{
			System.out.println("Incident number not listed");
		}
		return new UpdateIncidentPage(driver,prop);

	}
	
	public ViewIncidentPage clickOnIncidentId(String inciNumber) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		incidentId= driver.findElementByXPath("(//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a)[1]").getText();
		if(incidentId.contains(inciNumber)) {
			driver.findElementByXPath("(//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a)[1]").click();
		}
		else
		{
			System.out.println("Incident number not listed");
		}
		return this;
	}
	
	public ViewIncidentPage checkUpdatedIncident() {
		// TODO Auto-generated method stub
		String urgency=driver.findElementByXPath("//table[@id='incident_table']/tbody[1]/tr[1]/td[6]").getText();
		String state=driver.findElementByXPath("//table[@id='incident_table']/tbody[1]/tr[1]/td[9]").getText();
		if(urgency.contains("Moderate") && state.contains("Progress")) {
			System.out.println("Incident updated successfully");
		}
		else
		{
			System.out.println("Incident is not updated");
		}
		
		return this;

	}
	
	public ViewIncidentPage checkIncidentAssigned() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		String assignedGroup=driver.findElementByXPath("//table[@id='incident_table']/tbody[1]/tr[1]/td[10]/a[1]").getText();
		System.out.println(assignedGroup);
		String assignedTo=driver.findElementByXPath("//table[@id='incident_table']/tbody[1]/tr[1]/td[11]/a[1]").getText();
		System.out.println(assignedTo);
		if(assignedGroup.contains("Software") || assignedTo.contains("ITIL User")) {
			System.out.println("Incident assigned successfully");
		}
		else
		{
			System.out.println("Incident is not updated");
		}
		
		return this;

	}

}
