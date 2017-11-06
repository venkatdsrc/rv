package com.dsrc.seleniumtest.framework.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class XtentReporter {

	public static ExtentReports extent;
	public static ExtentTest test;
	public String testCaseName=null;
	public String testCaseDescription=null;
	public String testCaseCategory=null;
	public String testCaseAuthor=null;
	
	//public abstract void getEventDriver();
	public abstract long takeSnap();
	
	//this will be called from @BeforeSuite method
	public void startReport() {
		extent = new ExtentReports("./testreports/reports.html", true);
		//extent.loadConfig();
	}	

	//this will be called from @BeforeMethod method
	public void startTestCase(String testCaseName, String testDescription,
								String testCategory, String testAuthor) {
		test = extent.startTest(testCaseName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	
	}
	
	//This will be called from @AfterMethod
	public void endTestCase() {
		extent.endTest(test);
	}
	
	//This will be called from @AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	//replace all Sysout statements in WdEvent
	public void reportStep(String desc, String status) {
		
		if(status.equalsIgnoreCase("PASS")) {
			test.log(LogStatus.PASS, desc, test.addScreenCapture("./../testreports/snaps/"+takeSnap()+".jpg"));
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.log(LogStatus.FAIL, desc);
		}else if(status.equalsIgnoreCase("INFO")) {
			test.log(LogStatus.INFO, desc);
		}else if(status.equalsIgnoreCase("WARNING")) {
			test.log(LogStatus.WARNING, desc);
		}
	}
}

