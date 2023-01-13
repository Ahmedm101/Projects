package Utilities_pack;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class Utilities {
      
	public WebDriver driver;
  
  @Parameters({"browser","urladdress"})
  @BeforeClass
  public void BrowserInitialization(String NameOftheBrowser, String Url) {
	  String UD = System.getProperty("user.dir");
	
	if(NameOftheBrowser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",UD+"\\Drivers\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	else if(NameOftheBrowser.equalsIgnoreCase("Edge")) {
		
		System.setProperty("webdriver.edge.driver", UD+"\\Drivers\\msedgedriver.exe");
		driver= new EdgeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}}
  
  @AfterMethod
  public void afterMethod() throws IOException {
	 Screenshot("Amazon");  // how we will be making this available for other folder. As in we need to come and change the name here 
	  
  } 
  

  @AfterClass
  public void afterClass() {
	  driver.quit();    // do we always give close here or ss ??
  }
  
  public void Screenshot(String folder) throws IOException {
	  String UD=System.getProperty("user.dir");
		Date Dateformat = new Date();
		String DATE =Dateformat.toString().replace(":","_").replace(" ","_");
		
		File SS =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(SS,new File(UD+"\\Screenshots\\"+folder+"\\"+DATE+folder+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); }

  }
 
  public void screenshotOfScroll(String folder) throws IOException {
	  String UD=System.getProperty("user.dir");
		Date Dateformat = new Date();
		String DATE =Dateformat.toString().replace(":","_").replace(" ","_");
		
		File SS =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(SS,new File(UD+"\\Screenshots\\"+folder+"\\"+DATE+folder+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); }

  }
}
