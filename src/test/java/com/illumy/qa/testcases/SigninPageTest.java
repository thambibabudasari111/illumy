/**
 * 
 */
package com.illumy.qa.testcases;

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


/**
 * @author thambibabu.dasari
 *
 */
public class SigninPageTest extends TestBase{

	public static SigninPage signinPage;
	public static HomePage homePage;
	
	
	public SigninPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		signinPage=new SigninPage();	
		
	}
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	@AfterTest
	public void endTest() {
		endReport();
	}
	
	//signin page title test
	@Test(priority=1)
	public void illumy_SigninPageTitleValidation() {
			
		String title=signinPage.validateLoginPageTitle();
		Assert.assertEquals(title, "illumy");
		System.out.println(title);
			
	}
			
	
		
	//Welcome text
	@Test(priority=2)
	public void welcomeTextValidation() {
			
		String welcome_Text=signinPage.validateWelcomeText();
		System.out.println(welcome_Text);
	}
		
	//verify signin to continue text
	@Test(priority=3)
	public void signinToContinueText() {
			
		String signinContinueText=signinPage.signinToContinueText();
		System.out.println(signinContinueText);
	}
		
		//verify the email placeholder
		@Test(priority=4)
		public void emailPlaceholderValidation() {
			
			String emailPlaceholder=signinPage.emailPlaceholder();
			System.out.println(emailPlaceholder);
		}
		
		//verify the password placeholder
		@Test(priority=5)
		public void PwdPlaceholderValidation() {
			
			String pwdPlaceholder=signinPage.passwordPlaceholder();
			System.out.println(pwdPlaceholder);
		}
		
		//verify the forgot password link
		@Test(priority=6)
		public void ForgotPwdLinkVerification() {
			
			String forgotPwdlink=signinPage.forgotPwdLink();
			System.out.println(forgotPwdlink);
		}
		
		//verify the signUp Link
		@Test(priority=7)
		public void signUpLinkVerification() {
			
			String signUpLink=signinPage.signUpLink();
			System.out.println(signUpLink);
		}
		
		//click on signin with no inputs
		@Test(priority=8)
		public void singinWithoutInputs() throws Throwable {
			
			signinPage.signinWithoutInputs();
		}
		
		
		//click on signin with invalid email 
		@Test(priority=9)
		public void signinWithInvalidEmail() throws Throwable {
			
			signinPage.signinWithInvalidEmail(prop.getProperty("invalidEmail"));
		}
		
		//click on signin with valid email and invalid password
		@Test(priority=10)
		public void validEmailInvalidPwd() throws Throwable {
			
			signinPage.validEmailInvalidPwd(prop.getProperty("illumy_Email"), prop.getProperty("password1"));
		}
		
		//click on signin with valid email and without password
		@Test(priority=11)
		public void validEmailWithoutPwd() throws Throwable {
			signinPage.validEmailWithoutPwd(prop.getProperty("illumy_Email2"));
		}
		
		//verify the eye icon functionality in password field
		@Test(priority=12)
		public void eyeIconValidation() throws Throwable {
			signinPage.eye_Image_Icon(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		}
		
		
		//signin with valid inputs
		@Test(priority=13)
		public void signinWithValidInputs() throws InterruptedException {
			homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		}
			
		@AfterMethod
		public void getStatus(ITestResult result) throws IOException {
			getTestStatus(result);
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
		
}
