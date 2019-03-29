package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebsite {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
	    String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";     
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    baseUrl = "http://121.193.130.195:8800";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
    public void testWebsite() throws Exception {
		String filePath = System.getProperty("user.dir") + "/src/resources/软件测试名单.xlsx";
		File excelFile = new File(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
		XSSFSheet sheet = wb.getSheetAt(0);
		int columnNum = sheet.getLastRowNum();
		for(int i = 2; i < columnNum; i++){
			Row row = sheet.getRow(i);
			DecimalFormat df = new DecimalFormat("0"); 
			String id = df.format(row.getCell(1).getNumericCellValue());
			String password = df.format(row.getCell(1).getNumericCellValue()).substring(4,10);
			String gitUrl = row.getCell(3).toString();
			driver.get(baseUrl + "/");
			driver.findElement(By.name("id")).clear();
			driver.findElement(By.name("id")).sendKeys(id);
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.id("btn_login")).click();
			String getGitUrl = driver.findElement(By.id("student-git")).getText();
			assertEquals(gitUrl,getGitUrl);
			driver.findElement(By.id("btn_logout")).click();
		    driver.findElement(By.id("btn_return")).click();
		}
	}
	
    @After
    public void tearDown() throws Exception {
//	    driver.quit();
//	    String verificationErrorString = verificationErrors.toString();
//	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
//	  }
	}
	
	private boolean isElementPresent(By by) {
	  try {
	    driver.findElement(by);
	    return true;
	  } catch (NoSuchElementException e) {
	    return false;
	  }
	}
	
	private boolean isAlertPresent() {
	  try {
	    driver.switchTo().alert();
	    return true;
	  } catch (NoAlertPresentException e) {
	    return false;
	  }
	}
	
	private String closeAlertAndGetItsText() {
	  try {
	    Alert alert = driver.switchTo().alert();
	    String alertText = alert.getText();
	    if (acceptNextAlert) {
	      alert.accept();
	    } else {
	      alert.dismiss();
	    }
	    return alertText;
	  } finally {
	    acceptNextAlert = true;
	  }
	}

}
