package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
	
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		
		driver.findElementById("firstNameField").sendKeys("Guruu");
		driver.findElementById("lastNameField").sendKeys("Kuloo");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Guruji");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Kuloth");
		driver.findElementById("createContactForm_departmentName").sendKeys("HR");
		driver.findElementById("createContactForm_description").sendKeys("working in Human Resource  Team");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("guru.kulo@gmail.com");
		
		WebElement state = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select dd = new Select(state);
		dd.selectByVisibleText("New York");
		//Select dd = new Select(driver.findElementById("createContactForm_generalStateProvinceGeoId")).selectByVisibleText("NewYork");
		
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		
		driver.findElementByLinkText("Edit").click();
		
		driver.findElementById("updateContactForm_description").clear();
		driver.findElementById("updateContactForm_importantNote").sendKeys("notes recently updated");
		driver.findElementByXPath("//input[@value='Update']").click();
	
		System.out.println(driver.getTitle());
		
		
		
		//driver.close();

	}

}
