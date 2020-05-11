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
import com.illumy.qa.pages.ComposeMessage;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ComposeMessageTest1 extends TestBase{

	public ComposeMessage composeMsg;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	String composeMessage = "ComposeMessage";
	String toField = "toField";
	String ccField="CcField";
	String userToSelect = "userToSelect";
	String subject = "subject";
	String message = "message";
	String atMentions = "atMentions";
	String invalidEmail = "invalidEmail";
	String offnetUser = "offnetUser";
	String groupName = "groupName";
	String senderUserName = "senderUserName";
	String emojiKeys="emojiKeys";
	String filePath="filePath";
	String fileName="fileName";
	
	public ComposeMessageTest1() {
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
	 * Verify the "Create a Group" toggle functionality in the subject field of the
	 * compose message pop up
	 * 
	 * @throws Throwable
	 * @throws Exception
	 *****************************************************************************************************/
	// Verify the "Create a group" toggle by default is in disable mode or not when
	// user selected more than one users in To or Cc field
	@Test(priority = 51, enabled = true)
	public void verifyCreateGroupToggle_Default() throws Exception, Throwable {
		String expColor = "#fafafa";
		String actColor = composeMsg.verifyCreateGroupToggle_Default(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5));
		Assert.assertEquals(actColor, expColor);
		System.out.println(actColor);
	}

	// Verify the create group toggle enabled status
	@Test(priority = 52, enabled = true)
	public void verifyCreateGroupToggle_EnableStatus() throws Exception, Throwable {
		String expColor = "#2e008b";
		String actColor = composeMsg.verifyCreateGroupToggle_EnableStatus(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5));
		Assert.assertEquals(actColor, expColor);
		System.out.println(actColor);
	}

	// Verify the "Group Name" place holder on enable the create a group toggle
	@Test(priority = 53, enabled = true)
	public void verifyGroupNamePlaceholder() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.verifyGroupNamePlaceholder(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6),
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5)));
	}

	/*****************************************************************************************************
	 * Verify the "Message body" in the compose message
	 * 
	 * @throws Throwable
	 * @throws Exception
	 *****************************************************************************************************/

	// Verify the message body of compose message on entering the alphabets and
	// Select users in To and Cc and click on send button
	@Test(priority = 54, enabled = true)
	public void verifyMsgBody_Alphabet() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgBody_Alphabet(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 3));
		String expMsg = "to" + 	reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "Subject: "
				+ reader.getCellData(composeMessage, subject, 2) + "\n"
				+ reader.getCellData(composeMessage, message, 3);
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);

	}

	// Verify the message body of compose message on entering the numbers and select
	// users in To and Cc and click on send button
	@Test(priority = 55, enabled = true)
	public void verifyMsgBody_Numbers() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgBody_Numbers(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				"1234567890");
		String expMsg = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "Subject: "
				+ reader.getCellData(composeMessage, subject, 2)+ "\n" + "1234567890";
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);
	}

	// Verify the message body of compose message on entering the special characters
	// and select users in To and Cc and click on send button
	@Test(priority = 56, enabled = true)
	public void verifyMsgBody_SplChars() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgBody_SplChars(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 4));
		String expMsg = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "Subject: "
				+ reader.getCellData(composeMessage, subject, 2) + "\n"
				+ reader.getCellData(composeMessage, message, 4);
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);
	}

	// Verify the message body of compose message on entering the alphanumeric
	// cominations and select users in To and Cc and click on send button
	@Test(priority = 57, enabled = true)
	public void verifyMsgBody_Combinations() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgBody_Combinations(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 5));
		String expMsg = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "Subject: "
				+ reader.getCellData(composeMessage, subject, 2) + "\n"
				+ reader.getCellData(composeMessage, message, 5);
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);
	}

	// Verify the message body of compose message by sending URL and select users in
	// To and Cc and click on send button
	@Test(priority = 58, enabled = true)
	public void verifyMsgBody_URL() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgBody_URL(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 6));
		String expMsg = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "Subject: "
				+ reader.getCellData(composeMessage, subject, 2) + "\n"
				+ reader.getCellData(composeMessage, message, 6);
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);
	}

	// Verify the message body of compose message by sending email address and
	// select users in To and Cc and click on send button
	@Test(priority = 59, enabled = true)
	public void verifyMsgBody_Email() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgBody_Email(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 7));
		String expMsg = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "Subject: "
				+ reader.getCellData(composeMessage, subject, 2) + "\n"
				+ reader.getCellData(composeMessage, message, 7);
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);
	}

	// Verify the message body scroll on entering the long text
	@Test(priority = 60, enabled = true)
	public void verifyMsgBody_Scroll() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.verifyMsgBody_Scroll(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5), 
				reader.getCellData(composeMessage, subject, 2),
				 reader.getCellData(composeMessage, message, 8)));
	}

	/*****************************************************************************************************
	 * Verify the grouping functionality in the compose message
	 * 
	 * @throws Throwable
	 * @throws Exception
	 *****************************************************************************************************/

	// Verify the group field, without specifying any group name and click on send
	// button after selection the more than one users
	@Test(priority = 61, enabled = true)
	public void verifyCreateGroup_WithoutGroupName() throws Exception, Throwable {
		String groupNameReq = composeMsg.verifyCreateGroup_WithoutGroupName(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5));
		Assert.assertEquals(groupNameReq, "Required");
		System.out.println(groupNameReq);
	}

	// Create a new group of more than one users in To or Cc fields (either onnet or
	// offnet) along with the group name
	@Test(priority = 62, enabled = true)
	public void createNewGroup_WithGroupName() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.createNewGroup_WithGroupName(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, groupName, 2),
				 reader.getCellData(composeMessage, message, 2)));
	}

	// Create a group with the different users and same group name which is already
	// existed in the contacts list
	@Test(priority = 63, enabled = true)
	public void createGroupDiffUsers_ExistedGroupName() throws Exception, Throwable {
		String existedGroupName = composeMsg.createGroupDiffUsers_ExistedGroupName(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, groupName, 3),
				 reader.getCellData(composeMessage, message, 2));
		Assert.assertEquals(existedGroupName, "Group Name Already Exists");
		System.out.println(existedGroupName);
	}

	// Create a group with the same group members and same group name which is
	// already existed in the contacts list
	@Test(priority = 64, enabled = true)
	public void createGroupSameUsers_SameGroupName() throws Exception, Throwable {
		String actualGroupMsgThread = composeMsg.createGroupSameUsers_SameGroupName(
				reader.getCellData(composeMessage, toField, 15),
				reader.getCellData(composeMessage, toField, 16), 
				reader.getCellData(composeMessage, ccField, 12),
				reader.getCellData(composeMessage, ccField, 13),
				reader.getCellData(composeMessage, groupName, 3),
				 reader.getCellData(composeMessage, message, 2));
		String expGroupMsgThread = "Subject: " + reader.getCellData(composeMessage, groupName, 3) + "\n"
				+ reader.getCellData(composeMessage, message, 2);
		Assert.assertTrue(actualGroupMsgThread.contains(expGroupMsgThread));

		System.out.println(actualGroupMsgThread);
	}

	// Create a group with different group name and same users who are already group
	// members of a other group
	@Test(priority = 65, enabled = true)
	public void createGroup_SameUsers_DiffGroupName() throws Exception, Throwable {
		Assert.assertTrue(composeMsg.createGroup_SameUsers_DiffGroupName(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, groupName, 3),
				 reader.getCellData(composeMessage, message, 2)));
	}

	/*****************************************************************************************************
	 * Check the @mention functionality in compose message pop up
	 * 
	 * @throws Throwable
	 *****************************************************************************************************/

	// Verify the @mention icon click functionality in the compose message without
	// entering any users in To and Cc
	@Test(priority = 66, enabled = true)
	public void clicAtmention_ComposeMsg() throws Throwable {
		Assert.assertTrue(composeMsg.clicAtmention_ComposeMsg());
	}

	// Verify the @ mentions auto suggestion pop up by selecting onnet users in To
	// or Cc
	@Test(priority = 67, enabled = true)
	public void verifyAtmentionPopup_OnnetUsers_ToCc() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAtmentionPopup_OnnetUsers_ToCc(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, subject, 2)));
	}

	// Verify the @ mention auto suggestions pop up by entering the @ using keyboard
	// options "Shift+@"
	@Test(priority = 68, enabled = true)
	public void verifyAtmentionPopup_Shortcutkeys() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAtmentionPopup_Shortcutkeys());
	}

	// Verify the @ mentions auto suggestion pop up by pressing the "Space" key from
	// keyboard
	@Test(priority = 69, enabled = true)
	public void verifyAtmentionPopup_Space() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAtmentionPopup_Space());
	}

	// Verify the @ mentions auto suggestions pop up by pressing "Backspace" key
	// from keyboard
	@Test(priority = 70, enabled = true)
	public void verifyAtmentionPopup_Backspace() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAtmentionPopup_Backspace());
	}

	// Verify the message thread by sending the selected user from @ mentions pop up
	@Test(priority = 71, enabled = true)
	public void verifyMsgThread_AtmentionUser() throws Exception, Throwable {
		String actualMsg = composeMsg.verifyMsgThread_AtmentionUser(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, subject, 2),
				reader.getCellData(composeMessage, message, 2));
		String expMsg = "@"+reader.getCellData(composeMessage, toField, 6) + " "
				+ reader.getCellData(composeMessage, message, 2);
		Assert.assertTrue(actualMsg.contains(expMsg));
		System.out.println(actualMsg);
	}

	// Verify the '@' auto suggestions drop down menu by press the 'Esc' key on
	// keyboard
	@Test(priority = 72, enabled = true)
	public void verifyAtmentionPopup_Esc() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAtmentionPopup_Esc());
	}

	// Verify the '@' auto suggestions drop down menu by clicking on "X" symbol
	@Test(priority = 73, enabled = true)
	public void verifyAtmentionPopup_ClicXSymbol() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAtmentionPopup_ClicXSymbol());
	}

	// Verify the '@' icon functionality by selecting more than one user name from
	// the auto suggestions drop down list
	@Test(priority = 74, enabled = true)
	public void verifyMsgThread_SelectMorethan1AtmentionUsers() throws Exception, Throwable {
		String actMsg = composeMsg.verifyMsgThread_SelectMorethan1AtmentionUsers(
				reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6), 
				reader.getCellData(composeMessage, ccField, 2),
				reader.getCellData(composeMessage, ccField, 5),
				reader.getCellData(composeMessage, message, 2));
		String expMsg = "to" + reader.getCellData(composeMessage, toField, 6) + "\n" + "cc"
				+ reader.getCellData(composeMessage, ccField, 5) + "\n" + "@"
				+ reader.getCellData(composeMessage, toField, 6) + " " + "@"
				+ reader.getCellData(composeMessage, ccField, 5) + " "
				+ reader.getCellData(composeMessage, message, 2);
		Assert.assertTrue(actMsg.contains(expMsg));
		System.out.println(actMsg);
	}

	// Verify @mention pop up by entering '@' for multiple times without giving any
	// spaces using keyboard options "Shift+@"
	@Test(priority = 75, enabled = true)
	public void enterMultipleAtmentionsWithoutSpace_Shortkeys() throws Throwable {
		Assert.assertTrue(composeMsg.enterMultipleAtmentionsWithoutSpace_Shortkeys());
	}

	// Verify @ mentions pop up by clicking on @mention icon from message input
	// field for multiple times without giving any spaces
	@Test(priority = 76, enabled = true)
	public void clicMultipleAtmentionsWithoutSpace_Mouse() throws Throwable {
		Assert.assertTrue(composeMsg.clicMultipleAtmentionsWithoutSpace_Mouse());
	}

	/*****************************************************************************************************
	 * Verify the Emoji functionality in the compose message
	 *****************************************************************************************************/

	// Check the click action on emoji icon in the message body
	@Test(priority = 77, enabled = true)
	public void verifyClicActionEmojiIcon() throws InterruptedException {
		Assert.assertTrue(composeMsg.verifyClicActionEmojiIcon());
	}

	// Validate the scroll functionality by moving the mouse up and down
	@Test(priority = 78, enabled = true)
	public void verifyEmojiPopupScroll() throws Throwable {
		Assert.assertTrue(composeMsg.verifyEmojiPopupScroll());
	}

	// Verify the emoji pop up window by clicking on "X" symbol
	@Test(priority = 79, enabled = true)
	public void verifyEmojiPopupXSymbol() throws Throwable {
		Assert.assertTrue(composeMsg.verifyEmojiPopupXSymbol());
	}

	// Verify the emoji pop up by pressing "Esc" key on keyboard while pop up is in open
	@Test(priority = 80, enabled = true)
	public void verifyEmojiPopup_PressEscKey() throws Throwable {
		Assert.assertTrue(composeMsg.verifyEmojiPopup_PressEscKey());
	}

	// Verify that the selected emojis are displaying in message body or not by selecting an emoji from emoji popup
	@Test(priority = 81, enabled = true)
	public void verifyMsgBody_SelectEmoji() throws Throwable {
		Assert.assertTrue(composeMsg.verifyMsgBody_SelectEmoji());
	}

	// Verify the message thread by sending an emoji from compose message
	@Test(priority = 82, enabled = true)
	public void verifyMsgThread_SendEmoji() throws Throwable {
		Assert.assertTrue(composeMsg.verifyMsgThread_SendEmoji(reader.getCellData(composeMessage, toField, 4),
				reader.getCellData(composeMessage, toField, 6)));
	}

	// Verify the emojis that are displaying or not in message body by selecting the
	// multiple emojis using "Shift+Enter" keys on keyboard
	@Test(priority = 83, enabled = true)
	public void verifyMsgBody_SelectMultipleEmojis_ShiftEnter() throws Throwable {
		Assert.assertTrue(composeMsg.verifyMsgBody_SelectMultipleEmojis_ShiftEnter());
	}

	// Verify the search field in emojis pop up window by clicking on emoji icon from message body
	@Test(priority = 84, enabled = true)
	public void verifySearchFieldEmojiPopup() throws Throwable {
		Assert.assertTrue(composeMsg.verifySearchFieldEmojiPopup());
	}

	// Verify the search emoji by entering the keywords to search the emojis
	@Test(priority = 85, enabled = true)
	public void verifyEmojiPopupSearch_EnterValidKeys() throws Throwable {
		Assert.assertTrue(composeMsg.verifyEmojiPopupSearch_EnterValidKeys(reader.getCellData(composeMessage, emojiKeys, 2)));
	}

	// Verify the search emoji field by entering the invalid keywords to search the emojis
	@Test(priority = 86, enabled = true)
	public void verifyEmojiPopupSearch_EnterInvalidKeys() throws Exception, Throwable {
		String noEmojisFound=composeMsg.verifyEmojiPopupSearch_EnterInvalidKeys(reader.getCellData(composeMessage, emojiKeys, 3));
		Assert.assertEquals(noEmojisFound, "No Emoji Found!");
		System.out.println(noEmojisFound);
	}

	// Verify the click action on "X" symbol in the search emoji field by entering the some keywords
	@Test(priority = 87, enabled = true)
	public void verifyXSymbol_EmojiSearchFiled() throws Throwable {
		Assert.assertTrue(composeMsg.verifyXSymbol_EmojiSearchFiled(reader.getCellData(composeMessage, emojiKeys, 2)));
	}

	/*****************************************************************************************************
	 * Verify the giphy functionality in the compose message pop up window
	 * @throws Throwable 
	 *****************************************************************************************************/
	// Verify the click functionality of 'GIF' icon in the message body of compose message
	@Test(priority = 88, enabled = true)
	public void verifyGiphyClicAction() throws Throwable {
		Assert.assertTrue(composeMsg.verifyGiphyClicAction());
	}

	// Verify the giphy pop up window by clicking on "X" symbol
	@Test(priority = 89, enabled = true)
	public void verifyGiphyPopup_ClicXsymbol() throws Throwable {
		Assert.assertTrue(composeMsg.verifyGiphyPopup_ClicXsymbol());
	}

	// Verify the GIPHY title mouse hover and its click functionality at header section of the giphy pop up window
	@Test(priority = 90, enabled = true)
	public void verifyGiphyPopupTitle() throws Throwable {
		String giphyDotComTitle=composeMsg.verifyGiphyPopupTitle();
		Assert.assertEquals(giphyDotComTitle, "GIPHY | Search All the GIFs & Make Your Own Animated GIF");
		System.out.println(giphyDotComTitle);
	}

	// Verify the search field in the giphy pop up window by clicking on the GIF icon from message input field
	@Test(priority = 91, enabled = true)
	public void verifyGiphyPopup_SearchField() throws Throwable {
		Assert.assertTrue(composeMsg.verifyGiphyPopup_SearchField());
	}

	// Verify the search button is displaying or not in the giphy pop up window
	@Test(priority = 92, enabled = true)
	public void verifyGiphyPopup_SearchButton() throws Throwable {
		Assert.assertTrue(composeMsg.verifyGiphyPopup_SearchButton());
	}

	// Verify the giphy pop up by entering the invalid keywords to search the giphy's available in the giphy pop up window
	@Test(priority = 93, enabled = true)
	public void verifyGiphySearch_Invalidkeys() throws Throwable {
		Assert.assertTrue(composeMsg.verifyGiphySearch_Invalidkeys());
	}

	// Verify the "X" symbol mouse hover and click functionality in the search field by entering some keywords on search field
	@Test(priority = 94, enabled = true)
	public void verifyGiphySearchField_xSymbol() throws Throwable {
		Assert.assertTrue(composeMsg.verifyGiphySearchField_xSymbol());	
	}

	// Verify the mouse over and click functionality of giphy's in the giphy pop up window
	@Test(priority = 95, enabled = true)
	public void verifySelectGiphyFromPopup() throws Throwable {
		Assert.assertTrue(composeMsg.verifySelectGiphyFromPopup());
	}
	

	/*****************************************************************************************************
	 * Verify the attachments functionality in the compose message pop up window
	 * @throws Throwable 
	 *****************************************************************************************************/
	
	//Check the 'Attachment' icon click functionality on message body section
	@Test(priority = 96, enabled = true)
	public void verifyAttachmentClickAction() throws Throwable {
		Assert.assertTrue(composeMsg.verifyAttachmentClickAction());
	}
	
	//Verify the "My Computer" icon and its mouse hover functionality in the attachment pop pup window 
	@Test(priority = 97, enabled = true)
	public void verifyMyComputerTooltip() throws Throwable {
		String mycomputer="My Computer";
		String actualTooltip=composeMsg.verifyMyComputerTooltip();
		Assert.assertEquals(actualTooltip, mycomputer);
		System.out.println(actualTooltip);
	}
	
	//Verify the click action on "My Computer" icon to send a file to user  from the local system 
	@Test(priority = 98, enabled = true)
	public void verifyAttachmentMsgBody_MyComputer() throws Exception, Throwable {
		String filename=composeMsg.verifyAttachmentMsgBody_MyComputer(reader.getCellData(composeMessage, filePath, 2));
		Assert.assertTrue(filename.contains(reader.getCellData(composeMessage, fileName, 2)));
		System.out.println(filename);	
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
