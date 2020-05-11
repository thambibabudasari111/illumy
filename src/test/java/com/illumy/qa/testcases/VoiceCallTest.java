/**
 * 
 */
package com.illumy.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.pages.VoiceCall;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class VoiceCallTest extends TestBase{

	public VoiceCall voiceCall;
	public  SigninPage signinPage;
	public static HomePage homePage;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "VoiceCall";
	String userToSelect		= "userToSelect";
	String keys_SearchField	= "keys_SearchField";
	
	String userToSelect_Row2	= reader.getCellData(sheetName, userToSelect, 2);
	String userToSelect_Row3	= reader.getCellData(sheetName, userToSelect, 3);
	String keys_SearchField_Row2= reader.getCellData(sheetName, keys_SearchField, 2);
	
	public VoiceCallTest() {
		super();
	}
	

	@BeforeClass
	public void setUp() throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		voiceCall=new VoiceCall();
	}
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	

	
	//Verify the voice call in the P2P conversation thread 
	@Test(priority=1,enabled=true)
	public void verifyVoiceCall_P2PMsgHeaderSectionTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoiceCall_P2PMsgHeaderSection(userToSelect_Row2));
	}
	
	//Verify the voice call in  contacts page by clicking on the user name at P2P header section
	@Test(priority=2,enabled=true)
	public void verifyVoiceCall_ContactsPageTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoiceCall_ContactsPage(userToSelect_Row2));
	}
		
	//Verify the voice call icon by entering the keywords in search field
	@Test(priority=3,enabled=true)
	public void verifyVoiceCall_SearchAutoSuggTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoiceCall_SearchAutoSugg(keys_SearchField_Row2, userToSelect_Row2));
	}
		
	//Verify voice call icon by clicking on the contacts link in search field
	@Test(priority=4,enabled=true)
	public void verifyVoice_ContactsLinkTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoice_ContactsLink(keys_SearchField_Row2));
	}
	
	//Verify the voice call confirmation pop up window UI
	@Test(priority=5,enabled=true)
	public void verifyVoiceCallConfirmationPopupTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoiceCallConfirmationPopup(userToSelect_Row2));
	}
	
	//Verify the cancel button functionality by clicking on it from the voice call confirmation pop up 
	@Test(priority=6,enabled=true)
	public void verifyVoiceCall_ClickOnCancelBtnTest() throws Throwable {
		voiceCall.verifyVoiceCall_ClickOnCancelBtn(userToSelect_Row2);
	}
	
	//Verify the Test link in the voice call confirmation window
	@Test(priority=7,enabled=true)
	public void verifyTestLink_PopupWindow() throws Throwable {
		voiceCall.verifyTestLink_PopupWindow(userToSelect_Row2);
	}
		
	//Verify the voice call window when user1 make a voice call to user2
	@Test(priority=8,enabled=true)
	public void verifyVoiceCallWindow_CallerEndTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoiceCallWindow_CallerEnd(userToSelect_Row2));
		
	}
	
	//Verify the voice call window of user2 when user2 receiving the voice call from user1
	@Test(priority=9,enabled=true)
	public void verifyVoiceCallWindow_ReceiverEndTest() throws Throwable {
		Assert.assertTrue(voiceCall.verifyVoiceCallWindow_ReceiverEnd(userToSelect_Row2));
		
	}
	
	//Verify the UI of both the user when voice call is accepted 
	@Test(priority=10,enabled=true)
	public void verifyVoiceCallWindow_IfCallAcceptedTest() throws Throwable {
		voiceCall.verifyVoiceCallWindow_IfAccepted(userToSelect_Row2,userToSelect_Row3);
	}
	
	//Verify the unmute icon by clicking on the mute button 
	@Test(priority=11,enabled=true)
	public void verifyMuteBtn_ClickAction() throws Throwable {
		voiceCall.verifyMuteBtn_ClickAction(userToSelect_Row2);
	}
	
	//Verify if the other user decline the voice call
	@Test(priority=12,enabled=true)
	public void verify_VoiceCallDeclineTest() throws Throwable {
		String actualVoicemail = voiceCall.verify_VoiceCallDecline(userToSelect_Row2, userToSelect_Row3);
		String expectedVoicemail = "";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		expectedVoicemail = list.get(list.size()-1).getText();
		Assert.assertTrue(actualVoicemail.contains(expectedVoicemail));
		System.out.println(actualVoicemail);
		
	}
	
	//Verify the voice call window if the other user not attending the voice call
	@Test(priority=13,enabled=true)
	public void verifyVoiceCallWindiow_IfUser2NotAttendCall() throws Throwable {
		String actualVoicemail = voiceCall.verifyVoiceCallWindiow_IfUser2NotAttendCall(userToSelect_Row2, userToSelect_Row3);
		String expectedVoicemail = "";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		expectedVoicemail = list.get(list.size()-1).getText();
		Assert.assertTrue(actualVoicemail.contains(expectedVoicemail));
		System.out.println(actualVoicemail);
		
	}
	
	//Verify that by Sending the text messages when user 1 and user 2 are in voice call
	@Test(priority=14,enabled=true)
	public void sendTextMsgs_DuringVoiceCall() throws Throwable {
		Assert.assertTrue(voiceCall.sendTextMsgs_DuringVoiceCall(userToSelect_Row2,userToSelect_Row3));
	}
	
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
	}
	
	@AfterTest
	public void endTest() {
		endReport();
	}
	
	@AfterClass
	public void tearDown() throws IOException {	
		driver.quit();
	}
}
