package POM_AmazonSprint1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomepage {
	
	WebDriver driver;
	

	@FindBy(css = "#twotabsearchtextbox") WebElement SearchField;
	
	public void SearchFieldClick(String items) {
		SearchField.click();
		SearchField.clear();
		SearchField.sendKeys(items);
	}
	
	public void locateand_print_all_divs() {

	}
	
	
	
	public AmazonHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	


}
