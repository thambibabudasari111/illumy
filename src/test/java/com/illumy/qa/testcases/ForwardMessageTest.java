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
import com.illumy.qa.pages.ForwardMessage;
import com.illumy.qa.pages.HomePage;

import com.illumy.qa.pages.SigninPage;

import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class ForwardMessageTest extends TestBase{

	public ForwardMessage fowardMsg;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName		= "ForwardMessage";
	String userToSelect		= "userToSelect";
	String message			= "message";
	String keyToField		= "keyToField";
	String searchEmojiKeys	= "searchEmojiKeys";
	String filePath			= "filePath";
	String fileName			= "fileName";
	String msgBody			= "msgBody";
	String groupName		= "groupName";
	
	String userToSelect_Row2		= reader.getCellData(sheetName, userToSelect, 2);
	String userToSelect_Row3		= reader.getCellData(sheetName, userToSelect, 3);
	String userToSelect_Row4		= reader.getCellData(sheetName, userToSelect, 4);
	String message_Row2				= reader.getCellData(sheetName, message, 2);
	String keyToField_Row2			= reader.getCellData(sheetName, keyToField, 2);
	String keyToField_Row3			= reader.getCellData(sheetName, keyToField, 3);
	String searchEmojiKeys_Row2		= new String (reader.getCellData(sheetName, searchEmojiKeys, 2));
	String filePath_Row2			= new String (reader.getCellData(sheetName, filePath, 2));
	String fileName_Row2			= new String (reader.getCellData(sheetName, fileName, 2));
	String fileName_Row3			= new String (reader.getCellData(sheetName, fileName, 3));
	String fileName_Row4			= new String (reader.getCellData(sheetName, fileName, 4));
	String fileName_Row5			= new String (reader.getCellData(sheetName, fileName, 5));
	String msgBody_Row2				= new String (reader.getCellData(sheetName, msgBody, 2));
	String groupName_Row2			= new String (reader.getCellData(sheetName, groupName, 2));
	
	
	public ForwardMessageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		fowardMsg = new ForwardMessage();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1,enabled=true)
	public void verifyForwardClickAction() throws Exception, Throwable {
		Assert.assertTrue(fowardMsg.verifyForwardClickAction(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=2,enabled=true)
	public void verifyForwardDefaultSubject() {
		String defaultSubject;
		try {
			defaultSubject = fowardMsg.verifyForwardDefaultSubject(userToSelect_Row2,message_Row2);
			Assert.assertEquals(defaultSubject, "illumy - Forward Message");
			System.out.println(defaultSubject);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3,enabled=true)
	public void verifyForwardPopupTitle() throws Throwable{
		Assert.assertTrue(fowardMsg.verifyForwardPopupTitle(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=4,enabled=true)
	public void verifyForwardPopup_CrossMark() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyForwardPopup_CrossMark(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=5,enabled=true)
	public void verifyFwdPopup_Icons() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyFwdPopup_Icons(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=6,enabled=true)
	public void verifyFwdMsg_FwdPopup() throws Throwable {
		String actualAttachedMsg=fowardMsg.verifyFwdMsg_FwdPopup(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualAttachedMsg.contains(message_Row2));
		System.out.println(actualAttachedMsg);
	}
	
	@Test(priority=7,enabled=true)
	public void verifyShowMsg_FwdPopup() throws Throwable {
		String actualAttachedMsg=fowardMsg.verifyShowMsg_FwdPopup(userToSelect_Row2, message_Row2);
		Assert.assertTrue(actualAttachedMsg.contains(message_Row2));
		System.out.println(actualAttachedMsg);
	}
	
	@Test(priority=8,enabled=true)
	public void verifyHideMsg_ReplyAllPopup() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyHideMsg_FwdPopup(userToSelect_Row2, message_Row2));
	}
	
	/*************************************************************************************
	 *		 @mention functionality in Forward message pop up
	 ***************************************************************************************/
	
	@Test(priority=9,enabled=true)
	public void verifyAtmentionClickAction_FwdPopup() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyAtmentionClickAction_FwdPopup(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=10,enabled=true)
	public void verifyOnnetUsers_AtmentionPopup_FwdMsg() throws Throwable {
		String atmentionPopupUsers=fowardMsg.verifyOnnetUsers_AtmentionPopup_FwdMsg(userToSelect_Row2, message_Row2,userToSelect_Row3);
		Assert.assertTrue(atmentionPopupUsers.contains(userToSelect_Row3));
		System.out.println(atmentionPopupUsers);
	}
	
	@Test(priority=11,enabled=true)
	public void verifySelectedUser_AtmentionPopupFwdMsg() throws Throwable {
		String atmentionPopusUsers = fowardMsg.verifySelectedUser_AtmentionPopupFwdMsg(userToSelect_Row2, message_Row2, keyToField_Row2, userToSelect_Row4);
		Assert.assertTrue(atmentionPopusUsers.contains(userToSelect_Row4));
		System.out.println(atmentionPopusUsers);
	}
	
	@Test(priority=12,enabled=true)
	public void atmentionPopup_Shortcut_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.atmentionPopup_Shortcut_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=13,enabled=true)
	public void atmentionPopup_Space_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.atmentionPopup_Space_FwdMsg(userToSelect_Row2, message_Row2));
	}

	@Test(priority=14,enabled=true)
	public void atmentionPopup_Backspace_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.atmentionPopup_Backspace_FwdMsg(userToSelect_Row2, message_Row2));
	}

	@Test(priority=15,enabled=true)
	public void atmentionUserInFwdMsgBody() throws Throwable {
		String atmentionUser_MsgBody=fowardMsg.atmentionUserInFwdMsgBody(userToSelect_Row2, message_Row2,keyToField_Row2, userToSelect_Row4);
		Assert.assertTrue(atmentionUser_MsgBody.contains("@"+userToSelect_Row4));
		System.out.println(atmentionUser_MsgBody);
	}

	@Test(priority=16,enabled=true)
	public void atmentionUser_MsgThread_FwdMsg() throws Throwable {
		String atmentionUser_MsgBody=fowardMsg.atmentionUser_MsgThread_FwdMsg(userToSelect_Row2, message_Row2,keyToField_Row2, userToSelect_Row4);
		Assert.assertTrue(atmentionUser_MsgBody.contains("@"+userToSelect_Row4));
		System.out.println(atmentionUser_MsgBody);
	}

	@Test(priority=17,enabled=true)
	public void verifyAtmentionPopupByPressEsc() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyAtmentionPopupByPressEsc(userToSelect_Row2, message_Row2));
	}

	@Test(priority=18,enabled=true)
	public void atmentionPopupOnlineUserStatus_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.atmentionPopupOnlineUserStatus_FwdMsg(userToSelect_Row2, message_Row2,userToSelect_Row3));
	}

	@Test(priority=19,enabled=true)
	public void verifyAtmentionPopup_ClicXsym_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyAtmentionPopup_ClicXsym_FwdMsg(userToSelect_Row2, message_Row2));
	}

	@Test(priority=20,enabled=true)
	public void verifyMorethan1User_AtmentionPopup_FwdMsg() throws Throwable {
		String actualUsers=fowardMsg.verifyMorethan1User_AtmentionPopup_FwdMsg(userToSelect_Row2, message_Row2, keyToField_Row2,userToSelect_Row4,userToSelect_Row3);
		String expUsers="@"+userToSelect_Row3+" "+"@"+userToSelect_Row4;
		Assert.assertTrue(actualUsers.contains(expUsers));
		System.out.println(actualUsers);
	}

	@Test(priority=21,enabled=true)
	public void enterAtmentionMultipleTimes_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.enterAtmentionMultipleTimes_FwdMsg(userToSelect_Row2, message_Row2));
	}

	@Test(priority=22,enabled=true)
	public void clicOnAtmentionMultipleTimes_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.clicOnAtmentionMultipleTimes_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	/*************************************************************************************
	 * 						Emoji functionality in forward message pop up
	 * @throws Throwable 
	 *
	 ***************************************************************************************/
	@Test(priority=23,enabled=true)
	public void clickOnEmoji_FwdMsgPopup() throws Throwable{
		Assert.assertTrue(fowardMsg.clickOnEmoji_FwdMsgPopup(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=24,enabled=true)
	public void verifyEmojiPopupScroll_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyEmojiPopupScroll_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=25,enabled=true)
	public void verifyEmojiPopupClicXSym_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyEmojiPopupClicXSym_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=26,enabled=true)
	public void verifyEmojiPopupPressEsckey() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyEmojiPopupPressEsckey(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=27,enabled=true)
	public void verifySelectedEmoji_FwdMsgBody() throws Throwable {
		Assert.assertTrue(fowardMsg.verifySelectedEmoji_FwdMsgBody(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=28,enabled=true)
	public void verifyEmojiInMsgThread_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyEmojiInMsgThread_FwdMsg(userToSelect_Row2, message_Row2,keyToField_Row2,userToSelect_Row4 ));
	}
	
	@Test(priority=29,enabled=true)
	public void verifyFwdMsgBody_MultipleEmojis() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyFwdMsgBody_MultipleEmojis(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=30,enabled=true)
	public void verifySearchFieldInEmojiPopup_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifySearchFieldInEmojiPopup_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=31,enabled=true)
	public void verifyEmojiPopupSearch_ValidKeys_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyEmojiPopupSearch_ValidKeys_FwdMsg(userToSelect_Row2, message_Row2,searchEmojiKeys_Row2));
	}
	
	@Test(priority=32,enabled=true)
	public void verifyEmojiPopupSearch_InalidKeys_FwdMsg() throws Throwable {
		String noEmojisFound=fowardMsg.verifyEmojiPopupSearch_InalidKeys_FwdMsg(userToSelect_Row2, message_Row2,"sdfsfddsf");
		Assert.assertEquals(noEmojisFound, "No Emoji Found!");
		System.out.println(noEmojisFound);
	}
	
	@Test(priority=33,enabled=true)
	public void clickOnXsymEmojiSearchField_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.clickOnXsymEmojiSearchField_FwdMsg(userToSelect_Row2, message_Row2,searchEmojiKeys_Row2));
	}
	
	/*************************************************************************************
					GIF functionality in forward message pop-up 
	 * @throws Throwable 
	 ***************************************************************************************/
	@Test(priority=34,enabled=true)
	public void verifyGiphyClickAction_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyGiphyClickAction_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=35,enabled=true)
	public void verifyGiphyPopupByClickOnXsym_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyGiphyPopupByClickOnXsym_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=36,enabled=true)
	public void verifyGiphyPopupTitle_FwdMsg() throws Throwable {
		String giphyDotComTitle=fowardMsg.verifyGiphyPopupTitle_FwdMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(giphyDotComTitle, "GIPHY | Search All the GIFs & Make Your Own Animated GIF");
		System.out.println(giphyDotComTitle);
	}
	
	@Test(priority=37,enabled=true)
	public void verifySearchFieldInGiphyPopup_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifySearchFieldInGiphyPopup_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=38,enabled=true)
	public void verifySearchBtnInGiphyPopup_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifySearchBtnInGiphyPopup_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=39,enabled=true)
	public void verifyGiphySearchByEnterInvalidKeys_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyGiphySearchByEnterInvalidKeys_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=40,enabled=true)
	public void verifyGiphyPopupSearchXsym_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyGiphyPopupSearchXsym_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=41,enabled=true)
	public void verifyGiphyInMsgThread_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyGiphyInMsgThread_FwdMsg(userToSelect_Row2, message_Row2,keyToField_Row2));
	}
	
	@Test(priority=42,enabled=true)
	public void verifyStickerIconInGiphyPopup_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyStickerIconInGiphyPopup_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	/**********************************************************************************************************
	 * 								Attachment functionality in forward message pop up
	 * @throws Throwable 
	 **********************************************************************************************************/
	@Test(priority=43,enabled=true)
	public void clickOnAttachmentIcon_FwdMsg() throws Throwable {
		Assert.assertTrue(fowardMsg.clickOnAttachmentIcon_FwdMsg(userToSelect_Row2, message_Row2));
	}
	
	@Test(priority=44,enabled=true)
	public void verifyMyComputerTooltip_FwdMsg() throws Throwable {
		String mycomputer="My Computer";
		String actualTooltip=fowardMsg.verifyMyComputerTooltip_FwdMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, mycomputer);
		System.out.println(actualTooltip);
	}
	
	@Test(priority=45,enabled=true)
	public void verifyAttachmentInMsgThread_MyComp_FwdMsg() throws Throwable {
		String actualFileName=fowardMsg.verifyAttachmentInMsgThread_MyComp_FwdMsg(userToSelect_Row2, message_Row2,filePath_Row2,fileName_Row2,keyToField_Row2);
		Assert.assertTrue(actualFileName.contains(fileName_Row2));
		System.out.println(actualFileName);
	}
	
	@Test(priority=46,enabled=true)
	public void verifyOneDriveTooltip_FwdMsg() throws Throwable {
		String oneDrive="One Drive";
		String actualTooltip=fowardMsg.verifyOneDriveTooltip_FwdMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, oneDrive);
		System.out.println(actualTooltip);
	}
	
	@Test(priority=47,enabled=true)
	public void verifyOneDriveAttachmentInMsgThread_FwdMsg() throws Throwable {
		String attachment_MsgThread=fowardMsg.verifyOneDriveAttachmentInMsgThread_FwdMsg(userToSelect_Row2, message_Row2,
				prop.getProperty("email"),prop.getProperty("password"),fileName_Row3,keyToField_Row2);
		Assert.assertTrue(attachment_MsgThread.contains(fileName_Row3));
		System.out.println(attachment_MsgThread);
	}
	
	@Test(priority=48,enabled=true)
	public void verifyGoogleDriveTooltip_FwdMsg() throws Throwable {
		String googleDrive="Google Drive";
		String actualTooltip=fowardMsg.verifyGoogleDriveTooltip_FwdMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, googleDrive);
		System.out.println(actualTooltip);
	}
	
	@Test(priority=49,enabled=true)
	public void verifyDropboxTooltip_FwdMsg() throws Throwable {
		String dropbox="Dropbox";
		String actualTooltip=fowardMsg.verifyDropboxTooltip_FwdMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, dropbox);
		System.out.println(actualTooltip);
	}
	
	@Test(priority=50,enabled=true)
	public void verifyDropboxAttachmentInMsgThread_FwdMsg() throws Throwable {
		String attachment_MsgThread=fowardMsg.verifyDropboxAttachmentInMsgThread_FwdMsg(userToSelect_Row2, message_Row2,
				prop.getProperty("email"),prop.getProperty("password"),fileName_Row4,keyToField_Row2);
		Assert.assertTrue(attachment_MsgThread.contains(fileName_Row4));
		System.out.println(attachment_MsgThread);
	}
	
	@Test(priority=51,enabled=true)
	public void verifyBoxTooltip_FwdMsg() throws Throwable {
		String box="Box";
		String actualTooltip=fowardMsg.verifyBoxTooltip_FwdMsg(userToSelect_Row2, message_Row2);
		Assert.assertEquals(actualTooltip, box);
		System.out.println(actualTooltip);
	}
	
	@Test(priority=52,enabled=true)
	public void verifyBoxAttachmentInMsgThread_FwdMsg() throws Throwable {
		String attachment_MsgThread=fowardMsg.verifyBoxAttachmentInMsgThread_FwdMsg(userToSelect_Row2, message_Row2,
				prop.getProperty("email"),prop.getProperty("password"),fileName_Row5,keyToField_Row2);
		Assert.assertTrue(attachment_MsgThread.contains(fileName_Row5));
		System.out.println(attachment_MsgThread);
	}
	
	/**************************************************************************************************
	 *   			To and Cc functionality of forward message pop up 
	 ***************************************************************************************************/
	
	@Test(priority=53,enabled=true)
	public void fwdMsgByAddingToAndCcUsers() throws Throwable {
		String actualToAndCcUsers=fowardMsg.fwdMsgByAddingToAndCcUsers(userToSelect_Row2, message_Row2, keyToField_Row2, userToSelect_Row4, msgBody_Row2);
		String expToAndCcUsers	="to"+userToSelect_Row2+"\n"+"cc"+userToSelect_Row4;
		Assert.assertTrue(actualToAndCcUsers.contains(expToAndCcUsers));
		System.out.println(actualToAndCcUsers);
	}
	
	
	@Test(priority=54,enabled=true)
	public void verifyFwdMsgInMsgThread() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyFwdMsgInMsgThread(userToSelect_Row2, message_Row2, keyToField_Row2, msgBody_Row2));
	}
	
	@Test(priority=55,enabled=true)
	public void verifyFwdMsgArrowSymInMsgThread() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyFwdMsgArrowSymInMsgThread(userToSelect_Row2, message_Row2, keyToField_Row2, msgBody_Row2));
	}
	
	@Test(priority=56,enabled=true)
	public void verifyFwdArrowClickAction() throws Throwable {
		Assert.assertTrue(fowardMsg.verifyFwdArrowClickAction(userToSelect_Row2, message_Row2, keyToField_Row2, msgBody_Row2));
	}
	
	@Test(priority=57,enabled=true)
	public void fwdMsgToGroup() throws Throwable {
		String actualFwdMsg=fowardMsg.fwdMsgToGroup(userToSelect_Row2, message_Row2, keyToField_Row3, groupName_Row2, msgBody_Row2);
		Assert.assertTrue(actualFwdMsg.contains(message_Row2));
		System.out.println(actualFwdMsg);
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
