package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3CtryFramesAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebElement frameId = driver.findElementById("iframeResult");
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[contains(text(),'Try it')]").click();
		
		Alert alert = driver.switchTo().alert();
		String myName = "abirami";
		alert.sendKeys(myName);
		alert.accept();
		
		String text = driver.findElementById("demo").getText();
		
		if(text.contains(myName)) {
			System.out.println(text);
		}
		driver.switchTo().defaultContent();
		driver.close();
	}

}
