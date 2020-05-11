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
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.pages.VideoCall;


/**
 * @author thambibabu.dasari
 *
 */
public class VideoCallTest extends TestBase{
	
	
	public VideoCall videoCall;
	public  SigninPage signinPage;
	public static HomePage homePage;
	
	
	String userNameToSelect="Thambi Babu Dasari";
	String userToSelect="test email";
	String userName1="Srikar Poosala";
	String keysToSendInSearchField="test e";
	public VideoCallTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		videoCall=new VideoCall();
	}
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	//Verify the video call in header section of P2P message thread
	@Test(priority=1,enabled=true)
	public void verifyVideoCall_P2PMsgHeaderSectionTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCall_P2PMsgHeaderSection(userToSelect));
	}
	
	//Verify the voice call in  contacts page by clicking on the user name at P2P header section
	@Test(priority=2,enabled=true)
	public void verifyVideoCall_ContactsPageTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCall_ContactsPage(userToSelect));
	}
	
	//Verify the video call icon by entering the keywords in search field
	@Test(priority=3,enabled=true)
	public void verifyVideoCall_SeacrFieldAutoSuggTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCall_SeacrFieldAutoSugg(keysToSendInSearchField, userToSelect));
	}
	
	//Verify voice call icon by clicking on the contacts link from search field by entering keywords
	@Test(priority=4,enabled=true)
	public void verifyVideoCall_ClickingContactsLinkTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCall_ClickingContactsLink(keysToSendInSearchField));
	}
	
	//Verify the video call confirmation pop up window UI
	@Test(priority=5,enabled=true)
	public void verifyVideoCallConfirmationPopUpTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCallConfirmationPopUp(userToSelect));
	}
	
	//Verify the cancel button functionality in the video call confirmation pop up window
	@Test(priority=6,enabled=true)
	public void verifyCancelBtnFunctionalityTest() throws Throwable {
		videoCall.verifyCancelBtnFunctionality(userToSelect);
	}
	
	//Verify the test link in the video call confirmation pop up window
	@Test(priority=7,enabled=true)
	public void verifyTestLinkFunctionalityTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyTestLinkFunctionality(userToSelect));
	}
	
	//Verify the video call window at third panel of user1 and user2 when user1 making voice call to user2
	@Test(priority=8,enabled=true)
	public void verifyVideoCallWindow_User1CallToUser2() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCallWindow_User1CallToUser2(userToSelect));
	}
	
	//Verify the video call window if the user2 not answered the video call
	@Test(priority=9,enabled=true)
	public void verifyVideoCall_User2NotAnsweredCallTest() throws Throwable{
		Assert.assertTrue(videoCall.verifyVideoCall_User2NotAnsweredCall(userToSelect, userNameToSelect));
	}
	
	//Verify the video call if the user2 declined the call of user1
	@Test(priority=10,enabled=true)
	public void verifyVideoCall_User2DeclineCallTest() throws Throwable {
		Assert.assertTrue(videoCall.verifyVideoCall_User2DeclineCall(userToSelect, userNameToSelect));
	}
	
	//Verify the video call of both the users when accepted the video call 
	@Test(priority=11,enabled=true)
	public void verifyVideoCall_IfCallAcceptedTest() throws Throwable {
		videoCall.verifyVideoCall_IfCallAccepted();
	}
	
	
	
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
	}
	
	@AfterTest
	public void endTest() {
		endReport();
	}
	
	@AfterClass
	public void tearDown() throws IOException {	
		driver.quit();
	}

}
