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
import com.illumy.qa.pages.EditMessage;

import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class EditMessageTest extends TestBase{

	public EditMessage editMsg;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "EditMessage";
	String userToSelect 	= "userToSelect";
	String message			= "message";
	String editMessage		= "editMessage";
	
	String userToSelect_Row2		= new String (reader.getCellData(sheetName, userToSelect, 2));
	String userToSelect_Row3		= new String (reader.getCellData(sheetName, userToSelect, 3));
	String userToSelect_Row4		= new String (reader.getCellData(sheetName, userToSelect, 4)); 
	String message_Row2				= new String (reader.getCellData(sheetName, message, 2));
	String message_Row3				= new String (reader.getCellData(sheetName, message, 3));
	String editMessage_Row2			= new String (reader.getCellData(sheetName, editMessage, 2));
	
	public EditMessageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		editMsg = new EditMessage();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1,enabled=true)
	public void verifyEditMsgOptForSentMsg() throws Throwable {
		Assert.assertTrue(editMsg.verifyEditMsgOptForSentMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=2,enabled=true)
	public void verifyEditMsgClickAction() throws Throwable {
		Assert.assertTrue(editMsg.verifyEditMsgClickAction(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=3,enabled=true)
	public void verifyMsgInEditMsgSection() throws Throwable {
		Assert.assertTrue(editMsg.verifyMsgInEditMsgSection(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=4,enabled=true)
	public void verifyGiphyAndEmojiIcons_EditMsg() throws Throwable {
		Assert.assertTrue(editMsg.verifyGiphyAndEmojiIcons_EditMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=5,enabled=true)
	public void verifyEditMsgByClickOnEscKey() throws Throwable {
		Assert.assertTrue(editMsg.verifyEditMsgByClickOnEscKey(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=6,enabled=true)
	public void verifyEditMsgByClickOnEnter() throws Throwable {
		String actualMsg = editMsg.verifyEditMsgByClickOnEnter(userToSelect_Row2, message_Row2, editMessage_Row2);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=7,enabled=true)
	public void clickOnCancelBtnInMiddleOfEditMsg() throws Throwable {
		String actualMsg = editMsg.clickOnCancelBtnInMiddleOfEditMsg(userToSelect_Row2, message_Row2, editMessage_Row2);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=8,enabled=true)
	public void clickOnSaveChangesAfterEditingMsg() throws Throwable {
		String actualMsg = editMsg.clickOnSaveChangesAfterEditingMsg(userToSelect_Row2, message_Row2, editMessage_Row2);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=9,enabled=true)
	public void verifyEditedMsgAtFarEndUser() throws Throwable {
		String actualMsg = editMsg.verifyEditedMsgAtFarEndUser(userToSelect_Row2, message_Row2, editMessage_Row2,userToSelect_Row3);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
		
	@Test(priority=10,enabled=true)
	public void verifyAtmentionPopup_EditMsg() throws Throwable {
		String atmentionUsers = editMsg.verifyAtmentionPopup_EditMsg(userToSelect_Row2, message_Row2,userToSelect_Row3);
		
		Assert.assertTrue(atmentionUsers.contains(userToSelect_Row2+"\n"+userToSelect_Row3));
		System.out.println(atmentionUsers);
	}
	
	@Test(priority=11,enabled=true)
	public void verifyAtmentionUsersInThread_EditMsg() throws Throwable {
		String actualMsg = editMsg.verifyAtmentionUsersInThread_EditMsg(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=12,enabled=true)
	public void editGiphyInEditMsg() throws Throwable {
		Assert.assertTrue(editMsg.editGiphyInEditMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=13,enabled=true)
	public void editEmojiInEditMsg() throws Throwable {
		Assert.assertTrue(editMsg.editEmojiInEditMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=14,enabled=true)
	public void edit2MsgsAtaTime() throws Throwable {
		String editMsgAlert = editMsg.edit2MsgsAtaTime(userToSelect_Row2, message_Row2, message_Row3);
		Assert.assertEquals(editMsgAlert, "You are in the middle of editing some message. Do you want to save and continue?");
		System.out.println(editMsgAlert);
	}
	
	@Test(priority=15,enabled=true)
	public void clickOnCancelBtnEdit2Msgs() throws Throwable {
		Assert.assertTrue(editMsg.clickOnCancelBtnEdit2Msgs(userToSelect_Row2, message_Row2, message_Row3));
	}

	@Test(priority=16,enabled=true)
	public void clickOnSaveBtnEdit2Msgs() throws Throwable {
		String actualMsg = editMsg.clickOnSaveBtnEdit2Msgs(userToSelect_Row2, message_Row2, message_Row3);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=17,enabled=true)
	public void verifyEditMsgByClickOnContact() throws Throwable {
		String editMsgAlert = editMsg.verifyEditMsgByClickOnContact(userToSelect_Row2, message_Row2, userToSelect_Row4);
		Assert.assertEquals(editMsgAlert, "Would you like to save the changes before leaving the page?");
		System.out.println(editMsgAlert);
	}
	
	@Test(priority=18,enabled=true)
	public void clickOnCancelBtnFromAlertPopup() throws Throwable {
		String actualMsg = editMsg.clickOnCancelBtnFromAlertPopup(userToSelect_Row2, message_Row2, userToSelect_Row4,editMessage_Row2);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=19,enabled=true)
	public void clickOnSaveBtnFromAlertPopup() throws Throwable {
		String actualMsg = editMsg.clickOnSaveBtnFromAlertPopup(userToSelect_Row2, message_Row2, userToSelect_Row4,editMessage_Row2);
		Assert.assertTrue(actualMsg.contains(editMessage_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=20,enabled=true)
	public void verifyEditedTagAtSender() throws Throwable {
		String actualMsg = editMsg.verifyEditedTagAtSender(userToSelect_Row2, message_Row2,editMessage_Row2);
		Assert.assertTrue(actualMsg.contains("(edited)"));
		System.out.println(actualMsg);
	}
	
	@Test(priority=21,enabled=true)
	public void verifyEditedTagAtOppUser() throws Throwable {
		String actualMsg = editMsg.verifyEditedTagAtOppUser(userToSelect_Row2, message_Row2,editMessage_Row2,userToSelect_Row3);
		Assert.assertTrue(actualMsg.contains("(edited)"));
		System.out.println(actualMsg);
	}

	@Test(priority=22,enabled=true)
	public void clickCancelOrSaveBtnWithoutChanges_EditMsg() throws Throwable {
		Assert.assertTrue(editMsg.clickCancelOrSaveBtnWithoutChanges_EditMsg(userToSelect_Row2, message_Row2));
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
