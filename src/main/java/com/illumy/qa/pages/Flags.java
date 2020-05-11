/**
 * 
 */
package com.illumy.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
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
public class Flags extends TestBase{

	String msgId="";
	String msgOptionsId="";
	
	WebElement thumbsUpIcon;
	WebElement envelopeIcon;
	WebElement flag;
	WebElement reaction;
	WebElement moreOptions;
	
	String chars = TestUtil.randomChars(5);
	
	String xpath_ConversationList 	= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_MsgThread 			= "//*[contains(@id,'msg_')]";
	String xpath_MsgOptions			= "//*[contains(@id,'options_msg')]";
	String xpath_FlaggedMsg			= "//*[@class='flagged_div']//*[@class='white-space-pre-wrap message__thread ng-star-inserted']";
	//Page Factory : OR
	
	//Text fields:
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']//*[@class='mess_type_box']")
	WebElement MsgInputField;
	
	//Links and buttons:
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Flags']")
	WebElement flags;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Files']")
	WebElement files;
	
	@FindBy(xpath="//*[@class='col-md-3 noselect']")
	WebElement digitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='Sign out']")
	WebElement signOut;
	
	@FindBy(name="email")
	WebElement illumy_email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signin_Btn;
	
	@FindBy(xpath="//*[contains(@class,'chevron-circle')]")
	WebElement viewMsgCircle;
	
	@FindBy(xpath="//*[contains(@class,'flag red_col ')]")
	WebElement flagSymInFlagsSection;
	
	//Validations:
	@FindBy(xpath="//*[text()='No flags to see here right now!']")
	WebElement NoFlagsHereRightNow;
	
	@FindBy(xpath="//*[@style='transform: rotate(0deg);']//preceding-sibling::*[@class='mat-content']//*[text()='Flags']")
	WebElement flagsArrowAt0deg;
	
	@FindBy(xpath="//*[@style='transform: rotate(180deg);']//preceding-sibling::*[@class='mat-content']//*[text()='Flags']")
	WebElement flagsArrowAt180deg;
	
	@FindBy(xpath="//*[@class='flagged_div']//*[@class='white-space-pre-wrap message__thread ng-star-inserted']")
	WebElement flaggedMsgInFlagsSection;
	
	@FindBy(xpath="//*[@class='flagged_div']//*[contains(@class,'over_flow_hi')]//preceding-sibling::*[@class='handCursor']")
	WebElement userNameInFlagsSection;
	
	@FindBy(xpath="//*[contains(@class,'chevron-circle')]//following-sibling::*[contains(@class,'tooltip')]")
	WebElement viewMsgTooltip;
	
	@FindBy(xpath="//*[contains(@class,'flag red_col ')]//following-sibling::*[contains(@class,'tooltip')]")
	WebElement removeFlagTooltip;
	
	
	
	
	//Initializing the page objects:
	public Flags() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
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
				flag=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'fa-flag')]"));
				reaction=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@src,'smile_icon.png')]"));
				moreOptions=driver.findElement(By.xpath("//*[contains(@id,'"+msgOptionsId+"')]"+"//following-sibling::*[contains(@class,'btn_option handCursor')]"));
				
				if(thumbsUpIcon.isDisplayed() && envelopeIcon.isDisplayed() && flag.isDisplayed() && reaction.isDisplayed() && moreOptions.isDisplayed()) {
					return true;
				}
			}
		}
		return true;
	}
	
	//Verify the flag section is displayed or not when an user view is in home page
	public boolean verifyFlagsInHomePage() {
		return flags.isDisplayed();
	}
	
	//Verify the flag section by clicking on the (>) symbol if an user view is in message module
	public String verifyFlagsInMessageModule() throws Throwable {
		files.click();
		thread();
		flags.click();
		thread();
		return NoFlagsHereRightNow.getText();
	}
	
	//Verify the flag section by clicking on the (v) symbol
	public boolean verifyFlagsByClickOnVsymbol(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		flags.click();
		return flagsArrowAt0deg.isDisplayed();
	}
	
	//Checking that when the flags section is in open mode, if the user is logged out and logged in to the application
	public boolean verifyFlagsOpenMode_UserLogoutLogin(String userToSelect,String email, String pwd) throws Throwable{
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		digitalIdentityPanel.click();
		thread();
		signOut.click();
		thread();
		illumy_email.sendKeys(email);
		thread();
		password.sendKeys(pwd);
		thread();
		signin_Btn.click();
		thread();
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		return flagsArrowAt180deg.isDisplayed();
	}
	
	//Checking whether the flags section is hiding or not by clicking on the other options available in the third panel
	public boolean verifyFlagsByClickOtherOptions(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		files.click();
		thread();
		return flagsArrowAt0deg.isDisplayed();
	}
	
	
	//Check if an user doesn’t have any flagged messages in flags section
	public String verifyUserFlagsIfNoFlaggedMsg(String userToSelect) throws Throwable {
		TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		return NoFlagsHereRightNow.getText();
	}
	
	//Verify the flagged message is displayed or not in the flags section
	public String verifyFlaggedMsgInFlags(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		return flaggedMsgInFlagsSection.getText();		
	}
	
	//Verify the user avatar and user name for the flagged message in the flags section 
	public String verifyFlaggedMsgUserName(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		thread();
		return userNameInFlagsSection.getText();
	}
	
	//Check if an user clicks on user name or avatar in the flags section 
	public String clickOnUserNameInFlags(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		userNameInFlagsSection.click();
		thread();
		return driver.getCurrentUrl();
	}
	
	//Verify the mouse hover functionality of a flagged message in the flags section 
	public boolean verifyMousehoverOnFlaggedMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		
		Actions action = new Actions(driver);
		action.moveToElement(flaggedMsgInFlagsSection).build().perform();
		thread();
		return viewMsgCircle.isDisplayed() && flagSymInFlagsSection.isDisplayed();
	}
	
	//Verify the mouse hover functionality of a 'view message' option of a flagged message in the flags section
	public String verifyMousehoverOnViewMsg(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		
		Actions action = new Actions(driver);
		action.moveToElement(flaggedMsgInFlagsSection).build().perform();
		thread();
		action.moveToElement(viewMsgCircle).build().perform();
		return viewMsgTooltip.getText();
	}
	
	//Verify the mouse hover functionality of pink flag symbol of a flagged message in the flags section
	public String verifyMousehoverOnFlagSymbol(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		
		Actions action = new Actions(driver);
		action.moveToElement(flaggedMsgInFlagsSection).build().perform();
		thread();
		action.moveToElement(flagSymInFlagsSection).build().perform();
		return removeFlagTooltip.getText();
	}
	
	//Check the click functionality of view message option of a flagged message
	public String verifyClickOnViewMsg(String userToSelect,String message) throws Throwable {
		String msgBorder = "";
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		
		Actions action = new Actions(driver);
		action.moveToElement(flaggedMsgInFlagsSection).build().perform();
		thread();
		action.moveToElement(viewMsgCircle).click().build().perform();
		thread();
		
		String textMsg=message+" "+chars;
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_MsgThread));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			if(msgThread.get(i).getText().contains(textMsg)) {
				msgBorder = msgThread.get(i).getAttribute("style");
			}	
		}
		return msgBorder;
	}
	
	/*Verify that the flagged message is removed from the flags section, 
	 * if an user clicks on 'Remove Flag' icon from the message thread
	 */
	public boolean clickOnRemoveFlagFromThread(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
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
		
		List<WebElement>msgOptions=driver.findElements(By.xpath(xpath_MsgOptions));
		for(int i=0;i<msgOptions.size();i++) {
			msgOptionsId=msgOptions.get(i).getAttribute("id");

			if(msgOptionsId.contains(msgId)) {
				System.out.println("Message Options ID: "+msgOptionsId);
				flag=driver.findElement(By.xpath("//*[@id="+"'"+msgOptionsId+"']"+"//*[contains(@class,'fa-flag')]"));
				flag.click();
				thread();
			}
		}
		try {
			if(flaggedMsgInFlagsSection.getText().contains(textMsg)) {
				return false;
			}else if(!flaggedMsgInFlagsSection.getText().contains(textMsg)) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//Verify the flagged message removed or not by clicking on the 'Remove Flag' icon from the flags section
	public boolean clickOnRemoveFlagFromFlagSection(String userToSelect,String message) throws Throwable {
		String flaggedMsg = "";
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
		String textMsg=message+" "+chars;
		
		List<WebElement>flaggedMsgs = driver.findElements(By.xpath(xpath_FlaggedMsg));
		System.out.println("Flagged msgs:"+flaggedMsgs.size());
		for(int i=0; i<flaggedMsgs.size();i++) {
			flaggedMsgs.get(i).getText();
			
			if(flaggedMsgs.get(i).getText().contains(textMsg)) {
				flaggedMsg = flaggedMsgs.get(i).getText();
				flaggedMsgs.get(i).click();
			}
		}
		
		
		flagSymInFlagsSection.click();
		thread();
		thread();
		thread();
		List<WebElement>flagsSection = driver.findElements(By.xpath(xpath_FlaggedMsg));
		System.out.println("Flagged msgs:"+flaggedMsgs.size());
		for(int i=0; i<flagsSection.size();i++) {
			flagsSection.get(i).getText();
			try {
				if(flagsSection.get(i).getText().contains(textMsg)) {
					return false;
				}
				
				else if(!flagsSection.get(i).getText().contains(textMsg)) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println(flaggedMsg);
		return true;
		
	}
	
	//Check the scroll functionality, if the flags section exceeds the maximum limits
	public void verifyScrollOfFlagSection(String userToSelect,String message) throws Throwable {
		verifyMsgOptions(userToSelect,message);
		thread();
		flag.click();
		thread();
		files.click();
		thread();
		flags.click();
		thread();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
