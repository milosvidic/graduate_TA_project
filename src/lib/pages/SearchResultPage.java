package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;

public class SearchResultPage extends Page{

	@FindBy(linkText = "Career Development Discussion")
	private WebElement cddLink;
	
	private By bySearchResultsLabel = new By.ByCssSelector("#region-main *[role='main'] h2");
	
	
	//private WebDriver driver;
	public SearchResultPage(WebDriver driver){
		super(driver); 
		//this.driver = driver;                               //
		//Sleeper.sleepTightInSeconds(5);                     //
		//PageFactory.initElements(driver, this);
		waitForPageToBeLoaded(driver, bySearchResultsLabel, 5); 
	}
	
	public CDDPage clickOnCDDLink(){
		System.out.println("clickOnCDDLink()");
		cddLink.click();
		return new CDDPage(driver);
	}
	
}
