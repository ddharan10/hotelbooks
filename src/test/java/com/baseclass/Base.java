package com.baseclass;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public static WebDriver browserName(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			driver.manage().window().maximize();
		} else {
			throw new IllegalArgumentException("Invalied : " + browserName);
		}
		return driver;
	}

	// ============================
	// Browser Methods
	// ============================
	public static void openUrl(String url) {
		driver.get(url);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void implicitlyWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	// ============================
	// Element Methods
	// ============================
	public static void click(WebElement locator) {
		locator.click();
	}

	public static void sendKeys(WebElement locator, String text) {
		locator.sendKeys(text);
	}

	public static void sendKeysWithClear(WebElement locator, String text) {
		locator.clear();
		locator.sendKeys(text);
	}

	public static String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public static boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	// ============================
	// Explicit Waits
	// ============================
	public static WebElement waitForVisible(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickable(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// ============================
	// DropDown Methods
	// ============================
	public static void selectByVisibleText(By locator, String text) {
		new Select(driver.findElement(locator)).selectByVisibleText(text);
	}

	public static void selectByValue(By locator, String value) {
		new Select(driver.findElement(locator)).selectByValue(value);
	}

	public static void selectByIndex(By locator, int index) {
		new Select(driver.findElement(locator)).selectByIndex(index);
	}

	// ============================
	// Actions Class
	// ============================
	public static void moveToElement(By locator) {
		new Actions(driver).moveToElement(driver.findElement(locator)).perform();
	}

	public static void doubleClick(By locator) {
		new Actions(driver).doubleClick(driver.findElement(locator)).perform();
	}

	public static void rightClick(By locator) {
		new Actions(driver).contextClick(driver.findElement(locator)).perform();
	}

	// ============================
	// Alert Methods
	// ============================
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	// ============================
	// Frame Handling
	// ============================
	public static void switchToFrame(By locator) {
		driver.switchTo().frame(driver.findElement(locator));
	}

	public static void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	// ============================
	// JavaScriptExecutor
	// ============================
	public static void jsClick(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(locator));
	}

	public static void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}

	public static void scrollBy(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	// ============================
	// Screenshots
	// ============================
	public static void takeScreenshot(String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Dharani\\Workspace\\com.go\\target\\screenShot" + fileName + ".png");
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
