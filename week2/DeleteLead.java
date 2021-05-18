package week2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * Delete Lead: 1 Launch the browser 
		 * 2 Enter the username 
		 * 3 Enter the password 
		 * 4 Click Login 
		 * 5 Click crm/sfa link 
		 * 6 Click Leads link 
		 * 7 Click Find leads 
		 * 8 Click on Phone 
		 * 9 Enter phone number 
		 * 10 Click find leads button 
		 * 11 Capture lead ID of First Resulting lead 
		 * 12 Click First Resulting lead 
		 * 13 Click Delete
		 * 14 Click Find leads 
		 * 15 Enter captured lead ID 
		 * 16 Click find leads button 
		 * 17 Verify message "No records to display" in the Lead List. This message
		 * confirms the successful deletion 18 Close the browser (Do not log out)
		 */
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		String message = "No records to display";
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		
		//driver.findElementByName("phoneCountryCode").sendKeys("1");
		//driver.findElementByName("phoneAreaCode").sendKeys("9");
		driver.findElementByName("phoneNumber").sendKeys("999999999");
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		String leadId =driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]").getText().toString();
		driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]").click();
		driver.findElementByClassName("subMenuButtonDangerous").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input").sendKeys(leadId);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElementByClassName("x-paging-info").getText().toString();
		
		if(message.equalsIgnoreCase(text)) {
			System.out.println("Deleted"+text);
		}
		
		else
		{
			System.out.println("record not deleted");
		}
		
		
		
	}

}
