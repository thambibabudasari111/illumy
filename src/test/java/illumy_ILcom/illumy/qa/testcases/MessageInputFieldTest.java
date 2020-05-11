/**
 * 
 */
package illumy_ILcom.illumy.qa.testcases;

import java.io.IOException;

import org.apache.commons.exec.util.StringUtils;
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
import com.illumy.qa.pages.ForgotPassword;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.MessageInputField;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class MessageInputFieldTest extends TestBase{

	public static MessageInputField messageInputField;
	public  SigninPage signinPage;
	public static HomePage homePage;
	
	String userToSelect="test email";
	String onnetUser="Thambi Babu Dasari";
	String msgInputField_Text="This is a test message for automation test scripts";
	String sub_Text="Subject: "+"Test Message";
	String sub_SplChars="Subject: "+"!@#$%^&*()_+-=}{[]/?.>,\'<~`;:";
	String sub_Numbers="Subject: "+"12345647890";
	String sub_Combinations="Subject: "+"abcdefABCDEF!@#$%^&*(){}[];\".,<>1234567890";
	String sub_Url="Subject: "+"https://www.google.com";
	String sub_Morethan80Chars="abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*(){}.,<>/?|_+:;'\"[]=`~ TEST MESSAGE1";
	String sub_ClrTxt_Backspace="Test Mess";
	String sub_CopyPaste="Test Message Test Message Test Message";
	String msgInputNumbers="12345647890";
	String MsgInputFieldcombinations="abcdefABCDEF!@#$%^&*(){}[];\".,<>1234567890";
	String text_MsgInputField="Test Message";
	
	
	
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
		Assert.assertTrue(messageInputField.verify_MessageInputField(userToSelect));
	}
	
	//Verifying the  message placeholder in the message input field 
	@Test(priority=2,enabled=true)
	public void verify_GhostText_MsgInputField() throws Throwable {
		Assert.assertTrue(messageInputField.verify_GhostText_MsgInputField(userToSelect));
	}
	
	//Check the cursor position by default when an user open the P2P or group message thread
	@Test(priority=3,enabled=true)
	public void verifyDefaultCursorPostionTest() throws Throwable {
		WebElement actualcursorposition=messageInputField.verifyDefaultCursorPostion(userToSelect);
		WebElement expectedCursorPostion=driver.findElement(By.className("mess_type_box"));
		Assert.assertEquals(actualcursorposition, expectedCursorPostion);
	}
	
	//Verifying the '@' is displaying or not in the input field section
	@Test(priority=4,enabled=true)
	public void verify_AtMentions_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_AtMentions(userToSelect));
	}
	
	//Verifying the emoji symbol in the message input field
	@Test(priority=5,enabled=true)
	public void verify_Emoji_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_Emoji_MessageInputField(userToSelect));
	}
	
	//Verify the GIF symbol in the message input field
	@Test(priority=6,enabled=true)
	public void verify_GIF_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_GIF_MessageInputField(userToSelect));
	}
	
	//Verify the attachment symbol in the message input field
	@Test(priority=7,enabled=true)
	public void verify_Attachement_MessageInputFieldTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_Attachement_MessageInputField(userToSelect));
	}
	
	//Verifying the subject expander in the message input field
	@Test(priority=8,enabled=true)
	public void verify_SubLineExpanderTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_SubjectExpander(userToSelect));
	}
	
	//Verify the click functionality of subject expander
	@Test(priority=9,enabled=true)
	public void verify_ClickAction_SubExpanderTest() throws Throwable {
		String subject=messageInputField.verify_ClickAction_SubjectExpander(userToSelect);
		Assert.assertEquals(subject, "Subject:");
		System.out.println(subject);
	}
	
	//Verifying the double click functionality of the subject expander
	@Test(priority=10,enabled=true)
	public void verify_DoubleClick_SubExpanderTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_DoubleClick_SubLineExpander(userToSelect));
	}
	
	//Verifying the click functionality of the @ in message input field
	@Test(priority=11,enabled=true)
	public void verify_AtmentionIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_AtmentionClickAction(userToSelect));
	}
	
	//Verifying the click action on emoji in message input field
	@Test(priority=12,enabled=true)
	public void verify_EmojiIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_EmojiClickAction(userToSelect));
	}
	
	//Verifying the click action of GIF icon in message input field
	@Test(priority=13,enabled=true)
	public void verify_GiphyIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_GiphyClickAction(userToSelect));
	}
	
	//Verify the click functionality of attachment icon in message input field
	@Test(priority=14,enabled=true)
	public void verify_AttachmentIconClickTest() throws Throwable {
		Assert.assertTrue(messageInputField.verify_AttachmentClickAction(userToSelect));
	}
	
	//Sending text message to the user by entering subject in subject field and text message from input field
	@Test(priority=15,enabled=true)
	public void verifySubjectField_TxtMsgTest() throws Throwable {
		String msgThread=messageInputField.verifySubjectField_TxtMsg(userToSelect,prop.getProperty("sub_Text"),prop.getProperty("msgInputFieldText"));
		Assert.assertEquals(msgThread, sub_Text+"\n"+msgInputField_Text);
		System.out.println(msgThread);
	}
	
	//Verifying the subject field by entering the special characters and enter  text message in message entry field
	@Test(priority=16,enabled=true)
	public void verifySubjectField_SplCharsTest() throws Throwable {
		String splChars_TxtMsg=messageInputField.verifySubjectField_SplChars(userToSelect, prop.getProperty("sub_SplChars"), 
				prop.getProperty("msgInputFieldText"));
		Assert.assertEquals(splChars_TxtMsg, sub_SplChars+"\n"+msgInputField_Text);
		System.out.println(splChars_TxtMsg);
	}
	
	//Verifying the subject field by entering the numbers and enter text message in message entry field
	@Test(priority=17,enabled=true)
	public void verify_SubjectField_NumbersTest() throws Throwable {
		String num_TextMsg=messageInputField.verify_SubjectField_Numbers(userToSelect, 
				prop.getProperty("sub_Numbers"), 
				prop.getProperty("msgInputFieldText"));
		
		Assert.assertEquals(num_TextMsg, sub_Numbers+"\n"+msgInputField_Text);
		System.out.println(num_TextMsg);
	}
	
	/*Verify the subject field by entering the combination of alphabet, numbers,
	 * and special characters and enter text message in message input field
	 */
	@Test(priority=18,enabled=true)
	public void verifySubjectField_CombinationsTest() throws Throwable {
		String sub_combinations=messageInputField.verifySubjectField_Combinations(userToSelect, 
				prop.getProperty("sub_Combinations"), 
				prop.getProperty("msgInputFieldText"));
		Assert.assertEquals(sub_combinations, sub_Combinations+"\n"+msgInputField_Text);
		System.out.println(sub_combinations);
	}
	
	/* Verify the subject field by entering the URL and by entering the text message in message input field */
	@Test(priority=19,enabled=true)
	public void verifySubField_URLTest() throws Throwable {
		String sub_url=messageInputField.verifySubField_URL(userToSelect, 
				prop.getProperty("sub_URL"), 
				prop.getProperty("msgInputFieldText"));
		Assert.assertEquals(sub_url, sub_Url+"\n"+msgInputField_Text);
		System.out.println(sub_url);
	}
	
	/*Verify the subject field maximum limit of accepting the characters by entering more than 80 characters*/
	@Test(priority=20,enabled=true)
	public void verifySubField_MoreThan80CharsTest() throws Throwable {
		String sub_MoreThan80Chars1 =messageInputField.verifySubField_MoreThan80Chars(userToSelect, 
				prop.getProperty("sub_MoreThan80Chars"), 
				prop.getProperty("msgInputFieldText"));
		
	   Assert.assertEquals(sub_MoreThan80Chars1, sub_Morethan80Chars);
	   System.out.println(sub_MoreThan80Chars1);
	   
	}
	
	//Verify the subject field by clearing the text using 'Back Space' key from keyboard
	@Test(priority=21,enabled=true)
	public void verifySujField_ClearText_BackspaceTest() throws Throwable {
		String sub_Backspace=messageInputField.verifySujField_ClearText_Backspace(userToSelect, prop.getProperty("sub_Text"));
		Assert.assertEquals(sub_Backspace, sub_ClrTxt_Backspace);
		System.out.println(sub_Backspace);
	}
	
	//Verify the subject field by pasting the copied text using keyboard options
	@Test(priority=22,enabled=true)
	public void verifySubField_CopyPaste_KeyboardTest() throws Throwable {
		String copyPaste_Keyboard=messageInputField.verifySubField_CopyPaste_Keyboard(userToSelect, prop.getProperty("sub_Text"));
		Assert.assertEquals(copyPaste_Keyboard, sub_CopyPaste);
		System.out.println(copyPaste_Keyboard);
	}
	
	//Verify the cursor position by press the Enter key on keyboard by entering some text in subject field
	@Test(priority=23,enabled=true)
	public void verifySubField_CursorPos_EnterKeyTest() throws Throwable {
		WebElement actualElement=messageInputField.verifyCursorPosition_EnterKey(userToSelect, prop.getProperty("sub_Text"));
		WebElement expectedElement=driver.findElement(By.id("editable"));
		Assert.assertEquals(actualElement, expectedElement);
	}
	
	//Verify the TAB key functionality from keyboard when the cursor position at subject field
	@Test(priority=24,enabled=true)
	public void verifyCursorPosition_TABKeyTest() throws Throwable {
		
		WebElement actualElement=messageInputField.verifyCursorPosition_TABKey(userToSelect, prop.getProperty("sub_Text"));
		WebElement expectedElement=driver.findElement(By.id("editable"));
		Assert.assertEquals(actualElement, expectedElement);
	}
	
	//Verify the mouse hover action on subject expander symbol when it is in open status
	@Test(priority=25,enabled=true)
	public void verifyAddSubject_TooltipTest() throws Throwable {
		String addSubTooltip=messageInputField.verifyAddSubject_Tooltip(userToSelect);
		Assert.assertTrue(addSubTooltip.contains("Close Subject"));
		System.out.println(addSubTooltip);
	}
	
	//Verify the default subject of off-net user by clicking on  subject line expander in P2P message thread
	@Test(priority=26,enabled=true)
	public void verifyOffnetUser_SubjectFieldTest() throws Throwable {
		String offnetUserSubject=messageInputField.verifyOffnetUser_SubjectField(prop.getProperty("offnetUser"));
		Assert.assertTrue(offnetUserSubject.contains("New Message From "+onnetUser));
		System.out.println(offnetUserSubject);
	}
	
	//Verify the subject field by entering the short names of emojis and by entering text message in message input field
	@Test(priority=27,enabled=true)
	public void verifyEmojiShortNames_SubFieldTest() throws Throwable {
		String emojiShortNames_MsgThread=messageInputField.verifyEmojiShortNames_SubField(userToSelect, prop.getProperty("emojiShortName"), prop.getProperty("msgInputFieldText"));
		Assert.assertEquals(emojiShortNames_MsgThread, "Subject: "+prop.getProperty("emojiShortName")+"\n"+msgInputField_Text);
		System.out.println(emojiShortNames_MsgThread);
	}

	/*Clicking on '@' icon when the cursor position in subject field*/
	@Test(priority=28,enabled=true)
	public void verifySubField_ClickAtMentionTest() throws Throwable {
		String atmentionsSym=messageInputField.verifySubField_ClickAtMention(userToSelect);
		Assert.assertTrue(atmentionsSym.contains("@"));
		System.out.println(atmentionsSym);
	}
	
	/*User clicking on 'Emoji' icon when cursor position in subject field*/
	@Test(priority=29,enabled=true)
	public void verifySubField_ClickEmojiTest() throws Throwable {
		
		Assert.assertTrue(messageInputField.verifySubField_ClickEmoji(userToSelect));
		
	}
	

	//User clicking on'GIF' icon when cursor position in subject field
	@Test(priority=30,enabled=true)
	public void verifySubField_ClickGiphyTest() throws Throwable {
		messageInputField.verifySubField_ClickGiphy(userToSelect);
	}
	
	
	//Verify the message input field by entering only alphabets
	@Test(priority=31,enabled=true)
	public void verifyMsgInputField_AlphabetsTest() throws Throwable {
		String threadMsg=messageInputField.verifyMsgInputField_Alphabets(userToSelect, prop.getProperty("msgInputFieldText"));
		Assert.assertTrue(threadMsg.contains(msgInputField_Text));
		System.out.println(threadMsg);
	}
	
	//Verify the message input field by sending numbers only
	@Test(priority=32,enabled=true)
	public void verifyMsgInputField_NumbersTest() throws Throwable {
		String threadMsg=messageInputField.verifyMsgInputField_Numbers(userToSelect, prop.getProperty("sub_Numbers"));
		Assert.assertTrue(threadMsg.contains(msgInputNumbers));
		System.out.println(threadMsg);
			 
	}
	
	//Verify the message  input field by sending the all special characters 
	@Test(priority=33,enabled=true)
	public void verifyMsgInputField_SplCharsTest() throws Throwable {
		String splChars_ThreadMsg=messageInputField.verifyMsgInputField_SplChars(userToSelect, prop.getProperty("sub_SplChars"));
		Assert.assertTrue(splChars_ThreadMsg.contains(prop.getProperty("sub_SplChars")));
		System.out.println(splChars_ThreadMsg);
	}
	
	//User sending the combination of alphabet,special characters and numbers in message input field
	@Test(priority=34,enabled=true)
	public void verifyMsgInputField_CombinationsTest() throws Throwable {
		String combinations=messageInputField.verifyMsgInputField_Combinations(userToSelect, prop.getProperty("sub_Combinations"));
		Assert.assertTrue(combinations.contains(MsgInputFieldcombinations));
		System.out.println(combinations);
	}
	
	//Verify the message input field by sending the text message and selecting user from '@' at mentions pop up 
	@Test(priority=35,enabled=true)
	public void verifyMsgInputField_TxtMsg_AtMentionsTest() throws Throwable {
		String text_Atmention=messageInputField.verifyMsgInputField_TxtMsg_AtMentions(userToSelect, prop.getProperty("sub_Text"));
		Assert.assertEquals(text_Atmention, text_MsgInputField+" "+"@"+userToSelect);
		
		System.out.println(text_Atmention);
	}
	
	/*Verify the message input field by select the user from at 
	 * mentions pop up clicking on "@" icon and entering some text message
	 */
	@Test(priority=36,enabled=true)
	public void verifyMsgInputField_Atmention_TextMsgTest() throws Throwable {
		String atmention_Text=messageInputField.verifyMsgInputField_Atmention_TextMsg(userToSelect, prop.getProperty("sub_Text"));
		Assert.assertEquals(atmention_Text, "@"+userToSelect+" "+text_MsgInputField);
		System.out.println(atmention_Text);
	}
	
	/*Verify the message input field by sending the text message and selecting an emoji from the emoji's pop up */
	@Test(priority=37,enabled=true)
	public void verifyMsgInputField_Text_EmojiTest() throws Throwable {
		Assert.assertTrue(messageInputField.verifyMsgInputField_Text_Emoji(userToSelect, prop.getProperty("sub_Text")));
	}
	
	//Verify the message input field by entering the long text continuously
	@Test(priority=38,enabled=true)
	public void verifyMsgInputField_LongTextTest() throws Throwable {
		String msgText="This is a test message ";
		int size=messageInputField.verifyMsgInputField_LongText(userToSelect);
	
		String fdjsd=driver.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")).getText();
		int msgInputTxt=fdjsd.length();
		Assert.assertEquals(size, msgInputTxt);
	}
	
	//Check the slim scroll is displaying or not while entering the long text in message input field
	@Test(priority=39,enabled=true)
	public void verifyInputFieldSlimScroll_LongTextTest() throws Throwable {
		Assert.assertTrue(messageInputField.verifyInputFieldSlimScroll_LongText(userToSelect));
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


