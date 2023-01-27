package FacebookPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomepage {
    public   WebDriver driver;
   
    @FindBy(name ="email") WebElement email_field;
    @FindBy(name ="pass") WebElement pass_field;
    @FindBy(name ="login") WebElement login_btn;
    
    
    
    public void email(String email) {
    	email_field.click();
    	email_field.clear();
    	email_field.sendKeys(email);
    }
    public void pass(String password) {
    	pass_field.click();
    	pass_field.clear();
    	pass_field.sendKeys(password);
    }
    public void loginbtnclick() {
    	login_btn.click();
    }
    
    public FacebookHomepage (WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    
    
    
    
    
    
    
}
