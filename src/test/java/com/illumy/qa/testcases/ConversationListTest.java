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
import com.illumy.qa.pages.ConversationList;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;

import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ConversationListTest extends TestBase{

	public  SigninPage signinPage;
	public  HomePage homePage;
	public ConversationList conversationList;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName	= "ConversationList";
	String userToSelect	= "userToSelect";
	String offnetUser	= "offnetUser";
	String newUser		= "newUser";
	String conversationListScrollUser	= "conversationListScrollUser";
	
	String userToSelect_Row2	= reader.getCellData(sheetName, userToSelect, 2);
	String userToSelect_Row3	= reader.getCellData(sheetName, userToSelect, 3);
	String offnetUser_Row2		= reader.getCellData(sheetName, offnetUser, 2);
	String conversationListScrollUser_Row2	= reader.getCellData(sheetName, conversationListScrollUser, 2);
	String conversationListScrollUser_Row3	= reader.getCellData(sheetName, conversationListScrollUser, 3);
	String newUser_Row2			= reader.getCellData(sheetName, newUser, 2);
	
	public ConversationListTest() {
		super();
	}
	

	@BeforeMethod
	public void startTest(ITestResult result) throws InterruptedException {
		initialization();
		signinPage=new SigninPage();
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		conversationList=new ConversationList();
		testStart(result);	
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyOnnetUserFromConversationList() {
		String expected="#2e008b";
		String actual=conversationList.verifyOnnetUserFromConversationList(userToSelect_Row2);
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	
	@Test(priority=2,enabled=true)
	public void verifyOffnetUserFromConversationList() throws Throwable {
		String expected="#33354a";
		String actual=conversationList.verifyOffnetUserFromConversationList(offnetUser_Row2);
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyClickActionOfOnnetUser() {
		Assert.assertTrue(conversationList.verifyClickActionOfOnnetUser(userToSelect_Row2));
	}
	
	@Test(priority=4,enabled=true)
	public void verifySlimScroll_ConversationList() throws Throwable {
		
		conversationList.verifySlimScroll_ConversationList(conversationListScrollUser_Row2);
//	String username=conversationListScrollUser_Row2;
//	Assert.assertEquals(actual, username);
//		System.out.println(actual);
	}
	
	
	@Test(priority=5,enabled=true)
	public void verifyFavouriteContact() throws Throwable {
		Assert.assertTrue(conversationList.verifyFavouriteContact(userToSelect_Row2));
	}
	
	@Test(priority=6,enabled=true)
	public void verifyOnlineStatus() throws Throwable {
		
		Assert.assertTrue(conversationList.verifyOnlineStatus(userToSelect_Row2));
	}
	
	@Test(priority=7,enabled=true )
	public void verifyFavContactOnlineStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyFavContactOnlineStatus(userToSelect_Row2));
	}
	
	@Test(priority=8,enabled=true)
	public void verifyFavContactOfflineStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyFavContactOfflineStatus(userToSelect_Row2));
	}
	
	@Test(priority=9,enabled=true)
	public void verifyTypingStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyTypingStatus(userToSelect_Row3,userToSelect_Row2));
	}
	
	@Test(priority=10,enabled=true)
	public void verifyUnreadMessageCount() throws Throwable {
		conversationList.verifyUnreadMessageCount(userToSelect_Row3);
	}
	
	@Test(priority=11,enabled=true)
	public void verifyNewUserInvitationRequest() throws Throwable {
		String newInvitation=conversationList.verifyNewUserInvitationRequest(userToSelect_Row3,newUser_Row2);
		String newUser_ConversationList=newUser_Row2;
		Assert.assertEquals(newInvitation, newUser_ConversationList);
		System.out.println(newInvitation);
		
	}
	
	@Test(priority=12,enabled=true)
	public void verifyNavigationFromContactsPage() throws Throwable {
		Assert.assertTrue(conversationList.verifyNavigationFromContactsPage(userToSelect_Row2));
	}
	
	@Test(priority=13,enabled=true)
	public void verifyVoiceCallSymbol_ConversationList() throws Throwable {
		Assert.assertTrue(conversationList.verifyVoiceCallSymbol_ConversationList(userToSelect_Row2));
	}
	
	@Test(priority=14,enabled=true)
	public void verifyVideoCallSymbol_ConversationList() throws Throwable {
		Assert.assertTrue(conversationList.verifyVideoCallSymbol_ConversationList(userToSelect_Row2));
	}
	
	@Test(priority=15,enabled=true)
	public void verifyUnreadCount_Atmention() throws Throwable {
		String color=conversationList.verifyUnreadCount_Atmention(userToSelect_Row3,userToSelect_Row2);
		System.out.println(color);
	}
	
	@Test(priority=16,enabled=true)
	public void verifyUnreadCountAutoSync() throws Throwable {
		conversationList.verifyUnreadCountAutoSync(userToSelect_Row3);
	}
	
	@Test(priority=17,enabled=true)
	public void verifyOffnetUsers() {
		conversationList.verifyOffnetUsers();
	}
	
	@Test(priority=18,enabled=true)
	public void verifyNoConversations() {
		conversationList.verifyOnnetUsers();
	}
	
	@Test(priority=19,enabled=true)
	public void verifyOnnetUsers() {
		conversationList.verifyOnnetUsers();
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
