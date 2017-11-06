package com.dsrc.seleniumtest.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	public LoginPage() {
		
		System.out.println("Loginpage constructor is called....");
		PageFactory.initElements(eventDriver, this);
	}
	
	
	
	@FindBy(how=How.ID, using="ctl00_lnkLogin")
	WebElement eleLoginLink;
	
	public LoginPage clickLoginLink() {
		
		clickElement(eleLoginLink);
		return this;
	}
	@FindBy(how=How.ID, using="ctl00_ContentMainHolder_txtUserName")
	WebElement eleUName;
	
	public LoginPage enterUserName(String strUserName) {
		
		enterInput(eleUName, strUserName);
		return this;
	}
	
	
	@FindBy(how=How.ID, using="ctl00_ContentMainHolder_txtPassword")
	WebElement elePwd;
	public LoginPage enterPassword(String strPassword) {
		
		enterInput(elePwd,strPassword);
		return this;
	}

	
	
	@FindBy(how=How.ID,using="ctl00_ContentMainHolder_btnLogin")
	WebElement eleLoginButton;
	
	/*@FindBys({
	@FindBy(how=How.ID, using="password"),
	@FindBy(how=How.NAME,using="PASSWORD")
	})
	@FindAll({
		@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	})
	 */
	
	public void clickLogin() {
		
		clickElement(eleLoginButton);
	}
	

}
