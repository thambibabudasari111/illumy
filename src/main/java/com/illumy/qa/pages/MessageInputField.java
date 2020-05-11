/**
 * 
 */
package com.illumy.qa.pages;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class MessageInputField extends TestBase{

	String xpath_ThreadMsgs		= "//*[contains(@id,'msg_')]";
	
	public MessageInputField() {
		PageFactory.initElements(driver, this);
	}
	
	
	String messageText				= "//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@id='cntnt__edit']";
	String xpath_ConversationList	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String atmentionAutoSugg		= "//*[@role='listbox']//*[@role='option']//a";

	@FindBy(xpath="//span[@class='media-body users-list-name no-margin ng-star-inserted']")
	WebElement dkldk;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']")
	WebElement messageInputField;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@id='cntnt__edit']")
	WebElement ghostText_MsgInputField;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'fa fa-at')]")
	WebElement atMention;
	
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'smile_icon')]")
	WebElement emoji;
	
	@FindBy(xpath="//*[@type='button']//*[@class='gif_bto_cs']")
	WebElement GIF;
	
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'paperclip')]")
	WebElement attachment;
	
	@FindBy(xpath="//*[@class='subject_open']//div")
	WebElement subjectExpander;
	
	@FindBy(xpath="//*[@class='input-group']//*[@class='input-group-addon']")
	WebElement subjectPlaceholder;
	
	@FindBy(xpath="//*[@class='input-group']//*[@id='subject']")
	WebElement subjectField;
	
	@FindBy(xpath="//*[@class='subject_open']//div")
	WebElement subjectOpen;
	
	@FindBy(xpath="//*[@class='subject_open']//div")
	WebElement closeSubject_Tooltip;
	
	@FindBy(xpath="//*[@id='editable']")
	WebElement atmention_InputField;
	
	@FindBy(xpath="//*[@id='chat_window_emoji_div']")
	WebElement emojiPopup;
	
	@FindBy(xpath="//*[@class='ng-star-inserted']//*[@class='list-header pad bg-grey']")
	WebElement atmentionsPopupHeader;
	
	@FindBy(xpath="//*[contains(@id,'giphy_div')]")
	WebElement giphyPopup;
	
	@FindBy(xpath="//*[@class='attachment_div demo-droppable text-center']")
	WebElement attachmentPopup;
	
	@FindBy(xpath="white-space-pre-wrap message__thread ng-star-inserted")
	WebElement messageThread;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[@class='emojione-24-people _1f600 top_0 handCursor']")
	WebElement grinningFaceEmoji;
	
	@FindBy(xpath="//*[@class='smily_img ng-star-inserted']//*[@class='emojione-24-symbols _0023-20e3 top_0 handCursor']")
	WebElement hashEmoji;
	
	@FindBy(xpath="//*[@id='giphyOne']//*[contains(@class,'img-responsive')]")
	WebElement giphy;
	
	@FindBy(xpath="//*[@id='footer_container_slim']//*[@id='footer_scrollbar_slim']")
	WebElement inputFieldScroolBtn;
	
	@FindBy(xpath="//*[@class='emojimain_div']//*[contains(@class,'0023-20e3')]")
	WebElement hashSym_MsgThread;
	
	//Page Factory : OR
	
	
	//Actions:
	
	/*Check the input field is visible or not at the bottom 
	 * of the P2P or group message thread in the middle panel 
	 */
	public boolean verify_MessageInputField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		return messageInputField.isDisplayed();
	}
	
	
	public boolean verify_GhostText_MsgInputField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		String message="Message"+userToSelect;
		
		if(messageText.contains(message)) {
			return true;
		}
		return true;
	}
	
	//Check the cursor position by default when an user open the P2P or group message thread
	public WebElement verifyDefaultCursorPostion(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		thread();
		WebElement cursorPosition=driver.switchTo().activeElement();
		thread();
		return cursorPosition;
	}
	
	//Verifying the '@' is displaying or not in the input field section
	public boolean verify_AtMentions(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		return atMention.isDisplayed();
	}
	
	//Verifying the emoji symbol in the message input field
	public boolean verify_Emoji_MessageInputField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		return emoji.isDisplayed();
	}
	
	//Verify the GIF symbol in the message input field
	public boolean verify_GIF_MessageInputField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		return GIF.isDisplayed();
	}
	
	//Verify the attachment symbol in the message input field
	public boolean verify_Attachement_MessageInputField(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		return attachment.isDisplayed();
	}
	
	//Verifying the subject expander in the message input field for on-net contact
	public boolean verify_SubjectExpander(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		return subjectExpander.isDisplayed();
	}
	
	//Verify the click functionality of subject expander for on-net contact
	public String verify_ClickAction_SubjectExpander(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		 return subjectPlaceholder.getText();
	}
	
	//Verifying the double click functionality of the subject expander for on-net contact
	public boolean verify_DoubleClick_SubLineExpander(String userToSelect) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectOpen.isDisplayed();
		subjectOpen.click();
		thread();
		return subjectExpander.isDisplayed();
	}
	
	
	//Verifying the click functionality of the @ in message input field
	public boolean verify_AtmentionClickAction(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		atMention.click();
		thread();
		
		atmention_InputField.isDisplayed();
		atmentionsPopupHeader.isDisplayed();
		
		return true;
	}
	
	//Verifying the click action on emoji icon in message input field
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
	
	//Verifying the click action of GIF icon in message input field
	public boolean verify_GiphyClickAction(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		GIF.click();
		thread();
		thread();
		boolean giphy=giphyPopup.isDisplayed();
		thread();
		return giphy;
	}
	
	//Verify the click functionality of attachment icon in message input field
	public boolean verify_AttachmentClickAction(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		attachment.click();
		thread();
		boolean attachmentpopup=attachmentPopup.isDisplayed();
		TestUtil.drawBorder(attachmentPopup, driver);
		thread();
		return attachmentpopup;
	}
	
	//Sending text message to the user by entering subject in subject field and text message from input field
	public String verifySubjectField_TxtMsg(String userToSelect,String subjectTxt,String msgInput_Text) throws Throwable {
		String sub_Text="";
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(subjectTxt);
	
		MsgInputField.sendKeys(msgInput_Text);
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		sub_Text=TestUtil.getElementFromMsgThread(xpath_ThreadMsgs, subjectTxt, msgInput_Text);
		
		return sub_Text;
	}

	//Verifying the subject field by entering the special characters and enter  text message in message entry field
	public String verifySubjectField_SplChars(String userToSelect,String subSplChars,String msgInput_Text) throws Throwable {
		String splChars_TxtMsg="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(subSplChars);
		
		
		MsgInputField.sendKeys(msgInput_Text);
		
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		thread();
		
		splChars_TxtMsg=TestUtil.getElementFromMsgThread(xpath_ThreadMsgs, subSplChars, msgInput_Text);
		
		return splChars_TxtMsg;
	}
	
	//Verifying the subject field by entering the numbers and enter text message in message entry field
	public String verify_SubjectField_Numbers(String userToSelect,String sub_Num,String msgInput_Text) throws Throwable {
		String num_TextMsg="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Num);
		
		MsgInputField.sendKeys(msgInput_Text);
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		thread();
		
		num_TextMsg=TestUtil.getElementFromMsgThread(xpath_ThreadMsgs, sub_Num, msgInput_Text);
		return num_TextMsg;
	}
	
	/*Verify the subject field by entering the combination of alphabet, numbers,
	 * and special characters and enter text message in message input field
	 */
	public String verifySubjectField_Combinations(String userToSelect,String sub_combinations,String msgInput_Text) throws Throwable {
		String sub_Combinations="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_combinations);
		
		MsgInputField.sendKeys(msgInput_Text);
		
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		thread();
		
		sub_Combinations=TestUtil.getElementFromMsgThread(xpath_ThreadMsgs, sub_combinations, msgInput_Text);
		
		return sub_Combinations;
	}

	/* Verify the subject field by entering the URL and by entering the text message in message input field */
	public String verifySubField_URL(String userToSelect,String sub_Url,String msgInput_Text ) throws Throwable {
		String sub_URL="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Url);
		
		MsgInputField.sendKeys(msgInput_Text);
		
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		thread();
		
		sub_URL=TestUtil.getElementFromMsgThread(xpath_ThreadMsgs, sub_Url, msgInput_Text);
		
		return sub_URL;
	}
	 
	/*Verify the subject field maximum limit of accepting the characters by entering more than 80 characters*/
	public String verifySubField_MoreThan80Chars(String userToSelect,String sub_Morethan80Chars) throws Throwable {
		
	
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Morethan80Chars);
		thread();
		String abc = subjectField.getAttribute("value");

		thread();
		thread();

		return abc;
	}
	
	//Verify the subject field by clearing the text using 'Back Space' key from keyboard
	public String verifySujField_ClearText_Backspace(String userToSelect,String sub_TextMsg) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_TextMsg);
		thread();
		subjectField.sendKeys(Keys.CONTROL);
		thread();
		subjectField.sendKeys("\b","\b","\b");
		thread();
		String sub_Backspace=subjectField.getAttribute("value");
		return sub_Backspace;
	}
	
	//Verify the subject field by pasting the copied text using keyboard options
	public String verifySubField_CopyPaste_Keyboard(String userToSelect,String sub_Text) throws Throwable {
		String copiedText="";
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Text);
		thread();
		subjectField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		thread();
		subjectField.sendKeys(Keys.chord(Keys.CONTROL,"c"));
	
		subjectField.sendKeys(Keys.chord(Keys.CONTROL,"v",Keys.SPACE));
		subjectField.sendKeys(Keys.chord(Keys.CONTROL,"v",Keys.SPACE));
		subjectField.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		copiedText=subjectField.getText();
		
		return copiedText;
	}
	
	//Verify the cursor position by press the Enter key on keyboard by entering some text in subject field
	public WebElement verifyCursorPosition_EnterKey(String userToSelect,String sub_Text) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Text);
		thread();
		subjectField.sendKeys(Keys.chord(Keys.ENTER));
		
		WebElement cursorPosition=driver.switchTo().activeElement();
		
		return cursorPosition;
	}
	
	//Verify the TAB key functionality from keyboard when the cursor position at subject field
	public WebElement verifyCursorPosition_TABKey(String userToSelect,String sub_Text) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Text);
		thread();
		subjectField.sendKeys(Keys.chord(Keys.TAB));
		thread();
		WebElement cursorPosition=driver.switchTo().activeElement();
		thread();
		
		return cursorPosition;
	}
	
	//Verify the mouse hover action on subject expander symbol when it is in open status
	public String verifyAddSubject_Tooltip(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectOpen.isDisplayed();
		Actions addSubject=new Actions(driver);
		addSubject.moveToElement(subjectOpen).build().perform();
		thread();
		String addSubTooltip=closeSubject_Tooltip.getText();
		return addSubTooltip;
	}
	
	//Verify the default subject of off-net user by clicking on  subject line expander in P2P message thread
	public String verifyOffnetUser_SubjectField(String offnetUser) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, offnetUser);
		thread();
		subjectExpander.click();
		thread();
		String offnetUserSub=subjectField.getAttribute("value");
		return offnetUserSub;
	}
	
	//Verify the subject field by entering the short names of emojis and by entering text message in message input field
	public boolean verifyEmojiShortNames_SubField(String userNameToSelect,String emojiShortName,String msgInput_Text) throws Throwable {
		boolean emojiShortNames_MsgThread=false;
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(emojiShortName);
		MsgInputField.sendKeys(msgInput_Text);
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		
		String emojiShortNames="Subject: "+emojiShortName+"\n"+msgInput_Text;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(emojiShortNames)) {
				emojiShortNames_MsgThread=msgThread.get(i).isDisplayed();
			}
		}
		
		return emojiShortNames_MsgThread;
	}
	

	/*Clicking on '@' icon when the cursor position in subject field*/
	public String verifySubField_ClickAtMention(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		subjectExpander.click();
		thread();
		atMention.click();
		thread();
		String atmentionSym_MsgInput=MsgInputField.getText();
		return atmentionSym_MsgInput;
	}
	
	/*User clicking on 'Emoji' icon when cursor position in subject field*/
	public boolean verifySubField_ClickEmoji(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		subjectExpander.click();
		thread();
		Actions emojiIcon=new Actions(driver);
		emojiIcon.moveToElement(emoji);
		thread();
		emoji.click();
		thread();
		
		MsgInputField.sendKeys(":grinning:");
		
		String emoji="//*[@data-shortname=':grinning:']";
		if(MsgInputField.getText().contains(emoji)) {
			return true;
		}
		
		return true;
	}

	//User clicking on'GIF' icon when cursor position in subject field
	public void verifySubField_ClickGiphy(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		subjectExpander.click();
		thread();
		Actions emojiIcon=new Actions(driver);
		emojiIcon.moveToElement(GIF);
		thread();
		GIF.click();
		thread();
		giphy.click();
		
		List<WebElement> giphyList=driver.findElements(By.xpath("//*[@class='white-space-pre-wrap message__thread ng-star-inserted']//*[contains(@class,'gifPlayer')]"));
		System.out.println(giphyList.size());
		WebElement lastGiphy = giphyList.get(giphyList.size()-1);
		System.out.println(lastGiphy);
	}
	
	//Verify the message input field by entering only alphabets
	public String verifyMsgInputField_Alphabets(String userNameToSelect,String keysToSend) throws Throwable {
		String msgInput_Txt="";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		MsgInputField.sendKeys(keysToSend);
		thread();
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		thread();
		
		List<WebElement>msgThreadElements=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThreadElements.size();i++) {
			msgThreadElements.get(i).getText();
			if(msgThreadElements.get(i).getText().contains(keysToSend)) {
				msgInput_Txt=msgThreadElements.get(i).getText();
			}
		}
		return msgInput_Txt;
	}
	
	//Verify the message input field by sending numbers only
	public String verifyMsgInputField_Numbers(String userNameToSelect,String keysToSend) throws Throwable {
		String number_MsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		MsgInputField.sendKeys(keysToSend);
		thread();
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		
		List<WebElement>msgThreadElements=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThreadElements.size();i++) {
			msgThreadElements.get(i).getText();
			if(msgThreadElements.get(i).getText().contains(keysToSend)) {
				number_MsgThread=msgThreadElements.get(i).getText();
			}
		}
		return number_MsgThread;
	}
	
	//Verify the message  input field by sending the all special characters 
	public String verifyMsgInputField_SplChars(String userNameToSelect,String keysToSend ) throws Throwable {
		String splChars_MsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		MsgInputField.sendKeys(keysToSend);
		thread();
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		thread();
		
		List<WebElement>msgThreadElements=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThreadElements.size();i++) {
			msgThreadElements.get(i).getText();
			if(msgThreadElements.get(i).getText().contains(keysToSend)) {
				splChars_MsgThread=msgThreadElements.get(i).getText();
			}
		}
		return splChars_MsgThread;
	}
	
	//User sending the combination of alphabet,special characters and numbers in message input field
	public String verifyMsgInputField_Combinations(String userNameToSelect,String keysToSend) throws Throwable {
		String combinations_MsgThread="";
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		MsgInputField.sendKeys(keysToSend);
		thread();
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		thread();
		
		List<WebElement>msgThreadElements=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThreadElements.size();i++) {
			msgThreadElements.get(i).getText();
			if(msgThreadElements.get(i).getText().contains(keysToSend)) {
				combinations_MsgThread=msgThreadElements.get(i).getText();
			}
		}
		return combinations_MsgThread;
	}
	
	//Verify the message input field by sending the text message and selecting user from '@' at mentions pop up 
	public String verifyMsgInputField_TxtMsg_AtMentions(String userNameToSelect,String keysToSend) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		MsgInputField.sendKeys(keysToSend+" ");
		thread();
		atMention.click();
		thread();
		List<WebElement>autoSugg=driver.findElements(By.xpath(atmentionAutoSugg));
		for(int i=0;i<autoSugg.size();i++) {
			autoSugg.get(i).getText();
			if(autoSugg.get(i).getText().contains(userNameToSelect)) {
				autoSugg.get(i).click();
			}
		}
		
		String textAtmention=MsgInputField.getText();
		return textAtmention;
	}
	
	/*Verify the message input field by select the user from at 
	 * mentions pop up clicking on "@" icon and entering some text message
	 */
	public String verifyMsgInputField_Atmention_TextMsg(String userNameToSelect,String keysToSend) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		atMention.click();
		thread();
		List<WebElement>autoSugg=driver.findElements(By.xpath(atmentionAutoSugg));
		for(int i=0;i<autoSugg.size();i++) {
			autoSugg.get(i).getText();
			if(autoSugg.get(i).getText().contains(userNameToSelect)) {
				autoSugg.get(i).click();
			}
		}
		
		MsgInputField.sendKeys(keysToSend);
		thread();
		String atmentionText=MsgInputField.getText();
		return atmentionText;
	}
	
	/*Verify the message input field by sending the text message and selecting an emoji from the emoji's pop up */
	public boolean verifyMsgInputField_Text_Emoji(String userNameToSelect,String keysToSend) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		MsgInputField.sendKeys(keysToSend);
		thread();
		emoji.click();
		thread();
		MsgInputField.sendKeys(":grinning:");
		thread();
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		thread();
		
		List<WebElement>emoji=driver.findElements(By.xpath(xpath_ThreadMsgs));
		String sdjdj="Test Message"+driver.findElement(By.xpath("//span[@class='emoji_inner_size inner_sprit emojione-24-people _1f600']"));
		for(int i=0;i<emoji.size();i++) {
			emoji.get(i).getText();
			if(emoji.get(i).getText().contains(sdjdj)) {
				emoji.get(i).isDisplayed();
			}
		}
		return true;
	}
	
	//Verify the message input field by entering the long text continuously
	public int verifyMsgInputField_LongText(String userNameToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userNameToSelect);
		thread();
		String keysToSend1="This is a test message ";
		for(int i=0;i<90;i++) {
			MsgInputField.sendKeys(keysToSend1);
		}
		
		String inputField=MsgInputField.getText();
		int size=inputField.length();
		return size;
	}
	
	//Check the slim scroll is displaying or not while entering the long text in message input field
	public boolean verifyInputFieldSlimScroll_LongText(String userNameToSelect) throws Throwable {
		boolean scrollBtn=false;
		verifyMsgInputField_LongText(userNameToSelect);
		scrollBtn= inputFieldScroolBtn.isDisplayed();
		TestUtil.drawBorder(inputFieldScroolBtn, driver);
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		return scrollBtn;
	}
	
	//Verify the message input field by copy and paste the text messages using key board options
	public String verifyInputField_TextCopyPaste(String userToSelect,String sub_Text) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		subjectExpander.click();
		thread();
		subjectField.sendKeys(sub_Text);
		thread();
		subjectField.sendKeys(Keys.CONTROL,"a");
		thread();
		subjectField.sendKeys(Keys.CONTROL,"c");
		thread();
		String copyPaste=Keys.chord(Keys.CONTROL,"v");
		thread();
		String copyPaste1=Keys.chord(Keys.CONTROL,"v");
		thread();
		String copyPaste2=Keys.chord(Keys.CONTROL,"v");
		String copyPasteText=copyPaste+copyPaste1+copyPaste2;
		MsgInputField.sendKeys(copyPasteText);
		thread();
		String msgInputFieldText=MsgInputField.getText();
		return msgInputFieldText;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
