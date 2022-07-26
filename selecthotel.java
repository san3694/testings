package org.framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selecthotel extends BaseClass{
	
	public selecthotel () {
		PageFactory.initElements(getDriver(), this);}
	
	BaseClass baseclass = new BaseClass();
	
	@FindBy(id="radiobutton_0")
	private WebElement rdoClick;
	
	@FindBy(id="continue")
	private WebElement continueClick;
	
	public void selectContinue() {
		baseclass.click(rdoClick);
		baseclass.click(continueClick);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
