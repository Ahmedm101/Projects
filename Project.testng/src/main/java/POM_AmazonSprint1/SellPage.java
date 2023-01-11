package POM_AmazonSprint1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class SellPage {
  WebDriver driver;
  
 
  @FindBy(xpath = "(//a[text()='Amazon Basics']/following-sibling::a)[1]") WebElement Todays_Deal;
  
 
  public void TodaysDealClick() {
	  Todays_Deal.click();
  }
  public SellPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
}
