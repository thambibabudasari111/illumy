/**
 * 
 */
package com.illumy.qa.pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class VoicemailSettings extends TestBase{

	public  SigninPage signinPage;
	public  HomePage homePage;
	
	
	
	String xpath_ConversationList	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String chromeAllowImage_Path	= System.getProperty("user.dir")+"/Images/chrome_AllowBtn.png";
	
	//Initializing the page objects:
	public VoicemailSettings() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//Page Factory: OR (Object Repository)
	//Buttons and Icons:
	@FindBy(xpath = "//*[@class='col-md-3 noselect']")
	WebElement digitalIdentityPanel;

	@FindBy(xpath = "//*[@class='pulldown_nav']//*[text()='Settings']")
	WebElement settings;
	
	
	@FindBy(xpath = "//*[contains(@class,'users-list')]//*[text()='Voicemail']")
	WebElement voiceCall;
	
	@FindBy(xpath="//*[contains(@class,'middle ')]//*[text()='Voicemail']")
	WebElement voicemailHeader;
	
	@FindBy(xpath="//*[text()='Enable voicemail']")
	WebElement enableVoicemailTxt;
	
	@FindBy(xpath="//*[text()='Enable voicemail']//preceding-sibling::*[contains(@class,'checked mat-disabled')]")
	WebElement enableVoicemailToggle;
	
	@FindBy(xpath="//*[text()='Enable voicemail transcription']")
	WebElement enableVoicemailTransTxt;
	
	@FindBy(xpath="//*[text()='Enable voicemail transcription']//preceding-sibling::*[contains(@class,'mat-slide-toggle mat-primary')]//*[contains(@class,'toggle-thumb-container')]//*[@class='mat-slide-toggle-thumb']")
	WebElement voicemailTranscDisableToggle;
	
	@FindBy(xpath="//*[text()='Upgrade My Plan']")
	WebElement upgradeMyPlanPopup;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn end_call ng-star-inserted']")
	WebElement declineBtn;
	
	@FindBy(xpath="//*[text()='Sign out']")
	WebElement signout;
	
	@FindBy(name="email")
	WebElement illumy_email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signin_Btn;
	
	@FindBy(xpath="//*[text()='Enable voicemail transcription']//preceding-sibling::*[@class='mat-slide-toggle mat-primary']//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'toggle-thumb')]")
	WebElement enableVoicemailTransDisableToggle;
	
	@FindBy(xpath="//*[text()='Enable voicemail transcription']//preceding-sibling::*[contains(@class,'checked')]//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'toggle-thumb')]")
	WebElement enableVoicemailTransEnableToggle;
	
	
	//Actions:
	
	//Verify the voicemail option in the settings
	public boolean verifyVoicemailInSettings() {
		digitalIdentityPanel.click();
		settings.click();
		return voiceCall.isDisplayed();
	}
	
	//Verify the URL of the voicemail in the browser when clicking on the voicemail option from the settings
	public String verifyURLOfVoicemail() {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return driver.getCurrentUrl();
	}
	
	//Verify the header of the voicemail in the middle panel
	public String verifyVoicemailHeader() {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return voicemailHeader.getText();
	}
	
	//Verify the "Enable voicemail" text in the voicemail settings
	public String verifyEnableVoicemailText() {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailTxt.getText();
	}
	
	//Verify the "Enable voicemail" toggle is in enabled mode or not by default
	public boolean verifyi1UserEnableVoicemailDefaultToggle() {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailToggle.isDisplayed();
	}
	
	//Verify the text "Enable voicemail transcription" in the voicemail settings
	public boolean verifyEnableVoicemailTransText() {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailTransTxt.isDisplayed();
	}
	
	//Verify the toggle of "Enable voicemail transcription" is in disable mode or not by default.
	public boolean verifyEnableVoicemailTranscDefaultToggle() {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return voicemailTranscDisableToggle.isDisplayed();
	}
	
	//Verify the "Enable voicemail transcription" toggle click action for i1 user, when the toggle is in disable mode
	public boolean clickOnEnableVoicemailTransToggle() throws InterruptedException {
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		voicemailTranscDisableToggle.click();
		thread();
		return upgradeMyPlanPopup.isDisplayed();
	}
	
	//Verify the voicemail in P2P message thread, when user is not answered the voice call of other users
	public String verifyVoicemail_UserNotAnsVoiceCall(String oppUser,String userToSelect) throws Throwable {
		String actualVoicemail= "";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito=new ChromeDriver(options);
		
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumy_Email5"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement> conversationList = incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppUser)) {
				
				conversationList.get(i).click();
			}
		}
		thread();
		thread();
		incognito.findElement(By.xpath("//*[@type='button']//*[contains(@class,'pho_img')]")).click(); //voice call icon at header section in the middle panel
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		incognito.findElement(By.xpath("//*[@class='btn btn-primary ng-star-inserted']")).click(); //Call button in the voice call confirmation pop up
		Thread.sleep(40000);
		incognito.findElement(By.xpath("//*[@class='text-center relative']//*[@class='btn end_call']")).click(); // End call button 
		incognito.close();
		Thread.sleep(10000);
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		
		return actualVoicemail;	
	}
	
	//Verify the voicemail in P2P message thread, when user is declined the voice call of other users
	public String verifyVoicemail_UserDeclinedVoiceCall(String oppUser, String userToSelect) throws Throwable {
		String actualVoicemail= "";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito=new ChromeDriver(options);
		
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumy_Email5"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement> conversationList = incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppUser)) {
				
				conversationList.get(i).click();
			}
		}
		thread();
		thread();
		incognito.findElement(By.xpath("//*[@type='button']//*[contains(@class,'pho_img')]")).click(); //voice call icon at header section in the middle panel
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		incognito.findElement(By.xpath("//*[@class='btn btn-primary ng-star-inserted']")).click(); //Call button in the voice call confirmation pop up
		Thread.sleep(3000);
		declineBtn.click();
		thread();
		Thread.sleep(40000);
		incognito.findElement(By.xpath("//*[@class='text-center relative']//*[@class='btn end_call']")).click(); // End voice call button 
		incognito.close();
		Thread.sleep(10000);
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		
		return actualVoicemail;	
	}
	
	//Verify the voicemail in P2P message thread, when user is not answered the video call of other users
	public String verifyVoicemail_UserNotAnsVideoCall(String oppUser,String userToSelect) throws Throwable {
		String actualVoicemail= "";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito=new ChromeDriver(options);
		
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumy_Email5"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement> conversationList = incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppUser)) {
				
				conversationList.get(i).click();
			}
		}
		thread();
		thread();
		incognito.findElement(By.xpath("//*[@type='button']//*[contains(@class,'vid_img')]")).click(); //video call icon at header section in the middle panel
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		incognito.findElement(By.xpath("//*[@class='btn btn-primary ng-star-inserted']")).click(); //Call button in the video call confirmation pop up
		Thread.sleep(40000);
		incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[contains(@class,'video end_call_hang')]")).click(); // End video call button 
		incognito.close();
		Thread.sleep(10000);
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		
		return actualVoicemail;	
	}
	
	//Verify the voicemail in P2P message thread, when user is declined the video call of other users
	public String verifyVoicemail_UserDeclinedVideoCall(String oppUser,String userToSelect) throws Throwable {
		String actualVoicemail= "";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito=new ChromeDriver(options);
		
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumy_Email5"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement> conversationList = incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppUser)) {
				
				conversationList.get(i).click();
			}
		}
		thread();
		thread();
		incognito.findElement(By.xpath("//*[@type='button']//*[contains(@class,'vid_img')]")).click(); //video call icon at header section in the middle panel
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		incognito.findElement(By.xpath("//*[@class='btn btn-primary ng-star-inserted']")).click(); //Call button in the video call confirmation pop up
		Thread.sleep(3000);
		declineBtn.click();
		thread();
		Thread.sleep(40000);
		incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[contains(@class,'video end_call_hang')]")).click(); // End video call button 
		incognito.close();
		Thread.sleep(10000);
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		
		return actualVoicemail;	
	}
	
	//Verify the "Enable voicemail" toggle is in restricted or not by default in the voicemail settings of i2 user
	public boolean verifyi2UserEnableVoicemailDefaultToggle(String email, String pwd) throws Throwable {
		digitalIdentityPanel.click();
		signout.click();

		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailToggle.isDisplayed();
	}
	
	//Verify the toggle of "Enable voicemail transcription" is in disable mode or not by default.
	public boolean verifyi2UserEnableVoicemailTransDefaultToggle(String email, String pwd) throws Throwable {
		digitalIdentityPanel.click();
		signout.click();

		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailTransDisableToggle.isDisplayed();
	}
	
	//Verify the "Enable voicemail transcription" toggle click action for i2 user, when the toggle is in disable mode
	public boolean clicki2UserEnableVoicemailTransToggle(String email, String pwd) throws Throwable {
		digitalIdentityPanel.click();
		signout.click();

		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		enableVoicemailTransDisableToggle.click();
		thread();
		boolean enableToggle = enableVoicemailTransEnableToggle.isDisplayed();
		enableVoicemailTransEnableToggle.click();
		thread();
		return enableToggle;
	}
	
	//Verify the "Enable voicemail" toggle is in restricted or not by default in the voicemail settings of i3 user
	public boolean verifyi3UserEnableVoicemailDefaultToggle(String email, String pwd) throws Throwable {
		digitalIdentityPanel.click();
		signout.click();

		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailToggle.isDisplayed();
	}
	
	//Verify the toggle of "Enable voicemail transcription" is in disable mode or not by default.
	public boolean verifyi3UserEnableVoicemailTransDefaultToggle(String email, String pwd) throws Throwable {
		digitalIdentityPanel.click();
		signout.click();

		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		return enableVoicemailTransDisableToggle.isDisplayed();
	}
	
	//Verify the "Enable voicemail transcription" toggle click action for i3 user, when the toggle is in disable mode
	public boolean clicki3UserEnableVoicemailTransToggle(String email, String pwd) throws Throwable {
		digitalIdentityPanel.click();
		signout.click();

		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		digitalIdentityPanel.click();
		settings.click();
		voiceCall.click();
		enableVoicemailTransDisableToggle.click();
		thread();
		boolean enableToggle = enableVoicemailTransEnableToggle.isDisplayed();
		enableVoicemailTransEnableToggle.click();
		thread();
		return enableToggle;
	}
	
}
