package com.dsrc.seleniumtest.framework.tests;
import org.testng.annotations.Test;

import com.dsrc.seleniumtest.framework.base.TestNGAnnotations;

public class CarParkTest extends TestNGAnnotations {


	@Test 
	public void testCreateCarPark() {
	
		enterInput(locateElement("id", "txtShortDescription"), "Short1");
		enterInput(locateElement("id", "txtLongDescription"), "Long1");
		selListBoxByVisibleText(locateElement("id", "ddlDataSource"), "Adaptor - Adaptor");
		selListBoxByVisibleText(locateElement("id", "ddlType"), "aa");
		selListBoxByVisibleText(locateElement("id", "ddlQualityStatement"), "Cloud Amber - Adaptor");
		enterInput(locateElement("id", "txtCapacity"), "100");
		enterInput(locateElement("id", "txtDisabledCapacity"), "5");
		enterInput(locateElement("id", "txtAlmostfullincreasing"), "20");
		enterInput(locateElement("id", "txtAlmostFullDecreasing"), "5");
		enterInput(locateElement("id", "txtFullIncreasing"), "10");
		clickElement(locateElement("type","submit"));
		
	}
}
