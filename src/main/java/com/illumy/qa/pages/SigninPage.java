package com.illumy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.illumy.qa.base.TestBase;

public class SigninPage extends TestBase {
	
	
	//Page Factory : OR
	@FindBy(name="email")
	WebElement illumy_email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signin_Btn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signup_link;
	
	@FindBy(xpath="//div[@class='login-box-body login-popup ng-star-inserted']//p[@class='login-box-msg']")
	WebElement welcome_Text;
	
	@FindBy(xpath="//div[@class='login-box-body login-popup ng-star-inserted']//p[@class='msg_txt_box']")
	WebElement signin_to_continue_text;
	
	@FindBy(xpath="//div[@class='group']//input[@id='email']//following-sibling::label[@class='placeholder']")
	WebElement email_placeholder;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']//following-sibling::label[@class='placeholder']")
	WebElement password_placeholder;
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	WebElement forgot_password_link;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']//following-sibling::span[@class='illumy_txt btn ng-star-inserted']//img")
	WebElement password_field_eye_icon;
	
	@FindBy(xpath="//div[@class='group']//input[@name='email']//following-sibling::div[@class='text-danger ng-star-inserted']")
	WebElement email_is_required;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']//following-sibling::div[@class='text-danger ng-star-inserted']")
	WebElement password_is_required;
	
	@FindBy(xpath="//*[text()=' Enter a valid email address. ']")
	WebElement enter_valid_email_validation_message;
	
	@FindBy(xpath="//div[@class='group']//input[@name='password']//following-sibling::div[@class='text-danger ng-star-inserted']")
	WebElement wrong_password_validation_message;
	
	@FindBy(xpath="//*[@class='text-center h2 text-primary']")
	WebElement homepage_welcome_to_illumy;
	
	@FindBy(xpath="//a[@routerlink='/logout']")
	WebElement signOut_Button;
	
	
	
	
	//Initializing the Page Objects:
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	
	public String validateWelcomeText() {
		 return welcome_Text.getText();
	}
	
	public String signinToContinueText() {
		 return signin_to_continue_text.getText();	
	}
	
	public String emailPlaceholder() {
		return email_placeholder.getText();	 
	}
	
	public String passwordPlaceholder() {
		return password_placeholder.getText();	 
	}
	
	public String forgotPwdLink() {
		return forgot_password_link.getText();
	}
	
	public String signUpLink() {
		return signup_link.getText();
	}
	
	//signin with valid inputs
	public HomePage singin(String email,String pwd) throws InterruptedException {
		illumy_email.clear();
		password.clear();
		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		String welcomeHomepage=homepage_welcome_to_illumy.getText();
		System.out.println(welcomeHomepage);
		return new HomePage();
	}
	
	//signin without email and password
	public void signinWithoutInputs() throws Throwable {
		
		signin_Btn.click();
		thread();
		String emailIsRequired=email_is_required.getText();
		System.out.println(emailIsRequired);
		String pwdRequired=password_is_required.getText();
		System.out.println(pwdRequired);	
	}
	
	//click on signin with invalid email id
	public void signinWithInvalidEmail(String email) throws Throwable {
		illumy_email.clear();
		thread();
		illumy_email.sendKeys(email);
		signin_Btn.click();
		
		String Invalid_Email_Error=enter_valid_email_validation_message.getText();
		System.out.println(Invalid_Email_Error);		
	}
	
	//click on signin with valid email and invalid password
	public void validEmailInvalidPwd(String validEmail,String invalidPwd) throws Throwable {
		illumy_email.clear();
		illumy_email.sendKeys(validEmail);
		password.sendKeys(invalidPwd);
		signin_Btn.click();
		String wrongPassword_error=wrong_password_validation_message.getText();
		System.out.println(wrongPassword_error);
	}
	
	//click on signin with valid email and without password
		public void validEmailWithoutPwd(String illumyValidEmail) throws Throwable {
			
			illumy_email.clear();
			password.clear();
			illumy_email.sendKeys(illumyValidEmail);
			signin_Btn.click();
			String pwdRequired=password_is_required.getText();
			System.out.println(pwdRequired);
		}	
		
		//verify the functionality of eye image icon in password field
		public void eye_Image_Icon(String enterEmail,String enterPwd) throws Throwable {
				
			illumy_email.clear();
			illumy_email.sendKeys(enterEmail);
			password.clear();
			password.sendKeys(enterPwd);
			password_field_eye_icon.click();
			System.out.println("Password Eye Icon Is Working Fine");
			

		}
}
