package org.framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{

	

		public SearchHotel () {
			PageFactory.initElements(getDriver(), this);}
		
		@FindBy (id="location")
		private WebElement locationDd;
		
		@FindBy (id="hotels")
		private WebElement hotelsDd;
	
		@FindBy (id="room_type")
		private WebElement roomtypeDd;
		
		@FindBy (id="room_nos")
		private WebElement noofroomDd;
		
		@FindBy (id="datepick_in")
		private WebElement checkinDate;
		
		@FindBy (id="datepick_out")
		private WebElement checkoutDate;
		
		public WebElement getLocationDd() {
			return locationDd;
		}

		public WebElement getHotelsDd() {
			return hotelsDd;
		}

		public WebElement getRoomtypeDd() {
			return roomtypeDd;
		}

		public WebElement getNoofroomDd() {
			return noofroomDd;
		}

		public WebElement getCheckinDate() {
			return checkinDate;
		}

		public WebElement getCheckoutDate() {
			return checkoutDate;
		}

		public WebElement getNoofAdult() {
			return noofAdult;
		}

		public WebElement getNoofChild() {
			return noofChild;
		}

		public WebElement getSearch() {
			return search;
		}

		public BaseClass getBaseclass() {
			return baseclass;
		}

		@FindBy (id="adult_room")
		private WebElement noofAdult;
		
		@FindBy (id="child_room")
		private WebElement noofChild;
		
		@FindBy (id="Submit")
		private WebElement search;
		BaseClass baseclass = new BaseClass();
				
		public void searchFill() {
			baseclass.selectByIndex1(locationDd, 4);
			baseclass.selectByIndex1(hotelsDd, 2);
			baseclass.selectByIndex1(roomtypeDd,1);
			baseclass.selectByIndex1(noofroomDd, 2);
			baseclass.selectByIndex1(noofAdult,2);
			baseclass.selectByIndex1(noofChild, 0);
			baseclass.sendKey(checkinDate, "29/7/2022");
			baseclass.sendKey(checkoutDate, "30/7/2022");
			baseclass.click(search);
		}
	  
		

		}

