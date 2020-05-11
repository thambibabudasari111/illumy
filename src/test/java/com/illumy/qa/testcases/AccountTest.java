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
import com.illumy.qa.pages.Account;

import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class AccountTest extends TestBase{

	public  SigninPage signinPage;
	public  HomePage homePage;
	public  Account account;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName	= "Account";
	String email 		= "email";
	String flag 		= "flag";
	String countryCode	= "countryCode";
	String mobileNum	= "mobileNum";
	String text 		= "text";
	String url			= "url";
	String password		= "password";
	
	String email_Row2			= new String (reader.getCellData(sheetName, email, 2));
	String flag_Row2			= new String (reader.getCellData(sheetName, flag, 2));
	String countryCode_Row2		= new String (reader.getCellData(sheetName, countryCode, 2));
	
	String mobileNum_Row2		= new String (reader.getCellData(sheetName, mobileNum, 2));
	String mobileNum_Row3		= new String (reader.getCellData(sheetName, mobileNum, 3));
	String mobileNum_Row4		= new String (reader.getCellData(sheetName, mobileNum, 4));
	String mobileNum_Row5		= new String (reader.getCellData(sheetName, mobileNum, 5));
	String mobileNum_Row6		= new String (reader.getCellData(sheetName, mobileNum, 6));
	String mobileNum_Row7		= new String (reader.getCellData(sheetName, mobileNum, 7));
	String mobileNum_Row8		= new String (reader.getCellData(sheetName, mobileNum, 8));
	String mobileNum_Row9		= new String (reader.getCellData(sheetName, mobileNum, 9));
	String mobileNum_Row10		= new String (reader.getCellData(sheetName, mobileNum, 10));
	String mobileNum_Row11		= new String (reader.getCellData(sheetName, mobileNum, 11));
	
	String url_Row2				= new String (reader.getCellData(sheetName, url, 2));
	String url_Row3				= new String (reader.getCellData(sheetName, url, 3));
	
	String password_Row2		= new String (reader.getCellData(sheetName, password, 2));
	String password_Row3		= new String (reader.getCellData(sheetName, password, 3));
	String password_Row4		= new String (reader.getCellData(sheetName, password, 4));
	String password_Row5		= new String (reader.getCellData(sheetName, password, 5));
	
	String text_Row2			= new String (reader.getCellData(sheetName, text, 2));
	String text_Row3			= new String (reader.getCellData(sheetName, text, 3));
	
	
	public AccountTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		account=new Account();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyHeaderOfAccount() throws Throwable {
		Assert.assertTrue(account.verifyHeaderOfAccount());
	}
	
	@Test(priority=2,enabled=true)
	public void verifyillumyEmailId() throws Throwable {
		String actualEmail = account.verifyillumyEmailId();
		Assert.assertEquals(actualEmail,email_Row2 );
		System.out.println(actualEmail);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyCountryFlagInAccount() throws Throwable {
		String actualFlag = account.verifyCountryFlagInAccount();
		Assert.assertTrue(actualFlag.contains(flag_Row2));
		System.out.println(actualFlag);
	}
	
	@Test(priority=4,enabled=true)
	public void verifyCountryCodeInAccount() throws Throwable {
		String actualCode = account.verifyCountryCode_Account();
		Assert.assertTrue(actualCode.contains(countryCode_Row2));
		System.out.println(actualCode);
	}
	
	@Test(priority=5,enabled=true)
	public void verifyMobNum_Account() throws Throwable {
		String actualMobNum = account.verifyMobNum_Account();
		Assert.assertTrue(actualMobNum.contains(mobileNum_Row2));
		System.out.println(actualMobNum);
	}
	
	@Test(priority=6,enabled=true)
	public void verifyCheckIconInAccount() throws Throwable {
		Assert.assertTrue(account.verifyCheckIconInAccount());
	}

	@Test(priority=7,enabled=true)
	public void verifyChangeNumBtnInAccount() throws Throwable {
		Assert.assertTrue(account.verifyChangeNumBtnInAccount());
	}
	
	@Test(priority=8,enabled=true)
	public void clickOnChangeNumBtn_Account() throws Throwable {
		String actualTitle = account.clickOnChangeNumBtn_Account();
		Assert.assertEquals(actualTitle, "Change Your Password Recovery Mobile Number");
		System.out.println(actualTitle);
	}
	
	@Test(priority=9,enabled=true)
	public void closeChangePwdRecoveryMobNumPopup() throws Throwable{
		Assert.assertTrue(account.closeChangePwdRecoveryMobNumPopup());
	}
	
	@Test(priority=10,enabled=true)
	public void verifyCountryFlag_ChangePwdMobNunPopup() throws Throwable {
		String actualFlag = account.verifyCountryFlag_ChangePwdMobNunPopup();
		Assert.assertTrue(actualFlag.contains(flag_Row2));
		System.out.println(actualFlag);
	}
	
	@Test(priority=11,enabled=true)
	public void clickOnCountryFlag_ChangePwdMobNunPopup() throws Throwable {
		Assert.assertTrue(account.clickOnCountryFlag_ChangePwdMobNunPopup());
	}
	
	@Test(priority=12,enabled=true)  
	public void clickOnArrow_ChangePwdMobNunPopup() throws Throwable {
		Assert.assertTrue(account.clickOnArrow_ChangePwdMobNunPopup());
	}
	
	@Test(priority=13,enabled=true)
	public void verifyMobNumText_ChangePwdMobNunPopup() throws Throwable {
		String actualMsg = account.verifyMobNumText_ChangePwdMobNunPopup();
		Assert.assertTrue(actualMsg.contains(text_Row2));
		System.out.println(actualMsg);
	}
	
	@Test(priority=14,enabled=true)
	public void verifyStar_ChangePwdMobNunPopup() throws Throwable {
		String actualMsg = account.verifyStar_ChangePwdMobNunPopup();
		Assert.assertTrue(actualMsg.contains(text_Row3));
		System.out.println(actualMsg);
	}
	
	@Test(priority=15,enabled=true)
	public void clickOnCancel_ChangePwdMobNunPopup() throws Throwable {
		Assert.assertTrue(account.clickOnCancel_ChangePwdMobNunPopup());
	}
	
	@Test(priority=16,enabled=true)
	public void verifyNextBtnWithoutMobileNum() throws Throwable {
		Assert.assertTrue(account.verifyNextBtnWithoutMobileNum());
	}
	
	@Test(priority=17,enabled=true)
	public void verifyNextBtnByEnter3DigitsMobNum() throws Throwable {
		Assert.assertTrue(account.verifyNextBtnByEnter3DigitsMobNum(mobileNum_Row3));
	}
	
	@Test(priority=18,enabled=true)
	public void checkNextBtnByEnterMoreThan3DigistsMobNum() throws Throwable {
		Assert.assertTrue(account.checkNextBtnByEnterMoreThan3DigistsMobNum(mobileNum_Row4));
	}
	
	@Test(priority=19,enabled=true)
	public void verifyMobNumByEnterCurrentNum() throws Throwable {
		String actualMsg = account.verifyMobNumByEnterCurrentNum(mobileNum_Row5);
		Assert.assertEquals(actualMsg, "The mobile number you provided is the same as your current number. Please try again.");
		System.out.println(actualMsg);
	}
	
	@Test(priority=20,enabled=true)
	public void verifyMobNumByEnter3Digits() throws Throwable {
		String actualMsg = account.verifyMobNumByEnter3Digits(mobileNum_Row3);
		Assert.assertEquals(actualMsg, "Enter a valid mobile number");
		System.out.println(actualMsg);
	}
	
	@Test(priority=21,enabled=true)
	public void verifyMobNumByEnterAlphbet() throws Throwable {
		String actualMsg = account.verifyMobNumByEnterAlphbet(mobileNum_Row6);
		Assert.assertEquals(actualMsg, "Mobile number should be only in digits");
		System.out.println(actualMsg);
	}
	
	@Test(priority=22,enabled=true)
	public void verifyMobNumByEnterSplChars() throws Throwable {
		String actualMsg = account.verifyMobNumByEnterSplChars(mobileNum_Row7);
		Assert.assertEquals(actualMsg, "Mobile number should be only in digits");
		System.out.println(actualMsg);
	}
	
	@Test(priority=23,enabled=true) 
	public void verifyMobNumByEnterCombinations() throws Throwable {
		String actualMsg = account.verifyMobNumByEnterCombinations(mobileNum_Row8);
		Assert.assertEquals(actualMsg, "Mobile number should be only in digits");
		System.out.println(actualMsg);
	}
	
	@Test(priority=24,enabled=true)
	public void verifyMobNumByEnter11Digits() throws Throwable {
		String actualMsg = account.verifyMobNumByEnter11Digits(mobileNum_Row9);
		Assert.assertEquals(actualMsg, "Enter a valid mobile number");
		System.out.println(actualMsg);
	}
	
	@Test(priority=25,enabled=true)
	public void verifyMobNumByEnterValidNum() throws Throwable {
		String actualMsg = account.verifyMobNumByEnterValidNum(mobileNum_Row10);
		Assert.assertTrue(actualMsg.contains("We’ve sent you a mobile verification code to verify your mobile number"));
		System.out.println(actualMsg);
	}
	
	@Test(priority=26,enabled=true)
	public void verifyTextInOTPSection() throws Throwable {
		String actualMsg = account.verifyTextInOTPSection(mobileNum_Row10);
		Assert.assertTrue(actualMsg.contains(mobileNum_Row10));
		System.out.println(actualMsg);
	}
	
	@Test(priority=27,enabled=true)
	public void verifyResendVerificationCodeLink() throws Throwable {
		Assert.assertTrue(account.verifyResendVerificationCodeLink(mobileNum_Row10));
	}
	
	@Test(priority=28,enabled=true)
	public void clickOnResendVerificationCodeLink() throws Throwable {
		Assert.assertTrue(account.clickOnResendVerificationCodeLink(mobileNum_Row10));
	}
	
	@Test(priority=29,enabled=true)
	public void verifySubmitBtnWithoutEnterOTP() throws Throwable {
		Assert.assertTrue(account.verifySubmitBtnWithoutEnterOTP(mobileNum_Row10));
	}
	
	@Test(priority=30,enabled=true)
	public void verifySubmitBtnAfterEnterOTP() throws Throwable {
		Assert.assertTrue(account.verifySubmitBtnAfterEnterOTP(mobileNum_Row10,mobileNum_Row11));
	}
	
	@Test(priority=31,enabled=true)
	public void clickOnSubmitWithInvalidOTP() throws Throwable {
		String actualMsg = account.clickOnSubmitWithInvalidOTP(mobileNum_Row10,mobileNum_Row11);
		Assert.assertTrue(actualMsg.contains("Invalid verification code. Please try again"));
		System.out.println(actualMsg);
	}
	
	@Test(priority=32,enabled=true)
	public void verifyClickToVerifyBtn() throws Throwable {
		Assert.assertTrue(account.verifyClickToVerifyBtn());
	}
	
	@Test(priority=33,enabled=true)
	public void clickOnClickToVerifyBtn() throws Throwable {
		Assert.assertTrue(account.clickOnClickToVerifyBtn());
	}
	
	@Test(priority=34,enabled=true)
	public void clickOnForgotPwdLink() throws Throwable {
		Assert.assertTrue(account.clickOnForgotPwdLink());
	}
	
	@Test(priority=35,enabled=true)
	public void verifyAlertMsg_IForgotPwdPopup() throws Throwable {
		String actualMsg = account.verifyAlertMsg_IForgotPwdPopup();
		Assert.assertEquals(actualMsg, "You will be logged out from the application."+"\n"+ 
				"Are you sure you want to continue?");
		System.out.println(actualMsg);
	}
	
	@Test(priority=36,enabled=true)
	public void clickOnCrossSym_IForgotPwdPopup() throws Throwable {
		Assert.assertTrue(account.clickOnCrossSym_IForgotPwdPopup());
	}
	
	@Test(priority=37,enabled=true)
	public void clickOnCancel_IForgotPwdPopup() throws Throwable {
		Assert.assertTrue(account.clickOnCancel_IForgotPwdPopup());
	}
	
	@Test(priority=38,enabled=true)
	public void clickOnConfirm_IForgotPwdPopup() throws Throwable {
		String actualUrl = account.clickOnConfirm_IForgotPwdPopup();
		Assert.assertEquals(actualUrl, url_Row2);
		System.out.println(actualUrl);
	}
	
	@Test(priority=39,enabled=true)
	public void verifyCurrentPwdWithoutPwd() throws Throwable {
		String actualMsg = account.verifyCurrentPwdWithoutPwd();
		Assert.assertEquals(actualMsg, "Password is required");
		System.out.println(actualMsg);
	}
	
	@Test(priority=40,enabled=true)
	public void verifyCurrentPwdEncryption() throws Throwable {
		String actualMsg = account.verifyCurrentPwdEncryption(password_Row3);
		Assert.assertEquals(actualMsg, "password");
		System.out.println(actualMsg);
	}
	
	@Test(priority=41,enabled=true)
	public void verifyCurrentPwdWith7Chars() throws Throwable {
		String actualMsg = account.verifyCurrentPwdWith7Chars(password_Row2);
		Assert.assertEquals(actualMsg, "Password contains minimum of 8 characters");
		System.out.println(actualMsg);
	}
	
	@Test(priority=42,enabled=true)
	public void verifyCurrentPwdEyeIcon() throws Throwable {
		Assert.assertTrue(account.verifyCurrentPwdEyeIcon());
	}
	
	@Test(priority=43,enabled=true)
	public void verifyNewPwdWithoutPwd() throws Throwable {
		String actualMsg = account.verifyNewPwdWithoutPwd();
		Assert.assertEquals(actualMsg, "Password is required");
		System.out.println(actualMsg);
	}
	
	@Test(priority=44,enabled=true)
	public void verifyNewPwdEncryption() throws Throwable {
		String actualMsg = account.verifyNewPwdEncryption(password_Row3);
		Assert.assertEquals(actualMsg, "password");
		System.out.println(actualMsg);
		
	}
	
	@Test(priority=45,enabled=true)
	public void verifyNewPwdWith7Chars() throws Throwable {
		String actualMsg = account.verifyNewPwdWith7Chars(password_Row2);
		Assert.assertEquals(actualMsg, "Use 8 characters or more for your password");
		System.out.println(actualMsg);
	}
	
	@Test(priority=46,enabled=true)
	public void verifyNewPwdMorethan100Chars() throws Throwable {
		String actualMsg = account.verifyNewPwdMorethan100Chars(password_Row5);
		Assert.assertEquals(actualMsg, "Use less than 100 characters for your password");
		System.out.println(actualMsg);
	}
	
	@Test(priority=47,enabled=true)
	public void verifyNewPwdEyeIcon() throws Throwable {
		Assert.assertTrue(account.verifyNewPwdEyeIcon());
	}
	
	@Test(priority=48,enabled=true)
	public void repeatNewPwdWithoutPwd() throws Throwable {
		String actualMsg = account.repeatNewPwdWithoutPwd();
		Assert.assertEquals(actualMsg, "Repeat password is required");
		System.out.println(actualMsg);
	}
	
	@Test(priority=49,enabled=true)
	public void verifyRepeatNewPwdEncryption() throws Throwable {
		String actualMsg = account.verifyRepeatNewPwdEncryption(password_Row3);
		Assert.assertEquals(actualMsg, "password");
		System.out.println(actualMsg);
	}
	
	@Test(priority=50,enabled=true)
	public void verifyRepeatNewPwdEyeIcon() throws Throwable {
		Assert.assertTrue(account.verifyRepeatNewPwdEyeIcon());
	}
	
	@Test(priority=51,enabled=true)
	public void verifyShowEyeIconMousehover() throws Throwable {
		String actualTooltip = account.verifyShowEyeIconMousehover(password_Row3);
		Assert.assertEquals(actualTooltip, "Show");
		System.out.println(actualTooltip);
	}
	
	@Test(priority=52,enabled=true) 
	public void clickOnShowEyeIcon() throws Throwable {
		String actualMsg = account.clickOnShowEyeIcon(password_Row3);
		Assert.assertEquals(actualMsg, "text");
		System.out.println(actualMsg);
	}
	
	@Test(priority=53,enabled=true)
	public void verifyHideEyeIconMousehover() throws Throwable {
		String actualTooltip = account.verifyHideEyeIconMousehover(password_Row3);
		Assert.assertEquals(actualTooltip, "Hide");
		System.out.println(actualTooltip);
	}
	
	@Test(priority=54,enabled=true)
	public void clickOnHideEyeIcon() throws Throwable {
		String actualMsg = account.clickOnHideEyeIcon(password_Row3);
		Assert.assertEquals(actualMsg, "password");
		System.out.println(actualMsg);
	}
	
	@Test(priority=55,enabled=true)
	public void verifySaveBtn_IfUserNotEnterAllPwds() throws Throwable {
		Assert.assertTrue(account.verifySaveBtn_IfUserNotEnterAllPwds());
	}
	
	@Test(priority=56,enabled=true)
	public void verifySavePwd_IfUserEnterAllPwds() throws Throwable {
		Assert.assertTrue(account.verifySavePwd_IfUserEnterAllPwds(password_Row3,password_Row4,password_Row4));
	}
	
	@Test(priority=57,enabled=true)
	public void clickOnSavePwd_WrongCurrentPwd() throws Throwable {
		String actaulValidation = account.clickOnSavePwd_WrongCurrentPwd(password_Row3,password_Row4,password_Row4);
		Assert.assertEquals(actaulValidation, "Entered old password is wrong");
		System.out.println(actaulValidation);
	}
	
	@Test(priority=58,enabled=true)
	public void clickOnSavePwd_WrongRepeatNewPwd() throws Throwable {
		String actaulValidation = account.clickOnSavePwd_WrongRepeatNewPwd(password_Row3,password_Row4,password_Row2);
		Assert.assertEquals(actaulValidation, "Those passwords don't match. Try again");
		System.out.println(actaulValidation);
	}
	
	@Test(priority=59,enabled=true)
	public void clickOnSavePwdWithAllValidPwds() throws Throwable {
		String actaulUrl = account.clickOnSavePwdWithAllValidPwds(password_Row4,password_Row4,password_Row4);
		Assert.assertEquals(actaulUrl,url_Row3 );
		System.out.println(actaulUrl);
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
