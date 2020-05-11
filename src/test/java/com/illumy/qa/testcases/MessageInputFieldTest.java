
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
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.MessageInputField;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class MessageInputFieldTest extends TestBase{

	public static MessageInputField messageInputField;
	public  SigninPage signinPage;
	public static HomePage homePage;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "MessageInputField";
	String userToSelect		= "userToSelect";
	String onnetUser		= "onnetUser";
	String msgInputField	= "msgInputField";
	String subject			= "subject";
	String offnetUser		= "offnetUser";
	
	String userToSelect_Row2	= reader.getCellData(sheetName, userToSelect, 2);
	String subject_Row2			= reader.getCellData(sheetName, subject, 2);
	String subject_Row3			= reader.getCellData(sheetName, subject, 3);
	String subject_Row4			= reader.getCellData(sheetName, subject, 4);
	String subject_Row5			= reader.getCellData(sheetName, subject, 5);
	String subject_Row6			= reader.getCellData(sheetName, subject, 6);
	String subject_Row7			= reader.getCellData(sheetName, subject, 7);
	String subject_Row8			= reader.getCellData(sheetName, subject, 8);
	String subject_Row9			= reader.getCellData(sheetName, subject, 9);
	String subject_Row10		= reader.getCellData(sheetName, subject, 10);
	
	String msgInputField_Row2	= reader.getCellData(sheetName, msgInputField, 2);
	String msgInputField_Row3	= reader.getCellData(sheetName, msgInputField, 3);
	String msgInputField_Row4	= reader.getCellData(sheetName, msgInputField, 4);
	String msgInputField_Row5	= reader.getCellData(sheetName, msgInputField, 5);
	
	String onnetUser_Row2		= reader.getCellData(sheetName, onnetUser, 2);
	
	String offnetUser_Row2		= reader.getCellData(sheetName, offnetUser, 2);
	
	
	String hashXpath	= "//*[@class='emojimain_div']//*[contains(@class,'0023-20e3')]";
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		messageInputField=new MessageInputField();
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	/*Check the input field is visible or not at the bottom 
	 * of the P2P or group message thread in the middle panel 
	 */
	@Test(priority=1,enabled=true)
	public void verify_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_MessageInputField(userToSelect_Row2));
	}
	
	//Verifying the  message placeholder in the message input field 
	@Test(priority=2,enabled=true)
	public void verify_GhostText_MsgInputField() throws Throwable {
		Assert.assertTrue(messageInputField.verify_GhostText_MsgInputField(userToSelect_Row2));
	}
	
	//Check the cursor position by default when an user open the P2P or group message thread
	@Test(priority=3,enabled=true)
	public void verifyDefaultCursorPostionTest() throws Throwable {
		WebElement actualcursorposition=messageInputField.verifyDefaultCursorPostion(userToSelect_Row2);
		WebElement expectedCursorPostion=driver.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']"));
		Assert.assertEquals(actualcursorposition, expectedCursorPostion);
	}
	
	//Verifying the '@' is displaying or not in the input field section
	@Test(priority=4,enabled=true)
	public void verify_AtMentions_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_AtMentions(userToSelect_Row2));
	}
	
	//Verifying the emoji symbol in the message input field
	@Test(priority=5,enabled=true)
	public void verify_Emoji_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_Emoji_MessageInputField(userToSelect_Row2));
	}
	
	//Verify the GIF symbol in the message input field
	@Test(priority=6,enabled=true)
	public void verify_GIF_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_GIF_MessageInputField(userToSelect_Row2));
	}
	
	//Verify the attachment symbol in the message input field
	@Test(priority=7,enabled=true)
	public void verify_Attachement_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_Attachement_MessageInputField(userToSelect_Row2));
	}
	
	//Verifying the subject expander in the message input field
	@Test(priority=8,enabled=true)
	public void verify_SubLineExpanderTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_SubjectExpander(userToSelect_Row2));
	}
	
	//Verify the click functionality of subject expander
	@Test(priority=9,enabled=true)
	public void verify_ClickAction_SubExpanderTest() throws Throwable {
		String subject=messageInputField.verify_ClickAction_SubjectExpander(userToSelect_Row2);
		Assert.assertEquals(subject, "Subject:");
		System.out.println(subject);
	}
	
	//Verifying the double click functionality of the subject expander
	@Test(priority=10,enabled=true)
	public void verify_DoubleClick_SubExpanderTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_DoubleClick_SubLineExpander(userToSelect_Row2));
	}
	
	//Verifying the click functionality of the @ in message input field
	@Test(priority=11,enabled=true)
	public void verify_AtmentionIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_AtmentionClickAction(userToSelect_Row2));
	}
	
	//Verifying the click action on emoji in message input field
	@Test(priority=12,enabled=true)
	public void verify_EmojiIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_EmojiClickAction(userToSelect_Row2));
	}
	
	//Verifying the click action of GIF icon in message input field
	@Test(priority=13,enabled=true)
	public void verify_GiphyIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_GiphyClickAction(userToSelect_Row2));
	}
	
	//Verify the click functionality of attachment icon in message input field
	@Test(priority=14,enabled=true)
	public void verify_AttachmentIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_AttachmentClickAction(userToSelect_Row2));
	}
	
	//Sending text message to the user by entering subject in subject field and text message from input field
	@Test(priority=15,enabled=true)
	public void verifySubjectField_TxtMsgTest() throws Throwable {
		String msgThread=messageInputField.verifySubjectField_TxtMsg(userToSelect_Row2,subject_Row2, msgInputField_Row2);
		
		Assert.assertTrue(msgThread.contains("Subject: "+subject_Row2+"\n"+msgInputField_Row2));
		System.out.println(msgThread);
	}
	
	//Verifying the subject field by entering the special characters and enter  text message in message entry field
	@Test(priority=16,enabled=true)
	public void verifySubjectField_SplCharsTest() throws Throwable {
		String splChars_TxtMsg=messageInputField.verifySubjectField_SplChars(userToSelect_Row2,subject_Row3, msgInputField_Row2);
		Assert.assertTrue(splChars_TxtMsg.contains("Subject: "+subject_Row3+"\n"+msgInputField_Row2));
		System.out.println(splChars_TxtMsg);
	}
	
	//Verifying the subject field by entering the numbers and enter text message in message entry field
	@Test(priority=17,enabled=true)
	public void verify_SubjectField_NumbersTest() throws Throwable {
		String num_TextMsg=messageInputField.verify_SubjectField_Numbers(userToSelect_Row2, subject_Row4, msgInputField_Row2);
		Assert.assertTrue(num_TextMsg.contains("Subject: "+subject_Row4+"\n"+msgInputField_Row2));
	
		System.out.println(num_TextMsg);
	}
	
	/*Verify the subject field by entering the combination of alphabet, numbers,
	 * and special characters and enter text message in message input field
	 */
	@Test(priority=18,enabled=true)
	public void verifySubjectField_CombinationsTest() throws Throwable {
		String sub_combinations=messageInputField.verifySubjectField_Combinations(userToSelect_Row2, subject_Row5, msgInputField_Row2);
		Assert.assertTrue(sub_combinations.contains("Subject: "+subject_Row5+"\n"+msgInputField_Row2));
		System.out.println(sub_combinations);
	}
	
	/* Verify the subject field by entering the URL and by entering the text message in message input field */
	@Test(priority=19,enabled=true)
	public void verifySubField_URLTest() throws Throwable {
		String sub_url=messageInputField.verifySubField_URL(userToSelect_Row2, subject_Row6, msgInputField_Row2);
		Assert.assertTrue(sub_url.contains("Subject: "+subject_Row6+"\n"+msgInputField_Row2));
		System.out.println(sub_url);
	}
	
	/*Verify the subject field maximum limit of accepting the characters by entering more than 80 characters*/
	@Test(priority=20,enabled=true)
	public void verifySubField_MoreThan80CharsTest() throws Throwable {
		String sub_MoreThan80Chars1 =messageInputField.verifySubField_MoreThan80Chars(userToSelect_Row2, subject_Row7);
	   Assert.assertEquals(sub_MoreThan80Chars1, subject_Row8);
	   System.out.println(sub_MoreThan80Chars1);
	   
	}
	
	//Verify the subject field by clearing the text using 'Back Space' key from keyboard
	@Test(priority=21,enabled=true)
	public void verifySujField_ClearText_BackspaceTest() throws Throwable {
		String sub_Backspace=messageInputField.verifySujField_ClearText_Backspace(userToSelect_Row2, subject_Row2);
		Assert.assertEquals(sub_Backspace, subject_Row9);
		System.out.println(sub_Backspace);
	}
	
	//Verify the subject field by pasting the copied text using keyboard options
	@Test(priority=22,enabled=false)
	public void verifySubField_CopyPaste_KeyboardTest() throws Throwable {
		String copyPaste_Keyboard=messageInputField.verifySubField_CopyPaste_Keyboard(userToSelect_Row2, subject_Row2);
		Assert.assertEquals(copyPaste_Keyboard, subject_Row10);
		System.out.println(copyPaste_Keyboard);
	}
	
	//Verify the cursor position by press the Enter key on keyboard by entering some text in subject field
	@Test(priority=23,enabled=true)
	public void verifySubField_CursorPos_EnterKeyTest() throws Throwable {
		WebElement actualElement=messageInputField.verifyCursorPosition_EnterKey(userToSelect_Row2, subject_Row2);
		WebElement expectedElement=driver.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']"));
		Assert.assertEquals(actualElement, expectedElement);
	}
	
	//Verify the TAB key functionality from keyboard when the cursor position at subject field
	@Test(priority=24,enabled=true)
	public void verifyCursorPosition_TABKeyTest() throws Throwable {
		
		WebElement actualElement=messageInputField.verifyCursorPosition_TABKey(userToSelect_Row2, subject_Row2);
		WebElement expectedElement=driver.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']"));
		Assert.assertEquals(actualElement, expectedElement);
	}
	
	//Verify the mouse hover action on subject expander symbol when it is in open status
	@Test(priority=25,enabled=true)
	public void verifyAddSubject_TooltipTest() throws Throwable {
		String addSubTooltip=messageInputField.verifyAddSubject_Tooltip(userToSelect_Row2);
		Assert.assertTrue(addSubTooltip.contains("Close Subject"));
		System.out.println(addSubTooltip);
	}
	
	//Verify the default subject of off-net user by clicking on  subject line expander in P2P message thread
	@Test(priority=26,enabled=true)
	public void verifyOffnetUser_SubjectFieldTest() throws Throwable {
		String offnetUserSubject=messageInputField.verifyOffnetUser_SubjectField(offnetUser_Row2);
		Assert.assertTrue(offnetUserSubject.contains("New Message From "));
		System.out.println(offnetUserSubject);
	}
	
	//Verify the subject field by entering the short names of emojis and by entering text message in message input field
	@Test(priority=27,enabled=true)
	public void verifyEmojiShortNames_SubFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verifyEmojiShortNames_SubField(userToSelect_Row2, 
				reader.getCellData(sheetName, "emojiShortName", 2),msgInputField_Row2));
		
	}

	/*Clicking on '@' icon when the cursor position in subject field*/
	@Test(priority=28,enabled=true)
	public void verifySubField_ClickAtMentionTest() throws Throwable {
		String atmentionsSym=messageInputField.verifySubField_ClickAtMention(userToSelect_Row2);
		Assert.assertTrue(atmentionsSym.contains("@"));
		System.out.println(atmentionsSym);
	}
	
	/*User clicking on 'Emoji' icon when cursor position in subject field*/
	@Test(priority=29,enabled=true)
	public void verifySubField_ClickEmojiTest() throws Throwable {
		
		Assert.assertTrue(messageInputField.verifySubField_ClickEmoji(userToSelect_Row2));
		
	}
	

	//User clicking on'GIF' icon when cursor position in subject field
	@Test(priority=30,enabled=true)
	public void verifySubField_ClickGiphyTest() throws Throwable {
		messageInputField.verifySubField_ClickGiphy(userToSelect_Row2);
	}
	
	
	//Verify the message input field by entering only alphabets
	@Test(priority=31,enabled=true)
	public void verifyMsgInputField_AlphabetsTest() throws Throwable {
		String threadMsg=messageInputField.verifyMsgInputField_Alphabets(userToSelect_Row2, msgInputField_Row2);
		Assert.assertTrue(threadMsg.contains(msgInputField_Row2));
		System.out.println(threadMsg);
	}
	
	//Verify the message input field by sending numbers only
	@Test(priority=32,enabled=true)
	public void verifyMsgInputField_NumbersTest() throws Throwable {
		String threadMsg=messageInputField.verifyMsgInputField_Numbers(userToSelect_Row2, msgInputField_Row3);
		Assert.assertTrue(threadMsg.contains(msgInputField_Row3));
		System.out.println(threadMsg);
			 
	}
	
	//Verify the message  input field by sending the all special characters 
	@Test(priority=33,enabled=true)
	public void verifyMsgInputField_SplCharsTest() throws Throwable {
		String splChars_ThreadMsg=messageInputField.verifyMsgInputField_SplChars(userToSelect_Row2, msgInputField_Row5);
		Assert.assertTrue(splChars_ThreadMsg.contains(msgInputField_Row5));
		System.out.println(splChars_ThreadMsg);
	}
	
	//User sending the combination of alphabet,special characters and numbers in message input field
	@Test(priority=34,enabled=true)
	public void verifyMsgInputField_CombinationsTest() throws Throwable {
		String combinations=messageInputField.verifyMsgInputField_Combinations(userToSelect_Row2,msgInputField_Row4);
		Assert.assertTrue(combinations.contains(msgInputField_Row4));
		System.out.println(combinations);
	}
	
	//Verify the message input field by sending the text message and selecting user from '@' at mentions pop up 
	@Test(priority=35,enabled=true)
	public void verifyMsgInputField_TxtMsg_AtMentionsTest() throws Throwable {
		String text_Atmention=messageInputField.verifyMsgInputField_TxtMsg_AtMentions(userToSelect_Row2,msgInputField_Row2);
		Assert.assertEquals(text_Atmention, msgInputField_Row2+" "+"@"+userToSelect_Row2+" ");
		
		System.out.println(text_Atmention);
	}
	
	/*Verify the message input field by select the user from at 
	 * mentions pop up clicking on "@" icon and entering some text message
	 */
	@Test(priority=36,enabled=true)
	public void verifyMsgInputField_Atmention_TextMsgTest() throws Throwable {
		String atmention_Text=messageInputField.verifyMsgInputField_Atmention_TextMsg(userToSelect_Row2,msgInputField_Row2);
		Assert.assertEquals(atmention_Text, "@"+userToSelect_Row2+" "+msgInputField_Row2);
		System.out.println(atmention_Text);
	}
	
	/*Verify the message input field by sending the text message and selecting an emoji from the emoji's pop up */
	@Test(priority=37,enabled=true)
	public void verifyMsgInputField_Text_EmojiTest() throws Throwable {
		Assert.assertTrue(messageInputField.verifyMsgInputField_Text_Emoji(userToSelect_Row2,msgInputField_Row2));
	}
	
	//Verify the message input field by entering the long text continuously
	@Test(priority=38,enabled=true)
	public void verifyMsgInputField_LongTextTest() throws Throwable {
		
		int size=messageInputField.verifyMsgInputField_LongText(userToSelect_Row2);
	
		String longText=driver.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")).getText();
		int msgInputTxt=longText.length();
		Assert.assertEquals(size, msgInputTxt);
	}
	
	//Check the slim scroll is displaying or not while entering the long text in message input field
	@Test(priority=39,enabled=true)
	public void verifyInputFieldSlimScroll_LongTextTest() throws Throwable {
		Assert.assertTrue(messageInputField.verifyInputFieldSlimScroll_LongText(userToSelect_Row2));
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


