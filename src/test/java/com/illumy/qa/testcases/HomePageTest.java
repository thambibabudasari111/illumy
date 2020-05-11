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
import com.illumy.qa.pages.SigninPage;
//import com.illumy.qa.pages.and;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class HomePageTest extends TestBase{

	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	public  HomePage homePage;
	public  SigninPage signinPage;
	TestUtil testUtil;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void startTest(ITestResult result) throws InterruptedException {
		initialization();
		signinPage=new SigninPage();
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		testStart(result);	
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	//Verify the title of the home page
	@Test(priority=1,enabled=true)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String homePageTitle=homePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"illumy messaging","Home page title not matched");
		System.out.println(homePageTitle);
	}
	
	//Verifying the digital identity panel
	@Test(priority=2,enabled=true)
	public void verifyDigitalIdentityPanelTest() {
		Assert.assertTrue(homePage.verifyDigitalIdentityPanel());
	}
	
	//Verify the user name by clicking on the user avatar in digital identity panel
	@Test(priority=3,enabled=true)
	public void verify_UserName_DigitalIdentityPanelTest() throws Throwable {
		Assert.assertTrue(homePage.verify_UserName_DigitalIdentityPanel());
		
	}
	
	//Verifying the email id by clicking on the user avatar in digital identity panel
	@Test(priority=4,enabled=true)
	public void verify_EmailId_DigitalIdentityPanelTest() throws Throwable {
		Assert.assertTrue(homePage.verify_EmailId_DigitalIdentityPanel());
		
	}
	
	//Verifying my profile by clicking on it navigating to illumy contacts page
	@Test(priority=5,enabled=true)
	public void verify_MyProfileTest() throws Throwable {
		String myProfile=homePage.verify_MyProfile();
		Assert.assertEquals(myProfile, "illumy contacts", "illumy contacts page title mismatched");
		System.out.println(myProfile);
	}
	
	//Verifying setting in digital identity panel
	@Test(priority=6,enabled=true)
	public void verify_SettingsTest() throws Throwable {
		String settings=homePage.verify_Settings();
		Assert.assertEquals(settings, "illumy settings", "illumy settings page title mismatched");
		System.out.println(settings);
	}
	
	//Verify the my plan i1 in digital identity panel
	@Test(priority=7,enabled=true)
	public void verify_myPlani1() throws Throwable {
		Assert.assertTrue(homePage.verify_myPlani1());
	}
	
	//Verify the upgrade link in the my plan i1 
	@Test(priority=8,enabled=true)
	public void verify_UpgradeLink() throws Throwable {
		Assert.assertTrue(homePage.verify_UpgradeLink());
	}
	
	//Verifying the sign out link in digital identity panel
	@Test(priority=9,enabled=true)
	public void verify_SignOutTest() throws Throwable {
		String illumySignInTitle=homePage.verify_SignOut();
		Assert.assertEquals(illumySignInTitle, "illumy", "illumy sing-in page title mismatched");
		System.out.println(illumySignInTitle);
	}
	
	//Verifying the sprite menu in home page
	@Test(priority=10,enabled=true)
	public void verify_SpriteMenuTest() throws Throwable {
		Assert.assertTrue(homePage.verify_SpriteMenu());
	}
	
	//Verify the functionality of contacts link in the sprite menu
	@Test(priority=11,enabled=true)
	public void verify_ContactsLinkTest() throws Throwable {
		String contactsPage=homePage.verify_ContactsIcon();
		Assert.assertEquals(contactsPage, "illumy contacts","illumy contacts page title mismatched");
	}
	
	//Verify the functionality of messaging link in the sprite menu
	@Test(priority=12,enabled=true)
	public void verify_MessagingIconTest() throws Throwable {
		String contactsPage=homePage.verify_MessagingIcon();
		Assert.assertEquals(contactsPage, "illumy messaging","illumy messaging page title mismatched");
	}
	
	//Verify the functionality of calendar icon in the sprite menu
	@Test(priority=13,enabled=true)
	public void verify_CalendarIconTest() throws Throwable {
		String contactsPage=homePage.verify_CalendarIcon();
		
		System.out.println(contactsPage);
	}
	
	//Verifying the IOS icon in the sprite menu
	@Test(priority=14,enabled=true)
	public void veriyf_IOSIconTest() throws Throwable {
		String iosPageTitle=homePage.veriyf_IOSIcon();
		
		System.out.println(iosPageTitle);
	}
	
	//Verify the android icon in the sprite menu
	@Test(priority=15,enabled=true)
	public void verify_AndroidIconTest() throws Throwable {
		String androidPageTitle=homePage.veriyf_IOSIcon();
		
		System.out.println(androidPageTitle);
	}
	
	//Verify the invite friends in the home page
	@Test(priority=16,enabled=true)
	public void verify_InviteFriendsTest() throws Throwable {
		Assert.assertTrue(homePage.verifyMessagingIcon());
	}
	
	//Verify the dial pad in the home page
	@Test(priority=17,enabled=true)
	public void verify_DialPad() throws Throwable {
		Assert.assertTrue(homePage.verify_DialPad());
	}
	
	//Verify the search field in the home page
	@Test(priority=18,enabled=true)
	public void verify_SearchField() throws Throwable {
		Assert.assertTrue(homePage.verify_SearchField());
	}
	
	//Verify the compose message in the home page
	@Test(priority=19,enabled=true)
	public void verify_ComposeMessageTest() throws Throwable {
		String composeMsgTitle=homePage.verify_ComposeMessage();
		Assert.assertEquals(composeMsgTitle, "Compose Message","Compose message window title mismatched");
		System.out.println(composeMsgTitle);
	}
	
	//Verify the conversation list in the home page at the left panel
	@Test(priority=20,enabled=true)
	public void verify_ConversationListTest() {
		homePage.verify_ConversationList();
	}
	
	//Verifying the middle panel in home page
	@Test(priority=21,enabled=true)
	public void verify_MiddlePanelTest() {
		Assert.assertTrue(homePage.verify_MiddlePanel());
	}
	
	//Verify the files section in the third panel of the home page screen
	@Test(priority=22,enabled=true)
	public void verify_FilesTest() throws Throwable {
		homePage.verify_Files();
	}
	
	//Verifying the flags section in the third panel of the home page screen 
	@Test(priority=23,enabled=true)
	public void verify_Flags() throws Throwable {
		homePage.verify_Flags();
	}
	
	//Verifying the calendar section in the third panel of the home page
	@Test(priority=24,enabled=true)
	public void verify_CalendarTest() throws Throwable {
	homePage.verify_Calendar();
	}
	
	//Verifying the friend suggestions in the third panel of the home page
	@Test(priority=25,enabled=true)
	public void verify_FriendSuggestionsTest() throws Throwable {
		homePage.verify_FriendSuggestions();
	}
	
	//Verifying the see more in friend suggestion of the home page
	@Test(priority=26,enabled=true)
	public void verify_SeeMoreLinkTest() throws Throwable {
		homePage.verify_SeeMoreLink();
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

