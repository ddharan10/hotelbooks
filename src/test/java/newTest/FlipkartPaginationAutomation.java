package newTest;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartPaginationAutomation {

	static int currentPage = 2;
	static String page;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/search?q=mobiles");
		Thread.sleep(2000);
		page = driver.findElement(By.xpath("//span[contains(text(),'Page ')]")).getText();
		
		handlePagination(driver);

	}

	public static void handlePagination(WebDriver driver) throws InterruptedException {
		int totalPageNo = Integer.parseInt(page.substring(page.indexOf("f") + 2));

		if (currentPage < totalPageNo) {
			WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));

			for (int j = 1; j < currentPage; j++) {
				nextBtn.click();
				Thread.sleep(3000);
			}
			List<WebElement> mobilesName = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
			List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
			Map<String, String> map = new LinkedHashMap();
			for (int i = 0; i < mobilesName.size(); i++) {
				map.put(mobilesName.get(i).getText(), mobilePrice.get(i).getText());
			}

			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " = " + entry.getValue());
			}
			String current = driver.findElement(By.xpath("//span[contains(text(),'Page ')]")).getText();
			int currentPageIn = Integer
					.parseInt(current.substring(current.indexOf("e") + 2, current.indexOf("of") - 1));
			System.out.println(currentPageIn);// for Validation

			driver.quit();
		} else {
			System.out.println("InValided page number");
			driver.quit();
		}
	}
}
