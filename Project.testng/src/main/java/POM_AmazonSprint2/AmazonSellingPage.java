package POM_AmazonSprint2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSellingPage {
	
     WebDriver driver;
     
     @FindBy(css ="#twotabsearchtextbox") WebElement Searchfield;
     @FindBy(css="#nav-search-submit-button") WebElement SearchIcon;
     
     
     public void searchfieldClick(String item) {
    	 Searchfield.click();
    	 Searchfield.clear();
    	 Searchfield.sendKeys(item);
    	 
     }
     public void searchIconClick() {
    	 SearchIcon.click();
     }
     public AmazonSellingPage(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
}
