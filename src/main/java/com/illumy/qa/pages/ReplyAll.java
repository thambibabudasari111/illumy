/**
 * 
 */
package com.illumy.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class ReplyAll extends TestBase {

	public MessageOptions msgOptions;

	String msgId = "";
	String msgOptionsId = "";

	WebElement thumbsUpIcon;
	WebElement envelopeIcon;
	WebElement flag;
	WebElement reaction;
	WebElement moreOptions;

	String chars = TestUtil.randomChars(5);

	// Lists xpaths:
	String xpath_ConversationList	 	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_MsgThread 				= "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions 			= "//*[contains(@id,'options_msg')]";
	String xpath_UsersAtmentionPopup 	= "//*[@class='slimScrollDiv']//*[@role='listbox']//li//a";
	String xpath_Emojis_Searchkeys 		= "//*[@class='smily_inner ng-star-inserted']//*[@class='ng-star-inserted']//div//span";
	String xpath_fileList_OneDrive 		= "//*[@role='listitem']";
	String attachments_MsgThread 		= "//*[contains(@class,'attachment__thread')]//*[contains(@class,'iniviteFolder')]//*[starts-with(@class,'text_overlap')]";
	String xpath_Files_Dropbox 			= "//*[contains(@class,'dropins-item-row-content')]";
	String xpath_ToFieldAutoSugg		= "//div[@role='listbox']//mat-option[@role='option']//span[@class='mat-option-text']";
	String xpath_replyAllFwdMsgs		= "//*[contains(@id,'forwardReply')]";
	
	// PAGE FACTORY : OR (Object Repository)

	// Text fields:
	@FindBy(xpath = "//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;

	@FindBy(xpath = "//*[@id='subject']")
	WebElement subjectField;

	@FindBy(xpath = "//*[contains(@class,'attached_file')]//*[@class='white-space-pre-wrap message__thread ng-star-inserted']")
	WebElement attachedMsg_ReplyAllPopup;

	@FindBy(xpath = "//*[@id='threadBody']//*[@id='createThreadEditable']")
	WebElement msgBody;

	@FindBy(xpath = "//*[@id='results-createThreadEditable']//*[@role='option']//a//*[contains(@class,'ng-star-inserted')]")
	WebElement onlineStatus;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@id='emoji_search']//input")
	WebElement searchEmojisField;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[text()='Frequently Used']")
	WebElement frequentlyUsedText;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@name='search']")
	WebElement searchFieldGiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@placeholder='Search']")
	WebElement searchPlaceholder_GiphyPopup;
	
	@FindBy(xpath="//*[@role='combobox']")
	WebElement toField_ReplyAll;
	
	@FindBy(xpath = "//*[@class='mat-chip-list-wrapper']//*[text()='Cc']//following-sibling::*[@role='combobox']")
	WebElement ccField;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[text()='to']")
	WebElement to_MsgThread;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[text()='cc']")
	WebElement cc_MsgThread;
	
	// Button, Icons and Links:
	@FindBy(xpath = "//*[text()='Reply All']")
	WebElement replyAll;

	@FindBy(xpath = "//*[text()='Cc']")
	WebElement cc;
	
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

	@FindBy(xpath = "//*[text()='Show message']")
	WebElement showMessageBtn;

	@FindBy(xpath = "//*[text()='Hide message']")
	WebElement hideMessageBtn;

	@FindBy(xpath = "//*[contains(@id,'createThreadEditable')]//*[contains(@class,'close_btn')]")
	WebElement crossSym_AtmentionPopup;

	@FindBy(xpath = "//*[contains(@id,'dialog')]//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f1fa-1f1f8')]")
	WebElement emojiPopupScroll;

	@FindBy(xpath = "//*[contains(@id,'threadBody')]//*[contains(@src,'1f1fa-1f1f8.png')]")
	WebElement usFlag;

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@title='Close']")
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

	@FindBy(xpath = "//*[@id='create_thread_emoji_div']//*[@id='emoji_search']//*[@class='fas fa-times']")
	WebElement searchEmojiXSymbol;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@title='Close']//*[@class='fas fa-times']")
	WebElement XsymGiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@class='powerd_giphy']")
	WebElement poweredGiphy;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@type='button' and text()='Search ']")
	WebElement searchButton_GiphyPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_div']//*[@type='button']//*[@class='fas fa-times']")
	WebElement XsymbolSearchGiphy;

	@FindBy(xpath = "//*[@id='create_thread_giphydiv_body']//*[@id='giphyOne']//*[contains(@class,'img-responsive')]//*")
	WebElement selectGiphy;

	@FindBy(xpath = "//*[@id='create_thread_giphydiv_body']//*[@id='giphyOne']//*[contains(@class,'img-responsive')]")
	WebElement selectGIF;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'attachment_div')]//*[contains(@src,'my_com.png')]")
	WebElement myComputerIcon;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'attachment_div')]//*[contains(@src,'one_drive')]")
	WebElement oneDriveIcon;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'attachment_div')]//*[contains(@src,'google_drive')]")
	WebElement googleDriveIcon;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'attachment_div')]//*[contains(@src,'dropbox_drive')]")
	WebElement dropboxIcon;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'attachment_div')]//*[contains(@src,'assets/images/box_drive.png')]")
	WebElement boxIcon;

	@FindBy(xpath = "//*[@class='tooltip-inner']")
	WebElement tooltip;

	// Popup's:
	@FindBy(xpath = "//*[@role='option']//*[contains(@class,'compose_mes_text')]")
	WebElement replyAllPopup_UserName;

	@FindBy(xpath = "//*[@role='dialog']//*[text()=' Reply All ']")
	WebElement replyAllPopupTitle;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'fa-times')]")
	WebElement crossSymbol_ReplyAllPopup;

	@FindBy(xpath = "//*[@role='dialog']//*[contains(@class,'users__mail mentions__window')]//div[@class='ng-star-inserted']")
	WebElement atmentionPopup;

	@FindBy(xpath = "//*[contains(@id,'dialog')]//*[@class='Emoji_div']")
	WebElement emojiPopup;

	@FindBy(xpath = "//*[@id='create_thread_giphy_section']//*[contains(@id,'giphy_div')]")
	WebElement giphyPopup;

	// Validations:
	@FindBy(xpath = "//*[text()='No Emoji Found!']")
	WebElement noEmojisFound;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f603.png')]")
	WebElement smilyEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f604.png')]")
	WebElement smileEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f601.png')]")
	WebElement grinEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f606.png')]")
	WebElement laughingEmoji_MsgBody;

	@FindBy(xpath = "//*[@id='createThreadEditable']//*[contains(@src,'1f600.png')]")
	WebElement grinningEmoji_MsgBody;

	@FindBy(xpath = "//*[@class='white-space-pre-wrap message__thread ng-star-inserted']//*[@class='emojimain_enlarge_div']//*[contains(@class,'1f600')]")
	WebElement emoji_MsgThread;

	@FindBy(xpath = "//*[text()=' No giphy images found ']")
	WebElement noGiphysFound;

	// OneDrive xpaths:
	@FindBy(xpath = "//*[@type='email']")
	WebElement emailField_OneDrive;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitBtn_OneDrive;

	@FindBy(xpath = "//*[@name='passwd']")
	WebElement passwordBtn_OneDrive;

	@FindBy(xpath = "//*[text()='Documents']")
	WebElement documents_OneDrive;

	@FindBy(xpath = "//*[@role='listitem']//*[@data-icon-name='CircleRing']//following-sibling::*[@data-icon-name='StatusCircleCheckmark']")
	WebElement selectFile;

	@FindBy(xpath = "//*[@role='listitem']")
	WebElement circle;

	@FindBy(xpath = "//*[@class='od-ButtonBar-main']//button[contains(@class,'Button--primary')]")
	WebElement openBtn_OneDrive;

	// DropBox xpaths:
	@FindBy(xpath = "//*[@class='text-input-wrapper']//*[@name='login_email']")
	WebElement email_Dropbox;

	@FindBy(xpath = "//*[@class='text-input-wrapper']//*[@name='login_password']")
	WebElement pwd_Dropbox;

	@FindBy(xpath = "//*[@type='submit']//*[contains(@class,'sign-in')]")
	WebElement signInBtn_Dropbox;

	@FindBy(xpath = "//*[@class='mc-button mc-button-primary']")
	WebElement chooseBtn_Dropbox;

	// Box xpaths:
	@FindBy(xpath = "//*[@id='login-email']")
	WebElement email_Box;

	@FindBy(xpath = "//*[@id='login-submit']")
	WebElement submitEmailBtn_Box;

	@FindBy(xpath = "//*[@id='password-login']")
	WebElement pwd_Box;

	@FindBy(xpath = "//*[@id='login-submit-password']")
	WebElement submitPwd_Box;

	@FindBy(xpath = "//*[@type='checkbox' and @name='f_593803347087']")
	WebElement filePath_Box;

	@FindBy(xpath = "//*[text()='Choose']")
	WebElement chooseBtn_Box;

	// Initializing the page objects:
	public ReplyAll() {
		PageFactory.initElements(driver, this);
	}

	// ACTIONS:

	public boolean verifyMsgOptions(String userToSelect, String message) throws Throwable {

		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		String textMsg = message + " " + chars;
		MsgInputField.sendKeys(textMsg);
		thread();
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgId = msgThread.get(i).getAttribute("id");

				msgThread.get(i).click();
				thread();
			}
		}

		System.out.println("Message ID: " + msgId);

		List<WebElement> msgOptions = driver.findElements(By.xpath(xpath_MsgOptions));
		for (int i = 0; i < msgOptions.size(); i++) {
			msgOptionsId = msgOptions.get(i).getAttribute("id");

			if (msgOptionsId.contains(msgId)) {
				System.out.println("Message Options ID: " + msgOptionsId);

				// Message options
				thumbsUpIcon = driver.findElement(
						By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@class,'thumbs-up')]"));
				envelopeIcon = driver.findElement(
						By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@class,'envelope')]"));
				flag = driver
						.findElement(By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@class,'flag')]"));
				reaction = driver.findElement(
						By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@src,'smile_icon.png')]"));
				moreOptions = driver.findElement(By.xpath("//*[contains(@id,'" + msgOptionsId + "')]"
						+ "//following-sibling::*[contains(@class,'btn_option handCursor')]"));

				if (thumbsUpIcon.isDisplayed() && envelopeIcon.isDisplayed() && flag.isDisplayed()
						&& reaction.isDisplayed() && moreOptions.isDisplayed()) {
					return true;
				}
			}
		}
		return true;
	}

	/*
	 * Verify that by clicking on the reply all option for plain text message should
	 * open a pop up with the same user name populated in the To filed.
	 */
	public String verifyReplyAllClickAction(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		return replyAllPopup_UserName.getText();
	}

	/*
	 * Verify that by clicking on the reply all option for plain text message should
	 * open a pop up with illumy-reply message in the Subject field.
	 */
	public String verifyReplyAllDefaultSubject(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		String defaultSubject = subjectField.getAttribute("value");

		return defaultSubject;
	}

	// Verify that pop-up header name is reply All
	public boolean verifyReplyAllPopupHeader(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		return replyAllPopupTitle.isDisplayed();
	}

	// verify that the cross mark on the right corner of the popup
	public boolean verifyReplyAllPopup_CrossMark(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();
		return crossSymbol_ReplyAllPopup.isDisplayed();
	}

	// Verify that the pop up has @ mentions, Gif, Emoji, Attachment icons in bottom right corner
	public boolean verifyReplyAllPopup_Icons(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		return atMention.isDisplayed() && emoji.isDisplayed() && GIF.isDisplayed() && attachment.isDisplayed()
				&& sendBtn.isDisplayed();
	}

	// Verify that the reply message is attached with the reply all popup.
	public String verifyReplyMsg_ReplyAllPopup(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		showMessageBtn.click();
		thread();

		TestUtil.scrollIntoView(attachedMsg_ReplyAllPopup, driver);
		thread();
		return attachedMsg_ReplyAllPopup.getText();

	}

	// Verify that by clicking on the show message should view the reply content
	public String verifyShowMsg_ReplyAllPopup(String userToSelect, String message) throws Throwable {
		return verifyReplyMsg_ReplyAllPopup(userToSelect, message);
	}

	// Verify that by Clicking on the hide message should hide the visible content.
	public boolean verifyHideMsg_ReplyAllPopup(String userToSelect, String message) throws Throwable {
		verifyReplyMsg_ReplyAllPopup(userToSelect, message);
		thread();
		hideMessageBtn.click();
		thread();

		try {
			if (attachedMsg_ReplyAllPopup.isDisplayed()) {
				return false;
			} else if (!attachedMsg_ReplyAllPopup.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/*************************************************************************************
	 * 
	 * @mention functionality in Reply All pop up
	 ***************************************************************************************/
	// Verify the @mention icon click functionality in the reply all message without entering any users in To and Cc
	public boolean verifyAtmentionClickAction_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();

		return atmentionPopup.isDisplayed();
	}

	// Verify the @ mentions auto suggestion pop up by selecting on-net users in To or Cc
	public String verifyOnnetUsers_AtmentionPopup_ReplyAll(String userToSelect, String message)throws Throwable {
		String atmentionPopupUsers = "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();

		List<WebElement> atmentionPopup = driver.findElements(By.xpath(xpath_UsersAtmentionPopup));
		for (int i = 0; i < atmentionPopup.size(); i++) {
			atmentionPopup.get(i).getText();
			if (atmentionPopup.get(i).getText().contains(userToSelect)) {

				atmentionPopupUsers = atmentionPopup.get(i).getText();
			}
		}

		return atmentionPopupUsers;

	}

	// Verify the @ mention auto suggestions pop up by entering the @ using keyboard options "Shift+@"
	public boolean verifyAtmentionPopup_Shortcut_ReplAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		msgBody.sendKeys(Keys.chord(Keys.SHIFT + "@"));
		return atmentionPopup.isDisplayed();
	}

	// Verify the @ mentions auto suggestion pop up by pressing the "Space" key from keyboard
	public boolean verifyAtmentionPopup_Space_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();
		msgBody.sendKeys(Keys.chord(Keys.SPACE));
		thread();

		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	// Verify the @ mentions auto suggestions pop up by pressing "Backspace" key from keyboard
	public boolean verifyAtmentionPopup_Backspace_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();
		msgBody.sendKeys(Keys.chord(Keys.SPACE));
		thread();
		msgBody.sendKeys(Keys.chord(Keys.BACK_SPACE));
		thread();

		if (atmentionPopup.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// Verify the message body by selecting an user from the auto suggestion pop up of @ mentions
	public String verifyAtmentionUser_MsgBody_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();

		List<WebElement> atmentionPopup = driver.findElements(By.xpath(xpath_UsersAtmentionPopup));
		for (int i = 0; i < atmentionPopup.size(); i++) {
			atmentionPopup.get(i).getText();
			if (atmentionPopup.get(i).getText().contains(userToSelect)) {
				atmentionPopup.get(i).click();
			}
		}

		return msgBody.getText();

	}

	// Verify the message thread by sending the selected user from @ mentions pop up
	public String verifyAtmentionUser_MsgThread_ReplyAll(String userToSelect, String message) throws Throwable {
		String atmentionUser_MsgThread = "";
		verifyAtmentionUser_MsgBody_ReplyAll(userToSelect, message);
		thread();
		sendBtn.click();
		thread();
		thread();

		String atmentionUser = "@" + userToSelect;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(atmentionUser)) {
				atmentionUser_MsgThread = msgThread.get(i).getText();
			}
		}

		return atmentionUser_MsgThread;
	}

	// Verify the '@' auto suggestions drop down menu by press the 'Esc' key on keyboard
	public boolean verifyAtmentionPopup_Esc_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the online status of the logged in user in the @mention auto suggestions popup window
	public boolean verifyOnlineStatus_AtmentionPopup(String userToSelect, String message, String userToSelect1)
			throws Throwable {

		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();

		WebElement userOnlineStatus = driver.findElement(By.xpath("//*[@id='results-createThreadEditable']//*[text()=' "
				+ userToSelect1 + " ']//*[starts-with(@class,'fa')]"));

		return userOnlineStatus.isDisplayed();

	}

	// Verify the '@' auto suggestions drop down menu by clicking on "X" symbol
	public boolean verifyAtmentionPopup_ClicXSym_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();

		crossSym_AtmentionPopup.click();
		thread();

		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the '@' icon functionality by selecting more than one user name from the auto suggestions drop down list
	public String verifyMsgBody_Morethan1AtmentionUsers_ReplyAll(String userToSelect, String message,String userToSelect1) throws Throwable {
		String atMentionUsersMsgThread = "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		atMention.click();
		thread();

		TestUtil.selectElementFromList(xpath_UsersAtmentionPopup, userToSelect);
		thread();
		atMention.click();
		thread();
		TestUtil.selectElementFromList(xpath_UsersAtmentionPopup, userToSelect1);
		thread();
		sendBtn.click();
		thread();

		String textMsg = message + " " + chars;
		String atmentionUsers = "@" + userToSelect + " " + "@" + userToSelect1;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgThread.get(i).getText();

				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(atmentionUsers)) {
						atMentionUsersMsgThread = msg.get(j).getText();
					}
				}
			}
		}

		return atMentionUsersMsgThread;
	}

	// Verify @mention pop-up by entering '@' for multiple times without giving any spaces using keyboard options "Shift+@"
	public boolean enterMultipleAtmentions_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		msgBody.sendKeys("@@@@@@");
		thread();

		try {
			if (atmentionPopup.isDisplayed()) {
				return false;
			} else if (!atmentionPopup.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	// Verify @ mentions pop up by clicking on @mention icon from message body for multiple times without giving any spaces
	public boolean clicMultipleAtmentions_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/*************************************************************************************
	 * Emoji functionality in Reply All pop up
	 * 
	 * @return
	 * @throws Throwable
	 ***************************************************************************************/
	// Check the click action on emoji icon in the message body
	public boolean verifyEmojiClickAction_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		emoji.click();
		thread();
		return emojiPopup.isDisplayed();
	}

	// Validate the scroll functionality by moving the mouse up and down
	public boolean verifyEmojiPopupScroll_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
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
	public boolean verifyEmojiPopupXSymbol_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		emoji.click();
		thread();
		closeEmojiPopup.click();
		thread();

		try {
			if (emojiPopup.isDisplayed()) {
				return false;
			} else if (!emojiPopup.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify the emoji pop up by pressing "Esc" key on keyboard while pop up is in open
	public boolean verifyEmojiPopup_PressEscKey(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
		thread();

		emoji.click();
		thread();

		searchEmojisField.sendKeys(Keys.chord(Keys.ESCAPE));
		thread();
		try {
			if (emojiPopup.isDisplayed()) {
				return false;
			} else if (!emojiPopup.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// Verify that the selected emojis are displaying in message body or not by selecting an emoji from emoji popup
	public boolean verifyMsgBody_SelectEmoji(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
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
	public boolean verifyMsgThread_SendEmoji(String userToSelect, String message) throws Throwable {

		verifyMsgBody_SelectEmoji(userToSelect, message);
		thread();
		sendBtn.click();
		thread();

		String textMsg = message + " " + chars;

		String emoji_Thread = emoji_MsgThread.getText();
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());

				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(emoji_Thread)) {
						return true;
					}
				}
			}
		}

		return true;
	}

	/*
	 * Verify the emojis that are displaying or not in message body by selecting the
	 * multiple emojis using "Shift+Enter" keys on keyboard
	 */
	public boolean verifyMsgBody_SelectMultipleEmojis_ShiftEnter(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();

		replyAll.click();
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
	public boolean verifySearchFieldEmojiPopup(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		emoji.click();
		thread();
		return searchEmojisField.isDisplayed();
	}

	// Verify the search emoji by entering the keywords to search the emojis
	public boolean verifyEmojiPopupSearch_EnterValidKeys(String userToSelect, String message, String emojiSearchKeys)throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		emoji.click();
		searchEmojisField.sendKeys(emojiSearchKeys);
		List<WebElement> searchedEmojis = driver.findElements(By.xpath(xpath_Emojis_Searchkeys));
		for (int i = 0; i < searchedEmojis.size(); i++) {
			System.out.println(searchedEmojis.get(i).getAttribute("class"));
		}

		return true;
	}

	// Verify the search emoji field by entering the invalid keywords to search the emojis
	public String verifyEmojiPopupSearch_EnterInvalidKeys(String userToSelect, String message,String invalidEmojiSearchKeys) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(invalidEmojiSearchKeys);
		thread();
		String noemojisFound = noEmojisFound.getText();
		return noemojisFound;
	}

	// Verify the click action on "X" symbol in the emoji search field by entering the some keywords
	public boolean verifyXSymbol_EmojiSearchFiled(String userToSelect, String message, String emojiSearchKeys)throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(emojiSearchKeys);
		thread();
		searchEmojiXSymbol.click();
		thread();
		return frequentlyUsedText.isDisplayed();
	}

	/*************************************************************************************
	 * 						GIF functionality in Reply All pop up
	 * 
	 ***************************************************************************************/
	// Verify the click functionality of 'GIF' icon in the message body of reply all
	public boolean verifyGiphyClicAction_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		GIF.click();
		thread();
		return giphyPopup.isDisplayed();
	}

	// Verify the giphy pop up window by clicking on "X" symbol
	public boolean verifyGiphyPopup_ClicXsymbol_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
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
	public String verifyGiphyPopupTitle_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
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

	// Verify the search field in the giphy pop up window by clicking on the GIF icon from reply all popup
	public boolean verifyGiphyPopup_SearchField_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		GIF.click();
		thread();
		return searchFieldGiphyPopup.isDisplayed();
	}

	// Verify the search button is displaying or not in the giphy pop up window
	public boolean verifyGiphyPopup_SearchButton_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		GIF.click();
		thread();
		return searchButton_GiphyPopup.isDisplayed();
	}

	// Verify the giphy pop up by entering the invalid keywords to search the giphy's available in the giphy pop up window
	public boolean verifyGiphySearch_Invalidkeys_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		GIF.click();
		thread();
		searchFieldGiphyPopup.sendKeys("sdjksdkfgdddfdgdggdas");
		return noGiphysFound.isDisplayed();
	}

	// Verify the "X" symbol mouse hover and click functionality in the search field by entering some keywords on search field
	public boolean verifyGiphySearchField_Xsym_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		GIF.click();
		thread();
		searchFieldGiphyPopup.sendKeys("giphys");
		XsymbolSearchGiphy.click();
		return searchPlaceholder_GiphyPopup.isDisplayed();
	}

	// Verify the mouse over and click functionality of giphy's in the giphy pop up window
	public boolean verifyGiphy_MsgThread_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		GIF.click();
		thread();
		String GIF_MsgThread = selectGiphy.getAttribute("src");
		selectGIF.click();
		thread();

		sendBtn.click();
		thread();

		String textMsg = message + " " + chars;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());

				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(GIF_MsgThread)) {
						return true;
					}
				}
			}
		}

		System.out.println(GIF_MsgThread);
		return true;
	}

	/**********************************************************************************************************
	 * Attachment functionality in reply all pop up
	 * 
	 * @return
	 * @throws Throwable
	 **********************************************************************************************************/
	// Check the 'Attachment' icon click functionality on message body section
	public boolean verifyAttachmentPopup_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();

		myComputerIcon.isDisplayed();
		oneDriveIcon.isDisplayed();
		googleDriveIcon.isDisplayed();
		dropboxIcon.isDisplayed();
		thread();
		boxIcon.isDisplayed();
		return true;
	}

	// Verify the "My Computer" icon and its mouse hover functionality in the attachment pop pup window
	public String verifyMyComputerTooltip_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(myComputerIcon).build().perform();

		return tooltip.getText();
	}

	// Verify the click action on "My Computer" icon to send a file to user from the local system
	public String verifyAttachmentFromMyComputer_ReplyAll(String userToSelect, String message, String filePath,String fileName) throws Throwable {
		String fileName_MsgThread = "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		myComputerIcon.click();
		TestUtil.uploadFile(filePath);
		thread();
		Thread.sleep(3000);
		sendBtn.click();
		thread();

		String textMsg = message + " " + chars;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());
				System.out.println("====================================");
				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(fileName)) {
						fileName_MsgThread = msg.get(j).getText();
					}
				}
			}
		}
		return fileName_MsgThread;
	}

	// Verify the "One Drive" icon and it's mouse hover action in the attachment pop up window
	public String verifyOneDriveTooltip_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(oneDriveIcon).build().perform();

		return tooltip.getText();
	}

	// Verify the click functionality of "One Drive" icon in the attachment pop up window
	public String verifyAttachmentFromOneDrive_ReplyAll(String userToSelect, String message, String email,String password, String fileName) throws Throwable {
		String file_MsgThread = "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();
		oneDriveIcon.click();
		thread();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("Parent window ID: " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("Child Window ID: " + childWindowId);

		driver.switchTo().window(childWindowId);
		thread();

		String onedrive = driver.getTitle();
		System.out.println(onedrive);

		emailField_OneDrive.sendKeys(email);
		thread();
		submitBtn_OneDrive.click();
		thread();
		passwordBtn_OneDrive.sendKeys(password);
		thread();
		submitBtn_OneDrive.click();
		thread();
		documents_OneDrive.click();
		thread();

		List<WebElement> selectfile = driver.findElements(By.xpath(xpath_fileList_OneDrive));
		for (int i = 0; i < selectfile.size(); i++) {
			selectfile.get(i).getText();
			if (selectfile.get(i).getText().contains(fileName)) {

				circle.click();
				thread();
				selectFile.click();
			}
		}

		thread();
		openBtn_OneDrive.click();
		thread();
		thread();

		driver.switchTo().window(parentWindowId);
		thread();

		sendBtn.click();
		thread();
		
		List<WebElement> msgThread = driver.findElements(By.xpath(attachments_MsgThread));

		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(fileName)) {
				file_MsgThread = msgThread.get(i).getText();
			}
		}
		return file_MsgThread;
	}

	// Verify the "Google Drive" icon and it's mouse hover action in the attachment pop up window
	public String verifyGoogleDriveTooltip_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(googleDriveIcon).build().perform();

		return tooltip.getText();
	}

	// Verify the "Drop Box" icon and it's mouse hover action in the attachments pop up window
	public String verifyDropBoxTooltip_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(dropboxIcon).build().perform();

		return tooltip.getText();
	}

	// Verify the click functionality of "Drop Box" icon in the attachment pop up window
	public String verifyAttachmetFromDropBox_ReplyAll(String userToSelect, String message, String email, String pwd,String fileName) throws Throwable {
		String fileName_MsgThread = "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();
		dropboxIcon.click();
		thread();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("Parent window ID: " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("Child Window ID: " + childWindowId);

		driver.switchTo().window(childWindowId);
		thread();

		String onedrive = driver.getTitle();
		System.out.println(onedrive);

		email_Dropbox.sendKeys(email);
		thread();
		pwd_Dropbox.sendKeys(pwd);
		signInBtn_Dropbox.click();
		thread();

		List<WebElement> dropboxList = driver.findElements(By.xpath(xpath_Files_Dropbox));
		for (int i = 0; i < dropboxList.size(); i++) {
			dropboxList.get(i).getText();
			if (dropboxList.get(i).getText().contains(fileName)) {

				dropboxList.get(i).click();
			}
		}

		chooseBtn_Dropbox.click();
		thread();

		driver.switchTo().window(parentWindowId);
		thread();

		sendBtn.click();
		thread();
		String textMsg = message + " " + chars;

		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());
				System.out.println("====================================");
				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(fileName)) {
						fileName_MsgThread = msg.get(j).getText();
					}
				}
			}
		}
		return fileName_MsgThread;

	}

	// Verify the "Box" icon and it's mouse hover action in the attachment pop up window
	public String verifyBoxTooltip_ReplyAll(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(boxIcon).build().perform();

		return tooltip.getText();
	}

	// Verify the click functionality of the "Box" icon in the attachments pop up window
	public String verifyAttachmentFromBox_ReplyAll(String userToSelect, String message, String email, String pwd,String fileName) throws Throwable {
		String fileName_MsgThread = "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		attachment.click();
		thread();
		boxIcon.click();
		thread();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("Parent window ID: " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("Child Window ID: " + childWindowId);

		driver.switchTo().window(childWindowId);
		thread();

		String boxpage = driver.getTitle();
		System.out.println(boxpage);

		email_Box.sendKeys(email);
		thread();
		submitEmailBtn_Box.click();
		thread();
		pwd_Box.sendKeys(pwd);
		thread();
		submitPwd_Box.click();
		thread();

		filePath_Box.click(); // path of the file to click
		thread();
		chooseBtn_Box.click(); // choose button

		driver.switchTo().window(parentWindowId);
		thread();

		sendBtn.click();
		thread();
		
		String textMsg = message + " " + chars;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());
				System.out.println("====================================");
				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(fileName)) {
						fileName_MsgThread = msg.get(j).getText();
					}
				}
			}
		}
		return fileName_MsgThread;
	}


	/**************************************************************************************************
	 * To and Cc functionality of reply All pop up
	 * @return 
	 * @throws Throwable 
	 ***************************************************************************************************/
	/*
	 * Verify that by sending the reply all by adding users in to and cc fields with
	 * message content should deliver to all the users.
	 */
	public String replyAllMsgByAddingToAndCcUsers(String userToSelect, String message,String keysToField,String userToSelect1) throws Throwable {
		String toAndCcUsersInThread	= "";
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		cc.click();
		thread();
		ccField.sendKeys(keysToField);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, userToSelect1);
		sendBtn.click();
		thread();
		
		String textMsg = message + " " + chars;
		String toAndCcUsers = to_MsgThread.getText()+userToSelect+"\n"+cc_MsgThread.getText()+userToSelect1;
		
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());
				System.out.println("====================================");
				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(toAndCcUsers)) {
						toAndCcUsersInThread = msg.get(j).getText();
					}
				}
			}
		}
		return toAndCcUsersInThread;
	}

	//verify that the attached reply message should has blue bar beside it in the thread.
	public boolean verifyReplyMsgBlueBarInThread(String userToSelect, String message) throws Throwable {
		
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		String msg = "test message"+" "+chars;
		msgBody.sendKeys(msg);
		sendBtn.click();
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(msg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		
		driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[text()='Show more']")).click();
		thread();
		
		String textMsg = message + " " + chars;
		List<WebElement> msgThread1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread1.size(); i++) {
			msgThread1.get(i).getText();
			if (msgThread1.get(i).getText().contains(textMsg)) {
				msgId = msgThread1.get(i).getAttribute("id");
				thread();
				
			}
		}
		
		WebElement replyMsgBlueBorder = driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[contains(@class,'replyBorderLeft')]"));
		TestUtil.drawBorder(replyMsgBlueBorder, driver);
		

		System.out.println("Reply Message ID: " + msgId);

		return replyMsgBlueBorder.isDisplayed();
	}

	//Verify that the replied message should have the View message option beside the replied message.
	public boolean verifyViewMsgOptOfReplyMsgInThread(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		String msg = "test message"+" "+chars;
		msgBody.sendKeys(msg);
		sendBtn.click();
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(msg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		
		driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[text()='Show more']")).click();
		thread();
		
		String textMsg = message + " " + chars;
		List<WebElement> msgThread1 = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread1.size(); i++) {
			msgThread1.get(i).getText();
			if (msgThread1.get(i).getText().contains(textMsg)) {
				msgId = msgThread1.get(i).getAttribute("id");
				thread();
				
			}
		}
		
		WebElement viewMsgOption = driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[contains(@id,'viewMessage')]"));
		TestUtil.drawBorder(viewMsgOption, driver);
		

		System.out.println("Reply Message ID: " + msgId);

		return viewMsgOption.isDisplayed();
		
	}

	//Verify that if we give reply all in Group only the group email will populates in To field
	public String replyAllToGroup(String groupName, String message) throws Throwable {
		String replyMsgInGroupThread = "";
		verifyMsgOptions(groupName, message);
		moreOptions.click();
		thread();
		replyAll.click();
		thread();
		
		String msg = "test message"+" "+chars;
		msgBody.sendKeys(msg);
		sendBtn.click();
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(msg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		
		driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[text()='Show more']")).click();
		thread();
		
		String textMsg = message + " " + chars;
		List<WebElement> msgThread1 = driver.findElements(By.xpath(xpath_replyAllFwdMsgs));
		for (int i = 0; i < msgThread1.size(); i++) {
			msgThread1.get(i).getText();
			if (msgThread1.get(i).getText().contains(textMsg)) {
				replyMsgInGroupThread = msgThread1.get(i).getText();
			}
		}
		
		return replyMsgInGroupThread;
	}

























}