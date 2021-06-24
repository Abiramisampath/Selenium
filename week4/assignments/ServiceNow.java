package week4.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;



/**
 * @author ADMIN
 *
 */
public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		
		//Instantiating object for ChromeDriver class
		ChromeDriver driver = new ChromeDriver();
		
		//Load ServiceNow application https://dev111627.service-now.com/
		driver.get("https://dev111627.service-now.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Implicit wait to load the browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Switching to a frame in the page
		driver.switchTo().frame("gsft_main");
		
		//User login credentials
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		
		
		//Search “incident “ Filter Navigator
		driver.findElementByXPath("//input[@ng-model='filterTextValue']").sendKeys("incident");
		
		//Click “All”
		driver.findElementByXPath("(//div[text()='All'])[2]").click();
		
		//Declaring thread 
		Thread.sleep(3000);
		
		//Switching to a frame in the page
		driver.switchTo().frame(0);
		
		// Click New button and click on caller id
		driver.findElementById("sysverb_new").click();
		driver.findElementById("lookup.incident.caller_id").click();
		
		//Switching to a window from parent window 
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);
		
		//Passing set of window handles to List so that we can use get method 
		List<String> listWindow = new ArrayList<String>(childWindow);
		driver.switchTo().window(listWindow.get(1));
		
		
		//Select a value for Caller
		driver.findElementByXPath("//table/tbody[@class='list2_body']/tr[1]/td[3]/a").click();
		
		//Switch back to parent window
		driver.switchTo().window(listWindow.get(0));
		
		//Switching into frame
		driver.switchTo().frame("gsft_main");
		
		//Enter Short description
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("short description");
		
		//Get Incident Number for reference
		String incidentNumber = driver.findElementById("incident.number").getAttribute("value").toString();
		System.out.println("Incident number is"+incidentNumber);
		
		//Click Submit button at the top
		driver.findElementByXPath("//span[@class='navbar_ui_actions']/button").click();
		
		//Enter the incident number got as reference. import org.openqa.selenium.Keys for Keys.Enter
		driver.findElementByXPath("//input[@class='form-control'][1]").sendKeys(incidentNumber,Keys.ENTER);
		
		//Getting value of incident number
		String incNumber = driver.findElementByXPath("//table[@id='table_clone']").getAttribute("query").toString();
		
		if(incNumber.contains(incidentNumber)) {
			System.out.println("Fetched correct incident number");
		}
		else {
			System.out.println("Incorrect incident number");
		}
		
		//Close the browser window
		driver.close();

	}

}
