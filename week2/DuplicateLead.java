package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*http://leaftaps.com/opentaps/control/main
		 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)
		
		*/
		
		WebDriverManager.chromedriver().setup();
	
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	
		String title ="Duplicate Lead";
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("abg@gm.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(5000);
		driver.findElementByXPath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[1]").click();
		String leadName=driver.findElementById("viewLead_firstName_sp").getText();
		driver.findElementByLinkText("Duplicate Lead").click();
		
		String pageTitle = driver.getTitle().toString();
		if(title.equals(pageTitle)) {
			
			System.out.println("Title verified"+pageTitle);
		}
		
		else
			System.out.println("different page");
		
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		
		String duplicateLeadName = driver.findElementById("viewLead_firstName_sp").getText().toString();
		if(leadName.equals(duplicateLeadName)) {
			System.out.println("Name matched"+duplicateLeadName);
		}
		else
		{
			System.out.println("not matched");
		}
	
	}

}
