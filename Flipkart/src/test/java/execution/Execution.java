package execution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Locators;

public class Execution {
	WebDriver driver = null;

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lenovo pc\\eclipse-workspace\\Flipkart\\Driver\\chromedriverv81.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
	}

	@Test
	public void search() throws IOException {
		Locators l = new Locators(driver);
		l.singIn();
		l.do_search();
	}
}
