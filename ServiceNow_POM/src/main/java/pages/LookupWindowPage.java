package pages;


import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class LookupWindowPage extends ProjectSpecificMethods {
	
	
	
	public LookupWindowPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	//ProjectSpecificMethods psm=new ProjectSpecificMethods();

	public CreateIncidentPage selectFirstCaller() throws InterruptedException {
		// TODO Auto-generated method stub
		switchToWindow();
		Select ddSearchFor= new Select(driver.findElementByXPath("//select"));
		ddSearchFor.selectByValue("name");
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys("sa",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElementByXPath("//table/tbody[@class='list2_body']/tr[1]/td[3]/a").click();
		switchToParentWindow();
		return new CreateIncidentPage(driver, prop);

	}
	
	public UpdateIncidentPage selectAssignedGroup() throws InterruptedException {
		// TODO Auto-generated method stub
		switchToWindow();
		Select ddSearchFor= new Select(driver.findElementByXPath("//select"));
		ddSearchFor.selectByValue("name");
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys("sa",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElementByXPath("//a[text()='Software']").click();
		switchToParentWindow();
		return new UpdateIncidentPage(driver, prop);
	}
}
