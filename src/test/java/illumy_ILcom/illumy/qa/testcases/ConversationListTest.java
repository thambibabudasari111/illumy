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
import com.illumy.qa.pages.ConversationList;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;

/**
 * @author thambibabu.dasari
 *
 */
public class ConversationListTest extends TestBase{

	public  SigninPage signinPage;
	public  HomePage homePage;
	public ConversationList conversationList;
	
	String userToSelect="test email";
	String offnetUser="thambibabu.dasari@illumy.com";
	String userToSelect1="Thambi Babu Dasari";
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
		String actual=conversationList.verifyOnnetUserFromConversationList(userToSelect);
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	
	@Test(priority=2,enabled=true)
	public void verifyOffnetUserFromConversationList() {
		String expected="#33354a";
		String actual=conversationList.verifyOffnetUserFromConversationList(offnetUser);
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyClickActionOfOnnetUser() {
		Assert.assertTrue(conversationList.verifyClickActionOfOnnetUser(userToSelect));
	}
	
	@Test(priority=4,enabled=true)
	public void verifySlimScroll_ConversationList() throws Throwable {
		String username="DheemanthDheemanth ChalasaniChalasanidheema";
		String actual=conversationList.verifySlimScroll_ConversationList();
		Assert.assertEquals(actual, username);
		System.out.println(actual);
	}
	
	@Test(priority=5,enabled=true)
	public void verifyFavouriteContact() throws Throwable {
		Assert.assertTrue(conversationList.verifyFavouriteContact(userToSelect));
	}
	
	@Test(priority=6,enabled=true)
	public void verifyOnlineStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyOnlineStatus(userToSelect));
	}
	
	@Test(priority=7,enabled=true )
	public void verifyFavContactOnlineStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyFavContactOnlineStatus(userToSelect));
	}
	
	@Test(priority=8,enabled=true)
	public void verifyFavContactOfflineStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyFavContactOfflineStatus(userToSelect));
	}
	
	@Test(priority=9,enabled=true)
	public void verifyTypingStatus() throws Throwable {
		Assert.assertTrue(conversationList.verifyTypingStatus(userToSelect1,userToSelect));
	}
	
	@Test(priority=10,enabled=true)
	public void verifyUnreadMessageCount() throws Throwable {
		conversationList.verifyUnreadMessageCount(userToSelect);
	}
	
	@Test(priority=11,enabled=true)
	public void verifyNewUserInvitationRequest() throws Throwable {
		String newuser=conversationList.verifyNewUserInvitationRequest(userToSelect1, "test user");
		Assert.assertTrue(newuser.contains("test user"));
		System.out.println(newuser);
	}
	
	@Test(priority=12,enabled=true)
	public void verifyNavigationFromContactsPage() throws Throwable {
		Assert.assertTrue(conversationList.verifyNavigationFromContactsPage(userToSelect));
	}
	
	@Test(priority=13,enabled=true)
	public void verifyVoiceCallSymbol_ConversationList() throws Throwable {
		Assert.assertTrue(conversationList.verifyVoiceCallSymbol_ConversationList(userToSelect));
	}
	
	@Test(priority=14,enabled=true)
	public void verifyVideoCallSymbol_ConversationList() throws Throwable {
		Assert.assertTrue(conversationList.verifyVideoCallSymbol_ConversationList(userToSelect));
	}
	
	@Test(priority=15,enabled=true)
	public void verifyUnreadCount_Atmention() throws Throwable {
		String color=conversationList.verifyUnreadCount_Atmention(userToSelect1, userToSelect);
		System.out.println(color);
	}
	
	@Test(priority=16,enabled=true)
	public void verifyUnreadCountAutoSync() throws Throwable {
		conversationList.verifyUnreadCountAutoSync(userToSelect1);
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
