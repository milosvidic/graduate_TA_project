package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	
	@FindBy(linkText = "ivecluj.1@endava.com")   
	private WebElement mailCheck;
	
	@FindBy(linkText = "Career Development Discussion")  
	private WebElement areaCheck;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;

	private WebDriver driver;
	MyProfilePage(WebDriver driver){
		
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
		
		
	}
    /**
     * Get email from the page
     * @return {String}
     */
    public String getEmail(){
    	return mailCheck.getText();            
    }
	
    /**
     * Get area of expertise from the page
     * @return {String}
     */
    public String getArea(){
    	return areaCheck.getText();            
    }
    
    public LoginPage clickOnLogOutLink(){
		logOutLink.click();
		Sleeper.sleepTightInSeconds(5);
		return new LoginPage(driver);
	}
    
}
