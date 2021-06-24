package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateIncidentPage extends ProjectSpecificMethods{
	
	public CreateIncidentPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	//public static String incidentNumber;
	
	public CreateIncidentPage switchToFrame() {
		// TODO Auto-generated method stub
		driver.switchTo().frame("gsft_main");
		return this;

	}
	
	public CreateIncidentPage getIncidentNumber() {
		// TODO Auto-generated method stub
		incidentNumber = driver.findElementById("incident.number").getAttribute("value").toString();
		System.out.println("CreateIncident"+incidentNumber);
		return this;
	}
	
	public LookupWindowPage clickCallerLookupIcon() {
		// TODO Auto-generated method stub
		driver.findElementById("lookup.incident.caller_id").click();
		return new LookupWindowPage(driver,prop);
	}
	
	public CreateIncidentPage enterShortDescription() {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("short description");
		return this;
	}
	
	public IncidentPage clickSubmitButton() {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//span[@class='navbar_ui_actions']/button").click();
		return new IncidentPage(driver, prop);

	}
	
}
