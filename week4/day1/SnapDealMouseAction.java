package week4.day1;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealMouseAction {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver  driver = new ChromeDriver(options);
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement mensFashion= driver.findElementByLinkText("Men's Fashion");
		Actions  builder = new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		driver.findElementByLinkText("Shirts").click();
		
		Thread.sleep(5000);
		
		WebElement quickview = driver.findElementByXPath("(//div[contains(text(),'Quick View')])[1]");
		builder.moveToElement(quickview).perform();
		quickview.click();
		
		File source = quickview.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/snapdeal.png");
		FileUtils.copyFile(source, target);
		
		driver.close();
			
	}

}
