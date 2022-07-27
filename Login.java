package org.framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class Login extends BaseClass {

public Login () {
	PageFactory.initElements(getDriver(), this);
}

		@FindBy (id="username")
		private WebElement usernametxtfld;
		
		@FindBy (id="password")
		private WebElement passwordtxtfld;
		
		@FindBy (id="login")
		private WebElement loginbtn;

		BaseClass BaseClass = new BaseClass ();
		
		public void logIn () throws Throwable {
			
			String username = BaseClass.getDataFromExcel("C:\\Users\\SAN\\eclipse-workspace\\framework\\testdata\\hotel book.xlsx", "Sheet1", 1, 0);
				BaseClass.sendKey(usernametxtfld, username);
				
				String passWord = BaseClass.getDataFromExcel("C:\\Users\\SAN\\eclipse-workspace\\framework\\testdata\\hotel book.xlsx", "Sheet1", 2, 0);
				BaseClass.sendKey(passwordtxtfld, passWord);
				
				BaseClass.click(loginbtn);
		}

			

		}

		
		
		
		