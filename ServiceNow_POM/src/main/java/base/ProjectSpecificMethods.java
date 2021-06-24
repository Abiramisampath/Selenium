package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LookupWindowPage;
import utils.ReadExcel;

public class ProjectSpecificMethods {
	
	public ChromeDriver driver;
	public Properties prop;
	public static String incidentNumber;
	public String fileName;
	Set<String> childWindow;
	List<String> listWindow;
	
	public void startReport() {
		// TODO Auto-generated method stub

	}
	
	
	@BeforeMethod
	public void preCondition() throws IOException {
	// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
		prop=new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void postCondition() {
		// TODO Auto-generated method stub
		
		driver.close();

	}
	
	public void switchToWindow() {
		// TODO Auto-generated method stub
		childWindow = driver.getWindowHandles();
		System.out.println(childWindow);
		listWindow = new ArrayList<String>(childWindow);
		driver.switchTo().window(listWindow.get(1));
	}
	
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		driver.switchTo().window(listWindow.get(0));
	}
	
	@DataProvider
	public String[][] sendData() throws IOException{
				
		//String className = this.getClass().getSimpleName();
		ReadExcel re= new ReadExcel();
		String[][] excelData = re.excelData(fileName);
		return excelData;
	}
}
