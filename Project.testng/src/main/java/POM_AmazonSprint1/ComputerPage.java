package POM_AmazonSprint1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ComputerPage {
	WebDriver driver;  // should we make this default 
	
	@FindBy(xpath = "//a[text()='Sell']") WebElement Sell;
	
	
	public void SellClick() {
		Sell.click();
	}
	public ComputerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
