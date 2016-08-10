package test.cdd;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class CheckBoxFunctionality {

	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchPage;
	CDDPage cddPage;
    boolean b = false;
    boolean isChecked= false;
    String message;
	
	@Test
	public void f() {

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);

		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();

		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in.";

		System.out.println("test passed");

		homePage.typeSearchValueIntoSearchField(Property.textCareer);
		searchPage = homePage.clickOnGoButton();
		cddPage = searchPage.clickOnCDDLink();
		cddPage.checkFirstCheskBox();
		
		isChecked = true;
		
		loginPage = cddPage.clickOnLogOutLink();

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);

		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();

		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in.";

		System.out.println("test passed");

		homePage.typeSearchValueIntoSearchField(Property.textCareer);
		searchPage = homePage.clickOnGoButton();
		cddPage = searchPage.clickOnCDDLink();
		// cddPage.checkFirstCheskBox();

		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
		loginPage = cddPage.clickOnLogOutLink();
		System.out.println("Test passed");

	}

	/*
	 * @Test public void Search() {
	 * homePage.typeSearchValueIntoSearchField(Property.textCareer);
	 * Sleeper.sleepTightInSeconds(5); searchPage = homePage.clickOnGoButton();
	 * Sleeper.sleepTightInSeconds(5); cddPage = searchPage.clickOnCDDLink();
	 * Sleeper.sleepTightInSeconds(5); }
	 */

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		
		loginPage = new LoginPage(driver);
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		
    if(isChecked){
    	loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);

		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();

		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in.";

		System.out.println("test passed");

		homePage.typeSearchValueIntoSearchField(Property.textCareer);
		searchPage = homePage.clickOnGoButton();
		cddPage = searchPage.clickOnCDDLink();
		cddPage.checkFirstCheskBox();

		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
		cddPage.uncheckFirstCheskBox();
		loginPage = cddPage.clickOnLogOutLink();
		driver.quit();
    }
	
	}

}
