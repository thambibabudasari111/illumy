/**
 * 
 */
package com.illumy.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.illumy.qa.base.TestBase;

import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.pages.TermsOfServiceAndPrivacyPolicy;

/**
 * @author thambibabu.dasari
 *
 */
public class TermsOfServiceAndPrivacyPolicyTest extends TestBase{

	public  SigninPage signinPage;
	public  HomePage homePage;
	public  TermsOfServiceAndPrivacyPolicy termsAndPolicy;
	
	
	
	public TermsOfServiceAndPrivacyPolicyTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		termsAndPolicy=new TermsOfServiceAndPrivacyPolicy();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1,enabled=true)
	public void verifyTermsOfServiceLink() {
		Assert.assertTrue(termsAndPolicy.verifyTermsOfServiceLink());
	}
	
	@Test(priority=2,enabled=true)
	public void verifyTermsOfServiceHeader() {
		String actualHeader = termsAndPolicy.verifyTermsOfServiceHeader();
		Assert.assertEquals(actualHeader, "Terms Of Service");
		System.out.println(actualHeader);
	}
	
	@Test(priority=3,enabled=true)
	public void verifyScroll_TermsOfService() {
		Assert.assertTrue(termsAndPolicy.verifyScroll_TermsOfService());
	}
	
	@Test(priority=4,enabled=true)
	public void verifyPrivacyPolicyLink() {
		Assert.assertTrue(termsAndPolicy.verifyPrivacyPolicyLink());
	}
	
	@Test(priority=5,enabled=true)
	public void verifyPrivacyPolicyHeader() {
		String actualHeader = termsAndPolicy.verifyPrivacyPolicyHeader();
		Assert.assertEquals(actualHeader, "Privacy Policy");
		System.out.println(actualHeader);
	}
	
	@Test(priority=6,enabled=true)
	public void verifyScroll_PrivacyPolicy() {
		Assert.assertTrue(termsAndPolicy.verifyScroll_PrivacyPolicy());
	}
	
	
	
	
	@AfterMethod
	public void getStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		driver.quit();
		
	}

	@AfterTest
	public void endTest() {
		endReport();
	}
}
