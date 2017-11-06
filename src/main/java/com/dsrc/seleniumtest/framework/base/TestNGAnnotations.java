package com.dsrc.seleniumtest.framework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.dsrc.seleniumtest.framework.dataprovider.ExcelDataProvider;

public class TestNGAnnotations extends WebDriverMethods {
	
	public String dataWorkBookName=null;
	public static Properties prop;
	
	@BeforeSuite
	public void beforeSuiteNG(){
		
		System.out.println("beforeSuite is called..");
		prop = new Properties();
		try {
			//prop = new Properties();
			prop.load(new FileInputStream("./src/main/resources/config.properties"));
			System.out.println("URL is : " + prop.getProperty("URL"));
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		//this will start the report in ExtentReports format
		startReport();
		}
	
	@BeforeTest
	public void beforeTestNG() {
		System.out.println("beforeTest is called..");
	}
	
	@BeforeGroups
	public void beforeGroupsNG() {
		System.out.println("beforeGroups is called..");
	}
	
	
	
	@DataProvider(name="fetchData")
	public Object[][] readTestDataForTC001() {
		System.out.println("beforeDataProvider is called in TestNGAnnotations.."); 
		return ExcelDataProvider.readTestData("/data/"+dataWorkBookName+".xlsx");
	     
	}
 
	
	@Parameters("browser")	
	@BeforeMethod
	public void beforeMethodNG(String browser) throws Exception {
		System.out.println("beforeMethod is called..");
		//
		//String browser="chrome";
		//createDriverAndInvokeApp("chrome","http://leaftaps.com/opentaps");
		System.out.println("URL is : " +prop.getProperty("URL"));
		System.out.println("Thread id = " + Thread.currentThread().getId());

		
		if(prop.getProperty("RUN").equalsIgnoreCase("remote")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WIN10);
			dc.setVersion("59.0");
			driver=new RemoteWebDriver(new URL(prop.getProperty("SAUCE_HUB")), dc);
		}else if(prop.getProperty("RUN").equalsIgnoreCase("grid")) {
			
			System.out.println("Inside grid set up..");
			if (browser.equalsIgnoreCase("chrome")) {
				DesiredCapabilities capability = new DesiredCapabilities().chrome();
	        	capability.setBrowserName("chrome");
	        	capability.setPlatform(Platform.WINDOWS);
	        	try {
	        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
	        	
	        	}catch(Exception e) {
	        		e.printStackTrace();
	        	}
			}
	        	else if (browser.equalsIgnoreCase("firefox")) {
	    			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver-v0.18.0-win64/geckodriver.exe");
	    		   	DesiredCapabilities capability = new DesiredCapabilities().firefox();
	    		   	capability.setBrowserName("firefox");
	    		   	capability.setPlatform(Platform.WINDOWS);
	    		   	try {
	    		   		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
	    		   	}catch(Exception e) {
	    		   		e.printStackTrace();
	    		   	}
	        	}
		}
		startTestCase(testCaseName, testCaseDescription, testCaseCategory, testCaseAuthor);
		eventDriver = new EventFiringWebDriver(driver);
		//ThreadLocal<WebDriverMethods>threadDriver = new ThreadLocal<WebDriverMethods>();
		WebDriverEvent handler = new WebDriverMethods();
		eventDriver.register(handler);
		//threadDriver.set(this);
		
		eventDriver.navigate().to(prop.getProperty("URL"));
		
		
	}
	
	@AfterMethod
	public void afterMethodNG() {
		System.out.println("afterMethodNG is called..");
		quitApp();
		endTestCase();
	}
	
	@AfterClass
	public void afterClassNG() {
		System.out.println("afterClassNG is called..");
	}
	
	@AfterGroups
	public void afterGroupsNG() {
		System.out.println("afterGroupsNG is called..");
	}
	
	@AfterTest
	public void afterTestNG() {
		System.out.println("afterTestNG is called..");
	}
	
	@AfterSuite
	public void afterSuiteNG(){
		
		System.out.println("afterSuite is called..");
		endReport();
	}
	
	
	
	
	
	
}
