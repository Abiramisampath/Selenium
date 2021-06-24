package week4.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		
		//Instantiating object for ChromeDriver class
		ChromeDriver driver = new ChromeDriver();
		
		//Load Leaftaps application
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Implicit wait to load the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//User login credentials
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click on contacts Button
		driver.findElementByLinkText("Contacts").click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		
		//Click on Widget of From Contact
		driver.findElementByXPath("//table[@class='twoColumnForm']//tr/td[2]/a").click();
		
		Set<String> childWindow = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(childWindow);
		driver.switchTo().window(listWindow.get(1));
		
		//Click on First Resulting Contact
		driver.findElementByXPath("(//table[@class='x-grid3-row-table']//tr[1]/td[1]/div/a)[1]").click();
		driver.switchTo().window(listWindow.get(0));
		
		//Click on Widget of To Contact
		driver.findElementByXPath("//table[@class='twoColumnForm']//tr[2]/td[2]/a").click();
		Set<String> childWindow1 = driver.getWindowHandles();
		List<String> listWindow1 = new ArrayList<String>(childWindow1);
		driver.switchTo().window(listWindow1.get(1));
		
		//Click on Second Resulting Contact
		driver.findElementByXPath("//table[@class='x-grid3-row-table']/following::table/tbody[1]/tr[1]/td[1]/div[1]/a[1]").click();
		driver.switchTo().window(listWindow1.get(0));
		
		//Click on Merge button using Xpath Locator
		driver.findElementByXPath("//table[@class='twoColumnForm']//tr[4]/td/a").click();
		
		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify the title of the page
		String pageTitle = driver.findElementById("sectionHeaderTitle_contacts").getText();
		System.out.println(pageTitle);
		if(pageTitle.equals("View Contact")) {
			System.out.println("Page Title is"+pageTitle);
		}
		else
		{
			System.out.println("Incorrect page title");
		}
		
		//close the browser
		driver.close();

	}

}
