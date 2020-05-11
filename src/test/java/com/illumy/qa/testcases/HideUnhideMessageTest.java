/**
 * 
 */
package com.illumy.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.pages.HideUnhideMessage;
import com.illumy.qa.pages.HomePage;

import com.illumy.qa.pages.SigninPage;

import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class HideUnhideMessageTest extends TestBase{

	public HideUnhideMessage hideUnhideMsg;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	
	
	String sheetName		= "Reply All";
	String userToSelect		= "userToSelect";
	String message			= "message";
	
	String userToSelect_Row2	= new String (reader.getCellData(sheetName, userToSelect, 2));
	String message_Row2			= new String (reader.getCellData(sheetName, message, 2));
	
	public HideUnhideMessageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		hideUnhideMsg = new HideUnhideMessage();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1,enabled=true)
	public void verifyHideMessageOption() throws Exception, Throwable {
		Assert.assertTrue(hideUnhideMsg.verifyHideMessageOption(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	// Verify that by clicking on the "Unhide message" button will shows up the message and removes the grey border.
	@Test(priority = 2, enabled = true)
	public void verifyUnhideMessage() throws Throwable {
		String unhideMsg = hideUnhideMsg.verifyUnhideMessage(reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, message, 2));
		Assert.assertTrue(unhideMsg.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(unhideMsg);
	}
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		driver.quit();
	}

	@AfterTest
	public void endTest() {
		endReport();
	}

}
