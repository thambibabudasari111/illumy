/**
 * 
 */
package com.illumy.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
 *This class is explaining about the complete UI and functionality of "Voice Call" 
 *
 */
public class VoiceCall extends TestBase{

	public static SigninPage signinPage;
	WebDriver firefox;
	Actions action;
	TestUtil testUtil=new TestUtil();
	 
	public VoiceCall() {
		PageFactory.initElements(driver, this);
	}
	
	String chromeAllowImage_Path	= System.getProperty("user.dir")+"/Images/chrome_AllowBtn.png";
	String chromeBlockImage_Path	= System.getProperty("user.dir")+"/Images/blockBtn.png";
	
	String xpath_ConversationList	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String searchBarAutoSugg		= "//*[@class='search_sametxt']//*[@role='option']";
	String xpath_MsgThread			= "//*[contains(@id,'msg_')]";
	String xpath_AtmentionsAutoSugg	= "//*[@class='slimScrollDiv']//*[@role='listbox']//*[@role='option']//a";
	
	
	//Page Factory: OR
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'pho_img')]")
	WebElement voiceCallIcon_HeaderSection;
	
	@FindBy(xpath="//*[@class='call_popup_close_pre_Call']//i")
	WebElement close_ConfirmationsPopup;
	
	@FindBy(xpath="//*[@class='text_overlap width_42vw mart3']//a")
	WebElement userName_P2PHeaderSection;
	
	@FindBy(xpath="//*[text()=' Voice Call ']")
	WebElement voiceCall_ContactsPage;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//following-sibling::*[@class='sear_img']")
	WebElement searchIcon;
	
	@FindBy(xpath="//*[@class='mat-form-field-infix']//*[@role='combobox']")
	WebElement globalSearchField;
	
	@FindBy(xpath="//*[@class='search_sametxt']//*[@role='option']")
	WebElement searchFieldAutoSugg;
	
	@FindBy(xpath="//*[@class='ng-star-inserted']//*[@class='fas fa-phone fa-rotate-90']")
	WebElement voiceCallIcon_SearchAutoSugg;
	
	@FindBy(xpath="//*[@class='col-sm-6 pad_l0']//*[@class='nav nav-tabs']//*[text()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath="//*[@type='button']//i[@class='fas fa-times handCursor close_popup']")
	WebElement closeSearchPopup;
	
	@FindBy(xpath="//*[@class='col-sm-2 seach_words']//*[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//*[@role='button']")
	WebElement menuSprite;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a[@href='/message']")
	WebElement messagingIcon;
	
	
	@FindBy(xpath="//*[text()='Would you like to voice call?']")
	WebElement confirmationPopupTitle;
	
	@FindBy(xpath="//*[@class='profileImgSmall bor_rad_4 1 ng-star-inserted']//div[@class='offnet_username ng-star-inserted']")
	WebElement userAvatar_ConfirmationPopup;
	
	
	@FindBy(xpath="//*[@class='voice_popup_inner']//p[@class='text-primary font16 font-medium']")
	WebElement userName_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='voice_popup_inner']//p[@class='font15 text-black']")
	WebElement userEmail_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='btn btn-deafult']")
	WebElement cancelBtn_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-star-inserted']")
	WebElement callBtn_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='fa fa-microphone font18 ng-star-inserted']")
	WebElement microphone_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='fa fa-volume-up font16 marl25 ng-star-inserted']")
	WebElement speaker_ConfirmationPopup;
	
	@FindBy(xpath="//*[text()='Test']")
	WebElement testLink_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='call_header_txt']")
	WebElement callingStatus_VoiceCallWindow;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='font16 font-medium']")
	WebElement userName_VoiceCallWindow;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='profileImgSmall bor_rad_4 1']")
	WebElement userAvatar_VoiceCallWindow;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//following-sibling::*[@class='call_buttons']//button[@class='end_call ng-star-inserted']")
	WebElement hangUpBtn;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call call_in_process']//following-sibling::*[@class='call_buttons']//button[@class='btn end_call exit_btn']")
	WebElement exitBtn;
	
	@FindBy(xpath="//*[@class='icoming_outgoing_call']//*[@class='call_header_txt']//*[text()='Incoming call']")
	WebElement incomingCall;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn end_call ng-star-inserted']")
	WebElement declineBtn;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']")
	WebElement acceptBtn;
	
	@FindBy(xpath="//*[@class='answred_call_body ng-star-inserted']//*[@id='muteCallButtonOne']")
	WebElement muteBtn;
	
	@FindBy(xpath="//*[@class='text-center relative']//*[@class='btn end_call']")
	WebElement hangUpButtonAfterCallAccept;
	
	@FindBy(xpath="//*[@class='fa fa-microphone-slash font18 ng-star-inserted']")
	WebElement microphoneSlash;
	
	@FindBy(xpath="//*[text()='Your microphone is blocked']")
	WebElement microphoneBlockedValidationMsg;
	
	@FindBy(xpath="//*[@class='text-danger marl10 vert_txt ng-star-inserted']//a")
	WebElement microphoneQuestionMarkLink;
	
	@FindBy(xpath="//*[@class='voicecall_popup flex-design ng-star-inserted']//*[@class='voice_popup_inner']//*[@class='call_popup_close_pre_Call']//i")
	WebElement closePopup;
	
	@FindBy(xpath="//*[@class='answred_call_body ng-star-inserted']//*[@id='muteCallButton']")
	WebElement unmuteBtn;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call call_in_process']//*[@class='call_header_txt']")
	WebElement callNotAnswered;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call call_in_process']//*[@class='font16 font-medium']")
	WebElement userNameAfterDeclineCall;
	
	@FindBy(xpath="//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call call_in_process']//*[@class='profileImgSmall bor_rad_4 1']")
	WebElement userAvatarAfterDeclineCall;
	
	@FindBy(xpath="//*[@class='call_buttons']//*[@class='btn end_call exit_btn']")
	WebElement exitBtnAfterDeclineCall;
	
	@FindBy(xpath="//*[@class='call_hover']//*[@class='incall_label ng-star-inserted']//i[@class='fa fa-phone faa-flash animated']")
	WebElement phoneImage_ConversationList;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement messageInputField;
	
	@FindBy(xpath="//*[@type='button']//*[@class='fa fa-at']")
	WebElement atMentions;
	
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[@role='listbox']//*[@role='option']//a")
	WebElement atMentionsAutoSugg;
	
	//Actions:
	


		
		
	
	//Verify the voice call in the P2P conversation thread 
	public boolean verifyVoiceCall_P2PMsgHeaderSection(String userNameToSelect) throws Throwable {
		boolean voiceCallIcon=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		voiceCallIcon=voiceCallIcon_HeaderSection.isDisplayed();
		thread();
		
		TestUtil.drawBorder(voiceCallIcon_HeaderSection, driver);
		thread();
		voiceCallIcon_HeaderSection.click();
		thread();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		close_ConfirmationsPopup.click();
		thread();
		return voiceCallIcon;	
	}
	
	//Verify the voice call confirmation pop up window UI
		public boolean verifyVoiceCallConfirmationPopup(String userNameToSelect) throws Throwable {
			thread();
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
			thread();
			voiceCallIcon_HeaderSection.click();
			thread();
			String popupTitle=confirmationPopupTitle.getText();
			System.out.println(popupTitle);
			userAvatar_ConfirmationPopup.isDisplayed();
			userName_ConfirmationPopup.isDisplayed();
			userEmail_ConfirmationPopup.isDisplayed();
			cancelBtn_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(cancelBtn_ConfirmationPopup, driver);
			thread();
			callBtn_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(callBtn_ConfirmationPopup, driver);
			thread();
			microphone_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(microphone_ConfirmationPopup, driver);
			thread();
			
			speaker_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(speaker_ConfirmationPopup, driver);
			thread();
			testLink_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(testLink_ConfirmationPopup, driver);
			thread();
			TestUtil.drawBorder(close_ConfirmationsPopup, driver);
			thread();
			close_ConfirmationsPopup.click();
			thread();
			return true;
		}
		
		//Verify the cancel button functionality by clicking on it from the voice call confirmation pop up 
		public void verifyVoiceCall_ClickOnCancelBtn(String userNameToSelect) throws Throwable {
			thread();
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
			thread();
			voiceCallIcon_HeaderSection.click();
			thread();
			cancelBtn_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(cancelBtn_ConfirmationPopup, driver);
			thread();
			cancelBtn_ConfirmationPopup.click();
			thread();
			
		}
		
		//Verify the Test link in the voice call confirmation window
		public void verifyTestLink_PopupWindow(String userNameToSelect) throws Throwable {
			
			thread();
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
			thread();
			voiceCallIcon_HeaderSection.click();
			thread();
			testLink_ConfirmationPopup.isDisplayed();
			TestUtil.drawBorder(testLink_ConfirmationPopup, driver);
			thread();
			testLink_ConfirmationPopup.click();
			thread();
			close_ConfirmationsPopup.click();
			thread();

		}
	
	//Verify the voice call in  contacts page by clicking on the user name at P2P header section
	public boolean verifyVoiceCall_ContactsPage(String userNameToSelect) throws Throwable {
		boolean voiceCallContactsPage=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		userName_P2PHeaderSection.click();
		thread();
		
		voiceCallContactsPage=voiceCall_ContactsPage.isDisplayed();
		TestUtil.drawBorder(voiceCall_ContactsPage, driver);
		thread();
		voiceCall_ContactsPage.click();
		thread();
		close_ConfirmationsPopup.click();
		thread();
		return voiceCallContactsPage;
	}
	
	//Verify the voice call icon by entering the keywords in search field
	public boolean verifyVoiceCall_SearchAutoSugg(String keysToSendInSearchField,String userNameToSelect) throws Throwable {
		boolean voiceCall_SearchAutoSugg=false;
		searchIcon.click();
		thread();
		globalSearchField.sendKeys(keysToSendInSearchField);
		thread();
		TestUtil.mousehoverActions(searchBarAutoSugg, userNameToSelect, voiceCallIcon_SearchAutoSugg);
		thread();
		voiceCall_SearchAutoSugg=voiceCallIcon_SearchAutoSugg.isDisplayed();
		thread();
		TestUtil.drawBorder(voiceCallIcon_SearchAutoSugg, driver);
		thread();
		closeSearchPopup.click();
		thread();
		return voiceCall_SearchAutoSugg;
	}
	
	//Verify voice call icon by clicking on the contacts link in search field
	public boolean verifyVoice_ContactsLink(String keysToSendInSearchField) throws Throwable {
		boolean voiceCallIcon_ContactsList=false;
		searchIcon.click();
		thread();
		globalSearchField.sendKeys(keysToSendInSearchField);
		thread();
		thread();
		
		contactsLink.click();
		contactslink.click();
		thread();
		Actions action=new Actions(driver);
		action.moveToElement(voiceCallIcon_SearchAutoSugg).build().perform();
		thread();
		voiceCallIcon_ContactsList=voiceCallIcon_SearchAutoSugg.isDisplayed();
		thread();
		TestUtil.drawBorder(voiceCallIcon_SearchAutoSugg, driver);
		
		
		closeSearchPopup.click();
		thread();
		menuSprite.click();
		thread();
		messagingIcon.click();
		return voiceCallIcon_ContactsList;
	}
	
	//Verify the voice call window of user2 when user1 make a voice call to user2
		public boolean verifyVoiceCallWindow_CallerEnd(String userNameToSelect) throws Throwable {
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
			thread();
			String incognitochrome=System.getProperty("user.dir");
			
			System.setProperty("webdriver.chrome.driver",incognitochrome+"/Drivers/chromedriver.exe");
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
			
			voiceCallIcon_HeaderSection.click();
			thread();
			callBtn_ConfirmationPopup.click();
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
					TestUtil.drawBorder(declineBtn, incognito);
					thread();
					incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']")).isDisplayed();
					WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
					acceptBtn.isDisplayed();
					action=new Actions(incognito);
					action.moveToElement(acceptBtn).build().perform();
					thread();
					TestUtil.drawBorder(acceptBtn, incognito);
					thread();
					hangUpBtn.click();
					thread();
					incognito.close();
					thread();
					incognito.quit();
					
			return true;
		}
		
		
		//Verify the voice call window of user1 when user1 make voice call to user2
		public boolean verifyVoiceCallWindow_ReceiverEnd(String userNameToSelect) throws Throwable {
			
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
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
			
			voiceCallIcon_HeaderSection.click();
			thread();
			
			callBtn_ConfirmationPopup.click();
			thread();
			
			callingStatus_VoiceCallWindow.isDisplayed();
			userName_VoiceCallWindow.isDisplayed();		
			userAvatar_VoiceCallWindow.isDisplayed();
			thread();
			hangUpBtn.isDisplayed();
			thread();
			action=new Actions(driver);
			action.moveToElement(hangUpBtn).build().perform();
			thread();
			hangUpBtn.click();
			thread();
			
			incognito.close();
			thread();
			incognito.quit();
			
			return true;
		}
		
		
		//Verify the UI of both the user when voice call is accepted 
		public void verifyVoiceCallWindow_IfAccepted(String userNameToSelect,String userToSelect) throws Throwable {
			String afterCallCompleted="";
			String callDuration="";
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
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
			voiceCallIcon_HeaderSection.click();
			thread();
			
			callBtn_ConfirmationPopup.click();
			thread();
		
			WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
			action=new Actions(incognito);
			action.moveToElement(acceptBtn).build().perform();
			thread();
			acceptBtn.click();
			TestUtil.DesktopNotifications(chromeAllowImage_Path);
			thread();
			
			thread();
			
			WebElement mute=incognito.findElement(By.xpath("//*[@class='answred_call_body ng-star-inserted']//*[@id='muteCallButtonOne']"));
			mute.isDisplayed();
			action=new Actions(incognito);
			action.moveToElement(mute).build().perform();
			thread();
			
			
			WebElement hangupButton=incognito.findElement(By.xpath("//*[@class='text-center relative']//*[@class='btn end_call']"));
			hangupButton.isDisplayed();
			action=new Actions(incognito);
			action.moveToElement(hangupButton).build().perform();		
			thread();
			
			WebElement phoneImage=incognito.findElement(By.xpath("//*[@class='call_hover']//*[@class='incall_label ng-star-inserted']//i[@class='fa fa-phone faa-flash animated']"));
			phoneImage.isDisplayed();
			
			
			phoneImage_ConversationList.isDisplayed();
			
			
			muteBtn.isDisplayed();
			action=new Actions(driver);
			action.moveToElement(muteBtn).build().perform();
			thread();
			
			
			hangUpButtonAfterCallAccept.isDisplayed();
			action=new Actions(driver);
			action.moveToElement(hangUpButtonAfterCallAccept).build().perform();
			thread();
			
			hangUpButtonAfterCallAccept.click();
			thread();
			
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
			
			
			List<WebElement>user2MsgThread=incognito.findElements(By.xpath("//*[@class='white-space-pre-wrap message__thread media_call ng-star-inserted']"));
			
			for(int i=0;i<user2MsgThread.size();i++) {
				user2MsgThread.get(i).getText();
				afterCallCompleted="Voice call from "+userToSelect+" completed "+callDuration;
				if(user2MsgThread.get(i).getText().contains(afterCallCompleted)) {
					
					System.out.println(user2MsgThread.get(i).getText());
				}
			}
			
			thread();
			System.out.println();
			
			List<WebElement>user1MsgThread=driver.findElements(By.xpath("//*[@class='white-space-pre-wrap message__thread media_call ng-star-inserted']"));
			
			for(int i=0;i<user1MsgThread.size();i++) {
				user1MsgThread.get(i).getText();
				afterCallCompleted="Voice call to "+userNameToSelect+" completed "+callDuration;
				if(user1MsgThread.get(i).getText().contains(afterCallCompleted)) {
					
					System.out.println(user1MsgThread.get(i).getText());
				}
			}
			
			incognito.close();
			thread();
			incognito.quit();
			
			
			
		}
	
		//Verify the unmute icon by clicking on the mute button 
		public boolean verifyMuteBtn_ClickAction(String userNameToSelect) throws Throwable {
			boolean unmuteButton=false;
			TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
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
			voiceCallIcon_HeaderSection.click();
			thread();
			
			callBtn_ConfirmationPopup.click();
			thread();
			
			WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
			action=new Actions(incognito);
			action.moveToElement(acceptBtn).build().perform();
			thread();
			acceptBtn.click();
			TestUtil.DesktopNotifications(chromeAllowImage_Path);
			thread();
			
			thread();
			
			WebElement mute=incognito.findElement(By.xpath("//*[@class='answred_call_body ng-star-inserted']//*[@id='muteCallButtonOne']"));
			mute.isDisplayed();
			action=new Actions(incognito);
			action.moveToElement(mute).build().perform();
			thread();
			mute.click();
			thread();
			
			WebElement unmuteButton2=incognito.findElement(By.xpath("//*[@class='answred_call_body ng-star-inserted']//*[@id='muteCallButton']"));
			unmuteButton2.isDisplayed();
			
			
			muteBtn.isDisplayed();
			muteBtn.click();
			thread();
			
			 unmuteButton=unmuteBtn.isDisplayed();
			thread();
			
			hangUpButtonAfterCallAccept.click();
			thread();
			incognito.close();
			thread();
			incognito.quit();
			
			return unmuteButton;
			
		}
	
	//Verify if the other user decline the voice call 
	public String verify_VoiceCallDecline(String userNameToSelect,String userToSelect) throws Throwable {
		String actualVoicemail= "";
		String voiceCallDeclinedStatus2="";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
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
		voiceCallIcon_HeaderSection.click();
		thread();
		
		callBtn_ConfirmationPopup.click();
		thread();
		
		WebElement declineBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn end_call ng-star-inserted']"));
		action=new Actions(incognito);
		action.moveToElement(declineBtn).build().perform();
		thread();
		declineBtn.click();
		Thread.sleep(40000);
	

		driver.findElement(By.xpath("//*[@class='text-center relative']//*[@class='btn end_call']")).click(); // End voice call button
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
		thread();
		incognito.quit();
		return actualVoicemail;	
	}
	
	
	//Verify the voice call window if the other user not attending the voice call
	public String verifyVoiceCallWindiow_IfUser2NotAttendCall(String userNameToSelect,String userToSelect) throws Throwable {
		String voiceCallDeclinedStatus2="";
		String actualVoicemail= "";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
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
		
		voiceCallIcon_HeaderSection.click();
		thread();
		
		callBtn_ConfirmationPopup.click();
		thread();
		Thread.sleep(40000);
		
		driver.findElement(By.xpath("//*[@class='text-center relative']//*[@class='btn end_call']")).click(); // End voice call button
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
		
		thread();
		List<WebElement> voicmailList = driver.findElements(By.xpath("//*[contains(@id,'msg_')]//*[contains(@class,'word_wrap')]"));
		actualVoicemail =voicmailList.get(voicmailList.size()-1).getText();
		thread();
		incognito.close();
		thread();
		incognito.quit();
		return actualVoicemail;	
	}
	
	
	//Verify that by Sending the text messages when user 1 and user 2 are in voice call
	
	public boolean sendTextMsgs_DuringVoiceCall(String userNameToSelect,String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
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
		thread();
		
		voiceCallIcon_HeaderSection.click();
		thread();
		
		callBtn_ConfirmationPopup.click();
		thread();
	
		WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
		action=new Actions(incognito);
		action.moveToElement(acceptBtn).build().perform();
		thread();
		acceptBtn.click();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		
		List<WebElement>list=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			try {
				if(list.get(i).getText().contains(userToSelect)) {
					list.get(i).click();
					thread();
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
		String testMsg="This is a test message from user2";
		
		WebElement threadMsg=incognito.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']"));
		threadMsg.sendKeys(testMsg);
		
		threadMsg.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		thread();
		
		List<WebElement>testMessage=incognito.findElements(By.xpath("//*[@class='ng-star-inserted']//*[@class='white-space-pre-wrap message__thread ng-star-inserted']"));
		for(int i=0;i<testMessage.size();i++) {
			testMessage.get(i).getText();
			
			if(testMessage.get(i).getText().contains(testMsg)) {
				System.out.println(testMessage.get(i).getText());
			}
		}
		thread();
		
		System.out.println("===============================");
	
		List<WebElement>testMessage1=driver.findElements(By.xpath("//*[@class='ng-star-inserted']//*[@class='white-space-pre-wrap message__thread ng-star-inserted']"));
		for(int i=0;i<testMessage1.size();i++) {
			testMessage1.get(i).getText();
			
			if(testMessage1.get(i).getText().contains(testMsg)) {
				System.out.println(testMessage1.get(i).getText());
			}	
		}
		incognito.close();
		incognito.quit();
		return true;
	}
	
}
