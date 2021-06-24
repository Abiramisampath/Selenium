package week4.assignments;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class MyntraMouseAction {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	ChromeDriverManager.chromedriver().setup();
	
	//Code to disable the popups on the page
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-notifications");
		
	//Instantiating object for ChromeDriver class
		ChromeDriver driver = new ChromeDriver(options);
		
		//Load the application
		driver.get("https://www.myntra.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Implicit wait to load the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Mouse over on WOMEN 
		WebElement women = driver.findElementByXPath("//a[@data-group='women']");
		Actions builder = new Actions(driver);
		builder.moveToElement(women).perform();
		
		//Click Jackets & Coats
		driver.findElementByXPath("//a[@href='/women-jackets-coats']").click();
		//driver.findElementByLinkText("Jackets & Coats").click();
		
		//Fetching the total count of item 
		String jacketcoats = driver.findElementByClassName("title-count").getText().toString();
		String jack =jacketcoats.replaceAll("[^0-9]", "");
		System.out.println(jack);
		int jacketscoatsCount = Integer.parseInt(jack);
		
		//Fetching Count of Jackets
		String jackets=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText().toString();
		String jac =jackets.replaceAll("[^0-9]", "");
		System.out.println(jac);
		int jacketsCount = Integer.parseInt(jac);
		
		//Fetching Count of Coats
		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText().toString();
		String coat =  coats.replaceAll("[^0-9]", "");
		int coatsCount = Integer.parseInt(coat);
		
		//Validating total count
		int totalCount = jacketsCount + coatsCount;
		if(jacketscoatsCount==totalCount) {
			
			System.out.println("The count is validated"+totalCount);
		}
		
		else {
			System.out.println("the count is not matching");
		}
		
		
		//Check Coats
		driver.findElementByXPath("//input[@value='Coats']//parent::label/div").click();
		
		//Click + More option under BRAND
		driver.findElementByClassName("brand-more").click();
		
		//Type MANGO
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		
		//click checkbox
		driver.findElementByXPath("//label[@class=' common-customCheckbox']/div").click();
		
		//Close the pop-up x
		driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']/span").click();
		
		//Fetching all the products brand name
		List<WebElement> brandName = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
		int  sizeOfbrandName = brandName.size();
		System.out.println(sizeOfbrandName);
		
		//Validating all the products to be of brand MANGO
		for(int i=0;i<sizeOfbrandName;i++) {
			
			String checkBrandName = brandName.get(i).getText();
			
			if(checkBrandName.equals("MANGO")) {
				continue;
			}
			else {
				System.out.println("Brand differs"+checkBrandName);
			}
		}
		
		System.out.println("All coats are of MANGO brand");
		
		//Click Sort by
		WebElement sortBy= driver.findElementByXPath("//div[@class='sort-sortBy']");
		builder.moveToElement(sortBy).perform();
		
		//Select Better discount
		WebElement betterDiscount= driver.findElementByXPath("//label[text()='Better Discount']");
		builder.moveToElement(betterDiscount).click().perform();
		
		Thread.sleep(2000);
		
		//fetching the price of first displayed item
		System.out.println("Price of first product in the list is" +driver.findElementByXPath("//span[@class='product-discountedPrice'][1]").getText());
		
		//Mouse over on size of the first item
		WebElement firstProduct = driver.findElementByXPath("(//li[@class='product-base']/a/div[2]/h4)[1]");
		builder.moveToElement(firstProduct).perform();
		
		//Click on WishList Now
		driver.findElementByXPath("//div[@class='product-actions ']/span/span").click();
		
		
		//close the browser
		driver.close();
		
		
	}

}
