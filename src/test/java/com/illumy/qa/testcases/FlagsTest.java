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

import com.illumy.qa.pages.Flags;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class FlagsTest extends TestBase{

	public Flags flags;
	public  SigninPage signinPage;
	public  HomePage homePage;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName 		= "Flags";
	String userToSelect		= "userToSelect";
	String message			= "message";
	String userName			= "userName";
	String url				= "url";
	
	String userToSelect_Row2	= new String (reader.getCellData(sheetName, userToSelect, 2));
	String userToSelect_Row3	= new String (reader.getCellData(sheetName, userToSelect, 3));
	String message_Row2			= new String (reader.getCellData(sheetName, message, 2));
	String userName_Row2		= new String (reader.getCellData(sheetName, userName, 2));
	String url_Row2				= new String (reader.getCellData(sheetName, url, 2));
	
	public FlagsTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		flags=new Flags();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyFlagsInHomePage() {
		Assert.assertTrue(flags.verifyFlagsInHomePage());
	}
	
	@Test(priority=2,enabled=true)
	public void verifyFlagsInMessageModule() throws Throwable {
		String actualMsg = flags.verifyFlagsInMessageModule();
		Assert.assertEquals(actualMsg, "No flags to see here right now!");
		System.out.println(actualMsg);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyFlagsByClickOnVsymbol() throws Throwable {
		Assert.assertTrue(flags.verifyFlagsByClickOnVsymbol(userToSelect_Row2));
	}
	
	@Test(priority=4,enabled=true)
	public void verifyFlagsOpenMode_UserLogoutLogin() throws Throwable {
		Assert.assertTrue(flags.verifyFlagsOpenMode_UserLogoutLogin(userToSelect_Row2,prop.getProperty("illumy_Email"), prop.getProperty("password")));
	}
	
	@Test(priority=5,enabled=true)
	public void verifyFlagsByClickOtherOptions() throws Throwable {
		Assert.assertTrue(flags.verifyFlagsByClickOtherOptions(userToSelect_Row2));
	}
	
	@Test(priority=6,enabled=true)
	public void verifyUserFlagsIfNoFlaggedMsg() throws Throwable {
		String actualMsg = flags.verifyUserFlagsIfNoFlaggedMsg(userToSelect_Row3);
		Assert.assertEquals(actualMsg, "No flags to see here right now!");
		System.out.println(actualMsg);
	}
	
	@Test(priority=7,enabled=true)
	public void verifyFlaggedMsgInFlags() throws Throwable {
		String actualMsg=flags.verifyFlaggedMsgInFlags(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualMsg.contains(message_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=8,enabled=true)
	public void verifyFlaggedMsgUserName() throws Throwable {
		String actualUserName = flags.verifyFlaggedMsgUserName(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualUserName, userName_Row2);
		System.out.println(actualUserName);
	}
	
	@Test(priority=9,enabled=true)
	public void clickOnUserNameInFlags() throws Throwable {
		String actualUrl = flags.clickOnUserNameInFlags(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualUrl, url_Row2);
		System.out.println(actualUrl);
	}
	
	@Test(priority=10,enabled=true)
	public void verifyMousehoverOnFlaggedMsg() throws Throwable {
		Assert.assertTrue(flags.verifyMousehoverOnFlaggedMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=11,enabled=true)
	public void verifyMousehoverOnViewMsg() throws Throwable {
		String actualTooltip = flags.verifyMousehoverOnViewMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, "View Message");
		System.out.println(actualTooltip);
	}
	
	@Test(priority=12,enabled=true)
	public void verifyMousehoverOnFlagSymbol() throws Throwable {
		String actualTooltip = flags.verifyMousehoverOnFlagSymbol(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, "Remove Flag");
		System.out.println(actualTooltip);
	}
	
	@Test(priority=13,enabled=true)
	public void verifyClickOnViewMsg() throws Throwable {
		String expBorderColor = "rgb(255, 255, 255)";
		String actualBoderColor = flags.verifyClickOnViewMsg(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualBoderColor.contains(expBorderColor));
		System.out.println(actualBoderColor);
	}
	
	
	@Test(priority=14,enabled=true)
	public void clickOnRemoveFlagFromThread() throws Throwable {
		Assert.assertTrue(flags.clickOnRemoveFlagFromThread(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=15,enabled=true)
	public void clickOnRemoveFlagFromFlagSection() throws Throwable {
		Assert.assertTrue(flags.clickOnRemoveFlagFromFlagSection(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=16,enabled=true)
	public void verifyScrollOfFlagSection() throws Throwable {
		flags.verifyScrollOfFlagSection(userToSelect_Row2, message_Row2);	
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
