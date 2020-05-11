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

import com.illumy.qa.pages.Reply;
import com.illumy.qa.pages.SigninPage;

import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ReplyTest extends TestBase{

	public Reply reply;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "Reply";
	String userToSelect		= "userToSelect";
	String message			= "message";
	String replyMsg			= "replyMsg";
	
	String userToSelect_Row2	= new String (reader.getCellData(sheetName, userToSelect, 2));
	String message_Row2			= new String (reader.getCellData(sheetName, message, 2));
	String replyMsg_Row2		= new String (reader.getCellData(sheetName, replyMsg, 2));	
	
	
	public ReplyTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		reply = new Reply();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	//Verify the reply click functionality by clicking on  more options of a message
	@Test
	public void verifyReplyClickAction() throws Exception, Throwable {
		Assert.assertTrue(reply.verifyReplyClickAction(userToSelect_Row2,message_Row2));
	}
	
	//Check whether the reply message in highlighted with border or not above message input field
	@Test(priority=2,enabled=true)
	public void verifyReplyMsgBorderTest() throws Throwable {
		String expReplyMsgBorderColor="#05aff2";
		String actualReplyMsgBorderColor=reply.verifyReplyMsgBorder(userToSelect_Row2,message_Row2);
		Assert.assertEquals(actualReplyMsgBorderColor, expReplyMsgBorderColor);
		System.out.println(actualReplyMsgBorderColor);
	}
	
	//Verify the avatar, user name, date, and time stamp in the reply message above the message input field
	@Test(priority=3,enabled=true)
	public void verifyReplyMsgUserName_Date_Time() throws Throwable {
		Assert.assertTrue(reply.verifyReplyMsgUserName_Date_Time(userToSelect_Row2,message_Row2));
	}
	
	//Verify the 'Reply All' icon in reply message section
	@Test(priority=4,enabled=true)
	public void verifyReplyAllIcon_ReplyMsg() throws Throwable {
		Assert.assertTrue(reply.verifyReplyAllIcon_ReplyMsg(userToSelect_Row2,message_Row2));
	}
	
	//Check the cross symbol (X) is displaying or not at the right hand side of the reply message section
	@Test(priority=5,enabled=true)
	public void verifyCrossSymbol_ReplyMsgTest() throws Throwable {
		Assert.assertTrue(reply.verifyCrossSymbol_ReplyMsg(userToSelect_Row2,message_Row2));
	}
	
	//Verify the scroll functionality is working or not for long text messages in reply message view
	@Test(priority=6,enabled=true)
	public void verifyReplyMsg_ScrollBarForLongText() throws Throwable {
		Assert.assertTrue(reply.verifyReplyMsg_ScrollBarForLongText(userToSelect_Row2,message_Row2));
	}
	
	//Verify the click functionality of the 'Reply All' icon in the reply message section
	@Test(priority=7,enabled=true)
	public void verifyReplyAllIconClickAction() throws Throwable {
		Assert.assertTrue(reply.verifyReplyAllIconClickAction(userToSelect_Row2,message_Row2));
	}
	
	//Verify that the reply message is closing or not by clicking on the  cross symbol (X) icon
	@Test(priority=8,enabled=true)
	public void verifyReplyMsg_CrossSymClickAction() throws Throwable {
		Assert.assertTrue(reply.verifyReplyMsg_CrossSymClickAction(userToSelect_Row2,message_Row2));
	}
	
	//Verify the default subject for the reply message by clicking on 'Add subject'
	@Test(priority=9,enabled=true)
	public void verifyDefaultSubject_ReplyMsg() throws Throwable {
		String defaultSubject=reply.verifyDefaultSubject_ReplyMsg(userToSelect_Row2,message_Row2);
		Assert.assertEquals(defaultSubject, "illumy - Reply Message");
		System.out.println("Default subject for reply message: "+defaultSubject);
	}
	
	//Verify the reply message in message thread by  giving reply to that particular message
	@Test(priority=10,enabled=true)
	public void verifyReplyMsgInMsgThread() throws Throwable {
		String replyMsg_MsgThread=reply.verifyReplyMsgInMsgThread(userToSelect_Row2, message_Row2, replyMsg_Row2);
		Assert.assertTrue(replyMsg_MsgThread.contains(message_Row2));
		System.out.println(replyMsg_MsgThread);
	}
	
	//Verify that by sending the message with enabling the subject line should deliver the subject as well
	@Test(priority=11,enabled=true)
	public void verifyReplyMsgWithDefaultSubject() throws Throwable {
		
		String actualMsg=reply.verifyReplyMsgWithDefaultSubject(userToSelect_Row2, message_Row2, replyMsg_Row2);
		String defaultSubject="Subject: illumy - Reply Message";
		Assert.assertTrue(actualMsg.contains(defaultSubject));
		System.out.println(actualMsg);
	}
	
	//Verify that view message option in the replay message beside the replied message
	@Test(priority=12,enabled=true)
	public void verifyViewMsgOption_ReplyMsg() throws Throwable {
		Assert.assertTrue(reply.verifyViewMsgOption_ReplyMsg(userToSelect_Row2, message_Row2, replyMsg_Row2));	
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
