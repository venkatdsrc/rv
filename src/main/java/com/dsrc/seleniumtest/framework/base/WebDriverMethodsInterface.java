package com.dsrc.seleniumtest.framework.base;

	
	import org.openqa.selenium.WebElement;
	
	
	public interface WebDriverMethodsInterface {

		public WebElement locateElement(String how, String using);
		public void enterInput(WebElement ele, String inputText) ;
		public void clickElement(WebElement ele) ;
		public void selListBoxByVisibleText(WebElement ele, String str);
		public void selListBoxByIndex(WebElement ele,int index);
		public void selListBoxByValue(WebElement ele, String str);
		public void acceptAlert();
		public void dismissAlert() ;
		public String getAlertText();
		public void switchToFrame(WebElement ele);
		//HashSet->Random Order, TreeSet -> ASCII order, LinkedHashSet -> Order of insert/add
		public void switchWindow(int index);
		public String getText(WebElement ele);
		public boolean verifyText(WebElement ele, String txtToBeVerified);
		public String getAttribute(WebElement ele, String str);
		public void createDriverAndInvokeApp(String browser, String url);
		public void quitApp() ;
		public void readWebTable(WebElement ele);
		//public void takeScreenshot(WebDriver driver);

		
}
