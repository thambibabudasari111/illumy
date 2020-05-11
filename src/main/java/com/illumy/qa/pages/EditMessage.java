/**
 * 
 */
package com.illumy.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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
public class EditMessage extends TestBase{

	public MessageOptions msgOptions;
	String msgId = "";
	String msgId1= "";
	String msgOptionsId = "";

	WebElement thumbsUpIcon;
	WebElement envelopeIcon;
	WebElement flag;
	WebElement reaction;
	WebElement moreOptions;

	String chars = TestUtil.randomChars(5);
	
	// Lists xpaths:
	String xpath_ConversationList 	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_MsgThread 			= "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions			= "//*[contains(@id,'options_msg')]";
	String xpath_AtmentionsAutoSugg	= "//*[@id='results-editable']//*[contains(@class,'users__name')]//a";
	String xpath_GiphyPopup			= "//*[@id='edit_message_giphydiv_body']//*[@class='ng-star-inserted']";
	
	// PAGE FACTORY : OR (Object Repository)

	// Text fields:
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	@FindBy(xpath="//*[contains(@class,'editmsg')]")
	WebElement editMsgField;
	
	//Links:
	@FindBy(xpath="//*[text()='Edit Message']")
	WebElement editMessage;
	
	//Button and Icons:
	@FindBy(xpath="//*[contains(@class,'gif_rig')]//*[contains(@class,'gif_bto_cs')]")
	WebElement editMsgGIF;
	
	@FindBy(xpath="//*[contains(@class,'btn emoji_click')]//*[contains(@class,'smile_icon')]")
	WebElement editMsgEmoji;
	
	@FindBy(xpath="//*[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	@FindBy(xpath="//*[contains(@class,'center')]//*[contains(text(),'Cancel')]")
	WebElement cancelBtn_Center;
	
	@FindBy(xpath="//*[contains(text(),'Save Changes')]")
	WebElement saveChangesBtn;
	
	@FindBy(xpath="//*[contains(@class,'center')]//*[contains(text(),'Save')]")
	WebElement saveBtn_Center;
	
	@FindBy(xpath="//*[@id='edit_message_giphydiv_body']//*[@id='giphyOne']//*[contains(@class,'img-responsive')]")
	WebElement selectGiphy_EditMsg;
	
	@FindBy(xpath="//*[@id='edit_message_giphydiv_body']//*[@id='giphyOne']//*[contains(@class,'img-responsive')]//*")
	WebElement GIF_EditMsg;
	
	@FindBy(xpath="//*[@id='edit_message_emojidiv_body']//*[contains(@class,'1f600')]")
	WebElement grinningFaceEmoji_EditMsg;
	
	@FindBy(xpath="//*[@class='emojimain_div']//*[contains(@class,'1f600')]")
	WebElement ginningFaceEmoji_MsgThread;
	
	// Popup's:
	
	// Validations:
	@FindBy(xpath="//*[text()='You are in the middle of editing some message. Do you want to save and continue?']")
	WebElement editMsgAlert;
	
	@FindBy(xpath="//*[text()='Would you like to save the changes before leaving the page?']")
	WebElement editMsgAlert1;
	
	@FindBy(xpath="//*[text()='(edited)']")
	WebElement editedTag;
	
	// Initializing the page objects:
	public EditMessage() {
		PageFactory.initElements(driver, this);
	}

	
	//Actions:
	
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
	
	//Verify that Edit message option is only available for the message sent by sender only.
	public boolean verifyEditMsgOptForSentMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		return editMessage.isDisplayed();
		
	}
	
	//Verify that if we click on any Edit message the editable text editor will appear with Cancel and save changes option.
	public boolean verifyEditMsgClickAction(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		editMessage.click();
		thread();
		return editMsgField.isDisplayed();
	}
	
	//Verify that in the editor field the existing message exists or not.
	public boolean verifyMsgInEditMsgSection(String userToSelect,String message) throws Throwable {
		
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		String textMsg=message+" "+chars;
		if (editMsgField.getText().contains(textMsg)) {
			System.out.println(editMsgField.getText());
			return true;
		}else {
			return false;
		}
		
	}
	
	//Verify that we have gif and emoji option icon in the Text editor.
	public boolean verifyGiphyAndEmojiIcons_EditMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		
		return editMsgGIF.isDisplayed() && editMsgEmoji.isDisplayed();
	}
	
	//Verify that we can close the edit message box by clicking on the escape key in the key board
	public boolean verifyEditMsgByClickOnEscKey(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgField.sendKeys(Keys.chord(Keys.ESCAPE));
		thread();
		
		try {
			if(editMsgField.isDisplayed()) {
				return false;
			}else if(!editMsgField.isDisplayed()){
				return true;
		}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//Verify that by hitting enter after the changes should save the changes accordingly.
	public String verifyEditMsgByClickOnEnter(String userToSelect,String message,String editMsg) throws Throwable {
		String editedMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgField.sendKeys(" "+editMsg,Keys.chord(Keys.ENTER));
		thread();
		
		String textMsg=message+" "+chars;
		String editedmsg = textMsg+" "+editMsg;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(editedmsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		
		return editedMsg;
	}
	
	//Verify that by clicking on the cancel button in the middle of the edit will save with out any changes.
	public String clickOnCancelBtnInMiddleOfEditMsg(String userToSelect,String message,String editMsg) throws Throwable {
		String editedMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgField.sendKeys(" "+editMsg);
		thread();
		cancelBtn.click();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		return editedMsg;
	}
	
	//Verify that by editing some thing in the message and clicking on save changes should reflect the changes in thread.
	public String clickOnSaveChangesAfterEditingMsg(String userToSelect,String message,String editMsg) throws Throwable {
		String editedMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgField.sendKeys(" "+editMsg);
		thread();
		saveChangesBtn.click();
		thread();
		
		String textMsg=message+" "+chars;
		String editedmsg = textMsg+" "+editMsg;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(editedmsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		
		return editedMsg;
	}
	
	//Verify that by editing and saving the changes will reflect at the far end user or not.
	public String verifyEditedMsgAtFarEndUser(String userToSelect,String message,String editMsg,String oppUser) throws Throwable {
		String editedMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgField.sendKeys(" "+editMsg);
		thread();
		saveChangesBtn.click();
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		
		List<WebElement>conversationList = incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		for(int i=0; i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppUser)) {
				conversationList.get(i).click();
			}
		}
		thread();
		thread();
		thread();
		String textMsg=message+" "+chars;
		String editedmsg = textMsg+" "+editMsg;
		List<WebElement>msgThread = incognito.findElements(By.xpath("//*[contains(@id,'msg_')]"));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(editedmsg)) {
				msgId=msgThread.get(i).getAttribute("id");
				
				editedMsg=msgThread.get(i).getText();
				thread();
			}	
		}
		incognito.close();
		return editedMsg;
	}
	
	//Verify that by entering  @mentions in the edit message should display the @mentions popup with the existing users in thread
	public String verifyAtmentionPopup_EditMsg(String userToSelect,String message,String userToSelect1) throws Throwable {
		String user1="";
		String user2="";
		
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		
		editMsgField.sendKeys(" "+Keys.chord(Keys.SHIFT)+"@");
		thread();
		
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
	
	//Verify that we can able to select the @mention users in the edit message and able save them successfully
	public String verifyAtmentionUsersInThread_EditMsg(String userToSelect,String message) throws Throwable {
		String atmentionUserInMsgThread = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		
		editMsgField.sendKeys(" "+Keys.chord(Keys.SHIFT)+"@");
		thread();
		WebElement atmentionUser = driver.findElement(By.xpath("//a[@class='ng-star-inserted' and text()=' "+userToSelect+" ']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(atmentionUser).click().build().perform();
		
		saveChangesBtn.click();
		String textMsg=message+" "+chars;
		String atmentionUser_Thread = textMsg +" "+"@"+userToSelect;
		List<WebElement>atmentionUserInThread = driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<atmentionUserInThread.size();i++) {
			atmentionUserInThread.get(i).getText();
			if(atmentionUserInThread.get(i).getText().contains(atmentionUser_Thread)) {
				atmentionUserInMsgThread = atmentionUserInThread.get(i).getText();
			}
		}
		return atmentionUserInMsgThread;
	}
	
	//Verify that we can edit and insert the gif's and save them successfully
	public boolean editGiphyInEditMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgGIF.click();
		thread();
		
		String giphy_Src=GIF_EditMsg.getAttribute("src");
		selectGiphy_EditMsg.click();
		thread();
		saveChangesBtn.click();
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
					if (msg.get(j).getText().contains(giphy_Src)) {
						return true;
					}
				}
			}
		}
		System.out.println(giphy_Src);
		return true;
	}
	
	//Verify that we can edit and insert the Emoji's and save them successfully
	public boolean editEmojiInEditMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		editMsgEmoji.click();
		thread();
		grinningFaceEmoji_EditMsg.click();
		thread();
		
		saveChangesBtn.click();
		thread();
		String emoji_MsgThred = ginningFaceEmoji_MsgThread.getAttribute("class");
		String textMsg = message + " " + chars;
		
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());

				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(emoji_MsgThred)) {
						return true;
					}
				}
			}
		}
		System.out.println(emoji_MsgThred);
		return true;
	}
	
	/*Verify that if we try to edit second message if one is already in edit mode it says 
	 * "You are in the middle of editing some message. Do you want to save and continue?" pop up with cancel and save pop up
	 */
	public String edit2MsgsAtaTime(String userToSelect,String message,String message1) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		String textMsg=message+" "+chars;
		MsgInputField.sendKeys(textMsg);
		thread();
		MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
		thread();
		
		String msg1 = message1+" "+chars;
		MsgInputField.sendKeys(msg1, Keys.chord(Keys.ENTER));
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
				moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
				moreOptions.click();
				thread();
			}
		}
		
		editMessage.click();
		thread();
		
		List<WebElement>msgThread1=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread1.size();i++) {
			msgThread1.get(i).getText();
			if(msgThread1.get(i).getText().contains(msg1)) {
				msgId1=msgThread1.get(i).getAttribute("id");
				
				msgThread1.get(i).click();
				thread();
			}	
		}
		
		System.out.println("Message ID 1: " +msgId1);
		
		List<WebElement>msgOptions1=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions1.size();i++) {
			msgOptionsId=msgOptions1.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId1)) {
				System.out.println("Message Options ID: "+msgOptionsId);
				
				//Message options
				moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
				moreOptions.click();
				thread();
				
			}
		}
		
		editMessage.click();
		thread();
		
		return editMsgAlert.getText();
	}
	
	/*By clicking on the cancel button in the edit message warning popup it will cancel
	 *  the edit and stays at the first edit message 
	 */
	public boolean clickOnCancelBtnEdit2Msgs(String userToSelect,String message,String message1) throws Throwable {
		edit2MsgsAtaTime(userToSelect,message,message1);
		thread();
		cancelBtn_Center.click();
		thread();
		String editMsg = editMsgField.getText();
		System.out.println(editMsg);
		if(editMsg.contains(message1)) {
			return true;
		}else{
			return false;
		}
	}

	/*By clicking on the save button in the edit message warning popup it will saves 
	 * the first message and edits the second message
	 */
	public String clickOnSaveBtnEdit2Msgs(String userToSelect,String message,String message1) throws Throwable {
		String savedEditMsg = "";
		edit2MsgsAtaTime(userToSelect,message,message1);
		thread();
		saveBtn_Center.click();
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(message)) {
				savedEditMsg=msgThread.get(i).getText();				
			}	
		}
		return savedEditMsg;
	}
	
	/*Verify that by clicking on Edit message and try change module or click some other
	 *  links like other user or contacts or setting, warning pop will display
	 */
	public String verifyEditMsgByClickOnContact(String userToSelect,String message,String userToSelect1) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		
		editMessage.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect1);
		thread();
		return editMsgAlert1.getText();
	}
	
	//Verify that by clicking on the cancel it will cancel the edit and redirects to page respectively
	public String clickOnCancelBtnFromAlertPopup(String userToSelect,String message,String userToSelect1,String editMsg) throws Throwable {
		String cancelledEditMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		editMessage.click();
		thread();
		editMsgField.sendKeys(editMsg);
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect1);
		thread();
		cancelBtn_Center.click();
		thread();
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(message)) {
				cancelledEditMsg=msgThread.get(i).getText();				
			}	
		}
		return cancelledEditMsg;
	}
	
	//Verify that by clicking on save it will save the edited content
	public String clickOnSaveBtnFromAlertPopup(String userToSelect,String message,String userToSelect1,String editMsg) throws Throwable {
		String savedEditMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		editMessage.click();
		thread();
		editMsgField.sendKeys(" "+editMsg);
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect1);
		thread();
		saveBtn_Center.click();
		thread();
		
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		String textMsg=message+" "+chars;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());

				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(editMsg)) {
						savedEditMsg = msg.get(j).getText();
					}
				}
			}
		}
		
		return savedEditMsg;
	}
	
	/*Verify that in P2P and in Groups if we edit the message and save then it will display
	 *  as edited at the end of the message in the thread showing that we edited it.
	 */
	public String verifyEditedTagAtSender(String userToSelect,String message,String editMsg) throws Throwable {
		String editedTagForMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		editMessage.click();
		thread();
		
		editMsgField.sendKeys(" "+editMsg);
		thread();
		saveChangesBtn.click();
		
		String textMsg=message+" "+chars;
		String edited=editedTag.getText();
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				System.out.println(msgThread.get(i).getText());

				List<WebElement> msg = driver.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(edited)) {
						editedTagForMsg = msg.get(j).getText();
					}
				}
			}
		}
		
		return editedTagForMsg;
	}
	
	//Verify that edited tag for the edited message should display for the opposite user also.
	public String verifyEditedTagAtOppUser(String userToSelect,String message,String editMsg,String oppUser) throws Throwable {
		String editedTagForMsg = "";
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		editMessage.click();
		thread();
		
		editMsgField.sendKeys(" "+editMsg);
		thread();
		saveChangesBtn.click();
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
		incognito.findElement(By.name("email")).sendKeys(prop.getProperty("illumyEmail7"));
		thread();
		incognito.findElement(By.id("password")).sendKeys(prop.getProperty("password2"));
		thread();
		incognito.findElement(By.xpath("//button[@type='submit']")).click();
		thread();
		thread();
		thread();
		thread();
		
		List<WebElement>conversationList = incognito.findElements(By.xpath("//span[@class='media-body users-list-name no-margin ng-star-inserted']"));
		for(int i=0; i<conversationList.size();i++) {
			conversationList.get(i).getText();
			if(conversationList.get(i).getText().contains(oppUser)) {
				conversationList.get(i).click();
			}
		}
		thread();
		thread();
		thread();
		
		String textMsg=message+" "+chars;
		String edited=incognito.findElement(By.xpath("//*[text()='(edited)']")).getText();
		
		List<WebElement> msgThread = incognito.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgThread.get(i).getText();

				List<WebElement> msg = incognito.findElements(By.xpath(xpath_MsgThread));
				for (int j = 0; j < msg.size(); j++) {
					msg.get(j).getText();
					if (msg.get(j).getText().contains(edited)) {
						editedTagForMsg = msg.get(j).getText();
					}
				}
			}
		}
		incognito.close();
		return editedTagForMsg;
	}

	//Verify that if we edit the message and we did no changes and clicked on save or cancel will not show the edit tag.
	public boolean clickCancelOrSaveBtnWithoutChanges_EditMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		moreOptions.click();
		thread();
		editMessage.click();
		thread();
		saveChangesBtn.click();
		thread();
		
		String textMsg=message+" "+chars;
		String edited=driver.findElement(By.xpath("//*[text()='(edited)']")).getText();
		
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgThread.get(i).getText();
				
				if(textMsg.contains(edited)) {
					return false;
				}else {
					return true;
				}
			}
		}
		return true;
		
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
