/**
 * 
 */
package com.illumy.qa.testcases;

import java.io.IOException;
import java.util.List;

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
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.pages.VoicemailSettings;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class VoicemailSettingsTest extends TestBase{

	
	public  SigninPage signinPage;
	public  HomePage homePage;
	public  VoicemailSettings voicemail;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "Voicemail";
	String users			= "users";
	
	String users_Row2		= reader.getCellData(sheetName, users, 2);
	String users_Row3		= reader.getCellData(sheetName, users, 3);
	
	
	
	
	String currentUrl = "https://stage.illumy1.com/settings/voice-mail";
	
	
	
	public VoicemailSettingsTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		voicemail=new VoicemailSettings();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyVoicemailInSettings() {
		Assert.assertTrue(voicemail.verifyVoicemailInSettings());
	}
	
	@Test(priority=2,enabled=true)
	public void verifyURLOfVoicemail() {
		String actualUrl = voicemail.verifyURLOfVoicemail();
		Assert.assertEquals(actualUrl, currentUrl);
		System.out.println(actualUrl);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyVoicemailHeader() {
		String actualHeader = voicemail.verifyVoicemailHeader();
		Assert.assertEquals(actualHeader, "Voicemail");
		System.out.println(actualHeader);
	}
	
	@Test(priority=4,enabled=true)
	public void verifyEnableVoicemailText() {
		String actualText = voicemail.verifyEnableVoicemailText();
		Assert.assertEquals(actualText, "Enable voicemail");
		System.out.println(actualText);
	}
	
	@Test(priority=5,enabled=true)
	public void verifyi1UserEnableVoicemailDefaultToggle() {
		Assert.assertTrue(voicemail.verifyi1UserEnableVoicemailDefaultToggle());
	}
	
	@Test(priority=6,enabled=true)
	public void verifyEnableVoicemailTransText() {
		Assert.assertTrue(voicemail.verifyEnableVoicemailTransText());
	}
	
	@Test(priority=7,enabled=true)
	public void verifyEnableVoicemailTranscDefaultToggle() {
		Assert.assertTrue(voicemail.verifyEnableVoicemailTranscDefaultToggle());
	}
	
	@Test(priority=8,enabled=true)
	public void clickOnEnableVoicemailTransToggle() throws Throwable {
		Assert.assertTrue(voicemail.clickOnEnableVoicemailTransToggle());
	}
	
	@Test(priority=9,enabled=true)
	public void verifyVoicemail_UserNotAnsVoiceCall() throws Throwable {
		String actualVoicemail = voicemail.verifyVoicemail_UserNotAnsVoiceCall(users_Row2,users_Row3);
		String expectedVoicemail = "";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		expectedVoicemail = list.get(list.size()-1).getText();
		Assert.assertTrue(actualVoicemail.contains(expectedVoicemail));
		System.out.println(actualVoicemail);
	}
	
	@Test(priority=10,enabled=true)
	public void verifyVoicemail_UserDeclinedVoiceCall() throws Throwable {
		String actualVoicemail = voicemail.verifyVoicemail_UserDeclinedVoiceCall(users_Row2,users_Row3);
		String expectedVoicemail = "";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		expectedVoicemail = list.get(list.size()-1).getText();
		Assert.assertTrue(actualVoicemail.contains(expectedVoicemail));
		System.out.println(actualVoicemail);
	}
	
	@Test(priority=11,enabled=true)
	public void verifyVoicemail_UserNotAnsVideoCall() throws Throwable {
		String actualVoicemail = voicemail.verifyVoicemail_UserNotAnsVideoCall(users_Row2,users_Row3);
		String expectedVoicemail = "";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		expectedVoicemail = list.get(list.size()-1).getText();
		Assert.assertTrue(actualVoicemail.contains(expectedVoicemail));
		System.out.println(actualVoicemail);
	}
	
	@Test(priority=12,enabled=true)
	public void verifyVoicemail_UserDeclinedVideoCall() throws Throwable {
		String actualVoicemail = voicemail.verifyVoicemail_UserDeclinedVideoCall(users_Row2,users_Row3);
		String expectedVoicemail = "";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		expectedVoicemail = list.get(list.size()-1).getText();
		Assert.assertTrue(actualVoicemail.contains(expectedVoicemail));
		System.out.println(actualVoicemail);
	}
	
	@Test(priority=13,enabled=true)
	public void verifyi2UserEnableVoicemailDefaultToggle() throws Throwable {
		Assert.assertTrue(voicemail.verifyi2UserEnableVoicemailDefaultToggle(prop.getProperty("i2userEmail"),prop.getProperty("password2")));
	}
	
	@Test(priority=14,enabled=true)
	public void verifyi2UserEnableVoicemailTransDefaultToggle() throws Throwable {
		Assert.assertTrue(voicemail.verifyi2UserEnableVoicemailTransDefaultToggle(prop.getProperty("i2userEmail"),prop.getProperty("password2")));
	}
	
	@Test(priority=15,enabled=true)
	public void clicki2UserEnableVoicemailTransToggle() throws Throwable {
		Assert.assertTrue(voicemail.clicki2UserEnableVoicemailTransToggle(prop.getProperty("i2userEmail"),prop.getProperty("password2")));
	}
	
	@Test(priority=16,enabled=true)
	public void verifyi3UserEnableVoicemailDefaultToggle() throws Throwable {
		Assert.assertTrue(voicemail.verifyi3UserEnableVoicemailDefaultToggle(prop.getProperty("i3userEmail"),prop.getProperty("password2")));
	}
	
	@Test(priority=17,enabled=true)
	public void verifyi3UserEnableVoicemailTransDefaultToggle() throws Throwable {
		Assert.assertTrue(voicemail.verifyi3UserEnableVoicemailTransDefaultToggle(prop.getProperty("i3userEmail"),prop.getProperty("password2")));
	}
	
	@Test(priority=18,enabled=true)
	public void clicki3UserEnableVoicemailTransToggle() throws Throwable {
		Assert.assertTrue(voicemail.clicki3UserEnableVoicemailTransToggle(prop.getProperty("i3userEmail"),prop.getProperty("password2")));
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
