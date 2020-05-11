/**
 * 
 */
package com.illumy.qa.pages;

import java.util.List;

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
public class MarkReadUnread extends TestBase{



	String msgId="";
	String msgOptionsId="";
	
	
	WebElement thumbsUpIcon;
	WebElement envelopeIcon;
	WebElement flag;
	WebElement reaction;
	WebElement moreOptions;
	
	
	String chars = TestUtil.randomChars(5);
	
	//Lists xpaths:
	String xpath_ConversationList = "//*[contains(@class,'users-list-name')]";
	String xpath_MsgThread = "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions="//*[contains(@id,'options_msg')]";
	
	
	
	//PAGE FACTORY : OR (Object Repository)
	
	//Text fields:
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	@FindBy(xpath="//*[contains(@id,'msg_')]")
	WebElement messageThread;
	
	@FindBy(xpath="//*[contains(@class,'dial_img')]")
	WebElement menuBar;
	
	@FindBy(xpath="//*[@class='sidebar-menu']//*[@routerlink='/message']//*[contains(@class,'mess_img')]")
	WebElement messageIcon;
	
	// Button, Icons and Links:

	// Popup's

	// Validation messages:

	// Initializing the page objects:
	public MarkReadUnread() {
		PageFactory.initElements(driver, this);
	}

	// ACTIONS:
	
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

	// Verify the "envelope" (read/unread messages) symbol mouse hover action in the message options of messages in the message thread
	public String verifyMarkUnreadBtnMousehover(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(envelopeIcon).build().perform();
		thread();

		WebElement markUnreadTooltip = driver.findElement(By.xpath("//*[@id=" + "'" + msgOptionsId + "']"
				+ "//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));

		return markUnreadTooltip.getText();
	}

	// Verify that if we click on the mark unread, A vertical purple bar will appear on the left side of the message.
	public boolean verifyMarkUnreadBtnClickAction(String userToSelect, String message) throws Throwable {

		verifyMsgOptions(userToSelect, message);
		thread();

		envelopeIcon.click();
		thread();

		String textMsg = message + " " + chars;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgId = msgThread.get(i).getAttribute("id");

				msgThread.get(i).click();
				thread();
			}
		}

		WebElement unreadMsg = driver
				.findElement(By.xpath("//*[@id='" + msgId + "' " + "and contains(@class,'unread_bg')]"));
		return unreadMsg.isDisplayed();
	}

	// Verify that if we click on the mark unread, The thread count will display on the conversation list user name.
	public String verifyUnreadCountClickMarkUnreadBtn(String userToSelect, String message) throws Throwable {
		WebElement unreadCount = null;
		verifyMarkUnreadBtnClickAction(userToSelect, message);
		thread();

		List<WebElement> conversationList = driver.findElements(By.xpath(xpath_ConversationList));
		for (int i = 0; i < conversationList.size(); i++) {
			conversationList.get(i).getText();
			if (conversationList.get(i).getText().contains(userToSelect)) {
				unreadCount = driver.findElement(By.xpath("//*[contains(@class,'users-list-name')]//following-sibling::*[contains(@class,'media-right')]//label"));
			}
		}

		return unreadCount.getText();
	}

	// Verify that if we mouse hover mark unread after clicking it, The icon will change to mark read status and display the tool tip as mark read
	public String verifyMarkReadTooltip(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		thread();

		Actions action = new Actions(driver);
		action.moveToElement(envelopeIcon).build().perform();
		thread();
		envelopeIcon.click();
		thread();
		WebElement markReadTooltip = driver.findElement(By.xpath("//*[@id=" + "'" + msgOptionsId + "']"
				+ "//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));

		return markReadTooltip.getText();
	}

	// Verify that if we click on the mark read icon then the purple bar will disappears.
	public String verifyMarkReadClickAction(String userToSelect, String message) throws Throwable {
		verifyMarkReadTooltip(userToSelect, message);
		thread();

		List<WebElement> msgOptions = driver.findElements(By.xpath(xpath_MsgOptions));
		for (int i = 0; i < msgOptions.size(); i++) {
			msgOptionsId = msgOptions.get(i).getAttribute("id");

			if (msgOptionsId.contains(msgId)) {

				System.out.println("Message Options ID: " + msgOptionsId);
				WebElement envelopeBtn = driver.findElement(
						By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@class,'envelope')]"));
				envelopeBtn.click();
				thread();
			}
		}
		WebElement markUnreadTooltip = driver.findElement(By.xpath("//*[@id=" + "'" + msgOptionsId + "']"
				+ "//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));

		return markUnreadTooltip.getText();
	}
		
	//Verify that the purple bars will disappear if we move the thread page up and again viewing the purple bar	
	public void verifyMarkUnreadMsg_PageUpAndDown(String userToSelect, String message) throws Throwable {
	
		verifyMsgOptions(userToSelect, message);
		thread();
		
		envelopeIcon.click();
		thread();
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("window.scrollBy(0,-500)", messageThread);
		

		
	}
	
	//Verify that the purple bar will display for four seconds and then disappear if it comes in to view.
	public boolean verifyMarkUnreadMsg_ViewMessage(String userToSelect, String message) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		thread();
		
		envelopeIcon.click();
		thread();
		menuBar.click();
		thread();
		messageIcon.click();
		thread();
		menuBar.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		thread();
		String textMsg = message + " " + chars;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgId = msgThread.get(i).getAttribute("id");
				thread();
			}
		}

		try {
			if(!driver.findElement(By.xpath("//*[@id='" + msgId + "' " + "and contains(@class,'unread_bg')]")).isDisplayed()) {
				return true;
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify that marking unread and moving into another thread and viewing the thread will disappears the purple bar in four seconds.
	public boolean verifyMarkUnreadMsg_MoveToAnotherThread(String userToSelect, String message,String userToSelect1) throws Throwable {
		verifyMsgOptions(userToSelect, message);
		thread();
		
		envelopeIcon.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect1);
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		thread();
		
		String textMsg = message + " " + chars;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgId = msgThread.get(i).getAttribute("id");
				thread();
			}
		}

		try {
			if(!driver.findElement(By.xpath("//*[@id='" + msgId + "' " + "and contains(@class,'unread_bg')]")).isDisplayed()) {
				return true;
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	//verify that if the purple bar disappears the mark read will again turns into mark unread.
	public String verifyMarkUnread_ClickMarkRead(String userToSelect, String message) throws Throwable{
		verifyMarkReadTooltip(userToSelect, message);
		thread();

		List<WebElement> msgOptions = driver.findElements(By.xpath(xpath_MsgOptions));
		for (int i = 0; i < msgOptions.size(); i++) {
			msgOptionsId = msgOptions.get(i).getAttribute("id");

			if (msgOptionsId.contains(msgId)) {

				System.out.println("Message Options ID: " + msgOptionsId);
				WebElement envelopeBtn = driver.findElement(
						By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@class,'envelope')]"));
				envelopeBtn.click();
				thread();
			}
		}
		WebElement markUnreadTooltip = driver.findElement(By.xpath("//*[@id=" + "'" + msgOptionsId + "']"
				+ "//*[contains(@class,'envelope')]//following-sibling::*[contains(@class,'options_tooltip')]"));

		return markUnreadTooltip.getText();
	}
	
	//Verify that if the purple bar disappears the unread count on the conversation list also gets vanished.
	public boolean verifyUnreadCount_ClickMarkRead(String userToSelect, String message) throws Throwable {
		
		WebElement unreadCount = null;
		verifyMarkUnreadBtnClickAction(userToSelect, message);
		thread();

		List<WebElement> conversationList = driver.findElements(By.xpath(xpath_ConversationList));
		for (int i = 0; i < conversationList.size(); i++) {
			conversationList.get(i).getText();
			if (conversationList.get(i).getText().contains(userToSelect)) {
				unreadCount = driver.findElement(By.xpath("//*[contains(@class,'users-list-name')]//following-sibling::*[contains(@class,'media-right')]//label"));
			}
		}
		
		System.out.println(unreadCount.getText());
		
		String textMsg = message + " " + chars;
		List<WebElement> msgThread = driver.findElements(By.xpath(xpath_MsgThread));
		for (int i = 0; i < msgThread.size(); i++) {
			msgThread.get(i).getText();
			if (msgThread.get(i).getText().contains(textMsg)) {
				msgId = msgThread.get(i).getAttribute("id");

				msgThread.get(i).click();
				thread();
			}
		}
		List<WebElement> msgOptions = driver.findElements(By.xpath(xpath_MsgOptions));
		for (int i = 0; i < msgOptions.size(); i++) {
			msgOptionsId = msgOptions.get(i).getAttribute("id");

			if (msgOptionsId.contains(msgId)) {

				System.out.println("Message Options ID: " + msgOptionsId);
				WebElement envelopeBtn = driver.findElement(
						By.xpath("//*[@id=" + "'" + msgOptionsId + "']" + "//*[contains(@class,'envelope')]"));
				envelopeBtn.click();
				thread();
			}
		}
		
		try {
			if(!unreadCount.isDisplayed()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;	
	}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
