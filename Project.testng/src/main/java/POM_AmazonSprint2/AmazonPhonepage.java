package POM_AmazonSprint2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPhonepage {

	WebDriver driver;
	
	
	
	
	public AmazonPhonepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}