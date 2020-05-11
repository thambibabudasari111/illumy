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
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SignUpPage;

/**
 * @author thambibabu.dasari
 *
 */
public class SignUpPageTest extends TestBase{

	public static SignUpPage signUpPage;
	public static HomePage homePage;
	
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) {
		initialization();
		signUpPage=new SignUpPage();
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	
	
	//verify SignUp link in Signin Page
	@Test(priority=1)
	public void signUpLinkVerification() {
		String signUpLink=signUpPage.signUpLinkVerification();
		System.out.println(signUpLink);
	}
	
	//verify the SignUp link functionality
	@Test(priority=2)
	public void signUpClickAction() {
		String signUpUrl=signUpPage.signUpClickAction();
		Assert.assertEquals(signUpUrl, "https://stage.illumy1.com/signup");
		System.out.println(signUpUrl);
	}
	
	//validate the SignUpPage Title
	@Test(priority=3)
	public void signUpPageTitleValidation() {
		String signUpTitle=signUpPage.signUpPageTitleValidation();
		Assert.assertEquals(signUpTitle, "illumy");
		System.out.println("SignUp Page Title is: "+signUpTitle);
	}
	
	//To display the "create your illumy account "
	@Test(priority=4)
	public void createillumyAccountTitle() {
		String create_illumyAccount=signUpPage.signUpText();
		System.out.println(create_illumyAccount);
	}
	
	//Validate the illumy text "qa@illumy1.cpm" in email field
	@Test(priority=5)
	public void illumy_DomainValidation() {
		String illumyTxt=signUpPage.illumy_DomainValidation();
		System.out.println(illumyTxt);
	}
	
	//verify the placeholders in sign up page
	@Test(priority=6,enabled=true)
	public void verifySignUp_PlaceholdersTest() {
		Assert.assertTrue(signUpPage.verifySignUp_Placeholders());
	}
	
	//Verify the learn more link in the sign up page 
	@Test(priority=7,enabled=true)
	public void verifyLearnMoreLinkTest() {
		String learnMoreLinkPopupTitle=signUpPage.verifyLearnMoreLink();
		Assert.assertEquals(learnMoreLinkPopupTitle, "Why do we ask for your mobile number?");
		System.out.println(learnMoreLinkPopupTitle);
	}
	
	//Verify the sign in link in sign up page
	@Test(priority=8,enabled=true)
	public void verifySigninLink_SignupPageTest() {
		String signUrl=signUpPage.verifySigninLink_SignupPage();
		Assert.assertEquals(signUrl, "https://stage.illumy1.com/signin");
		System.out.println(signUrl);
	}
	
	//Verify the sign up free button without entering any fields
	@Test(priority=9,enabled=true)
	public void verifySignUpFreeBtn_WithoutAnyFields() {
		String[]fieldsValidations=new String[] {
				"Enter a first name",
				"Enter a last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
		};
		
		String[]actualValidations=signUpPage.verifySignUpFreeBtn_WithoutAnyFields();
		
		Assert.assertEquals(actualValidations, fieldsValidations);
	}
	
	/****************************************************************************************
	 * 								FIRST NAME FIELD
	 ****************************************************************************************/
	//Verify moreThan 25 characters in first name field
	@Test(priority=10,enabled=true)
	public void verifyFirstName_MoreThan25Chars() throws Exception {
		String[]expectedValidations=new String[] {
			"Maximum of 25 characters",
			"Enter a last name",
			"Username is required",
			"Password is required",
			"Enter a mobile number"
		};
		
		String[] actualValidations=signUpPage.verifyFirstName_MoreThan25Chars();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//verify the first name field by sending only numbers 
	@Test(priority=11,enabled=true)
	public void verifyFirstName_NumbersTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a valid first name",
				"Enter a last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyFirstName_Numbers();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the first name by sending only special characters
	@Test(priority=12,enabled=true)
	public void verifyFirstName_SplCharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a valid first name",
				"Enter a last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyFirstName_SplChars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the first name field sending combination of alphabets, numerics and special characters
	@Test(priority=13,enabled=true)
	public void verifyFirsstName_CombinationsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a valid first name",
				"Enter a last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyFirsstName_Combinations();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	/*Verify first name filed by giving the combination of characters, periods(.), Exclamation point(!), 
	 * hyphens(-), and apostrophe(') */
	@Test(priority=14,enabled=true)
	public void verifyFirstName_PossibleCombinationsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyFirstName_PossibleCombinations();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify first name field by giving below 25 characters
	@Test(priority=15,enabled=true)
	public void verifyFirstName_25CharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyFirstName_Below25Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	/****************************************************************************************
	 * 								LAST NAME FIELD
	 ****************************************************************************************/
	
	//Verify the last name field by giving moreThan 25 characters
	@Test(priority=16,enabled=true)
	public void verifyLastName_Morethan25Chars() throws Exception {
		
		String[]expectedValidations=new String[] {
				"Maximum of 25 characters",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyLastName_Morethan25Chars();
			for(int i = 0;i<actualValidations.length;i++) {
				System.out.println("****************");
				Assert.assertEquals(actualValidations[i], expectedValidations[i]);
				System.out.println(actualValidations[i]);
			}	
	}
	
	//Verify the last name field by giving numbers 
	@Test(priority=17,enabled=true)
	public void verifyLastName_NumbersTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a valid last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyLastName_Numbers();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the last name field by giving special characters
	@Test(priority=18,enabled=true)
	public void verifyLastName_SplCharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a valid last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyLastName_SplChars();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the last name field by giving combination of alphabet,numeric, and special characters
	@Test(priority=19,enabled=true)
	public void verifyLastName_CombinationsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a valid last name",
				"Username is required",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyLastName_Combinations();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	/*Verify last name filed by giving the combination of characters, periods(.), Exclamation point(!), 
	 * hyphens(-), and apostrophe(') */
	@Test(priority=20,enabled=true)
	public void verifyLastName_PossibleCombinations() throws Exception {
		String[]expectedValidations=new String[] {
				"Username is required",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyLastName_PossibleCombinations();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the last name field by giving below 25 characters
	@Test(priority=21,enabled=true)
	public void verifyLastName_Below25Chars() throws Exception {
		String[]expectedValidations=new String[] {
				"Username is required",
				"Password is required",
				"Enter a mobile number"
		};
		
		String[] actualValidations=signUpPage.verifyLastName_Below25Chars();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	/****************************************************************************************
	 * 								USER NAME FIELD
	 ****************************************************************************************/
	
	//Verify the user name help text in sign up page
	@Test(priority=22,enabled=true)
	public void verifyUserNameHelpTextTest() {
		String userNameHelpText=signUpPage.verifyUserNameHelpText();
		Assert.assertEquals(userNameHelpText, "You can use letters, numbers, periods, hyphens & underscores", "User name help do not matched");
		System.out.println(userNameHelpText);
	}
	
	//Verify the user name field by giving numbers
	@Test(priority=23,enabled=true)
	public void verifyUserName_NumbersTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Only letters, numbers, periods, hyphens and underscores are acceptable",
				"Password is required",
				"Enter a mobile number"
			};
			
		String[] actualValidations=signUpPage.verifyUserName_Numbers();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the user name field by giving less than 4 chars
	@Test(priority=24,enabled=true)
	public void verifyUserName_Lessthan4CharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Sorry, your username must be between 4 and 30 characters long.",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyUserName_Lessthan4Chars();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the user name field by giving more than 30 characters
	@Test(priority=25,enabled=true)
	public void verifyUserName_Morethan30CharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Sorry, your username must be between 4 and 30 characters long.",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyUserName_Morethan30Chars();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the user name field by giving special characters
	@Test(priority=26,enabled=true)
	public void verifyUserName_SplCharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Only letters, numbers, periods, hyphens and underscores are acceptable",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyUserName_SplChars();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the user name field by giving the combination of alphabet, numerics and special characters
	@Test(priority=27,enabled=true)
	public void verifyUserName_InvalidCombinationsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Only letters, numbers, periods, hyphens and underscores are acceptable",
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyUserName_InvalidCombinations();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the user name field by giving the valid combinations
	@Test(priority=28,enabled=true)
	public void verifyUserName_ValidCombinations() throws Exception {
		String[]expectedValidations=new String[] {
				"Password is required",
				"Enter a mobile number"
		};
			
		String[] actualValidations=signUpPage.verifyUserName_ValidCombinations();
		Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the user name field by entering already registered user with illumy 
	@Test(priority=29,enabled=true)
	public void verifyAlreadyRegisteredUser() throws Exception {
		String alreadyRegUser=signUpPage.verifyAlreadyRegisteredUser(prop.getProperty("validMobileNum"));
		Assert.assertEquals(alreadyRegUser, "That username is taken, please try another.");
		System.out.println(alreadyRegUser);
	}
	
	/****************************************************************************************
	 * 								PASSWORD FIELD
	 * @throws Exception 
	 ****************************************************************************************/
	
	//Verify password field by giving less than 8 characters
	@Test(priority=30,enabled=true)
	public void verifyPassword_Below8CharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Use 8 characters or more for your password",
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyPassword_Below8Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the password field by giving more than 8 chars
	@Test(priority=31,enabled=true)
	public void verifyPassword_Morethan8Chars() throws Exception {
		String[]expectedValidations=new String[] {
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyPassword_Morethan8Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the password field by giving all combinations of characters, numbers, and special chars
	@Test(priority=32,enabled=true)
	public void verifyPassword_AllCombinationsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyPassword_AllCombinations();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the password field by giving only one character
	@Test(priority=33,enabled=true)
	public void verifyPassword_OneCharTest() throws Exception {
		Assert.assertTrue(signUpPage.verifyPassword_OneChar());
	}
	
	//Verify the password field by giving more than 100 characters
	@Test(priority=34,enabled=true)
	public void verifyPassword_Morethan100Chars() throws Exception {
		String[]expectedValidations=new String[] {
				"Use less than 100 characters for your password",
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyPassword_Morethan100Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	/****************************************************************************************
	 * 								CONFIRM PASSWORD FIELD
	 ****************************************************************************************/
	
	//Verify the confirm password field by giving less than 8 characters
	@Test(priority=35,enabled=true)
	public void verifyConfirmPwd_Lessthan8CharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyConfirmPwd_Lessthan8Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the confirm password field by giving more than 8 characters 
	@Test(priority=36,enabled=true)
	public void verifyConfirmPwd_Morethan8CharsTest() throws Exception {
		String[]expectedValidations=new String[] {
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyConfirmPwd_Morethan8Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the confirm password field by giving more than 100 characters
	@Test(priority=37,enabled=true)
	public void verifyConfirmPwd_Morethan100Chars() throws Exception {
		String[]expectedValidations=new String[] {
				"Those passwords don't match. Try again",
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyConfirmPwd_Morethan100Chars();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	//Verify the confirm password field by giving the same passwords
	@Test(priority=38,enabled=true)
	public void verifyConfirmPassword_SamePasswords() throws Exception {
		String[]expectedValidations=new String[] {
				"Enter a mobile number"
			};
			
			String[] actualValidations=signUpPage.verifyConfirmPassword_SamePasswords();
			Assert.assertEquals(actualValidations, expectedValidations);
	}
	
	/****************************************************************************************
	 * 								MOBILE NUMBER FIELD
	 * @throws Exception 
	 ****************************************************************************************/
	//Verify the mobile number field by entering only alphabet
	@Test(priority=39,enabled=true)
	public void verifyMobileNum_Alphabet() throws Exception {
		String mobileNumOnlyDigits=signUpPage.verifyMobileNum_Alphabet();
		Assert.assertEquals(mobileNumOnlyDigits, "Mobile number should be only in digits");
	}
	
	//Verify mobile number field by entering three digits
	@Test(priority=40,enabled=true)
	public void verifyMobileNum_3Digits() throws Exception {
		String mobileNumOnlyDigits=signUpPage.verifyMobileNum_3Digits();
		Assert.assertEquals(mobileNumOnlyDigits, "Enter a valid mobile number");
	}
	
	//Verify the mobile number field by entering special characters
	@Test(priority=41,enabled=true)
	public void veiryMobileNum_SplChars() throws Exception {
		String mobileNumOnlyDigits=signUpPage.veiryMobileNum_SplChars();
		Assert.assertEquals(mobileNumOnlyDigits, "Mobile number should be only in digits");
	}
	
	//Verify the mobile number field by entering the combination of alphabet,numerics, and special characters
	@Test(priority=42,enabled=true)
	public void veiryMobileNum_Combinations() throws Exception {
		String mobileNumOnlyDigits=signUpPage.veiryMobileNum_Combinations();
		Assert.assertEquals(mobileNumOnlyDigits, "Mobile number should be only in digits");
	}
	
	//Verify the mobile number field by entering more than 10 digits
	@Test(priority=43,enabled=true)
	public void verifyMobileNum_Morethan11Digits() throws Exception {
		String mobileNumOnlyDigits=signUpPage.verifyMobileNum_Morethan10Digits();
		Assert.assertEquals(mobileNumOnlyDigits, "Enter a valid mobile number");
	}
	
	/*Verify the captcha is required validation by clicking on the sign up free button of entering all valid information*/
	@Test(priority=44,enabled=true)
	public void verifyCaptcha_SignUpPage() throws Exception {
		String captchaReq=signUpPage.verifyCaptcha_SignUpPage(prop.getProperty("validMobileNum"));
		Assert.assertEquals(captchaReq, "Captcha is required");
	}
	
	//Verify the mobile number field by entering valid mobile number
	@Test(priority=45,enabled=true)
	public void verifyMobileNum_ValidNum() throws Exception {
		Assert.assertTrue(signUpPage.verifyMobileNum_ValidNum(prop.getProperty("validMobileNum")));
	}
	
	/**********************************************************************************************
	 * 							VERIFY YOUR PHONE NUMBER SCREEN
	 *********************************************************************************************/
	//Verify the UI of "verify your phone number" screen in sign up process
	@Test(priority=46,enabled=false)
	public void verifyYourPhoneNumberScreenUI() throws Exception {
		Assert.assertTrue(signUpPage.verifyYourPhoneNumberScreenUI(prop.getProperty("validMobileNum")));
	}
		
	
	//Click on verify button with out entering any OTP 
	@Test(priority=47,enabled=true)
	public void verifyPhoneNumber_WithOutOTP() throws Exception {
		Assert.assertTrue(signUpPage.verifyPhoneNumber_WithOutOTP(prop.getProperty("validMobileNum")));
	}
	
	//Verify the phone number with invalid OTP
	@Test(priority=48,enabled=true)
	public void verifyPhoneNumber_InvalidOTP() throws Exception {
		String captchaReq=signUpPage.verifyPhoneNumber_InvalidOTP(prop.getProperty("validMobileNum"));
		Assert.assertEquals(captchaReq, "Invalid Verification Code");
		System.out.println(captchaReq);
	}
	
	//Verify the re-send verification code link in the verify phone number screen
	@Test(priority=49,enabled=true)
	public void verifyResendVerificationCode() throws Exception {
		Assert.assertTrue(signUpPage.verifyResendVerificationCode(prop.getProperty("validMobileNum")));
	}
	
	//Verify the edit number button click functionality
	@Test(priority=50,enabled=true)
	public void verifyEditNumberBtnTest() throws Exception {
		String reenterMobileNum=signUpPage.verifyEditNumberBtn(prop.getProperty("validMobileNum"));
		Assert.assertEquals(reenterMobileNum, "Please re-enter your mobile number");
		System.out.println(reenterMobileNum);
	}

	//Verify the send button functionality by editing the mobile number
	@Test(priority=51,enabled=true)
	public void verifySendBtn_EditMobileNumTest() throws Exception {
		Assert.assertTrue(signUpPage.verifySendBtn_EditMobileNum(prop.getProperty("validMobileNum")));
	}
	
	//Verify the terms of service link in verify phone number screen
	@Test(priority=52,enabled=true)
	public void verifyTermsOfServiceLinkTest() throws Exception {
		Assert.assertTrue(signUpPage.verifyTermsOfServiceLink(prop.getProperty("validMobileNum")));
	}
	
	//Verify the "verify your phone number" with valid OTP
	@Test(priority=53,enabled=true)
	public void verifyYourPhoneNumber_ValidOTP() throws Exception {
		Assert.assertTrue(signUpPage.verifyYourPhoneNumber_ValidOTP(prop.getProperty("validMobileNum")));
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
	
	

