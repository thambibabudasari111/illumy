/**
 * 
 */
package com.illumy.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;

/**
 * @author thambibabu.dasari
 *
 */
public class Notifications extends TestBase{


	//Initializing the page objects:
	public Notifications() {
		PageFactory.initElements(driver, this);
	}
	
	
	String xpath_Dropdonw  = "//*[contains(@id,'overlay')]//*[@role='option']";
	
	//Page Factory: OR (Object Repository)
	
	//Buttons and Icons:
	@FindBy(xpath = "//*[@class='col-md-3 noselect']")
	WebElement digitalIdentityPanel;

	@FindBy(xpath = "//*[@class='pulldown_nav']//*[text()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//*[text()='Receive desktop notifications for new messages and important activity']//preceding-sibling::*[contains(@class,'checked')]//*[contains(@class,'toggle-thumb')]//*[contains(@class,'toggle-thumb')]")
	WebElement receiveDesktopNotifEnableToggle;
	
	@FindBy(xpath="//*[text()='Receive desktop notifications for new messages and important activity']//preceding-sibling::*[@class='mat-slide-toggle mat-primary']//*[@class='mat-slide-toggle-thumb']")
	WebElement receiveDesktopNotifDisableToggle;
	
	@FindBy(xpath="//*[contains(text(),'Disable notifications')]//preceding-sibling::*[@class='mat-slide-toggle mat-primary']//*[@class='mat-slide-toggle-thumb']")
	WebElement disableNotifDisableToggle;
	
	@FindBy(xpath="//*[contains(text(),' to ')]//preceding-sibling::*[contains(@class,'width')]//*[contains(@role,'listbox')]//*[contains(@class,'select-value')]")
	WebElement startTime;
	
	@FindBy(xpath="//*[contains(text(),' to ')]//following-sibling::*[contains(@class,'width')]//*[contains(@role,'listbox')]//*[contains(@class,'select-value')]")
	WebElement endTime;
	
	@FindBy(xpath="//*[contains(@id,'overlay')]//*[@role='option']")
	WebElement dropDown;
	
	@FindBy(xpath="//*[contains(text(),' to ')]//preceding-sibling::*[contains(@class,'width')]//*[contains(@role,'listbox')]//*[contains(@class,'select-arrow-wrapper')]")
	WebElement startTimeDownArrow;
	
	@FindBy(xpath="//*[contains(text(),' to ')]//following-sibling::*[contains(@class,'width')]//*[contains(@role,'listbox')]//*[contains(@class,'select-arrow-wrapper')]")
	WebElement endTimeDownArrow;
	
	@FindBy(xpath="//*[text()='Incoming message']//preceding-sibling::*[contains(@class,'checked')]//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'toggle-thumb')]")
	WebElement incomingMsgEnableToggle;
	
	@FindBy(xpath="//*[text()='Incoming message']//preceding-sibling::*[@class='mat-slide-toggle mat-primary']//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'toggle-thumb')]")
	WebElement incomingMsgDisableToggle;
	
	@FindBy(xpath="//*[text()='Incoming message']//following-sibling::*[contains(@class,'label')]//*[contains(@role,'listbox')]//*[contains(@class,'select-value')]")
	WebElement incomingMsgToneField;
	
	@FindBy(xpath="//*[text()='Outgoing message']//following-sibling::*[contains(@class,'label')]//*[contains(@role,'listbox')]//*[contains(@class,'select-value')]")
	WebElement outgoingMsgToneField;
	
	@FindBy(xpath="//*[text()='Incoming message']//following-sibling::*[contains(@class,'label')]//*[contains(@role,'listbox')]//*[contains(@class,'select-arrow-wrapper')]")
	WebElement incomingMsgFieldDownArrow;
	
	@FindBy(xpath="//*[text()='Outgoing message']//following-sibling::*[contains(@class,'label')]//*[contains(@role,'listbox')]//*[contains(@class,'select-arrow-wrapper')]")
	WebElement outgoingMsgFieldDownArrow;
	
	@FindBy(xpath="//*[text()='Incoming message']//following-sibling::*[@class='handCursor']//*[contains(@class,'fa-play')]")
	WebElement incomingMsgPlayBtn;
	
	@FindBy(xpath="//*[text()='Outgoing message']//following-sibling::*[@class='handCursor']//*[contains(@class,'fa-play')]")
	WebElement outgoingMsgPlayBtn;
	
	@FindBy(xpath="//*[text()='Incoming message']//following-sibling::*[@class='handCursor']//*[contains(@class,'fa-pause')]")
	WebElement incomingMsgPauseBtn;
	
	@FindBy(xpath="//*[text()='Outgoing message']//following-sibling::*[@class='handCursor']//*[contains(@class,'fa-pause')]")
	WebElement outgoingMsgPauseBtn;
	
	@FindBy(xpath="//*[text()='Outgoing message']//preceding-sibling::*[contains(@class,'checked')]//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'slide-toggle-thumb')]")
	WebElement outgoingMsgEnableToggle;
	
	@FindBy(xpath="//*[text()='Outgoing message']//preceding-sibling::*[contains(@class,'mat-slide-toggle mat-primary')]//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'slide-toggle-thumb')]")
	WebElement outgoingMsgDisableToggle;
	
	@FindBy(xpath="//*[text()='Incoming call']//preceding-sibling::*[contains(@class,'checked')]//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'toggle-thumb')]")
	WebElement incomingCallEnableToggle;
	
	@FindBy(xpath="//*[text()='Incoming call']//preceding-sibling::*[contains(@class,'mat-slide-toggle mat-primary')]//*[contains(@class,'toggle-thumb-container')]//*[contains(@class,'toggle-thumb')]")
	WebElement incomingCallDisableToggle;
	
	@FindBy(xpath="//*[text()='Incoming call']//following-sibling::*[contains(@class,'label')]//*[contains(@role,'listbox')]//*[contains(@class,'select-value')]")
	WebElement incomingCallToneField;
	
	@FindBy(xpath="//*[text()='Incoming call']//following-sibling::*[contains(@class,'label')]//*[contains(@role,'listbox')]//*[contains(@class,'select-arrow-wrapper')]")
	WebElement incomingCallDownArrow;
	
	@FindBy(xpath="//*[text()='Incoming call']//following-sibling::*[@class='handCursor']//*[contains(@class,'fa-play')]")
	WebElement incomingCallPlayBtn;
	
	@FindBy(xpath="//*[text()='Incoming call']//following-sibling::*[@class='handCursor']//*[contains(@class,'fa-play')]")
	WebElement incomingCallPauseBtn;
	
	
	//Links:
	@FindBy(xpath="//*[contains(@class,'users-list')]//*[text()='Notifications']")
	WebElement notifications;
	
	
	//Validations:
	@FindBy(xpath="//*[text()='Enable Notifications']")
	WebElement enableNotificationsTxt;
	
	@FindBy(xpath="//*[text()='Do Not Disturb ']")
	WebElement doNotDistrubText;
	
	@FindBy(xpath="//*[text()='Desktop Sounds']")
	WebElement desktopSoundsTxt;
	
	@FindBy(xpath="//*[text()='Receive desktop notifications for new messages and important activity']")
	WebElement receiveDesktopNotifTxt;
	
	@FindBy(xpath="//*[contains(text(),'Disable notifications')]")
	WebElement disableNotifText;
	
	@FindBy(xpath="//*[text()='Incoming message']")
	WebElement incomingMsgText;
	
	@FindBy(xpath="//*[text()='Outgoing message']")
	WebElement outgoingMsgText;
	
	@FindBy(xpath="//*[text()='Incoming call']")
	WebElement incomingCallText;
	
	
	//Actions:
	
	//Verify the header of the notifications in the middle panel 
	public boolean verifyNotificationsHeader() {
		digitalIdentityPanel.click();
		settings.click();
		return notifications.isDisplayed();
	}
	
	//Verify the URL of the notifications at the browser when the user view in the notifications
	public String verifyNotificationsURL() {
		digitalIdentityPanel.click();
		settings.click();
		return driver.getCurrentUrl();
	}
	
	//Verify the browser title when the user is in settings module
	public String verifyBrowserTitle_Notif() {
		digitalIdentityPanel.click();
		settings.click();
		return driver.getTitle();
	}
	
	//Verify the "Enable Notifications" text is displayed or  not in the middle panel
	public String verifyEnableNotificationsText() {
		digitalIdentityPanel.click();
		settings.click();
		return enableNotificationsTxt.getText();
	}
	
	//Verify the "Do Not Disturb" text is displayed or  not in the middle panel
	public String verifyDoNotDistrubText() {
		digitalIdentityPanel.click();
		settings.click();
		return doNotDistrubText.getText();
	}
	
	//Verify the "Desktop Sounds" text is displayed or  not in the middle panel
	public String verifyDesktopSoundsText() {
		digitalIdentityPanel.click();
		settings.click();
		return desktopSoundsTxt.getText();
	}
	
	//Verify the text "Receive desktop notifications for new messages and important activity" in the enable notifications
	public String verifyReceiveDesktopText() {
		digitalIdentityPanel.click();
		settings.click();
		return receiveDesktopNotifTxt.getText();
	}
	
	/*Verify the toggle of "Receive desktop notifications for new messages
	 * and important activity" is enable or not by default
	 */
	public boolean verifyReceiveDeskopDefaultToggle() {
		digitalIdentityPanel.click();
		settings.click();
		return receiveDesktopNotifEnableToggle.isDisplayed();
	}
	
	//Verify the color of toggle when it is in enable mode in the "Receive desktop notifications for new messages and important activity"
	public String verifyReceiveDesktopToggleColor() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		receiveDesktopNotifEnableToggle.isDisplayed();
		thread();
		String toggleColor = receiveDesktopNotifEnableToggle.getCssValue("background-color");
		String actualColor=Color.fromString(toggleColor).asHex();
		return actualColor;
	}
	
	/*
	 * Verify the click functionality of toggle, when it is in enabled mode of  
	 * "Receive desktop notifications for new messages and important activity".
	 */
	public boolean clickOnEnableToggle_DesktopNotif() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		receiveDesktopNotifEnableToggle.click();
		thread();
		return receiveDesktopNotifDisableToggle.isDisplayed();
	}
	
	/*
	 * Verify the click functionality of toggle, when it is in disabled mode of
	 *   "Receive desktop notifications for new messages and important activity".
	 */
	public boolean clickOnDisableToggle_DesktopNotif() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		receiveDesktopNotifDisableToggle.click();
		thread();
		return receiveDesktopNotifEnableToggle.isDisplayed();
	}
	
	//Verify the Do Not Disturb toggle is in disabled mode or not by default
	public boolean verifyDoNotDisturbDefaultToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return disableNotifDisableToggle.isDisplayed();
	}
	
	//Verify the text "Disable notifications from " in the Do Not Disturb section of notifications
	public String verifyDisableNotifFromTxt() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return disableNotifText.getText();
	}
	
	/*
	 * Verify the gray color text "(UTC-08:00) Pacific Time (US & Canada)" is there or not next to the Do Not Disturb primary text
	 */
	public String verifyDonNotDisturbGrayTxt() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return doNotDistrubText.getText();
	}
	
	//Verify the click functionality of the start time field in the Do Not Disturb section
	public boolean verifyStartTimeFieldClickAction() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		startTime.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the click functionality of the end time field in the Do Not Disturb section
	public boolean verifyEndTimeFieldClickAction() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		endTime.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the click functionality of the down arrow of start time in the Do Not Disturb section
	public boolean verifyStartTimeDownArrowClickAction() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		startTimeDownArrow.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the click functionality of the down arrow of end time in the Do Not Disturb section
	public boolean verifyEndTimeDownArrowClickAction() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		endTimeDownArrow.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the scroll functionality of the drop down list of start time in the Do Not Disturb section
	public String verifyScrollOfStartTimeDropdown(String time) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		startTimeDownArrow.click();
		thread();
		
		List<WebElement>dropdownList = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<dropdownList.size();i++) {
			dropdownList.get(i).getText();
			
			if(dropdownList.get(i).getText().contains(time)) {
				dropdownList.get(i).click();
			}
		}
		String SelectedTime = startTime.getText();
		return SelectedTime;
	}
	
	//Verify the scroll functionality of the drop down list of end time in the Do Not Disturb section
	public String verifyScrollOfEndTimeDropDown(String time) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		endTimeDownArrow.click();
		thread();
		
		List<WebElement>dropdownList = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<dropdownList.size();i++) {
			dropdownList.get(i).getText();
			
			if(dropdownList.get(i).getText().contains(time)) {
				dropdownList.get(i).click();
			}
		}
		String SelectedTime = endTime.getText();
		return SelectedTime;
	}
	
	//Verify the selected time is displaying or not in the start time field by selecting the start time from the drop down list
	public String verifySelectedTimeInStarTimeField(String time) throws Throwable {
		String activeStatus = "";
		digitalIdentityPanel.click();
		settings.click();
		thread();
		startTimeDownArrow.click();
		thread();
		
		List<WebElement>dropdownList = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<dropdownList.size();i++) {
			dropdownList.get(i).getText();
			
			if(dropdownList.get(i).getText().contains(time)) {
				dropdownList.get(i).click();
			}
		}
		startTimeDownArrow.click();
		thread();
		List<WebElement>startTimeDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<startTimeDropdown.size();i++) {
			startTimeDropdown.get(i).getText();
			
			if(startTimeDropdown.get(i).getText().contains(time)) {
				activeStatus = startTimeDropdown.get(i).getAttribute("class");
			}
		}
		
		return activeStatus;
	}
	
	//Verify the selected time is displaying or not in the end time field by selecting the end time from the drop down list
	public String verifySelectedTimeInEndTimeField(String time) throws Throwable {
		String activeStatus = "";
		digitalIdentityPanel.click();
		settings.click();
		thread();
		endTimeDownArrow.click();
		thread();
		
		List<WebElement>dropdownList = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<dropdownList.size();i++) {
			dropdownList.get(i).getText();
			
			if(dropdownList.get(i).getText().contains(time)) {
				dropdownList.get(i).click();
			}
		}
		endTimeDownArrow.click();
		thread();
		List<WebElement>startTimeDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<startTimeDropdown.size();i++) {
			startTimeDropdown.get(i).getText();
			
			if(startTimeDropdown.get(i).getText().contains(time)) {
				activeStatus = startTimeDropdown.get(i).getAttribute("class");
			}
		}
		
		return activeStatus;
	}
	
	//If the user selected one time format as start time, Verify that the selected time is disable or not in the end time drop down list.
	public String verifySelectedStartTimeInEndTimeDropdown(String time) throws Throwable {
		String option="";
		digitalIdentityPanel.click();
		settings.click();
		thread();
		startTimeDownArrow.click();
		thread();
		
		List<WebElement>startTimeDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<startTimeDropdown.size();i++) {
			startTimeDropdown.get(i).getText();
			
			if(startTimeDropdown.get(i).getText().contains(time)) {
				startTimeDropdown.get(i).click();
			}
		}
		
		endTimeDownArrow.click();
		thread();
		List<WebElement>endTimedropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<endTimedropdown.size();i++) {
			endTimedropdown.get(i).getText();
			
			if(endTimedropdown.get(i).getText().contains(time)) {
				option = endTimedropdown.get(i).getAttribute("class");
			}
		}
		return option;
	}
	
	//If the user selected one time format as end time, Verify that the selected time is disable or not in the start time drop down list.
	public String verifySelectedEndTimeInStartTimeDropdown(String time) throws Throwable {
		String option="";
		digitalIdentityPanel.click();
		settings.click();
		thread();
		endTimeDownArrow.click();
		thread();
		
		List<WebElement>startTimeDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<startTimeDropdown.size();i++) {
			startTimeDropdown.get(i).getText();
			
			if(startTimeDropdown.get(i).getText().contains(time)) {
				startTimeDropdown.get(i).click();
			}
		}
		
		startTimeDownArrow.click();
		thread();
		List<WebElement>endTimedropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0;i<endTimedropdown.size();i++) {
			endTimedropdown.get(i).getText();
			
			if(endTimedropdown.get(i).getText().contains(time)) {
				option = endTimedropdown.get(i).getAttribute("class");
			}
		}
		return option;
	}
	
	//Verify the "Incoming message" text in the Desktop Sounds section
	public String verifyIncomingMsgTxt() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return incomingMsgText.getText();
	}
	
	//Verify the "Incoming message" toggle is in enabled mode or not by default in the Desktop Sounds section
	public boolean verifyIncomingMsgDefaultToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return incomingMsgEnableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the "Incoming message" toggle, when it is in enabled mode
	public boolean clickOnIncomingMsgEnableToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingMsgEnableToggle.click();
		thread();
		boolean enableToggle = incomingMsgDisableToggle.isDisplayed();
		
		thread();
		return enableToggle;
	}
	
	//Verify the mouse hover and click functionality of the "Incoming message" toggle, when it is in disabled mode
	public boolean clickOnIncomingMsgDisableToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingMsgDisableToggle.click();
		thread();
		return incomingMsgEnableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the incoming message tones field
	public boolean clickOnIncomingMsgToneField() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingMsgToneField.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the incoming message down arrow button
	public boolean clickOnIncomingMsgDownArrow() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingMsgFieldDownArrow.click();
		thread();
		return dropDown.isDisplayed(); 
	}
	
	//Verify the incoming message tone by selecting the tone from the drop-down list
	public String verifySelectedIncomingMsgTone(String toneName) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingMsgFieldDownArrow.click();
		thread();
		
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(toneName)) {
				tonesDropdown.get(i).click();
			}
		}
		return incomingMsgToneField.getText();
	}
	
	//Verify the click functionality of the incoming message play button after selecting any tone from the drop-down list.
	public boolean verifyIncomingMsgPlayBtnClickAction(String toneName) throws Throwable {
		verifySelectedIncomingMsgTone(toneName);
		thread();
		incomingMsgPlayBtn.click();
		thread();
		return incomingMsgPauseBtn.isDisplayed();
	}
	
	//Verify that the play button is showing or not, after completion of playing the incoming message tone.
	public boolean verifyIncomingMsgPlayBtnAfterTonePlayed(String toneName) throws Throwable {
		verifyIncomingMsgPlayBtnClickAction(toneName);
		thread();
		return incomingMsgPlayBtn.isDisplayed();
	}
	
	//Verify the "Outgoing message" text in the Desktop Sounds section
	public boolean verifyOutgoingMsgText() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return outgoingMsgText.isDisplayed();
	}
	
	//Verify the "Outgoing message" toggle is in enabled mode or not by default in the Desktop Sounds section
	public boolean verifyOutgoingMsgDefaultTogggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return outgoingMsgEnableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the "Outgoing message" toggle, when it is in enabled mode
	public boolean clickOnOutgoingMsgEnableToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgEnableToggle.click();
		thread();
		return outgoingMsgDisableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the "Outgoing message" toggle, when it is in disabled mod
	public boolean clickOnOutgoingMsgDisableToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgDisableToggle.click();
		thread();
		return outgoingMsgEnableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the Outgoing message tones field
	public boolean clickOnOutgoingMsgTonesField() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgToneField.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the Outgoing message down arrow button
	public boolean clickOnOutgoingMsgDownArrow() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgFieldDownArrow.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the Outgoing message tone by selecting the tone from the drop-down list
	public String verifySelectedOutgoingMsgTone(String tone) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgFieldDownArrow.click();
		thread();
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
			}
		}
		
		return outgoingMsgToneField.getText();
	}
	
	//Verify the click functionality of the Outgoing message play button after selecting any tone from the drop-down list.
	public boolean verifyOutgoingMsgPlayBtnClickAction(String tone) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgFieldDownArrow.click();
		thread();
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
			}
		}
		
		outgoingMsgPlayBtn.click();
		return outgoingMsgPauseBtn.isDisplayed();
		
	}
	
	//Verify that the play button is showing or not, after completion of playing Outgoing message tone.
	public boolean verifyOutgoingMsgPlayBtnAfterTonePlayed(String tone) throws InterruptedException {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		outgoingMsgFieldDownArrow.click();
		thread();
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
			}
		}
		
		outgoingMsgPlayBtn.click();
		thread();
		return outgoingMsgPlayBtn.isDisplayed();
	}
	
	//Verify the "Incoming call" text in the Desktop Sounds section
	public boolean verifyIncomingCallText() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return incomingCallText.isDisplayed();
	}
	
	//Verify the "Incoming call" toggle is in enabled mode or not by default in the Desktop Sounds section
	public boolean verifyDefaultIncomingCallToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		return incomingCallEnableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the "Incoming call" toggle, when it is in enabled mode
	public boolean clickOnIncomingCallEnableToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallEnableToggle.click();
		thread();
		return incomingCallDisableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the "Incoming call" toggle, when it is in disabled mode
	public boolean clickOnIncomingCallDisableToggle() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallDisableToggle.click();
		thread();
		return incomingCallEnableToggle.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the Incoming call tones field
	public boolean clickOnIncomingCallTonesField() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallToneField.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the mouse hover and click functionality of the Incoming call down arrow button
	public boolean clickOnIncomingCallDownArrow() throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallDownArrow.click();
		thread();
		return dropDown.isDisplayed();
	}
	
	//Verify the Incoming call tone by selecting the tone from the drop-down list
	public String verifySelectedIncomingCallTone(String tone) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallDownArrow.click();
		thread();
		
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
				thread();
			}
		}
		return incomingCallToneField.getText();	
	}
	
	//Verify the scroll function of the drop-down list of the "Incoming call"
	public String verifyIncomingCallDropdownScroll(String tone) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallDownArrow.click();
		thread();
		
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
				thread();
			}
		}
		return incomingCallToneField.getText();	
	}
	
	//Verify the click functionality of the Incoming call play button after selecting any tone from the drop-down list.
	public boolean verifyIncomingCallPlayBtnClickAction(String tone) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallDownArrow.click();
		thread();
		
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
				thread();
			}
		}
		incomingCallPlayBtn.click();
		thread();
		return incomingCallPauseBtn.isDisplayed();
		
	}
	
	//Verify that the play button is showing or not, after completion of playing Incoming call tone.
	public boolean verifyIncomingCallPlayBtnAfterTonePlayed(String tone) throws Throwable {
		digitalIdentityPanel.click();
		settings.click();
		thread();
		incomingCallDownArrow.click();
		thread();
		
		List<WebElement> tonesDropdown = driver.findElements(By.xpath(xpath_Dropdonw));
		for(int i=0; i<tonesDropdown.size();i++) {
			tonesDropdown.get(i).getText();
			
			if(tonesDropdown.get(i).getText().contains(tone)) {
				tonesDropdown.get(i).click();
				thread();
			}
		}
		incomingCallPlayBtn.click();
		thread();
		return incomingCallPlayBtn.isDisplayed();
		
	}	
	
}
