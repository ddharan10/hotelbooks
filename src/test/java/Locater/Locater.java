package Locater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.Base;

public class Locater extends Base {

	public static WebElement from() {
		return driver.findElement(By.xpath("//input[@placeholder='From where?']"));
	}

	public static WebElement fromclick() {
		return driver.findElement(By.xpath("//span[text()='MAA - ']"));
	}

	public static WebElement to() {
		return driver.findElement(By.xpath("//input[@placeholder='To where?']"));
	}
	public static WebElement toclick() {
		return driver.findElement(By.xpath("//span[text()='Del']"));
	}

	public static WebElement fromDate() {
		return driver.findElement(By.xpath("//input[@id='fs_departDate_0']"));
	}
	public static WebElement validate() {
		return driver.findElement(By.xpath("//span[contains(text(),' Cheap Flights - ')]"));
	}
	

	public static WebElement selectMonthYear() {
		return driver.findElement(By.xpath("//span[@aria-label='31 December 2025']"));
	}

	public static WebElement selectDateMonthYear() {
		return driver.findElement(By.xpath("//span[contains(@aria-label,'28 November 2025')]"));
	}

	public static WebElement toDate() {
		return driver.findElement(By.xpath("//span[contains(@aria-label,'26 January 2026')]"));
	}

	public static WebElement traveler() {
		return driver.findElement(By.xpath("//input[@id='travellerButtonFlights']"));
	}

//	public static WebElement addAdult() {
//		return driver.findElement(By.xpath("//button[@id='addADULTS']"));// removeADULTS
//	}
//
//	public static WebElement addsenior() {
//		return driver.findElement(By.xpath("//button[@id='addSENIORS'"));// removeSENIORS
//	}
//
//	public static WebElement addchild() {
//		return driver.findElement(By.xpath("//button[@id='addCHILD'"));// id="removeCHILD"
		
		//not
	}

//	public static WebElement childrenAge() {
//		return driver.findElement(By.xpath("//select[@name='ChildrenAge'"));
//	}
//
//	public static WebElement done() {
//		return driver.findElement(By.xpath("//button[@id='closeFlightDialog'"));
//	}

	// span[contains(@aria-label,'1 March 2026')]
//}
