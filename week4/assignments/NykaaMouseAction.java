package week4.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class NykaaMouseAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		
		//Code to disable the popups on the page
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Instantiating object for ChromeDriver class
		ChromeDriver driver = new ChromeDriver(options);
		
		//Load the application
		driver.get("https://www.nykaa.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Implicit wait to load the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions builder= new Actions(driver);
		
		// Mouseover on Brands
		WebElement brands = driver.findElementByXPath("//li[@class='menu-dropdown-icon']/a");
		builder.moveToElement(brands).perform();
		
		//Mouseover on Popular
		WebElement popular = driver.findElementByXPath("//div[@class='BrandsCategoryHeading']/a[1]");
		builder.moveToElement(popular).perform();
		
		//Click L'Oreal Paris
		driver.findElementByXPath("//ul[@class='l-vertical-list']/li[5]/a").click();
		
		//Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> childWindow = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(childWindow);
		driver.switchTo().window(listWindow.get(1));
		
		System.out.println(driver.getTitle().toString());
		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 */
		
		Thread.sleep(3000);
		
		//Click sort By
		WebElement sortBy=driver.findElementByXPath("//span[@title='POPULARITY']");
		builder.moveToElement(sortBy).click().perform();
		
		//select customer top rated
		driver.findElementByXPath("//div[@id='sortComponent']/div/div/div[2]/div[4]/div/div").click();
		
		//Click Category and click Shampoo
		driver.findElementByXPath("(//div[@class='filter-sidebar__filter-wrap']/div/div[@class='filter-sidebar__filter-title pull-left'])[1]").click();
		driver.findElementByXPath("//span[text()='Hair']").click();
		driver.findElementByXPath("//span[text()='Hair Care']").click();
		driver.findElementByXPath("//label[@for='chk_Shampoo_undefined']//div[1]").click();
		
		//check whether the Filter is applied with Shampoo
		String checkShampoo = driver.findElementByXPath("//div[@class='filter-row']/div/ul/li").getText();
		System.out.println(checkShampoo);
		if(checkShampoo.equals("Shampoo")) {
			System.out.println("Filter is applied with shampoo");
		}
		else
		{
			System.out.println("Incorrect filter");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("//h2[@title=\"L'Oreal Paris Colour Protect Shampoo\"]").click();
		//driver.switchTo().window(listWindow.get(2));
		Set<String> childWindow1 = driver.getWindowHandles();
		List<String> listWindow1 = new ArrayList<String>(childWindow1);
		driver.switchTo().window(listWindow1.get(2));
		
		Thread.sleep(2000);
		
		//select size as 175ml
		driver.findElementByXPath("//span[text()='175ml']").click();
		
		//Print the MRP of the product
		String mrp= driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		System.out.println("MRP of the product is" +mrp);
		
		//Click on ADD to BAG
		driver.findElementByXPath("//div[@class='main-cta-wrap-inner']/div/div/div/button").click();
		
		//Go to Shopping Bag 
		driver.findElementByClassName("AddBagIcon").click();
		
		//Print the Grand Total amount
		String grandTotal =  driver.findElementByXPath("//div[@class='first-col']/div").getText();
		System.out.println(grandTotal);
		
		//Click Proceed
		driver.findElementByXPath("//div[@class='second-col']/button").click();
		
		//Click on Continue as Guest
		driver.findElementByXPath("(//i[@class='proceed-arrow'])[2]/parent::button").click();
		
		//Check the grand total is same
		System.out.println(driver.findElementByXPath("//div[text()='Grand Total']/following-sibling::div").getText());
		
		//close the browser
		driver.quit();
		

	}

}
