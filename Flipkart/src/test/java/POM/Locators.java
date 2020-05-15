package POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	WebDriver driver1 = new ChromeDriver ();
	WebDriver driver = null;

	public Locators(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.name("q");
	By uname = By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
	By pwd = By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']");
	By login = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");

	public void singIn() throws IOException {
		FileInputStream file = new FileInputStream("confiq.properties");
		Properties prop = new Properties();
		prop.load(file);
		driver.findElement(uname).sendKeys(prop.getProperty("uname"));
		driver.findElement(pwd).sendKeys(prop.getProperty("pwd"));
		driver.findElement(login).click();
	}

	public void do_search() throws IOException {
		FileInputStream file = new FileInputStream("confiq.properties");
		Properties prop = new Properties();
		prop.load(file);
		driver.findElement(search).sendKeys(prop.getProperty("product"));
		driver.findElement(search).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='_1p7h2j'])[2]")).click();
	}
}
