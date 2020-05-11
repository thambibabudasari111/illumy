/**
 * 
 */
package com.illumy.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class HomePage extends TestBase{

	TestUtil testUtil;
	
	Actions action;
	
	
	
	//Page Factory: OR
	@FindBy(name="email")
	WebElement illumy_email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signin_Btn;
	
	@FindBy(xpath="//div[@class='text-center']//following-sibling::div[@class='text-center h3 text-primary']")
	WebElement homepage_welcome_to_illumy;
	
	@FindBy(xpath="//*[@class='col-md-3 noselect']")
	WebElement digitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='menu_drop_txt_sh']//*[@class='text_overlap font_w_7']")
	WebElement username_DigitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='menu_drop_txt_sh']//*[@class='text_overlap email_sm font12 text-default']")
	WebElement emailId_DigitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='menu_drop_txt_sh']//*[@class='text_overlap email_sm font12 text-default ng-star-inserted']")
	WebElement mobileNum_DigitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='My Profile']")
	WebElement myProfile;
	
	@FindBy(xpath="//*[@id='search_3']//*[text()='My Profile']")
	WebElement myProfileView_ContactsPage;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='My Plan i2']")
	WebElement myPlani2;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='My Plan i1']")
	WebElement myPlani1;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='Upgrade']")
	WebElement upgradeLink;
	
	@FindBy(xpath="//*[@class='mat-dialog-title ng-star-inserted']//*[text()='Upgrade My Plan']")
	WebElement upgradePopupTitle;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='Sign out']")
	WebElement signOut;
	
	@FindBy(xpath="//*[@id='search_3']//*[text()='Billing & Plan']")
	WebElement billingAndPlan;
	
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//*[@role='button']")
	WebElement spriteMenu;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a[@href='/message']")
	WebElement messagingIcon;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a[@href='/contact']")
	WebElement contactsIcon;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a[@href='/calendar']")
	WebElement calendarIcon;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a//i[@title='IOS']")
	WebElement IOSIcon;
	
	@FindBy(xpath="//*[@id='menubar']//ul//li//a//i[@title='Android']")
	WebElement androidIcon;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//*[@class='mess_img']")
	WebElement messgingIcon;
	
	@FindBy(xpath="//*[@class='ng-star-inserted']//*[text()='Invite Friends ']")
	WebElement inviteFriendsPopupTitle;
	
	@FindBy(xpath="//*[@type='button']//*[@class='fas fa-times handCursor close_popup']")
	WebElement closeInviteFriendsPopup;
	
	@FindBy(xpath="//*[@class='right_angle_side_call widget_icon']//span")
	WebElement dialPad;
	
	@FindBy(xpath="//*[@class='voicecall_inner_div flex-design']//*[@class='dialpad_inner']//*[@class='btn btn_number']//*[text()='1']")
	WebElement dialPad_Num1;
	
	@FindBy(xpath="//*[@class='voicecall_inner_div flex-design']//*[@class='dialpad_inner']//*[@class='btn btn_number']//*[text()='2']")
	WebElement dialPad_Num2;
	
	@FindBy(xpath="//*[@class='voicecall_inner_div flex-design']//*[@class='dialpad_inner']//*[@class='btn btn_number']//*[text()='3']")
	WebElement dialPad_Num3;
	
	@FindBy(xpath="//*[@class='dialpad_header']//*[@name='dailInput']")
	WebElement dialPadInput;
	
	@FindBy(xpath="//*[@class='dialpad_close text-primary font16']//*[@class='fas fa-times']")
	WebElement closeDialPad;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//following-sibling::*[@class='sear_img']")
	WebElement searchIcon;
	
	@FindBy(xpath="//*[@placeholder='Search for messages, contacts, and groups']")
	WebElement searchFieldPlaceholders;
	
	@FindBy(xpath="//div[@class='compose_btn_div']//*[contains(@class,'compose_messg btn')]")
	WebElement composeMessageBtn;
	
	@FindBy(xpath="//*[text()=' Compose Message ']")
	WebElement composeMsgWindowTitle;
	
	@FindBy(xpath="//*[@class='flex-design mar10vh']//*[contains(@src,'assets/images/dashboard_img.png')]")
	WebElement middlePanleImage;
	
	@FindBy(xpath="//*[@class='text-center h2 text-primary']")
	WebElement welcomeToillumyText;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Files']")
	WebElement files;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Flags']")
	WebElement flags;
	
	@FindBy(xpath="//*[@class='mat-expansion-indicator ng-tns-c13-10 ng-trigger ng-trigger-indicatorRotate ng-star-inserted']")
	WebElement arrowAtFlagSection;
	
	@FindBy(xpath="//*[@style='transform: rotate(180deg);']")
	WebElement arrowOpenStatus;
	
	@FindBy(xpath="//*[@style='transform: rotate(0deg);']")
	WebElement arrowCloseStatus;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Calendar']")
	WebElement calendar;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Friend Suggestions']")
	WebElement friendSuggestions;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()=' See more ']")
	WebElement seeMoreLink;
	
	@FindBy(xpath="//*[@class='ng-star-inserted']//*[text()=' Friend Suggestions ']")
	WebElement friendSuggPopup;
	
	@FindBy(xpath="//*[@id='click-spanish']")
	WebElement hideAndShowWidgets;
	
	@FindBy(xpath="//*[@id='click-spanish']//*[@class='fa fa-caret-right']")
	WebElement hideWigets;
	
	@FindBy(xpath="//*[@class='fa fa-caret-left']")
	WebElement showWidgets;
	
	
	//Initializing the Page Objects :
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions :
		
	//Verify the title of the home page
	public String VerifyHomePageTitle() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle();	
	}
	
	//Verifying the digital identity panel
	public boolean verifyDigitalIdentityPanel() {
		return digitalIdentityPanel.isDisplayed();
	}
	
	//Verify the user name by clicking on the user avatar in digital identity panel
	public boolean verify_UserName_DigitalIdentityPanel() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		return username_DigitalIdentityPanel.isDisplayed();
	}
	
	//Verifying the email id by clicking on the user avatar in digital identity panel
	public boolean verify_EmailId_DigitalIdentityPanel() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		thread();
		return emailId_DigitalIdentityPanel.isDisplayed();
	}
	

	
	//Verifying my profile by clicking on it navigating to illumy contacts page
	public String verify_MyProfile() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		myProfile.isDisplayed();
		myProfile.click();
		thread();
		myProfileView_ContactsPage.isDisplayed();
		
		return driver.getTitle();
	}
	
	//Verifying setting in digital identity panel
	public String verify_Settings() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		settings.isDisplayed();
		settings.click();
		thread();
		return driver.getTitle();
	}
	
	//Verify the my plan i1 in digital identity panel
	public boolean verify_myPlani1() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		myPlani1.isDisplayed();
		myPlani1.click();
		thread();
		return billingAndPlan.isDisplayed();
		
	}
	
	//Verify the upgrade link in the my plan i1 
	public boolean verify_UpgradeLink() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		upgradeLink.click();
		thread();
		return upgradePopupTitle.isDisplayed();
	}
	
	//Verifying the sign out link in digital identity panel
	public String verify_SignOut() throws Throwable {
		digitalIdentityPanel.click();
		thread();
		signOut.isDisplayed();
		signOut.click();
		thread();
		return driver.getTitle();
	}
	
	//Verifying the sprite menu in home page
	public boolean verify_SpriteMenu() throws Throwable {
		spriteMenu.isDisplayed();
		spriteMenu.click();
		thread();
		messagingIcon.isDisplayed();
		contactsIcon.isDisplayed();
		calendarIcon.isDisplayed();
		IOSIcon.isDisplayed();
		androidIcon.isDisplayed();
		
		return true;
	}
	
	//Verify the functionality of contacts link in the sprite menu
	public String verify_ContactsIcon() throws Throwable {
		spriteMenu.click();
		thread();
		contactsIcon.isDisplayed();
		contactsIcon.click();
		thread();
		
		return driver.getTitle();
		
	}
	
	//Verify the functionality of messaging icon in the sprite menu
	public String verify_MessagingIcon() throws Throwable {
		spriteMenu.click();
		thread();
		messagingIcon.isDisplayed();
		messagingIcon.click();
		thread();
		return driver.getTitle();
	}
	
	//Verify the functionality of calendar icon in the sprite menu
	public String verify_CalendarIcon() throws Throwable {
		spriteMenu.click();
		thread();
		calendarIcon.isDisplayed();
		calendarIcon.click();
		
		return driver.getTitle();
	}
	
	//Verifying the IOS icon in the sprite menu
	public String veriyf_IOSIcon() throws Throwable {
		spriteMenu.click();
		thread();
		IOSIcon.isDisplayed();
		IOSIcon.click();
		thread();
		
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window ID: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window ID: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		thread();
		
		String iosPageTitle=driver.getTitle();
		
		
		driver.close();
		thread();
		driver.switchTo().window(parentWindowId);

		return iosPageTitle;
	}
	
	//Verify the android icon in the sprite menu
	public String verify_AndroidIcon() throws Throwable {
		spriteMenu.click();
		thread();
		androidIcon.isDisplayed();
		androidIcon.click();
		thread();
		
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window ID: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window ID: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		thread();
		
		String androidPageTitle=driver.getTitle();
		
		
		driver.close();
		thread();
		driver.switchTo().window(parentWindowId);

		return androidPageTitle;
	}
	
	//Verify the message icon in the home page
	public boolean verifyMessagingIcon() throws Throwable {
		return messgingIcon.isDisplayed();
	}
	
	//Verify the dial pad in the home page
	public boolean verify_DialPad() throws Throwable {
		dialPad.isDisplayed();
		dialPad.click();
		thread();
		dialPad_Num1.click();
		thread();
		dialPad_Num2.click();
		thread();
		dialPad_Num3.click();
		thread();
		dialPadInput.clear();
		thread();
		closeDialPad.click();
		
		return true;
	}
	
	//Verify the search field in the home page
	public boolean verify_SearchField() throws Throwable {
		searchIcon.isDisplayed();
		searchIcon.click();
		thread();
		
		return searchFieldPlaceholders.isDisplayed();
	}
	
	//Verify the compose message in the home page
	public String verify_ComposeMessage() throws Throwable {
		composeMessageBtn.isDisplayed();
		composeMessageBtn.click();
		thread();
		
		return composeMsgWindowTitle.getText();
	}
	
	//Verify the conversation list in the home page at the left panel
	public void verify_ConversationList() {
		
		List<WebElement>conversationList=driver.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		System.out.println(conversationList.size());
		for(int i=0;i<conversationList.size();i++) {
			System.out.println(conversationList.get(i).getText());
			
		}
		
	}
	
	//Verifying the middle panel in home page
	public boolean verify_MiddlePanel() {
		
		middlePanleImage.isDisplayed();
		return welcomeToillumyText.isDisplayed();
	}
	
	//Verify the files section in the third panel of the home page screen
	public boolean verify_Files() throws InterruptedException {
		
		try{
			if(!files.isDisplayed()) {
				thread();
				showWidgets.click();
				
			}
			else if(files.isDisplayed()) {
				Thread.sleep(3000);
				files.click();
				thread();
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verifying the flags section in the third panel of the home page screen 
	public boolean verify_Flags() throws Throwable {
		
		try{
			if(!flags.isDisplayed()) {
				thread();
				showWidgets.click();
				
			}
			else if(flags.isDisplayed()) {
				Thread.sleep(3000);
				flags.click();
				thread();
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verifying the calendar section in the third panel of the home page
	public boolean verify_Calendar() throws Throwable {
		
		try{
			if(!calendar.isDisplayed()) {
				thread();
				showWidgets.click();
				
			}
			else if(calendar.isDisplayed()) {
				Thread.sleep(3000);
				calendar.click();
				thread();
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
			
		return true;	
		
	}
	
	//Verifying the friend suggestions in the third panel of the home page
	public boolean verify_FriendSuggestions() throws Throwable {
		
		try{
			if(!friendSuggestions.isDisplayed()) {
				thread();
				showWidgets.click();
				
			}
			else if(friendSuggestions.isDisplayed()) {
				Thread.sleep(3000);
				friendSuggestions.click();
				thread();
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;	
	}
	
	//Verifying the see more in friend suggestion of the home page
	public boolean verify_SeeMoreLink() throws Throwable {
		
		try{
			if(!seeMoreLink.isDisplayed()) {
				thread();
				showWidgets.click();
				
			}
			else if(seeMoreLink.isDisplayed()) {
				Thread.sleep(3000);
				seeMoreLink.click();
				thread();				
				
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

