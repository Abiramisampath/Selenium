package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setting up the driver
		WebDriverManager.chromedriver().setup();
		
		//creating object for chromedriver
		ChromeDriver driver = new ChromeDriver();
		
		//passing URL
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//passing search value as Perfume
		driver.findElementByName("search-suggestions-nykaa").sendKeys("Perfumes",Keys.ENTER);
		//driver.findElementByName("search-suggestions-nykaa").sendKeys(Keys.ENTER);
		
		//String perfName= driver.findElementByClassName("m-content__product-list__title").toString();
		
		//Getting all the perfume names listed in the page and printing it
		List<WebElement> perfumeName = driver.findElementsByClassName("m-content__product-list__title");
		int prosize = perfumeName.size();
		System.out.println(prosize);
		//List<WebElement> name = new ArrayList<WebElement>();
		for(int i=0;i<perfumeName.size();i++) {
			
			String name = perfumeName.get(i).getText();
			System.out.println(name);
			
		}
		
		//Getting all the perfume prices listed and printing it
		List<WebElement> perfumePrice = driver.findElementsByClassName("post-card__content-price-offer");
		int promsize = perfumeName.size();
		System.out.println(promsize);
		//List<WebElement> name = new ArrayList<WebElement>();
		for(int i=0;i<perfumePrice.size();i++) {
			
			String name = perfumePrice.get(i).getText();
			System.out.println(name);
			
		}
		
		//selecting one perfume from the list
		driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[2]").click();
		
		//redirecting to next page.so created object for window 
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);
		List<String> listWindow = new ArrayList<String>(childWindow);
		driver.switchTo().window(listWindow.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
		//driver.switchTo().window(listWindow.get(0));
		
		
		driver.findElementById("SearchInputBox").sendKeys("Sunglasses",Keys.ENTER);
		
		List<WebElement> sunglassNames = driver.findElementsByClassName("m-content__product-list__title");
		prosize = sunglassNames.size();
		System.out.println(prosize);
		//List<WebElement> name = new ArrayList<WebElement>();
		for(int i=0;i<sunglassNames.size();i++) {
			
			String name = sunglassNames.get(i).getText();
			System.out.println(name);
			
		}
		
		driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[2]").click();
		Set<String> childWindow1 = driver.getWindowHandles();
		System.out.println(childWindow1);
		List<String> listWindow1 = new ArrayList<String>(childWindow1);
		driver.switchTo().window(listWindow1.get(2));
		System.out.println(driver.getCurrentUrl());
		driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
		
		driver.findElementByClassName("AddBagIcon").click();
		
		driver.findElementByXPath("//div[@class='fixrow']/div[2]/button").click();
		
		String grandTotal = driver.findElementByXPath("//div[@class='shipping-items-details-section']/div[2]/div[2]/div[@class='value']").getText();
		System.out.println("Grand Total is "+grandTotal);
		
		driver.close();
	}

	
}
