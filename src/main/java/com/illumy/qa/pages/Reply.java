/**
 * 
 */
package com.illumy.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class Reply extends TestBase{

	
	String msgId="";
	String msgOptionsId="";
	
	WebElement moreOptions;
	
	String chars = TestUtil.randomChars(5);
	
	//Lists xpaths:
	String xpath_ConversationList = "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_MsgThread = "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions="//*[contains(@id,'options_msg')]";
	String xpath_replyAllFwdMsgs="//*[contains(@id,'forwardReply')]";
	String xpath_ViewMessage="//*[text()='View Message']";
	
	//PAGE FACTORY : OR (Object Repository)
	
	//Text fields:
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	
	
	
	//Button, Icons and Links:
	@FindBy(xpath="//a[text()='Reply']")
	WebElement reply;
	
	@FindBy(xpath="//a[text()='Reply All']")
	WebElement replyAll;
	
	@FindBy(xpath="//a[text()='Forward']")
	WebElement forward;
	
	@FindBy(xpath="//a[text()='Hide Message']")
	WebElement hideMessage;
	
	@FindBy(xpath="//a[text()='Edit Message']")
	WebElement editMessage;
	
	@FindBy(xpath="//a[text()='Delete ']")
	WebElement delete;
	
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[contains(@id,'replay_message')]//*[contains(@class,'text-primary')]")
	WebElement userName_ReplyMsg;
	
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[contains(@id,'replay_message')]//*[contains(@class,'text-gray')]")
	WebElement date_TimeStamp;
	
	@FindBy(xpath="//*[contains(@class,'fas fa-external-link')]")
	WebElement replyAllIcon_ReplyMsg;
	
	@FindBy(xpath="//*[contains(@class,'replyClose')]//*[contains(@class,'fas fa-times')]")
	WebElement crossSymbol_ReplyMsg;
	
	@FindBy(xpath="//*[@id='replay_message_scroll']//following-sibling::*[@class='slimScrollBar']")
	WebElement replyMsg_Scroll;
	
	@FindBy(xpath="//*[contains(@class,'subject_open')]//div")
	WebElement subjectExpander;
	
	@FindBy(xpath="//*[@id='subject']")
	WebElement subjectField;
	
	@FindBy(xpath="//*[text()='View Message']")
	WebElement viewMessage;
	
	//Popup's:
	@FindBy(xpath="//*[@class='slimScrollDiv']//*[contains(@id,'replay_message')]")
	WebElement replyMessagePopup;
	
	@FindBy(xpath="//*[text()=' Reply All ']")
	WebElement replyAllPopup;
	
	
	//Validation messages:
	
	//Initializing the page objects: 
		public Reply() {
			PageFactory.initElements(driver, this);
		}
		
		//ACTIONS: 
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
					
					moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
					
					moreOptions.click();
					thread();
				}
			}
			return true;
		}
		
		
		//Verify the reply click functionality by clicking on  more options of a message
		public boolean verifyReplyClickAction(String userToSelect,String message) throws Throwable {
			verifyMsgOptions(userToSelect,message);
			thread();
			reply.click();
			thread();
			
			return replyMessagePopup.isDisplayed();
		}
		
		//Check whether the reply message in highlighted with border or not above message input field
		public String verifyReplyMsgBorder(String userToSelect,String message) throws Throwable {
			verifyReplyClickAction(userToSelect,message);
			String borderColor="";
			String userColor=replyMessagePopup.getCssValue("border-left-color");
			borderColor=Color.fromString(userColor).asHex();
			
			return borderColor;
		}
		
		//Verify the avatar, user name, date, and time stamp in the reply message above the message input field
		public boolean verifyReplyMsgUserName_Date_Time(String userToSelect,String message) throws Throwable {
			verifyReplyMsgBorder(userToSelect,message);
			if(userName_ReplyMsg.isDisplayed() && date_TimeStamp.isDisplayed()) {
				System.out.println("User name: "+userName_ReplyMsg.getText());
				System.out.println("Date and Time : "+date_TimeStamp.getText());
				return true;
			}
			return true;
		}
		
		//Verify the 'Reply All' icon in reply message section
		public boolean verifyReplyAllIcon_ReplyMsg(String userToSelect,String message) throws Throwable {
			verifyReplyClickAction(userToSelect,message);
			
			return replyAllIcon_ReplyMsg.isDisplayed();
		}
		
		//Check the cross symbol (X) is displaying or not at the right hand side of the reply message section
		public boolean verifyCrossSymbol_ReplyMsg(String userToSelect,String message) throws Throwable {
			verifyReplyClickAction(userToSelect,message);
			
			return crossSymbol_ReplyMsg.isDisplayed();
		}
		
		//Verify the scroll functionality is working or not for long text messages in reply message view
		public boolean verifyReplyMsg_ScrollBarForLongText(String userToSelect,String message) throws Throwable {
			TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
			thread();
			String textMsg=message+" "+chars;
			
			for(int i=0;i<30;i++) {
				MsgInputField.sendKeys(textMsg);
			}
			
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
					
					moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
					
					moreOptions.click();
					thread();
					reply.click();
					thread();
					return replyMsg_Scroll.isDisplayed();
				}
		
			}
			return true;
		
		}	
		
		//Verify the click functionality of the 'Reply All' icon in the reply message section
		public boolean verifyReplyAllIconClickAction(String userToSelect,String message) throws Throwable {
			verifyReplyAllIcon_ReplyMsg(userToSelect,message);
			replyAllIcon_ReplyMsg.click();
			thread();
			return replyAllPopup.isDisplayed();
		}
		
		//Verify that the reply message is closing or not by clicking on the  cross symbol (X) icon
		public boolean verifyReplyMsg_CrossSymClickAction(String userToSelect,String message) throws Throwable {
			verifyCrossSymbol_ReplyMsg(userToSelect,message);
			thread();
			
			crossSymbol_ReplyMsg.click();
			thread();
			
			try {
				if(replyMessagePopup.isDisplayed()) {
					return false;
				}else if(!replyMessagePopup.isDisplayed()) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		
		//Verify the default subject for the reply message by clicking on 'Add subject'
		public String verifyDefaultSubject_ReplyMsg(String userToSelect,String message) throws Throwable {
			verifyMsgOptions(userToSelect,message);
			thread();
			reply.click();
			thread();
			subjectExpander.click();
			thread();
			return subjectField.getAttribute("value");
		}
		
		//Verify the reply message in message thread by giving reply to that particular message
		public String verifyReplyMsgInMsgThread(String userToSelect,String message,String replyMsg) throws Throwable {
			String replyAllMsg="";
			verifyMsgOptions(userToSelect,message);
			thread();
			reply.click();
			thread();
			String reply = replyMsg+" "+chars;
			MsgInputField.sendKeys(reply);
			thread();
			MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
			thread();
			List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
			for(int i=0;i<msgThread.size();i++) {
				msgThread.get(i).getText();
				if(msgThread.get(i).getText().contains(reply)) {
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
		
		
		//Verify that by sending the message with enabling the subject line should deliver the subject as well
		public String verifyReplyMsgWithDefaultSubject(String userToSelect,String message,String replyMsg) throws Throwable {
			verifyMsgOptions(userToSelect,message);
			thread();
			reply.click();
			thread();
			subjectExpander.click();
			thread();
			String reply = replyMsg+" "+chars;
			MsgInputField.sendKeys(reply);
			thread();
			MsgInputField.sendKeys(Keys.chord(Keys.ENTER));
			thread();
			List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
			for(int i=0;i<msgThread.size();i++) {
				msgThread.get(i).getText();
				if(msgThread.get(i).getText().contains(reply)) {
					msgId=msgThread.get(i).getAttribute("id");
					thread();
				}	
			}
			
			driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[text()='Show more']")).click();
			thread();
			
			//String textMsg=message+" "+chars;
			List<WebElement>msgThread1=driver.findElements(By.xpath(xpath_MsgThread));
			for(int i=0;i<msgThread1.size();i++) {
				msgThread1.get(i).getText();
				if(msgThread1.get(i).getText().contains(message)) {
					msgId=msgThread1.get(i).getAttribute("id");
					thread();
				}	
			}
			
			WebElement replyMsg_subject=driver.findElement(By.xpath("//*[@id='"+msgId+"']//following-sibling::*[@class='ng-star-inserted']"));

			return replyMsg_subject.getText();
		}
		
		//Verify that view message option in the replay message beside the replied message
		public boolean verifyViewMsgOption_ReplyMsg(String userToSelect,String message,String replyMsg) throws Throwable {
			verifyReplyMsgInMsgThread(userToSelect,message,replyMsg);
			
			String textMsg=message+" "+chars;
			List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
			for(int i=0;i<msgThread.size();i++) {
				msgThread.get(i).getText();
				if(msgThread.get(i).getText().contains(textMsg)) {
					msgId=msgThread.get(i).getAttribute("id");
					thread();
				}	
			}
			
			WebElement viewMsg=driver.findElement(By.xpath("//*[@id='"+msgId+"']//*[text()='View Message']"));
			
			return viewMsg.isDisplayed();
		}
				
}
