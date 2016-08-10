package Test1;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.MyProfilePage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class MyAccount {
	
	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myProfilePage;
	String message;
  
  @Test(dependsOnMethods ="test2")
  public void test1() {
	  System.out.println("Usao u prvi test");
	  message = myProfilePage.getEmail();
	  System.out.println(message);

	  assert message.equals(myProfilePage.getEmail()) : "Email address is not like expected";

	  System.out.println("test passed");
	  
	  
	  
  }
  
  
  @Test
  public void test2() {
	  System.out.println("Usao u drugi test");
	  message = myProfilePage.getArea();
	  System.out.println(message);
	  
	  assert message.equals(Property.area) : "Area of expertise is not like expected";

	  System.out.println("test passed");
	  
  }
  
  
  
  
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  loginPage = new LoginPage(driver);
	  
	  loginPage.typeUsername(Property.username);
	  loginPage.typePassword(Property.password);

	  homePage = loginPage.clickOnLoginButton();
	  
	  message = homePage.getTextFromLoginInfoLabel();
	  System.out.println(message);
	  
	  assert message.contains("You are logged in as") : "You are not logged in.";
	  
	  homePage.clickOnMyAccount();                
	  myProfilePage = homePage.clickOnMyProfile();
	  
  }

  @AfterClass
  public void afterClass() {
	  loginPage = myProfilePage.clickOnLogOutLink();
	  
  }

}
