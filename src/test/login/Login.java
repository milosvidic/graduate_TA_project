package test.login;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Login {
	
	public static String username = "ivecluj1";
	public static String wrongUsername = "ive";
	public static String password = "IveParola2";
	public static String password2 = "IveParola";
	
	   
	
	public static final String URL = "https://www.endavauniversity.com";
	
	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchPage;
	CDDPage cddPage;
	
  @Test //(dependsOnMethods = "testLoginWrongUsername_negative")
  public void f() {
	  
	  loginPage.typeUsername(Property.username);
	  loginPage.typePassword(Property.password);
	 
	  homePage = loginPage.clickOnLoginButton();
	  
	  String message = homePage.getTextFromLoginInfoLabel();
	  
	  System.out.println(message);
	  
      assert message.contains("You are logged in as") : "You are not logged in.";
      System.out.println("test passed");

  }
  @Test 
  public void search() {
	  homePage.typeSearchValueIntoSearchField(Property.textCareer);
	  Sleeper.sleepTightInSeconds(5);
	  searchPage = homePage.clickOnGoButton();
	  Sleeper.sleepTightInSeconds(5);
  }
  
  @Test
  public void openCDD(){
	  
	  cddPage = searchPage.clickOnCDDLink();
	  Sleeper.sleepTightInSeconds(5);
  }
	  
	
  
	  
	 

  /*
  @Test(dependsOnMethods = "testLoginWrongPassword_negative")                                                      
  public void testLoginWrongUsername_negative() {
	  
	  driver.findElement(By.id("username")).sendKeys(wrongUsername);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("loginbtn")).click();
	  
	  Sleeper.sleepTightInSeconds(5);
	  
	  
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message);
	  
	  assert message.contains("Invalid login, please try again") : "You are logged in.";
      System.out.println("test passed");
	  
  }
  
  @Test
  public void testLoginWrongPassword_negative() {
	  
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password2);
	  driver.findElement(By.id("loginbtn")).click();
	  
	  Sleeper.sleepTightInSeconds(5);
	  
	  
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message);
	  
	  assert message.contains("Invalid login, please try again") : "You are logged in.";
      System.out.println("test passed");
	  
  }
  
 */
  

  
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	 loginPage = new LoginPage(driver);
	  
	  
  }
  


  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

 
}
