package lib.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;

public class HomePage {
	
	
	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	//@FindBy(css = "input[type = 'submit'][value = 'go']")
	@FindBy(xpath = ".//*[@id='coursesearch']/fieldset/input[2]")
	private WebElement goButton;
	
	@FindBy(xpath = "//a[contains(@title, 'My Account')]")      
	private WebElement myAccount;
	
	@FindBy(xpath = "//a[contains(@title, 'My Profile')]")      
	private WebElement myProfile;
	
	@FindBy(xpath = "//a[contains(@title, 'Endava University')]")
	private WebElement endavaUniversity;
	
	@FindBy(xpath = "//a[contains(@title, 'Internal systems self help')]")
	private WebElement internalSystems;
	
	
	
	
	private WebDriver driver;
	public HomePage(WebDriver driver){
		
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	/**
	 * Get text from login info label
	 * @return {String}
	 */
	public String getTextFromLoginInfoLabel(){
		return loginInfoLabel.getText();
	}
	
	/**
	 * Type search value into search field
	 * @param value {String}
	 * @return {HomePage}
	 */
    public HomePage typeSearchValueIntoSearchField(String value){
    	searchInputField.sendKeys(value);
    	return this;
    }
    
    public SearchResultPage clickOnGoButton(){
    	//goButton.click();
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", goButton);
    	return new SearchResultPage(driver);
    }
    
    public HomePage clickOnMyAccount(){       
    	myAccount.click();
    	return this;
    }
    
    public MyProfilePage clickOnMyProfile(){
    	myProfile.click();
    	return new MyProfilePage(driver);
    	
    }
    
    public HomePage clickOnEndavaUniversity(){
    	endavaUniversity.click();
    	return this;
    	
    }
    
    public EndavaInternalSystems clickOnEndavaInternalSystems(){
    	internalSystems.click();
    	return new EndavaInternalSystems(driver);
    	
    }
    
}
