

/**
 * 
 */
package com.illumy.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 *
 *
 */
public class ConversationList extends TestBase{

	public ConversationList(){
		PageFactory.initElements(driver, this);
	}
	
	
	String xpath_ConversationList	= "//*[@class='slimScrollDiv']//*[@id='conversation_slim']//ul[contains(@class,'users-list')]//li[contains(@class,'users_div')]//a//*[@class='media-body users-list-name no-margin ng-star-inserted']";
	String chromeAllowImage_Path	= System.getProperty("user.dir")+"/Images/chrome_AllowBtn.png";


	//Page Factory: OR
	@FindBy(xpath="//*[@id='user_conversation_']")
	WebElement messageThread;
	
	
	@FindBy(xpath="//span[@class='media-body users-list-name no-margin ng-star-inserted']")
	WebElement conversationList;
	
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[@class='conversation_slim conversation__height']")
	WebElement conversationListHeight;
	
	@FindBy(xpath="//*[@type='button']//*[@class='star_img']")
	WebElement favSymbol;
	
	@FindBy(xpath="//*[@class='fa-star far']")
	WebElement favContact;
	
	@FindBy(xpath="//*[@class='fas fa-circle']")
	WebElement onlineStatus;
	
	@FindBy(xpath="//*[@class='fa-star fa far']")
	WebElement favContact_OnlineStatus;
	
	@FindBy(xpath="//*[@class='conversation typing-indicator ng-star-inserted']")
	WebElement typingStatus;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	@FindBy(xpath="//*[@data-target='#menubar']")
	WebElement spriteMenu;
	
	@FindBy(xpath="//*[@id='menubar']//*[@href='/contact']")
	WebElement contactsIcon;
	
	@FindBy(xpath="//*[@class='text_overlap width_42vw mart3']//a")
	WebElement user_MsgThreadHeader;
	
	@FindBy(xpath="//*[text()=' Send Message ']")
	WebElement sendMsgIcon;

	@FindBy(xpath="//*[@type='button']//*[contains(@class,'pho_img ')]")
	WebElement voiceCallIcon_HeaderSection;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-star-inserted']")
	WebElement callBtn_ConfirmationPopup;
	
	@FindBy(xpath="//*[@class='incall_label ng-star-inserted']//*[contains(@class,'fa fa-phone')]")
	WebElement voiceCallSym_ConversationList;
	
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'vid_img')]")
	WebElement videoCallIcon_HeaderSection;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-star-inserted']")
	WebElement callBtn_VideoCallPopup;
	
	@FindBy(xpath="//*[@class='badge badge-danger handCursor red-badge']")
	WebElement unreadCount_Atmention;
	
	@FindBy(xpath="//*[@class='incall_label video_incall ng-star-inserted']//*[contains(@class,'fa fa-video faa-flash')]")
	WebElement videoCallSymbol;
	
	@FindBy(xpath="//*[text()='Invitation sent']")
	WebElement invitationSent;
	
	//Actions:

	//Verify the UI of On-Net(illumy contacts) users in the conversation list(either name or email id)
	public String verifyOnnetUserFromConversationList(String userToSelect) {
		String actualColor="";
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				conversationList.get(i).click();
				String userColor=conversationList.get(i).getCssValue("color");
				actualColor=Color.fromString(userColor).asHex();
			}
		}
		return actualColor;
	}
	
	//Verify the UI of Off-Net(Basic contacts) users in the conversation list(either name or email id)
	public String verifyOffnetUserFromConversationList(String userToSelect) throws Throwable {
		String actualOffnetUserColor="";
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				thread();
				conversationList.get(i).click();
				String userColor=conversationList.get(i).getCssValue("color");
				actualOffnetUserColor=Color.fromString(userColor).asHex();
			}
		}
		return actualOffnetUserColor;
	}
	
	//Verify the click functionality of the any on-net contact in the conversation list
	public boolean verifyClickActionOfOnnetUser(String userToSelect) {
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				conversationList.get(i).click();
			}
		}
		return messageThread.isDisplayed();
	}
	
	//Check the scroll functionality when conversation list exceeds the maximum of screen resolution
	public void verifySlimScroll_ConversationList(String userName) throws Throwable {		
			
			
	}
	
	public boolean verifyFavouriteContact(String userToSelect) throws Throwable {
		
		List<WebElement>conversationList1=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList1.size();i++) {
			conversationList1.get(i).getText();
			if(conversationList1.get(i).getText().contains(userToSelect)) {
				conversationList1.get(i).getText();
				Actions action=new Actions(driver);
				action.moveToElement(favContact).build().perform();
				TestUtil.drawBorder(favContact, driver);
				thread();
			}
		}
		return favContact.isDisplayed();
	}
	
	public boolean verifyOnlineStatus(String userToSelect) throws Throwable {
		
		boolean onlineUserStatus = false;
		
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
		
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				WebElement onlineUser = driver.findElement(By.xpath("//*[text()='"+userToSelect+"']//preceding-sibling::*[@class='ng-star-inserted']//*[contains(@class,'live_user')]//*[starts-with(@class,'fa')]"));
				onlineUserStatus=onlineUser.isDisplayed();
				
				TestUtil.drawBorder(onlineUser, driver);
			}	
		}
		
		incognito.findElement(By.xpath("//*[@id='search']//*[@class='col-md-3 noselect']")).click();
		thread();
		incognito.findElement(By.xpath("//*[text()='Sign out']")).click();
		thread();
		incognito.close();
		
		return onlineUserStatus;
	}
	
	public boolean verifyFavContactOnlineStatus(String userToSelect) throws Throwable {
		boolean favConOnlineStatus=false;
		favContact.isDisplayed();
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
		Thread.sleep(5000);		
		thread();
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			WebElement list=conversationList.get(i);
			String text=list.getAttribute("innerHTML");
			
			if(text.equalsIgnoreCase(userToSelect)) {
				favConOnlineStatus=favContact_OnlineStatus.isDisplayed();
				
			}
		}
		
		incognito.findElement(By.xpath("//*[@id='search']//*[@class='col-md-3 noselect']")).click();
		thread();
		incognito.findElement(By.xpath("//*[text()='Sign out']")).click();
		thread();
		incognito.close();
		
		return favConOnlineStatus;
	}
	
	public boolean verifyFavContactOfflineStatus(String userToSelect) throws Throwable {
		boolean favContactOfflineStatus=false;
		
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
		Thread.sleep(5000);		
		
		incognito.findElement(By.xpath("//*[@id='search']//*[@class='col-md-3 noselect']")).click();
		thread();
		incognito.findElement(By.xpath("//*[text()='Sign out']")).click();
		thread();
		thread();
		
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			WebElement list=conversationList.get(i);
			String text=list.getAttribute("innerHTML");
			
			if(text.equalsIgnoreCase(userToSelect)) {
				favContactOfflineStatus=favContact.isDisplayed();	
				TestUtil.drawBorder(favContact, driver);
				thread();
			}
		}
		
		incognito.close();
		
		return favContactOfflineStatus;
	}
	
	
	public boolean verifyTypingStatus(String UserToSelect,String typingUserName) throws InterruptedException {
		
		boolean chkTypingStatus=false;
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
		Thread.sleep(5000);		
		List<WebElement>conversationList=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(UserToSelect)) {
				conversationList.get(i).click();
			}
		}
		
		thread();
		thread();
		incognito.findElement(By.xpath("//*[@class='mess_type_box']")).sendKeys("abcdkjjsdfkkdhsh");
		
		List<WebElement>conversationList1=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList1.size();i++) {
			WebElement list=conversationList1.get(i);
			String text=list.getAttribute("innerHTML");
			
			if(text.equalsIgnoreCase(typingUserName)) {
				chkTypingStatus=typingStatus.isDisplayed();	
				TestUtil.drawBorder(typingStatus, driver);
				thread();
			}
		}
		
		incognito.close();
		return chkTypingStatus;
		
	}
	
	public Object verifyUnreadMessageCount(String userToSelect1) throws Throwable {
		String unreadCount="";
		Thread.sleep(3000);
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
		Thread.sleep(5000);		
		
		List<WebElement>conversationList=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect1)) {
				unreadCount=incognito.findElement(By.xpath("//*[@class='badge badge-danger handCursor']")).getText();
			}else {
				return null;
			}
		}
		System.out.println(unreadCount);
		incognito.close();
		return unreadCount;
	}
	
	
	public String verifyNewUserInvitationRequest(String selectUser1,String user) throws Throwable {
		String newUserInvitation="";
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito=new ChromeDriver(options);
		incognito.manage().window().maximize();
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail6"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);	
		
		incognito.findElement(By.xpath("//div[@class='compose_btn_div']//*[contains(@class,'compose_messg btn')]")).click();
		incognito.findElement(By.xpath("//div[@class='mat-chip-list-wrapper']//input[@role='combobox']")).sendKeys("Thamb");
		Thread.sleep(5000);
		List<WebElement>list=incognito.findElements(By.xpath("//div[@role='listbox']//mat-option[@role='option']//span[@class='mat-option-text']"));
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			try {
				if(list.get(i).getText().contains(selectUser1)) {
					thread();
					list.get(i).click();
					break;
				}
			}catch(StaleElementReferenceException e) {
				if(list.get(i).getText().contains(selectUser1)) {
					
					list.get(i).click();
					break;
				}
			}
		}
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		incognito.close();
		thread();
		List<WebElement>conversationList1=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList1.size();i++) {
			conversationList1.get(i).getText();
			if(conversationList1.get(i).getText().contains(user)) {
				newUserInvitation=conversationList1.get(i).getText();
				conversationList1.get(i).click();
			}
		}
		
		
		return newUserInvitation;
	}
	
	public boolean verifyNavigationFromContactsPage(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		user_MsgThreadHeader.click();
		thread();
		sendMsgIcon.click();
		thread();
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				System.out.println(conversationList.get(i).getText());
			}
		}
		
		return true;
	}
	
	public boolean verifyVoiceCallSymbol_ConversationList(String userNameToSelect) throws Throwable {
		boolean voiceCallSym=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		voiceCallIcon_HeaderSection.click();
		thread();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications",1);
		//1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito=new ChromeDriver(options);
		
		//*[@id='voicecall_maindiv']//*[@class='user_name_div']//*[@class='font14 margin-left-phone']
		
		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumy_Email5"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
	
		callBtn_ConfirmationPopup.click();
		thread();
	
		WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
		Actions action=new Actions(driver);
		action=new Actions(incognito);
		action.moveToElement(acceptBtn).build().perform();
		thread();
		acceptBtn.click();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		
		thread();
		voiceCallSym=voiceCallSym_ConversationList.isDisplayed();
		thread();
		incognito.close();
		return voiceCallSym;
	}
	
	public boolean verifyVideoCallSymbol_ConversationList(String userNameToSelect) throws Throwable {
		boolean videoSymbol=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		videoCallIcon_HeaderSection.click();
		thread();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
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
		thread();
		callBtn_VideoCallPopup.click();
		thread();
		thread();
		WebElement acceptBtn=incognito.findElement(By.xpath("//*[@id='voicecall_maindiv']//*[@class='icoming_outgoing_call']//*[@class='btn answer_call ng-star-inserted']"));
		Actions action=new Actions(incognito);
		action.moveToElement(acceptBtn).build().perform();
		thread();
		acceptBtn.click();
		TestUtil.DesktopNotifications(chromeAllowImage_Path);
		thread();
		videoSymbol=videoCallSymbol.isDisplayed();
		thread();
		incognito.close();
		return videoSymbol;
		
	}
	
	public String verifyUnreadCount_Atmention(String userToSelect,String userTogetCount) throws Throwable {
		String redColor="";
		String actualColor="";
		String unreadCount="";
		Thread.sleep(3000);
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
		Thread.sleep(5000);		
		
		List<WebElement>conversationList=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				conversationList.get(i).click();
			}
		}
		Thread.sleep(5000);	
		incognito.findElement(By.xpath("//*[@type='button']//*[contains(@class,'fa fa-at')]")).click();
		thread();
		List<WebElement>list=incognito.findElements(By.xpath("//*[@role='listbox']//*[@role='option']//a"));
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			if(list.get(i).getText().contains(userToSelect)) {
				
				
				list.get(i).click();
			}
		}
		thread();
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		thread();
		
		List<WebElement>converList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<converList.size();i++) {
			converList.get(i).getText();
			if(converList.get(i).getText().contains(userTogetCount)) {
				unreadCount=unreadCount_Atmention.getText();
				System.out.println("Unread Messages count: "+unreadCount);
				actualColor=unreadCount_Atmention.getCssValue("background-color");
				redColor=Color.fromString(actualColor).asHex();
			}
		}	
		
		thread();
		incognito.close();
		return redColor;
	}
	
	public void verifyUnreadCountAutoSync(String userToSelect1) throws Throwable {
		String unreadCount="";
		Thread.sleep(3000);
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
		Thread.sleep(5000);		
		
		List<WebElement>conversationList=incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect1)) {
				unreadCount=incognito.findElement(By.xpath("//*[@class='badge badge-danger handCursor']")).getText();
			}
		}
		System.out.println(unreadCount);
	}
	
	public String verifyNoConversations() throws Throwable {
		driver.findElement(By.xpath("//*[@id='search']//*[@class='col-md-3 noselect']")).click();
		thread();
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		thread();
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("testmail@qa.illumy1.com");
		thread();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12345678");
		thread();
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		thread();
		
		return driver.findElement(By.xpath("//*[text()='No Conversations']")).getText();
	}
	
	public void verifyOnnetUsers() {
		
		String onnetUsers="#2e008b";
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(onnetUsers)) {
				System.out.println(onnetUsers);
			}
		}
		
		
	}
	
	public void verifyOffnetUsers() {
		
		String offnetUsers="#33354a";
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(offnetUsers)) {
				System.out.println(conversationList.get(i).getText());
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
		
	
}
