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

import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.Notifications;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class NotificationsTest extends TestBase{

	public  SigninPage signinPage;
	public  HomePage homePage;
	public Notifications notifications;
	
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "Notifications";
	String url				= "url";
	String startTime		= "startTime";
	String endTime			= "endTime";
	
	String url_Row2			= new String (reader.getCellData(sheetName, url, 2));
	String startTime_Row2	= new String (reader.getCellData(sheetName, startTime, 2));
	String endTime_Row2		= new String (reader.getCellData(sheetName, endTime, 2));
	
	public NotificationsTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		notifications=new Notifications();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyNotificationsHeader() {
		Assert.assertTrue(notifications.verifyNotificationsHeader());
	}
	
	@Test(priority=2,enabled=true)
	public void verifyNotificationsURL() {
		String currentUrl = notifications.verifyNotificationsURL();
		Assert.assertEquals(currentUrl, url_Row2);
		System.out.println(currentUrl);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyBrowserTitle_Notif() {
		String currentTitle = notifications.verifyBrowserTitle_Notif();
		Assert.assertEquals(currentTitle, "illumy settings");
		System.out.println(currentTitle);
	}
	
	@Test(priority=4,enabled=true)
	public void verifyEnableNotificationsText() {
		String actualText = notifications.verifyEnableNotificationsText();
		Assert.assertEquals(actualText, "Enable Notifications");
		System.out.println(actualText);
	}
	
	@Test(priority=5,enabled=true)
	public void verifyDoNotDistrubText() {
		String actualText = notifications.verifyDoNotDistrubText();
		Assert.assertTrue(actualText.contains("Do Not Disturb"));
		System.out.println(actualText);
	}
	
	@Test(priority=6,enabled=true)
	public void verifyDesktopSoundsText() {
		String actualText = notifications.verifyDesktopSoundsText();
		Assert.assertEquals(actualText, "Desktop Sounds");
		System.out.println(actualText);
	}
	
	@Test(priority=7,enabled=true)
	public void verifyReceiveDesktopText() {
		String actualText = notifications.verifyReceiveDesktopText();
		Assert.assertEquals(actualText, "Receive desktop notifications for new messages and important activity");
		System.out.println(actualText);
	}
	
	@Test(priority=8,enabled=true)
	public void verifyReceiveDeskopDefaultToggle() {
		Assert.assertTrue(notifications.verifyReceiveDeskopDefaultToggle());
	}
	
	@Test(priority=9,enabled=true)
	public void verifyReceiveDesktopToggleColor() throws Throwable {
		String actualToggleColor = notifications.verifyReceiveDesktopToggleColor();
		Assert.assertEquals(actualToggleColor, "#2e008b");
		System.out.println(actualToggleColor);
	}
	
	@Test(priority=10,enabled=true)
	public void clickOnEnableToggle_DesktopNotif() throws Throwable {
		Assert.assertTrue(notifications.clickOnEnableToggle_DesktopNotif());
	}
	
	@Test(priority=11,enabled=true)
	public void clickOnDisableToggle_DesktopNotif() throws Throwable {
		Assert.assertTrue(notifications.clickOnDisableToggle_DesktopNotif());
	}
	
	@Test(priority=12,enabled=true)
	public void verifyDoNotDisturbDefaultToggle() throws Throwable {
		Assert.assertTrue(notifications.verifyDoNotDisturbDefaultToggle());
	}
	
	@Test(priority=13,enabled=true)
	public void verifyDisableNotifFromTxt() throws Throwable {
		String actualText = notifications.verifyDisableNotifFromTxt();
		Assert.assertEquals(actualText, "Disable notifications from  ");
		System.out.println(actualText);
	}
	
	@Test(priority=14,enabled=true)
	public void verifyDonNotDisturbGrayTxt() throws Throwable {
		String actualText = notifications.verifyDonNotDisturbGrayTxt();
		Assert.assertTrue(actualText.contains("(UTC-08:00) Pacific Time (US & Canada)"));
		System.out.println(actualText);
	}
	
	@Test(priority=15,enabled=true)
	public void verifyStartTimeFieldClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyStartTimeFieldClickAction());
	}
	
	@Test(priority=16,enabled=true)
	public void verifyEndTimeFieldClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyEndTimeFieldClickAction());
	}
	
	@Test(priority=17,enabled=true)
	public void verifyStartTimeDownArrowClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyStartTimeDownArrowClickAction());
	}
	
	@Test(priority=18,enabled=true)
	public void verifyEndTimeDownArrowClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyEndTimeDownArrowClickAction());
	}
	
	@Test(priority=19,enabled=true)
	public void verifyScrollOfStartTimeDropdown() throws Throwable {
		String actualTime = notifications.verifyScrollOfStartTimeDropdown("11:00 PM");
		Assert.assertEquals(actualTime, "11:00 PM");
		System.out.println(actualTime);
	}
	
	@Test(priority=20,enabled=true)
	public void verifyScrollOfEndTimeDropDown() throws Throwable {
		String actualTime = notifications.verifyScrollOfEndTimeDropDown("11:30 PM");
		Assert.assertEquals(actualTime, "11:30 PM");
		System.out.println(actualTime);
	}
	
	@Test(priority=21,enabled=true) 
	public void verifySelectedTimeInStarTimeField() throws Throwable {
		String actualStatus = notifications.verifySelectedTimeInStarTimeField("6:00 PM");
		Assert.assertTrue(actualStatus.contains("active"));
		System.out.println(actualStatus);
	}
	
	@Test(priority=22,enabled=true)
	public void verifySelectedTimeInEndTimeField() throws Throwable {
		String actualStatus = notifications.verifySelectedTimeInEndTimeField("6:30 PM");
		Assert.assertTrue(actualStatus.contains("active"));
		System.out.println(actualStatus);
	}
	
	@Test(priority=23,enabled=true)
	public void verifySelectedStartTimeInEndTimeDropdown() throws Throwable {
		String actualStatus = notifications.verifySelectedStartTimeInEndTimeDropdown("6:00 PM");
		Assert.assertTrue(actualStatus.contains("option-disabled"));
		System.out.println(actualStatus);
	}
	
	@Test(priority=24,enabled=true)
	public void verifySelectedEndTimeInStartTimeDropdown() throws Throwable {
		String actualStatus = notifications.verifySelectedEndTimeInStartTimeDropdown("6:30 PM");
		Assert.assertTrue(actualStatus.contains("option-disabled"));
		System.out.println(actualStatus);
	}
	
	@Test(priority=25,enabled=true)
	public void verifyIncomingMsgTxt() throws Throwable {
		String actualText = notifications.verifyIncomingMsgTxt();
		Assert.assertEquals(actualText, "Incoming message");
		System.out.println(actualText);
	}
	
	@Test(priority=26,enabled=true)
	public void verifyIncomingMsgDefaultToggle() throws Throwable {
		Assert.assertTrue(notifications.verifyIncomingMsgDefaultToggle());
	}
	
	@Test(priority=27,enabled=true)
	public void clickOnIncomingMsgEnableToggle() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingMsgEnableToggle());
	}
	
	@Test(priority=28,enabled=true)
	public void clickOnIncomingMsgDisableToggle() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingMsgDisableToggle());
	}
	
	@Test(priority=29,enabled=true)
	public void clickOnIncomingMsgToneField() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingMsgToneField());
	}
	
	@Test(priority=30,enabled=true)
	public void clickOnIncomingMsgDownArrow() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingMsgDownArrow());
	}
	
	@Test(priority=31,enabled=true)
	public void verifySelectedIncomingMsgTone() throws Throwable {
		String actualTone = notifications.verifySelectedIncomingMsgTone("Intuition");
		Assert.assertEquals(actualTone, "Intuition");
		System.out.println(actualTone);
	}
	
	@Test(priority=32,enabled=true)
	public void verifyIncomingMsgPlayBtnClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyIncomingMsgPlayBtnClickAction("To-the-point"));
	}
	
	@Test(priority=33,enabled=true)
	public void verifyIncomingMsgPlayBtnAfterTonePlayed() throws Throwable {
		Assert.assertTrue(notifications.verifyIncomingMsgPlayBtnAfterTonePlayed("To-the-point"));
	}
	
	@Test(priority=34,enabled=true)
	public void verifyOutgoingMsgText() throws Throwable {
		Assert.assertTrue(notifications.verifyOutgoingMsgText());
	}
	
	@Test(priority=35,enabled=true)
	public void verifyOutgoingMsgDefaultTogggle() throws Throwable {
		Assert.assertTrue(notifications.verifyOutgoingMsgDefaultTogggle());
	}
	
	@Test(priority=36,enabled=true)
	public void clickOnOutgoingMsgEnableToggle() throws Throwable {
		Assert.assertTrue(notifications.clickOnOutgoingMsgEnableToggle());
	}
	
	@Test(priority=37,enabled=true)
	public void clickOnOutgoingMsgDisableToggle() throws Throwable {
		Assert.assertTrue(notifications.clickOnOutgoingMsgDisableToggle());
	}
	
	@Test(priority=38,enabled=true)
	public void clickOnOutgoingMsgTonesField() throws Throwable {
		Assert.assertTrue(notifications.clickOnOutgoingMsgTonesField());
	}
	
	@Test(priority=39,enabled=true)
	public void clickOnOutgoingMsgDownArrow() throws Throwable {
		Assert.assertTrue(notifications.clickOnOutgoingMsgDownArrow());
	}
	
	@Test(priority=40,enabled=true)
	public void verifySelectedOutgoingMsgTone() throws Throwable {
		String selectedTone = notifications.verifySelectedOutgoingMsgTone("Filling Your Inbox");
		Assert.assertEquals(selectedTone, "Filling Your Inbox");
		System.out.println(selectedTone);
	}
	
	@Test(priority=41,enabled=true)
	public void verifyOutgoingMsgPlayBtnClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyOutgoingMsgPlayBtnClickAction("Filling Your Inbox"));
	}
	
	@Test(priority=42,enabled=true)
	public void verifyOutgoingMsgPlayBtnAfterTonePlayed() throws Throwable {
		Assert.assertTrue(notifications.verifyOutgoingMsgPlayBtnAfterTonePlayed("Filling Your Inbox"));
	}
	
	@Test(priority=43,enabled=true)
	public void verifyIncomingCallText() throws Throwable {
		Assert.assertTrue(notifications.verifyIncomingCallText());
	}
	
	@Test(priority=44,enabled=true)
	public void verifyDefaultIncomingCallToggle() throws Throwable {
		Assert.assertTrue(notifications.verifyDefaultIncomingCallToggle());
	}
	
	@Test(priority=45,enabled=true)
	public void clickOnIncomingCallEnableToggle() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingCallEnableToggle());
	}
	
	@Test(priority=46,enabled=true)
	public void clickOnIncomingCallDisableToggle() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingCallDisableToggle());
	}
	
	@Test(priority=47,enabled=true)
	public void clickOnIncomingCallTonesField() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingCallTonesField());
	}
	
	@Test(priority=48,enabled=true)
	public void clickOnIncomingCallDownArrow() throws Throwable {
		Assert.assertTrue(notifications.clickOnIncomingCallDownArrow());
	}
	
	@Test(priority=49,enabled=true)
	public void verifySelectedIncomingCallTone() throws Throwable {
		String selectedTone = notifications.verifySelectedIncomingCallTone("Electronic");
		Assert.assertEquals(selectedTone, "Electronic");
		System.out.println(selectedTone);
	}
	
	@Test(priority=50,enabled=true)
	public void verifyIncomingCallDropdownScroll() throws Throwable {
		String selectedTone = notifications.verifyIncomingCallDropdownScroll("Xylophone");
		Assert.assertEquals(selectedTone, "Xylophone");
		System.out.println(selectedTone);
	}
	
	@Test(priority=51,enabled=true)
	public void verifyIncomingCallPlayBtnClickAction() throws Throwable {
		Assert.assertTrue(notifications.verifyIncomingCallPlayBtnClickAction("Xylophone"));
	}
	
	@Test(priority=52,enabled=true)
	public void verifyIncomingCallPlayBtnAfterTonePlayed() throws Throwable {
		Assert.assertTrue(notifications.verifyIncomingCallPlayBtnAfterTonePlayed("Xylophone"));
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		driver.quit();
	}

	@AfterTest
	public void endTest() {
		endReport();
	}
	
	
	
	
	
	
}
