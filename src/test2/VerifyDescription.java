package test2;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.EndavaInternalSystems;
import lib.pages.HomePage;
import lib.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class VerifyDescription {
	
	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	EndavaInternalSystems endavaInternalSystems;
	String message;
	
	
	
	
  @Test
  public void verifydescription() {
	  System.out.println("Category description test.");
	  homePage.clickOnEndavaUniversity();
	  endavaInternalSystems = homePage.clickOnEndavaInternalSystems();
	  message = endavaInternalSystems.getDescription();
	  assert message.contains("This category contains help materials") : "Category description is not like expected";
	  System.out.println("Test passed");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  
	  
	        driver = new FirefoxDriver();
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
			
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			Sleeper.sleepTightInSeconds(4);

			homePage = loginPage.clickOnLoginButton();

			message = homePage.getTextFromLoginInfoLabel();
			System.out.println(message);

			assert message.contains("You are logged in as") : "You are not logged in.";
		    System.out.println("Text passed");
	  }

	  
	  
	  
  

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
