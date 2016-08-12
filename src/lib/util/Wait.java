package lib.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	/**
	 * Wait until web element become visible.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementVisible(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	
	public static void untilWebElementVisible(WebDriver driver, By webElement, int time) {
		WebElement element = null;
		boolean b = false;
		while(!b) {
		try {
			element = driver.findElement(webElement);
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Wait until web element become clickable.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementClickable(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	
	/*public static void untilWebElementPresent(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shortsearchbox")));
	}  */
	
	public static void untilWebElementPresent(WebDriver driver, By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
	
}
