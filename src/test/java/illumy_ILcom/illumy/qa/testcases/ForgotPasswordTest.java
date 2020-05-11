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
import com.illumy.qa.pages.ForgotPassword;

/**
 * @author thambibabu.dasari
 *
 */
public class ForgotPasswordTest extends TestBase{

	public static ForgotPassword forgotPwd;
	
	
	public ForgotPasswordTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) {
		initialization();
		forgotPwd=new ForgotPassword();
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	//Verifying the forgot password link in the sign in page 
	@Test(priority=1,enabled=true)
	public void verify_ForgotPwdLinkTest() {
		Assert.assertTrue(forgotPwd.verify_ForgotPwdLink());
	}
	
	//Verify the forgot password link click functionality 
	@Test(priority=2,enabled=true)
	public void verify_ForgotPwdClickActionTest() throws Throwable {
		String recoveryPwd=forgotPwd.verify_ForgotPwdClickAction();
		Assert.assertEquals(recoveryPwd, "Recover Password");
		System.out.println(recoveryPwd);
	}
	
	//Verify the sign in link in the recover password screen 
	@Test(priority=3,enabled=true)
	public void verify_SignInLinkTest() throws Throwable {
		Assert.assertTrue(forgotPwd.verify_SignInLink());
	}
	
	//Verify the click functionality of the sign in link in the recover password screen
	@Test(priority=4,enabled=true)
	public void verify_SignInLinkClickActionTest() throws Throwable {
		String signInPage=forgotPwd.verify_SignInLinkClickAction();
		Assert.assertEquals(signInPage, "https://qa.illumy1.com/signin");
	}
	
	//Verify the email field in the recover password screen without email id
	@Test(priority=5,enabled=true)
	public void submit_WithoutEmailIdTest() throws Throwable {
		String emailReq=forgotPwd.submit_WithoutEmailId();
		Assert.assertEquals(emailReq, "Email is required");
	}
	
	//Verifying the email field by entering the invalid email id 
	@Test(priority=6,enabled=true)
	public void submit_WithInvalidEmailId() throws Throwable {
		String invalidEmail=forgotPwd.submit_WithInvalidEmailId();
		Assert.assertEquals(invalidEmail, "Enter a valid email address.");
		System.out.println(invalidEmail);
	}
	
	//Verify the email field by entering unregistered email id 
	@Test(priority=7,enabled=true)
	public void submit_UnregisteredEmailIdTest() throws Throwable {
		String weDontRecognizeEmail=forgotPwd.submit_UnregisteredEmailId();
		Assert.assertEquals(weDontRecognizeEmail, "We do not recognize this email. Try again");
		System.out.println(weDontRecognizeEmail);
	}
	
	//Verify the email field by entering only numbers 
	@Test(priority=8,enabled=true)
	public void submit_OnlyNumbersTest() throws Throwable {
		String weDontRecognizeEmail=forgotPwd.submit_OnlyNumbers();
		Assert.assertEquals(weDontRecognizeEmail, "Enter a valid email address.");
		System.out.println(weDontRecognizeEmail);
	}
	
	//Verify the email field by entering only special characters
	@Test(priority=9,enabled=true)
	public void submit_SpecialCharsTest() throws Throwable {
		String enterValidEmail=forgotPwd.submit_SpecialChars();
		Assert.assertEquals(enterValidEmail, "Enter a valid email address.");
	}
	
	//Verify the email field by entering combination of alphabets,numbers and special characters
	@Test(priority=10,enabled=true)
	public void submit_AlphabetsNumSplCharsTest() throws Throwable {
		String enterValidEmail=forgotPwd.submit_AlphabetsNumSplChars();
		Assert.assertEquals(enterValidEmail, "Enter a valid email address.");
	}
	
	//Verify the email field by entering the valid email id 
	@Test(priority=11,enabled=true)
	public void submit_ValidEmailId() throws Throwable {
		String verifyMissingDigits=forgotPwd.submit_ValidEmailId(prop.getProperty("illumy_Email2"));
		Assert.assertEquals(verifyMissingDigits, "For security purposes, please verify the missing digits");
	}
	
	//Verify submit button without entering any missing digits 
	@Test(priority=12,enabled=true)
	public void submit_WithoutMissingDigitsTest() throws Throwable {
		String missingMobileNumsReq=forgotPwd.submit_WithoutMissingDigits(prop.getProperty("illumy_Email2"));
		Assert.assertEquals(missingMobileNumsReq, "Missing mobile numbers are required");
	}
	
	//Verify submit button by entering invalid missing digits
	@Test(priority=13,enabled=true)
	public void submit_InvalidMissingDigitsTest() throws Throwable {
		String missingNumsAreIncorrect=forgotPwd.submit_InvalidMissingDigits(prop.getProperty("illumy_Email2"));
		Assert.assertEquals(missingNumsAreIncorrect, "The entered missing numbers are incorrect, please check and try again");
	}
	
	//Verify submit button by entering valid missing digits
	@Test(priority=14,enabled=true)
	public void submit_ValidMissingDigitsTest() throws Throwable {
		String pwdReset=forgotPwd.submit_ValidMissingDigits(prop.getProperty("illumy_Email2"));
		Assert.assertEquals(pwdReset, "Password Reset");
	}
	
	//Click on change my password without any password reset code and passwords
	@Test(priority=15,enabled=true)
	public void changeMyPwd_WithoutAnyDataTest() throws Throwable {
		String[] dataValuesArray = new String[] {
				"Verification code is required.",
				"Password is required",
				"Confirm new password is required"
		};
		String[] verificaficationCodeReq=forgotPwd.changeMyPwd_WithoutAnyData(prop.getProperty("illumy_Email2"));
		for(int i = 0;i<verificaficationCodeReq.length;i++) {
			Assert.assertEquals(verificaficationCodeReq[i], dataValuesArray[i]);	
		}
	}
	
	//Click on change my password with less than 6 digits
	@Test(priority=16,enabled=true)
	public void changeMyPwd_5DigitsTest() throws InterruptedException {
		String[] dataValuesArray=new String[] {
				"Sorry, verification code should be 6 digits",
				"Password is required",
				"Confirm new password is required"
		};
			String[] codeShouldBe6Digits=forgotPwd.changeMyPwd_5Digits(prop.getProperty("illumy_Email5"));
			for(int i = 0;i<codeShouldBe6Digits.length;i++) {
				Assert.assertEquals(codeShouldBe6Digits[i], dataValuesArray[i]);
			}
		
	}
	
	//Click on change my password with greater than 6 digits
	@Test(priority=17,enabled=true)
	public void changeMyPwd_7DigitsTest() throws Throwable {
		String[] dataValuesArray=new String[] {
				
				"Password is required",
				"Confirm new password is required"
		};
			String[] codeShouldBe6Digits=forgotPwd.changeMyPwd_7Digits(prop.getProperty("illumy_Email5"));
			for(int i = 0;i<codeShouldBe6Digits.length;i++) {
				Assert.assertEquals(codeShouldBe6Digits[i], dataValuesArray[i]);
				System.out.println(codeShouldBe6Digits[i]);
			}
			
			
	}
	
	//Click on change my password with invalid password reset code
	@Test(priority=18,enabled=true)
	public void changeMyPwd_InvalidPasswordResetCodeTest() throws Throwable {
		
		String invalidCode=forgotPwd.changeMyPwd_InvalidPasswordResetCode(prop.getProperty("illumy_Email1"));
		
			Assert.assertEquals(invalidCode, "Invalid verification code. Please try again");
		
		
		System.out.println(invalidCode);
	}
	
	//Click on change my password only with valid password reset code
	@Test(priority=19,enabled=true)
	public void changeMyPwd_OnlyWithValidPwdResetCodeTest() throws Throwable {
		String PwdReq=forgotPwd.changeMyPwd_OnlyWithValidPwdResetCode(prop.getProperty("illumy_Email1"));
		Assert.assertEquals(PwdReq, "Password is required");
		System.out.println(PwdReq);
	}
	
	//Click on change my password only with passwords without any password reset code
	@Test(priority=20,enabled=true)
	public void changeMyPwd_OnlyWithPwds_NoPwdResetCode() throws Throwable {
		String verificationCodeReq=forgotPwd.changeMyPwd_OnlyWithPwds_NoPwdResetCode(prop.getProperty("illumy_Email1"));
		Assert.assertEquals(verificationCodeReq, "Verification code is required.");
	}
	
	//Click on the 'CHANGE MY PASSWORD' button with valid verification code and  valid password in Choose a New Password field
	@Test(priority=21,enabled=true)
	public void changeMyPwd_WithoutConfirmNewPwdTest() throws Throwable {
		String confirmPwdReq=forgotPwd.changeMyPwd_WithOutConfirmNewPwd(prop.getProperty("illumy_Email3"));
		Assert.assertEquals(confirmPwdReq, "Confirm new password is required");
	}
	
	/*
	 * Click on the 'CHANGE MY PASSWORD' button with valid verification code and 
	 * enter any 7 characters of  password  in Choose a New Password field
	 */
	@Test(priority=22,enabled=true)
	public void changeMyPwd_ValidResetCode_7DigitsNewPwd() throws Throwable {
		String use8CharsPwd=forgotPwd.changeMyPwd_ValidResetCode_7DigitsNewPwd(prop.getProperty("illumy_Email3"));
		Assert.assertEquals(use8CharsPwd, "Use 8 characters or more for your password");
	}
	

	/* Click on the 'CHANGE MY PASSWORD' button with valid verification code and 
	 * enter more than 8 characters of  password  in Choose a New Password field
	 */
	@Test(priority=23,enabled=true)
	public void changeMyPwd_MoreThan8DigitsNewPwd() throws Throwable {
		String confirmPwdReq=forgotPwd.changeMyPwd_MoreThan8DigitsNewPwd(prop.getProperty("illumy_Email3"));
		Assert.assertEquals(confirmPwdReq, "Confirm new password is required");
	}
	
	/*Click on the 'CHANGE MY PASSWORD' button with valid verification code, enter 8 characters of  password  in Choose 
	 * a New Password field and enter invalid password with more than 8 characters in Confirm New Password field
	 */
	@Test(priority=24,enabled=true)
	public void changeMyPwd_MoreThan8DigitsConfirmNewPwd() throws Throwable {
		String pwdDontMatch=forgotPwd.changeMyPwd_MoreThan8DigitsConfirmNewPwd(prop.getProperty("illumy_Email3"));
		Assert.assertEquals(pwdDontMatch, "Those passwords don't match. Try again");
	}
	
	//Verify the functionality of eye icon image in Choose a New Password field
	@Test(priority=25,enabled=true)
	public void verify_EyeIcon_NewPwdTest() throws Throwable {
		String newPwdEyeIcon=forgotPwd.verify_EyeIcon_NewPwd(prop.getProperty("illumy_Email3"));
		Assert.assertEquals(newPwdEyeIcon, "12345678");
		System.out.println(newPwdEyeIcon);
	}
	
	//Verify the functionality of eye icon image in Confirm New Password field
	@Test(priority=26,enabled=true)
	public void verify_EyeIcon_ConfirmNewPwdTest() throws Throwable {
		String confirmNewPwdEyeIcon=forgotPwd.verify_EyeIcon_ConfirmNewPwd(prop.getProperty("illumy_Email4"));
		Assert.assertEquals(confirmNewPwdEyeIcon, "12345678");
	}
	
	//Verify the resend link click functionality in the password reset code field
	@Test(priority=27,enabled=true)
	public void verify_ResendLinkFunctionalityTest() throws Throwable {
		String mobileAccountKeySentAgain=forgotPwd.verify_ResendLinkFunctionality(prop.getProperty("illumy_Email4"));
		Assert.assertEquals(mobileAccountKeySentAgain, "Mobile account key has sent again");
	}
	

	/* Click on the 'CHANGE MY PASSWORD' button with valid verification code, enter 8 characters 
	 * of valid password in both Choose a New Password and Confirm New Password  field
	 */
	@Test(priority=28,enabled=true)
	public void changeMyPwd_WithValidInputsTest() throws Throwable {
		String welcomeToillumy=forgotPwd.changeMyPwd_WithValidInputs(prop.getProperty("illumy_Email4"));
		Assert.assertEquals(welcomeToillumy, "Welcome to illumy");
		System.out.println(welcomeToillumy);
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
