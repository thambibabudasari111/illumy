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
import com.illumy.qa.pages.MarkReadUnread;

import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class MarkReadUnreadTest extends TestBase{

	public MarkReadUnread markReadUnread;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName="MessageOptions";
	String userToSelect="userToSelect";
	String message="message";
	
	String userToSelect_Row2=reader.getCellData(sheetName, userToSelect, 2);
	String message_Row2=reader.getCellData(sheetName, message, 2);
	String userToSelect_Row3=reader.getCellData(sheetName, userToSelect, 3);
	
	
	
	public MarkReadUnreadTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		markReadUnread = new MarkReadUnread();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	// Verify the "envelope" (read/unread messages) symbol mouse hover action in the message options of messages in the message thread
	@Test(priority = 1, enabled = true)
	public void verifyMarkUnreadBtnMousehover() throws Throwable {
		String actualTooltip=markReadUnread.verifyMarkUnreadBtnMousehover(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, "Mark Unread");
		System.out.println(actualTooltip);
	}

	// Verify that if we Click on the mark unread, A vertical purple bar will appear on the left side of the message.
	@Test(priority = 2, enabled = true)
	public void verifyMarkUnreadBtnClickAction() throws Throwable {
		Assert.assertTrue(markReadUnread.verifyMarkUnreadBtnClickAction(userToSelect_Row2, message_Row2));
	}

	// Verify that if we click on the mark unread, The thread count will display on the conversation list user name.
	@Test(priority = 3, enabled = true)
	public void verifyUnreadCountClickMarkUnreadBtn() throws Throwable {
		String unreadCount=markReadUnread.verifyUnreadCountClickMarkUnreadBtn(userToSelect_Row2, message_Row2);
		Assert.assertEquals(unreadCount, "1");
		System.out.println(unreadCount);
	}

	// Verify that if we mouse hover mark unread after clicking it, The icon will change to mark read status and display the tool tip as mark read
	@Test(priority = 4, enabled = true)
	public void verifyMarkReadTooltip() throws Throwable {
		String markReadTooltip=markReadUnread.verifyMarkReadTooltip(userToSelect_Row2, message_Row2);
		Assert.assertEquals(markReadTooltip, "Mark Read");
		System.out.println(markReadTooltip);
	}

	// Verify that if we click on the mark read icon then the purple bar will disappears.
	@Test(priority = 5, enabled = true)
	public void verifyMarkReadClickAction() throws Throwable {
		String markUnreadTooltip=markReadUnread.verifyMarkReadClickAction(userToSelect_Row2, message_Row2);
		Assert.assertEquals(markUnreadTooltip, "Mark Unread");
		System.out.println(markUnreadTooltip);
	}

	// Verify that the purple bars will disappear if we move the thread page up and again viewing the purple bar
	@Test(priority = 6, enabled = true)
	public void verifyMarkUnreadMsg_PageUpAndDown() throws Throwable {
		markReadUnread.verifyMarkUnreadMsg_PageUpAndDown(userToSelect_Row2, message_Row2);
	}

	// Verify that the purple bar will display for four seconds and then disappear if it comes in to view.
	@Test(priority = 7, enabled = true)
	public void verifyMarkUnreadMsg_ViewMessage() throws Throwable {
		Assert.assertTrue(markReadUnread.verifyMarkUnreadMsg_ViewMessage(userToSelect_Row2, message_Row2));
	}

	// Verify that marking unread and moving into another thread and viewing the thread will disappears the purple bar in four seconds.
	@Test(priority = 8, enabled = true)
	public void verifyMarkUnreadMsg_MoveToAnotherThread() throws Throwable {
		Assert.assertTrue(markReadUnread.verifyMarkUnreadMsg_MoveToAnotherThread(userToSelect_Row2, message_Row2, userToSelect_Row3));
	}

	// verify that if the purple bar disappears the mark read will again turns into mark unread.
	@Test(priority = 9, enabled = true)
	public void verifyMarkUnread_ClickMarkRead() throws Throwable {
		String markUnreadTooltip=markReadUnread.verifyMarkUnread_ClickMarkRead(userToSelect_Row2, message_Row2);
		Assert.assertEquals(markUnreadTooltip, "Mark Unread");
		System.out.println(markUnreadTooltip);
	}

	// Verify that if the purple bar disappears the unread count on the conversation list also gets vanished.
	@Test(priority = 10, enabled = true)
	public void verifyUnreadCount_ClickMarkRead() throws Throwable {
		Assert.assertTrue(markReadUnread.verifyUnreadCount_ClickMarkRead(userToSelect_Row2, message_Row2));
	}
	
	
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		driver.quit();
	}

	@AfterTest
	public void endTest() {
		endReport();
	}

}
