/**
 * 
 */
package com.illumy.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.pages.ComposeMessage;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;

import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ComposeMessageTest extends TestBase {

	public ComposeMessage composeMsg;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	String composeMessage 	= "ComposeMessage";
	String toField 			= "toField";
	String ccField			= "CcField";
	String userToSelect		= "userToSelect";
	String subject 			= "subject";
	String message 			= "message";
	String atMentions 		= "atMentions";
	String invalidEmail 	= "invalidEmail";
	String offnetUser 		= "offnetUser";
	String groupName 		= "groupName";
	String senderUserName	= "senderUserName";
	String emojiKeys		= "emojiKeys";
	String filePath			= "filePath";
	String fileName			= "fileName";
	
	
	
	
	public ComposeMessageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		composeMsg = new ComposeMessage();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}

	/*****************************************************************************************************
	 * Verify the UI of compose message button in left panel of illumy home page
	 *****************************************************************************************************/

	// Verifying the compose message text
	@Test(priority = 1, enabled = true)
	public void verifyComposeMsg() {
		String compMsgTxt = composeMsg.getComposeMsgText();
		Assert.assertEquals(compMsgTxt, "Compose Message", "Compose Message Text not identified");
		System.out.println(compMsgTxt);
	}

	// Verifying click functionality of compose message
	@Test(priority = 2, enabled = true)
	public void verifyComposeMsgPopup() {
		String createNewThread = composeMsg.compMsg_ClickAction();
		Assert.assertEquals(createNewThread, "Compose Message", "There is no Create a new thread… text there");
		System.out.println(createNewThread);
	}

	// Verify by clicking on the 'X' symbol to close the new message thread window
	@Test(priority = 3, enabled = true)
	public void close_ComposeMsgPopup() throws Throwable {
		Assert.assertTrue(composeMsg.closeThread());
	}

	/*****************************************************************************************************
	 * Validate the compose message pop up UI by clicking on compose message button
	 *****************************************************************************************************/
	// Verifying the create new thread window
	@Test(priority = 4, enabled = true)
	public void verifyComposeMsgUITest() throws Throwable {
		Assert.assertTrue(composeMsg.verifyComposeMsgUI());
	}

	/*****************************************************************************************************
	 * Check the "To" field functionality in compose message pop up
	 *****************************************************************************************************/

	// Verify the To field by click on the send button with selecting any user
	@Test(priority = 5, enabled = true)
	public void verifyToFiledWithoutSelectUser() throws Throwable {
		String selectAtleasetOneUser = composeMsg.verifyToFiledWithoutSelectUser();
		Assert.assertEquals(selectAtleasetOneUser, "Please select at least one user.");
		System.out.println(selectAtleasetOneUser);
	}

	// Clicking on send button by entering invalid email id in To field
	@Test(priority = 6, enabled = true)
	public void verifyToField_InvalidEmail() throws Exception {
		String enterValidEmail = composeMsg
				.verifyToField_InvalidEmail(reader.getCellData(composeMessage, toField, 2));
		Assert.assertEquals(enterValidEmail, "Enter a valid email address.");
		System.out.println(enterValidEmail);
	}

	// Verify the To field by entering the basic contact with spaces and click on
	// send button
	@Test(priority = 7, enabled = true)
	public void verifyToField_BasicContactWithSpaces() throws Throwable {
		String enterValidEmail = composeMsg
				.verifyToField_BasicContactWithSpaces(reader.getCellData(composeMessage, toField, 3));
		Assert.assertEquals(enterValidEmail, "Enter a valid email address.");
		System.out.println(enterValidEmail);
	}

	// Verify the To filed functionality
	@Test(priority = 8, enabled = true)
	public void verifyToField_SelectSingleUser() throws Throwable {
		Assert.assertTrue(
				composeMsg.verifyToField_SelectSingleUser(reader.getCellData(composeMessage, toField, 4),
						reader.getCellData(composeMessage, toField, 5)));
	}

	// Verify the create group toggle by selecting the more than one user in To
	// field
	@Test(priority = 9, enabled = true)
	public void veriyCrateGroupToggle_Morethan1UserToField() throws Throwable {
		Assert.assertTrue(composeMsg.veriyCrateGroupToggle_SelectMorethanOneUser(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 5),
				reader.getCellData(composeMessage, toField, 6)));
	}

	// Click on send button by selecting an user and with out subject and message body
	@Test(priority = 10, enabled = true)
	public void composeMsgWithoutSubj_MsgBody() throws Throwable {

		Assert.assertTrue(
				composeMsg.composeMsgWithoutSubj_MsgBody(reader.getCellData(composeMessage, toField, 4),
						reader.getCellData(composeMessage, toField, 5)));
	}

	// Click on send button by selecting more than one user in to field with out subject and message body
	@Test(priority = 11, enabled = true)
	public void composeMsgMultipleUsers_ToField() throws Exception, Throwable {
		composeMsg.composeMsgMultipleUsers_ToField(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 5),
				reader.getCellData(composeMessage, toField, 7));
	}

	// Sending a message to already connected on-net user through compose message
	@Test(priority = 12, enabled = true)
	public void composeMsgConnectedOnnetUser() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.composeMsgConnectedOnnetUser(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 2),
				reader.getCellData(composeMessage, senderUserName, 2)));
	}

	// Sending a message to on-net user not in contacts list through compose message
	@Test(priority = 13, enabled = true)
	public void composeMsgOnnetUserNotInContacts() throws Throwable {
		Assert.assertTrue(composeMsg.composeMsgOnnetUserNotInContacts(
				reader.getCellData(composeMessage, toField, 8),
				reader.getCellData(composeMessage, toField, 9),
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 2),
				reader.getCellData(composeMessage, senderUserName, 2)));
	}

	// Sending a message to off-net user not in contacts list through compose
	// message
	@Test(priority = 14, enabled = true)
	public void composeMsgOffnetUserNotInContacts() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.composeMsgOffnetUserNotInContacts(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 10), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 2)));
	}

	// Sending message to an off-net user already in contacts list through compose
	// message
	@Test(priority = 15, enabled = true)
	public void composeMsgOffnetUserAlreadyInContacts() throws Exception, Throwable {
		String expectdSubj_Msg = "Subject: " + reader.getCellData(composeMessage, subject, 2) + "\n"
				+ reader.getCellData(composeMessage, message, 2);
		String actualSub_Msg = composeMsg.composeMsgOffnetUserAlreadyInContacts(
				reader.getCellData(composeMessage, toField, 11),
				reader.getCellData(composeMessage, subject, 2), 
				reader.getCellData(composeMessage, message, 2));
		Assert.assertTrue(actualSub_Msg.contains(expectdSubj_Msg));
		System.out.println(actualSub_Msg);
	}

	// Verify the +more option when an user selects more than 5 users in the To
	// field
	@Test(priority = 16, enabled = true)
	public void verifyToFieldMorethan5UsersTest() throws Throwable {

		String actualUsers = composeMsg.verifyToFieldMorethan5Users(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, toField, 7),
				reader.getCellData(composeMessage, toField, 5),
				reader.getCellData(composeMessage, toField, 12),
				reader.getCellData(composeMessage, toField, 13),
				reader.getCellData(composeMessage, toField, 14));
		String expectedUsers = driver.findElement(By.xpath("//*[@role='option' and contains(text(),'more')]"))
				.getText();
		Assert.assertEquals(actualUsers, expectedUsers);
		System.out.println(actualUsers);
	}

	// Verify the cursor position by press the TAB key when the cursor focus in To
	// field
	@Test(priority = 17, enabled = true)
	public void verifyCursorPositionToFieldTABKey() throws Throwable {
		WebElement actualCursorPosition = composeMsg.verifyCursorPositionToFieldTABKey();
		WebElement expectedCursorPosition = driver.findElement(By.xpath("//*[@id='subject']"));
		Assert.assertEquals(actualCursorPosition, expectedCursorPosition);
	}

	// Verify the removing of user from the To field by pressing the back space key
	// on keyboard
	@Test(priority = 18, enabled = true)
	public void verifyRemoveToFieldUserBackSpace() throws Throwable {
		Assert.assertTrue(
				composeMsg.verifyRemoveToFieldUserBackSpace(reader.getCellData(composeMessage, toField, 4),
						reader.getCellData(composeMessage, toField, 6)));
	}

	// Verify the message thread view, by selecting onnet users and off net users in
	// To filed from compose message and click on send button
	@Test(priority = 19, enabled = true)
	public void verifyMsgThread_Onnet$OffnetUsers_ToField() throws Throwable, Throwable {
		
		String actualMsg = composeMsg.verifyMsgThread_Onnet$OffnetUsers_ToField(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, toField, 11),
				reader.getCellData(composeMessage, toField, 11));
		String expectedMsg = "to" + reader.getCellData(composeMessage, toField, 6) + " and "
				+ reader.getCellData(composeMessage, toField, 11);
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		System.out.println(actualMsg);
	}

	/*****************************************************************************************************
	 * 			Check the "Cc" filed functionality in the compse message pop up
	 *****************************************************************************************************/
	// Verify the Cc field by clicking on the Cc link in To filed
	@Test(priority = 20, enabled = true)
	public void verifyCcLinkClicAction() {
		try {
			Assert.assertTrue(composeMsg.verifyCcLinkClicAction());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Verify the mouse hover action on the Cc link in To field
	@Test(priority = 21, enabled = true)
	public void verifyCcLinkMousehover() throws Throwable {
		Assert.assertTrue(composeMsg.verifyCcLinkMousehover());
	}

	// Verify the Cc field by using the keyboard short cut keys options on pressing
	// the "Ctrl+Shift+C"
	@Test(priority = 22, enabled = true)
	public void verifyCc_ShortCutKeys() throws Throwable {

		WebElement ccField = composeMsg.verifyCc_ShortCutKeys();
		WebElement cc = driver.findElement(By
				.xpath("//*[@class='mat-chip-list-wrapper']//*[text()='Cc']//following-sibling::*[@role='combobox']"));
		Assert.assertEquals(ccField, cc);
	}

	// Verify the Cc field by entering the invalid email address and Select an user
	// in To field
	@Test(priority = 23, enabled = true)
	public void verifyCc_InvalidEmailAddressTest() throws Throwable {
		String acutualValidation = composeMsg.verifyCc_InvalidEmailAddress(
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 4));
				
		Assert.assertEquals(acutualValidation, "Enter a valid email address.",
				"Actual and expected validations are not same");
		System.out.println(acutualValidation);
	}

	// Verify the message thread, by sending the message on selecting the user in cc
	// section only
	@Test(priority = 24, enabled = true)
	public void composeMsg_SingleUserCcFieldTest() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.composeMsg_SingleUserCcField(
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3), 
				reader.getCellData(composeMessage, subject, 2), 
				reader.getCellData(composeMessage, message, 2),
				reader.getCellData(composeMessage, senderUserName, 2)));
	}

	// Verify the Cc field by removing the selected user from Cc field using back
	// space key from keyboard
	@Test(priority = 25, enabled = true)
	public void verifyRemoveUserCc_Backspace() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.verifyRemoveUserCc_Backspace(reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3)));
	}

	// Verify the Cc field by removing the user name from the Cc field on clicking
	// the "x" symbol
	@Test(priority = 26, enabled = true)
	public void verifyRemoveCcUser_ClickXSym() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.verifyRemoveCcUser_ClickXSym(reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3)));
	}

	// Verify the "Create a group" toggle in subject field by entering more than one
	// user in Cc field
	@Test(priority = 27, enabled = true)
	public void verifyCreateGroupToggle_Morethan1UserCc() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.verifyCreateGroupToggle_Morethan1UserCc(
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 5)));
	}

	// Verify the message thread view, by selecting more than one user in Cc field
	// and no users in To field and click on send button
	@Test(priority = 28, enabled = true)
	public void composeMsg_Morethan1UserCc() throws Throwable {
		
		String actualCcUsers = composeMsg.composeMsg_Morethan1UserCc(reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 5));
		String expectedCcUsers = "cc" + reader.getCellData(composeMessage, ccField, 3) + " and "
				+ reader.getCellData(composeMessage, ccField, 5);
		Assert.assertTrue(actualCcUsers.contains(expectedCcUsers));
		System.out.println(actualCcUsers);
	}

	// Verify the message thread view, by selecting onnet user and offnet user in Cc
	// field and click on send button
	@Test(priority = 29, enabled = true)
	public void composeMsg_SelectOnnet$OffnetUsers_Cc() throws Throwable {
		String acutalUsers = composeMsg.composeMsg_Onnet$OffnetUsers_Cc(
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 7));
		String expectedUsers = "cc" + reader.getCellData(composeMessage, ccField, 3) + " and "
				+ reader.getCellData(composeMessage, ccField, 7);
		Assert.assertTrue(acutalUsers.contains(expectedUsers));
		System.out.println(acutalUsers);
	}

	// Verify the Cc field by selecting multiple onnet and offnet users and invalid
	// email address by clicking on send button
	@Test(priority = 30, enabled = true)
	public void composeMsg_OnnetOffnet$InvalidUsers_Cc() throws Throwable {
		String actualValidation = composeMsg.composeMsg_OnnetOffnet$InvalidUsers_Cc(
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 7),
				reader.getCellData(composeMessage, ccField, 4));
		Assert.assertEquals(actualValidation, "Enter a valid email address.");
		System.out.println(actualValidation);
	}

	// Verify the Cc field by selecting more than 5 users in Cc field and click on
	// send button
	@Test(priority = 31, enabled = true)
	public void verifyMorethan5Users_Cc() throws Throwable {
		String actualUsers = composeMsg.verifyMorethan5Users_Cc(reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, ccField, 6),
				reader.getCellData(composeMessage, ccField, 8),
				reader.getCellData(composeMessage, ccField, 9),
				reader.getCellData(composeMessage, ccField, 10));
		String expectedUsers = driver.findElement(By.xpath("//*[@role='option' and contains(text(),'more')]"))
				.getText();
		Assert.assertEquals(actualUsers, expectedUsers);
		System.out.println(actualUsers);
	}

	// Verify the cursor position by press the TAB key when the cursor position in
	// Cc field
	@Test(priority = 32, enabled = true)
	public void verifyCursorPosition_TABKey_Cc() throws Throwable {
		WebElement actualCursorPositon = composeMsg.verifyCursorPosition_TABKey_Cc();
		WebElement subject = driver.findElement(By.xpath("//*[@id='subject']"));
		Assert.assertEquals(actualCursorPositon, subject);
	}

	// Verify the Cc field by removing the invalid email address from the Cc field
	// and Click on send button only with valid email addresses
	@Test(priority = 33, enabled = true)
	public void composeMsg_RemoveInvalidEmail_Cc() throws Throwable {
		String actualUsers = composeMsg.composeMsg_RemoveInvalidEmail_Cc(
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3),
				reader.getCellData(composeMessage, ccField, 7),
				reader.getCellData(composeMessage, ccField, 4));
		String expectedUsers = "cc" + reader.getCellData(composeMessage, ccField, 3) + " and "
				+ reader.getCellData(composeMessage, ccField, 7);
		Assert.assertEquals(actualUsers, expectedUsers);
		System.out.println(actualUsers);
	}

	/*****************************************************************************************************
	 * Check the "To" and "Cc" by selecting the users and validate the same in
	 * message thread
	 * 
	 * @throws Throwable
	 *****************************************************************************************************/

	// Verify the To and Cc field without selecting any users and click on send
	// button
	@Test(priority = 34, enabled = true)
	public void verifyToCc_WithoutUsers() throws Throwable {
		String plsSelectAtleastOneUser = composeMsg.verifyToCc_WithoutUsers();
		Assert.assertEquals(plsSelectAtleastOneUser, "Please select at least one user.");
		System.out.println(plsSelectAtleastOneUser);
	}

	// Verify the To and Cc field by entering invalid email address and on clicking
	// send button
	@Test(priority = 35, enabled = true)
	public void verifyToCc_InvalidEmails() throws Throwable {
		String enterValidEmail = composeMsg.verifyToCc_InvalidEmails(
				reader.getCellData(composeMessage, toField, 2),
				reader.getCellData(composeMessage, ccField, 4));
		Assert.assertEquals(enterValidEmail, "Enter a valid email address.");
		System.out.println(enterValidEmail);
	}

	// Verify the "Create a group" toggle in subject field by selecting single users
	// in To and in Cc fields
	@Test(priority = 36)
	public void verifyCreateGroupToggle_ToCcUsers() throws Throwable {
		Assert.assertTrue(composeMsg.verifyCreateGroupToggle_ToCcUsers(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5)));
	}

	// Verify the message thread, by selecting single users in To and Cc fields and
	// click on send button
	@Test(priority = 37, enabled = true)
	public void composeMsg_SelectSingleUsersToCc() throws Throwable {
		String expectedToCcUsersMsgThead = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ 				reader.getCellData(composeMessage, ccField, 5);
		String actual = composeMsg.composeMsg_SelectSingleUsersToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 5));
		Assert.assertEquals(actual, expectedToCcUsersMsgThead);
		System.out.println(actual);
	}

	// Verify the message thread, by selecting onnet and offnet users in To and Cc
	// fields and click on send button
	@Test(priority = 38, enabled = true)
	public void composeMsg_OnnetOffnetUsers_ToCc() throws Throwable {
		String actualToCcUsers = composeMsg.composeMsg_OnnetOffnetUsers_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 7),
				reader.getCellData(composeMessage, ccField, 7));
		String expToCcUsers = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 7);
		Assert.assertTrue(actualToCcUsers.contains(expToCcUsers));
		System.out.println(actualToCcUsers);
	}

	// Verify the message thread, by selecting offnet users in To and Cc field and
	// click on send button
	@Test(priority = 39, enabled = true)
	public void composeMsg_OffnetUsers_ToCc() throws Throwable {
		String actualToCcUsers = composeMsg.composeMsg_OffnetUsers_ToCc(
				reader.getCellData(composeMessage, toField, 11),
				reader.getCellData(composeMessage, ccField, 11));
		String expToCcUsers = "to" + reader.getCellData(composeMessage, toField, 11) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 11);
		Assert.assertTrue(actualToCcUsers.contains(expToCcUsers));
		System.out.println(actualToCcUsers);
	}

	// Verify the To and Cc field, by entering invalid plain characters in To field
	// and select one or more users in Cc field
	@Test(priority = 40, enabled = true)
	public void verifyToField_EnterPlainText() throws Throwable {
		String plainText = composeMsg.verifyToField_EnterPlainText(
				reader.getCellData(composeMessage, toField, 2),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 3));
		Assert.assertEquals(plainText, "Enter a valid email address.");
		System.out.println(plainText);
	}

	// Verify the To and Cc field, by entering invalid plain characters in Cc field
	// and select one or more users in To field
	@Test(priority = 41, enabled = true)
	public void verifyCcField_EnterPlainText() throws Throwable {
		String plainText = composeMsg.verifyCcField_EnterPlainText(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 4));
		Assert.assertEquals(plainText, "Enter a valid email address.");
		System.out.println(plainText);
	}

	// Verify the message thread of users, by sending users in To field and Cc filed
	// also along with subject and message body
	@Test(priority = 42, enabled = true)
	public void composeMsg_To_Cc_MultipleUsers() throws Exception, Throwable {

		String to_Cc_MultipleUsers = composeMsg.composeMsg_To_Cc_MultipleUsers(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, toField, 7),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 6),
				reader.getCellData(composeMessage, ccField, 8),
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 2),
				reader.getCellData(composeMessage, senderUserName, 2));
		String expectedToCcUsers = "to" + reader.getCellData(composeMessage, toField, 6) + " and "
				+ reader.getCellData(composeMessage, toField, 7) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 6) + " and "
				+reader.getCellData(composeMessage, ccField, 8);
		Assert.assertTrue(to_Cc_MultipleUsers.contains(expectedToCcUsers));
		System.out.println(to_Cc_MultipleUsers);
	}

	/*****************************************************************************************************
	 * Validate the "Subject" field functionality in compose message pop up
	 * 
	 * @throws Throwable
	 * @throws Exception
	 *****************************************************************************************************/

	// Verify the subject field by entering the alphabets, select users in To and Cc
	// field and on click send button
	@Test(priority = 43, enabled = true)
	public void verifySubject_Alphabets_ToCc() throws Exception, Throwable {
		String acutalSubject = composeMsg.verifySubject_Alphabets_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 3));
		String expSubject = "Subject: " +reader.getCellData(composeMessage, subject, 3);
		Assert.assertTrue(acutalSubject.contains(expSubject));
		System.out.println(acutalSubject);
	}

	// Check the Subject field is accepting numbers or not, select users in To and Cc field and click on send button
	@Test(priority = 44, enabled = true)
	public void verifySubject_Numbers_ToCc() throws Throwable {
		String acutalSubject = composeMsg.verifySubject_Numbers_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), "1234567890");
		String expSubject = "Subject: " + "1234567890";
		Assert.assertTrue(acutalSubject.contains(expSubject));
		System.out.println(acutalSubject);
	}

	// Verify the subject field by entering the special characters and select the
	// users in To and click fields and click on send button
	@Test(priority = 45, enabled = true)
	public void verifySubject_SplChars_ToCc() throws Throwable {
		String acutalSubject = composeMsg.verifySubject_SplChars_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 4));
		String expSubject = "Subject: " + reader.getCellData(composeMessage, subject, 4);
		Assert.assertTrue(acutalSubject.contains(expSubject));
		System.out.println(acutalSubject);
	}

	// Verify the subject field by entering the combinations and select the users in
	// To and Cc fields and click on send button
	@Test(priority = 46, enabled = true)
	public void verifySubject_Combinations_ToCc() throws Throwable {
		String acutalSubject = composeMsg.verifySubject_Combinations_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 5));
		String expSubject = "Subject: " + reader.getCellData(composeMessage, subject, 5);
		Assert.assertTrue(acutalSubject.contains(expSubject));
		System.out.println(acutalSubject);
	}

	// Verify the subject field by entering the URL and select users in To and Cc
	// fields and click on send button
	@Test(priority = 47, enabled = true)
	public void verifySubject_URL_ToCc() throws Throwable {
		String acutalSubject = composeMsg.verifySubject_URL_ToCc(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 6));
		String expSubject = "Subject: " + reader.getCellData(composeMessage, subject, 6);
		Assert.assertTrue(acutalSubject.contains(expSubject));
		System.out.println(acutalSubject);
	}

	// Verify the subject field by entering the email id and select users in To and
	// Cc fields and click on send button
	@Test(priority = 48, enabled = true)
	public void verifySubject_EmailId_ToCc() throws Exception, Throwable {
		String acutalSubject = composeMsg.verifySubject_EmailId_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 7));
		String expSubject = "Subject: " + reader.getCellData(composeMessage, subject, 7);
		Assert.assertTrue(acutalSubject.contains(expSubject));
		System.out.println(acutalSubject);
	}

	// Verify the subject by entering the maximum limit of characters in subject
	// field
	@Test(priority = 49, enabled = true)
	public void verifySubject_MaxLimitChars_ComposeMsg() throws Exception, Throwable {
		String acutalSubject = composeMsg.verifySubject_MaxLimitChars_ComposeMsg(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 8));
		String expSubject = reader.getCellData(composeMessage, subject, 9);
		Assert.assertEquals(acutalSubject, expSubject);
		System.out.println(acutalSubject);
	}

	// Selecting single user in To field and entering only subject
	@Test(priority = 50, enabled = true)
	public void composeMsg_ToSingleUser_Subject() throws Throwable {
		String expected = "Subject: " + reader.getCellData(composeMessage, subject, 2);
		String actual = composeMsg.composeMsg_ToFieldSingleUser_Subject(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, subject, 2));

		Assert.assertEquals(actual, expected);
		System.out.println(actual);
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
