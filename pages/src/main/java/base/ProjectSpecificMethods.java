package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;


public class ProjectSpecificMethods {
	
	public ChromeDriver driver;
	public String fileName;
	
	@BeforeMethod
	public void preCondition() {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void postCondition() {
		// TODO Auto-generated method stub
		driver.close();

	}
	
	@DataProvider
	public String[][] sendData() throws IOException{
		
		
		//String className = this.getClass().getSimpleName();
		ReadExcel re= new ReadExcel();
		String[][] excelData = re.excelData(fileName);
		
		return excelData;
	}

}
