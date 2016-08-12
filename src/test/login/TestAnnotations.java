package test.login;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.HomePage;
import lib.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

//@Test(groups = {"login"})
public class TestAnnotations {
	
	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	String message;
	
  @Test(groups = {"login"})
  public void NeuspesnoLogovanje(){
  System.out.println("Test: NeuspesnoLogovanje()");
  System.out.println("Step: Invalid login.");
  loginPage.typeUsername("nenad");
  loginPage.typePassword(Property.password);
  loginPage.clickOnLoginButton();
  System.out.println("Step: Verify unsuccessful login.");
  String errorMessage = loginPage.getErrorMessage();
	  
	assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
	System.out.println("Test passed");
	  
	  
  }
  @Test(dependsOnMethods = "NeuspesnoLogovanje")
  public void NeuspesnoLogovanje1(){
  System.out.println("Test: NeuspesnoLogovanje1()");
  System.out.println("Step: Invalid login.");
  loginPage.typeUsername(Property.username);
  loginPage.typePassword("fdsfad");
  loginPage.clickOnLoginButton();
  System.out.println("Step: Verify unsuccessful login.");
  String errorMessage = loginPage.getErrorMessage();
	  
	assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
	System.out.println("Test passed");
  }

	@Test(dependsOnMethods = "NeuspesnoLogovanje1")
	  public void UspesnoLogovanje(){
		
	  
		try {
			System.out.println("Test: UspesnoLogovanje");
			System.out.println("Step: Login.");
			  loginPage.typeUsername(Property.username);
			  loginPage.typePassword(Property.password);
			  homePage = loginPage.clickOnLoginButton();
			  System.out.println("Step: Verify successful login.");
			  message = homePage.getTextFromLoginInfoLabel();
			  System.out.println(message);
				  
				assert message.contains("You are logged in") : "ERROR: You are not logged in";
				System.out.println("Test passed");
		} catch (Exception e) {
			
		}
	
	}
	  
  
  @BeforeMethod
  public void clearFields() {
	  System.out.println("Before Method");
	  loginPage.clearUsernameAndPasswordFields();
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
	  System.out.println("Before Class");
	  driver = new FirefoxDriver();
	  loginPage = new LoginPage(driver);
  }

  @AfterClass
  public void afterClass() {
  driver.quit();  
  }

}
