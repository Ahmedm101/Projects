package POM_AmazonSprint1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Today_Dealpage {
      WebDriver driver;
	@FindBy(xpath = "(//div[@id='nav-subnav']/descendant::span)[2]") WebElement Coupons;
	
	public void CouponClick () {
		Coupons.click();
	}
   public Today_Dealpage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver,this);
	   
   }
	
	
	
}
