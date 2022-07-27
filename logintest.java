package org.framework;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;

public class logintest {

	

	public static void main(String[] args) throws Throwable {
		
		BaseClass.getDriver("chrome");
		BaseClass.launchUrl("https://adactinhotelapp.com/");
		Login Login =new Login();
		Login.logIn();
		SearchHotel SearchHotel = new SearchHotel ();
		SearchHotel.searchFill();
		selecthotel selecthotel = new selecthotel ();
		selecthotel.selectContinue();
		BookHotel BookHotel =new BookHotel();
		BookHotel.bookNowClick();	
		BookHotel.printid();
		
		
	}
	
	
	
		

		

	
	}

