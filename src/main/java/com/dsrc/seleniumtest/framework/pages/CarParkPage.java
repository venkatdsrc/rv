package com.dsrc.seleniumtest.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class CarParkPage extends AbstractPage {

	public CarParkPage() {
		System.out.println("Car Park page constructor is called....");
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how=How.ID, using="txtShortDescription")
	WebElement eleShortDescription;
	public CarParkPage enterShortDescription(String paramShortDescription) {
		
		enterInput(eleShortDescription, paramShortDescription);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtLongDescription")
	WebElement eleLongDescription;
	public CarParkPage enterLongDescription(String paramLongDescription) {
		
		enterInput(eleShortDescription, paramLongDescription);
		return this;
	}
	
	@FindBy(how=How.ID, using="ddlDataSource")
	WebElement eleSelectDataSource;
	public CarParkPage selectDataSource(String paramDataSource) {
		
		selListBoxByVisibleText(eleSelectDataSource, paramDataSource);
		return this;
	}
	
	@FindBy(how=How.ID, using="ddlType")
	WebElement eleSelectType;
	public CarParkPage selectType(String paramType) {
		
		selListBoxByVisibleText(eleSelectType, paramType);
		return this;
	}
	
	@FindBy(how=How.ID, using="ddlQualityStatement")
	WebElement eleQualityStatement;
	public CarParkPage selectQualityStatement(String paramQualityStatement) {
		
		selListBoxByVisibleText(eleQualityStatement, paramQualityStatement);
		return this;
	}
	
	@FindBy(how=How.ID, using="ddlModalRestrictions")
	WebElement eleModalRestrictions;
	
	public CarParkPage selectModalRestrictions(String paramModalRestrictions) {
		
		selListBoxByVisibleText(eleModalRestrictions, paramModalRestrictions);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtCapacity")
	WebElement eleCapacity;
	public CarParkPage enterCapacity(String paramCapacity) {
		
		enterInput(eleCapacity, paramCapacity);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtDisabledCapacity")
	WebElement eleDisabledCapacity;
	public CarParkPage enterDisabledCapacity(String paramDisabledCapacity) {
		
		enterInput(eleDisabledCapacity, paramDisabledCapacity);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtAlmostfullincreasing")
	WebElement eleAlmostFullIncreasing;
	public CarParkPage enterAlmostFullIncreasing(String paramAlmostFullIncreasing) {
		
		enterInput(eleAlmostFullIncreasing, paramAlmostFullIncreasing);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtAlmostFullDecreasing")
	WebElement eleAlmostFullDecreasing;
	public CarParkPage enterAlmostFullDecreasing(String paramAlmostFullDecreasing) {
		
		enterInput(eleAlmostFullDecreasing, paramAlmostFullDecreasing);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtFullIncreasing")
	WebElement eleFullIncreasing;
	public CarParkPage enterFullIncreasing(String paramFullIncreasing) {
		
		enterInput(eleFullIncreasing, paramFullIncreasing);
		return this;
	}
	
	@FindBy(how=How.ID, using="txtFullDecreasing")
	WebElement eleFullDecreasing;
	public CarParkPage enterFullDecreasing(String paramFullDecreasing) {
		
		enterInput(eleFullDecreasing, paramFullDecreasing);
		return this;
	}
	
	@FindBy(how=How.ID, using="btnSave")
	WebElement eleClickSavePark;
	public CarParkPage clickSaveCarPark() {
		
		clickElement(eleClickSavePark);
		return this;
	}
	
}
