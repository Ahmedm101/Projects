package AmazonTestNG;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Java_Script_Utilities.JS;
import POM_AmazonSprint2.AmazonHomepage2;
import POM_AmazonSprint2.AmazonPhonepage;
import POM_AmazonSprint2.AmazonSellingPage;
import Utilities_pack.Utilities;

public class Sprint2_Amazon extends Utilities {
  @Test(priority=1,groups= {"smoke","regression"})
  public void Test1() {
	String UrlofHomapage=  driver.getCurrentUrl();
	String FrsUrlofHomepage="https://www.amazon.com/";
	SoftAssert ob = new SoftAssert();
	ob.assertEquals(UrlofHomapage, FrsUrlofHomepage);
	String TitleofHomepage =driver.getTitle();
	String FrsTitleofHomepage="Amazon.com. Spend less. Smile more.";
	ob.assertEquals(TitleofHomepage, FrsTitleofHomepage);  // what happends when it is assert we inform to dev ?
	AmazonHomepage2 hp = new AmazonHomepage2(driver);
	hp.AccountandListsClick();
	hp.SellingClick();
	Set <String> SessionIDs = driver.getWindowHandles();
	Iterator<String> it= SessionIDs.iterator();
	String ParentID = it.next();
	String ChildID =it.next();
	driver.switchTo().window(ChildID);
	List<WebElement> allbtn =driver.findElements(By.tagName("div"));
	int buttons =allbtn.size();
	System.out.println(buttons);
	AmazonSellingPage sp = new AmazonSellingPage(driver);
	sp.searchfieldClick("phone");
	// m ---- i did action class here not in action method as I am copying "phone"
	Actions mouse = new Actions(driver);
	 mouse.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
	 mouse.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
	 mouse.keyUp(Keys.CONTROL).build().perform();  
	 sp.searchIconClick();
	
	  ob.assertAll();
	  
  }
  @Test(priority=2,dependsOnMethods = "Test1", groups={"sanity","regression"})
  public void Test2() throws IOException, InterruptedException{
	  WebElement Text=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/child::span)[1]"));
	  String textOfPhonepage= Text.getText();
	  String frsTextOfPhonepage="1-16 of over 10,000 results for";
	  SoftAssert ob =new SoftAssert();
	  ob.assertEquals(textOfPhonepage, frsTextOfPhonepage);
	  
	 List<WebElement> allLink= driver.findElements(By.tagName("a"));
	 for(int i=0;i<allLink.size();i++) {
		System.out.println("the text of the link tags "+allLink.get(i).getText()); 
		System.out.println("the link of the link tags "+allLink.get(i).getAttribute("href"));
	 }
	 //     s----u i did on test method not on POM of Phonepage
    WebElement elementtoview= driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/child::span[@class='a-size-medium a-color-base a-text-normal'])[13]"));
   // i am locating an element but when testing its bordering different one every time I am executing test
    JS.scrollIntoView(driver, elementtoview);
	JS.drawBorder(driver, elementtoview);
	screenshotOfScroll("AmazonScroll");
	Thread.sleep(2000);
	JS.scrollPageDown(driver);
	screenshotOfScroll("AmazonScroll");
	String urlOfPhonePage= driver.getCurrentUrl();
	System.out.println(urlOfPhonePage);
	String frsUrlOfPhonePage="https://www.amazon.com/s?k=";
	// i made the assert purposely wrong, the script is running but fail TestNG report of test2 is not showing
	ob.assertNotEquals(urlOfPhonePage, frsUrlOfPhonePage);
	//    w---y
	//JS.generateAlert(driver, "You're on Phone Page ");  
	//switch to the alert then the driver doesn't work so how can we take a screenshot here
	// here we generated alert with message, does the ok comes automatically
	
	  ob.assertAll();
	  
  }
  @Test(priority=3,dependsOnMethods="Test2", groups= {"sanity","regression"})
  public void Test3() throws InterruptedException {
	  driver.navigate().back();
	  //  bb.  as its on a Test3 method we made Set string again, if it was on Test2 then just switch it to give parentID as string
	  Set<String> SessionIDs=  driver.getWindowHandles();
	  Iterator<String> it= SessionIDs.iterator();
	  String ParentID= it.next();
	  String ChildID = it.next();
	  driver.switchTo().window(ParentID);
	  driver.navigate().refresh();
	  //   dd----ff
	  AmazonHomepage2 hp = new AmazonHomepage2(driver);
	  hp.allClick();
	  hp.HomepagesearchfieldClick();
	  Actions mouse = new Actions(driver);
	  mouse.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
	  mouse.keyUp(Keys.CONTROL).build().perform();
	  hp.allSideMenuClick();
	//  Thread.sleep(2000);
	//  hp.newRealeaseClick();
	  
	  /*is there can be situation close the child-window then close the parent so how we do it with after method
	   here on test close the child and move to the driver to parent and then close the parent with after method */
	  
	  
	  
	  
	  
  }
}
