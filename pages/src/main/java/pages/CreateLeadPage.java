package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods{
	
	public CreateLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CreateLeadPage enterCompanyName(String companyName) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		return this;

	}
	
	public CreateLeadPage enterFirstName(String firstName) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		return this;

	}

	public CreateLeadPage enterLastName(String lastName) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;

	}
	
	public CreateLeadPage enterPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
		return this;

	}
	
	public ViewLeadPage clickCreateLeadButton() {
		// TODO Auto-generated method stub
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);

	}
}
