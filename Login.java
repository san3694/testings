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


		public void logindata (String username , String password) {
			sendKey(usernametxtfld, username);
			sendKey(passwordtxtfld, password);
			click(loginbtn);
			

		}}

		
		
		
		