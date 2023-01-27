package POM_AmazonSprint2;

import java.util.List;

import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AmazonPhonepage {

  public	WebDriver driver;
	
  @FindBy(xpath="\"(//div[@class='a-section a-spacing-small a-spacing-top-small']/child::span)[1]\"") WebElement PhoneText;
 
  
  public void phoneTextVerify() {
	  SoftAssert ob = new SoftAssert();
	 String text = PhoneText.getText();
	  String FRS = "100000";
	  ob.assertEquals(text, FRS, "according to FRS text should be 10000");
	  ob.assertTrue(text.contains(FRS), "message");
	  ob.assertAll();
  }
	
	
	
	public AmazonPhonepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
