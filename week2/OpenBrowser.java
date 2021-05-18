package week2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1: to set up driver
		WebDriverManager.chromedriver().setup();
		
		//Step 2: Open chromeDriver and create object for ChromeDriver
		ChromeDriver  driver = new ChromeDriver();
		
		//Step 3: Load the application URL
		driver.get("http://leaftaps.com/opentaps/control/main");
				
		//Step 4: to maximize the window
		driver.manage().window().maximize();
		
		//Step 5: to close the current browser
		driver.close();
	

	}

}
