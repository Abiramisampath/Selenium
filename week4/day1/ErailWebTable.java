package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver  driver = new ChromeDriver();
		
		driver.get("http://erail.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("ms",Keys.TAB);
		
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("mdu",Keys.TAB);
		
		driver.findElementById("chkSelectDateOnly").click();
		
		driver.findElementById("buttonFromTo").click();
		
		Thread.sleep(2000);
		
		List<WebElement> rows= driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		int rowCount = rows.size();
		
		List<String> trainNames = new ArrayList<String>();
		
		for(int i=1;i<=rowCount;i++) {
			
			String trainName = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();
			trainNames.add(trainName);
		}
		
		Set<String> trainNameSet = new HashSet<String>();
		if(trainNames.size()==trainNameSet.size()) {
			System.out.println("No duplicates found");
		}
		else
		{
			System.out.println("duplicate names are there in the train name");
		}
		
		
	}

}
