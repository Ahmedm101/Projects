package AmazonTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_AmazonSprint1.AmazonHomepage;
import POM_AmazonSprint1.ComputerPage;
import POM_AmazonSprint1.SellPage;
import POM_AmazonSprint1.Today_Dealpage;
import Utilities_pack.Utilities;

public class Sprint1_Amazon extends Utilities {
	
  @Test
  public void Test1() {
	  
	  AmazonHomepage hp = new AmazonHomepage(driver);
	  hp.SearchFieldClick("computer");
	  Actions mouse = new Actions(driver);
	  mouse.sendKeys(Keys.ENTER).build().perform();
	  ComputerPage cp= new ComputerPage(driver);
	 WebElement text_Computerresult= driver.findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']>span:first-of-type"));
	  SoftAssert ob = new SoftAssert();
	  String textofComputerresult =text_Computerresult.getText();
	  String textofComputerresultOnFrs ="9000";
	  ob.assertEquals(textofComputerresult, textofComputerresultOnFrs);
	  cp.SellClick();
	  SellPage sp = new SellPage(driver);
	WebElement TextonSellpage= driver.findElement(By.cssSelector("div[class='has-max-width']>div>h1"));
	  String TextofSellpage =TextonSellpage.getText();
	  String TextofSellpageFRS ="Sell on Amazon 1";
	  ob.assertEquals(TextofSellpage, TextofSellpageFRS);
      sp.TodaysDealClick();
      Today_Dealpage td= new Today_Dealpage(driver);
      td.CouponClick();
	 
	  ob.assertAll();
	  
  }
}
