package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;
import lib.util.Wait;

public class HomePage extends Page{
	
	
	
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	//@FindBy(css = "input[type = 'submit'][value = 'go']")
	@FindBy(xpath = "//input[contains(@value,'Go') and contains(@type, 'submit')]")
	private WebElement goButton;
	
	private By goBtn = new By.ByXPath("//input[contains(@value,'Go') and contains(@type, 'submit')]");
	//private WebDriver driver;
	
	/*@FindBy(xpath = "//a[contains(@title, 'My Account')]")      
	private WebElement myAccount; */
	
	@FindBy(xpath = "//a[contains(@title, 'My Profile')]")      
	private WebElement myProfile;
	
	/* @FindBy(xpath = "//a[contains(@title, 'Endava University')]")
	private WebElement endavaUniversity; */
	
	@FindBy(xpath = "//a[contains(@title, 'Internal systems self help')]")
	private WebElement internalSystems;
	
	private By srch = new By.ById("shortsearchbox");
	
	
	
	//private WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(3);
		//PageFactory.initElements(driver, this);
		waitForPageToBeLoaded(driver, goBtn, 5);    
		
		
	}
	
	
	
	
	/**
	 * Type search value into search field
	 * @param value {String}
	 * @return {HomePage}
	 */
    public HomePage typeSearchValueIntoSearchField(String value){
    	System.out.println("typeSearchValueIntoSearchField("+value+")");
    	Wait.untilWebElementPresent(driver, srch, 5);
    	searchInputField.sendKeys(value);
    	return this;
    }
    
    public SearchResultPage clickOnGoButton(){
    	System.out.println("clickOnGoButton()");
    	//goButton.click();
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", goButton);
    	return new SearchResultPage(driver);
    }
    
   /* public HomePage clickOnMyAccount(){       
    	myAccount.click();
    	return this;
    }*/
    
    public MyProfilePage clickOnMyProfile(){
    	System.out.println("clickOnMyProfile()");
    	myProfile.click();
    	return new MyProfilePage(driver);
    	
    }
    
    /* public HomePage clickOnEndavaUniversity(){
    	endavaUniversity.click();
    	return this;
    	
    } */
    
    public EndavaInternalSystems clickOnEndavaInternalSystems(){
    	System.out.println("clickOnEndavaInternalSystems()");
    	internalSystems.click();
    	return new EndavaInternalSystems(driver);
    	
    }
    
}
