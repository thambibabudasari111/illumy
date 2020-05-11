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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class MessageInputFieldOptions extends TestBase{

	public MessageInputFieldOptions() {
		PageFactory.initElements(driver, this);
	}
	
	String xpath_ConversationList		= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_AtmentionsAutoSugg		= "//*[@class='slimScrollDiv']//*[@id='results-editable']//*[@role='option']//a";
	String xpath_ThreadMsgs				= "//*[contains(@id,'msg_')]";
	String xpath_FrequentlyUsedEmojisList= "//*[contains(@id,'fel_1f')]";
	String xpath_GiphysMsgThread		= "//*[@class='white-space-pre-wrap message__thread ng-star-inserted']//*[@class='gifplayer-wrapper']//img";
	String xpath_EmojiShortNames		= "//*[@class='slimScrollDiv']//*[@id='results-editable']//*[@role='option']";
	String attachments_MsgThread		= "//*[contains(@class,'attachment__thread')]//*[contains(@class,'iniviteFolder')]//*[starts-with(@class,'text_overlap')]";
	String xpath_FilesList				= "//*[contains(@id,'file_options')]//*[starts-with(@class,'contant_name_elipsis')]";
	String xpath_Emojis_Searchkeys		= "//*[@class='smily_inner ng-star-inserted']//*[@class='ng-star-inserted']//div//span";
	String xpath_fileList_OneDrive		= "//*[@role='listitem']";
	
	
	
	//Page Factory: OR
	@FindBy(xpath	= "//*[@id='editable']")
	WebElement atmention_InputField;
	
	@FindBy(xpath	= "//*[contains(@class,'users__mail mentions__window')]//div[@class='ng-star-inserted']")
	WebElement atmentionPopup;
	
	@FindBy(xpath	= "//*[@type='button']//*[contains(@class,'fa fa-at')]")
	WebElement atMention;
	
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[@role='option']//a")
	WebElement users_AtmentionsPopup;
	
	@FindBy(xpath="//*[@id='mention-items-editable']//*[@class='slimScrollDiv']//*[@id='results-editable']//*[@id='everyone']//a")
	WebElement everyOneOption_Group;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Flags']")
	WebElement flags;
	
	@FindBy(xpath="//*[@id='mention-items-editable']//*[contains(@class,'list-header')]")
	WebElement peopleMatchingText;
	
	@FindBy(xpath="//*[@id='mention-items-editable']//*[@class='padlr10']")
	WebElement tabOrNavigateText;
	
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[@role='listbox']//*[@role='option']//a//*[contains(@class,'fa fa-circle')]")
	WebElement onlineStatus;
	
	@FindBy(xpath="//*[contains(@class,'close_btn')]")
	WebElement XSymbol_AtmentionPopup;
	
	@FindBy(xpath="//*[@data-target='#emoji_divi']")
	WebElement emoji;
	
	@FindBy(xpath="//*[@class='Emoji_div']")
	WebElement emojiPopup;
	
	@FindBy(xpath="//*[@title='Frequently Used']//*[contains(@class,'clock')]")
	WebElement clockSymbolEmojiPopup;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted active']")
	WebElement highlightedEmoji;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted active']//span")
	WebElement frequentlyUsedEmoji;
	
	@FindBy(xpath="//*[text()='Frequently Used']")
	WebElement frequentlyUsedText;

	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']")
	WebElement emojisList;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f1fa-1f1f8')]")
	WebElement EmojiPopupScroll; 
	
	@FindBy(xpath="//*[contains(@src,'1f1fa-1f1f8.png')]")
	WebElement usFlag;
	
	@FindBy(xpath="//*[@title='Close']")
	WebElement closeEmojiPopup;
	
	@FindBy(xpath="//*[@id='emoji_search']//input")
	WebElement searchEmojisField;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f600')]")
	WebElement grinningEmoji;
	
	@FindBy(xpath="//*[contains(@src,'1f600.png')]")
	WebElement grinningEmoji_MsgInputField;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f600')]")
	WebElement ginnigEmoji;
	
	@FindBy(xpath="//*[@class='white-space-pre-wrap message__thread ng-star-inserted']//*[@class='emojimain_enlarge_div']//*[contains(@class,'1f600')]")
	WebElement emoji_MsgThread;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'_1f603')]")
	WebElement grinningFaceWithBigEyes;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f604')]")
	WebElement grinnigFaceWithSmilingEyes;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'_1f601')]")
	WebElement beamingFaceWithSmileEyes;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f606')]")
	WebElement grinningSquintingFace;
	
	@FindBy(xpath="//*[contains(@src,'1f603.png')]")
	WebElement smilyEmoji_MsgInputField;
	
	@FindBy(xpath="//*[contains(@src,'1f604.png')]")
	WebElement smileEmoji_MsgInputField;
	
	@FindBy(xpath="//*[contains(@src,'1f601.png')]")
	WebElement grinEmoji_MsgInputField;
	
	@FindBy(xpath="//*[contains(@src,'1f606.png')]")
	WebElement laughingEmoji_MsgInputField;
	
	@FindBy(xpath="//*[text()='No Emoji Found!']")
	WebElement noEmojisFound;
	
	@FindBy(xpath="//*[@id='emoji_search']//*[@class='fas fa-times']")
	WebElement searchEmojiXSymbol;
	
	@FindBy(xpath="//*[@class='col-sm-10 text_overlap pad_r0 ng-star-inserted']//span[@class='text-gray font13']")
	WebElement emojiShortNames;
	
	@FindBy(xpath="//*[contains(@data-target,'giphy')]//*[contains(@class,'gif')]")
	WebElement GIF;
	
	@FindBy(xpath="//*[contains(@id,'giphy_div')]")
	WebElement giphyPopup;
	
	@FindBy(xpath="//*[contains(@id,'giphy_div')]//*[@title='Close']//*[@class='fas fa-times']")
	WebElement XsymGiphyPopup;
	
	@FindBy(xpath="//*[@class='powerd_giphy']")
	WebElement poweredGiphy;
	
	@FindBy(xpath="//*[@name='search']")
	WebElement searchFieldGiphyPopup;
	
	@FindBy(xpath="//*[@type='button' and text()='Search ']")
	WebElement searchButton_GiphyPopup;
	
	@FindBy(xpath="//*[text()=' No giphy images found ']")
	WebElement noGiphysFound;
	
	@FindBy(xpath="//*[@type='button']//*[@class='fas fa-times']")
	WebElement XsymbolSearchGiphy;
	
	@FindBy(xpath="//*[@placeholder='Search']")
	WebElement searchPlaceholder_GiphyPopup;
	
	@FindBy(xpath="//*[@id='giphyOne']//*[contains(@class,'img-responsive')]")
	WebElement selectGiphy;
	
	
	@FindBy(xpath="//*[contains(@class,'gifplayer')]//*[contains(@src,'giphy')]")
	WebElement giphysMsgThread;
	
	@FindBy(xpath="//*[@id='mention-items-editable']//*[@class='ng-star-inserted']")
	WebElement emojisShortNamesPopup;
	
	@FindBy(xpath="//*[contains(@class,'close_btn')]//*[@class='fas fa-times']")
	WebElement xSymbol_EmojiPopupMsgInputField;
	
	@FindBy(xpath="//*[contains(@src,'1f41f.png')]")
	WebElement fishEmoji_MsgInputField;
	
	@FindBy(xpath="//*[@id='1f41f']//a")
	WebElement fishEmoji;
	
	@FindBy(xpath="//*[contains(@class,'attachment_div')]//*[contains(@src,'my_com.png')]")
	WebElement myComputerIcon;
	
	@FindBy(xpath="//*[contains(@class,'attachment_div')]//*[contains(@src,'one_drive')]")
	WebElement oneDriveIcon;
	
	@FindBy(xpath="//*[contains(@class,'attachment_div')]//*[contains(@src,'google_drive')]")
	WebElement googleDriveIcon;
	
	@FindBy(xpath="//*[contains(@class,'attachment_div')]//*[contains(@src,'dropbox_drive')]")
	WebElement dropboxIcon;
	
	@FindBy(xpath="//*[contains(@class,'attachment_div')]//*[@title='Box']")
	WebElement boxIcon;
	
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'paperclip')]")
	WebElement attachment;
	
	@FindBy(xpath="//*[@class='attachment_div demo-droppable text-center']")
	WebElement attachmentPopup;
	
	@FindBy(xpath="//*[@class='tooltip-inner']")
	WebElement tooltip;
	
	@FindBy(xpath="//*[@type='email' and @aria-label='Email, phone, or Skype']")
	WebElement oneDrive_Email;
	
	@FindBy(xpath="//*[text()='Files']")
	WebElement files;
	
	//OneDrive xpaths: 
	@FindBy(xpath	= "//*[@type='email']")
	WebElement emailField_OneDrive;
	
	@FindBy(xpath	= "//*[@type='submit']")
	WebElement submitBtn_OneDrive;
	
	@FindBy(xpath	= "//*[@name='passwd']")
	WebElement passwordBtn_OneDrive;
	
	@FindBy(xpath	= "//*[text()='Documents']")
	WebElement documents_OneDrive;
	
	@FindBy(xpath="//*[@role='listitem']//*[@data-icon-name='CircleRing']//following-sibling::*[@data-icon-name='StatusCircleCheckmark']")
	WebElement selectFile;
	
	@FindBy(xpath="//*[@role='listitem']")
	WebElement circle;
	
	@FindBy(xpath="//*[@class='od-ButtonBar-main']//button[contains(@class,'Button--primary')]")
	WebElement openBtn_OneDrive;
	
	//Actions:
	
	/*
	 * Verify the click action on '@' icon from message input field of on-net users P2P message thread
	 */
	public String verifyAtMentionClilckAction(String userToSelect,String userToSelect1) throws Throwable{
		String user1="";
		String user2="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		atMention.click();
		atmention_InputField.isDisplayed();
		List<WebElement>atmentionsAutoSugg=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		System.out.println(atmentionsAutoSugg.size());
		for(int i=0;i<atmentionsAutoSugg.size();i++) {
			atmentionsAutoSugg.get(i).getText();
			if(atmentionsAutoSugg.get(i).getText().contains(userToSelect)) {
				user1=atmentionsAutoSugg.get(i).getText();
			}
			if(atmentionsAutoSugg.get(i).getText().contains(userToSelect1)) {
				user2=atmentionsAutoSugg.get(i).getText();
			}
		}
		String users=user1+"\n"+user2;
		
		return users;
	}
	
	//Verify the @ mentions auto suggestion pop up  of the off-net user
	public String verifyAtmentionClickAction_OffnetUser(String offnetUserToSelect,String userToSelect) throws Throwable {
		String onnetUser="";
		TestUtil.selectElementFromList(xpath_ConversationList, offnetUserToSelect);
		thread();
		atMention.click();
		atmention_InputField.isDisplayed();
	
		List<WebElement>atmentionsAutoSugg=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		System.out.println(atmentionsAutoSugg.size());
		for(int i=0;i<atmentionsAutoSugg.size();i++) {
			atmentionsAutoSugg.get(i).getText();
			if(atmentionsAutoSugg.get(i).getText().contains(userToSelect)) {
				onnetUser=atmentionsAutoSugg.get(i).getText();
			}
		}
		
		return onnetUser;
	}
	
	//Verify the @ mentions auto suggestion pop up for groups by clicking on the "@" icon in the message input field
	public String verifyAtmentionsClickAction_Group(String groupName,String everyoneOption) throws Throwable {
		String everyone="";
		TestUtil.selectElementFromList(xpath_ConversationList,groupName);
		thread();
		atMention.click();
		atmention_InputField.isDisplayed();
		
		List<WebElement>atmentionsAutoSugg=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		System.out.println(atmentionsAutoSugg.size());
		for(int i=0;i<atmentionsAutoSugg.size();i++) {
			atmentionsAutoSugg.get(i).getText();	
			
			if(atmentionsAutoSugg.get(i).getText().contains(everyoneOption)) {
				everyone=atmentionsAutoSugg.get(i).getText();
			}
		}
		return everyone;
	}
	
	//Verify the message input field by selecting the "Everyone" option from the @mentions popup
	public String verifyEveryone_GroupMsgInputField(String groupName,String everyoneOption) throws Throwable {
		verifyAtmentionsClickAction_Group(groupName,everyoneOption);
		everyOneOption_Group.click();
		String everyone=MsgInputField.getText();
		return everyone;
	}
	
	//Verify the message thread by sending the text message by selecting the "Everyone" from @mentions auto suggestions popup
	public String verifyMsgThread_Text_Everyone(String groupName,String everyoneOption,String textMsg) throws Throwable {
		String everyone_Text="";
		TestUtil.selectElementFromList(xpath_ConversationList,groupName);
		thread();
		atMention.click();
		TestUtil.selectElementFromList(xpath_AtmentionsAutoSugg,everyoneOption);
		thread();
		MsgInputField.sendKeys(textMsg);
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		thread();
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			String messageThread="@everyone"+" "+textMsg;
			if(msgThread.get(i).getText().contains(messageThread)) {
				everyone_Text=msgThread.get(i).getText();
			}
		}
		return everyone_Text;
	}
	
	//Verify the @ mention auto suggestions pop up by entering the @ using keyboard options "Shift+@"
	public String verifyAtmentionPopup_ShiftAndAtmention(String userToSelect,String userToSelect1) throws Throwable {
		String user1="";
		String user2="";
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		MsgInputField.isDisplayed();
		MsgInputField.sendKeys(Keys.SHIFT,"@");
		
		List<WebElement>atmentionsAutoSugg=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		System.out.println(atmentionsAutoSugg.size());
		for(int i=0;i<atmentionsAutoSugg.size();i++) {
			atmentionsAutoSugg.get(i).getText();
			if(atmentionsAutoSugg.get(i).getText().contains(userToSelect)) {
				user1=atmentionsAutoSugg.get(i).getText();
			}
			if(atmentionsAutoSugg.get(i).getText().contains(userToSelect1)) {
				user2=atmentionsAutoSugg.get(i).getText();
			}
		}
		String users=user1+"\n"+user2;
		
		return users;
	}
	
	//Verify the @ mentions auto suggestion pop up by pressing the "Space" key from keyboard
	public boolean verifyAtmentionPopup_SpaceKey(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		MsgInputField.sendKeys("@");
		thread();
		MsgInputField.sendKeys(Keys.SPACE);
		try {
		if(!atmentionPopup.isDisplayed()) {
			return true;
		}else if(atmentionPopup.isDisplayed()) {
			return false;
		}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//Verify the @ mentions auto suggestions pop up by pressing "Backspace" key from keyboard 
	public boolean verifyAtmentionPopup_Backspace(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		MsgInputField.sendKeys("@");
		thread();
		MsgInputField.sendKeys(Keys.SPACE);
		thread();
		MsgInputField.sendKeys("\b");
		thread();
		return atmentionPopup.isDisplayed();
	
	}
	
	//Verify the message input field by selecting an user from the auto suggestion pop up of @ mentions
	public String verifyMsgInputField_AtmentionUser(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		List<WebElement>atmentionPopup=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		for(int i=0;i<atmentionPopup.size();i++) {
			atmentionPopup.get(i).getText();
			if(atmentionPopup.get(i).getText().contains(userToSelect)) {
				atmentionPopup.get(i).click();
			}
		}
		
		String userNameWithAtmention=MsgInputField.getText();
		return userNameWithAtmention;
	}
	
	//Verify the message thread by sending the selected user from @ mentions pop up 
	public String verifyMsgThread_AtmentionUser(String userToSelect,String keysToSend) throws Throwable {
		String msgThreaUser_Text="";
		verifyMsgInputField_AtmentionUser(userToSelect);
		MsgInputField.sendKeys(keysToSend);
		thread();
		MsgInputField.sendKeys(Keys.ENTER);
		thread();
		String atmention_Text=userToSelect+" "+keysToSend;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(atmention_Text)) {
				msgThreaUser_Text=msgThread.get(i).getText();
			}
		}
		return msgThreaUser_Text;
	}
	
	//Validate the text 'people matching "@" in the at mentions pop up  by clicking on '@' icon
	public boolean validatePeopleMatchingText_AtmentionPopup(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		return peopleMatchingText.isDisplayed();
	}
	
	//Verify the text 'tab or to navigate' in the at mentions pop up by clicking on '@' icon
	public boolean verifyTaborNavigateText_AtmentionPopup(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		return tabOrNavigateText.isDisplayed();
	}
	
	//Verify the '@' auto suggestions drop down menu by press the 'Esc' key on keyboard
	public boolean verifyAtmentionPopup_EscKey(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		MsgInputField.sendKeys(Keys.ESCAPE);
		thread();
		try {
			if(!atmentionPopup.isDisplayed()) {
				return true;
			}else if(atmentionPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;
	}
	
	//Verify the online status of the logged in user in the @mention auto suggestions popup window
	public void verifyOnlineStatus_AtmentionPopup(String userToSelect) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		
		List<WebElement>atmentionsAutoSugg=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		System.out.println(atmentionsAutoSugg.size());
		for(int i=0;i<atmentionsAutoSugg.size();i++) {
			atmentionsAutoSugg.get(i).getText();
			onlineStatus.isDisplayed();
			TestUtil.drawBorder(onlineStatus, driver);
			thread();
			
		}
	}
	
	//Verify the message input field by selecting an user from @mentions pop up using "Enter" key using keyboard
	public String verifyMsgInput_SelectUser_AtmentionPopup(String userToSelect) throws Throwable {
		String user_MsgInputField="";
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		List<WebElement>atmentionPopup=driver.findElements(By.xpath(xpath_AtmentionsAutoSugg));
		for(int i=0;i<atmentionPopup.size();i++) {
			atmentionPopup.get(i).getText();
		
			if(atmentionPopup.get(i).getText().contains(userToSelect))
			
				atmentionPopup.get(i).click();
			
		}
		user_MsgInputField=MsgInputField.getText();
		return user_MsgInputField;
	}
	
	//Verify the '@' auto suggestions popup by clicking on "X" symbol 
	public boolean verifyAtmentionPopup_ClickXSymbol(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		XSymbol_AtmentionPopup.click();
		return true;
	}
	
	//Verify the '@' icon functionality by selecting more than one user name from the auto suggestions drop down list
	public String verifyMsgThreadSendingTwoAtmentionUsers(String userToSelect,String userToSelect1) throws Throwable {
		String atmentionusersMsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		atMention.click();
		thread();
		TestUtil.selectElementFromList(xpath_AtmentionsAutoSugg,userToSelect);
		thread();
		atMention.click();
		thread();
		TestUtil.selectElementFromList(xpath_AtmentionsAutoSugg,userToSelect1);
		thread();
		MsgInputField.sendKeys(Keys.ENTER);
		thread();
		String atmentionUsers_MsgThread="@"+userToSelect+" "+"@"+userToSelect1;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(atmentionUsers_MsgThread)) {
				atmentionusersMsgThread=msgThread.get(i).getText();
				
			}
		}
		return atmentionusersMsgThread;
	}
	
	//Verify @mention pop up by entering '@' for multiple times without giving any spaces using keyboard options "Shift+@"
	public boolean verifyAtmentionPopup_EnterMultipleAtmentions(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
		thread();
		MsgInputField.sendKeys("@");
		thread();
		MsgInputField.sendKeys("@");
		MsgInputField.sendKeys("@");
		thread();
		MsgInputField.sendKeys("@");
		thread();
		
		try {
			if(!atmentionPopup.isDisplayed()) {
				return true;
			}else if(atmentionPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;
	}
	
	//Verify @ mentions pop up by clicking on @mention icon from message input field for multiple times without giving any spaces
	public boolean verifyAtmentionPopup_ClickMultipleAtmentions(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList,userToSelect);
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
			if(!atmentionPopup.isDisplayed()) {
				return true;
			}else if(atmentionPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;
	}
	
	

	/*************************************************************************************************
	 * 						EMOJI FUNCTIONALITY IN MESSAGE INPUT FIELD
	************************************************************************************************/
	
	//Check  the click action on emoji icon in the message input field 
	public boolean verify_EmojiClickAction(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		boolean emojis_Menu=emojiPopup.isDisplayed();
		TestUtil.drawBorder(emojiPopup, driver);
		thread();
		return emojis_Menu;
	}
	
	//Verify the frequently used emoji's in the emoji pop up by clicking on emoji icon from message input field
	public void verifyFrequentlyUseddEmojis(String userToSelect) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		clockSymbolEmojiPopup.click();
		highlightedEmoji.isDisplayed();
		String bgColor=highlightedEmoji.getCssValue("background-color");
		String actualColor=Color.fromString(bgColor).asHex();
		System.out.println(actualColor);
		String frequentlyusedEmoji=frequentlyUsedEmoji.getAttribute("class");
		System.out.println(frequentlyusedEmoji);
		
		List<WebElement>frequentlyUsedEmojis=driver.findElements(By.xpath(xpath_FrequentlyUsedEmojisList));
		for(int i=0;i<frequentlyUsedEmojis.size();i++) {
			frequentlyUsedEmojis.get(i).getText();
			if(frequentlyUsedEmojis.get(i).getText().contains(frequentlyusedEmoji)) {
				frequentlyUsedEmojis.get(i).click();
				thread();
			}
		}
		
	}
	
	//Validate the scroll functionality of emoji pop up by moving the mouse up and down
	public boolean verifyEmojiPopupScroll(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		JavascriptExecutor js=((JavascriptExecutor)driver);
		WebElement element=EmojiPopupScroll;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		thread();
		String flag=usFlag.getText();
		if(MsgInputField.getText().contains(flag)){
			return true;
		}
		else {
			return false;
		}
	}
	
	/*Verify the emoji pop up window by clicking on "X" symbol 
	 * by clicking on emoji icons from message input field
	*/
	public boolean verifyEmojiPopup_ClickXSymbol(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		closeEmojiPopup.click();
		thread();
		try {
			if(!emojiPopup.isDisplayed()) {
				return true;
			}else if(emojiPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;
		
	}
	
	//Verify the emoji pop up by pressing "Esc" key on keyboard while pop up is in open 
	public boolean verifyEmojiPopup_EscKey(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys(Keys.ESCAPE);
		thread();
		try {
			if(!emojiPopup.isDisplayed()) {
				return true;
			}else if(emojiPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;
		
	}
	
	//Verify that the selected emojis are displaying in message input field or not by selecting an emoji from emoji popup 
	public boolean verifyMsgInputField_SelectEmoji(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		grinningEmoji.click();
		thread();
		String grinningEmoji=grinningEmoji_MsgInputField.getText();
		if(MsgInputField.getText().contains(grinningEmoji)){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//Verify the message thread by sending an emoji from message input field
	public boolean verifyMsgThread_SendEmoji(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.click();
		emoji.click();
		thread();
		grinningEmoji.click();
		thread();
		thread();
		
		MsgInputField.sendKeys(Keys.ENTER);
		thread();
		String emoji=emoji_MsgThread.getText();
		
		List<WebElement>msgThreadEmojis=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThreadEmojis.size();i++) {
			msgThreadEmojis.get(i).getText();
			if(msgThreadEmojis.get(i).getText().contains(emoji)) {
				return true;
			}
			
		}
		return true;
	}
	
	//Verify the emojis that are displaying or not in message input field by selecting the multiple emojis using "Shift+Enter" keys on keyboard
	public boolean verifyMsgInputField_SelectEmojisShiftEnter(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		Actions action=new Actions(driver);
		action.keyDown(Keys.SHIFT).click(grinningFaceWithBigEyes).click(grinningEmoji)
		.click(grinnigFaceWithSmilingEyes).click(beamingFaceWithSmileEyes).click(grinningSquintingFace)
		.keyUp(Keys.SHIFT).build().perform();
		thread();
		String grinningEmoji=grinningEmoji_MsgInputField.getText();
		String smily=smilyEmoji_MsgInputField.getText();
		String smile=smileEmoji_MsgInputField.getText();
		String grin=grinEmoji_MsgInputField.getText();
		String laugh=laughingEmoji_MsgInputField.getText();
		String emojisMsgInputField=grinningEmoji+smily+smile+grin+laugh;
		
		if(MsgInputField.getText().contains(emojisMsgInputField)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//Verify the search emoji field by entering the keywords to search the emojis
	public boolean verifyEmojiPopupSearch_EnterValidKeys(String userToSelect) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys("smile");
		thread();
		List<WebElement>searchedEmojis=driver.findElements(By.xpath(xpath_Emojis_Searchkeys));
		for(int i=0;i<searchedEmojis.size();i++) {
			System.out.println(searchedEmojis.get(i).getAttribute("class"));
		}
		
		return true;
	}
	
	//Verify the search emoji field by entering the invalid keywords to search the emojis
	public String verifyEmojiPopupSearch_EnterInvalidKeys(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys("smilly");
		String noemojisFound=noEmojisFound.getText();
		return noemojisFound;
	}
	
	//Verify the click action on "X" symbol in the search emoji field by entering the some keywords 
	public boolean verifyXSymbol_EmojiSearchFiled(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		searchEmojisField.sendKeys("smile");
		thread();
		searchEmojiXSymbol.click();
		return frequentlyUsedText.isDisplayed();
	}
	
	//Verify the emoji names and short names in the emoji pop up window by moving the mouse hover on emojis
	public String verifyEmojiNamesAndShortNames(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		emoji.click();
		thread();
		Actions action=new Actions(driver);
		action.moveToElement(ginnigEmoji).build().perform();
		thread();
		String emojishortnames=emojiShortNames.getText();
		return emojishortnames;
	}
	
	
	/**********************************************************************************************
	 * 							GIF FUNCTIONALITY IN MESSAGE INPUT FIELD
	 * *********************************************************************************************/
	
	//Verifying the click action of GIF icon in message input field
	public boolean verify_GiphyClickAction(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		thread();
		GIF.click();
		thread();
		boolean giphy=giphyPopup.isDisplayed();
		TestUtil.drawBorder(giphyPopup, driver);
		thread();
		return giphy;
	}
	
	//Verify the  mouse hover functionality of the "X" symbol in giphy pop up window by clicking on "GIF" icon 
	public boolean verifyMousehoverAction_XSymGiphyPopup(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		Actions action=new Actions(driver);
		action.moveToElement(XsymGiphyPopup).build().perform();
		
		return true;
	}
	
	//Verify the giphy pop up window by clicking on "X" symbol
	public boolean verifyGigpyPopup_ClickXSymbol(String userToSelect) throws Throwable {
		verifyMousehoverAction_XSymGiphyPopup(userToSelect);
		thread();
		XsymGiphyPopup.click();
		try {
			if(!giphyPopup.isDisplayed()) {
				return true;
			}else if(giphyPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;
	}

	//Verify the GIPHY title mouse hover and its click functionality at header section  of the giphy  pop up window 
	public String verifyGiphyTitle_PopupHeaderSection(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		poweredGiphy.isDisplayed();
		poweredGiphy.click();
		thread();
		
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window ID: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window ID: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		thread();
		String giphyDotCom=driver.getTitle();
		driver.close();
		thread();
		return giphyDotCom;
	}
	
	//Verify the search field in the giphy pop up window by clicking on the GIF icon from message input field
	public boolean verifyGiphyPopupSearchField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		return searchFieldGiphyPopup.isDisplayed();
		
	}
	
	//Verify the search button in the giphy pop up window 
	public boolean verifySearchButton_GiphyPopup(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		return searchButton_GiphyPopup.isDisplayed();
	}
	 
	//Verify the search field by entering the invalid keywords to search the giphy's available in the giphy pop up window 
	public boolean verifyGiphySearchField_EnterInvalidKeys(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		searchFieldGiphyPopup.sendKeys("sdjksdkfgdddfdgdggdas");
		return noGiphysFound.isDisplayed();
	}
	
	//Verify the "X" symbol mouse hover and click functionality in the search field by entering some keywords on search field
	public boolean verifyXsymbolClickAction_GiphyPopup(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		searchFieldGiphyPopup.sendKeys("giphys");
		XsymbolSearchGiphy.click();
		return searchPlaceholder_GiphyPopup.isDisplayed();
	}
	
	//Verify the mouse over and click functionality of giphy's in the giphy pop up window
	public boolean verifyGiphyClickAction_GiphyPopup(String userToSelect) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		selectGiphy.click();
		
		return giphysMsgThread.isDisplayed();
	}
		
	//Verify the scroll functionality of the giphy pop  up window by moving the mouse up and down 
	public boolean verifyGiphyPopupScroll(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		Actions action=new Actions(driver);
		action.moveToElement(selectGiphy).build().perform();
		thread();
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		thread();
		
		return true;
	}
	
	
	
	/******************************************************************************************************
	 * 								EMOJI SHORT NAMES IN MESSAGE INPUT FIELD
	 * 
	 * ****************************************************************************************************/
	
	//Verify the emojis auto suggestions pop up in the message input field by entering the short names
	public boolean verifyEmojiPopup_MsgInputField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":sh");
		thread();
		return emojisShortNamesPopup.isDisplayed();
	}
	
	//Verify the emoji auto suggestions pop up in the message input field by pressing the "Esc" key on keyboard
	public boolean verifyEmojiPopupMsgInputFiled_EscKey(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":sh");
		thread();
		MsgInputField.sendKeys(Keys.ESCAPE);
		thread();
		try {
			if(!emojisShortNamesPopup.isDisplayed()) {
				return true;
			}else if(emojisShortNamesPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;	
	}
	
	//Verify the "X" symbol functionality in the emoji pop up auto suggestions  
	public boolean verifyEmojiPopupMsgInputField_ClickXSymbol(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":sh");
		thread();
		xSymbol_EmojiPopupMsgInputField.click();
		
		try {
			if(!emojisShortNamesPopup.isDisplayed()) {
				return true;
			}else if(emojisShortNamesPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;	
	}
	
	//Verify the message input field by selecting the emojis by mouse click from the auto suggestion pop up 
	public boolean verifyMsgInputField_SelectEmoji_EnterShortNames(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":sh");
		thread();
		fishEmoji.click();
		thread();
		return fishEmoji_MsgInputField.isDisplayed();
	}
	
	//Verify the message input field by selecting the emoji using "Enter" key on keyboard from the auto suggestions pop up 
	public boolean verifyMsgInputField_SelectEmoji_EnterKey(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":sh");
		thread();
		fishEmoji.sendKeys(Keys.ENTER);
		thread();
		return fishEmoji_MsgInputField.isDisplayed();
	}
	
	//Verify the emoji auto suggestions pop up by entering only single character followed by colon (:) symbol
	public boolean verifyEmojiPopup_EnterSingleCharShortName(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":s");
		thread();
		try {
			if(!emojisShortNamesPopup.isDisplayed()) {
				return true;
			}else if(emojisShortNamesPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;	
	}
	
	//Verify the emojis auto suggestions pop up window by pressing the "Backspace" key on keyboard when user enter only two characters (:ha)
	public boolean verifyEmojiPopupMsgInputField_Backspace(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(":sh");
		thread();
		MsgInputField.sendKeys("\b");
		try {
			if(!emojisShortNamesPopup.isDisplayed()) {
				return true;
			}else if(emojisShortNamesPopup.isDisplayed()) {
				return false;
			}
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
			return true;	
		
	}
	
	/****************************************************************************************************
	 *							SHORT CUT KEYS IN MESSAGE THREAD
	 * 
	 **************************************************************************************************/
	//Verify the message thread by sending the :P short cut key from the message input field 
	public String verifyShortCutKeys_MsgThread(String userToSelect) throws Throwable {
		String shortcutKeys="";
		String keys=":P";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		MsgInputField.sendKeys(keys);
		thread();
		MsgInputField.sendKeys(Keys.ENTER);
		thread();
		List<WebElement>MsgThread=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<MsgThread.size();i++) {
			MsgThread.get(i).getText();
			if(MsgThread.get(i).getText().contains(keys)) {
				shortcutKeys=MsgThread.get(i).getText();
			}
		}
		return shortcutKeys;
	}
	
	
	/************************************************************************************************************
	 * 										ATTACHMENTS IN MESSAGE INPUT FIELD
	 *
	 ***********************************************************************************************************/
	//Check the 'Attachment' icon click functionality on message input field
	public boolean verifyAttachmentClickAction(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
	
		return attachmentPopup.isDisplayed();
		
	}
	
	//Verify the attachment pop up window by clicking on attachment icon from the message input field
	public boolean verifyAttachementPopup(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		myComputerIcon.isDisplayed();
		oneDriveIcon.isDisplayed();
		googleDriveIcon.isDisplayed();
		dropboxIcon.isDisplayed();
		boxIcon.isDisplayed();
		return true;
	}
	
	//Verify the "My Computer" icon and its mouse hover functionality in the attachment pop pup window 
	public String verifyMyComputerTooltip(String userToSelect) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		thread();
		Actions action=new Actions(driver);
		action.moveToElement(myComputerIcon).build().perform();
		
		return tooltip.getText();
	}
	
	//Verify the click action on "My Computer" icon to send a file to user  from the local system 
	public String verifyAttachmentMsgThread_MyComputer(String userToSelect,String fileName,String filePath) throws Throwable {
		String fileMsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		myComputerIcon.click();
		thread();
		TestUtil.uploadFile(filePath);
		Thread.sleep(8000);
		List<WebElement>list=driver.findElements(By.xpath(attachments_MsgThread));
		
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			if(list.get(i).getText().contains(fileName)) {
				fileMsgThread=list.get(i).getText();
			}
			
		}
		
		return fileMsgThread;
	}
	
	//Verify the "One Driver" icon and it's mouse hover action in the attachment pop up window
	public String verifyOneDriveTooltip(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		thread();
		Actions action=new Actions(driver);
		action.moveToElement(oneDriveIcon).build().perform();
		thread();
		return tooltip.getText();
	}
	
	//Verify the click functionality of "One Drive" icon in the attachment pop up window
	public String verifyMsgThreadSelectAttachment_OneDrive(String userToSelect,String email,String password,String fileName1) throws Throwable {
		String file_MsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		oneDriveIcon.click();
		thread();
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window ID: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window ID: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		thread();
		
		String onedrive=driver.getTitle();
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
			if (selectfile.get(i).getText().contains(fileName1)) {

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
		
		List<WebElement>msgThread=driver.findElements(By.xpath(attachments_MsgThread));
		
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(fileName1)) {
				file_MsgThread=msgThread.get(i).getText();
			}
		}
		return file_MsgThread;
	}
	
	//Verify the "Google Drive" icon and it's mouse hover action in the attachment pop up window
	public String verifyGoogleDriveTooltip(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		Actions action=new Actions(driver);
		action.moveToElement(googleDriveIcon).build().perform();
		
		return tooltip.getText();
	}
	
	public boolean verifyGoogleDriveClickAction() {
		return false;
	}
	
	//Verify the "Drop Box" icon and it's mouse hover action in the attachments pop up window
	public String verifyDropboxTooltip(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		Actions action=new Actions(driver);
		action.moveToElement(dropboxIcon).build().perform();
		
		return tooltip.getText();
	}
	
	//Verify the click functionality of "Drop Box" icon in the attachments pop up window
	public String verifyMsgThreadAttachment_Dropbox(String userToSelect,String email,String pwd,String fileName) throws Throwable {
		String file_MsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		dropboxIcon.click();
		thread();
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window ID: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window ID: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		thread();
		
		String dropboxpage=driver.getTitle();
		System.out.println(dropboxpage);
		
		driver.findElement(By.xpath("//*[@class='text-input-wrapper']//*[@name='login_email']")).sendKeys(email);
		thread();
		driver.findElement(By.xpath("//*[@class='text-input-wrapper']//*[@name='login_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[@type='submit']//*[contains(@class,'sign-in')]")).click();
		thread();
		
		List<WebElement>dropboxList=driver.findElements(By.xpath("//*[contains(@class,'dropins-item-row-content')]"));
		for(int i=0;i<dropboxList.size();i++) {
			dropboxList.get(i).getText();
			if(dropboxList.get(i).getText().contains(fileName)) {

				dropboxList.get(i).click();
			}
		}
		
		driver.findElement(By.xpath("//*[@class='mc-button mc-button-primary']")).click();
		thread();
		
		driver.switchTo().window(parentWindowId);
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(attachments_MsgThread));
		
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(fileName)) {
				file_MsgThread=msgThread.get(i).getText();
			}
		}
		return file_MsgThread;
	}
	
	//Verify the "Box" icon and it's mouse hover action in the attachment pop up window
	public String verifyBoxIconTooltip(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		Actions action=new Actions(driver);
		action.moveToElement(boxIcon).build().perform();
		
		return tooltip.getText();
	}
	
	//Verify the click functionality of the "Box" icon in the attachments pop up window
	public String verifyAttachmentMsgThread_Box(String userToSelect,String email,String pwd,String fileName) throws Throwable {
		
		String file_MsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		boxIcon.click();
		thread();
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window ID: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window ID: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		thread();
		
		String boxpage=driver.getTitle();
		System.out.println(boxpage);
		
		driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys(email);
		thread();
		driver.findElement(By.xpath("//*[@id='login-submit']")).click();
		thread();
		driver.findElement(By.xpath("//*[@id='password-login']")).sendKeys(pwd);
		thread();
		driver.findElement(By.xpath("//*[@id='login-submit-password']")).click();
		thread();
		
		driver.findElement(By.xpath("//*[@type='checkbox' and @name='f_593803347087']")).click(); // path of the file to click 
		thread();
		driver.findElement(By.xpath("//*[text()='Choose']")).click(); //choose button
		
		driver.switchTo().window(parentWindowId);
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(attachments_MsgThread));
		
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(fileName)) {
				file_MsgThread=msgThread.get(i).getText();
			}
		}
		return file_MsgThread;
	}
	
	//Verify the files section in the third panel whether the sending attachment are updating and showing or not
	public String verifyFileSection_SendingAttachment(String userToSelect,String fileName,String filePath) throws Throwable {
		String attchmnt_FileSection="";
		verifyAttachmentMsgThread_MyComputer(userToSelect,fileName,filePath);
		flags.click();
		thread();
		files.click();
		thread();
		List<WebElement>fileSection=driver.findElements(By.xpath(xpath_FilesList));
		for(int i=0;i<fileSection.size();i++) {
			fileSection.get(i).getText();
			if(fileSection.get(i).getText().contains(fileName)) {
				attchmnt_FileSection=fileSection.get(i).getText();
			}
		}
		return attchmnt_FileSection;
	}
	
	//Verify the message thread by sending the "Mp3" file format
	public String verifyMp3File_MsgThread(String userToSelect,String fileName,String filePath) throws Throwable {
		return verifyAttachmentMsgThread_MyComputer(userToSelect,fileName,filePath);
	}
	
	//Verify the message thread by sending the "Mp4" file format
	public String verifyMp4File_MsgThread(String userToSelect,String fileName,String filePath) throws Throwable {
		return verifyAttachmentMsgThread_MyComputer(userToSelect,fileName,filePath);
	}
	
	//Verify the message thread by sending the ".xlsx" file format
	public String verifyXlsxFile_MsgThread(String userToSelect,String fileName,String filePath) throws Throwable {
		return verifyAttachmentMsgThread_MyComputer(userToSelect,fileName,filePath);
	}
	
	
	//Verify the message thread by sending the ".html" file format
	public String verifyHTMLFile_MsgThread(String userToSelect,String fileName,String filePath) throws Throwable {
		return verifyAttachmentMsgThread_MyComputer(userToSelect,fileName,filePath);
	}
	
}
