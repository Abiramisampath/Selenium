package pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class IncidentPage extends ProjectSpecificMethods{
	
	
	
	public IncidentPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public ViewIncidentPage enterIncidentNumberInSearch(String inciNumber) {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//input[@class='form-control'][1]").sendKeys(inciNumber,Keys.ENTER);
		return new ViewIncidentPage(driver, prop);
	}
	
	public ViewIncidentPage enterIncidentIdInSearch() {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//input[@class='form-control'][1]").sendKeys(incidentNumber,Keys.ENTER);
		return new ViewIncidentPage(driver, prop);
	}
	
	/*
	 * public IncidentPage selectFirstIncidentFromList() { // TODO Auto-generated
	 * method stub driver.switchTo().frame("gsft_main"); incidentNumber =
	 * driver.findElementByXPath(
	 * "//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a[1]").getText();
	 * System.out.println(incidentNumber); return this;
	 * 
	 * }
	 */
	
	public ViewIncidentPage searchForIncident(String inciNumber) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(inciNumber,Keys.ENTER);
		return new ViewIncidentPage(driver, prop);

	}
	
}
