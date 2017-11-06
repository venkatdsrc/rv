package com.dsrc.seleniumtest.framework.pages;

import com.dsrc.seleniumtest.framework.base.WebDriverMethods;

public abstract class AbstractPage extends WebDriverMethods {

	public AbstractPage() {
		System.out.println("Abstract page constructor is called....");
		//PageFactory.initElements(driver, this);
	}


}
