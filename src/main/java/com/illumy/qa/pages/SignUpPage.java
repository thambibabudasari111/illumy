/**
 * 
 */
package com.illumy.qa.pages;

import java.util.Scanner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */

public class SignUpPage extends TestBase {

	String email = randomEmail(2);
	TestUtil testUtil;
	String firstName = "firstName";
	String lastName = "lastName";
	String userName = "userName";
	String password = "password";
	String confirmPwd = "confirmPwd";
	String mobileNum = "mobileNumber";

	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	// Page Factory : OR

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement illumy_image;

	@FindBy(xpath = "//div[@class='register-box-body login-popup ng-star-inserted']//p[@class='login-box-msg']")
	WebElement create_your_illumy_account;

	@FindBy(xpath = "//span[text()='@stage.illumy1.com']")
	WebElement illumy_Text;

	@FindBy(xpath = "//*[text()=' You can use letters, numbers, periods, hyphens & underscores ']")
	WebElement userNameHelpText;

	@FindBy(xpath = "//*[contains(@src,'eye_icon_h.png')]")
	WebElement eyeIcon;

	@FindBy(xpath = "//*[text()='Verify Your Phone Number ']")
	WebElement verifyYourPhoneNum;

	@FindBy(xpath = "//*[contains(text(),' Terms Of Service ')]")
	WebElement termsOfServicePopup;

	// Place holders and text messages xpaths:

	@FindBy(xpath = "//*[@class='mat-form-field-label-wrapper']//*[text()='First name']	")
	WebElement firstNamePlaceholder;

	@FindBy(xpath = "//*[@class='mat-form-field-label-wrapper']//*[text()='Last name']")
	WebElement lastNamePlaceholder;

	@FindBy(xpath = "//*[@class='mat-form-field-label-wrapper']//*[text()='Choose a username']")
	WebElement chooseUsernamePlaceholder;

	@FindBy(xpath = "//*[@class='mat-form-field-label-wrapper']//*[text()='Password']")
	WebElement pwdPlaceholder;

	@FindBy(xpath = "//*[@class='mat-form-field-label-wrapper']//*[text()='Confirm password']")
	WebElement confirmPwdPlaceholder;

	@FindBy(xpath = "//*[@class='mat-form-field-label-wrapper']//*[text()='Mobile number']")
	WebElement mobileNumPlaceholder;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[contains(@class,'recovery_e_txt')]")
	WebElement recoveryTextMessage;

	// Links,Buttons and Images xpaths:

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signup_link;

	@FindBy(xpath = "//*[text()='Learn more']")
	WebElement learnmoreLink;

	@FindBy(xpath = "//*[text()=' Why do we ask for your mobile number? ']")
	WebElement learnmoreLinkPopupTitle;

	@FindBy(xpath = "//*[@aria-label='Close dialog']//i")
	WebElement learnmoreLinkPopupClose;

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signinLink;

	@FindBy(xpath = "//*[text()='Sign up free ']")
	WebElement signUpFreeBtn;

	@FindBy(xpath = "//*[contains(@src,'India.png')]")
	WebElement indiaFlag;

	@FindBy(xpath = "//*[@role='listbox']")
	WebElement flagsSection;

	@FindBy(xpath = "//*[contains(@src,'mobile_otp.jpg')]")
	WebElement mobileOtpImage;

	@FindBy(xpath = "//*[text()=' Edit Number ']")
	WebElement editNumberBtn;

	@FindBy(xpath = "//*[text()='Resend verification code']")
	WebElement resendVerificationCodeLink;

	@FindBy(xpath = "//*[text()='Terms of Service']")
	WebElement termsOfServiceLink;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement verifyBtn;

	@FindBy(xpath = "//*[@type='submit' and text()='Send ']")
	WebElement sendBtn;

	// Text fields xpaths:

	@FindBy(xpath = "//*[@formcontrolname='firstName']")
	WebElement firstNameField;

	@FindBy(xpath = "//*[@formcontrolname='lastName']")
	WebElement lastNameField;

	@FindBy(xpath = "//*[@formcontrolname='emailId']")
	WebElement userNameField;

	@FindBy(xpath = "//*[@formcontrolname='password']")
	WebElement passwordField;

	@FindBy(xpath = "//*[@formcontrolname='confirmPassword']")
	WebElement confirmPwdField;

	@FindBy(xpath = "//*[@formcontrolname='mobile']")
	WebElement mobileNumField;

	@FindBy(xpath = "//*[@formcontrolname='otpCode1']")
	WebElement otpCode1;

	@FindBy(xpath = "//*[@formcontrolname='otpCode2']")
	WebElement otpCode2;

	@FindBy(xpath = "//*[@formcontrolname='otpCode3']")
	WebElement otpCode3;

	@FindBy(xpath = "//*[@formcontrolname='otpCode4']")
	WebElement otpCode4;

	@FindBy(xpath = "//*[@formcontrolname='otpCode5']")
	WebElement otpCode5;

	@FindBy(xpath = "//*[@formcontrolname='otpCode6']")
	WebElement otpCode6;

	// Validations xpaths:

	@FindBy(xpath = "//*[text()='Enter a first name']")
	WebElement enterFirstName;

	@FindBy(xpath = "//*[text()='Enter a last name']")
	WebElement enterLastName;

	@FindBy(xpath = "//*[text()='Username is required']")
	WebElement userNameIsRequired;

	@FindBy(xpath = "//*[text()='Password is required']")
	WebElement pwdIsRequired;

	@FindBy(xpath = "//*[text()='Enter a mobile number']")
	WebElement enterMobileNum;

	@FindBy(xpath = "//*[text()='Sorry, your username must be between 4 and 30 characters long.']")
	WebElement userName_4and30Chars;

	@FindBy(xpath = "//*[text()='Use 8 characters or more for your password']")
	WebElement use8orMoreForPwd;

	@FindBy(xpath = "//span[contains(text(),'Those passwords')]")
	WebElement thosePwdsDontMatch;

	@FindBy(xpath = "//*[text()='Only letters, numbers, periods, hyphens and underscores are acceptable']")
	WebElement onlyAcceptLtrsPeriods_UserName;

	@FindBy(xpath = "//*[text()='Maximum of 25 characters']")
	WebElement max25Chars;

	@FindBy(xpath = "//*[text()='Enter a valid first name']")
	WebElement enterValidFirstName;

	@FindBy(xpath = "//*[text()='Enter a valid last name']")
	WebElement enterValidLastName;

	@FindBy(xpath = "//*[text()='Enter valid password']")
	WebElement enterValidPassword;

	@FindBy(xpath = "//*[text()='Use less than 100 characters for your password']")
	WebElement useLessthan100Chars;

	@FindBy(xpath = "//*[text()='Mobile number should be only in digits']")
	WebElement mobileNumOnlyDigits;

	@FindBy(xpath = "//*[text()='Enter a valid mobile number']")
	WebElement enterValidMobileNum;

	@FindBy(xpath = "//*[text()='Captcha is required']")
	WebElement captchaIsRequired;

	@FindBy(xpath = "//*[text()='That username is taken, please try another.']")
	WebElement userNameAlreadyTaken;

	@FindBy(xpath = "//*[text()=' Invalid Verification Code ']")
	WebElement invalidVerificationCode;

	@FindBy(xpath = "//*[contains(@class,'resend_succ_icon')]")
	WebElement resendCodeConfirmation;

	@FindBy(xpath = "//*[text()='Please re-enter your mobile number']")
	WebElement reenterYourMobileNum;

	@FindBy(xpath = "//*[contains(text(),'Welcome to illumy ')]")
	WebElement welcomeToillumy;

	// Initializing the Page Objects:
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String signUpPageTitleValidation() {
		return driver.getTitle();
	}

	public String signUpLinkVerification() {
		return signup_link.getText();
	}

	public String signUpClickAction() {
		signup_link.click();
		return driver.getCurrentUrl();
	}

	public String signUpText() {
		signup_link.click();
		return create_your_illumy_account.getText();
	}

	public String illumy_DomainValidation() {
		signup_link.click();
		return illumy_Text.getText();
	}

	public boolean verifySignUp_Placeholders() {
		signup_link.click();

		firstNamePlaceholder.isDisplayed();
		lastNamePlaceholder.isDisplayed();
		chooseUsernamePlaceholder.isDisplayed();
		pwdPlaceholder.isDisplayed();
		confirmPwdPlaceholder.isDisplayed();
		mobileNumPlaceholder.isDisplayed();

		return true;
	}

	// Verify the learn more link in the sign up page
	public String verifyLearnMoreLink() throws Throwable {
		signup_link.click();
		thread();
		learnmoreLink.click();
		String learnMoreLinkPopup = learnmoreLinkPopupTitle.getText();

		learnmoreLinkPopupClose.click();
		return learnMoreLinkPopup;
	}

	// Verify the sign in link in sign up page
	public String verifySigninLink_SignupPage() {
		signup_link.click();
		signinLink.click();
		return driver.getCurrentUrl();
	}

	// Verify the sign up free button without entering any fields
	public String[] verifySignUpFreeBtn_WithoutAnyFields() {
		signup_link.click();
		signUpFreeBtn.click();

		String[] validations = new String[] { enterFirstName.getText(), enterLastName.getText(),
				userNameIsRequired.getText(), pwdIsRequired.getText(), enterMobileNum.getText() };

		return validations;
	}

	/****************************************************************************************
	 * 									FIRST NAME FIELD
	 ****************************************************************************************/

	// Verify moreThan 25 characters in first name field
	public String[] verifyFirstName_MoreThan25Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 2));
		thread();
		signUpFreeBtn.click();
		String[] validations = new String[] {
				max25Chars.getText(), enterLastName.getText(),
				userNameIsRequired.getText(), pwdIsRequired.getText(), enterMobileNum.getText()
				};

		return validations;
	}

	// verify the first name field by sending only numbers
	public String[] verifyFirstName_Numbers() throws Exception {
		signup_link.click();
		// firstNameField.sendKeys(ExcelReader.getValue("SignUpPage", "numbers"));
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 3));
		signUpFreeBtn.click();
		String[] validations = new String[] { 
				enterValidFirstName.getText(),
				enterLastName.getText(),
				userNameIsRequired.getText(), 
				pwdIsRequired.getText(), 
				enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the first name by sending only special characters
	public String[] verifyFirstName_SplChars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 4));
		signUpFreeBtn.click();
		String[] validations = new String[] {
				enterValidFirstName.getText(), enterLastName.getText(),
				userNameIsRequired.getText(), pwdIsRequired.getText(), enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the first name field by sending combination of alphabets, numerics and
	// special characters
	public String[] verifyFirsstName_Combinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 5));
		signUpFreeBtn.click();
		String[] validations = new String[] { 
				enterValidFirstName.getText(), enterLastName.getText(),
				userNameIsRequired.getText(), pwdIsRequired.getText(), enterMobileNum.getText() 
				};
		return validations;
	}

	/*
	 * Verify first name filed by giving the combination of characters, periods(.),
	 * Exclamation point(!), hyphens(-), and apostrophe(')
	 */
	public String[] verifyFirstName_PossibleCombinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 6));
		signUpFreeBtn.click();

		String[] validations = new String[] { enterLastName.getText(), userNameIsRequired.getText(),
				pwdIsRequired.getText(), enterMobileNum.getText() };
		return validations;
	}

	// Verify first name field by giving below 25 characters
	public String[] verifyFirstName_Below25Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		signUpFreeBtn.click();
		String[] validations = new String[] {
				enterLastName.getText(), userNameIsRequired.getText(),
				pwdIsRequired.getText(), enterMobileNum.getText()
				};
		return validations;
	}

	/****************************************************************************************
	 * LAST NAME FIELD
	 ****************************************************************************************/

	// Verify the last name field by giving moreThan 25 characters
	public String[] verifyLastName_Morethan25Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 2));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				max25Chars.getText(), userNameIsRequired.getText(),
				pwdIsRequired.getText(), enterMobileNum.getText()
				};

		return validations;
	}

	// Verify the last name field by giving numbers
	public String[] verifyLastName_Numbers() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 3));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				enterValidLastName.getText(), userNameIsRequired.getText(),
				pwdIsRequired.getText(), enterMobileNum.getText() 
				};
		return validations;

	}

	// Verify the last name field by giving special characters
	public String[] verifyLastName_SplChars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 4));
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				enterValidLastName.getText(), userNameIsRequired.getText(),
				pwdIsRequired.getText(), enterMobileNum.getText()
				};
		return validations;
	}

	// Verify the last name field by giving combination of alphabet,numeric, and
	// special characters
	public String[] verifyLastName_Combinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 5));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				enterValidLastName.getText(), userNameIsRequired.getText(),
				pwdIsRequired.getText(), enterMobileNum.getText() 
				};
		return validations;
	}

	/*
	 * Verify last name filed by giving the combination of characters, periods(.),
	 * Exclamation point(!), hyphens(-), and apostrophe(')
	 */
	public String[] verifyLastName_PossibleCombinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 6));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] {
				userNameIsRequired.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText()
				};
		return validations;
	}

	// Verify the last name field by giving below 25 characters
	public String[] verifyLastName_Below25Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				userNameIsRequired.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText() 
				};
		return validations;
	}

	/************************************************************************
	 * USER NAME FIELD
	 **********************************************************************/

	// Verify the user name help text in sign up page
	public String verifyUserNameHelpText() {
		signup_link.click();
		return userNameHelpText.getText();
	}

	// Verify the user name field by giving numbers
	public String[] verifyUserName_Numbers() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 2));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] {
				onlyAcceptLtrsPeriods_UserName.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText()
				};
		return validations;
	}

	// Verify the user name field by giving less than 4 chars
	public String[] verifyUserName_Lessthan4Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 3));
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				userName_4and30Chars.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the user name field by giving more than 30 characters
	public String[] verifyUserName_Morethan30Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 4));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] {
				userName_4and30Chars.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the user name field by giving special characters
	public String[] verifyUserName_SplChars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 5));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				onlyAcceptLtrsPeriods_UserName.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText()
				};
		return validations;
	}

	// Verify the user name field by giving the combination of alphabet, numerics
	// and special characters
	public String[] verifyUserName_InvalidCombinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 6));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] {
				onlyAcceptLtrsPeriods_UserName.getText(), pwdIsRequired.getText(),
				enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the user name field by giving the valid combinations
	public String[] verifyUserName_ValidCombinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] {
				pwdIsRequired.getText(), enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the user name field by entering already registered user with illumy
	public String verifyAlreadyRegisteredUser() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 8));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		flagsSection.click();
		thread();
		indiaFlag.click();
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 2));
		Thread.sleep(50000);
		thread();
		signUpFreeBtn.click();

		return userNameAlreadyTaken.getText();
	}

	/****************************************************************************************
	 * PASSWORD FIELD
	 ****************************************************************************************/

	// Verify password field by giving less than 8 characters
	public String[] verifyPassword_Below8Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 3));
		signUpFreeBtn.click();
		thread();
		String[] validations = new String[] { 
				use8orMoreForPwd.getText(), thosePwdsDontMatch.getText(),
				enterMobileNum.getText() 
				};
		return validations;
	}

	// Verify the password field by giving more than 8 chars
	public String[] verifyPassword_Morethan8Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 4));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				thosePwdsDontMatch.getText(), enterMobileNum.getText()
				};
		return validations;
	}

	// Verify the password field by giving all combinations of characters, numbers,
	// and special chars
	public String[] verifyPassword_AllCombinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 5));
		thread();
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				thosePwdsDontMatch.getText(), enterMobileNum.getText()
				};
		return validations;
	}

	// Verify the password field by giving only one character
	public boolean verifyPassword_OneChar() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 6));
		thread();
		signUpFreeBtn.click();

		if (thosePwdsDontMatch.isDisplayed() && enterMobileNum.isDisplayed() && enterValidPassword.isDisplayed()) {
			return true;
		} else
			return false;

	}

	// Verify the password field by giving more than 100 characters
	public String[] verifyPassword_Morethan100Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 7));
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				useLessthan100Chars.getText(), thosePwdsDontMatch.getText(),
				enterMobileNum.getText()

		};
		return validations;
	}

	/****************************************************************************************
	 * CONFIRM PASSWORD FIELD
	 ****************************************************************************************/

	// Verify the confirm password field by giving less than 8 characters
	public String[] verifyConfirmPwd_Lessthan8Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 3));

		signUpFreeBtn.click();

		String[] validations = new String[] {
				thosePwdsDontMatch.getText(), enterMobileNum.getText()

		};
		return validations;
	}

	// Verify the confirm password field by giving more than 8 characters
	public String[] verifyConfirmPwd_Morethan8Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 4));
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				thosePwdsDontMatch.getText(), enterMobileNum.getText()

		};
		return validations;
	}

	// Verify the confirm password field by giving more than 100 characters
	public String[] verifyConfirmPwd_Morethan100Chars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 5));
		signUpFreeBtn.click();

		String[] validations = new String[] { 
				thosePwdsDontMatch.getText(), enterMobileNum.getText()

		};
		return validations;
	}

	// Verify the confirm password field by giving the same passwords
	public String[] verifyConfirmPassword_SamePasswords() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		signUpFreeBtn.click();

		String[] validations = new String[] {
				enterMobileNum.getText()

		};
		return validations;
	}

	/****************************************************************************************
	 * MOBILE NUMBER FIELD
	 ****************************************************************************************/
	// Verify the mobile number field by entering only alphabet
	public String verifyMobileNum_Alphabet() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 3));
		signUpFreeBtn.click();

		return mobileNumOnlyDigits.getText();
	}

	// Verify mobile number field by entering three digits
	public String verifyMobileNum_3Digits() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 4));
		signUpFreeBtn.click();

		return enterValidMobileNum.getText();
	}

	// Verify the mobile number field by entering special characters
	public String veiryMobileNum_SplChars() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 5));
		signUpFreeBtn.click();

		return mobileNumOnlyDigits.getText();
	}

	// Verify the mobile number field by entering the combination of
	// alphabet,numerics, and special characters
	public String veiryMobileNum_Combinations() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 6));
		signUpFreeBtn.click();

		return mobileNumOnlyDigits.getText();
	}

	// Verify the mobile number field by entering more than 11 digits
	public String verifyMobileNum_Morethan10Digits() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 7));
		signUpFreeBtn.click();

		return enterValidMobileNum.getText();
	}

	/*
	 * Verify the captcha is required validation by clicking on the sign up free
	 * button of entering all valid information
	 */
	public String verifyCaptcha_SignUpPage() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7));
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		thread();
		flagsSection.click();
		thread();
		indiaFlag.click();
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 2));
		thread();
		signUpFreeBtn.click();

		return captchaIsRequired.getText();
	}

	// Verify the mobile number field by entering valid mobile number
	public boolean verifyMobileNum_ValidNum() throws Exception {
		signup_link.click();
		firstNameField.sendKeys(reader.getCellData("SignUpPage", firstName, 7));
		lastNameField.sendKeys(reader.getCellData("SignUpPage", lastName, 7));
		userNameField.sendKeys(reader.getCellData("SignUpPage", userName, 7) + email);
		passwordField.sendKeys(reader.getCellData("SignUpPage", password, 2));
		confirmPwdField.sendKeys(reader.getCellData("SignUpPage", confirmPwd, 2));
		thread();
		flagsSection.click();
		thread();
		indiaFlag.click();
		mobileNumField.sendKeys(reader.getCellData("SignUpPage", mobileNum, 2));
		Thread.sleep(50000);
		thread();
		signUpFreeBtn.click();

		return verifyYourPhoneNum.isDisplayed();
	}

	/**********************************************************************************************
	 * VERIFY YOUR PHONE NUMBER SCREEN
	 *********************************************************************************************/

	// Verify the UI of "verify your phone number" screen in sign up process
	public boolean verifyYourPhoneNumberScreenUI() throws Exception {
		verifyMobileNum_ValidNum();
		recoveryTextMessage.isDisplayed();
		editNumberBtn.isDisplayed();
		resendVerificationCodeLink.isDisplayed();
		termsOfServiceLink.isDisplayed();
		verifyBtn.isDisplayed();
		return true;
	}

	// Click on verify button with out entering any OTP
	public boolean verifyPhoneNumber_WithOutOTP() throws Exception {
		verifyMobileNum_ValidNum();
		verifyBtn.click();
		return true;
	}

	// Verify the phone number with invalid OTP
	public String verifyPhoneNumber_InvalidOTP() throws Exception {
		verifyMobileNum_ValidNum();
		Scanner sc = new Scanner(System.in);

		System.out.println("Please, Enter verification code  ");

		String code1 = Integer.toString(sc.nextInt());
		otpCode1.sendKeys(code1);
		thread();
		verifyBtn.click();

		return invalidVerificationCode.getText();
	}

	// Verify the re-send verification code link in the verify phone number screen
	public boolean verifyResendVerificationCode() throws Exception {
		verifyMobileNum_ValidNum();
		resendVerificationCodeLink.click();
		return resendCodeConfirmation.isDisplayed();
	}

	// Verify the edit number button click functionality
	public String verifyEditNumberBtn() throws Exception {
		verifyMobileNum_ValidNum();
		editNumberBtn.click();

		return reenterYourMobileNum.getText();
	}

	// Verify the send button functionality by editing the mobile number
	public boolean verifySendBtn_EditMobileNum() throws Exception {
		verifyEditNumberBtn();
		mobileNumField.clear();
		thread();
		mobileNumField.sendKeys();
		thread();
		sendBtn.click();
		thread();

		return editNumberBtn.isDisplayed();
	}

	// Verify the terms of service link in verify phone number screen
	public boolean verifyTermsOfServiceLink() throws Exception {
		verifyMobileNum_ValidNum();
		termsOfServiceLink.click();

		return termsOfServicePopup.isDisplayed();
	}

	// Verify the "verify your phone number" with valid OTP
	public boolean verifyYourPhoneNumber_ValidOTP() throws Exception {
		verifyMobileNum_ValidNum();
		Scanner sc = new Scanner(System.in);

		System.out.println("Please, Enter valid verification Code  ");

		String code1 = Integer.toString(sc.nextInt());
		otpCode1.sendKeys(code1);
		thread();
		verifyBtn.click();
		thread();
		return welcomeToillumy.isDisplayed();
	}

}
