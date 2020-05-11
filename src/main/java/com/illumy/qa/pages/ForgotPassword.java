/**
 * 
 */
package com.illumy.qa.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 *The forgot password class will automate the complete flow of forgot password 
 */
public class ForgotPassword extends TestBase{

	Scanner sc;
	String ValidMissingNum1		= "3";
	String ValidMissingNum2		= "5";
	String validPassword		= "12345678";
	String password				= prop.getProperty("password2");
	
	
	public void threadSleep() throws Throwable {
		Thread.sleep(50000);
	}
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	//Page Factory : OR 
	@FindBy(xpath="//a[contains(text(),'Forgot password?')]")
	WebElement forgotPwdLink;
	
	@FindBy(xpath="//div[@class='login-box-body login-popup']//p[@class='login-box-msg']")
	WebElement recoverPwdText;
	
	@FindBy(xpath="//div[@class='group']//input[@name='email']//following-sibling::label[@class='placeholder']")
	WebElement emailPlaceholder;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailField;
	
	@FindBy(xpath="//div[@class='col-sm-8 mart_t11']")
	WebElement alreadyHaveAccountText;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signinLink;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-md btn-flat']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='group']//input[@name='email']//following-sibling::div[@class='text-danger ng-star-inserted']")
	WebElement emailFieldValidationMsg;
	
	@FindBy(xpath="//div[@class='group']//input[@name='email']//following-sibling::div[@class='text-danger ng-star-inserted']")
	WebElement weDontRecognizeEmail;
	
	@FindBy(xpath="//div[@class='login-box-body login-popup ng-star-inserted']//p[@class='login-box-msg']")
	WebElement welcome_Text;
	
	@FindBy(xpath="//span[contains(text(),'For security purposes, please verify the missing digits')]")
	WebElement plsVerifyMissingDigits_Alt;
	
	@FindBy(xpath="//div[@class='group']//following-sibling::div[@class='text-center text-danger ng-star-inserted']")
	WebElement missingMobNumsReq;
	
	@FindBy(xpath="//div[@class='group']//following-sibling::div[@class='text-center text-danger ng-star-inserted']")
	WebElement missingNumsAreIncorrect;
	
	@FindBy(xpath="//*[@class='group phone_no']//*[@name='missingMobileNoposition1']")
	WebElement missignMobileNo1;
	
	@FindBy(xpath="//input[@name='missingMobileNoposition2']")
	WebElement missignMobileNo2;
	
	@FindBy(xpath="//p[text()='Password Reset']")
	WebElement pwdResetText;
	
	@FindBy(xpath="//*[@class='login-box-body login-popup']//p[2]")
	WebElement PwdResetVerifyMsg;
	
	@FindBy(xpath="//div[@class='group']//input[@type='text']//following-sibling::label[@class='placeholder']")
	WebElement pwdResetCodePlaceholder;
	
	@FindBy(xpath="//div[@class='group']//input[@type='text']//following-sibling::span[@class='illumy_txt btn']")
	WebElement resendLink;
	
	@FindBy(xpath="//*[text()='Mobile account key has sent again']")
	WebElement mobileAccountKeySentAgain;
	
	@FindBy(xpath="//div[@class='group']//input[@type='text']//following-sibling::div[@class='font_w_5 font12 pad_l2 ng-star-inserted']")
	WebElement allowOnlyNumericValues;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']//following-sibling::label[@class='placeholder']")
	WebElement chooseNewPwdPlaceholder;
	
	@FindBy(xpath="//div[@class='group']//input[@name='repeatPassword']//following-sibling::label[@class='placeholder']")
	WebElement confirmNewPwdPlaceholder;
	
	@FindBy(xpath="//div[@class='group']//input[@name='repeatPassword']//following-sibling::span[@class='illumy_txt btn ng-star-inserted']//img")
	WebElement confirmNewPwdEyeIcon;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']//following-sibling::span[@class='illumy_txt btn ng-star-inserted']//img")
	WebElement chooseNewPwdEyeIcon;
	
	@FindBy(xpath="//div[@class='group']//input[@id='otpCode']")
	WebElement pwdResetCodeField;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']")
	WebElement chooseNewPwdField;
	
	@FindBy(xpath="//input[@name='repeatPassword']")
	WebElement confirmNewPwdField;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-md btn-flat']")
	WebElement changeMyPwdBtn;
	
	@FindBy(xpath="//*[text()=' Verification code is required.']")
	WebElement verificationCodeReq;
	
	@FindBy(xpath="//div[text()=' Sorry, verification code should be 6 digits']")
	WebElement codeShouldBe6Digits;
	
	@FindBy(xpath="//*[text()='Password is required']")
	WebElement pwdIsRequired;
	
	@FindBy(xpath="//div[text()=' Invalid verification code. Please try again']")
	WebElement invalidVerificationCode;
	
	@FindBy(xpath="//*[text()='Confirm new password is required']")
	WebElement confirmPwdIsRequired;
	
	@FindBy(xpath="//*[text()='Use 8 characters or more for your password']")
	WebElement use8CharsPwd;
	
	@FindBy(xpath="//div[@class='group']//input[@name='repeatPassword']//following-sibling::p[@class='text-danger ng-star-inserted']")
	WebElement thosePwdsNotMatched;
	
	@FindBy(xpath="//*[@class='text-center h2 text-primary']")
	WebElement homepage_welcome_to_illumy;

	@FindBy(xpath="//*[text()=' Attempt limit exceeded, please try after some time. ']")
	WebElement attemptLimitsExceeds;
	
	@FindBy(xpath="//*[@class='text-center']//*[contains(@class,'lett')]")
	WebElement mobileNumFormat;
	
	@FindBy(xpath="//*[text()='Captcha is required']")
	WebElement captchaRequired;
	
	//Initializing the Page Objects :
	public ForgotPassword() {
		PageFactory.initElements(driver, this);
	}
	
	
	//ACTIONS :
	
	//Verifying the forgot password link in the sign in page 
	public boolean verify_ForgotPwdLink() {
		return forgotPwdLink.isDisplayed();
	}
	
	//Verify the forgot password link click functionality 
	public String verify_ForgotPwdClickAction() throws Throwable {
		forgotPwdLink.click();
		thread();
		return recoverPwdText.getText();
	}
	
	//Verify the sign in link in the recover password screen 
	public boolean verify_SignInLink() throws Throwable {
		forgotPwdLink.click();
		thread();
		return signinLink.isDisplayed();
	}
	
	//Verify the click functionality of the sign in link in the recover password screen
	public String verify_SignInLinkClickAction() throws Throwable {
		forgotPwdLink.click();
		thread();
		signinLink.isDisplayed();
		signinLink.click();
		thread();
		return driver.getCurrentUrl();
	}
	
	//Verify the email field in the recover password screen without email id
	public String submit_WithoutEmailId() throws Throwable {
		forgotPwdLink.click();
		thread();
		submitButton.click();
		thread();
		return emailFieldValidationMsg.getText();
	}
	
	//Verifying the email field by entering the invalid email id 
	public String submit_WithInvalidEmailId() throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys("test123@qa.illumy1.co");
		thread();
		submitButton.click();
		thread();
		return emailFieldValidationMsg.getText();
	}
	
	//Verify the email field by entering unregistered email id 
	public String submit_UnregisteredEmailId(String email) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(email);
		thread();
		threadSleep();
		submitButton.click();
		thread();
		return emailFieldValidationMsg.getText();
	}
	
	//Verify the email field by entering only numbers 
	public String submit_OnlyNumbers() throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys("123456789");
		thread();
		submitButton.click();
		thread();
		return emailFieldValidationMsg.getText();
	}
	
	//Verify the email field by entering only special characters
	public String submit_SpecialChars() throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys("!@#%$&%^&%&*%$^()%%#@");
		thread();
		submitButton.click();
		thread();
		return emailFieldValidationMsg.getText();
	}
	
	//Verify the email field by entering combination of alphabets,numbers and special characters
	public String submit_AlphabetsNumSplChars() throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys("abc12345!$#$^#$^$^&%^*(");
		thread();
		submitButton.click();
		thread();
		return emailFieldValidationMsg.getText();
	}
	
	//Verify the captcha in recovery password view 
	public String verifyCaptcha(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		
		return captchaRequired.getText();
	}
	
	//Verify the email field by entering the valid email id 
	public String submit_ValidEmailId(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		threadSleep();
		submitButton.click();
		thread();
		return plsVerifyMissingDigits_Alt.getText();
	}
	
	//Verifying the  mobile number format in recovery password section
	public String verifyMobileNumFormat(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		threadSleep();
		submitButton.click();
		thread();
		return mobileNumFormat.getText();
	}
	
	//Verify submit button without entering any missing digits 
	public String submit_WithoutMissingDigits(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		submitButton.click();
		thread();
		return missingMobNumsReq.getText();
	}
	
	//Verify submit button by entering invalid missing digits
	public String submit_InvalidMissingDigits(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys("1");
		thread();
		missignMobileNo2.sendKeys("2");
		thread();
		submitButton.click();
		return missingNumsAreIncorrect.getText();
	}
	
	//Verify submit button by entering valid missing digits
	public String submit_ValidMissingDigits(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		return pwdResetText.getText();
	}
	
	//Verify sign-in link in the mobile number format screen of forgot password
	public String verifySigninLinkInMobileNumView(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		threadSleep();
		submitButton.click();
		thread();
		signinLink.click();
		thread();
		
		return driver.getCurrentUrl();
	}
	
	//Click on change my password without any password reset code and passwords
	public String[] changeMyPwd_WithoutAnyData(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();

		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		submitButton.click();
		thread();
		changeMyPwdBtn.click();
		thread();
		String[] dataArray = new String[]{
				verificationCodeReq.getText(),
				pwdIsRequired.getText(),
				confirmPwdIsRequired.getText()
				
		};
		return dataArray;
	}
	
	//Click on change my password with less than 6 digits
	public String[] changeMyPwd_5Digits(String validEmail) throws InterruptedException {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		pwdResetCodeField.sendKeys("12345");
		thread();
		changeMyPwdBtn.click();
		String[] dataArray = new String[]{
				codeShouldBe6Digits.getText(),
				pwdIsRequired.getText(),
				confirmPwdIsRequired.getText()
				
		};
		return dataArray;
		
	}
	
	//Click on change my password with greater than 6 digits
	public String[] changeMyPwd_7Digits(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		pwdResetCodeField.sendKeys("1234567");
		thread();
		changeMyPwdBtn.click();
		
		String[] dataArray = new String[]{
				
				pwdIsRequired.getText(),
				confirmPwdIsRequired.getText()
				
		};
		return dataArray;
		
	}
	
	//Click on change my password with invalid password reset code
	public String changeMyPwd_InvalidPasswordResetCode(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		pwdResetCodeField.sendKeys("123456");
		thread();
		chooseNewPwdField.sendKeys(password);
		thread();
		confirmNewPwdField.sendKeys(password);
		thread();
		changeMyPwdBtn.click();
		
		return invalidVerificationCode.getText();
		
		
	}
	
	//Click on change my password only with valid password reset code
	public String changeMyPwd_OnlyWithValidPwdResetCode(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid password reset code");
		String valideResetCode=Integer.toString(sc.nextInt());
		pwdResetCodeField.sendKeys(valideResetCode);
		thread();
		changeMyPwdBtn.click();
		
		changeMyPwdBtn.click();
		
		 return pwdIsRequired.getText();
	}
	
	//Click on change my password only with passwords without any password reset code
	public String changeMyPwd_OnlyWithPwds_NoPwdResetCode(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		chooseNewPwdField.sendKeys(password);
		thread();
		confirmNewPwdField.sendKeys(password);
		thread();
		changeMyPwdBtn.click();
		
		changeMyPwdBtn.click();
		
		
		return verificationCodeReq.getText();
		
	}
	
	//Click on the 'CHANGE MY PASSWORD' button with valid verification code and  valid password in Choose a New Password field
	public String changeMyPwd_WithOutConfirmNewPwd(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid password reset code");
		String valideResetCode=Integer.toString(sc.nextInt());
		pwdResetCodeField.sendKeys(valideResetCode);
		thread();
		chooseNewPwdField.sendKeys(password);
		thread();
		changeMyPwdBtn.click();
		
		changeMyPwdBtn.click();
		return confirmPwdIsRequired.getText();
	}
	
	/*
	 * Click on the 'CHANGE MY PASSWORD' button with valid verification code and 
	 * enter any 7 characters of  password  in Choose a New Password field
	 */
	public String changeMyPwd_ValidResetCode_7DigitsNewPwd(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid password reset code");
		String valideResetCode=Integer.toString(sc.nextInt());
		pwdResetCodeField.sendKeys(valideResetCode);
		thread();
		chooseNewPwdField.sendKeys("1234567");
		thread();
		changeMyPwdBtn.click();
		
		changeMyPwdBtn.click();
		return use8CharsPwd.getText();
	}

	/* Click on the 'CHANGE MY PASSWORD' button with valid verification code and 
	 * enter more than 8 characters of  password  in Choose a New Password field
	 */
	public String changeMyPwd_MoreThan8DigitsNewPwd(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid password reset code");
		String valideResetCode=Integer.toString(sc.nextInt());
		pwdResetCodeField.sendKeys(valideResetCode);
		thread();
		chooseNewPwdField.sendKeys("12345678910");
		thread();
		changeMyPwdBtn.click();
		
		changeMyPwdBtn.click();
		return confirmPwdIsRequired.getText();
	}
	
	/*Click on the 'CHANGE MY PASSWORD' button with valid verification code, enter 8 characters of  password  in Choose 
	 * a New Password field and enter invalid password with more than 8 characters in Confirm New Password field
	 */
	public String changeMyPwd_MoreThan8DigitsConfirmNewPwd(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid password reset code");
		String valideResetCode=Integer.toString(sc.nextInt());
		pwdResetCodeField.sendKeys(valideResetCode);
		thread();
		chooseNewPwdField.sendKeys(password);
		thread();
		confirmNewPwdField.sendKeys("123456789");
		thread();
		changeMyPwdBtn.click();
		
		changeMyPwdBtn.click();
		
		return thosePwdsNotMatched.getText();
	}
	
	//Verify the functionality of eye icon image in Choose a New Password field
	public String verify_EyeIcon_NewPwd(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		chooseNewPwdField.sendKeys(password);
		thread();
		chooseNewPwdEyeIcon.click();
		thread();
		if(chooseNewPwdField.getText().contains(password)) {
			return validPassword;
		}
		return validPassword;	
	}
	
	//Verify the functionality of eye icon image in Confirm New Password field
	public String verify_EyeIcon_ConfirmNewPwd(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		confirmNewPwdField.sendKeys(password);
		thread();
		confirmNewPwdEyeIcon.click();
		thread();
		if(confirmNewPwdField.getText().contains(password)) {
			return validPassword;
		}
		return validPassword;	
	}
	
	//Verify the resend link click functionality in the password reset code field
	public String verify_ResendLinkFunctionality(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		resendLink.click();
		thread();
		
		return mobileAccountKeySentAgain.getText();
	}
	
	/* Click on the 'CHANGE MY PASSWORD' button with valid verification code, enter 8 characters 
	 * of valid password in both Choose a New Password and Confirm New Password  field
	 */
	public String changeMyPwd_WithValidInputs(String validEmail) throws Throwable {
		forgotPwdLink.click();
		thread();
		emailField.sendKeys(validEmail);
		thread();
		threadSleep();
		submitButton.click();
		thread();
		missignMobileNo1.sendKeys(ValidMissingNum1);
		thread();
		missignMobileNo2.sendKeys(ValidMissingNum2);
		thread();
		submitButton.click();
		thread();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid password reset code");
		String valideResetCode=Integer.toString(sc.nextInt());
		pwdResetCodeField.sendKeys(valideResetCode);
		thread();
		chooseNewPwdField.sendKeys(password);
		thread();
		confirmNewPwdField.sendKeys(password);
		thread();
		changeMyPwdBtn.click();
		changeMyPwdBtn.click();
		thread();
		return driver.getCurrentUrl();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}