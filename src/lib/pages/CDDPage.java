package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDDPage extends Page{
	
	@FindBy(xpath = "//input[contains(@title, 'CDD Animation Scripts')]")
	private WebElement firstCheckBox;
	
	private By checker = new By.ByXPath("//input[contains(@title, 'CDD Animation Scripts')]");
	
	/* @FindBy(linkText = "Log out")
	private WebElement logOutLink; */
	
	//
	
	
	//private WebDriver driver;
	public CDDPage(WebDriver driver){
		super(driver);
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(5);
		//PageFactory.initElements(driver, this);
		waitForPageToBeLoaded(driver, checker, 5);
	}
    /**
     * Check on first check box
     * @return
     */
	public CDDPage checkFirstCheskBox(){
		System.out.println("checkFirstCheckBox()");
		if(!isFirstCheckBoxSelected()){
		firstCheckBox.click();
		}
		Sleeper.sleepTightInSeconds(2);
		return this;
	}
	
	 /**
     * Uncheck on first check box
     * @return
     */
	public CDDPage uncheckFirstCheskBox(){
		System.out.println("uncheckFirstCheckBox()");
		if(isFirstCheckBoxSelected()){
		firstCheckBox.click();
		}
		Sleeper.sleepTightInSeconds(2);
		return this;
	}
	
	/**
	 * Is first check box selected
	 * @return {boolean}
	 */
	public boolean isFirstCheckBoxSelected(){
	   System.out.println("checkIsFirstCheckBoxSelected()");
	   String attributeValue = firstCheckBox.getAttribute("title");
	   if(attributeValue.contains("Mark as not complete")){
		   return true;
	   }
	   else return false;
}
	 /**
	 * Click on log out link to log out
	 * @return {LoginPage}
	 */
  /*	public LoginPage clickOnLogOutLink(){
		logOutLink.click();
		Sleeper.sleepTightInSeconds(5);
		return new LoginPage(driver);
	}   */  
	
}
	
	
	
	
	