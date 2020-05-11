/**
 * 
 */
package illumy_ILcom.illumy.qa.testcases;

import java.io.IOException;




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
import com.illumy.qa.pages.ComposeMessage;

import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.ExcelReader;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ComposeMessageTest extends TestBase{

	public  ComposeMessage composeMsg;
	public  SigninPage signinPage;
	public  HomePage homePage;
	public 	TestUtil testUtil;
	Xls_Reader reader=new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName="ComposeMessage";
	String to="to";
	String userToSelect="userToSelect";
	String subject="subject";
	String message="message";
	String atMentions="atMentions";
	String invalidEmail="invalidEmail";
	String offnetUser="offnetUser";
	String groupName="groupName";
	String userToSelect1="Thambi Babu Dasari";
	public ComposeMessageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		composeMsg=new ComposeMessage();
		testStart(result);
	}
	
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	//Verifying the compose message text
	@Test(priority=1,enabled=true)
	public void verifyComposeMsg() {
		String compMsgTxt=composeMsg.getComposeMsgText();
		Assert.assertEquals(compMsgTxt, "Compose Message", "Compose Message Text not identified");
		System.out.println(compMsgTxt);
	}
	
	//Verifying click functionality of compose message 
	@Test(priority=2,enabled=true)
	public void verifyComposeMsgPopup() {
		String createNewThread=composeMsg.compMsg_ClickAction();
		Assert.assertEquals(createNewThread, "Compose Message","There is no Create a new thread… text there");
		System.out.println(createNewThread);
	}
	
	//Verify by clicking on the 'X' symbol to close the new message thread window
	@Test(priority=3,enabled=true)
	public void close_ComposeMsgPopup() throws Throwable {
		Assert.assertTrue(composeMsg.closeThread());
	}
	
	//Verifying the create new thread window 
	@Test(priority=4,enabled=true)
	public void verifyComposeMsgUITest() throws Throwable {
		Assert.assertTrue(composeMsg.verifyComposeMsgUI());
	}

	//Verify the To field by click on the send button with selecting any user
	@Test(priority=5,enabled=true)
	public void verifyToFiledWithoutSelectUser() throws Throwable {
		String selectAtleasetOneUser=composeMsg.verifyToFiledWithoutSelectUser();
		Assert.assertEquals(selectAtleasetOneUser, "Please select at least one user.");
		System.out.println(selectAtleasetOneUser);
	}
	
	//Clicking on send button by entering invalid email id in To field
	@Test(priority=6,enabled=true)
	public void verifyToField_InvalidEmail() throws Exception {
		String enterValidEmail=composeMsg.verifyToField_InvalidEmail(ExcelReader.getValue("ComposeMessage", "invalidEmail"));
		Assert.assertEquals(enterValidEmail, "Enter a valid email address.");
		System.out.println(enterValidEmail);
	}
	
	
	//Verify the To filed functionality
	@Test(priority=7,enabled=true)
	public void verifyToField_SelectSingleUser() throws Throwable {
		Assert.assertTrue(composeMsg.verifyToField_SelectSingleUser(ExcelReader.getValue("ComposeMessage", "keys_ToField"), 
				ExcelReader.getValue("ComposeMessage", "userToSelect")));
	}
	
	//Verify the create group toggle by selecting the more than one user in To field
	@Test(priority=8,enabled=true)
	public void veriyCrateGroupToggle_SelectMorethanOneUser() throws Throwable {
		Assert.assertTrue(composeMsg.veriyCrateGroupToggle_SelectMorethanOneUser(ExcelReader.getValue("ComposeMessage", "keys_ToField"),
				ExcelReader.getValue("ComposeMessage", "userToSelect"), 
				ExcelReader.getValue("ComposeMessage", "ToField_Key1")));
	}
	
	//Verify the Cc field by clicking on the Cc link in To filed 
	@Test(priority=9,enabled=true)
	public void verifyCcClickAction_ToField() {
		try {
			Assert.assertTrue(composeMsg.verifyCcClickAction_ToField());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Click on send button by selecting an user and with out subject and message body
	@Test(priority=10,enabled=true)
	public void verifyMsgThread_SendWithoutSubj_MsgBody() throws Throwable {
		
			composeMsg.verifyMsgThread_SendWithoutSubj_MsgBody(ExcelReader.getValue("ComposeMessage", "keys_ToField"),
					ExcelReader.getValue("ComposeMessage", "userToSelect"),
					ExcelReader.getValue("ComposeMessage", "senderUserName"));
			
		
	}
	
	/*Click on 'Send' button without entering any subject in 'Subject' filed and enter some text in 'Message' field 
	by selecting a single user from auto suggestions list drop down or entering a single user in'To' Field */
	@Test(priority=9,enabled=true)
	public void send_OnlyMessage() throws Throwable {
	String threadMsg=composeMsg.send_OnlyMessage(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName,message , 2));	
		System.out.println(threadMsg);
	}
	
	/*
	 * Click on 'Send' button entering any subject in 'Subject' filed and without entering any text in 'Message' field
	 *  by selecting a single user from auto suggestions list drop down or entering a single user in'To' Field 
	 */
		@Test(priority=10,enabled=true)
	public void send_OnlySubject() throws Throwable {
		Assert.assertTrue(composeMsg.send_OnlySubject(reader.getCellData(sheetName, to, 2), 
			reader.getCellData(sheetName, userToSelect, 2),reader.getCellData(sheetName, subject, 2)));
	}
	

	//Click on 'Send' button by selecting a single user for the first time from the auto suggestions list drop down of To field
	@Test(priority=11,enabled=true)
	public void send_Invitation_FirstTime() throws Throwable {
		Assert.assertTrue(composeMsg.send_Invitation_FirstTime(reader.getCellData(sheetName, to, 4),
			reader.getCellData(sheetName, userToSelect, 4)));
	}
	
	
	/*
	 * Click on 'Send' button entering any subject in 'Subject' filed and entering any text in 'Message' 
	 * field by selecting a single user from auto suggestions list drop down or entering a single user in'To' Field 
	 */
	@Test(priority=12,enabled=true)
	public void send_Subject_Message() throws Throwable {
		String msgThread=composeMsg.send_Subject_Message(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, subject, 2),
				reader.getCellData(sheetName, message, 2));
		System.out.println(msgThread);
	}
	
	@Test(priority=13,enabled=true)
	public void send_AtMention() throws Throwable {
		Assert.assertTrue(composeMsg.send_AtMention(reader.getCellData(sheetName, atMentions, 2)));
		
	}
	
	
	@Test(priority=14,enabled=true)
	public void send_AtMention_SingleUser() throws Throwable {
		String threadAtMentions=composeMsg.send_AtMention_singleUser(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2));
		System.out.println(threadAtMentions);
	}
	
	@Test(priority=15,enabled=true)
	public void send_Emoji() throws Throwable {
		Assert.assertTrue(composeMsg.send_Emoji(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2)));
		
	}
	
	@Test(priority=16,enabled=true)
	public void send_GIF() throws Throwable {
		Assert.assertTrue(composeMsg.send_GIF(reader.getCellData(sheetName, to, 2),
				reader.getCellData(sheetName, userToSelect, 2)));
	}
	
	@Test(priority=17,enabled=true) //getting failed 
	public void send_Attachement() throws Throwable {
		Assert.assertTrue(composeMsg.send_Attachement(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2),
				TestUtil.FILEPATH_TO_UPLOAD));
	}
	
	@Test(priority=18,enabled=true)
	public void atMention_AutoSugg() throws Throwable {
		composeMsg.atMention_AutoSugg(reader.getCellData(sheetName, to, 2),
				reader.getCellData(sheetName, userToSelect, 2));
		
	}
	
	@Test(priority=19,enabled=true)
	public void send_SplChars_Subject_Message() throws Throwable {
		String sub_MsgFields=composeMsg.send_SplChars_Subject_Message(reader.getCellData(sheetName, to, 2),
				reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, subject, 3),
				reader.getCellData(sheetName, message, 3));
		System.out.println(sub_MsgFields);
	}
	
	@Test(priority=20,enabled=true)
	public void send_MessageToGroup() throws Throwable {
		composeMsg.send_MessageToGroup(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, offnetUser, 2),
				reader.getCellData(sheetName, subject, 2),reader.getCellData(sheetName, message, 3));	
	}
	
	//Verify the Emoji's shortcuts functionality in message body
	@Test(priority=21,enabled=true)
	public void emojiShortcuts() throws Throwable {
		Assert.assertTrue(composeMsg.emojiShortcuts(reader.getCellData(sheetName, to, 2),
				reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 5)));
	}
	
	//Verify creating a Group by giving same Group name with same email id's or user names
	@Test(priority=22,enabled=true)
	public void createGroup_SameEmails() throws Throwable {
		String grupName=composeMsg.createGroup_SameEmails(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, userToSelect, 3), 
				reader.getCellData(sheetName, groupName, 2));
		System.out.println(grupName);
	}
	
	//Verify creating a Group by giving different Group name with same email id's or user names
	@Test(priority=23,enabled=true)
	public void createGroup_DiffName() throws Throwable {
		Assert.assertTrue(composeMsg.createGroup_DiffName(reader.getCellData(sheetName, to, 2), 
				reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, userToSelect, 3), 
				reader.getCellData(sheetName, groupName, 3)));	
	}
	
	@Test(priority=24,enabled=true)
	public void send_SameGroupName() throws Throwable {
		composeMsg.send_SameGroupName(reader.getCellData(sheetName, to, 2),
				reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, userToSelect, 3),
				reader.getCellData(sheetName, subject, 2));
	}
	
	//Click on 'Cancel' button in the new thread window 
	@Test(priority=25,enabled=true)
	public void cancelBtn() throws Throwable {
		Assert.assertTrue(composeMsg.cancelBtn());
	}
	
	
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		//driver.quit();
	}
	
	@AfterTest
	public void endTest() {
		endReport();
	}
	
	
}
