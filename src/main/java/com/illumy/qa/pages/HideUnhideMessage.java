/**
 * 
 */
package com.illumy.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class HideUnhideMessage extends TestBase{


	String msgId="";
	String msgOptionsId="";
	
	
	WebElement thumbsUpIcon;
	WebElement envelopeIcon;
	WebElement flag;
	WebElement reaction;
	WebElement moreOptions;
	

	
	String chars = TestUtil.randomChars(5);
	
	//Lists xpaths:
	String xpath_ConversationList = "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_MsgThread = "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions="//*[contains(@id,'options_msg')]";
	
	
	
	//PAGE FACTORY : OR (Object Repository)
	
	//Text fields:
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	
	@FindBy(xpath="//*[contains(text(),'Hide Message')]")
	WebElement hideMessage;
	
	@FindBy(xpath="//*[contains(text(),'Unhide Message')]")
	WebElement unhideMsgBtn;
	
	//Button, Icons and Links:
	
	//Popup's
	
	//Validation messages:
	
	//Initializing the page objects: 
		public HideUnhideMessage() {
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
		
		/*Verify that by clicking on the Hide option from more options in message options will hide that
		 *  particular message with dark grey color Saying the text "This message is hidden".
		 */
		public boolean verifyHideMessageOption(String userToSelect,String message) throws Throwable {
			verifyMsgOptions(userToSelect,message);
			moreOptions.click();
			thread();
			
			hideMessage.click();
			thread();
			
			boolean unhide=unhideMsgBtn.isDisplayed();
			unhideMsgBtn.click();
			thread();
			
			return unhide;
		}
		
	
		//Verify that by clicking on the "Unhide message" button will shows up the message and removes the grey border.
		public String verifyUnhideMessage(String userToSelect,String message) throws Throwable {
			String unhideMsg="";
			verifyMsgOptions(userToSelect,message);
			moreOptions.click();
			thread();
			
			hideMessage.click();
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
