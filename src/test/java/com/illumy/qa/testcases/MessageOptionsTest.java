/**
 * 
 */
package com.illumy.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.MessageOptions;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;
import com.illumy.qa.util.Xls_Reader;

/**
 * @author thambibabu.dasari
 *
 */
public class MessageOptionsTest extends TestBase{
	
	
	public MessageOptions msgOptions;
	public SigninPage signinPage;
	public HomePage homePage;
	public TestUtil testUtil;
	
	String sheetName="MessageOptions";
	String userToSelect="userToSelect";
	String message="message";
	String oppositeUser="oppositeUser";
	String ccKeys="ccKeys";
	String ccUsers="CcUsers";
	String toKeys="toKeys";
	String toUsers="toUsers";
	
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	public MessageOptionsTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage = new SigninPage();
		homePage = signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		msgOptions = new MessageOptions();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	/*verify that when we mouse hover on any message in the thread will show the message 
	 * options on right side of the message highlighted 
	 */
	@Test(priority=1,enabled=true)
	public void verifyMsgOptionsTest() throws Throwable {
		Assert.assertTrue(msgOptions.verifyMsgOptions(reader.getCellData(sheetName, userToSelect, 2), reader.getCellData(sheetName, message, 2)));
	}
	

	/*Verify that by clicking on the three vertical lines (More Options) in the message options 
	 * for a sent message will display Reply, forward, hide, Edit and delete options.*/
	@Test(priority=2,enabled=true)
	public void verifySentMsgOptionsTest() throws Throwable {
		Assert.assertTrue(msgOptions.verifySentMsgOptions(reader.getCellData(sheetName, userToSelect, 2), reader.getCellData(sheetName, message, 2)));
	}
	
	/*Verify that by clicking on the three vertical lines (More Options) in the message 
	 * options for a received message will display Reply forward and hide options.*/
	@Test(priority=3,enabled=true)
	public void verifyReceivedMsgOptionsTest() throws Throwable {
		Assert.assertTrue(msgOptions.verifyReceivedMsgOptions(reader.getCellData(sheetName, userToSelect, 2),
				reader.getCellData(sheetName, oppositeUser, 2),
				reader.getCellData(sheetName, message, 2)));
				
	}
	
	//Verify that mouse hover on like icon  in message options will populates the text "Like"
	@Test(priority=4,enabled=true)
	public void verifyLikeBtnMousehover() throws Throwable {
		String actualTooltip=msgOptions.verifyLikeBtnMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "Like");
		System.out.println(actualTooltip);
	}
	
	//Verify that mouse hover on like icon  in message options which is already liked will populates the text "Remove Like"
	@Test(priority=5,enabled=true)
	public void verifyAlreadyLikedBtnMousehover() throws Throwable {
		String actualTooltip=msgOptions.verifyAlreadyLikedBtnMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "Remove Like");
		System.out.println(actualTooltip);
	}
		
	//Verify the "envelope" (read/unread messages) symbol mouse hover action in the message options of messages in the message thread
	@Test(priority=6,enabled=true)
	public void verifyMarkUnreadBtnMousehover() throws Throwable {
		String actualTooltip=msgOptions.verifyMarkUnreadBtnMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "Mark Unread");
		System.out.println(actualTooltip);
	}
		
	//Verify that mouse hover on Flag icon  in message options will populates the text "Flag"
	@Test(priority=7,enabled=true)
	public void verifyFlagBtnMousehover() throws Throwable {
		String actualTooltip=msgOptions.verifyFlagBtnMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "Flag");
		System.out.println(actualTooltip);
	}
		
	//Verify that mouse hover on Flag icon  in message options which is already Flagged  will populates the text "Remove Flag"
	@Test(priority=8,enabled=true)
	public void verifyAlreadyFlaggedBtnMousehover() throws Throwable {
		String actualTooltip=msgOptions.verifyAlreadyFlaggedBtnMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "Remove Flag");
		System.out.println(actualTooltip);
	}

	//Verify that mouse hover on Emoji icon in the message options will populates the text "Reaction"
	@Test(priority=9,enabled=true)
	public void verifyEmojiIconMousehover() throws Throwable {
		String actualTooltip=msgOptions.verifyEmojiIconMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "Reaction");
		System.out.println(actualTooltip);	
	}
		
	//Verify that mouse hovering on the three vertical lines(more options) in the message options will populates the text "More Options".
	@Test(priority=10,enabled=true)
	public void verify3VerticalDotsMousehover() throws Throwable {
		String actualTooltip=msgOptions.verify3VerticalDotsMousehover(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(actualTooltip, "More Options");
		System.out.println(actualTooltip);	
	}
		
	/*Verify that by clicking on the Like icon in the message option will like that particular
	 * message and like icon/symbol will appear besides the message.*/
	@Test(priority=11,enabled=true)
	public void verifyLikeBtnClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyLikeBtnClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that the opposite User click on the like icon beside the message the count will increase to 2.
	@Test(priority=12,enabled=true)
	public void verifyOppositeUserClickLikeBtn() throws Throwable {
		String likesCount=msgOptions.verifyOppositeUserClickLikeBtn(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2), reader.getCellData(sheetName, oppositeUser, 2));
		
		Assert.assertEquals(likesCount, "2");
		System.out.println(likesCount);
	}
	
	//Verify that mouse hover on the like Icon beside the message will populates the User name and avatar who liked it.
	@Test(priority=13,enabled=true)
	public void verifyUsernamesAfterClickedLikeBtn() throws Throwable {
		String actualLikedUsers=msgOptions.verifyUsernamesAfterClickedLikeBtn(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2), reader.getCellData(sheetName, oppositeUser, 2));
		String expLikedUsers=reader.getCellData(sheetName, userToSelect, 2);
				reader.getCellData(sheetName, oppositeUser, 2);
				Assert.assertTrue(actualLikedUsers.contains(expLikedUsers));
				System.out.println(actualLikedUsers);
		
	}
	
	//Verify that Re-clicking on the like Icon will disappear the like icon beside the message/ decreases the count.
	@Test(priority=14,enabled=true)
	public void verifyReclickingLikedBtn() throws Throwable {
		Assert.assertTrue(msgOptions.verifyReclickingLikedBtn(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that if we Click on the mark unread, A vertical purple bar will appear on the left side of the message.
	@Test(priority=15,enabled=true)
	public void verifyMarkUnreadBtnClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyMarkUnreadBtnClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that if we click on the mark unread, The thread count will display on the conversation list user name.
	@Test(priority=16,enabled=true)
	public void verifyUnreadCountClickMarkUnreadBtn() throws Throwable {
		String unreadCount=msgOptions.verifyUnreadCountClickMarkUnreadBtn(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		String expUnreadCount = driver.findElement(By.xpath("//*[contains(@class,'users-list-name')]//following-sibling::*[contains(@class,'media-right')]//label")).getText();
		Assert.assertEquals(unreadCount, expUnreadCount);
		System.out.println(unreadCount);
	}
	
	//Verify that if we mouse hover mark unread after clicking it, The icon will change to mark read status and display the tool tip as mark read
	@Test(priority=17,enabled=true)
	public void verifyMarkReadTooltip() throws Throwable {
		String markReadTooltip=msgOptions.verifyMarkReadTooltip(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(markReadTooltip, "Mark Read");
		System.out.println(markReadTooltip);
	}
	
	//Verify that if we click on the mark read icon then the purple bar will disappears.
	@Test(priority=18,enabled=true)
	public void verifyMarkReadClickAction() throws Throwable {
		String markUnreadTooltip=msgOptions.verifyMarkReadClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(markUnreadTooltip, "Mark Unread");
		System.out.println(markUnreadTooltip);
	}
	
	/*Verify that by clicking on the Flag icon in the message option will Flag 
	 * that particular message and Flag icon/symbol will appear besides the message.*/
	@Test(priority=19,enabled=true)
	public void verifyFlagIconClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyFlagIconClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify the flagged message or images or attachments are reflected in flags section in third panel or not
	@Test(priority=20,enabled=true)
	public void verifyFlaggedMsgInFilesSection() throws Throwable {
		String flagsSectionMsgs=msgOptions.verifyFlaggedMsgInFilesSection(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertTrue(flagsSectionMsgs.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println("Flagged message in flags section: "+flagsSectionMsgs);
	}
	
	//Verify that re-clicking on the Flag Icon besides the message will vanishes the flag icon .
	@Test(priority=21,enabled=true)
	public void verifyRemoveFlagAction() throws Throwable {
		String flagTooltip=msgOptions.verifyRemoveFlagAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(flagTooltip, "Flag");
		System.out.println(flagTooltip);
	}

	//Verify that by clicking on the reaction Icon will populates the Emojis window.
	@Test(priority=22,enabled=true)
	public void verifyReactionIconClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyReactionIconClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//verify that we have Emoji search option in the window.
	@Test(priority=23,enabled=true)
	public void verifySearchFieldEmojiPopup() throws Throwable {
		Assert.assertTrue(msgOptions.verifySearchFieldEmojiPopup(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	// Verify that we have frequently used section in the emoji window
	@Test(priority=24,enabled=true)
	public void verifyFrequentlyUsedSection() throws Throwable {
		Assert.assertTrue(msgOptions.verifyFrequentlyUsedSection(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	// Verify that we are able scroll down to have more emoji types
	@Test(priority=25,enabled=true)
	public void verifyScrollBarEmojiPopup() throws Throwable {
		Assert.assertTrue(msgOptions.verifyScrollBarEmojiPopup(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	// Verify that by clicking on the cross mark symbol at the top right corner of emoji window will close the emoji window.
	@Test(priority=26,enabled=true)
	public void verifyEmojiPopup_X_Symbol() throws Throwable {
		Assert.assertTrue(msgOptions.verifyEmojiPopup_X_Symbol(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that by clicking on any Emoji from the window will be selected and display beside the message
	@Test(priority=27,enabled=true)
	public void verifyEmojiClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyEmojiClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that by adding an emoji to the message,  add reaction icon with emoji symbol will be added next to added emoji.
	@Test(priority=28,enabled=true)
	public void verifyAddReactionSymbol() throws Throwable {
		Assert.assertTrue(msgOptions.verifyAddReactionSymbol(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that the Emoji added by the logged in user has count 1 and border colour of the emoji will be in blue.
	@Test(priority=29,enabled=true)
	public void verifyEmojiCount_LoggedInUser() throws Throwable {
		String emojisCount=msgOptions.verifyEmojiCount_LoggedInUser(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(emojisCount, "1");
		System.out.println("Emojis Count for logged in user: "+emojisCount);
	}
	
	//Verify that by clicking the same emoji by the opposite user will increase the count by 2 and turns grey border to blue.
	@Test(priority=30,enabled=true)
	public void verifyEmojiCount_OppUserSelectSameEmoji() throws Throwable {
		String emojisCount=msgOptions.verifyEmojiCount_OppUserSelectSameEmoji(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, oppositeUser, 2));
		Assert.assertEquals(emojisCount, "2");
		System.out.println("Emojis Count after opposite user click on same emoji: "+emojisCount);
	}
	
	//Verify that mouse hovering on the emoji will display the user name with avatar who had reacted on it.
	@Test(priority=31,enabled=true)
	public void verifyUsernamesOnMousehoverEmoji() throws Throwable {
		String actualResult=msgOptions.verifyUsernamesOnMousehoverEmoji(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2), reader.getCellData(sheetName, oppositeUser, 2));
		String expectedResult=reader.getCellData(sheetName, userToSelect, 2);
				reader.getCellData(sheetName, oppositeUser, 2);
				Assert.assertTrue(actualResult.contains(expectedResult));
				System.out.println(actualResult);
	}
	
	//Verify that Reclicking on the added emoji will disappear the emoji  beside the message/ decreases the count.
	@Test(priority=32,enabled=true)
	public void verifyReclickingOnEmoji() throws Throwable {
		Assert.assertTrue(msgOptions.verifyReclickingOnEmoji(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	// Verify that Clicking on the reply option from more options in message option is adding that particular message to Input field
	@Test(priority=33,enabled=true)
	public void verifyReplyClickAction() throws Throwable {
		String replyMsg=msgOptions.verifyReplyClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		
		Assert.assertTrue(replyMsg.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(replyMsg);
	}

	// Verify that by clicking on the cross mark symbol at the top right corner of reply message will remove the reply message added to the input field
	@Test(priority=34,enabled=true)
	public void verifyReplyMsgCrossSymClick() throws Throwable {
		Assert.assertTrue(msgOptions.verifyReplyMsgCrossSymClick(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}

	// Verify that by clicking on the Reply all option for plain text message should open a pop up with the same user name populated in the To filed.
	@Test(priority=35,enabled=true)
	public void verifyReplyAllClickAction() throws Throwable {
		String replyAllPopupUser=msgOptions.verifyReplyAllClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		
		Assert.assertTrue(replyAllPopupUser.contains(reader.getCellData(sheetName, userToSelect, 2)));
		System.out.println(replyAllPopupUser);
	}

	// Verify that popup header name is Reply All
	@Test(priority=36,enabled=true)
	public void verifyReplyAllPopupTitle() throws Throwable {
		Assert.assertTrue(msgOptions.verifyReplyAllPopupTitle(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//verify default subject message in reply all message pop up window
	@Test(priority=37,enabled=true)
	public void verifyDefaultSubject_ReplyAll() throws Throwable {
		String defaultSubject=msgOptions.verifyDefaultSubject_ReplyAll(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(defaultSubject, "illumy - Reply Message");
		System.out.println(defaultSubject);
	}

	// Verify that the pop up has @ mentions, Gif, Emoji, Attachment icons in bottom right corner
	@Test(priority=38,enabled=true)
	public void verifyIconsInReplyAllPopup() throws Throwable {
		Assert.assertTrue(msgOptions.verifyIconsInReplyAllPopup(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that the Attached message has the show message/hide message option beside the reply attachments.
	@Test(priority=39,enabled=true)
	public void verifyShowAndHideMsgOptions() throws Throwable {
		Assert.assertTrue(msgOptions.verifyShowAndHideMsgOptions(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}

	// verify that the popup has a send button at the bottom right corner.
	@Test(priority=40,enabled=true)
	public void verifySendBtnReplyAllPopup() throws Throwable {
		Assert.assertTrue(msgOptions.verifySendBtnReplyAllPopup(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}

	// Verify that by sending the Reply all by adding users in to and cc fields with message content should deliver to all the users.
	@Test(priority=41,enabled=true)
	public void verifyReplyAllMsgInMsgThread() throws Throwable {
		String replyAllMsg=msgOptions.verifyReplyAllMsgInMsgThread(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertTrue(replyAllMsg.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(replyAllMsg);
		
	}

	// Verify that To and CC should display in the message thread
	@Test(priority=42,enabled=true)
	public void verifyReplyAllMsgAddUsersToCc() throws Throwable {
	String replyAllToCcUsers=msgOptions.verifyReplyAllMsgAddUsersToCc(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, ccKeys, 2),
				reader.getCellData(sheetName, ccUsers, 2));
		Assert.assertTrue(replyAllToCcUsers.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(replyAllToCcUsers);
	}
	
	
	/*Verify that by clicking on the Forward option from more options in message options will display
	 *  a new forward window with Forward text on it*/
	@Test(priority=43,enabled=true)
	public void verifyForwardMsgPopupTitle() throws Throwable {
		Assert.assertTrue(msgOptions.verifyForwardMsgPopupTitle(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}

	//Verify that subject field in forward window has the predefined text as "illumy - Forward Message".
	@Test(priority=44,enabled=true)
	public void verifyFwdMsgDefaultSubject() throws Throwable {
		String defaultSubject=msgOptions.verifyFwdMsgDefaultSubject(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(defaultSubject, "illumy - Forward Message");
		System.out.println(defaultSubject);
	}
	
	/*Verify that by clicking on the send button without selecting user should 
	 * get a mandatory field message as "Please select at least one user"*/
	@Test(priority=45,enabled=true)
	public void clickOnSendBtnWithoutUsers_FwdMsg() throws Throwable {
		String plsSelectOneUser=msgOptions.clickOnSendBtnWithoutUsers_FwdMsg(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertEquals(plsSelectOneUser, "Please select at least one user.");
		System.out.println(plsSelectOneUser);
	}
	
	//Verify that by clicking on send Button with valid user in "To" field has to deliver the forward message 
	@Test(priority=46,enabled=true)
	public void verifyFwdMsgInMsgThread() throws Throwable {
		String fwdMsg=msgOptions.verifyFwdMsgInMsgThread(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, toKeys, 2),
				reader.getCellData(sheetName, toUsers, 2));
		Assert.assertTrue(fwdMsg.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(fwdMsg);
	}
	
	//verify that by clicking on the cross mark on the top right corner of forward window should close that particular window.
	@Test(priority=47,enabled=true)
	public void verifyFwdMsgPopupClose_ClickXSym() throws Throwable {
		Assert.assertTrue(msgOptions.verifyFwdMsgPopupClose_ClickXSym(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	/*Verify that by clicking on the Hide option from more options in message options will hide that
	 *  particular message with dark grey color Saying the text "This message is hidden".
	 */
	@Test(priority=48,enabled=true)
	public void verifyHideMessageOption() throws Throwable {
		Assert.assertTrue(msgOptions.verifyHideMessageOption(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that by clicking on the "Unhide message" button will shows up the message and removes the grey border.
	@Test(priority=49,enabled=true)
	public void verifyUnhideMessage() throws Throwable {
		String unhideMsg=msgOptions.verifyUnhideMessage(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertTrue(unhideMsg.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(unhideMsg);
	}
	
	/*Verify that by clicking on the Edit message from more option in message options
	 *  will enable that message to be editable in the message thread view only.
	 */
	@Test(priority=50,enabled=true)
	public void verifyEditMsg_MessageThread() throws Throwable {
		String editMsg=msgOptions.verifyEditMsg_MessageThread(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2));
		Assert.assertTrue(editMsg.contains(reader.getCellData(sheetName, message, 2)));
		System.out.println(editMsg);
	}
	
	//Verify that we have Add emoji symbol and GIF  icons at top right corner of the message to add reactions.
	@Test(priority=51,enabled=true)
	public void verifyEmoji_GIFIcons_EditMsg() throws Throwable {
		Assert.assertTrue(msgOptions.verifyEmoji_GIFIcons_EditMsg(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	/*Verify that by clicking on the cancel button below the editable input message 
	 * field will cancel the edit process and remains the same message
	 */
	@Test(priority=52,enabled=true)
	public void verifyEditMsg_ClickCancelBtn() throws Throwable {
		Assert.assertTrue(msgOptions.verifyEditMsg_ClickCancelBtn(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that by editing some thing and clicking on "save changes" will reflect the changes in message thread.
	@Test(priority=53,enabled=true)
	public void verifyEditMsg_ClickSaveChangesBtn() throws Throwable {
		String editedMsg=msgOptions.verifyEditMsg_ClickSaveChangesBtn(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, "editMsgKeys", 2));
		Assert.assertTrue(editedMsg.contains(reader.getCellData(sheetName, message,2)));
		System.out.println(editedMsg);
	}
	
	//Verify that after editing a message we have a text "(edited)" besides the message. (to make sure that we have edited it)
	@Test(priority=54,enabled=true)
	public void verifyEditedMsg_LoggedInUser() throws Throwable {
		Assert.assertTrue(msgOptions.verifyEditedMsg_LoggedInUser(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, "editMsgKeys", 2)));
	
	}
	
	//Verify that the opposite user also has the text "(edited)" once the sender edits it.
	@Test(priority=55,enabled=true)
	public void verifyEditedMsg_OppositeUser() throws Throwable {
		Assert.assertTrue(msgOptions.verifyEditedMsg_OppositeUser(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, "editMsgKeys", 2),
				reader.getCellData(sheetName, oppositeUser, 2)));
	}

	/*Verify that by clicking on the delete option  from more options in message options will opens a confirmation 
	 * popup saying "Are you sure you want to delete this message?" with cancel and confirm buttons.
	 */
	@Test(priority=56,enabled=true)
	public void verifyDeleteClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyDeleteClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that by clicking on the Cancel button will close the pop-up and message retains same.
	@Test(priority=57,enabled=true)
	public void verifyCancelBtnClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyCancelBtnClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that by clicking on the confirm button will delete that particular message from the message thread.
	@Test(priority=58,enabled=true)
	public void verifyConfirmBtnClickAction() throws Throwable {
		Assert.assertTrue(msgOptions.verifyConfirmBtnClickAction(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
	}
	
	//Verify that for the opposite user also the message will be deleted
	@Test(priority=59,enabled=true)
	public void verifyDeletedMsg_OppositeUser() throws Throwable {
		Assert.assertTrue(msgOptions.verifyDeletedMsg_OppositeUser(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2),
				reader.getCellData(sheetName, oppositeUser, 2)));
	}
	
	//Verify that by clicking on the cross mark on the top right corner of delete popup will close that particular window.
	@Test(priority=60,enabled=true)
	public void verifyDeletePopupXSymbolClick() throws Throwable {
		Assert.assertTrue(msgOptions.verifyDeletePopupXSymbolClick(reader.getCellData(sheetName, userToSelect, 2), 
				reader.getCellData(sheetName, message, 2)));
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
