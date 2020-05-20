package POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	WebDriver driver = null;

	public Locators(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.name("q");
	By uname = By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
	By pwd = By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']");
	By login = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");

	public String getExcelData(int rowNum, int colNum) throws IOException {
		File f = new File("D:\\Book1.xlsx");
		FileInputStream fIS = new FileInputStream(f);

		XSSFWorkbook wB = new XSSFWorkbook(fIS);
		XSSFSheet sheet = wB.getSheet("sheet1");
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;

	}

	public static Properties readPropertiesFiles(String fileName) throws IOException {
		FileInputStream file = new FileInputStream("confiq.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop;
	}

	public void singIn() throws IOException {
		Properties prop = readPropertiesFiles("confiq.properties");
		driver.findElement(uname).sendKeys(prop.getProperty("username"));
		driver.findElement(pwd).sendKeys(prop.getProperty("password"));
		// driver.findElement(uname).sendKeys(l.getExcelData(0, 2));
		// driver.findElement(pwd).sendKeys(l.getExcelData(0, 3));
		driver.findElement(login).click();
	}

	public void do_search() throws IOException {
		Properties prop = readPropertiesFiles("confiq.properties");
		driver.findElement(search).sendKeys(prop.getProperty("product"));
		// driver.findElement(search).sendKeys(l.getExcelData(0, 1));
		driver.findElement(search).sendKeys(Keys.ENTER);

	}
}
