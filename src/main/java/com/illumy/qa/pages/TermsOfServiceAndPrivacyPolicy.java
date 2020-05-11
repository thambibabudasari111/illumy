/**
 * 
 */
package com.illumy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class TermsOfServiceAndPrivacyPolicy extends TestBase{

	//Initializing the page objects:
	public TermsOfServiceAndPrivacyPolicy() {
		PageFactory.initElements(driver, this);
	}
		
		
	//Page Factory: OR (Object Repository)
	
	@FindBy(xpath="//*[@class='col-md-3 noselect']")
	WebElement digitalIdentityPanel;
	
	@FindBy(xpath="//*[@class='pulldown_nav']//*[text()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//*[text()='Terms Of Service']")
	WebElement termsOfService;
	
	
	
	@FindBy(xpath="//*[contains(@class,'box-header')]")
	WebElement termsOfServiceHeader;
	
	@FindBy(xpath="//*[text()='helpdesk@illumy.com']")
	WebElement helpDeskLink;
	
	@FindBy(xpath="//*[text()='Privacy Policy']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//*[contains(@class,'box-header')]")
	WebElement privacyPolicyHeader;
	
	@FindBy(xpath="//*[text()='helpdesk@illumy.com.']")
	WebElement helpDesk;
	
	
	
	
	//Actions:
	
	//Verify the "Terms Of Service" option in the settings module
	public boolean verifyTermsOfServiceLink() {
		digitalIdentityPanel.click();
		settings.click();
		return termsOfService.isDisplayed();
	}
	
	//Verify the header section of the "Terms Of Service" in the middle panel
	public String verifyTermsOfServiceHeader() {
		digitalIdentityPanel.click();
		settings.click();
		termsOfService.click();
		return termsOfServiceHeader.getText();
	}
	
	//Verify the scroll functionality of the "Terms Of Service" in the middle panel to view the content 
	public boolean verifyScroll_TermsOfService() {
		digitalIdentityPanel.click();
		settings.click();
		termsOfService.click();
		TestUtil.scrollIntoView(helpDeskLink, driver);
		return true;
	}
	
	//Verify the "Privacy Policy" option in the settings module
	public boolean verifyPrivacyPolicyLink() {
		digitalIdentityPanel.click();
		settings.click();
		return privacyPolicy.isDisplayed();
	}
	
	//Verify the header section of the "Privacy Policy" in the middle panel
	public String verifyPrivacyPolicyHeader() {
		digitalIdentityPanel.click();
		settings.click();
		privacyPolicy.click();
		return privacyPolicyHeader.getText();
	}
	
	//Verify the scroll functionality of the "Privacy Policy" in the middle panel to view the content 
	public boolean verifyScroll_PrivacyPolicy() {
		digitalIdentityPanel.click();
		settings.click();
		privacyPolicy.click();
		
		TestUtil.scrollIntoView(helpDesk, driver);
		return true;
	}
	
	
	
		
}
