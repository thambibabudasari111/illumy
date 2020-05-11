/**
 * 
 */
package com.illumy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;

/**
 * @author thambibabu.dasari
 * 
 *In this class, written all the possible test cases related to the "Account" in the settings module.
 *Settings> Account.
 *1. Validating the illumy email id
 *2. Change the mobile number
 *3. Forgot Password
 *4. Reset password 
 *
 */
public class Account extends TestBase{

	
	//Initializing the page objects:
	public Account() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Page Factory: OR (Object Repository)
	
	//Buttons and Icons:
	@FindBy(xpath="//*[@class='col-md-3 noselect']")
	WebElement digitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//*[text()='Account']")
	WebElement account;
	
	@FindBy(xpath="//*[@id='setting_scroll']//*[contains(text(),'Change Number')]")
	WebElement changeNumBtn;
	
	@FindBy(xpath="//*[contains(@class,'close_popup')]")
	WebElement closePopup;
	
	@FindBy(xpath="//*[@role='dialog']//*[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	@FindBy(xpath="//*[@role='dialog']//*[contains(@type,'submit')]")
	WebElement confirmBtn_IForgotMyPwdPopup;
	
	@FindBy(xpath="//*[@role='dialog']//*[contains(@id,'phone_code')]//*[contains(@class,'arrow')]")
	WebElement arrow_changePwdMobNumPopup;
	
	@FindBy(xpath="//*[@role='dialog']//*[contains(@type,'submit')]")
	WebElement nextBtn;
	
	@FindBy(xpath="//*[@role='dialog']//*[contains(@type,'submit')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//*[contains(@class,'group')]//*[@id='oldPassword']//following-sibling::*[contains(@class,'illumy_txt btn')]//*[@data-toggle='tooltip']")
	WebElement currentPwdEyeIcon;
	
	@FindBy(xpath="//*[contains(@class,'group')]//*[@id='password']//following-sibling::*[contains(@class,'illumy_txt btn')]//*[@data-toggle='tooltip']")
	WebElement newPwdEyeIcon;
	
	@FindBy(xpath="//*[contains(@class,'group')]//*[@id='repeatPassword']//following-sibling::*[contains(@class,'illumy_txt btn')]//*[@data-toggle='tooltip']")
	WebElement repeatNewPwdEyeIcon;
	
	@FindBy(xpath="//*[contains(@type,'submit')]")
	WebElement savePwdBtn;
	
	@FindBy(xpath="//*[contains(text(),'Click To Verify')]")
	WebElement clickToVerifyBtn;
	
	
	//Links:
	@FindBy(xpath="//*[@id='setting_scroll']//*[contains(text(),'(Forgot Password?)')]")
	WebElement forgotPwdLink;
	
	@FindBy(xpath="//*[text()='Resend Verification Code']")
	WebElement resendVerificationCodeLink;
	
	
	//Popup's:
	@FindBy(xpath="//*[contains(text(),' I Forgot My Password ')]")
	WebElement iForgotMyPwdPopup;

	@FindBy(xpath="//*[@role='dialog']//*[contains(@class,'text-primary')]")
	WebElement text_IForgotMyPwdPopup;
	
	//Text Fields:
	@FindBy(xpath="//*[@role='dialog']//*[@id='phone_number']")
	WebElement mobNumField_changePwdMobNumPopup;
	
	@FindBy(xpath="//*[@id='setting_scroll']//*[contains(@id,'oldPassword')]")
	WebElement currentPwdField;
	
	@FindBy(xpath="//*[@id='setting_scroll']//*[contains(@id,'password')]")
	WebElement newPwdField;
	
	@FindBy(xpath="//*[@id='setting_scroll']//*[contains(@id,'repeatPassword')]")
	WebElement repeatNewPwdField;
	
	@FindBy(xpath="//*[@name='optcode1']")
	WebElement verificationCode;
	
	
	//Validations:
	@FindBy(xpath = "//*[contains(@class,'box-header')]//*[text()='Account']")
	WebElement accountSectionHeader;

	@FindBy(xpath = "//*[@id='setting_scroll']//*[text()='illumy Account']//following-sibling::*[@class='swith_txt']")
	WebElement illumyAccount;

	@FindBy(xpath = "//*[@id='setting_scroll']//*[contains(@src,'Flags')]")
	WebElement flagInPwdRecoveryMobNum;

	@FindBy(xpath = "//*[@id='setting_scroll']//*[contains(@class,'account-phoneno')]")
	WebElement phNumInPwdRecoveryMobNum;

	@FindBy(xpath = "//*[@id='setting_scroll']//*[contains(@class,'fa-check-circle')]")
	WebElement greenColorCheckCircle;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'dialog-title')]")
	WebElement changePwdMobNumPopupTitle;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@id,'phone_code')]//*[@class='ng-star-inserted']//*[contains(@src,'Flags')]")
	WebElement Flag_changePwdMobNumPopup;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@id,'phone_code')]//*[@class='ng-star-inserted']")
	WebElement countryCode_changePwdMobNumPopup;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'text-center')]")
	WebElement centerText;

	
	@FindBy(xpath="//*[@role='dialog']//*[contains(@class,'login-popup')]//*[contains(@class,'text-center')]")
	WebElement changePwd_CenterText;
	
	@FindBy(xpath = "//*[@role='dialog']//*[@class='text-center']//*[@class='star_txt']")
	WebElement starTxt_changePwdMobNumPopup;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'text-primary')]")
	WebElement primaryText;
	
	@FindBy(xpath="//*[contains(@class,'bounding-box')]//*[contains(@class,'cdk-overlay-pane')]")
	WebElement countriesDropdown;
	
	@FindBy(xpath="//*[text()='The mobile number you provided is the same as your current number. Please try again.']")
	WebElement mobNumProvidedSameAsCurrent;
	
	@FindBy(xpath="//*[text()=' Enter a valid mobile number ']")
	WebElement enterValidMobNum;
	
	@FindBy(xpath="//*[text()=' Mobile number should be only in digits ']")
	WebElement mobNumOnlyDigits;
	
	@FindBy(xpath="//*[text()='Invalid verification code. Please try again']")
	WebElement invalidVerificationCode;
	
	@FindBy(xpath="//*[text()='Mobile verification code has been resent']")
	WebElement verificationCodeResent;
	
	@FindBy(xpath="//*[text()=' Password is required']")
	WebElement pwdIsRequired;
	
	@FindBy(xpath="//*[text()=' Password is required ']")
	WebElement passwordRequired;
	
	@FindBy(xpath="//*[text()=' Repeat password is required']")
	WebElement repeatPwdIsRequired;
	
	@FindBy(xpath="//*[text()=' Password contains minimum of 8 characters']")
	WebElement pwdMinimum8Chars;
	
	@FindBy(xpath="//*[text()=' Use 8 characters or more for your password ']")
	WebElement use8CharsForPwd;
	
	@FindBy(xpath="//*[text()=' Use less than 100 characters for your password ']")
	WebElement useLessthan100CharsForPwd;
	
	@FindBy(xpath="//*[contains(@class,'group')]//*[@id='oldPassword']//following-sibling::*[contains(@class,'illumy_txt btn')]//*[@data-toggle='tooltip']//following-sibling::*[@role='tooltip']")
	WebElement eyeIconTooltip;
	
	@FindBy(xpath="//*[text()='Entered old password is wrong']")
	WebElement enteredPwdIsWrong;
	
	@FindBy(xpath="//*[contains(@class,'text-danger')]")
	WebElement thosePwdsDontMatch;
	
	
	
	//Actions:
	
	//Verify the title of the 'Account' section in the settings module
	public boolean verifyHeaderOfAccount() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return accountSectionHeader.isDisplayed();
	}
	
	//Verify the illumy email id in the 'Account' section of the settings module
	public String verifyillumyEmailId() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return illumyAccount.getText();
	}
	
	//Validate the country flag in the 'Password Recovery Mobile Number' section
	public String verifyCountryFlagInAccount() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return flagInPwdRecoveryMobNum.getAttribute("src");
	}
	
	//Check for the "country code" before the mobile number in the 'Password Recovery Mobile Number'
	public String verifyCountryCode_Account() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return phNumInPwdRecoveryMobNum.getText();
	}
	
	//Verify the mobile number next to the country code in the 'Password Recovery Mobile Number' section
	public String verifyMobNum_Account() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return phNumInPwdRecoveryMobNum.getText();
	}
	
	/*Validate the "Green color circle check Icon" next to the mobile number in the 'Password Recovery Mobile Number'
	 *  section that indicates the mobile number is verified
	 */
	public boolean verifyCheckIconInAccount() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return greenColorCheckCircle.isDisplayed();
	}

	//Verify the "Change Number" button is displaying or not in the 'Password Recovery Mobile Number' section
	public boolean verifyChangeNumBtnInAccount() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return changeNumBtn.isDisplayed();
	}
	
	//Verify the click functionality of the "Change Number" button 
	public String clickOnChangeNumBtn_Account() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		return changePwdMobNumPopupTitle.getText();
	}
	
	/*Verify the mouse hover and click functionality of the cross symbol (X) in the
	 * "Change Your Password Recovery Mobile Number' pop up
	 */
	public boolean closeChangePwdRecoveryMobNumPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		closePopup.click();
		thread();
		try {
			if(changePwdMobNumPopupTitle.isDisplayed()) {
				return false;
			}else if(!changePwdMobNumPopupTitle.isDisplayed()){
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify the country flag and country code field in the "Change Your Password Recovery Mobile Number' pop up  
	public String verifyCountryFlag_ChangePwdMobNunPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		return Flag_changePwdMobNumPopup.getAttribute("src");
	}
	
	/*Verify the mouse hover and click functionality of the country flag field 
	 * in the "Change Your Password Recovery Mobile Number' pop up  
	 */
	public boolean clickOnCountryFlag_ChangePwdMobNunPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		Flag_changePwdMobNumPopup.click();
		thread();
		return countriesDropdown.isDisplayed();
	}
	
	//Verify the down arrow and it's click functionality in the "Change Your Password Recovery Mobile Number' pop up  
	public boolean clickOnArrow_ChangePwdMobNunPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		arrow_changePwdMobNumPopup.click();
		thread();
		return countriesDropdown.isDisplayed();
	}
	
	//Verify the text "Mobile Number" above the phone number field in the "Change Your Password Recovery Mobile Number' pop up
	public String verifyMobNumText_ChangePwdMobNunPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		return centerText.getText();
	}
	
	//Verify the red color star (*) symbol next to the mobile number text in the  "Change Your Password Recovery Mobile Number' pop up
	public String verifyStar_ChangePwdMobNunPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		return centerText.getText();
	}
	
	//Verify the mouse hover and click functionality of the "Cancel" button in the "Change Your Password Recovery Mobile Number' pop up  
	public boolean clickOnCancel_ChangePwdMobNunPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		cancelBtn.click();
		thread();
		try {
			if(changePwdMobNumPopupTitle.isDisplayed()) {
				return false;
			}else if(!changePwdMobNumPopupTitle.isDisplayed()){
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify the "Next" button, if an user is not entering the mobile number
	public boolean verifyNextBtnWithoutMobileNum() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		if(nextBtn.isEnabled()) {
			return false;
		}else if(!nextBtn.isEnabled()) {
			return true;
		}
		return true;
	}
	
	//Verify the "Next" button, when an user enter 3 digits in the mobile number field
	public boolean verifyNextBtnByEnter3DigitsMobNum(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		if(nextBtn.isEnabled()) {
			return false;
		}else if(!nextBtn.isEnabled()) {
			return true;
		}
		return true;
	}
	
	//Verify the "Next" button by entering the more than 3 digits in the mobile number field
	public boolean checkNextBtnByEnterMoreThan3DigistsMobNum(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		if(!nextBtn.isEnabled()) {
			return false;
		}else if(nextBtn.isEnabled()) {
			return true;
		}
		return true;
	}
	
	/*Verify the mobile number field by entering the same mobile number as current number,  
	 * which already existed in the password recovery mobile number section 
	 */
	public String verifyMobNumByEnterCurrentNum(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		nextBtn.click();
		thread();
		return mobNumProvidedSameAsCurrent.getText();
	}
	
	//Verify the mobile number field by entering 3 digits
	public String verifyMobNumByEnter3Digits(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		return enterValidMobNum.getText();
	}
	
	//Verify the mobile number field by entering only alphabet
	public String verifyMobNumByEnterAlphbet(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		return mobNumOnlyDigits.getText();
	}
	
	//Verify the mobile number field by entering only special characters
	public String verifyMobNumByEnterSplChars(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		return mobNumOnlyDigits.getText();
	}
	
	//Verify the mobile number field by entering the combination of alphabet, numbers and special characters 
	public String verifyMobNumByEnterCombinations(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		return mobNumOnlyDigits.getText();
	}
	
	//Verify the mobile number field by entering more than 11 digits
	public String verifyMobNumByEnter11Digits(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		return enterValidMobNum.getText();
	}
	
	//Click on "Next" button by entering the valid mobile number
	public String verifyMobNumByEnterValidNum(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		nextBtn.click();
		thread();
		return centerText.getText();
	}
	
	//Verify the text message in the verification code section once sent the OTP to mobile number
	public String verifyTextInOTPSection(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		nextBtn.click();
		thread();
		return centerText.getText();
	}
	
	//Verify the "Submit" button without entering the verification code
	public boolean verifySubmitBtnWithoutEnterOTP(String keysToSend) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		nextBtn.click();
		thread();
		
		if(submitBtn.isEnabled()) {
			return false;
		}else if(!submitBtn.isEnabled()) {
			return true;
		}
		return true;
	}
	
	//Verify the "Submit" button after entering the verification code
	public boolean verifySubmitBtnAfterEnterOTP(String keysToSend,String code) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		nextBtn.click();
		thread();
		verificationCode.sendKeys(code);
		thread();
		
		if(!submitBtn.isEnabled()) {
			return false;
		}else if(submitBtn.isEnabled()) {
			return true;
		}
		return true;
	}
	
	//Click on "Submit" button by entering the invalid verification code
	public String clickOnSubmitWithInvalidOTP(String keysToSend,String code) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(keysToSend);
		thread();
		nextBtn.click();
		thread();
		verificationCode.sendKeys(code);
		thread();
		submitBtn.click();
		thread();
		return invalidVerificationCode.getText();
	}
	
	//Verify the "Click To Verify" button next to the mobile number, if the is not verified the mobile number
	public boolean verifyClickToVerifyBtn() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return clickToVerifyBtn.isDisplayed();
	}
	
	//Verify the click functionality of the "Click To Verify" button in the password recovery mobile number section
	public boolean clickOnClickToVerifyBtn() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		clickToVerifyBtn.click();
		thread();
		
		return  changePwd_CenterText.isDisplayed();	
	}
	
	//Verify the "Re-send Verification Code" link in the verification code section 
	public boolean verifyResendVerificationCodeLink(String mobNum) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(mobNum);
		thread();
		nextBtn.click();
		thread();
		return resendVerificationCodeLink.isDisplayed();
	}
	
	//Verify the verification code resent confirmation code by clicking the "Resend Verification Code" link
	public boolean clickOnResendVerificationCodeLink(String mobNum) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		changeNumBtn.click();
		thread();
		mobNumField_changePwdMobNumPopup.sendKeys(mobNum);
		thread();
		nextBtn.click();
		thread();
		resendVerificationCodeLink.click();
		thread();
		return verificationCodeResent.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of "Forgot Password" link
	public boolean clickOnForgotPwdLink() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		forgotPwdLink.click();
		thread();
		return iForgotMyPwdPopup.isDisplayed();
	}
	
	//Verify the alert message in the "I Forgot My Password" pop up to reset the password
	public String verifyAlertMsg_IForgotPwdPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		forgotPwdLink.click();
		thread();
		return primaryText.getText();
	}
	
	//Verify the cross mark (X) symbol and it's click functionality in the "I Forgot My Password" pop up 
	public boolean clickOnCrossSym_IForgotPwdPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		forgotPwdLink.click();
		thread();
		
		closePopup.click();
		thread();
		try {
			if(iForgotMyPwdPopup.isDisplayed()) {
				return false;
			}else if(!iForgotMyPwdPopup.isDisplayed()){
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify the click functionality of the "Cancel" button "I Forgot My Password" pop up 
	public boolean clickOnCancel_IForgotPwdPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		forgotPwdLink.click();
		thread();
		
		cancelBtn.click();
		thread();
		try {
			if(iForgotMyPwdPopup.isDisplayed()) {
				return false;
			}else if(!iForgotMyPwdPopup.isDisplayed()){
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify the click functionality of the "Confirm" button "I Forgot My Password" pop up 
	public String clickOnConfirm_IForgotPwdPopup() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		forgotPwdLink.click();
		thread();
		
		confirmBtn_IForgotMyPwdPopup.click();
		thread();
		return driver.getCurrentUrl();
	}
	
	//Verify the "Current Password" field without entering any password
	public String verifyCurrentPwdWithoutPwd() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.click();
		thread();
		newPwdField.click();
		thread();
		return pwdIsRequired.getText();
	}
	
	//Verify "Current Password"  by entering password is showing in encrypted mode or not.
	public String verifyCurrentPwdEncryption(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(password);
		thread();
		return currentPwdField.getAttribute("type");
	}
	
	//Verify the "Current Password" field by entering less than 8 characters
	public String verifyCurrentPwdWith7Chars(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(password);
		thread();
		return pwdMinimum8Chars.getText();
	}
	
	//Verify the eye icon is displayed or not in the "Current Password" field
	public boolean verifyCurrentPwdEyeIcon() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return currentPwdEyeIcon.isDisplayed();
	}
	
	//Verify the "New Password" field without entering any password
	public String verifyNewPwdWithoutPwd() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		newPwdField.click();
		thread();
		currentPwdField.click();
		thread();
		return passwordRequired.getText();
	}
	
	//Verify by entering the "New Password" showing in encrypted mode or not.
	public String verifyNewPwdEncryption(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		newPwdField.sendKeys(password);
		thread();
		return newPwdField.getAttribute("type");
	}
	
	//Verify the "New Password" field by entering less than 8 characters
	public String verifyNewPwdWith7Chars(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		newPwdField.sendKeys(password);
		thread();
		return use8CharsForPwd.getText();
	}
	
	//Verify the "New Password" field by entering more than 100 characters
	public String verifyNewPwdMorethan100Chars(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		newPwdField.sendKeys(password);
		thread();
		return useLessthan100CharsForPwd.getText();
	}
	
	//Verify the eye icon is displayed or not in the "New Password" field
	public boolean verifyNewPwdEyeIcon() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return newPwdEyeIcon.isDisplayed();
	}
	
	//Verify the " Repeat New Password" field without entering any password
	public String repeatNewPwdWithoutPwd() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		repeatNewPwdField.click();
		thread();
		newPwdField.click();
		thread();
		return repeatPwdIsRequired.getText();
	}
	
	//Verify that by entering the "Repeat New Password" showing in encrypted mode or not.
	public String verifyRepeatNewPwdEncryption(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		repeatNewPwdField.sendKeys(password);
		thread();
		return repeatNewPwdField.getAttribute("type");
	}
	
	//Verify the eye icon is displayed or not in the "Repeat New Password" field
	public boolean verifyRepeatNewPwdEyeIcon() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return repeatNewPwdEyeIcon.isDisplayed();
	}
	
	//Verify the mouse hover action of eye icon in the password fields, when the password is in encrypted mode
	public String verifyShowEyeIconMousehover(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(password);
		thread();
		Actions action = new Actions(driver);
		action.moveToElement(currentPwdEyeIcon).build().perform();
		thread();
		return eyeIconTooltip.getText();
	}
	
	//Click on "Show" eye icon to view the entered encrypted password 
	public String clickOnShowEyeIcon(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(password);
		thread();
		currentPwdEyeIcon.click();
		thread();
		return currentPwdField.getAttribute("type");
	}
	
	//Verify the mouse hover functionality of eye icon when the password is in decrypt mode
	public String verifyHideEyeIconMousehover(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(password);
		thread();
		currentPwdEyeIcon.click();
		thread();
		Actions action = new Actions(driver);
		action.moveToElement(currentPwdEyeIcon).build().perform();
		thread();
		return eyeIconTooltip.getText();
	}
	
	//Click on "Hide" eye icon to encrypt the entered password
	public String clickOnHideEyeIcon(String password) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(password);
		thread();
		currentPwdEyeIcon.click();
		thread();
		currentPwdEyeIcon.click();
		thread();
		return currentPwdField.getAttribute("type");
	}
	
	//Verify the "Save Password" button is disabled or not, if the user is not entering all the required password fields
	public boolean verifySaveBtn_IfUserNotEnterAllPwds() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		return !savePwdBtn.isEnabled();
	}
	
	//Verify the "Save Password" button is enabled or not, if the user is entered all the required password fields
	public boolean verifySavePwd_IfUserEnterAllPwds(String currentPwd,String newPwd,String repeatNewPwd) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(currentPwd);
		thread();
		newPwdField.sendKeys(newPwd);
		thread();
		repeatNewPwdField.sendKeys(repeatNewPwd);
		thread();
		return savePwdBtn.isEnabled();
	}
	
	//Click on "Save Password" by entering the wrong "Current Password"
	public String clickOnSavePwd_WrongCurrentPwd(String currentPwd,String newPwd,String repeatNewPwd) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(currentPwd);
		thread();
		newPwdField.sendKeys(newPwd);
		thread();
		repeatNewPwdField.sendKeys(repeatNewPwd);
		thread();
		savePwdBtn.click();
		thread();
		return enteredPwdIsWrong.getText();
	}
	
	//Click on "Save Password" by entering the wrong "Repeat New Password"
	public String clickOnSavePwd_WrongRepeatNewPwd(String currentPwd,String newPwd,String repeatNewPwd) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(currentPwd);
		thread();
		newPwdField.sendKeys(newPwd);
		thread();
		repeatNewPwdField.sendKeys(repeatNewPwd);
		thread();
		savePwdBtn.click();
		thread();
		return thosePwdsDontMatch.getText();
	}
	
	//Click on "Save Password" by entering the valid password in all the required fields
	public String clickOnSavePwdWithAllValidPwds(String currentPwd,String newPwd,String repeatNewPwd) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		account.click();
		thread();
		currentPwdField.sendKeys(currentPwd);
		thread();
		newPwdField.sendKeys(newPwd);
		thread();
		repeatNewPwdField.sendKeys(repeatNewPwd);
		thread();
		savePwdBtn.click();
		thread();
		thread();
		return driver.getCurrentUrl();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
