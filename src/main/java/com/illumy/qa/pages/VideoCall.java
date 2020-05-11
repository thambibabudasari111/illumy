/**
 * 
 */
package com.illumy.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 * 
 */
 
public class VideoCall extends TestBase{
	
	
	Actions action=new Actions(driver);
	
	public VideoCall() {
		PageFactory.initElements(driver, this);
	}
	
	String xpath_ConversationList		= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String searchBarAutoSugg			= "//*[@class='search_sametxt']//*[@role='option']";
	String chromeAllowImage_Path		= System.getProperty("user.dir")+"/Images/chrome_AllowBtn.png";
	String chromeBlockImage_Path		= System.getProperty("user.dir")+"/Images/blockBtn.png";
	
	
	//Page Factory : OR
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'vid_img')]")
	WebElement videoCallIcon_HeaderSection;
	
	@FindBy(xpath="//*[@class='text_overlap width_42vw mart3']//a")
	WebElement userName_P2PHeaderSection;
	
	@FindBy(xpath="//*[text()=' Video Call ']")
	WebElement videoCallBtn_ContactsPage;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//following-sibling::*[@class='sear_img']")
	WebElement searchIcon;
	
	@FindBy(xpath="//*[@class='mat-form-field-infix']//*[@role='combobox']")
	WebElement globalSearchField;
	
	@FindBy(xpath="//*[@class='ng-star-inserted']//*[@class='fas fa-video']")
	WebElement videoCallIcon_SearchAutoSugg;
	
	@FindBy(xpath="//*[@type='button']//i[@class='fas fa-times handCursor close_popup']")
	WebElement closeSearchPopup;
	
	@FindBy(xpath="//*[@class='col-sm-2 seach_words']//*[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@class='col-sm-6 pad_l0']//*[@class='nav nav-tabs']//*[text()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//*[@role='button']")
	WebElement spriteMenu;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a[@href='/message']")
	WebElement messagingIcon;
	
	@FindBy(xpath="//*[text()='Would you like to video call?']")
	WebElement videoCallConfirmationPopupTitle;
	
	@FindBy(xpath="//*[@class='row ng-star-inserted']//*[@class='profileImgSmall bor_rad_4 1']")
	WebElement userAvatar_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='voice_popup_inner']//p[@class='text-primary font16 font-medium']")
	WebElement userName_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='voice_popup_inner']//p[@class='font15 text-black']")
	WebElement userEmail_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='btn btn-deafult']")
	WebElement cancelBtn_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-star-inserted']")
	WebElement callBtn_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='fa fa-microphone font18 ng-star-inserted']")
	WebElement microphone_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='fa fa-volume-up font16 marl25 ng-star-inserted']")
	WebElement speaker_VideoCallPopup;
	
	@FindBy(xpath="//*[text()='Test']")
	WebElement testLink_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='call_popup_close_pre_Call']//i")
	WebElement close_VideoCallPopup;
	
	@FindBy(xpath="//*[text()='Playing...']")
	WebElement playingText;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='call_header_txt']")
	WebElement callingStatus_VideoCallWindow;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='font16 font-medium']")
	WebElement userName_VideoCallWindow;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='profileImgSmall bor_rad_4 1']")
	WebElement userAvatar_VideoCallWindow;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//following-sibling::*[@class='call_buttons']//button[@class='end_call ng-star-inserted']")
	WebElement hangUpBtn;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call call_in_process']//*[@class='call_header_txt']")
	WebElement callNotAnswered;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call call_in_process']//*[@class='font16 font-medium']")
	WebElement userName_CallNotAnswer;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call call_in_process']//*[@class='profileImgSmall bor_rad_4 1']")
	WebElement userAvatar_CallNotAnswer;
	
	@FindBy(xpath="//*[@class='call_buttons']//*[@class='btn end_call exit_btn']")
	WebElement exitBtn;
	
	@FindBy(xpath="//*[@class='video_call_btns']//*[@class='btn btn-black-video videoexpand_icon']")
	WebElement maximizeBtn;
	
	@FindBy(xpath="//*[@class='video_call_btns']//*[@class='btn btn-black-video ng-star-inserted'][1]")
	WebElement audioMuteBtn;
	
	@FindBy(xpath="//*[@class='video_call_btns']//*[@class='btn btn-black-video ng-star-inserted'][2]")
	WebElement videoMuteBtn;
	
	@FindBy(xpath="//*[@class='video_call_btns']//*[@class='btn btn-black-video end_call_hang']")
	WebElement videoHangupBtn;
	
	@FindBy(xpath="//*[@class='incall_label video_incall ng-star-inserted']//*[@class='fa fa-video faa-flash animated']")
	WebElement videoCallStatus_ConversationList;
	
	
	//Actions:
	
	//Verify the video call in header section of P2P message thread
	public boolean verifyVideoCall_P2PMsgHeaderSection(String userNameToSelect) throws Throwable {
		boolean videoCallIcon=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon=videoCallIcon_HeaderSection.isDisplayed();
		TestUtil.drawBorder(videoCallIcon_HeaderSection, driver);
		thread();
		action.moveToElement(videoCallIcon_HeaderSection).build().perform();
		thread();
		
		return videoCallIcon;
	}
	
	//Verify the video call in  contacts page by clicking on the user name at P2P message thread header section
	public boolean verifyVideoCall_ContactsPage(String userNameToSelect) throws Throwable {
		boolean videoCall_ContactPage=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		userName_P2PHeaderSection.click();
		thread();
		videoCall_ContactPage=videoCallBtn_ContactsPage.isDisplayed();
		TestUtil.drawBorder(videoCallBtn_ContactsPage, driver);
		thread();
		action.moveToElement(videoCallBtn_ContactsPage).build().perform();
		thread();
		
		return videoCall_ContactPage;
	}
	
	//Verify the video call icon by entering the keywords in search field
	public boolean verifyVideoCall_SeacrFieldAutoSugg(String keysToSendInSearchField,String userNameToSelect) throws Throwable {
		boolean videoCallBtn_SearchAutoSugg=false;
		searchIcon.click();
		thread();
		globalSearchField.sendKeys(keysToSendInSearchField);
		thread();
		TestUtil.mousehoverActions(searchBarAutoSugg, userNameToSelect, videoCallIcon_SearchAutoSugg);
		thread();
		videoCallBtn_SearchAutoSugg=videoCallIcon_SearchAutoSugg.isDisplayed();
		thread();
		TestUtil.drawBorder(videoCallIcon_SearchAutoSugg, driver);
		thread();
		closeSearchPopup.click();
		
		return videoCallBtn_SearchAutoSugg;	
	}
	
	//Verify voice call icon by clicking on the contacts link from search field by entering keywords
	public boolean verifyVideoCall_ClickingContactsLink(String keysToSendInSearchField) throws InterruptedException {
		boolean videoCallBtn_ContactsList=false;
		thread();
		searchIcon.click();
		thread();
		globalSearchField.sendKeys(keysToSendInSearchField);
		thread();
		
		contactsLink.click();
		contactslink.click();
		thread();
		action.moveToElement(videoCallIcon_SearchAutoSugg).build().perform();
		thread();
		videoCallBtn_ContactsList=videoCallIcon_SearchAutoSugg.isDisplayed();
		TestUtil.drawBorder(videoCallIcon_SearchAutoSugg, driver);
		thread();
		closeSearchPopup.click();
		thread();
		spriteMenu.click();
		thread();
		messagingIcon.click();
		
		return videoCallBtn_ContactsList;
	}
	
	//Verify the video call confirmation pop up window UI
	public boolean verifyVideoCallConfirmationPopUp(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		String videocallPopupTitle=videoCallConfirmationPopupTitle.getText();
		System.out.println(videocallPopupTitle);
		userAvatar_VideoCallPopup.isDisplayed();
		userName_VideoCallPopup.isDisplayed();
		userEmail_VideoCallPopup.isDisplayed();
		cancelBtn_VideoCallPopup.isDisplayed();
		thread();
		callBtn_VideoCallPopup.isDisplayed();
		thread();
		microphone_VideoCallPopup.isDisplayed();
		speaker_VideoCallPopup.isDisplayed();
		testLink_VideoCallPopup.isDisplayed();
		close_VideoCallPopup.isDisplayed();
		thread();
		close_VideoCallPopup.click();
		
		return true;	
	}
	
	//Verify the cancel button functionality in the video call confirmation pop up window
	public void verifyCancelBtnFunctionality(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		TestUtil.drawBorder(cancelBtn_VideoCallPopup, driver);
		thread();
		cancelBtn_VideoCallPopup.click();
		thread();
		
	}
	
	//Verify the test link in the video call confirmation pop up window
	public boolean verifyTestLinkFunctionality(String userNameToSelect) throws Throwable {
		boolean palying=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		testLink_VideoCallPopup.click();
		Thread.sleep(1000);
		palying=playingText.isDisplayed();
		cancelBtn_VideoCallPopup.click();
		return palying;
	}
	
	//Verify the video call window at third panel of user1 and user2 when user1 making voice call to user2
	public boolean verifyVideoCallWindow_User1CallToUser2(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		
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
		callBtn_VideoCallPopup.click();
		callingStatus_VideoCallWindow.isDisplayed();
		String userNameofUser2=userName_VideoCallWindow.getText();
		if(userName_VideoCallWindow.equals(userNameToSelect)) {
			System.out.println(userNameofUser2);
		}
		userAvatar_VideoCallWindow.isDisplayed();
		hangUpBtn.isDisplayed();
		action.moveToElement(hangUpBtn).build().perform();
		thread();
		
		//incognito chrome elements
		incognito.findElement(By.xpath("//*[@class='icoming_outgoing_call']//*[@class='call_header_txt']//*[text()='Incoming call']")).isDisplayed();
		incognito.findElement(By.xpath("//*[@class='icoming_outgoing_call']//*[@class='font16 font-medium']")).isDisplayed();		
		incognito.findElement(By.xpath("//*[@class='icoming_outgoing_call']//*[@class='profileImgSmall bor_rad_4 1']")).isDisplayed();
		incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn end_call ng-star-inserted']")).isDisplayed();
				
				WebElement declineBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn end_call ng-star-inserted']"));
				action=new Actions(incognito);
				action.moveToElement(declineBtn).build().perform();
				thread();
			
				incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']")).isDisplayed();
				WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
				acceptBtn.isDisplayed();
				action=new Actions(incognito);
				action.moveToElement(acceptBtn).build().perform();
				thread();
				
				hangUpBtn.click();
				thread();
				incognito.close();
				incognito.quit();
				
		return true;
	}
	
	//Verify the video call window if the user2 not answered the video call
	public String verifyVideoCall_User2NotAnsweredCall(String userNameToSelect,String userToSelect) throws Throwable {
		String actualVoicemail= "";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		
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
		
		callBtn_VideoCallPopup.click();
		thread();
		Thread.sleep(40000);
		driver.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[contains(@class,'video end_call_hang')]")).click(); // End video call button 
		Thread.sleep(10000);
		List<WebElement>list=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			try {
				if(list.get(i).getText().contains(userToSelect)) {
					list.get(i).click();
					thread();
					break;
			}
			
			}catch(StaleElementReferenceException e) {
				
				list=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
					if(list.get(i).getText().contains(userToSelect)) {
						list.get(i).click();
						thread();
						break;
				}
			}
		}
		thread();
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		incognito.close();
		incognito.quit();
		return actualVoicemail;	
			
	}
	
	//Verify the video call if the user2 declined the call of user1
	public String verifyVideoCall_User2DeclineCall(String userNameToSelect,String userToSelect) throws Throwable {
		String actualVoicemail= "";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		
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
		
		callBtn_VideoCallPopup.click();
		thread();
		thread();
		
		WebElement declineBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn end_call ng-star-inserted']"));
		action=new Actions(incognito);
		action.moveToElement(declineBtn).build().perform();
		thread();
		declineBtn.click();
		Thread.sleep(40000);
		driver.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[contains(@class,'video end_call_hang')]")).click(); // End video call button 
		Thread.sleep(10000);
		List<WebElement>list=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			try {
				if(list.get(i).getText().contains(userToSelect)) {
					list.get(i).click();
					thread();
					break;
			}
			
			}catch(StaleElementReferenceException e) {
				
				list=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
					if(list.get(i).getText().contains(userToSelect)) {
						list.get(i).click();
						thread();
						break;
				}
			}
		}
		thread();
		
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		incognito.close();
		incognito.quit();
		return actualVoicemail;	
	}
	
	//Verify the video call window of both the users when accepted the video call 
	public void verifyVideoCall_IfCallAccepted(String userNameToSelect,String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		options.addArguments("--allow-file-access-from-files");
		options.addArguments("--use-fake-ui-for-media-stream");
		options.addArguments("--use-fake-device-for-media-stream");
		options.addArguments("--allow-file-access");
		options.addArguments("--use-file-for-fake-video-capture=C:\\Users\\thambibabu.dasari\\Downloads\\grandma_qcif (1).y4m");
		WebDriver incognito=new ChromeDriver(options);
	
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumy_Email5"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		
		callBtn_VideoCallPopup.click();
		thread();
		thread();
		
		incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']")).click();
		thread();
		
	}
	

}
