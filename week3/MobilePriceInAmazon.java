package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.util.Pair;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePriceInAmazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("twotabsearchtextbox").sendKeys("Redmi Mobiles",Keys.ENTER);
		driver.findElementById("nav-search-submit-button").click();
		
		//List<WebElement> mobiles = driver.findElementsByXPath("//div[@data-component-type='s-search-result']");
		List<WebElement> mobileName = driver.findElementsByXPath("//div[@class='sg-col-inner']/div/h2/a/span");
		List<WebElement> mobilePrice = driver.findElementsByXPath("//div[@class='sg-col-inner']/div/div/a/span/span/span[@class='a-price-whole']");
		Thread.sleep(2000);
		  int noOfElements=mobileName.size(); 
		  System.out.println("noof mobile names"+noOfElements);
		/*
		 * if(mobileName.size()==mobilePrice.size()) { noOfElements = mobileName.size();
		 * System.out.println(noOfElements); }
		 */
		  int  noOfMobilePrice = mobilePrice.size();
		  System.out.println("mobile price size="+noOfMobilePrice);
		  //System.out.println(mobiles.size());
		
	/*	  for(int i=0;i<noOfElements;i++) {
		  
		  System.out.println(mobileName.get(i).getText()); }
		 
		
		
		for(int i=0;i<mobilePrice.size();i++) {
			System.out.println(mobilePrice.get(i).getText());
		*/
	int costliestprice=0;
	for(int i=0;i<mobileName.size();i++) {
		//System.out.println(mobileName.get(i).getText()+"\t"+mobilePrice.get(i).getText());
		String mobname =mobileName.get(i).getText().toString();
		String numbers=mobilePrice.get(i).getText().toString().replace(",", "");
		if(numbers.isEmpty()) {
			continue;
			
		}
		else
		{
		int price = Integer.parseInt(numbers);
		
		
		
		
		HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
		hash_map.put(mobname, price);
		
		System.out.println(hash_map);
		
		//int  maxValueInMap = Collections.max(hash_map.values());
		Map.Entry<String, Integer> maxValueInMap = null;
		
		for (Entry<String, Integer> entry : hash_map.entrySet()) {
			
					/*
					 * if (entry.getValue()==maxValueInMap) { System.out.println(entry.getKey()); //
					 * Print the key with max value }
					 */
			
			if(maxValueInMap==null || entry.getValue().compareTo(maxValueInMap.getValue())>0) {
				maxValueInMap=entry;
		}
			System.out.println(maxValueInMap);
						
		}
		}
	}
	}
}

