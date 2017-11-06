package com.dsrc.seleniumtest.framework.base;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverMethods extends WebDriverEvent implements WebDriverMethodsInterface {

	public RemoteWebDriver driver;
	public static EventFiringWebDriver eventDriver;
	public WebDriverWait wait;
	/**
	 * this method locates elements
	 * @param how
	 * @param using
	 * @return
	 */
	public WebElement locateElement(String how, String using) {
		
	WebElement ele= null;
		switch(how) {
		
		case("id"):
				ele = eventDriver.findElement(By.id(using));break;
		
		case("name"):
			ele = eventDriver.findElement(By.name(using));break;
		
		case("linkText"):
			ele = eventDriver.findElement(By.linkText(using));break;
		
		case("partialLinkText"):
			ele = eventDriver.findElement(By.partialLinkText(using));break;
		
		case("className"):
			ele = eventDriver.findElement(By.className(using));break;
		
		case("cssSelector"):
			ele = eventDriver.findElement(By.cssSelector(using));break;
		
		case("xpath"):
			ele = eventDriver.findElement(By.xpath(using));break;
	
		case("tagName"):
			ele = eventDriver.findElement(By.tagName(using));break;
			
		case("type"):
			ele = eventDriver.findElement(By.xpath("//*[@type='"+using+"']"));
			
		
		default:
			System.out.println("The given locator " +how+ " is not correct");
		}
		return ele;
	}
	
	/**
	 * this method passes input text to an element
	 * @param ele - locator of the element
	 * @param inputText - input text to be typed
	 */
	
	
	@Override
	public void enterInput(WebElement ele, String inputText) {
	
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ele.sendKeys(inputText);
	}
	
	public void clickElement(WebElement ele) {
		
		ele.click();
	}
	
	public void selListBoxByVisibleText(WebElement ele, String str) {
		
		Select sel = new Select(ele);
		sel.selectByVisibleText(str);
	}
	
	public void selListBoxByIndex(WebElement ele,int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void selListBoxByValue(WebElement ele, String str) {
		Select sel = new Select(ele);
		sel.selectByValue(str);
	}
	
	
	public void acceptAlert() {
		
		eventDriver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		eventDriver.switchTo().alert().dismiss();
	}
	
	public String getAlertText() {
		
		return eventDriver.switchTo().alert().getText();
	}

	
	public void switchToFrame(WebElement ele) {
		
		eventDriver.switchTo().frame(ele);
	}
	
	
	//HashSet->Random Order, TreeSet -> ASCII order, LinkedHashSet -> Order of insert/add
	public void switchWindow(int index) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList();
		allWindows.addAll(allWindowHandles);
		eventDriver.switchTo().window(allWindows.get(index));
	}
	
	public String getText(WebElement ele) {
		
		return ele.getText();
	}
	public boolean verifyText(WebElement ele, String txtToBeVerified) {
		
		if(ele.getText().equalsIgnoreCase(txtToBeVerified))
		return true;
		else
		return false;
	}
	
	public String getAttribute(WebElement ele, String str) {
		
		return ele.getAttribute(str);
		
	}
	
	
	public void createDriverAndInvokeApp
	(String browser, String url) {
		
		//switch(browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capability = new DesiredCapabilities().chrome();
        	capability.setBrowserName("chrome");
        	capability.setPlatform(Platform.WINDOWS);
        	try {
        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        	
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
			//break;
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
		   	//break;
			
		//default:
			//System.out.println("Unable to create driver");
	}
		eventDriver = new EventFiringWebDriver(driver);
		ThreadLocal<WebDriverMethods>threadDriver = new ThreadLocal<WebDriverMethods>();
		WebDriverEvent handler = new WebDriverMethods();
		eventDriver.register(handler);
		threadDriver.set(this);
		
		wait = new WebDriverWait(eventDriver, 120);
		eventDriver.navigate().to(url);
		
	}
	
	/*public void launchApp() {
		
		eventDriver.navigate().to("http://leaftaps.com/opentaps");
	}*/
	
	
		
	public void quitApp() {
		
		eventDriver.quit();
	}
	
	public void readWebTable(WebElement ele) {
	
		List<WebElement> rows_table = ele.findElements(By.tagName("table"));
		int rows_count = rows_table.size();
		System.out.println("Table size : " + rows_count);
	}
	
	public long takeSnap() {
		
		long number = (long) Math.floor(Math.random()*9000000L)+1000000L;
		File src = eventDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./testreports/snaps/"+number+".jpg"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return number;
	}

	
	
	/*@Override
	public void getEventDriver() {
		// TODO Auto-generated method stub
		
	}*/
}
