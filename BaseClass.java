package org.framework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.PortableServer.ImplicitActivationPolicyValue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.support.ui.Select;


public class BaseClass  {

		
	
	
	static WebDriver driver;
	
	
	public static void getDriver (String browserName) {
	try {
		if (browserName .equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAN\\eclipse-workspace\\framework\\src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver ();
		
	}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SAN\\eclipse-workspace\\framework\\src\\main\\resources\\driver\\msedgedriver.exe");
			driver = new EdgeDriver ();
}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAN\\eclipse-workspace\\framework\\src\\main\\resources\\driver\\msedgedriver.exe");
			driver = new FirefoxDriver ();
		}
		else { System.out.println("no browsers matched "); }
	} catch (Exception e) {
		
	}
	driver.manage().window().maximize();
	
}
	
	public static void  launchUrl (String url ){
	try {
		driver.get(url); 
	} catch (Exception e) {
		System.out.println(e);}
}
	
	public void sendKey (WebElement element,String data ) {
		try {
			element.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e);}
			
		}
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}}
	
		public void toFindElement (String locator, String elementData) {
			try {
				if (locator.equalsIgnoreCase("id")){
					WebElement element = driver.findElement(By.id(elementData));
				} else if (locator.equalsIgnoreCase("name")){
					WebElement element = driver.findElement(By.name(elementData));}
				else if (locator.equalsIgnoreCase("xpath")){
					WebElement element = driver.findElement(By.xpath(elementData));}
			} catch (Exception e) {
				System.out.println(e);}}
			
			public void clickwithwait(WebElement element) {
				try {
					Thread.sleep(30);
					element.click();
				} catch (Exception e) {
					System.out.println(e);
				}}
			
			public void clickwhenClickable(WebElement element) {
				try {
					clickwhenClickable (element);
					element.click();
				} catch (Exception e) {
					System.out.println(e);
				}}
			
				public void enterkey (WebElement element) throws AWTException {
					Robot rob = new Robot ();
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);}
				
				public void jsclick (WebElement element) {
						JavascriptExecutor exe = (JavascriptExecutor) getDriver();
						exe.executeScript("arguments[0].click()", element);}

					public String getAttribute (WebElement e , String attribute) {
						return e.getAttribute(attribute);}
						
					
				public void scrollByVisblity (WebElement element) {
					JavascriptExecutor exe = (JavascriptExecutor) getDriver();
					exe.executeScript("arguments[0].scrollintoview()", element);}
				
				public void selectByIndex (WebElement element, int index) {
					Select s = new Select (element);
					s.selectByIndex(index);
				}
				
				public void selectByVale (WebElement element, String value) {
					Select s = new Select (element);
					s.selectByValue(value);
				}
				public void selectByVisibletext (WebElement element, String value) {
					Select s = new Select (element);
					s.selectByVisibleText(value);;
				}
				
				public void dragDrop (WebElement source , WebElement target) {
					Actions action = new  Actions (driver);
					action.dragAndDrop(source, target).perform();
					
				}
				
				public void getCurrentURL() {
					String text = ((WebDriver) getDriver()).getCurrentUrl();
					System.out.println(text);
				}
				
	public void rightClick (WebElement ele) {
		Actions action = new  Actions (driver);
		action.contextClick().perform();
	}
	
	public void doubleClick (WebElement ele) {
		Actions action = new  Actions (driver);
		action.doubleClick().perform();
	}		
	public void alertDismiss (WebElement ele) {
		driver.switchTo().alert().dismiss();
	}
	public void alertaccept (WebElement ele) {
		driver.switchTo().alert().accept();
	}
	public void alertDataPass (WebElement ele , String data) {
		driver.switchTo().alert().sendKeys(data);
	}
		public String getDataFromExcel(String pathlocation, String sheetName, int rowNo, int cellNo) throws Throwable {
			String value = null;
			try {
			File file = new File (pathlocation);
			FileInputStream fileinput = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(fileinput);
			Sheet sheet = book.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			int cellType = cell.getCellType();
			if (cellType==1) {
				value= cell.getStringCellValue(); }
			else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-mm-yyyy");
				String format = dateFormat.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l= (long) numericCellValue;
				value = String.valueOf(l); }}
						
			catch (Exception e) {
				System.out.println(e);
			}
			return value;
		}
			
			 JavascriptExecutor ja = (JavascriptExecutor) driver;
			 
			
			
			public void selectByValue(WebElement w,String value) {
				Select s = new Select(w);
				s.selectByValue(value);
		}
			public void selectByIndex1(WebElement w, int no) {
				Select s = new Select(w);
				s.selectByIndex(no);
		
			}
			
			public String getDataToExcel(String pathlocation, String sheetName, int rowNo, int cellNo, String valueInput) throws Throwable {
				String value = null;
				try {
				File file = new File (pathlocation);
				FileInputStream fileinput = new FileInputStream(file);
				Workbook book = new XSSFWorkbook(fileinput);
				Sheet sheet = book.getSheet(sheetName);
				Row row = sheet.getRow(rowNo);
				Cell cell = row.getCell(cellNo);
				cell.setCellValue(valueInput);}
				catch (Exception e) {
				}
				return value;}
			
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				public static WebDriver getDriver() {
	
					return driver ;
				}

			
						
						
						
					
				
				
				
					
					
			
			
			
			
			
			
						
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

 