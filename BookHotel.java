package org.framework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends BaseClass{
	
	public BookHotel () {
		PageFactory.initElements(getDriver(), this);}
	
	BaseClass baseclass = new BaseClass();
	
	@FindBy(id="first_name")
	private WebElement fstNameTxtFld;
	
	@FindBy(id="last_name")
	private WebElement lstNameTxtFld;
	
	@FindBy(id="address")
	private WebElement addressTxtFld;
	
	@FindBy(id="cc_num")
	private WebElement cc16TxtFld;
	
	
	@FindBy(id="cc_type")
	private WebElement ccTypeDd;
	
	@FindBy(id="cc_exp_month")
	private WebElement ccExpMonthDd;
	
	
	@FindBy(id="cc_exp_year")
	private WebElement ccExpyrDd;
	
	
	@FindBy(id="cc_cvv")
	private WebElement cvvTxtFld;
	
	@FindBy(id="book_now")
	private WebElement booknowClick;
	
	public void bookNowClick() {

		baseclass.sendKey(fstNameTxtFld, "san");
		baseclass.sendKey(lstNameTxtFld, "raj");
		baseclass.sendKey(addressTxtFld, "san chennai ind ");
		baseclass.sendKey(cc16TxtFld, "1234567891234567");
		baseclass.selectByVale(ccTypeDd, "VISA");
		selectByIndex1(ccExpMonthDd, 6);
		selectByIndex1(ccExpyrDd, 6);
		baseclass.sendKey(cvvTxtFld, "576");
		click(booknowClick);
		
	}

	@FindBy (id="order_no")
	private WebElement ordernoGet;
	


	public void printid() throws Throwable {
		Thread.sleep(5000);
		//String data = ordernoGet.getAttribute("value");
		//		System.out.println(data);
				
				BaseClass BaseClass = new BaseClass ();
				//String dataToExcel = BaseClass.getDataToExcel("C:\\Users\\SAN\\eclipse-workspace\\framework\\testdata\\hotel book.xlsx", "Sheet1", 10, 0,data );

				File file = new File ("C:\\Users\\SAN\\eclipse-workspace\\framework\\testdata\\hotel book.xlsx");
				FileInputStream fileinput = new FileInputStream(file);
				Workbook book = new XSSFWorkbook(fileinput);
				Sheet sheet = book.getSheet("Sheet1");
				Row row = sheet.getRow(10);
				Cell cell = row.getCell(0);
				String data = ordernoGet.getAttribute("value");
				System.out.println(data);
				cell.setCellValue(data);			
				
				


	}

}
