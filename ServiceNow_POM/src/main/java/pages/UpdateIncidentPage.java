package pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class UpdateIncidentPage extends ProjectSpecificMethods {
	
	
	
	public UpdateIncidentPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public UpdateIncidentPage selectUrgencyValueasHigh() {
		// TODO Auto-generated method stub
		Select ddUrgency =new Select(driver.findElementById("incident.urgency"));
		ddUrgency.selectByVisibleText("1 - High");
		return this;

	}
	
	public UpdateIncidentPage selectStateAsInProgress() {
		// TODO Auto-generated method stub
		Select ddState =new Select(driver.findElementById("incident.state"));
		ddState.selectByVisibleText("In Progress");		
		return this;
	}
	
	public IncidentPage clickUpdateButton() {
		// TODO Auto-generated method stub
		driver.findElementByXPath("//button[@id='sysverb_update']").click();
		return new IncidentPage(driver, prop);

	}
	
	public LookupWindowPage clickAssignGroupLookUp() {
		// TODO Auto-generated method stub
		driver.findElementById("lookup.incident.assignment_group").click();
		return new LookupWindowPage(driver,prop);

	}
	
	public UpdateIncidentPage enterWorkNotes(String notes) {
		// TODO Auto-generated method stub
		driver.switchTo().frame("gsft_main");
		Actions builder = new Actions(driver);
		WebElement note=driver.findElementByXPath("//textarea[@id='activity-stream-textarea']");
		builder.moveToElement(note).click().perform();
		builder.moveToElement(note).sendKeys(notes,Keys.ENTER).perform();
		return this;
	}

}
