package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	public HomePage(ChromeDriver driver,Properties prop) {
		
		this.driver=driver;
		this.prop=prop;
	
	}
	
	public HomePage verifyHomePage() {
			// TODO Auto-generated method stub
		System.out.println("HomePage displayed");
		return this;

	}
	
	public HomePage enterIncidentInFilter() {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath("//input[@ng-model='filterTextValue']").sendKeys("incident");
		return this;
		

	}
	
	public IncidentPage enterIncidentInFilters() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//input[@ng-model='filterTextValue']").sendKeys("incident");
		Thread.sleep(1000);
		return new IncidentPage(driver, prop);
	}
	
	public CreateIncidentPage clickCreateNewLink() {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath("//li[@id='concourse_module_14641d70c611228501114133b3cc88a1']/div/div/a/div/div").click();
		return new CreateIncidentPage(driver, prop);

	}
	
	public IncidentPage clickOnIncidentsUnderSelfService() {
		driver.findElementByXPath("(//div[text()='Open'])[1]").click();
		return new IncidentPage(driver, prop);
	}
	
	public IncidentPage clickOpenLink() {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//div[text()='Open']").click();
		return new IncidentPage(driver, prop);

	}
}
