/**
 * 
 */
package com.illumy.qa.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;


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
 *In this class, written the scripts related to the files section in the 3rd panel
 *
 *1. Verify the file in 3rd panel
 *2. Files options
 *3. Download the file
 *3. Share the file
 *3. Goto the file
 *4. Get external link
 *5. Delete the file
 */
public class Files extends TestBase{
	
	
	
	String xpath_ConversationList		= "//span[@class='media-body users-list-name no-margin ng-star-inserted']";
	String xpath_filesList				= "//*[contains(@id,'file_options')]//*[@role='img']";
	String xpath_ThreadMsgs				= "//span[@class='white-space-pre-wrap message__thread ng-star-inserted']";
	String xpath_ToFieldAutoSugg		= "//div[@role='listbox']//mat-option[@role='option']//span[@class='mat-option-text']";
	String xpath_FileOptions			= "//*[contains(@id,'file_options')]";
	
	//Page Factory : OR
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Files']")
	WebElement files;
	
	@FindBy(xpath="//*[@class='mat-content']//*[text()='Flags']")
	WebElement flags;
	
	@FindBy(xpath="//*[@role='button']//*[@style='transform: rotate(0deg);']//preceding-sibling::*//*[text()='Files']")
	WebElement files_0deg;
	
	@FindBy(xpath="//*[@role='button']//*[@style='transform: rotate(180deg);']//preceding-sibling::*//*[text()='Files']")
	WebElement files_180deg;
	
	@FindBy(xpath="//*[text()='No files to see here right now!']")
	WebElement noFilesText;
	
	@FindBy(xpath="//*[@id='click-spanish']//*[contains(@class,'caret-right')]")
	WebElement hideWidgets; 
	
	@FindBy(xpath="//*[@id='click-spanish']//*[contains(@class,'caret-left')]")
	WebElement showWidgets; 
	
	@FindBy(xpath="//*[contains(@class,'mat-elevation-z0 files_panel')]//*[contains(@id,'cdk-accordion')]")
	WebElement filesPanelBody;
	
	@FindBy(xpath="//*[contains(@id,'file_options')]")
	WebElement filesList;
	
	@FindBy(xpath="//*[contains(@id,'file_options')]//*[@role='img']")
	WebElement threeverticalDots;
	
	@FindBy(xpath="//*[contains(@class,'ng-star-inserted')]//*[text()='Files']")
	WebElement ariaExpandedFalse;
	
	@FindBy(xpath="//*[contains(@class,'mat-expanded')]//*[text()='Files']")
	WebElement ariaExpandedTrue;
	
	@FindBy(xpath="//*[@class='mat-menu-content']//*[text()='Download']")
	WebElement download;
	
	@FindBy(xpath="//*[@class='mat-menu-content']//*[text()='Go To File']")
	WebElement goToFile;

	@FindBy(xpath="//*[@class='mat-menu-content']//*[text()='Share']")
	WebElement share;
	
	@FindBy(xpath="//*[@class='mat-menu-content']//*[text()='Get External Link']")
	WebElement getExternalLink;
	
	@FindBy(xpath="//*[@class='mat-menu-content']//*[text()='Delete']")
	WebElement delete;
	
	@FindBy(xpath="//*[text()='Share File ']")
	WebElement shareFilePopup;
	
	@FindBy(xpath="//*[text()='External Link ']")
	WebElement externalLinkPopup;
	
	@FindBy(xpath="//*[text()=' Delete File ']")
	WebElement deleteFilePopup;
	
	@FindBy(xpath="//*[@class='form_div ng-untouched ng-pristine ng-valid']")
	WebElement messageInputField;
	
	@FindBy(xpath="//*[@class='text-center main_menu_bot_bor']//*[@role='button']")
	WebElement spriteMenu;
	
	@FindBy(xpath="//*[@id='share_file_to']")
	WebElement toField;
	
	@FindBy(xpath="//*[text()='Send ']")
	WebElement sendBtn;
	
	//Initializing the page objects:
		public Files() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions:
		
		//Verify the files section by clicking on the "Hide Widgets" symbol in third panel
		public boolean verifyFilesSection_HideWidgets() throws Throwable {
			hideWidgets.isDisplayed();
			hideWidgets.click();
			thread();
			if(!files.isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}
		
		//Verify the files section by clicking on the "Show Widgets" symbol in third panel
		public boolean verifyFilesSection_ShowWidgets() throws Throwable {
			showWidgets.isDisplayed();	
			showWidgets.click();
			thread();
			
			if(files.isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}
		
		
		//Verifying the files section in message module by clicking on expand symbol
		public String verifyFilesSection_MsgModule() throws Throwable {
			String noFiles="";
			flags.click();
			thread();
			files.click();
			thread();
			noFiles=noFilesText.getText();
			if(!noFilesText.isDisplayed()) {
				flags.click();
				thread();
				files.click();
				noFiles=noFilesText.getText();
			}
			
			return noFiles;
		}
		
		//Checking the files section if there are no files available 
		public String verifyFilesSection_NoFiles(String userToSelect) throws Throwable {
			TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
			String noFiles="";
			flags.click();
			thread();
			files.click();
			thread();
			noFiles=noFilesText.getText();
			if(!noFilesText.isDisplayed()) {
				flags.click();
				thread();
				files.click();
				noFiles=noFilesText.getText();
			}
			
			return noFiles;
		}
		
		//Verify the file options by clicking on vertical ellipsis of attachments sent by the logged in user 
		public String[] verifyFileOptions_LoggedinUser(String userToSelect,String fileName) throws Throwable {
			String[] options = { };
			String fileId="";
			TestUtil.selectElementFromList(xpath_ConversationList, userToSelect);
			thread();
			thread();
			flags.click();
			thread();
			files.click();
			List<WebElement>file=driver.findElements(By.xpath(xpath_FileOptions));
			for(int i=0;i<file.size();i++) {
				file.get(i).getText();
					
					if(file.get(i).getText().contains(fileName)) {
							
						file.get(i).click();
						thread();
						fileId=file.get(i).getAttribute("id");
						thread();
						thread();
							
						WebElement threeDots=driver.findElement(By.xpath("//*[contains(@id,'"+fileId+"')]"+"//*[@class='text-right files_width_calc_do']//*[@role='img']")); // dynamic id 
						thread();
						Actions action = new Actions(driver);
						action.moveToElement(threeDots).click().build().perform();
					}	
				}
			
				options= new String[] {
					download.getText(),
					goToFile.getText(),
					share.getText(),
					getExternalLink.getText(),
					delete.getText()
			};
			thread();
			
			System.out.println("File Id : "+fileId);
			return options;
		}
		
		//Verify click functionality of the "Download" option of an attachment in the file options
		public boolean verifyDownloadOption(String userToSelect,String fileName,String location) throws Throwable {
			verifyFileOptions_LoggedinUser(userToSelect,fileName);
			
			download.click();
			thread();
			thread();
			
			File fileLocation=new File(location);
			File[] totalFiles=fileLocation.listFiles();
			thread();
			for(File file: totalFiles) {
				if(file.getName().contains(fileName)) {
					System.out.println(file.getName());
					System.out.println("File Downloaded");
					file.delete();
					break;
				}
				
			}
			return true;
		}
		
		
		//Verify click functionality of the "Go To File" option of an attachment in the file options
		public void verifyGoToFileOption(String userToSelect,String fileName) throws Throwable {
			verifyFileOptions_LoggedinUser(userToSelect,fileName);
			goToFile.click();
			
			String actualColor="";
			List<WebElement>conversationList=driver.findElements(By.xpath(xpath_ThreadMsgs));
			for(int i=0;i<conversationList.size();i++) {
				conversationList.get(i).getText();
				if(conversationList.get(i).getText().contains(userToSelect)) {
					conversationList.get(i).click();
					String userColor=conversationList.get(i).getCssValue("background-color");
					actualColor=Color.fromString(userColor).asHex();
					System.out.println(actualColor);
				}
			}
		}
		
		//Verify click functionality of the "Share" option of an attachment in the file options
		public boolean verifyShareOption(String userToSelect,String fileName) throws Throwable {
			verifyFileOptions_LoggedinUser(userToSelect,fileName);
			share.click();
			thread();
			
			return shareFilePopup.isDisplayed();
		}
		
		//Verify click functionality of the "Get External Link" option of an attachment in the file options
		public boolean verifyGetExternalLinkOption(String userToSelect,String fileName) throws Throwable {
			verifyFileOptions_LoggedinUser(userToSelect,fileName);
			getExternalLink.click();
			thread();
			
			return externalLinkPopup.isDisplayed();
		}
		
		//Verify the click functionality of the "Delete" option of an attachment in the file options
		public boolean verifyDeleteOption(String userToSelect,String fileName) throws Throwable {
			verifyFileOptions_LoggedinUser(userToSelect,fileName);
			thread();
			delete.click();
			thread();
			
			return deleteFilePopup.isDisplayed();
		}
		
		//Verify the share pop up "Send" button  functionality to share an attachment
		public void verifyShareAttachment_SharePopup(String userToSelect,String fileName,String keysToSend,String selectUerFromAutoSugg) throws Throwable {
			verifyShareOption(userToSelect,fileName);
			toField.sendKeys(keysToSend);
			Thread.sleep(3000);
			TestUtil.selectElementFromList(xpath_ToFieldAutoSugg,selectUerFromAutoSugg);
			thread();
			sendBtn.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
