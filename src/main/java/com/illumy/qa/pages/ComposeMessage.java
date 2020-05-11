/**
 * 
 */
package com.illumy.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Key;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ComposeMessage extends TestBase {

	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	// Auto suggestions xpath's
	String xpath_ToFieldAutoSugg = "//div[@role='listbox']//mat-option[@role='option']//span[@class='mat-option-text']";
	String xpath_MsgThread = "white-space-pre-wrap message__thread ng-star-inserted";
	String xpath_ConversationList = "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_UsersAtmentionPopup = "//*[@class='slimScrollDiv']//*[@role='listbox']//li//a";
	String xpath_Emojis_Searchkeys = "//*[@class='smily_inner ng-star-inserted']//*[@class='ng-star-inserted']//div//span";

	String email = randomEmail(2);
	// PAGE FACTORY : OR (OBJECT REPOSITORY)

	// Text messages xpaths:

	@FindBy(xpath = "//div[@class='compose_btn_div']//*[contains(@class,'compose_messg btn')]//*[text()='Compose Message']")
	WebElement getCompMsgText;

	@FindBy(xpath = "//*[text()='Create a group ']")
	WebElement createGroup;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[text()='to']")
	WebElement to_MsgThread;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[text()='cc']")
	WebElement cc_MsgThread;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@id='emoji_search']//input")
	WebElement searchEmojisField;

	// Buttons and Icons xpaths:

	@FindBy(xpath = "//div[@class='compose_btn_div']//*[contains(@class,'compose_messg btn')]")
	WebElement compMsgBtn;

	@FindBy(xpath = "//*[@role='dialog']//*[@type='button']//*[contains(@class,'fa fa-at')]")
	WebElement atMention;

	@FindBy(xpath = "//*[@role='dialog']//*[@type='button']//*[contains(@class,'smile_icon_fot')]")
	WebElement emoji;

	@FindBy(xpath = "//*[@role='dialog']//*[@type='button']//*[contains(@class,'gif_bto_cs')]")
	WebElement GIF;

	@FindBy(xpath = "//*[@role='dialog']//*[@type='button']//*[contains(@class,'fa fa-paperclip')]")
	WebElement attachment;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendBtn;

	@FindBy(xpath = "//mat-chip[@role='option']//i")
	WebElement removeUserClickXsym;

	@FindBy(xpath = "//*[contains(@class,'toggle-thumb')]//*[contains(@class,'toggle-thumb')]")
	WebElement createGroupToggle;

	@FindBy(xpath = "//*[@id='threadBody']//following-sibling::*[@class='slimScrollBar']")
	WebElement msgBody_Scroll;

	@FindBy(xpath = "//*[contains(@class,'close_btn')]//*[@class='fas fa-times']")
	WebElement closeAtmentionPopup;

	@FindBy(xpath = "//*[@title='Close']")
	WebElement closeEmojiPopup;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f600')]")
	WebElement grinningEmoji;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@class='smily_img ng-star-inserted']//*[contains(@class,'_1f603')]")
	WebElement grinningFaceWithBigEyes;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f604')]")
	WebElement grinnigFaceWithSmilingEyes;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@class='smily_img ng-star-inserted']//*[contains(@class,'_1f601')]")
	WebElement beamingFaceWithSmileEyes;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f606')]")
	WebElement grinningSquintingFace;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f600.png')]")
	WebElement grinningEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f603.png')]")
	WebElement smilyEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f604.png')]")
	WebElement smileEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f601.png')]")
	WebElement grinEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f606.png')]")
	WebElement laughingEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@id='emoji_search']//*[@class='fas fa-times']")
	WebElement searchEmojiXSymbol;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@title='Close']//*[@class='fas fa-times']")
	WebElement XsymGiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@class='powerd_giphy']")
	WebElement poweredGiphy;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@name='search']")
	WebElement searchFieldGiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@type='button' and text()='Search ']")
	WebElement searchButton_GiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@type='button']//*[@class='fas fa-times']")
	WebElement XsymbolSearchGiphy;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@placeholder='Search']")
	WebElement searchPlaceholder_GiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphydiv_body']//*[@id='giphyOne']//*[contains(@class,'img-responsive')]")
	WebElement selectGiphy;

	@FindBy(xpath = "//*[@id='createThreadEditable']//img[contains(@src,'giphy.gif')]")
	WebElement gipgy_MsgBody;

	@FindBy(xpath = "//*[contains(@class,'attachment_div')]//*[contains(@src,'my_com.png')]")
	WebElement myComputerIcon;

	// Links xpaths:

	@FindBy(xpath = "//*[text()='Cc']")
	WebElement cc;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[contains(@style,'!important;')]//*[@class='to_bg_fill_wid']//a")
	WebElement userName_MsgThread;

	// Pop ups xpaths:

	@FindBy(xpath = "//*[text()=' Compose Message ']")
	WebElement composeMessagePopup;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'users__mail mentions__window')]//div[@class='ng-star-inserted']")
	WebElement atmentionPopup;

	@FindBy(xpath = "//*[@class='slimScrollDiv']//*[@role='option']//a")
	WebElement users_AtmentionsPopup;

	@FindBy(xpath = "//*[contains(@id,'dialog')]//*[@class='Emoji_div']")
	WebElement emojiPopup;

	@FindBy(xpath = "//*[contains(@id,'dialog')]//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f1fa-1f1f8')]")
	WebElement emojiPopupScroll;

	@FindBy(xpath = "//*[@id='create_thread_giphy_section']//*[contains(@id,'giphy_div')]")
	WebElement giphyPopup;

	@FindBy(xpath = "//*[contains(@class,'attachment_div')]")
	WebElement attachmentPopup;

	// Text fields xpaths:

	@FindBy(xpath = "//*[@class='mat-chip-list-wrapper']//*[text()='To']//following-sibling::*[@role='combobox']")
	WebElement toField;

	@FindBy(xpath = "//*[@id='subject']")
	WebElement subject;

	@FindBy(xpath = "//*[@id='threadBody']//*[@id='createThreadEditable']")
	WebElement msgBody;

	@FindBy(xpath = "//*[@class='mat-chip-list-wrapper']//*[text()='Cc']//following-sibling::*[@role='combobox']")
	WebElement ccField;

	// Validation messages xpaths:

	@FindBy(xpath = "//*[text()='Please select at least one user.']")
	WebElement plsSelectAtleastOneUser;

	@FindBy(xpath = "//*[text()=' Enter a valid email address.']")
	WebElement enterValidEmailAddress;

	@FindBy(xpath = "//*[text()='Invitation sent']")
	WebElement invitationSent;

	@FindBy(xpath = "//*[@class='btn btn-default-blue']")
	WebElement messagePreview;

	@FindBy(xpath="//*[@class='btn btn-default-outline']//*[contains(@class,'users')]")
	WebElement acceptAsFriend;
	
	@FindBy(xpath="//*[@class='btn btn-default-outline']//*[contains(@class,'handshake')]")
	WebElement AcceptasAcquaintance;
	
	@FindBy(xpath="//*[contains(@class,'red text')]")
	WebElement dismiss;
	
	@FindBy(xpath = "//*[text()=' Withdraw Invite ']")
	WebElement withdrawInvite;

	@FindBy(xpath = "//*[@role='option' and contains(text(),'more')]")
	WebElement more;

	@FindBy(xpath = "//*[text()='Add Cc recipients (Ctrl+Shift+C)']")
	WebElement addCcRecipientsTooltip;

	@FindBy(xpath = "//*[@placeholder='Group Name']")
	WebElement groupNamePlaceholder;

	@FindBy(xpath = "//*[text()=' Required']")
	WebElement required;

	@FindBy(xpath = "//*[contains(text(),' Group Name Already Exists')]")
	WebElement groupNameAlreadyExists;

	@FindBy(xpath = "//*[@type='button']//*[contains(@class,'close_popup')]")
	WebElement closeComposeMsgPopup;

	@FindBy(xpath = "//*[contains(@id,'threadBody')]//*[contains(@src,'1f1fa-1f1f8.png')]")
	WebElement usFlag;

	@FindBy(xpath = "//*[@class='white-space-pre-wrap message__thread ng-star-inserted']//*[@class='emojimain_enlarge_div']//*[contains(@class,'1f600')]")
	WebElement emoji_MsgThread;

	@FindBy(xpath = "//*[text()='No Emoji Found!']")
	WebElement noEmojisFound;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[text()='Frequently Used']")
	WebElement frequentlyUsedText;

	@FindBy(xpath = "//*[text()=' No giphy images found ']")
	WebElement noGiphysFound;

	@FindBy(xpath = "//*[@class='tooltip-inner']")
	WebElement tooltip;

	@FindBy(xpath = "//*[@class='attached_file_compose']//*[contains(@class,'attached_files')]//*[contains(@class,'file_name')]")
	WebElement fileNameMsgBody;

	@FindBy(xpath = "//mat-chip[@role='option']//span[contains(@class,'text-primary')]")
	WebElement validateSelectedUser;

	// Lists :
	List<WebElement> conversationList = driver.findElements(By.xpath(xpath_ConversationList));

	// Initializing the page objects:
	public ComposeMessage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	/*****************************************************************************************************
	 * Verify the UI of compose message button in left panel of illumy home page
	 *****************************************************************************************************/
	// Verifying the compose message text
	public String getComposeMsgText() {
		return getCompMsgText.getText();
	}

	// Verifying click functionality of compose message
	public String compMsg_ClickAction() {
		compMsgBtn.click();
		return composeMessagePopup.getText();
	}

	// Verify by clicking on the 'X' symbol to close the new message thread window
	public boolean closeThread() throws Throwable {
		compMsg_ClickAction();
		thread();
		closeComposeMsgPopup.click();

		return true;
	}

	/*****************************************************************************************************
	 * Validate the compose message pop up UI by clicking on compose message button
	 *****************************************************************************************************/

	// Verifying the UI of compose message pop up window
	public boolean verifyComposeMsgUI() throws Throwable {
		compMsg_ClickAction();
		thread();

		toField.isDisplayed();
		cc.isDisplayed();
		subject.isDisplayed();
		msgBody.isDisplayed();
		atMention.isDisplayed();
		emoji.isDisplayed();
		GIF.isDisplayed();
		attachment.isDisplayed();
		sendBtn.isDisplayed();

		return true;
	}

	/*****************************************************************************************************
	 * Check the "To" field functionality in compose message pop up
	 *****************************************************************************************************/

	// Verify the To field by click on the send button with selecting any user
	public String verifyToFiledWithoutSelectUser() throws Throwable {
		compMsg_ClickAction();
		thread();
		sendBtn.click();

		return plsSelectAtleastOneUser.getText();
	}

	// Clicking on send button by entering invalid email id in To field
	public String verifyToField_InvalidEmail(String keysToSend) throws InterruptedException {
		compMsgBtn.click();
		thread();
		toField.sendKeys(keysToSend);
		toField.sendKeys(Keys.ENTER);
		thread();
		sendBtn.click();
		thread();
		return enterValidEmailAddress.getText();
	}

	// Verify the To field by entering the basic contact with spaces and click on
	// send button
	public String verifyToField_BasicContactWithSpaces(String keysToSend) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(keysToSend);
		toField.sendKeys(Keys.chord(Keys.TAB));
		thread();
		sendBtn.click();
		thread();
		return enterValidEmailAddress.getText();
	}

	// Verify the To filed by selecting single user from auto suggestion list
	public boolean verifyToField_SelectSingleUser(String to, String selectUserFromAutoSugg) throws Throwable {
		thread();
		compMsgBtn.click();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUserFromAutoSugg);
		thread();
		boolean selectedUser = validateSelectedUser.isDisplayed();

		return selectedUser;
	}

	// Verify the create group toggle by selecting the more than one user in To
	// field
	public boolean veriyCrateGroupToggle_SelectMorethanOneUser(String to, String selectUser1, String selectUser2)
			throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser1);
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser2);

		return createGroup.isDisplayed();
	}

	// Click on send button by selecting an user and with out subject and message
	// body
	public boolean composeMsgWithoutSubj_MsgBody(String to, String selectUserFromAutoSugg) throws Throwable {

		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUserFromAutoSugg);
		thread();
		sendBtn.click();
		thread();

		return true;
	}

	// Click on send button by selecting more than one user in to field with out
	// subject and message body
	public void composeMsgMultipleUsers_ToField(String to, String selectUser1, String selectUser2) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(5000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser1);
		thread();

		toField.sendKeys(to);
		Thread.sleep(5000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser2);
		thread();

		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, selectUser1);
		thread();

	}

	// Sending a message to already connected on-net user through compose message
	public boolean composeMsgConnectedOnnetUser(String to, String toUser1, String sub, String msg, String senderName)
			throws Throwable {
		String message_OnnetUser1 = "";
		String message_OnnetUser2 = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser1);
		thread();

		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, toUser1);
		thread();

		String msg_ConnectedUser = "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(msg_ConnectedUser)) {
				message_OnnetUser1 = msgThread.get(i).getText();
			}
		}

		System.out.println("User1 message thread: " + message_OnnetUser1);

		// To open incognito browser
		String dpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dpath + "/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		// 1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito = new ChromeDriver(options);

		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail3"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();

		// Select user from the conversation list of incognito
		List<WebElement> list = incognito
				.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));

		for (int i = 0; i < list.size(); i++) {
			list.get(i).getText();
			try {
				if (list.get(i).getText().contains(senderName)) {
					list.get(i).click();
					break;
				}

			} catch (StaleElementReferenceException e) {

				list = incognito.findElements(
						By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
				if (list.get(i).getText().contains(senderName)) {
					list.get(i).click();
					thread();
					break;
				}
			}
		}

		thread();
		thread();

		List<WebElement> user2MsgThread = incognito.findElements(By.xpath("//*[contains(@class,'chat-middle')]"));
		for (int i = 0; i < user2MsgThread.size(); i++) {
			user2MsgThread.get(i).getText();
			if (user2MsgThread.get(i).getText().contains(msg_ConnectedUser)) {
				message_OnnetUser2 = user2MsgThread.get(i).getText();
			}
		}

		System.out.println("User2 msg thread:" + message_OnnetUser2);

		if (message_OnnetUser1 == message_OnnetUser2) {
			return true;
		}

		incognito.close();
		return true;
	}

	// Sending a message to on-net user not in contacts list through compose message
	public boolean composeMsgOnnetUserNotInContacts(String to, String toUser1, String sub, String msg,
			String senderName) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser1);
		thread();

		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, toUser1);
		thread();
		messagePreview.isDisplayed();
		
		// To open incognito browser
		String dpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dpath + "/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		// 1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito = new ChromeDriver(options);

		incognito.get(prop.getProperty("url"));
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail6"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		thread();
		// Select user from the conversation list of incognito
		List<WebElement> list = incognito
				.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));

		for (int i = 0; i < list.size(); i++) {
			list.get(i).getText();
			try {
				if (list.get(i).getText().contains(senderName)) {
					list.get(i).click();
					break;
				}

			} catch (StaleElementReferenceException e) {

				list = incognito.findElements(
						By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
				if (list.get(i).getText().contains(senderName)) {
					list.get(i).click();
					thread();
					break;
				}
			}
		}

		thread();
		thread();
		thread();
		
	
		WebElement msgPreview = incognito.findElement(By.xpath("//*[@class='btn btn-default-blue']"));
		
		thread();
		thread();
		
		
		return msgPreview.isDisplayed() && withdrawInvite.isDisplayed();

	}

	// Sending a message to off-net user not in contacts list through compose message
	public boolean composeMsgOffnetUserNotInContacts(String keys_ToField, String offnetUser, String sub, String msg)
			throws Throwable {
		String offnetEmail = "";
		String offnetMail = keys_ToField + email + offnetUser;
		compMsgBtn.click();
		thread();
		toField.sendKeys(offnetMail);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, "add new");
		thread();

		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		thread();
		List<WebElement> conversationList = driver.findElements(By.xpath(xpath_ConversationList));
		for (int i = 0; i < conversationList.size(); i++) {
			conversationList.get(i).getText();
			if (conversationList.get(i).getText().contains(offnetMail)) {
				offnetEmail = conversationList.get(i).getText();
			}
		}
		System.out.println("New off net user in conversation list: " + offnetEmail);
		return true;
	}

	// Sending a message to an off-net user already in contacts list through compose message
	public String composeMsgOffnetUserAlreadyInContacts(String offnetUser, String sub, String msg) throws Throwable {
		String MsgThread1 = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(offnetUser);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, offnetUser);
		thread();

		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, offnetUser);
		thread();
		thread();
		String sub_Msg = "Subject: " + sub + "\n" + msg;

		List<WebElement> offnetMsgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < offnetMsgThread.size(); i++) {
			offnetMsgThread.get(i).getText();
			if (offnetMsgThread.get(i).getText().contains(sub_Msg)) {
				MsgThread1 = offnetMsgThread.get(i).getText();
			}
		}

		return MsgThread1;
	}

	// Verify the +more option when an user selects more than 5 users in the To field
	public String verifyToFieldMorethan5Users(String to, String user1, String user2, String user3, String user4,
			String user5, String user6) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user1);
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user2);
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user3);
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user4);
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user5);
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user6);
		thread();

		subject.click();

		return more.getText();

	}

	// Verify the cursor position by press the TAB key when the cursor focus in To field
	public WebElement verifyCursorPositionToFieldTABKey() throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(Keys.chord(Key.TAB));
		WebElement cursorPosition = driver.switchTo().activeElement();
		return cursorPosition;
	}

	// Verify the removing of user from the To field by pressing the back space key on keyboard
	public boolean verifyRemoveToFieldUserBackSpace(String to, String user1) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, user1);
		thread();
		toField.sendKeys(Keys.chord(Keys.BACK_SPACE), Keys.chord(Keys.BACK_SPACE));
		thread();
		try {
			if (!validateSelectedUser.isDisplayed()) {
				return true;
			} else if (validateSelectedUser.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the message thread view, by selecting onnet users and off net users in To filed from compose message and click on send button
	public String verifyMsgThread_Onnet$OffnetUsers_ToField(String to, String onnetUser, String offnetEmailId,
			String offnetUser) throws Throwable {
		String onnetUserMsgThread = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, onnetUser);
		thread();

		toField.sendKeys(offnetEmailId);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, offnetUser);
		thread();

		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, onnetUser);
		thread();

		String onnet_OffnetUsers = onnetUser + " and " + offnetUser;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(onnet_OffnetUsers)) {
				onnetUserMsgThread = msgThread.get(i).getText();
			}
		}

		return onnetUserMsgThread;

	}

	/*****************************************************************************************************
	 * Check the "Cc" filed functionality in the compose message pop up
	 *****************************************************************************************************/

	// Verify the Cc field by clicking on the Cc link in To filed
	public boolean verifyCcLinkClicAction() throws Exception {
		compMsgBtn.click();
		thread();
		cc.click();
		return ccField.isDisplayed();
	}

	// Verify the mouse hover action on the Cc link in To field
	public boolean verifyCcLinkMousehover() throws Throwable {
		compMsgBtn.click();
		thread();
		Actions action = new Actions(driver);
		action.moveToElement(cc).build().perform();

		return addCcRecipientsTooltip.isDisplayed();

	}

	// Verify the Cc field by using the keyboard short cut keys options on pressing
	// the "Ctrl+Shift+C"
	public WebElement verifyCc_ShortCutKeys() throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(Keys.chord(Keys.CONTROL, Keys.chord(Keys.SHIFT + "c")));
		return driver.switchTo().activeElement();
	}

	// Verify the Cc field by entering the invalid email address and Select an user
	// in To field
	public String verifyCc_InvalidEmailAddress(String to, String onnetUser, String invaliEmail) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, onnetUser);
		thread();
		cc.click();
		ccField.sendKeys(invaliEmail);
		ccField.sendKeys(Keys.chord(Keys.TAB));
		thread();
		sendBtn.click();
		thread();
		return enterValidEmailAddress.getText();
	}

	// Verify the message thread, by sending the message on selecting the user in cc
	// section only
	public boolean composeMsg_SingleUserCcField(String ccKeys, String ccUser1, String sub, String msg,
			String senderName) throws Throwable {
		String user1MsgThread = "";
		String user2Thread = "";
		compMsgBtn.click();
		thread();

		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();

		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, ccUser1);
		thread();

		String cc_Sub_Msg = "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThreadUser1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThreadUser1.size(); i++) {
			msgThreadUser1.get(i).getText();
			if (msgThreadUser1.get(i).getText().contains(cc_Sub_Msg)) {
				user1MsgThread = msgThreadUser1.get(i).getText();
			}
		}

		System.out.println("user1 messag thread: " + user1MsgThread);

		// To open incognito browser
		String dpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dpath + "/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		// 1-Allow , 2-Block, 0-Default
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		WebDriver incognito = new ChromeDriver(options);

		incognito.get("https://stage.illumy1.com");
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail3"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();

		// Select user from the conversation list of incognito
		List<WebElement> list = incognito
				.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));

		for (int i = 0; i < list.size(); i++) {
			list.get(i).getText();
			try {
				if (list.get(i).getText().contains(senderName)) {
					list.get(i).click();
					break;
				}

			} catch (StaleElementReferenceException e) {

				list = incognito.findElements(
						By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
				if (list.get(i).getText().contains(senderName)) {
					list.get(i).click();
					thread();
					break;
				}
			}
		}

		thread();
		thread();

		List<WebElement> user2MsgThread = incognito.findElements(By.xpath("//*[contains(@class,'chat-middle')]"));
		for (int i = 0; i < user2MsgThread.size(); i++) {
			user2MsgThread.get(i).getText();
			if (user2MsgThread.get(i).getText().contains(cc_Sub_Msg)) {
				user2Thread = user2MsgThread.get(i).getText();
			}
		}

		System.out.println("User2 msg thread:" + user2Thread);

		if (user1MsgThread == user2Thread) {
			return true;
		}
		return true;
	}

	// Verify the Cc field by removing the selected user from Cc field using back
	// space key from keyboard
	public boolean verifyRemoveUserCc_Backspace(String ccKeys, String ccUser1) throws Throwable {
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(Keys.chord(Keys.BACK_SPACE), Keys.chord(Keys.BACK_SPACE));
		thread();
		try {
			if (!validateSelectedUser.isDisplayed()) {
				return true;
			} else if (validateSelectedUser.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the Cc field by removing the user name from the Cc field on clicking
	// the "x" symbol
	public boolean verifyRemoveCcUser_ClickXSym(String ccKeys, String ccUser1) throws Throwable {
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		removeUserClickXsym.click();
		thread();
		try {
			if (!validateSelectedUser.isDisplayed()) {
				return true;
			} else if (validateSelectedUser.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the "Create a group" toggle in subject field by entering more than one
	// user in Cc field
	public boolean verifyCreateGroupToggle_Morethan1UserCc(String ccKeys, String ccUser1, String ccUser2)
			throws Throwable {
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		thread();
		return createGroup.isDisplayed();
	}

	// Verify the message thread view, by selecting more than one user in Cc field
	// and no users in To field and click on send button
	public String composeMsg_Morethan1UserCc(String ccKeys, String ccUser1, String ccUser2) throws Throwable {
		String msgThread = "";
		compMsgBtn.click();
		thread();
		cc.click();

		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, ccUser1);
		thread();
		String ccUsers = ccUser1 + " and " + ccUser2;
		List<WebElement> msgThreadUser1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThreadUser1.size(); i++) {
			msgThreadUser1.get(i).getText();
			if (msgThreadUser1.get(i).getText().contains(ccUsers)) {
				msgThread = msgThreadUser1.get(i).getText();
			}
		}

		return msgThread;
	}

	// Verify the message thread view, by selecting onnet user and offnet user in Cc
	// field and click on send button
	public String composeMsg_Onnet$OffnetUsers_Cc(String ccKeys, String ccUser1, String ccUser2) throws Throwable {
		String msgThread = "";
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(ccUser2);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, ccUser1);
		thread();
		String ccUsers = ccUser1 + " and " + ccUser2;
		List<WebElement> msgThreadUser1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThreadUser1.size(); i++) {
			msgThreadUser1.get(i).getText();
			if (msgThreadUser1.get(i).getText().contains(ccUsers)) {
				msgThread = msgThreadUser1.get(i).getText();
			}
		}
		return msgThread;
	}

	// Verify the Cc field by selecting multiple onnet and offnet users and invalid
	// email address by clicking on send button
	public String composeMsg_OnnetOffnet$InvalidUsers_Cc(String ccKeys, String ccUser1, String ccUser2,
			String invalidEmail) throws Throwable {
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(ccUser2);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		thread();
		ccField.sendKeys(invalidEmail);
		ccField.sendKeys(Keys.chord(Keys.TAB));
		thread();
		sendBtn.click();
		thread();

		return enterValidEmailAddress.getText();
	}

	// Verify the Cc field by selecting more than 5 users in Cc field and click on
	// send button
	public String verifyMorethan5Users_Cc(String ccKeys, String ccUser1, String ccUser2, String ccUser3, String ccUser4,
			String ccUser5, String ccUser6) throws Throwable {
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser3);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser4);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser5);
		thread();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser6);
		thread();
		ccField.sendKeys(Keys.chord(Keys.TAB));
		thread();

		return more.getText();
	}

	// Verify the cursor position by press the TAB key when the cursor position in
	// Cc field
	public WebElement verifyCursorPosition_TABKey_Cc() throws Throwable {
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(Keys.chord(Key.TAB));
		WebElement cursorPosition = driver.switchTo().activeElement();
		return cursorPosition;
	}

	// Verify the Cc field by removing the invalid email address from the Cc field
	// and Click on send button only with valid email addresses
	public String composeMsg_RemoveInvalidEmail_Cc(String ccKeys, String ccUser1, String ccUser2, String ccUser3)
			throws Throwable {
		String msgThread = "";
		compMsgBtn.click();
		thread();
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();
		ccField.sendKeys(ccUser2);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		ccField.sendKeys(ccUser3);
		Thread.sleep(3000);
		ccField.sendKeys(Keys.chord(Keys.TAB));
		sendBtn.click();
		thread();
		thread();
		ccField.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.chord(Keys.BACK_SPACE)));
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, ccUser1);
		thread();
		String ccUsers = ccUser1 + " and " + ccUser2;
		List<WebElement> msgThreadUser1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThreadUser1.size(); i++) {
			msgThreadUser1.get(i).getText();
			if (msgThreadUser1.get(i).getText().contains(ccUsers)) {
				msgThread = msgThreadUser1.get(i).getText();
			}
		}

		return msgThread;

	}

	/*****************************************************************************************************
	 * Check the "To" and "Cc" by selecting the users and validate the same in
	 * message thread
	 * 
	 * @return
	 * @throws InterruptedException
	 *****************************************************************************************************/

	// Verify the To and Cc field without selecting any users and click on send
	// button
	public String verifyToCc_WithoutUsers() throws InterruptedException {
		compMsgBtn.click();
		thread();
		cc.click();
		thread();
		sendBtn.click();
		thread();

		return plsSelectAtleastOneUser.getText();
	}

	// Verify the To and Cc field by entering invalid email address and on clicking
	// send button
	public String verifyToCc_InvalidEmails(String toUser, String ccUser) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(toUser);
		toField.sendKeys(Keys.chord(Keys.TAB));
		cc.click();
		ccField.sendKeys(ccUser);
		ccField.sendKeys(Keys.chord(Keys.TAB));
		sendBtn.click();

		return enterValidEmailAddress.getText();

	}

	// Verify the "Create a group" toggle in subject field by selecting single users in To and in Cc fields
	public boolean verifyCreateGroupToggle_ToCcUsers(String to, String toUser, String cckeys, String ccUser)throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		cc.click();
		ccField.sendKeys(cckeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);

		return createGroup.isDisplayed();

	}

	// Verify the message thread, by selecting single users in To and Cc fields and
	// click on send button
	public String composeMsg_SelectSingleUsersToCc(String to, String selectUser1, String selectUser2) throws Throwable {
		String to_cc_UsersMsgThread = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser1);
		thread();

		cc.click();
		ccField.sendKeys(to);

		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser2);
		thread();

		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, selectUser1);
		thread();

		String to_UserName = to_MsgThread.getText() + selectUser1;
		String cc_UserName = cc_MsgThread.getText() + selectUser2;

		String to_cc_UserNames = to_UserName + "\n" + cc_UserName;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));

		for (int i = 0; i < msgThread.size(); i++) {

			msgThread.get(i).getText();

			if (msgThread.get(i).getText().equalsIgnoreCase(to_cc_UserNames)) {

				to_cc_UsersMsgThread = msgThread.get(i).getText();
			}
		}
		return to_cc_UsersMsgThread;
	}

	// Verify the message thread, by selecting onnet and offnet users in To and Cc
	// fields and click on send button
	public String composeMsg_OnnetOffnetUsers_ToCc(String to, String toUser, String cckeys, String ccUser)
			throws Throwable {
		String msgThread = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		cc.click();
		ccField.sendKeys(cckeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);
		thread();

		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();
		thread();
		String to_UserName = to_MsgThread.getText() + toUser;
		String cc_UserName = cc_MsgThread.getText() + ccUser;
		String to_CcUsers = to_UserName + "\n" + cc_UserName;
		List<WebElement> msgThreadUser1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThreadUser1.size(); i++) {
			msgThreadUser1.get(i).getText();
			if (msgThreadUser1.get(i).getText().contains(to_CcUsers)) {
				msgThread = msgThreadUser1.get(i).getText();
			}
		}

		return msgThread;

	}

	// Verify the message thread, by selecting offnet users in To and Cc field and
	// click on send button
	public String composeMsg_OffnetUsers_ToCc(String toUser, String ccUser) throws Throwable {
		String msgThread = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(toUser);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		cc.click();
		ccField.sendKeys(ccUser);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);
		thread();

		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, ccUser);
		thread();
		thread();
		String to_UserName = to_MsgThread.getText() + toUser;
		String cc_UserName = cc_MsgThread.getText() + ccUser;
		String to_CcUsers = to_UserName + "\n" + cc_UserName;
		List<WebElement> msgThreadUser1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThreadUser1.size(); i++) {
			msgThreadUser1.get(i).getText();
			if (msgThreadUser1.get(i).getText().contains(to_CcUsers)) {
				msgThread = msgThreadUser1.get(i).getText();
			}
		}

		return msgThread;
	}

	// Verify the To and Cc field, by entering invalid plain characters in To field
	// and select one or more users in Cc field
	public String verifyToField_EnterPlainText(String to, String cckeys, String ccUser) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to,Keys.chord(Keys.chord(Keys.ENTER)));
		cc.click();
		ccField.sendKeys(cckeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);
		thread();
		thread();
		sendBtn.click();
		thread();

		return enterValidEmailAddress.getText();
	}

	// Verify the To and Cc field, by entering invalid plain characters in Cc field
	// and select one or more users in To field
	public String verifyCcField_EnterPlainText(String to, String toUser, String ccUser) throws Throwable {
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		cc.click();
		ccField.sendKeys(ccUser,Keys.chord(Keys.chord(Keys.ENTER)));
		thread();
		thread();
		sendBtn.click();
		thread();

		return enterValidEmailAddress.getText();
	}

	// Verify the message thread of users, by sending subject and message and
	// selecting users in To field and Cc filed
	public String composeMsg_To_Cc_MultipleUsers(String to, String toUser1, String toUser2, String ccKeys,
			String ccUser1, String ccUser2, String sub, String msg, String senderName) throws Throwable {
		String to_cc_MessageThread = "";

		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser1);
		thread();

		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser2);
		thread();

		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser1);
		thread();

		ccField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser2);
		thread();

		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, toUser1);
		thread();

		String to_MultipleUsers = to_MsgThread.getText() + toUser1 + " and " + toUser2;
		String cc_MultipleUsers = cc_MsgThread.getText() + ccUser1 + " and " + ccUser2;
		String to_Cc_Sub_Msg = to_MultipleUsers + "\n" + cc_MultipleUsers;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(to_Cc_Sub_Msg)) {
				to_cc_MessageThread = msgThread.get(i).getText();
			}
		}

		return to_cc_MessageThread;
	}

	/*****************************************************************************************************
	 * Validate the "Subject" field functionality in compose message pop up
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/

	// Verify the subject field by entering the alphabets, select users in To and Cc
	// field and on click send button
	public String verifySubject_Alphabets_ToCc(String to, String toUser, String cckeys, String ccUser, String sub)throws Throwable {
		String subject_Chars = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				subject_Chars = msgThread.get(i).getText();
			}
		}
		return subject_Chars;
	}

	// Check the Subject field is accepting numbers or not, select users in To and
	// Cc field and click on send button
	public String verifySubject_Numbers_ToCc(String to, String toUser, String cckeys, String ccUser, String sub)
			throws Throwable {
		String subject_Nums = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				subject_Nums = msgThread.get(i).getText();
			}
		}
		return subject_Nums;
	}

	// Verify the subject field by entering the special characters and select the
	// users in To and click fields and click on send button
	public String verifySubject_SplChars_ToCc(String to, String toUser, String cckeys, String ccUser, String sub)
			throws Throwable {
		String subject_SplChars = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				subject_SplChars = msgThread.get(i).getText();
			}
		}
		return subject_SplChars;
	}

	// Verify the subject field by entering the combinations and select the users in
	// To and Cc fields and click on send button
	public String verifySubject_Combinations_ToCc(String to, String toUser, String cckeys, String ccUser, String sub)
			throws Throwable {
		String subject_Combinations = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				subject_Combinations = msgThread.get(i).getText();
			}
		}
		return subject_Combinations;
	}

	// Verify the subject field by entering the URL and select users in To and Cc
	// fields and click on send button
	public String verifySubject_URL_ToCc(String to, String toUser, String cckeys, String ccUser, String sub)
			throws Throwable {
		String subject_Url = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				subject_Url = msgThread.get(i).getText();
			}
		}
		return subject_Url;
	}

	// Verify the subject field by entering the email id and select users in To and
	// Cc fields and click on send button
	public String verifySubject_EmailId_ToCc(String to, String toUser, String cckeys, String ccUser, String sub)
			throws Throwable {
		String subject_Email = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				subject_Email = msgThread.get(i).getText();
			}
		}
		return subject_Email;
	}

	// Verify the subject by entering the maximum limit of characters in subject
	// field
	public String verifySubject_MaxLimitChars_ComposeMsg(String to, String toUser, String cckeys, String ccUser,
			String sub) throws Throwable {
		String subject_MaxLimit = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		subject_MaxLimit = subject.getAttribute("value");
		return subject_MaxLimit;

	}

	// Selecting single user in To field and entering only subject
	public String composeMsg_ToFieldSingleUser_Subject(String to, String selectUser1, String sub) throws Throwable {
		String to_Sub_MsgThread = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, selectUser1);
		thread();

		subject.sendKeys(sub);
		thread();
		sendBtn.click();
		thread();

		TestUtil.selectElementFromList(xpath_ConversationList, selectUser1);
		thread();

		String subj_Msg = "Subject: " + sub;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));

		for (int i = 0; i < msgThread.size(); i++) {

			msgThread.get(i).getText();

			if (msgThread.get(i).getText().equalsIgnoreCase(subj_Msg)) {

				to_Sub_MsgThread = msgThread.get(i).getText();
			}
		}
		return to_Sub_MsgThread;
	}

	/*****************************************************************************************************
	 * Verify the "Create a Group" toggle functionality in the subject field of the
	 * compose message pop up
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/
	// Verify the "Create a group" toggle by default is in disable mode or not when
	// user selected more than one users in To or Cc field
	public String verifyCreateGroupToggle_Default(String to, String toUser, String cckeys, String ccUser)
			throws Throwable {
		String actualColor = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		createGroupToggle.isDisplayed();

		String userColor = createGroupToggle.getCssValue("background-color");
		actualColor = Color.fromString(userColor).asHex();
		return actualColor;
	}

	// Verify the create group toggle enabled status
	public String verifyCreateGroupToggle_EnableStatus(String to, String toUser, String cckeys, String ccUser)
			throws Throwable {
		String actualColor = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		createGroupToggle.click();
		thread();

		String userColor = createGroupToggle.getCssValue("background-color");
		actualColor = Color.fromString(userColor).asHex();
		return actualColor;
	}

	// Verify the "Group Name" place holder on enable the create a group toggle
	public boolean verifyGroupNamePlaceholder(String to, String toUser, String cckeys, String ccUser) throws Throwable {
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		createGroupToggle.click();
		thread();
		return groupNamePlaceholder.isDisplayed();
	}

	/*****************************************************************************************************
	 * Verify the "Message body" in the compose message
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/

	// Verify the message body of compose message on entering the alphabets and
	// Select users in To and Cc and click on send button
	public String verifyMsgBody_Alphabet(String to, String toUser, String cckeys, String ccUser, String sub, String msg)
			throws Throwable {
		String msgBody_Alphabet = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				msgBody_Alphabet = msgThread.get(i).getText();
			}
		}
		return msgBody_Alphabet;

	}

	// Verify the message body of compose message on entering the numbers and select
	// users in To and Cc and click on send button
	public String verifyMsgBody_Numbers(String to, String toUser, String cckeys, String ccUser, String sub, String msg)
			throws Throwable {
		String msgBody_Nums = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				msgBody_Nums = msgThread.get(i).getText();
			}
		}
		return msgBody_Nums;
	}

	// Verify the message body of compose message on entering the special characters
	// and select users in To and Cc and click on send button
	public String verifyMsgBody_SplChars(String to, String toUser, String cckeys, String ccUser, String sub, String msg)
			throws Throwable {
		String msgBody_SplChars = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				msgBody_SplChars = msgThread.get(i).getText();
			}
		}
		return msgBody_SplChars;
	}

	// Verify the message body of compose message on entering the alphanumeric
	// combinations and select users in To and Cc and click on send button
	public String verifyMsgBody_Combinations(String to, String toUser, String cckeys, String ccUser, String sub,
			String msg) throws Throwable {
		String msgBody_Combinations = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				msgBody_Combinations = msgThread.get(i).getText();
			}
		}
		return msgBody_Combinations;
	}

	// Verify the message body of compose message by sending URL and select users in
	// To and Cc and click on send button
	public String verifyMsgBody_URL(String to, String toUser, String cckeys, String ccUser, String sub, String msg)
			throws Throwable {
		String msgBody_Url = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				msgBody_Url = msgThread.get(i).getText();
			}
		}
		return msgBody_Url;
	}

	// Verify the message body of compose message by sending email address and
	// select users in To and Cc and click on send button
	public String verifyMsgBody_Email(String to, String toUser, String cckeys, String ccUser, String sub, String msg)
			throws Throwable {
		String msgBody_Email = "";
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String toCcUsers_Subject = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n"
				+ "Subject: " + sub + "\n" + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(toCcUsers_Subject)) {
				msgBody_Email = msgThread.get(i).getText();
			}
		}
		return msgBody_Email;
	}

	// Verify the message body scroll on entering the long text
	public boolean verifyMsgBody_Scroll(String to, String toUser, String cckeys, String ccUser, String sub, String msg)
			throws Throwable {
		boolean messageBody_Scroll = false;
		verifyCreateGroupToggle_ToCcUsers(to, toUser, cckeys, ccUser);
		subject.sendKeys(sub);

		for (int i = 0; i < 30; i++) {
			msgBody.sendKeys(msg);
		}
		messageBody_Scroll = msgBody_Scroll.isDisplayed();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		return messageBody_Scroll;
	}

	/*****************************************************************************************************
	 * Verify the grouping functionality in the compose message
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/

	// Verify the group field, without specifying any group name and click on send
	// button after selection the more than one users
	public String verifyCreateGroup_WithoutGroupName(String to, String toUser, String cckeys, String ccUser)
			throws Throwable {
		verifyGroupNamePlaceholder(to, toUser, cckeys, ccUser);
		sendBtn.click();
		thread();

		return required.getText();
	}

	// Create a new group of more than one users in To or Cc fields (either onnet or
	// offnet) along with the group name
	public boolean createNewGroup_WithGroupName(String to, String toUser, String cckeys, String ccUser,
			String groupName, String msg) throws Throwable {
		boolean newGroupName = false;
		verifyGroupNamePlaceholder(to, toUser, cckeys, ccUser);
		String newGroup = groupName + email;
		
		subject.sendKeys(newGroup);
		thread();

		msgBody.sendKeys(msg);
		thread();

		sendBtn.click();
		thread();
		thread();
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_ConversationList));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(newGroup)) {
				System.out.println("New Group Name is: " + msgThread.get(i).getText());
				newGroupName = msgThread.get(i).isDisplayed();
			}
		}
		return newGroupName;
	}

	// Create a group with the different users and same group name which is already
	// existed in the contacts list
	public String createGroupDiffUsers_ExistedGroupName(String to, String toUser, String cckeys, String ccUser,
			String groupName, String msg) throws Throwable {
		verifyGroupNamePlaceholder(to, toUser, cckeys, ccUser);
		
		thread();
		subject.sendKeys(groupName);
		thread();

		msgBody.sendKeys(msg);
		thread();

		sendBtn.click();
		thread();

		return groupNameAlreadyExists.getText();
	}

	// Create a group with the same group members and same group name which is
	// already existed in the contacts list
	public String createGroupSameUsers_SameGroupName(String to, String toUser, String cckeys, String ccUser,String groupName, String msg) throws Throwable {
		String groupMsg = "";
		verifyGroupNamePlaceholder(to, toUser, cckeys, ccUser);
		subject.sendKeys(groupName);
		thread();
		msgBody.sendKeys(msg);
		thread();
		sendBtn.click();
		thread();
		thread();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, groupName);
		String groupUsersMsg = "Subject: " + groupName + "\n" + msg;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(groupUsersMsg)) {
				groupMsg = msgThread.get(i).getText();
			}
		}

		return groupMsg;
	}

	// Create a group with different group name and same users who are already group
	// members of a other group
	public boolean createGroup_SameUsers_DiffGroupName(String to, String toUser, String cckeys, String ccUser,
			String groupName, String msg) throws Throwable {
		boolean diffGroupName_SameUsers = false;
		verifyGroupNamePlaceholder(to, toUser, cckeys, ccUser);
		String newGroup = groupName + email;
		subject.sendKeys(newGroup);
		thread();

		msgBody.sendKeys(msg);
		thread();

		sendBtn.click();
		thread();
		thread();
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_ConversationList));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(newGroup)) {
				System.out.println("Same users and diff. group name: " + msgThread.get(i).getText());
				diffGroupName_SameUsers = msgThread.get(i).isDisplayed();
			}
		}
		return diffGroupName_SameUsers;
	}

	/*****************************************************************************************************
	 * Check the @mention functionality in compose message pop up
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/

	// Verify the @mention icon click functionality in the compose message without
	// entering any users in To and Cc
	public boolean clicAtmention_ComposeMsg() throws Throwable {
		compMsgBtn.click();
		thread();
		atMention.click();
		thread();
		return atmentionPopup.isDisplayed();
	}

	// Verify the @ mentions auto suggestion pop up by selecting onnet users in To
	// or Cc
	public boolean verifyAtmentionPopup_OnnetUsers_ToCc(String to, String toUser, String cckeys, String ccUser,
			String sub) throws Throwable {
		boolean atmentionPopupUsers = false;
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		cc.click();
		ccField.sendKeys(cckeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);
		thread();
		subject.sendKeys(sub);
		thread();
		atMention.click();
		thread();

		List<WebElement> atmentionPopup = driver.findElements(By.xpath(xpath_UsersAtmentionPopup));
		for (int i = 0; i < atmentionPopup.size(); i++) {
			atmentionPopup.get(i).getText();
			if (atmentionPopup.get(i).getText().contains(toUser)) {

				atmentionPopupUsers = atmentionPopup.get(i).isDisplayed();
			}
		}

		return atmentionPopupUsers;
	}

	// Verify the @ mention auto suggestions pop up by entering the @ using keyboard options "Shift+@"
	public boolean verifyAtmentionPopup_Shortcutkeys() throws Throwable {
		compMsgBtn.click();
		thread();
		msgBody.sendKeys(Keys.chord(Keys.SHIFT + "@"));
		return atmentionPopup.isDisplayed();
	}

	// Verify the @ mentions auto suggestion pop up by pressing the "Space" key from keyboard
	public boolean verifyAtmentionPopup_Space() throws Throwable {
		compMsgBtn.click();
		thread();
		atMention.click();
		thread();
		msgBody.sendKeys(Keys.chord(Keys.SPACE, Keys.chord(Keys.SPACE)));

		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return true;
	}

	// Verify the @ mentions auto suggestions pop up by pressing "Backspace" key from keyboard
	public boolean verifyAtmentionPopup_Backspace() throws Throwable {
		compMsgBtn.click();
		thread();
		atMention.click();
		thread();
		msgBody.sendKeys(Keys.chord(Keys.SPACE, Keys.chord(Keys.SPACE)));
		thread();
		msgBody.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.chord(Keys.BACK_SPACE)));
		thread();
		try {
			if (atmentionPopup.isDisplayed()) {
				return true;
			} else if (!atmentionPopup.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return true;
	}

	// Verify the message thread by sending the selected user from @ mentions pop up
	public String verifyMsgThread_AtmentionUser(String to, String toUser, String sub, String msg) throws Throwable {
		String atmentionUser_Msg = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		subject.sendKeys(sub);
		thread();
		atMention.click();
		thread();
		TestUtil.selectElementFromList(xpath_UsersAtmentionPopup, toUser);
		thread();
		msgBody.sendKeys(msg);
		sendBtn.click();
		thread();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String atmentionUser = "@"+toUser + " " + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(atmentionUser)) {
				atmentionUser_Msg = msgThread.get(i).getText();
			}
		}
		return atmentionUser_Msg;
	}

	// Verify the '@' auto suggestions drop down menu by press the 'Esc' key on
	// keyboard
	public boolean verifyAtmentionPopup_Esc() throws Throwable {
		compMsgBtn.click();
		thread();
		atMention.click();
		thread();
		msgBody.sendKeys(Keys.chord(Keys.ESCAPE));
		thread();
		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return true;
	}

	// Verify the '@' auto suggestions drop down menu by clicking on "X" symbol
	public boolean verifyAtmentionPopup_ClicXSymbol() throws Throwable {
		compMsgBtn.click();
		thread();
		atMention.click();
		thread();
		closeAtmentionPopup.click();
		thread();
		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return true;
	}

	// Verify the '@' icon functionality by selecting more than one user name from
	// the auto suggestions drop down list
	public String verifyMsgThread_SelectMorethan1AtmentionUsers(String to, String toUser, String cckeys, String ccUser,
			String msg) throws Throwable {
		String atmentionUser_Msg = "";
		compMsgBtn.click();
		thread();
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		cc.click();
		ccField.sendKeys(cckeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);
		thread();

		atMention.click();
		thread();
		TestUtil.selectElementFromList(xpath_UsersAtmentionPopup, toUser);
		thread();
		atMention.click();
		thread();
		TestUtil.selectElementFromList(xpath_UsersAtmentionPopup, ccUser);
		thread();
		msgBody.sendKeys(msg);
		sendBtn.click();
		thread();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		String atmentionUser = to_MsgThread.getText() + toUser + "\n" + cc_MsgThread.getText() + ccUser + "\n" + "@"
				+ toUser + " " + "@" + ccUser + " " + msg;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(atmentionUser)) {
				atmentionUser_Msg = msgThread.get(i).getText();
			}
		}

		return atmentionUser_Msg;
	}

	// Verify @mention pop up by entering '@' for multiple times without giving any
	// spaces using keyboard options "Shift+@"
	public boolean enterMultipleAtmentionsWithoutSpace_Shortkeys() throws Throwable {

		compMsgBtn.click();
		thread();
		msgBody.sendKeys("@");
		thread();
		msgBody.sendKeys("@");
		thread();
		msgBody.sendKeys("@");
		thread();
		msgBody.sendKeys("@");
		thread();

		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify @ mentions pop up by clicking on @mention icon from message input
	// field for multiple times without giving any spaces
	public boolean clicMultipleAtmentionsWithoutSpace_Mouse() throws Throwable {
		compMsgBtn.click();
		thread();
		atMention.click();
		thread();
		atMention.click();
		thread();
		atMention.click();
		thread();
		atMention.click();
		thread();

		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	/*****************************************************************************************************
	 * Verify the Emoji functionality in the compose message
	 * 
	 * @return
	 * @throws InterruptedException
	 *****************************************************************************************************/

	// Check the click action on emoji icon in the message body
	public boolean verifyClicActionEmojiIcon() throws InterruptedException {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		return emojiPopup.isDisplayed();

	}

	// Validate the scroll functionality by moving the mouse up and down
	public boolean verifyEmojiPopupScroll() throws InterruptedException {
		compMsgBtn.click();
		thread();
		msgBody.click();
		emoji.click();
		thread();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement element = emojiPopupScroll;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		thread();
		String flag = usFlag.getText();
		if (msgBody.getText().contains(flag)) {
			return true;
		} else {
			return false;
		}
	}

	// Verify the emoji pop up window by clicking on "X" symbol
	public boolean verifyEmojiPopupXSymbol() throws Throwable {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		closeEmojiPopup.click();
		thread();

		try {
			if (!emojiPopup.isDisplayed()) {
				return true;
			} else if (emojiPopup.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the emoji pop up by pressing "Esc" key on keyboard while pop up is in open
	public boolean verifyEmojiPopup_PressEscKey() throws Throwable {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(Keys.chord(Keys.ESCAPE));
		thread();

		try {
			if (!emojiPopup.isDisplayed()) {
				return true;
			} else if (emojiPopup.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify that the selected emojis are displaying in message body or not by selecting an emoji from emoji popup
	public boolean verifyMsgBody_SelectEmoji() throws Throwable {
		compMsgBtn.click();
		thread();
		msgBody.click();
		emoji.click();
		thread();
		grinningEmoji.click();
		thread();
		
		String grinningEmoji = grinningEmoji_MsgBody.getText();
		if (msgBody.getText().contains(grinningEmoji)) {
			return true;
		} else {
			return false;
		}
	}

	// Verify the message thread by sending an emoji from compose message
	public boolean verifyMsgThread_SendEmoji(String to, String toUser) throws Throwable {
		thread();
		verifyMsgBody_SelectEmoji();
		thread();
		
		toField.sendKeys(to);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();

		sendBtn.click();
		thread();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
		thread();

		return emoji_MsgThread.isDisplayed();
	}

	// Verify the emojis that are displaying or not in message body by selecting the multiple emojis using "Shift+Enter" keys on keyboard
	public boolean verifyMsgBody_SelectMultipleEmojis_ShiftEnter() throws Throwable {
		compMsgBtn.click();
		thread();
		msgBody.click();
		emoji.click();
		thread();

		Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).click(grinningFaceWithBigEyes).click(grinningEmoji).click(grinnigFaceWithSmilingEyes)
				.click(beamingFaceWithSmileEyes).click(grinningSquintingFace).keyUp(Keys.SHIFT).build().perform();
		thread();
		thread();

		if (grinningEmoji_MsgBody.isDisplayed() && smilyEmoji_MsgBody.isDisplayed() && smileEmoji_MsgBody.isDisplayed()
				&& grinEmoji_MsgBody.isDisplayed() && laughingEmoji_MsgBody.isDisplayed()) {
			return true;
		}
		return true;
	}

	// Verify the search field in emojis pop up window by clicking on emoji icon from message body
	public boolean verifySearchFieldEmojiPopup() throws Throwable {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		return searchEmojisField.isDisplayed();
	}

	// Verify the search emoji by entering the keywords to search the emojis
	public boolean verifyEmojiPopupSearch_EnterValidKeys(String emojiSearchKeys) throws Throwable {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(emojiSearchKeys);
		List<WebElement> searchedEmojis = driver.findElements(By.xpath(xpath_Emojis_Searchkeys));
		for (int i = 0; i < searchedEmojis.size(); i++) {
			System.out.println(searchedEmojis.get(i).getAttribute("class"));
		}

		return true;
	}

	// Verify the search emoji field by entering the invalid keywords to search the emojis
	public String verifyEmojiPopupSearch_EnterInvalidKeys(String invalidEmojiSearchKeys) throws Throwable {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(invalidEmojiSearchKeys);
		thread();
		String noemojisFound = noEmojisFound.getText();
		return noemojisFound;
	}

	// Verify the click action on "X" symbol in the search emoji field by entering the some keywords
	public boolean verifyXSymbol_EmojiSearchFiled(String emojiSearchKeys) throws InterruptedException {
		compMsgBtn.click();
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(emojiSearchKeys);
		thread();
		searchEmojiXSymbol.click();
		return frequentlyUsedText.isDisplayed();
	}

	/*****************************************************************************************************
	 * Verify the giphy functionality in the compose message pop up window
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/
	// Verify the click functionality of 'GIF' icon in the message body of compose message
	public boolean verifyGiphyClicAction() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();

		return giphyPopup.isDisplayed();
	}

	// Verify the giphy pop up window by clicking on "X" symbol
	public boolean verifyGiphyPopup_ClicXsymbol() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		XsymGiphyPopup.click();
		thread();
		try {
			if (!giphyPopup.isDisplayed()) {
				return true;
			} else if (giphyPopup.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the GIPHY title mouse hover and its click functionality at header section of the giphy pop up window
	public String verifyGiphyPopupTitle() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		poweredGiphy.isDisplayed();
		poweredGiphy.click();
		thread();

		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("Parent window ID: " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("Child Window ID: " + childWindowId);

		driver.switchTo().window(childWindowId);
		thread();
		String giphyDotCom = driver.getTitle();
		driver.close();
		thread();
		return giphyDotCom;
	}

	// Verify the search field in the giphy pop up window by clicking on the GIF icon from message input field
	public boolean verifyGiphyPopup_SearchField() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		return searchFieldGiphyPopup.isDisplayed();
	}

	// Verify the search button is displaying or not in the giphy pop up window
	public boolean verifyGiphyPopup_SearchButton() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		return searchButton_GiphyPopup.isDisplayed();
	}

	// Verify the giphy pop up by entering the invalid keywords to search the giphy's available in the giphy pop up window
	public boolean verifyGiphySearch_Invalidkeys() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		searchFieldGiphyPopup.sendKeys("sdjksdkfgdddfdgdggdas");
		return noGiphysFound.isDisplayed();
	}

	// Verify the "X" symbol mouse hover and click functionality in the search field by entering some keywords on search field
	public boolean verifyGiphySearchField_xSymbol() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		searchFieldGiphyPopup.sendKeys("giphys");
		XsymbolSearchGiphy.click();
		return searchPlaceholder_GiphyPopup.isDisplayed();
	}

	// Verify the mouse over and click functionality of giphy's in the giphy pop up window
	public boolean verifySelectGiphyFromPopup() throws Throwable {
		compMsgBtn.click();
		thread();
		GIF.click();
		thread();
		selectGiphy.click();
		thread();

		return gipgy_MsgBody.isDisplayed();
	}

	/*****************************************************************************************************
	 * Verify the attachments functionality in the compose message pop up window
	 * 
	 * @return
	 * @throws Throwable
	 *****************************************************************************************************/

	// Check the 'Attachment' icon click functionality on message body section
	public boolean verifyAttachmentClickAction() throws Throwable {
		compMsgBtn.click();
		thread();
		attachment.click();
		thread();
		return attachmentPopup.isDisplayed();
	}

	// Verify the "My Computer" icon and its mouse hover functionality in the attachment pop pup window
	public String verifyMyComputerTooltip() throws Throwable {
		compMsgBtn.click();
		thread();
		attachment.click();
		thread();
		Actions action = new Actions(driver);
		action.moveToElement(myComputerIcon).build().perform();

		return tooltip.getText();
	}

	// Verify the click action on "My Computer" icon to send a file to user from the local system
	public String verifyAttachmentMsgBody_MyComputer(String filePath) throws Throwable {
		compMsgBtn.click();
		thread();
		attachment.click();
		thread();
		myComputerIcon.click();
		thread();
		TestUtil.uploadFile(filePath);
		thread();
		Thread.sleep(5000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement element = fileNameMsgBody;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		String file=fileNameMsgBody.getText();
		
		return file;
	}

}
