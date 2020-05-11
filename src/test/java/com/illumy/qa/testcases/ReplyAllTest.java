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
import com.illumy.qa.pages.ReplyAll;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ReplyAllTest extends TestBase{

	public ReplyAll replyAll;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "Reply All";
	String userToSelect		= "userToSelect";
	String message			= "message";
	String replyMsg			= "replyMsg";
	String searchEmojiKeys	= "searchEmojiKeys";
	String filePath			= "filePath";
	String fileName			= "fileName";
	String keys				= "keys";
	String groupName		= "groupName";
	
	
	String userToSelect_Row2	= new String (reader.getCellData(sheetName, userToSelect, 2));
	String userToSelect_Row3	= new String (reader.getCellData(sheetName, userToSelect, 3));
	String userToSelect_Row4	= new String (reader.getCellData(sheetName, userToSelect, 4));
	String message_Row2			= new String (reader.getCellData(sheetName, message, 2));
	String replyMsg_Row2		= new String (reader.getCellData(sheetName, replyMsg, 2));	
	String searchEmojiKeys_Row2	= new String (reader.getCellData(sheetName, searchEmojiKeys, 2));
	String filePath_Row2		= new String (reader.getCellData(sheetName, filePath, 2));
	String fileName_Row2		= new String (reader.getCellData(sheetName, fileName, 2));
	String fileName_Row5		= new String (reader.getCellData(sheetName, fileName, 5));
	String keys_Row2			= new String (reader.getCellData(sheetName, keys, 2));
	String keys_Row3			= new String (reader.getCellData(sheetName, keys, 3));
	String groupName_Row2		= new String (reader.getCellData(sheetName, groupName, 2));
	
	
	public ReplyAllTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		replyAll = new ReplyAll();
		testStart(result);
	}

	
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1,enabled=true)
	public void verifyReplyAllClickAction() throws Throwable {
		String replyAllPopupUser=replyAll.verifyReplyAllClickAction(userToSelect_Row2,message_Row2);
		
		Assert.assertTrue(replyAllPopupUser.contains(userToSelect_Row2));
		System.out.println(replyAllPopupUser);
	}
	
	/*Verify that by clicking on the reply all option for plain text message should 
	 * open a pop up with illumy-reply message in the Subject field. 
	 */
	@Test(priority=2,enabled=true)
	public void verifyReplyAllDefaultSubject() {
		String defaultSubject;
		try {
			defaultSubject = replyAll.verifyReplyAllDefaultSubject(userToSelect_Row2,message_Row2);
			Assert.assertEquals(defaultSubject, "illumy - Reply Message");
			System.out.println(defaultSubject);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Verify that pop-up header name is reply All
	@Test(priority=3,enabled=true)
	public void verifyReplyAllPopupHeader() throws Throwable {
		Assert.assertTrue(replyAll.verifyReplyAllPopupHeader(userToSelect_Row2, message_Row2));
	}

	// verify that the cross mark on the right corner of the popup
	@Test(priority=4,enabled=true)
	public void verifyReplyAllPopup_CrossMark() throws Throwable {
		Assert.assertTrue(replyAll.verifyReplyAllPopup_CrossMark(userToSelect_Row2, message_Row2));
	}

	// Verify that the pop up has @ mentions, Gif, Emoji, Attachment icons in bottom right corner
	@Test(priority=5,enabled=true)
	public void verifyReplyAllPopup_Icons() throws Throwable {
		Assert.assertTrue(replyAll.verifyReplyAllPopup_Icons(userToSelect_Row2, message_Row2));
	}

	// Verify that the reply message is attached with the reply all popup.
	@Test(priority=6,enabled=true)
	public void verifyReplyMsg_ReplyAllPopup() throws Throwable {
		String actualAttachedMsg=replyAll.verifyReplyMsg_ReplyAllPopup(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualAttachedMsg.contains(message_Row2));
		System.out.println(actualAttachedMsg);
	}

	// Verify that by clicking on the show message should view the reply content
	@Test(priority=7,enabled=true)
	public void verifyShowMsg_ReplyAllPopup() throws Throwable {
		String actualAttachedMsg=replyAll.verifyShowMsg_ReplyAllPopup(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualAttachedMsg.contains(message_Row2));
		System.out.println(actualAttachedMsg);
	}

	// Verify that by Clicking on the hide message should hide the visible content.
	@Test(priority=8,enabled=true)
	public void verifyHideMsg_ReplyAllPopup() throws Throwable {
		Assert.assertTrue(replyAll.verifyHideMsg_ReplyAllPopup(userToSelect_Row2, message_Row2));
	}

	/*************************************************************************************
							@mention functionality in Reply All pop up
	 ***************************************************************************************/
	//Verify the @mention icon click functionality in the reply all message without entering any users in To and Cc
	@Test(priority=9,enabled=true)
	public void verifyAtmentionClickAction_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAtmentionClickAction_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	//Verify the @ mentions auto suggestion pop up  by selecting on-net users in To or Cc
	@Test(priority=10,enabled=true)
	public void verifyOnnetUsers_AtmentionPopup_ReplyAll() throws Throwable {
		String atmentionPopupUsers=replyAll.verifyOnnetUsers_AtmentionPopup_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertTrue(atmentionPopupUsers.contains(userToSelect_Row2));
		System.out.println(atmentionPopupUsers);
	}
	
	//Verify the @ mention auto suggestions pop up by entering the @ using keyboard options "Shift+@"
	@Test(priority=11,enabled=true)
	public void verifyAtmentionPopup_Shortcut_ReplAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAtmentionPopup_Shortcut_ReplAll(userToSelect_Row2, message_Row2));	
	}
	
	// Verify the @ mentions auto suggestion pop up by pressing the "Space" key from keyboard
	@Test(priority=12,enabled=true)
	public void verifyAtmentionPopup_Space_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAtmentionPopup_Space_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the @ mentions auto suggestions pop up by pressing "Backspace" key from keyboard
	@Test(priority=13,enabled=true)
	public void verifyAtmentionPopup_Backspace_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAtmentionPopup_Backspace_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the message body by selecting an user from the auto suggestion pop up of @ mentions
	@Test(priority=14,enabled=true)
	public void verifyAtmentionUser_MsgBody_ReplyAll() throws Throwable {
		String atmentionUser_MsgBody=replyAll.verifyAtmentionUser_MsgBody_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertTrue(atmentionUser_MsgBody.contains("@"+userToSelect_Row2));
		System.out.println(atmentionUser_MsgBody);
	}

	// Verify the message thread by sending the selected user from @ mentions pop up
	@Test(priority=15,enabled=true)
	public void verifyAtmentionUser_MsgThread_ReplyAll() throws Throwable {
		String atmentionUser_MsgBody=replyAll.verifyAtmentionUser_MsgThread_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertTrue(atmentionUser_MsgBody.contains("@"+userToSelect_Row2));
		System.out.println(atmentionUser_MsgBody);
	}

	// Verify the '@' auto suggestions drop down menu by press the 'Esc' key on keyboard
	@Test(priority=16,enabled=true)
	public void verifyAtmentionPopup_Esc_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAtmentionPopup_Esc_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the online status of the logged in user in the @mention auto suggestions popup window
	@Test(priority=17,enabled=true)
	public void verifyOnlineStatus_AtmentionPopup() throws Throwable {
		Assert.assertTrue(replyAll.verifyOnlineStatus_AtmentionPopup(userToSelect_Row2, message_Row2,userToSelect_Row3));
	}

	// Verify the '@' auto suggestions drop down menu by clicking on "X" symbol
	@Test(priority=18,enabled=true)
	public void verifyAtmentionPopup_ClicXSym_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAtmentionPopup_ClicXSym_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the '@' icon functionality by selecting more than one user name from the auto suggestions drop down list
	@Test(priority=19,enabled=true)
	public void verifyMsgBody_Morethan1AtmentionUsers_ReplyAll() throws Throwable {
		String actualUsers=replyAll.verifyMsgBody_Morethan1AtmentionUsers_ReplyAll(userToSelect_Row2, message_Row2, userToSelect_Row3);
		String expUsers="@"+userToSelect_Row2+" "+"@"+userToSelect_Row3;
		Assert.assertTrue(actualUsers.contains(expUsers));
		System.out.println(actualUsers);
	}

	// Verify @mention pop-up by entering '@' for multiple times without giving any spaces using keyboard options "Shift+@"
	@Test(priority=20,enabled=true)
	public void enterMultipleAtmentions_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.enterMultipleAtmentions_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify @ mentions pop up by clicking on @mention icon from message body for multiple times without giving any spaces
	@Test(priority=21,enabled=true)
	public void clicMultipleAtmentions_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.clicMultipleAtmentions_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	
	/*************************************************************************************
							Emoji functionality in Reply All pop up
	 * @throws Throwable 
	 ***************************************************************************************/
	//Check  the click action on emoji icon in the message body
	@Test(priority=22,enabled=true)	
	public void verifyEmojiClickAction_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyEmojiClickAction_ReplyAll(userToSelect_Row2, message_Row2));
	}
		
	// Validate the scroll functionality by moving the mouse up and down
	@Test(priority=23,enabled=true)	
	public void verifyEmojiPopupScroll_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyEmojiPopupScroll_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the emoji pop up window by clicking on "X" symbol
	@Test(priority=24,enabled=true)	
	public void verifyEmojiPopupXSymbol_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyEmojiPopupXSymbol_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the emoji pop up by pressing "Esc" key on keyboard while pop up is in open
	@Test(priority=25,enabled=true)	
	public void verifyEmojiPopup_PressEscKey() throws Throwable {
		Assert.assertTrue(replyAll.verifyEmojiPopup_PressEscKey(userToSelect_Row2, message_Row2));
	}

	// Verify that the selected emojis are displaying in message body or not by selecting an emoji from emoji popup
	@Test(priority=26,enabled=true)	
	public void verifyMsgBody_SelectEmoji() throws Throwable {
		Assert.assertTrue(replyAll.verifyMsgBody_SelectEmoji(userToSelect_Row2, message_Row2));
	}

	// Verify the message thread by sending an emoji from compose message
	@Test(priority=27,enabled=true)	
	public void verifyMsgThread_SendEmoji() throws Throwable {
		Assert.assertTrue(replyAll.verifyMsgThread_SendEmoji(userToSelect_Row2, message_Row2));
	}

	/*
	 * Verify the emojis that are displaying or not in message body by selecting the
	 * multiple emojis using "Shift+Enter" keys on keyboard
	 */
	@Test(priority=28,enabled=true)	
	public void verifyMsgBody_SelectMultipleEmojis_ShiftEnter() throws Throwable {
		Assert.assertTrue(replyAll.verifyMsgBody_SelectMultipleEmojis_ShiftEnter(userToSelect_Row2, message_Row2));
	}

	// Verify the search field in emojis pop up window by clicking on emoji icon from message body
	@Test(priority=29,enabled=true)	
	public void verifySearchFieldEmojiPopup() throws Throwable {
		Assert.assertTrue(replyAll.verifySearchFieldEmojiPopup(userToSelect_Row2, message_Row2));
	}

	// Verify the search emoji by entering the keywords to search the emojis
	@Test(priority=30,enabled=true)	
	public void verifyEmojiPopupSearch_EnterValidKeys() throws Throwable {
		Assert.assertTrue(replyAll.verifyEmojiPopupSearch_EnterValidKeys(userToSelect_Row2, message_Row2,searchEmojiKeys_Row2));
	}

	// Verify the search emoji field by entering the invalid keywords to search the emojis
	@Test(priority=31,enabled=true)	
	public void verifyEmojiPopupSearch_EnterInvalidKeys() throws Throwable {
		String noEmojisFound=replyAll.verifyEmojiPopupSearch_EnterInvalidKeys(userToSelect_Row2, message_Row2,"sdfsfddsf");
		Assert.assertEquals(noEmojisFound, "No Emoji Found!");
		System.out.println(noEmojisFound);
	}

	// Verify the click action on "X" symbol in the search emoji field by entering the some keywords
	@Test(priority=32,enabled=true)	
	public void verifyXSymbol_EmojiSearchFiled() throws Throwable {
		Assert.assertTrue(replyAll.verifyXSymbol_EmojiSearchFiled(userToSelect_Row2, message_Row2,searchEmojiKeys_Row2));
	}
	
	
	/*************************************************************************************
							GIF functionality in Reply All pop up
	 * @throws Throwable 

	 ***************************************************************************************/
	//Verify the click functionality of 'GIF' icon in the message body of reply all
	@Test(priority=33,enabled=true)
	public void verifyGiphyClicAction_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphyClicAction_ReplyAll(userToSelect_Row2, message_Row2));
	}
	

	//Verify the giphy pop up window by clicking on "X" symbol
	@Test(priority=34,enabled=true)
	public void verifyGiphyPopup_ClicXsymbol_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphyPopup_ClicXsymbol_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	//Verify the GIPHY title mouse hover and its click functionality at header section  of the giphy  pop up window 
	@Test(priority=35,enabled=true)
	public void verifyGiphyPopupTitle_ReplyAll() throws Throwable {
		String giphyDotComTitle=replyAll.verifyGiphyPopupTitle_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertEquals(giphyDotComTitle, "GIPHY | Search All the GIFs & Make Your Own Animated GIF");
		System.out.println(giphyDotComTitle);
	}
	
	//Verify the search field in the giphy pop up window by clicking on the GIF icon from reply all popup
	@Test(priority=36,enabled=true)
	public void verifyGiphyPopup_SearchField_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphyPopup_SearchField_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	//Verify the search button is displaying or not in the giphy pop up window 
	@Test(priority=37,enabled=true)
	public void verifyGiphyPopup_SearchButton_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphyPopup_SearchButton_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	//Verify the giphy pop up by entering the invalid keywords to search the giphy's available in the giphy pop up window
	@Test(priority=38,enabled=true)
	public void verifyGiphySearch_Invalidkeys_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphySearch_Invalidkeys_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	//Verify the "X" symbol mouse hover and click functionality in the search field by entering some keywords on search field
	@Test(priority=39,enabled=true)
	public void verifyGiphySearchField_Xsym_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphySearchField_Xsym_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	//Verify the mouse over and click functionality of giphy's in the giphy pop up window
	@Test(priority=40,enabled=true)
	public void verifyGiphy_MsgThread_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyGiphy_MsgThread_ReplyAll(userToSelect_Row2, message_Row2));
	}
	
	
	/**********************************************************************************************************
	 * 									Attachment functionality in reply all pop up
	 * @throws Throwable 
	 **********************************************************************************************************/
	//Check the 'Attachment' icon click functionality on message body section
	@Test(priority=41,enabled=true)
	public void verifyAttachmentPopup_ReplyAll() throws Throwable {
		Assert.assertTrue(replyAll.verifyAttachmentPopup_ReplyAll(userToSelect_Row2, message_Row2));
	}

	// Verify the "My Computer" icon and its mouse hover functionality in the attachment pop pup window
	@Test(priority=42,enabled=true)
	public void verifyMyComputerTooltip_ReplyAll() throws Throwable {
		String mycomputer="My Computer";
		String actualTooltip=replyAll.verifyMyComputerTooltip_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, mycomputer);
		System.out.println(actualTooltip);
	}

	// Verify the click action on "My Computer" icon to send a file to user from the local system
	@Test(priority=43,enabled=true)
	public void verifyAttachmentFromMyComputer_ReplyAll() throws Throwable {
		String actualFileName=replyAll.verifyAttachmentFromMyComputer_ReplyAll(userToSelect_Row2, message_Row2,filePath_Row2,fileName_Row2);
		Assert.assertTrue(actualFileName.contains(fileName_Row2));
		System.out.println(actualFileName);
	}

	// Verify the "One Drive" icon and it's mouse hover action in the attachment pop up window
	@Test(priority=44,enabled=true)
	public void verifyOneDriveTooltip_ReplyAll() throws Throwable {
		String oneDrive="One Drive";
		String actualTooltip=replyAll.verifyOneDriveTooltip_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, oneDrive);
		System.out.println(actualTooltip);
	}

	// Verify the click functionality of "One Drive" icon in the attachment pop up window
	@Test(priority=45,enabled=true)
	public void verifyAttachmentFromOneDrive_ReplyAll() throws Throwable {
		String attachment_MsgThread=replyAll.verifyAttachmentFromOneDrive_ReplyAll(userToSelect_Row2, message_Row2,
				prop.getProperty("email"),prop.getProperty("password"), reader.getCellData(sheetName, fileName, 3));
		Assert.assertTrue(attachment_MsgThread.contains(reader.getCellData(sheetName, fileName, 3)));
		System.out.println(attachment_MsgThread);
	}

	// Verify the "Google Drive" icon and it's mouse hover action in the attachment pop up window
	@Test(priority=46,enabled=true)
	public void verifyGoogleDriveTooltip_ReplyAll() throws Throwable {
		String googleDrive="Google Drive";
		String actualTooltip=replyAll.verifyGoogleDriveTooltip_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, googleDrive);
		System.out.println(actualTooltip);
	}
	
	// Verify the "Drop Box" icon and it's mouse hover action in the attachments pop up window
	@Test(priority=47,enabled=true)
	public void verifyDropBoxTooltip_ReplyAll() throws Throwable {
		String dropbox="Dropbox";
		String actualTooltip=replyAll.verifyDropBoxTooltip_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, dropbox);
		System.out.println(actualTooltip);
	}

	// Verify the click functionality of "Drop Box" icon in the attachment pop up window
	@Test(priority=48,enabled=true)
	public void verifyAttachmetFromDropBox_ReplyAll() throws Throwable {
		String attachment_MsgThread=replyAll.verifyAttachmetFromDropBox_ReplyAll(userToSelect_Row2, message_Row2,
				prop.getProperty("email"),prop.getProperty("password"),
				reader.getCellData(sheetName, fileName, 5));
		Assert.assertTrue(attachment_MsgThread.contains(reader.getCellData(sheetName, fileName, 5)));
		System.out.println(attachment_MsgThread);
	}

	// Verify the "Box" icon and it's mouse hover action in the attachment pop up window
	@Test(priority=49,enabled=true)
	public void verifyBoxTooltip_ReplyAll() throws Throwable {
		String box="Box";
		String actualTooltip=replyAll.verifyBoxTooltip_ReplyAll(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, box);
		System.out.println(actualTooltip);
	}

	// Verify the click functionality of the "Box" icon in the attachments pop up window
	@Test(priority=50,enabled=true)
	public void verifyAttachmentFromBox_ReplyAll() throws Throwable {
		String attachment_MsgThread=replyAll.verifyAttachmentFromBox_ReplyAll(userToSelect_Row2, message_Row2,
				prop.getProperty("email"),prop.getProperty("password"),
				reader.getCellData(sheetName, fileName, 6));
		Assert.assertTrue(attachment_MsgThread.contains(reader.getCellData(sheetName, fileName, 6)));
		System.out.println(attachment_MsgThread);
	}	
	
	@Test(priority=51,enabled=true)
	public void replyAllMsgByAddingToAndCcUsers() throws Throwable {
		String actualtoAndCcUsers = replyAll.replyAllMsgByAddingToAndCcUsers(userToSelect_Row2, message_Row2, keys_Row2, userToSelect_Row4);
		String expToAndCcUsers	= "to"+userToSelect_Row2+"\n"+"cc"+userToSelect_Row4;
		Assert.assertTrue(actualtoAndCcUsers.contains(expToAndCcUsers));
		System.out.println(actualtoAndCcUsers);
	}

	
	//verify that the attached reply message should has blue bar beside it in the thread.
	@Test(priority=52,enabled=true)
	public void verifyReplyMsgBlueBarInThread() throws Throwable {
		Assert.assertTrue(replyAll.verifyReplyMsgBlueBarInThread(userToSelect_Row2, message_Row2));
	}

	
	//Verify that the replied message should have the View message option beside the replied message.
	@Test(priority=53,enabled=true)
	public void verifyViewMsgOptOfReplyMsgInThread() throws Throwable {
		Assert.assertTrue(replyAll.verifyViewMsgOptOfReplyMsgInThread(userToSelect_Row2, message_Row2));
	}

	
	//Verify that if we give reply all in Group only the group email will populates in To field
	@Test(priority=54,enabled=true)
	public void replyAllToGroup() throws Throwable {
		String actualReplyMsg = replyAll.replyAllToGroup(groupName_Row2, message_Row2);
		Assert.assertTrue(actualReplyMsg.contains(message_Row2));
		System.out.println(actualReplyMsg);
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
