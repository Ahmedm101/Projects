package POM_AmazonSprint2;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Java_Script_Utilities.JS;

public class AmazonHomepage2 {
	WebDriver driver;           // should i make this public or only utilities public is ok 
	
	@FindBy(xpath = "//div[@class='nav-line-1-container']/following-sibling::span") WebElement AccountandLists;
	@FindBy(xpath="(//a[@id='nav_prefetch_yourorders']/following-sibling::a/child::span)[12]") WebElement Selling;
	@FindBy(css="#searchDropdownBox") WebElement All;
	@FindBy(css ="#twotabsearchtextbox") WebElement Searchfield;
	@FindBy(css="i[class='hm-icon nav-sprite']+span") WebElement allSideMenu;
//	@FindBy(xpath="//ul[@class='hmenu hmenu-visible hmenu-translateX']/descendant::a[text()='New Releases']") WebElement NewRealease;
	@FindBy(xpath="(//a[text()='New Releases'])[2]") WebElement NewRealease;
	
	public void AccountandListsClick() {
		WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		exwait.until(ExpectedConditions.elementToBeClickable(AccountandLists));
		JS.drawBorder(driver, AccountandLists);
		Actions mouse = new Actions (driver);
		mouse.moveToElement(AccountandLists).build().perform();
		
	}
	public void SellingClick() {
		JS.flash_blue(Selling, driver);
		JS.drawBorder(driver,Selling);
		Actions mouse = new Actions (driver);
		mouse.moveToElement(Selling).keyDown(Keys.SHIFT).click().build().perform();
		mouse.keyUp(Keys.SHIFT).build().perform();
	}
	public void allClick() {
		All.click();
		Select dropdown =new Select(All);
		dropdown.selectByIndex(4);
	
	}
	//ff
	  public void HomepagesearchfieldClick() {
	    	 Searchfield.click();
	    	  }
	  
	  public void allSideMenuClick() {
		  allSideMenu.click();
		  }
	  
	  public void newRealeaseClick() {
		NewRealease.click();
		// why is it showing unable to locate. i did use explicit to be clickable as i am seeing the element and also JSclick method  
	  }
	public AmazonHomepage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
