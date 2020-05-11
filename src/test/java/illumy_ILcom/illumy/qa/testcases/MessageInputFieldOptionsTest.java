/**
 * 
 */
package illumy_ILcom.illumy.qa.testcases;

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
import com.illumy.qa.pages.MessageInputField;
import com.illumy.qa.pages.MessageInputFieldOptions;
import com.illumy.qa.pages.SigninPage;

/**
 * @author thambibabu.dasari
 *
 */
public class MessageInputFieldOptionsTest extends TestBase{

	public  MessageInputFieldOptions msgInputFieldOptions;
	public  SigninPage signinPage;
	public static HomePage homePage;
	
	public MessageInputFieldOptionsTest() {
		super();
	}
	
	String userToSelect="test email";
	String userToSelect1="Thambi Babu Dasari";
	String userToSelect2="test account two";
	String userToSelect3="test account three";
	String offnetUserToSelect="thambibabu.dasari@illumy.com";
	String groupName="test group2";
	String everyone="Everyone";
	String msgInputFieldTxt="This is a test message for automation test scripts";
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		msgInputFieldOptions=new MessageInputFieldOptions();
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	

	/*
	 * Verify the click action on '@' icon from message input field of on-net users P2P message thread
	 */
	@Test(priority=1,enabled=true)
	public void verifyAtMentionClilckActionTest() throws Throwable {
	String users=msgInputFieldOptions.verifyAtMentionClilckAction(userToSelect,userToSelect1);
	Assert.assertTrue(users.contains(userToSelect+"\n"+userToSelect1));
	System.out.println(users);
	}
	
	//Verify the @ mentions auto suggestion pop up  of the off-net user
	@Test(priority=2,enabled=true)
	public void verifyOffnetUserAtmentionClickActionTest() throws Throwable {
		String offnetUserAtmention=msgInputFieldOptions.verifyAtmentionClickAction_OffnetUser(offnetUserToSelect, userToSelect1);
		Assert.assertEquals(offnetUserAtmention, userToSelect1);
		System.out.println(offnetUserAtmention);
	}

	//Verify the @ mentions auto suggestion pop up for groups by clicking on the "@" icon in the message input field
	@Test(priority=3,enabled=true)
	public void verifyAtmentionsClickAction_GroupTest() throws Throwable {
		String everyoneOption=msgInputFieldOptions.verifyAtmentionsClickAction_Group(groupName,everyone);
		Assert.assertTrue(everyoneOption.contains("Everyone"));
		System.out.println(everyoneOption);
	}
	
	//Verify the message input field by selecting the "Everyone" option from the @mentions popup
	@Test(priority=4,enabled=true)
	public void verifyEveryone_GroupMsgInputField() throws Throwable {
		String everyoneInMsgInput=msgInputFieldOptions.verifyEveryone_GroupMsgInputField(groupName, everyone);
		Assert.assertEquals(everyoneInMsgInput, "@everyone ");
		System.out.println(everyoneInMsgInput);
	}

	//Verify the message thread by sending the text message by selecting the "Everyone" from @mentions auto suggestions popup
	@Test(priority=5,enabled=true)
	public void verifyMsgThread_Text_EveryoneTest() throws Throwable {
		String threadMsgs=msgInputFieldOptions.verifyMsgThread_Text_Everyone(groupName, everyone,prop.getProperty("msgInputFieldText"));
		Assert.assertEquals(threadMsgs, "@everyone "+msgInputFieldTxt);
		
		System.out.println(threadMsgs);
		
	}
	
	//Verify the @ mention auto suggestions pop up by entering the @ using keyboard options "Shift+@"
	@Test(priority=6,enabled=true)
	public void verifyAtmentionPopup_ShiftAndAtmentionTest() throws Throwable {
		String users=msgInputFieldOptions.verifyAtmentionPopup_ShiftAndAtmention(userToSelect,userToSelect1);
		Assert.assertTrue(users.contains(userToSelect+"\n"+userToSelect1));
		System.out.println(users);
	}
	
	//Verify the @ mentions auto suggestion pop up by pressing the "Space" key from keyboard
	@Test(priority=7,enabled=true)
	public void verifyAtmentionPopup_SpaceKeyTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAtmentionPopup_SpaceKey(userToSelect));
	}
	
	//Verify the @ mentions auto suggestions pop up by pressing "Backspace" key from keyboard 
	@Test(priority=8,enabled=true)
	public void verifyAtmentionPopup_BackspaceTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAtmentionPopup_Backspace(userToSelect));
	}
	
	//Verify the message input field by selecting an user from the auto suggestion pop up of @ mentions
	@Test(priority=9,enabled=true)
	public void verifyMsgInputField_AtmentionUserTest() throws Throwable {
		String userWithAtmention=msgInputFieldOptions.verifyMsgInputField_AtmentionUser(userToSelect);
		Assert.assertEquals(userWithAtmention, "@"+userToSelect+" ");
		System.out.println(userWithAtmention);	
	}
	
	//Verify the message thread by sending the selected user from @ mentions pop up 
	@Test(priority=10,enabled=true)
	public void verifyMsgThread_AtmentionUserTest() throws Throwable {
		String atmentionUser_Text=msgInputFieldOptions.verifyMsgThread_AtmentionUser(userToSelect, prop.getProperty("msgInputFieldText"));
		Assert.assertTrue(atmentionUser_Text.contains(userToSelect+" "+msgInputFieldTxt));
		System.out.println(atmentionUser_Text);
	}
	
	//Validate the text 'people matching "@" in the at mentions pop up  by clicking on '@' icon
	@Test(priority=11,enabled=true)
	public void validatePeopleMatchingText_AtmentionPopup() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.validatePeopleMatchingText_AtmentionPopup(userToSelect));
	}
	
	//Verify the text 'tab or to navigate' in the at mentions pop up by clicking on '@' icon
	@Test(priority=12,enabled=true)
	public void verifyTaborNavigateText_AtmentionPopup() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyTaborNavigateText_AtmentionPopup(userToSelect));
	}
	
	//Verify the '@' auto suggestions drop down menu by press the 'Esc' key on keyboard
	@Test(priority=13,enabled=true)
	public void verifyAtmentionPopup_EscKeyTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAtmentionPopup_EscKey(userToSelect));
	}
	
	//Verify the online status of the logged in user in the @mention auto suggestions popup window
	@Test(priority=14,enabled=true)
	public void verifyOnlineStatus_AtmentionPopupTest() throws Throwable {
		msgInputFieldOptions.verifyOnlineStatus_AtmentionPopup(userToSelect);
		
	}
	
	//Verify the message input field by selecting an user from @mentions pop up using "Enter" key using keyboard
	@Test(priority=15,enabled=true)
	public void verifyMsgInput_SelectUser_AtmentionPopup() throws Throwable {
		String user_MsgInputField=msgInputFieldOptions.verifyMsgInput_SelectUser_AtmentionPopup(userToSelect);
		Assert.assertTrue(user_MsgInputField.contains(userToSelect1));
		System.out.println(user_MsgInputField);
	}
	
	//Verify the '@' auto suggestions popup by clicking on "X" symbol 
	@Test(priority=16,enabled=true)
	public void verifyAtmentionPopup_XSymbolClick() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAtmentionPopup_ClickXSymbol(userToSelect));
	}
	
	//Verify the '@' icon functionality by selecting more than one user name from the auto suggestions drop down list
	@Test(priority=17,enabled=true)
	public void verifyMsgThreadTwoAtmentionUsersTest() throws Throwable {
		String atmentionUserMsgThread=msgInputFieldOptions.verifyMsgThreadSendingTwoAtmentionUsers(userToSelect, userToSelect1);
		Assert.assertEquals(atmentionUserMsgThread, "@"+userToSelect+" "+"@"+userToSelect1);
		System.out.println(atmentionUserMsgThread);
	}
	
	//Verify @mention pop up by entering '@' for multiple times without giving any spaces using keyboard options "Shift+@"
	@Test(priority=18,enabled=true)
	public void verifyAtmentionPopup_EnterMultipleAtmentions() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAtmentionPopup_EnterMultipleAtmentions(userToSelect));
	}
	
	//Verify @ mentions pop up by clicking on @mention icon from message input field for multiple times without giving any spaces
	@Test(priority=19,enabled=true)
	public void verifyAtmentionPopup_ClickMultipleAtmentions() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAtmentionPopup_ClickMultipleAtmentions(userToSelect));
	}
	
	
	/*************************************************************************************************
	 * 						EMOJI FUNCTIONALITY IN MESSAGE INPUT FIELD
	************************************************************************************************/
	
	//Check  the click action on emoji icon in the message input field 
	@Test(priority=20,enabled=true)
	public void verify_EmojiClickActionTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verify_EmojiClickAction(userToSelect));
	}
	
	//Verify the frequently used emoji's in the emoji pop up by clicking on emoji icon from message input field
	@Test(priority=21,enabled=true)
	public void verifyFrequentlyUseddEmojisTest() throws Throwable {
		msgInputFieldOptions.verifyFrequentlyUseddEmojis(userToSelect);
	}
	
	//Validate the scroll functionality by moving the mouse up and down
	@Test(priority=22,enabled=true)
	public void verifyEmojiPopupScrollTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopupScroll(userToSelect));
	}
	
	/*Verify the emoji pop up window by clicking on "X" symbol 
	 * by clicking on emoji icons from message input field
	*/
	@Test(priority=23,enabled=true)
	public void verifyEmojiPopup_ClickXSymbol() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopup_ClickXSymbol(userToSelect));
	}
	
	//Verify the emoji pop up by pressing "Esc" key on keyboard while pop up is in open 
	@Test(priority=24,enabled=true)
	public void verifyEmojiPopup_EscKeyTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopup_EscKey(userToSelect));
	}
	
	//Verify that the selected emojis are displaying in message input field or not by selecting an emoji from emoji popup 
	@Test(priority=25,enabled=true)
	public void verifyMsgInputField_SelectEmoji() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyMsgInputField_SelectEmoji(userToSelect));
	}
	
	//Verify the message thread by sending an emoji from message input field
	@Test(priority=26,enabled=true)
	public void verifyMsgThread_SendEmoji() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyMsgThread_SendEmoji(userToSelect));
	}
	
	//Verify the emojis that are displaying or not in message input field by selecting the multiple emojis using "Shift+Enter" keys on keyboard
	@Test(priority=27,enabled=true)
	public void verifyMsgInputField_SelectEmojisShiftEnter() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyMsgInputField_SelectEmojisShiftEnter(userToSelect));
	}
	
	//Verify the search emoji field by entering the keywords to search the emojis
	@Test(priority=28,enabled=true)
	public void verifyEmojiPopupSearch_EnterValidKeys() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopupSearch_EnterValidKeys(userToSelect));
	}
	
	//Verify the search emoji field by entering the invalid keywords to search the emojis
	@Test(priority=29,enabled=true)
	public void verifyEmojiPopupSearch_EnterInvalidKeys() throws Throwable {
		String noEmojisFound=msgInputFieldOptions.verifyEmojiPopupSearch_EnterInvalidKeys(userToSelect);
		Assert.assertEquals(noEmojisFound, "No Emoji Found!");
		System.out.println(noEmojisFound);
	}
	
	//Verify the click action on "X" symbol in the search emoji field by entering the some keywords 
	@Test(priority=30,enabled=true)
	public void verifyXSymbol_EmojiSearchFiled() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyXSymbol_EmojiSearchFiled(userToSelect));
	}
	
	//Verify the emoji names and short names in the emoji pop up window by moving the mouse hover on emojis
	@Test(priority=31,enabled=true)
	public void verifyEmojiNamesAndShortNames() throws Throwable {
		String emojiShortNames=msgInputFieldOptions.verifyEmojiNamesAndShortNames(userToSelect);
		Assert.assertEquals(emojiShortNames, ":grinning:");
		System.out.println(emojiShortNames);
	}
	
	
	/**********************************************************************************************
	 * 							GIF FUNCTIONALITY IN MESSAGE INPUT FIELD
	 * *********************************************************************************************/
	
	
	//Verifying the click action of GIF icon in message input field
	@Test(priority=33,enabled=true)
	public void verify_GiphyClickActionTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verify_GiphyClickAction(userToSelect));
	}
	
	//Verify the  mouse hover functionality of the "X" symbol in giphy pop up window by clicking on "GIF" icon 
	@Test(priority=34,enabled=true)
	public void verifyMousehoverAction_XSymGiphyPopup() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyMousehoverAction_XSymGiphyPopup(userToSelect));
	}
	
	//Verify the giphy pop up window by clicking on "X" symbol
	@Test(priority=35,enabled=true)
	public void verifyGigpyPopup_ClickXSymbol() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyGigpyPopup_ClickXSymbol(userToSelect));
	}
	
	//Verify the GIPHY title mouse hover and its click functionality at header section  of the giphy  pop up window 
	@Test(priority=36,enabled=true)
	public void verifyGiphyTitle_PopupHeaderSection() throws Throwable {
		String giphyDotComTitle=msgInputFieldOptions.verifyGiphyTitle_PopupHeaderSection(userToSelect);
		Assert.assertEquals(giphyDotComTitle, "GIPHY | Search All the GIFs & Make Your Own Animated GIF");
		System.out.println(giphyDotComTitle);
	}
	
	//Verify the search field in the giphy pop up window by clicking on the GIF icon from message input field
	@Test(priority=37,enabled=true)
	public void verifyGiphyPopupSearchFieldTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyGiphyPopupSearchField(userToSelect));
	}
	
	//Verify the search button in the giphy pop up window 
	@Test(priority=38,enabled=true)
	public void verifySearchButton_GiphyPopupTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifySearchButton_GiphyPopup(userToSelect));
	}
	
	//Verify the search field by entering the invalid keywords to search the giphy's available in the giphy pop up window 
	@Test(priority=39,enabled=true)
	public void verifyGiphySearchField_EnterInvalidKeys() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyGiphySearchField_EnterInvalidKeys(userToSelect));
	}
	
	//Verify the "X" symbol mouse hover and click functionality in the search field by entering some keywords on search field
	@Test(priority=40,enabled=true)
	public void verifyXsymbolClickAction_GiphyPopup() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyXsymbolClickAction_GiphyPopup(userToSelect));
	}
	
	//Verify the mouse over and click functionality of giphy's in the giphy pop up window
	@Test(priority=41,enabled=true)
	public void verifyGiphyClickAction_GiphyPopup() throws Throwable {
		msgInputFieldOptions.verifyGiphyClickAction_GiphyPopup(userToSelect);
	}
	
	//Verify the scroll functionality of the giphy pop  up window by moving the mouse up and down 
	@Test(priority=42,enabled=true)
	public void verifyGiphyPopupScroll() throws Throwable {
		msgInputFieldOptions.verifyGiphyPopupScroll(userToSelect);
	}
	
	/******************************************************************************************************
	 * 								EMOJI SHORT NAMES IN MESSAGE INPUT FIELD
	 * 
	 * ****************************************************************************************************/
	
	//Verify the emojis auto suggestions pop up in the message input field by entering the short names
	@Test(priority=43,enabled=true)
	public void verifyEmojiPopup_MsgInputField() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopup_MsgInputField(userToSelect));
	}
	
	//Verify the emoji auto suggestions pop up in the message input field by pressing the "Esc" key on keyboard
	@Test(priority=44,enabled=true)
	public void verifyEmojiPopupMsgInputFiled_EscKey() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopupMsgInputFiled_EscKey(userToSelect));
	}
	
	//Verify the "X" symbol functionality in the emoji pop up auto suggestions  
	@Test(priority=45,enabled=true)
	public void verifyEmojiPopupMsgInputField_ClickXSymbol() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopupMsgInputField_ClickXSymbol(userToSelect));
	}
	
	//Verify the message input field by selecting the emojis by mouse click from the auto suggestion pop up 
	@Test(priority=46,enabled=true)
	public void verifyMsgInputField_SelectEmoji_EnterShortNames() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyMsgInputField_SelectEmoji_EnterShortNames(userToSelect));
	}
	
	//Verify the message input field by selecting the emoji using "Enter" key on keyboard from the auto suggestions pop up 
	@Test(priority=47,enabled=true)
	public void verifyMsgInputField_SelectEmoji_EnterKey() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyMsgInputField_SelectEmoji_EnterKey(userToSelect));
	}
	
	//Verify the emoji auto suggestions pop up by entering only single character followed by colon (:) symbol
	@Test(priority=48,enabled=true)
	public void verifyEmojiPopup_EnterSingleCharShortName() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopup_EnterSingleCharShortName(userToSelect));
	}
	
	//Verify the emojis auto suggestions pop up window by pressing the "Backspace" key on keyboard when user enter only two characters (:ha)
	@Test(priority=49,enabled=true )
	public void verifyEmojiPopupMsgInputField_Backspace() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyEmojiPopupMsgInputField_Backspace(userToSelect));
	}
	
	/****************************************************************************************************
	 *							
	 *								SHORT CUT KEYS IN MESSAGE THREAD
	 * 
	 **************************************************************************************************/
	//Verify the message thread by sending the :P short cut key from the message input field 
	@Test(priority=50,enabled=true)
	public void verifyShortCutKeys_MsgThread() throws Throwable {
		String shortCutKeys=msgInputFieldOptions.verifyShortCutKeys_MsgThread(userToSelect);
		Assert.assertEquals(shortCutKeys, ":P");
		System.out.println(shortCutKeys);
	}
	
	
	/************************************************************************************************************
	 * 										ATTACHMENTS IN MESSAGE INPUT FIELD
	 * @throws Throwable 
	 *
	 ***********************************************************************************************************/
	//Check the 'Attachment' icon click functionality on message input field
	@Test(priority=51,enabled=true)
	public void verifyAttachmentClickActionTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAttachmentClickAction(userToSelect2));
	}
	
	//Verify the attachment pop up window by clicking on attachment icon from the message input field
	@Test(priority=52,enabled=true)
	public void verifyAttachementPopupTest() throws Throwable {
		Assert.assertTrue(msgInputFieldOptions.verifyAttachementPopup(userToSelect2));
	}
	
	//Verify the "My Computer" icon and its mouse hover functionality in the attachment pop pup window
	@Test(priority=53,enabled=true)
	public void verifyMyComputerMousehoverActionTest() throws Throwable {
		String mycomputer="My Computer";
		String actualTooltip=msgInputFieldOptions.verifyMyComputerTooltip(userToSelect2);
		Assert.assertEquals(actualTooltip, mycomputer);
		System.out.println(actualTooltip);
	}
	
	//Verify the click action on "My Computer" icon to send a file to user  from the local system 
	@Test(priority=54,enabled=true)
	public void verifyAttachmentMsgThread_MyComputer() throws Throwable {
	String filename=msgInputFieldOptions.verifyAttachmentMsgThread_MyComputer(userToSelect2,prop.getProperty("docName"),prop.getProperty("filePath_MyComputer"));
	Assert.assertTrue(filename.contains(prop.getProperty("docName")));
	System.out.println(filename);
	}
	
	//Verify the "One Driver" icon and it's mouse hover action in the attachment pop up window
	@Test(priority=55,enabled=true)
	public void verifyOneDriveMouserhover() throws Throwable {
		String oneDrive="One Drive";
		String actualTooltip=msgInputFieldOptions.verifyOneDriveTooltip(userToSelect2);
		Assert.assertEquals(actualTooltip, oneDrive);
		System.out.println(actualTooltip);
	}
	
	//Verify the click functionality of "One Drive" icon in the attachment pop up window
	@Test(priority=56,enabled=true)
	public void verifyMsgThreadAttachment_OneDrive() throws Throwable {
		msgInputFieldOptions.verifyMsgThreadSelectAttachment_OneDrive(userToSelect2,prop.getProperty("email"),prop.getProperty("pwd"),
				prop.getProperty("fileName"));
	}
	
	//Verify the "Google Drive" icon and it's mouse hover action in the attachment pop up window
	@Test(priority=57,enabled=true)
	public void verifyGoogleDriveTooltip() throws Throwable {
		String googleDrive="Google Drive";
		String actualTooltip=msgInputFieldOptions.verifyGoogleDriveTooltip(userToSelect2);
		Assert.assertEquals(actualTooltip, googleDrive);
		System.out.println(actualTooltip);
	}
	
	//Google Drive 
	@Test(priority=58,enabled=true)
	public void verifyGoogleDriveClickAction(){
		Assert.assertTrue(msgInputFieldOptions.verifyGoogleDriveClickAction());
	}
	
	//Verify the "Drop Box" icon and it's mouse hover action in the attachments pop up window
	@Test(priority=59,enabled=true)
	public void verifyDropboxTooltip() throws Throwable {
		String dropbox="Dropbox";
		String actualTooltip=msgInputFieldOptions.verifyDropboxTooltip(userToSelect2);
		Assert.assertEquals(actualTooltip, dropbox);
		System.out.println(actualTooltip);
	}
	
	//Verify the click functionality of "Drop Box" icon in the attachments pop up window
	@Test(priority=60,enabled=true)
	public void verifyMsgThreadAttachment_Dropbox() throws Throwable {
		String attachment_MsgThread=msgInputFieldOptions.verifyMsgThreadAttachment_Dropbox(userToSelect2, prop.getProperty("email"), prop.getProperty("pwd"),prop.getProperty("dropboxImage"));
		Assert.assertTrue(attachment_MsgThread.contains(prop.getProperty("dropboxImage")));
		System.out.println(attachment_MsgThread);
	}
	
	//Verify the "Box" icon and it's mouse hover action in the attachment pop up window
	@Test(priority=61,enabled=true)
	public void verifyBoxIconTooltip() throws Throwable {
		String box="Box";
		String actualTooltip=msgInputFieldOptions.verifyBoxIconTooltip(userToSelect2);
		Assert.assertEquals(actualTooltip, box);
		System.out.println(actualTooltip);
	}
	
	//Verify the click functionality of the "Box" icon in the attachments pop up window
	@Test(priority=62,enabled=true)
	public void verifyAttachmentMsgThread_Box() throws Throwable {
		String attachment_msgThread=msgInputFieldOptions.verifyAttachmentMsgThread_Box(userToSelect2, prop.getProperty("email"),
				prop.getProperty("pwd"), prop.getProperty("file_Box"));
		Assert.assertTrue(attachment_msgThread.contains(prop.getProperty("file_Box")));
		System.out.println(attachment_msgThread);
	}
	
	//Verify the files section in the third panel whether the sending attachment are updating and showing or not
	@Test(priority=63,enabled=true)
	public void verifyFileSection_SendingAttachment() throws Throwable {
		String fileSection=msgInputFieldOptions.verifyFileSection_SendingAttachment(userToSelect2, prop.getProperty("docName"), prop.getProperty("filePath_MyComputer"));
		Assert.assertTrue(fileSection.contains(prop.getProperty("docName")));
		System.out.println(fileSection);
	}
	
	//Verify the message thread by sending the "Mp3" file format
	@Test(priority=64,enabled=true)
	public void verifyMp3File_MsgThread() throws Throwable {
		String MsgThread=msgInputFieldOptions.verifyMp3File_MsgThread(userToSelect2, prop.getProperty("mp3File"), prop.getProperty("mp3FilePath"));
		Assert.assertTrue(MsgThread.contains(prop.getProperty("mp3File")));
		System.out.println(MsgThread);
	}
	
	//Verify the message thread by sending the "Mp4" file format
	@Test(priority=65,enabled=true)
	public void verifyMp4File_MsgThread() throws Throwable {
		String fileSection=msgInputFieldOptions.verifyMp4File_MsgThread(userToSelect, prop.getProperty("mp4File"), prop.getProperty("mp4FilePath"));
		Assert.assertTrue(fileSection.contains(prop.getProperty("mp4File")));
		System.out.println(fileSection);
	}
	
	//Verify the message thread by sending the ".xlsx" file format
	@Test(priority=66,enabled=true)
	public void verifyXlsxFile_MsgThread() throws Throwable {
		String MsgThread=msgInputFieldOptions.verifyXlsxFile_MsgThread(userToSelect3, prop.getProperty("xlsxFile"), prop.getProperty("xlsxFilePath"));
		Assert.assertTrue(MsgThread.contains(prop.getProperty("xlsxFile")));
		System.out.println(MsgThread);
	}
	
	
	//Verify the message thread by sending the ".html" file format
	@Test(priority=67,enabled=true)
	public void verifyHTMLFile_MsgThread() throws Throwable {
		String MsgThread=msgInputFieldOptions.verifyHTMLFile_MsgThread(userToSelect3, prop.getProperty("htmlFile"), prop.getProperty("htmlFilePath"));
		Assert.assertTrue(MsgThread.contains(prop.getProperty("htmlFile")));
		System.out.println(MsgThread);
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
