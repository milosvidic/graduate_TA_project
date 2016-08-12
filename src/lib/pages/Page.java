package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.util.Wait;

public class Page {

	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;
	
	@FindBy(xpath = "//a[contains(@title, 'My Account')]")      
	private WebElement myAccount;
	
	@FindBy(xpath = "//a[contains(@title, 'Endava University')]")
	private WebElement endavaUniversity;
	
	
	
	
	
	
	
	protected WebDriver driver;
	public Page(WebDriver driver){
		this.driver = driver;
	//	waitForPageToBeLoaded(driver, loginInfoLabel, 5);
		PageFactory.initElements(driver, this);
		
	}
	
	
	/**
	 * Get text from login info label
	 * @return {String}
	 */
	public String getTextFromLoginInfoLabel(){
		return loginInfoLabel.getText();
	}
	
	public void waitForPageToBeLoaded(WebDriver driver, By element, int time){
		Wait.untilWebElementVisible(driver, loginInfoLabel, 5);
	}
	
	
	/**
	 * Click on log out link to log out
	 * @return {LoginPage}
	 */
	public LoginPage clickOnLogOutLink(){
		logOutLink.click();
		Sleeper.sleepTightInSeconds(5);
		return new LoginPage(driver);
	}
	
	 public Page clickOnMyAccount(){                 //vraca page
	    	myAccount.click();
	    	return this;
	    }
	 
	 public Page clickOnEndavaUniversity(){    //vraca page
	    	endavaUniversity.click();
	    	return this;
	    	
	    }
}
