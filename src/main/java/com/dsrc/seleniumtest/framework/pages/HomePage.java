package com.dsrc.seleniumtest.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

	public HomePage() {
		System.out.println("Home page constructor is called....");
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using="somelink")
	WebElement someLink;
	public void clickSomething() {
		
		clickElement(someLink);
		
	}
	

}
