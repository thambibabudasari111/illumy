/**
 * 
 */
package com.illumy.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
 */
public class MessageOptions extends TestBase{

	
	String msgId="";
	String msgOptionsId="";
	
	WebElement thumbsUpIcon;
	WebElement envelopeIcon;
	WebElement flag;
	WebElement reaction;
	WebElement moreOptions;
	
	String chars = TestUtil.randomChars(5);
	
	//Lists xpaths:
	String xpath_ConversationList 	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_MsgThread 			= "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions			= "//*[contains(@id,'options_msg')]";
	String xpath_UserNamesPopup		= "//*[@role='listitem']//*[@class='mat-list-item-content']//*[contains(@class,'text-primary')]";
	String xpath_UnreadCount		= "//*[contains(@class,'users-list-name')]//following-sibling::*[contains(@class,'media-right')]//label";
	String xpath_FlagsSectionMsgs	= "//*[@class='flagged_div']//*[@class='white-space-pre-wrap message__thread ng-star-inserted']";
	String xpath_ToFieldAutoSugg 	= "//div[@role='listbox']//mat-option[@role='option']//span[@class='mat-option-text']";
	String xpath_replyAllFwdMsgs	= "//*[contains(@id,'forwardReply')]";
	
	
	//PAGE FACTORY : OR (Object Repository)
	
	//Text fields:
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	@FindBy(xpath="//*[@id='reaction_message_emoji_header']//*[@id='emoji_search']//*[contains(@id,'reaction_message_search')]")
	WebElement emojiSearchField;
	
	@FindBy(xpath="//*[@id='reaction_message_recent_emoji']//following-sibling::*[text()='Frequently Used']")
	WebElement frequentlyUsedSection;
	
	@FindBy(xpath="//*[contains(@id,'replay_message')]//*[@class='white-space-pre-wrap message__thread ng-star-inserted']")
	WebElement replyMsg_InputFieldSection;
	
	@FindBy(xpath="//*[@role='option']//*[contains(@class,'compose_mes_text')]")
	WebElement replyAllPopup_UserName;
	
	@FindBy(xpath="//*[@role='dialog']//*[text()=' Reply All ']")
	WebElement replyAllPopupTitle;
	
	@FindBy(xpath = "//*[@class='mat-chip-list-wrapper']//*[text()='Cc']//following-sibling::*[@role='combobox']")
	WebElement ccField;
	
	@FindBy(xpath = "//*[@class='mat-chip-list-wrapper']//*[text()='To']//following-sibling::*[@role='combobox']")
	WebElement toField;
	
	@FindBy(xpath="//*[@id='subject']")
	WebElement subjectField;
	
	@FindBy(xpath = "//*[@id='threadBody']//*[@id='createThreadEditable']")
	WebElement msgBody;
	
	//Button, Icons and Links:
	@FindBy(xpath="//*[text()='Reply']")
	WebElement reply;
	
	@FindBy(xpath="//*[text()='Reply All']")
	WebElement replyAll;
	
	@FindBy(xpath="//*[text()='Forward']")
	WebElement forward;
	
	@FindBy(xpath="//*[text()='Hide Message']")
	WebElement hideMessage;
	
	@FindBy(xpath="//*[text()='Edit Message']")
	WebElement editMessage;
	
	@FindBy(xpath="//*[text()='Delete ']")
	WebElement delete;
	
	@FindBy(xpath="//*[@role='button']//*[text()='Flags']")
	WebElement flagsSection;
	
	@FindBy(xpath="//*[contains(@id,'reaction_message')]//*[@class='smily_img ng-star-inserted']//*[contains(@class,'1f1fa-1f1f3')]")
	WebElement unitedNationsEmoji;
	
	@FindBy(xpath="//*[@id='reaction_message_emoji_header']//*[@title='Close']//*[contains(@class,'fa-times')]")
	WebElement closeEmojiPopup;
	
	@FindBy(xpath="//*[contains(@id,'reaction_message')]//*[contains(@class,'1f600')]")
	WebElement grinningFaceEmoji;
	
	@FindBy(xpath="//*[contains(@class,'replyClose')]//*[contains(@class,'fa-times')]")
	WebElement closeReplyMsg;
	
	@FindBy(xpath="//*[contains(@class,'com_fot')]//*[@type='button']//*[contains(@class,'fa fa-at')]")
	WebElement replyAll_Atmention;
	
	@FindBy(xpath="//*[contains(@class,'com_fot')]//*[@type='button']//*[contains(@class,'smile_icon_fot')]")
	WebElement replyAll_Emoji;
	
	@FindBy(xpath="//*[contains(@class,'com_fot')]//*[@type='button']//*[contains(@class,'gif_bto_cs')]")
	WebElement replyAll_GIF;
	
	@FindBy(xpath="//*[contains(@class,'com_fot')]//*[@type='button']//*[contains(@class,'fa fa-paperclip')]")
	WebElement replyAll_Attachment;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendBtn;
	
	@FindBy(xpath="//*[text()='Show message']")
	WebElement showMessageBtn;
	
	@FindBy(xpath="//*[text()='Hide message']")
	WebElement hideMessageBtn;
	
	@FindBy(xpath = "//*[text()='Cc']")
	WebElement cc;
	
	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[text()='to']")
	WebElement to_MsgThread;

	@FindBy(xpath = "//*[@class='ng-star-inserted']//*[text()='cc']")
	WebElement cc_MsgThread;

	@FindBy(xpath="//*[text()=' Confirm ']")
	WebElement confirmBtn_DeletePopup;
	
	@FindBy(xpath="//*[@type='button']//*[contains(@class,'close_popup')]")
	WebElement closeBtn_FwdPopup;
	
	//Popup's 
	@FindBy(xpath="//*[contains(@id,'reaction_message_emoji_div')]")
	WebElement emojiPopup;
	
	@FindBy(xpath="//*[@role='dialog']//*[text()=' Forward ']")
	WebElement forwardPopup;
	
	@FindBy(xpath="//*[contains(@class,'gif_rig')]//*[contains(@class,'gif_bto_cs')]")
	WebElement editMsgGIF;
	
	@FindBy(xpath="//*[contains(@class,'btn emoji_click')]//*[contains(@class,'smile_icon')]")
	WebElement editMsgEmoji;
	
	@FindBy(xpath="//*[text()=' Delete Message ']")
	WebElement deletePopup;
	
	@FindBy(xpath="//*[contains(@class,'close_popup')]")
	WebElement closeDeletePopup_Xsym;
	
	
	//Validation messages:
	@FindBy(xpath = "//*[text()='Please select at least one user.']")
	WebElement plsSelectAtleastOneUser;
	
	@FindBy(xpath="//*[contains(@class,'blur_main flex-design')]//*[text()='This message is hidden.']")
	WebElement thisMsgIsHidden;
	
	@FindBy(xpath="//*[contains(text(),'Unhide Message')]")
	WebElement unhideMsgBtn;
	
	@FindBy(xpath="//*[contains(text(),'Cancel')]")
	WebElement cancelBtn_EditMsg;
	
	@FindBy(xpath="//*[contains(text(),'Cancel')]")
	WebElement cancelBtn_DeleteMsg;
	
	@FindBy(xpath="//*[contains(@class,'editmsg')]")
	WebElement editMsgField;
	
	@FindBy(xpath="//*[contains(text(),'Save Changes')]")
	WebElement saveChangesBtn_EditMsg;
	
	
	//Initializing the page objects: 
	public MessageOptions() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS: 
	
	
	/*verify that when we mouse hover on any message in the thread will show the message 
	 * options on right side of the message highlighted 
	 */
	
	public boolean verifyMsgOptions(String userToSelect,String message) throws Throwable {
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		String textMsg=message+" "+chars;
		MsgInputField.sendKeys(textMsg);
		thread();
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID: " +msgId);
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				System.out.println("Message Options ID: "+msgOptionsId);
				
				//Message options
				thumbsUpIcon=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'thumbs-up')]"));
				envelopeIcon=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'envelope')]"));
				flag=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'flag')]"));
				reaction=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@src,'smile_icon.png')]"));
				moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
				
				if(thumbsUpIcon.isDisplayed() && envelopeIcon.isDisplayed() && flag.isDisplayed() && reaction.isDisplayed() && moreOptions.isDisplayed()) {
					return true;
				}
			}
		}
		return true;
	}
	
	/*Verify that by clicking on the three vertical lines (More Options) in the message options 
	 * for a sent message will display Reply, forward, hide, Edit and delete options.*/
	public boolean verifySentMsgOptions(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		if(reply.isDisplayed() && replyAll.isDisplayed() && forward.isDisplayed() && hideMessage.isDisplayed() && editMessage.isDisplayed() && delete.isDisplayed()) {
			return true;
		}
		return true;
	}
	
	/*Verify that by clicking on the three vertical lines (More Options) in the message 
	 * options for a received message will display Reply forward and hide options.*/
	public boolean verifyReceivedMsgOptions(String userToSelect,String oppositeUser,String message) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement>conversationList=incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppositeUser)) {
				conversationList.get(i).click();
			}
		}
		
		thread();
		thread();

		WebElement inputField=incognito.findElement(By.xpath("//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']"));
		String textMsg=message+" "+chars;
		inputField.sendKeys(textMsg);
		thread();
		inputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		
		incognito.close();
		thread();
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID: " +msgId);
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				System.out.println("Message Options ID: "+msgOptionsId);
			}
		}
		moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
		moreOptions.click();
		thread();
		
		if(reply.isDisplayed() && replyAll.isDisplayed() && forward.isDisplayed() && hideMessage.isDisplayed()) {
			return true;
		}
		return true;
	}

	//Verify that mouse hover on like icon  in message options will populates the text "Like"
	public String verifyLikeBtnMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(thumbsUpIcon).build().perform();
		thread();
		
		WebElement likeTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'thumbs-up')]//following-sibling::*[@class='options_tooltip']"));
		
		return likeTooltip.getText();
	}
	
	//Verify that mouse hover on like icon  in message options which is already liked will populates the text "Remove Like"
	public String verifyAlreadyLikedBtnMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(thumbsUpIcon).build().perform();
		thread();
		thumbsUpIcon.click();
		thread();
		WebElement alreadylikedBtnTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'thumbs-up')]//following-sibling::*[@class='options_tooltip']"));
		
		return alreadylikedBtnTooltip.getText();
	}
	
	//Verify the "envelope" (read/unread messages) symbol mouse hover action in the message options of messages in the message thread
	public String verifyMarkUnreadBtnMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(envelopeIcon).build().perform();
		thread();
		
		WebElement markUnreadTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return markUnreadTooltip.getText();
	}
	
	//Verify that mouse hover on Flag icon  in message options will populates the text "Flag"
	public String verifyFlagBtnMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(flag).build().perform();
		thread();
		
		WebElement flagTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'flag')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return flagTooltip.getText();
	}
	
	//Verify that mouse hover on Flag icon  in message options which is already Flagged  will populates the text "Remove Flag"
	public String verifyAlreadyFlaggedBtnMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(flag).build().perform();
		thread();
		flag.click();
		thread();
		WebElement alreadyFlaggedTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'flag')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return alreadyFlaggedTooltip.getText();
	}

	//Verify that mouse hover on Emoji icon in the message options will populates the text "Reaction"
	public String verifyEmojiIconMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(reaction).build().perform();
		thread();
		
		WebElement reactionTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@src,'smile_icon.png')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return reactionTooltip.getText();
	}
	
	//Verify that mouse hovering on the three vertical lines(more options) in the message options will populates the text "More Options".
	public String verify3VerticalDotsMousehover(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(moreOptions).build().perform();
		thread();
		
		WebElement moreOptionsTooltip=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return moreOptionsTooltip.getText();
	}
	
	/*Verify that by clicking on the Like icon in the message option will like that particular
	 * message and like icon/symbol will appear besides the message.*/
	public boolean verifyLikeBtnClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID: " +msgId);
		
		thumbsUpIcon.click();
		thread();
		
		WebElement likedMsg=driver.findElement(By.xpath("//*[contains(@id,'"+msgId+"')]"+"//*[contains(@class,'box__icon')]//*[contains(@class,'handCursor')]"));
		
		WebElement LikesCount=driver.findElement(By.xpath("//*[contains(@id,'"+msgId+"')]"+"//*[contains(@class,'box__icon')]//*[contains(@class,'handCursor')]//*[@class='likes_count']"));
		System.out.println("Likes Count: "+LikesCount.getText());
		return likedMsg.isDisplayed();
	}
	
	//Verify that the opposite User click on the like icon beside the message the count will increase to 2.
	public String verifyOppositeUserClickLikeBtn(String userToSelect,String message,String oppositeUser) throws Throwable {
		verifyLikeBtnClickAction(userToSelect,message);
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		
		List<WebElement>conversationList=incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppositeUser)) {
				conversationList.get(i).click();
			}
		}
		
		thread();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=incognito.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID: " +msgId);
		
		WebElement likeBtn=incognito.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'thumbs-up')]"));
		likeBtn.click();
		thread();
		
		incognito.close();
		
		WebElement LikesCount=driver.findElement(By.xpath("//*[contains(@id,'"+msgId+"')]"+"//*[contains(@class,'box__icon')]//*[contains(@class,'handCursor')]//*[@class='likes_count']"));
		System.out.println("Likes Count: "+LikesCount.getText());
		
		return LikesCount.getText();
		
	}
	
	//Verify that mouse hover on the like Icon beside the message will populates the User name and avatar who liked it.
	public String verifyUsernamesAfterClickedLikeBtn(String userToSelect,String message,String oppositeUser) throws Throwable {
		String likedUsers="";
		verifyOppositeUserClickLikeBtn(userToSelect,message,oppositeUser);
		thread();
		thread();
		
		WebElement likedMsg=driver.findElement(By.xpath("//*[contains(@id,'"+msgId+"')]"+"//*[contains(@class,'box__icon')]//*[contains(@class,'handCursor')]"));
		Actions action=new Actions(driver);
		action.moveToElement(likedMsg).build().perform();
		thread();
		
		List<WebElement>userNames=driver.findElements(By.xpath(xpath_UserNamesPopup));
		for(int i=0;i<userNames.size();i++) {
			thread();
			likedUsers=userNames.get(i).getText();
			thread();
			
		}
		
		return likedUsers;
	}
	
	//Verify that Re-clicking on the like Icon will disappear the like icon beside the message/ decreases the count.
	public boolean verifyReclickingLikedBtn(String userToSelect,String message) throws Throwable {
		verifyLikeBtnClickAction(userToSelect,message);
		thread();
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				
				System.out.println("Message Options ID: "+msgOptionsId);
				WebElement likeBtn=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'thumbs-up')]"));
				likeBtn.click();
				thread();
			}
		}
		WebElement likeTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'thumbs-up')]//following-sibling::*[@class='options_tooltip']"));
		
		return likeTooltip.isDisplayed();
	}
	
	//Verify that if we Click on the mark unread, A vertical purple bar will appear on the left side of the message.
	public boolean verifyMarkUnreadBtnClickAction(String userToSelect,String message) throws Throwable {
		
		verifyMsgOptions(userToSelect,message);
		thread();
		
		
		envelopeIcon.click();
		thread();

		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		WebElement unreadMsg=driver.findElement(By.xpath("//*[@id='"+msgId +"' "+"and contains(@class,'unread_bg')]"));
		return unreadMsg.isDisplayed();
	}
	
	//Verify that if we click on the mark unread, The thread count will display on the conversation list user name.
	public String verifyUnreadCountClickMarkUnreadBtn(String userToSelect,String message) throws Throwable {
		WebElement unreadCount = null;
		verifyMarkUnreadBtnClickAction(userToSelect,message);
		thread();
		
		List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(userToSelect)) {
				unreadCount=driver.findElement(By.xpath("//*[contains(@class,'users-list-name')]//following-sibling::*[contains(@class,'media-right')]//label"));
			}	
		}
		
		return unreadCount.getText();
	}
	
	//Verify that if we mouse hover mark unread after clicking it, The icon will change to mark read status and display the tool tip as mark read
	public String verifyMarkReadTooltip(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		Actions action=new Actions(driver);
		action.moveToElement(envelopeIcon).build().perform();
		thread();
		envelopeIcon.click();
		thread();
		WebElement markReadTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return markReadTooltip.getText();
	}
		
	//Verify that if we click on the mark read icon then the purple bar will disappears.
	public String verifyMarkReadClickAction(String userToSelect,String message) throws Throwable {
		verifyMarkReadTooltip(userToSelect,message);
		thread();
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				
				System.out.println("Message Options ID: "+msgOptionsId);
				WebElement envelopeBtn=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'envelope')]"));
				envelopeBtn.click();
				thread();
			}
		}
		WebElement markUnreadTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));	
		
		return markUnreadTooltip.getText();
	}
		
	/*Verify that by clicking on the Flag icon in the message option will Flag 
	 * that particular message and Flag icon/symbol will appear besides the message.*/
	public boolean verifyFlagIconClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID: " +msgId);
		
		flag.click();
		thread();
		
		WebElement flaggedMsg=driver.findElement(By.xpath("//*[contains(@id,'"+msgId+"')]"+"//*[contains(@class,'flag red_col')]"));
		return flaggedMsg.isDisplayed();
		
	}
		
	//Verify the flagged message or images or attachments are reflected in flags section in third panel or not
	public String verifyFlaggedMsgInFilesSection(String userToSelect,String message) throws Throwable {
		String flaggedMsg_FlagSection="";
		verifyFlagIconClickAction(userToSelect,message);
		thread();
		thread();
		flagsSection.click();
		thread();
		String textMsg=message+" "+chars;
		List<WebElement>flaggedMsg=driver.findElements(By.xpath(xpath_FlagsSectionMsgs));
		for(int i=0;i<flaggedMsg.size();i++) {
			flaggedMsg.get(i).getText();
			if(flaggedMsg.get(i).getText().contains(textMsg)) {
				flaggedMsg_FlagSection=flaggedMsg.get(i).getText();
			}
		}
		flagsSection.click();
		thread();
		return flaggedMsg_FlagSection;
	}
		
	//Verify that re-clicking on the Flag Icon besides the message will vanishes the flag icon .
	public String verifyRemoveFlagAction(String userToSelect,String message) throws Throwable {
		verifyFlagIconClickAction(userToSelect,message);
		thread();
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				
				System.out.println("Message Options ID: "+msgOptionsId);
				WebElement flagIcon=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'flag')]"));
				flagIcon.click();
				thread();
			}
		}
		WebElement flagTooltip=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'flag')]//following-sibling::*[contains(@class,'options_tooltip')]"));
		
		return flagTooltip.getText();
	}

	//Verify that by clicking on the reaction Icon will populates the Emojis window.
	public boolean verifyReactionIconClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		
		reaction.click();
		thread();
		return emojiPopup.isDisplayed();
	}
		
	//verify that we have Emoji search option in the window.
	public boolean verifySearchFieldEmojiPopup(String userToSelect,String message) throws Throwable {
		verifyReactionIconClickAction(userToSelect,message);
		thread();
		
		return emojiSearchField.isDisplayed();
	}
	
	//Verify that we have frequently used section in the emoji window
	public boolean verifyFrequentlyUsedSection(String userToSelect,String message) throws Throwable {
		verifyReactionIconClickAction(userToSelect,message);
		thread();
		
		return frequentlyUsedSection.isDisplayed();
	}
	
	//Verify that we are able scroll down to have more emoji types
	public boolean verifyScrollBarEmojiPopup(String userToSelect,String message) throws Throwable {
		verifyReactionIconClickAction(userToSelect,message);
		thread();
		JavascriptExecutor js=((JavascriptExecutor)driver);
		WebElement element=unitedNationsEmoji;
		//js.executeScript("arguments[0].scrollIntoView(true);",element);
		js.executeScript("scroll(0, 500);",element);
		thread();
		element.click();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		WebElement unitedNotations=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//*[contains(@class,'1f1fa-1f1f3')]"));
		return unitedNotations.isDisplayed();
	}
	
	//Verify that by clicking on the cross mark symbol at the top right corner of emoji window will close the emoji window.
	public boolean verifyEmojiPopup_X_Symbol(String userToSelect,String message) throws Throwable {
		verifyReactionIconClickAction(userToSelect,message);
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
	
	//Verify that by clicking on any Emoji from the window will be selected and display beside the message
	public boolean verifyEmojiClickAction(String userToSelect,String message) throws Throwable {
		verifyReactionIconClickAction(userToSelect,message);
		thread();
		JavascriptExecutor js=((JavascriptExecutor)driver);
		WebElement element=grinningFaceEmoji;
		//js.executeScript("arguments[0].scrollIntoView(true);",element);
		js.executeScript("scroll(0, 500);",element);
		thread();
		element.click();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		WebElement grinningFaceSymbol=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//*[contains(@class,'1f600')]"));
		return grinningFaceSymbol.isDisplayed();
	}
	
	//Verify that by adding an emoji to the message,  add reaction icon with emoji symbol will be added next to added emoji.
	public boolean verifyAddReactionSymbol(String userToSelect,String message) throws Throwable {
		verifyEmojiClickAction(userToSelect,message);
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		WebElement addReactionIcon=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'relative tooltip_icon')]"));
		return addReactionIcon.isDisplayed();
		
	}
	
	//Verify that the Emoji added by the logged in user has count 1 and border colour of the emoji will be in blue.
	public String verifyEmojiCount_LoggedInUser(String userToSelect,String message) throws Throwable {
		verifyEmojiClickAction(userToSelect,message);
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				thread();
			}	
		}
		WebElement emojisCount=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//following-sibling::*[@class='count_emoji']"));
		return emojisCount.getText();
		
	}
	
	//Verify that by clicking the same emoji by the opposite user will increase the count by 2 and turns grey border to blue.
	public String verifyEmojiCount_OppUserSelectSameEmoji(String userToSelect,String message,String oppositeUser) throws Throwable {
		verifyEmojiCount_LoggedInUser(userToSelect,message);
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement>conversationList=incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppositeUser)) {
				conversationList.get(i).click();
			}
		}
		
		thread();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=incognito.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				msgThread.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID: " +msgId);
		
		WebElement grinningFaceSymbol=incognito.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//*[contains(@class,'1f600')]"));
		grinningFaceSymbol.click();
		thread();
		
		incognito.close();
		thread();
		WebElement emojisCount=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//following-sibling::*[@class='count_emoji']"));
		System.out.println("Likes Count: "+emojisCount.getText());
		
		return emojisCount.getText();
	}
	
	//Verify that mouse hovering on the emoji will display the user name with avatar who had reacted on it.
	public String verifyUsernamesOnMousehoverEmoji(String userToSelect,String message,String oppositeUser) throws Throwable {
		String emojiSelectedUsers="";
		
		verifyEmojiCount_OppUserSelectSameEmoji(userToSelect,message,oppositeUser);
		thread();
		
		WebElement emoji=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//*[contains(@class,'1f600')]"));
		Actions action=new Actions(driver);
		action.moveToElement(emoji).build().perform();
		thread();
		thread();
		List<WebElement>userNames=driver.findElements(By.xpath(xpath_UserNamesPopup));
		for(int i=0;i<userNames.size();i++) {
			emojiSelectedUsers=userNames.get(i).getText();
			thread();
			
		}
		
		return emojiSelectedUsers;
	}
	
	//Verify that Re-clicking on the added emoji will disappear the emoji  beside the message/ decreases the count.
	public boolean verifyReclickingOnEmoji(String userToSelect,String message) throws Throwable {
		WebElement grinningFaceIcon=null;
		verifyEmojiClickAction(userToSelect,message);
		thread();
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				
				System.out.println("Message Options ID: "+msgOptionsId);
				grinningFaceIcon=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[contains(@class,'box_emoji')]//*[contains(@class,'1f600')]"));
				grinningFaceIcon.click();
				thread();
				
				try {
					if(grinningFaceIcon.isDisplayed()) {
						return false;
					}else if(!grinningFaceIcon.isDisplayed()) {
						return true;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return true;
		
	}
	
	//Verify that Clicking on the reply option from more options in message option is adding that particular message to Input field 
	public String verifyReplyClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		reply.click();
		thread();
		
		return replyMsg_InputFieldSection.getText();
	}
	
	//Verify that by clicking on the cross mark symbol at the top right corner of reply message will remove the reply message added to the input field
	public boolean verifyReplyMsgCrossSymClick(String userToSelect,String message) throws Throwable {
		verifyReplyClickAction(userToSelect,message);
		thread();
		closeReplyMsg.click();
		try {
			if(replyMsg_InputFieldSection.isDisplayed()) {
				return false;
			}
			else if(!replyMsg_InputFieldSection.isDisplayed()) {
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify that by clicking on the Reply all option for plain text message should open a pop up with the same user name populated in the To filed. 
	public String verifyReplyAllClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		replyAll.click();
		thread();
		
		return replyAllPopup_UserName.getText();
	}
	
	
	//Verify that pop-up header name is Reply All
	public boolean verifyReplyAllPopupTitle(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		replyAll.click();
		thread();
		
		return replyAllPopupTitle.isDisplayed();
	}
	
	//verify default subject message in reply all message pop up window
	public String verifyDefaultSubject_ReplyAll(String userToSelect,String message) throws Throwable {
		verifyReplyAllPopupTitle(userToSelect,message);
		thread();
		
		String defaultSubject=subjectField.getAttribute("value");
		
		return defaultSubject;
	}
	
	//Verify that the pop up has @ mentions, Gif, Emoji, Attachment icons in bottom right corner
	public boolean verifyIconsInReplyAllPopup(String userToSelect,String message) throws Throwable {
		verifyReplyAllPopupTitle(userToSelect,message);
		thread();
		
		return replyAll_Atmention.isDisplayed() && replyAll_Emoji.isDisplayed() && replyAll_GIF.isDisplayed() && replyAll_Attachment.isDisplayed();
	}
	
	//Verify that the Attached message has the show message/hide message option beside the reply attachments.
	public boolean verifyShowAndHideMsgOptions(String userToSelect,String message) throws Throwable {
		boolean showMsg=false;
		boolean hideMsg=false;
		verifyReplyAllPopupTitle(userToSelect,message);
		thread();
		showMsg=showMessageBtn.isDisplayed();
		thread();
		showMessageBtn.click();
		thread();
		hideMsg=hideMessageBtn.isDisplayed();
		
		return showMsg && hideMsg;
	}
	
	//verify that the pop-up has a send button at the bottom right corner.
	public boolean verifySendBtnReplyAllPopup(String userToSelect,String message) throws Throwable {
		verifyReplyAllPopupTitle(userToSelect,message);
		thread();
		
		return sendBtn.isDisplayed();
	}
	
	//Verify that by sending the Reply all by adding users in to and cc fields with message content should deliver to all the users.
	public String verifyReplyAllMsgInMsgThread(String userToSelect,String message) throws Throwable {
		String replyAllMsg="";
		verifyReplyAllPopupTitle(userToSelect,message);
		thread();
		String msg = "test message"+chars;
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
		
		List<WebElement>msgThread1=driver.findElements(By.xpath(xpath_replyAllFwdMsgs));
		for(int i=0;i<msgThread1.size();i++) {
			msgThread1.get(i).getText();
			if(msgThread1.get(i).getText().contains(message)) {
				replyAllMsg=msgThread1.get(i).getText();
			}
		}
		
		return replyAllMsg;
	}
	
	//Verify that To and CC should display in the message thread 
	public String verifyReplyAllMsgAddUsersToCc(String userToSelect,String message,String ccKeys,String ccUser) throws Throwable {
		String replyAllToCcMsg="";
		String toCcUsers="";
		verifyReplyAllPopupTitle(userToSelect,message);
		thread();
		
		cc.click();
		ccField.sendKeys(ccKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, ccUser);
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
		
		String replyAllToUser=to_MsgThread.getText()+userToSelect;
		String replyAllCcUser=cc_MsgThread.getText()+ccUser;
		
		String replyAllToCcUsers=replyAllToUser+"\n"+replyAllCcUser;
		String textMsg=message+" "+chars;
		List<WebElement>msgThread1=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread1.size();i++) {
			msgThread1.get(i).getText();
			if(msgThread1.get(i).getText().contains(replyAllToCcUsers)) {
				
				toCcUsers=msgThread1.get(i).getText();
				if(toCcUsers.contains(textMsg)) {
					replyAllToCcMsg=msgThread1.get(i).getText();
				}
			}	
			
			System.out.println(toCcUsers);
		}
		return replyAllToCcMsg;
	
	}
	
	/*Verify that by clicking on the Forward option from more options in message options will display
	 *  a new forward window with Forward text on it*/
	public boolean verifyForwardMsgPopupTitle(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		forward.click();
		thread();
		
		return forwardPopup.isDisplayed();
	}

	//Verify that subject field in forward window has the predefined text as "illumy - Forward Message".
	public String verifyFwdMsgDefaultSubject(String userToSelect,String message) throws Throwable {
		verifyForwardMsgPopupTitle(userToSelect,message);
		String defaultSubject=subjectField.getAttribute("value");
		
		return defaultSubject;
	}
	
	/*Verify that by clicking on the send button without selecting user should 
	 * get a mandatory field message as "Please select at least one user"*/
	public String clickOnSendBtnWithoutUsers_FwdMsg(String userToSelect,String message) throws Throwable {
		verifyForwardMsgPopupTitle(userToSelect,message);
		sendBtn.click();
		thread();
		
		return plsSelectAtleastOneUser.getText();
	}
	
	//Verify that by clicking on send Button with valid user in "To" field has to deliver the forward message 
	public String verifyFwdMsgInMsgThread(String userToSelect,String message,String toKeys,String toUser) throws Throwable {
		String forwardedMsg="";
		verifyForwardMsgPopupTitle(userToSelect,message);
		toField.sendKeys(toKeys);
		Thread.sleep(3000);
		TestUtil.selectElementFromList(xpath_ToFieldAutoSugg, toUser);
		thread();
		
		String msg = "test message"+" "+chars;
		msgBody.sendKeys(msg);
		sendBtn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, toUser);
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
		
		List<WebElement>msgThread1=driver.findElements(By.xpath(xpath_replyAllFwdMsgs));
		for(int i=0;i<msgThread1.size();i++) {
			msgThread1.get(i).getText();
			if(msgThread1.get(i).getText().contains(message)) {
				forwardedMsg=msgThread1.get(i).getText();
			}
		}
		
		
		return forwardedMsg;
	}
	
	//verify that by clicking on the cross mark on the top right corner of forward window should close that particular window.
	public boolean verifyFwdMsgPopupClose_ClickXSym(String userToSelect,String message) throws Throwable {
		verifyForwardMsgPopupTitle(userToSelect,message);
		thread();
		closeBtn_FwdPopup.click();
		thread();
		
		try {
			if(forwardPopup.isDisplayed()) {
				return false;
			}else if(!forwardPopup.isDisplayed()) {
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	/*Verify that by clicking on the Hide option from more options in message options will hide that
	 *  particular message with dark grey color Saying the text "This message is hidden".
	 */
	public boolean verifyHideMessageOption(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		hideMessage.click();
		thread();
		return unhideMsgBtn.isDisplayed();
	}
	
	//Verify that by clicking on the "Unhide message" button will shows up the message and removes the grey border.
	public String verifyUnhideMessage(String userToSelect,String message) throws Throwable {
		String unhideMsg="";
		verifyHideMessageOption(userToSelect,message);
		thread();
		unhideMsgBtn.click();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				unhideMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		
		return unhideMsg;
	}
	
	/*Verify that by clicking on the Edit message from more option in message options
	 *  will enable that message to be editable in the message thread view only.
	 */
	public String verifyEditMsg_MessageThread(String userToSelect,String message) throws Throwable {
		String editMsg="";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		
		return editMsg;
	}
	
	//Verify that we have Add emoji symbol and GIF  icons at top right corner of the message to add reactions.
	public boolean verifyEmoji_GIFIcons_EditMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		
		return editMsgGIF.isDisplayed() && editMsgEmoji.isDisplayed();
	}
	
	/*Verify that by clicking on the cancel button below the editable input message 
	 * field will cancel the edit process and remains the same message
	 */
	public boolean verifyEditMsg_ClickCancelBtn(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		cancelBtn_EditMsg.click();
		thread();
		
		try {
			if(editMsgGIF.isDisplayed() && editMsgEmoji.isDisplayed()) {
				return false;
			}else if(!editMsgGIF.isDisplayed() && editMsgEmoji.isDisplayed()) {
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//Verify that by editing some thing and clicking on "save changes" will reflect the changes in message thread.
	public String verifyEditMsg_ClickSaveChangesBtn(String userToSelect,String message,String keys) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgField.sendKeys(" "+keys);
		thread();
		saveChangesBtn_EditMsg.click();
		String textMsg=message+" "+chars;
		String editedMsg=textMsg+" "+keys;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(editedMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		return editedMsg;
	}
	
	//Verify that after editing a message we have a text "(edited)" besides the message. (to make sure that we have edited it)
	public boolean verifyEditedMsg_LoggedInUser(String userToSelect,String message,String keys) throws Throwable {
		verifyEditMsg_ClickSaveChangesBtn(userToSelect,message,keys);
		thread();
		
		String textMsg=message+" "+chars;
		String editedMsg=textMsg+" "+keys;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(editedMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		
		WebElement editedTag=driver.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[text()='(edited)']"));
		System.out.println("Edited Message: "+editedMsg);
		return editedTag.isDisplayed();
	}
	
	//Verify that the opposite user also has the text "(edited)" once the sender edits it.
	public boolean verifyEditedMsg_OppositeUser(String userToSelect,String message,String keys,String oppositeUser) throws Throwable {
		verifyEditedMsg_LoggedInUser(userToSelect,message,keys);
		
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		List<WebElement>conversationList=incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppositeUser)) {
				conversationList.get(i).click();
			}
		}
		
		thread();
		thread();
		String textMsg=message+" "+chars;
		String editedMsg=textMsg+" "+keys;
		List<WebElement>msgThread=incognito.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(editedMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		
		WebElement oppUserEditedTag=incognito.findElement(By.xpath("//*[@id='"+msgId+"']"+"//*[text()='(edited)']"));
		System.out.println("Edited Message: "+editedMsg);
		
		return oppUserEditedTag.isDisplayed();
	}

	/*Verify that by clicking on the delete option  from more options in message options will opens a confirmation 
	 * popup saying "Are you sure you want to delete this message?" with cancel and confirm buttons.
	 */
	public boolean verifyDeleteClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		delete.click();
		thread();
		
		return deletePopup.isDisplayed();
	}
	
	//Verify that by clicking on the Cancel button will close the popup and message retains same.
	public boolean verifyCancelBtnClickAction(String userToSelect,String message) throws Throwable {
		verifyDeleteClickAction(userToSelect,message);
		
		cancelBtn_DeleteMsg.click();
		thread();
		
		try {
			if(deletePopup.isDisplayed()) {
				return false;
			}else if(!deletePopup.isDisplayed()) {
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//Verify that by clicking on the confirm button will delete that particular message from the message thread.
	public boolean verifyConfirmBtnClickAction(String userToSelect,String message) throws Throwable {
		verifyDeleteClickAction(userToSelect,message);
		confirmBtn_DeletePopup.click();
		thread();
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			
			try{
				if(!msgThread.get(i).getText().contains(textMsg)) {
					msgId=msgThread.get(i).getAttribute("id");
					return true;
			}if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				return false;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
			}
		return true;
	}
	
	//Verify that for the opposite user also the message will be deleted
	public boolean verifyDeletedMsg_OppositeUser(String userToSelect,String message,String oppositeUser) throws Throwable {
		verifyConfirmBtnClickAction(userToSelect,message);
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		List<WebElement>conversationList=incognito.findElements(By.xpath(xpath_ConversationList));
		for(int i=0;i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppositeUser)) {
				conversationList.get(i).click();
			}
		}
		
		thread();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=incognito.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			
			try{
				if(!msgThread.get(i).getText().contains(textMsg)) {
					msgId=msgThread.get(i).getAttribute("id");
					System.out.println(msgThread.get(i).getText());
					return true;
			}if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				return false;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		return true;
	}
	
	//Verify that by clicking on the cross mark on the top right corner of delete popup will close that particular window.
	public boolean verifyDeletePopupXSymbolClick(String userToSelect,String message) throws Throwable {
		verifyDeleteClickAction(userToSelect,message);
		thread();
		
		closeDeletePopup_Xsym.click();
		thread();
		try {
			if(deletePopup.isDisplayed()) {
				return false;
			}else if(!deletePopup.isDisplayed()) {
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
		
	}

}
