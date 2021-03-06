package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndavaInternalSystems extends Page{
	
	@FindBy(className="no-overflow")
	private WebElement categoryDescription;
	
	//WebDriver driver;
	public EndavaInternalSystems(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//Sleeper.sleepTightInSeconds(2);
		PageFactory.initElements(driver, this);
		
	}


	/**
	 * Get description from the text box
	 * @return {String}
	 */
	public String getDescription(){
		System.out.println("getDescription()");
		return categoryDescription.getText();
	}
}
