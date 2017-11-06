package com.dsrc.seleniumtest.framework.pagetests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dsrc.seleniumtest.framework.base.TestNGAnnotations;
import com.dsrc.seleniumtest.framework.pages.CarParkPage;
import com.dsrc.seleniumtest.framework.pages.LoginPage;
import com.dsrc.seleniumtest.framework.reports.TestReporter;
@Listeners(TestReporter.class)

public class LoginTest extends TestNGAnnotations {

	
  /**
   * Test case to create Leads
   * Using dataprovider to log in
   * 
   * @throws Exception
   */
	@Parameters("browser")
	@BeforeClass
	public void beforeClassNG(String browser) {
		System.out.println("beforeClass in the test is called....");
		dataWorkBookName="testdata_rv";
		testCaseName="RV Login Test"+" on " + browser;
		testCaseDescription="To Login to RV " + browser;
		testCaseCategory="Functional";
		testCaseAuthor="Venkat Srinivasan";
	}
	
  @Test(dataProvider = "fetchData")
 
	public void testRVLogin(String varUserName, String varPassword)
			throws Exception {
		
	  	new LoginPage()
	  	.clickLoginLink()
	  	.enterUserName(varUserName)
	  	.enterPassword(varPassword)
	  	.clickLogin();
	  	Thread.sleep(4000);

	}
}
