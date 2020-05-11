/**
 * 
 */
package illumy_ILcom.illumy.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.illumy.qa.base.TestBase;
import com.illumy.qa.pages.ComposeMessage;
import com.illumy.qa.pages.Files;
import com.illumy.qa.pages.HomePage;
import com.illumy.qa.pages.SigninPage;
import com.illumy.qa.util.TestUtil;

/**
 * @author thambibabu.dasari
 *
 */
public class FilesTest extends TestBase{

	
	
	public  Files files;
	public  SigninPage signinPage;
	public  HomePage homePage;
	public 	TestUtil testUtil;
	
	String userToSelect="Vamshidhar Bommineni";
	String userToSelect1="test account three";
	public FilesTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) throws Throwable {
		initialization();
		signinPage=new SigninPage();	
		homePage=signinPage.singin(prop.getProperty("illumy_Email"), prop.getProperty("password"));
		files=new Files();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	//Verify the files section by clicking on the "Hide Widgets" symbol in third panel
	@Test(priority=1,enabled=true)
	public void verifyFilesSection_HideWidgets() throws Throwable {
		Assert.assertTrue(files.verifyFilesSection_HideWidgets());
	}
	
	//Verify the files section by clicking on the "Show Widgets" symbol in third panel
	@Test(priority=2,enabled=true)
	public void verifyFilesSection_ShowWidgetsTest() throws Throwable {
		Assert.assertTrue(files.verifyFilesSection_ShowWidgets());
	}
	
	//Verifying the files section in message module by clicking on expand symbol
	@Test(priority=3,enabled=true)
	public void verifyFilesSection_MsgModuleTest() throws Throwable {
		String actual=files.verifyFilesSection_MsgModule();
		Assert.assertEquals(actual, "No files to see here right now!");
		System.out.println(actual);
	}
	
	//Checking the files section if there are no files available 
	@Test(priority=4,enabled=true)
	public void verifyFilesSection_NoFilesTest() throws Throwable {
		String actual=files.verifyFilesSection_NoFiles(userToSelect);
		Assert.assertEquals(actual, "No files to see here right now!");
		System.out.println(actual);
	}
	
	//Verify the file options by clicking on vertical ellipsis of attachments sent by the logged in user 
	@Test(priority=5,enabled=true)
	public void verifyFileOptions_LoggedinUser() throws Throwable {
		String[]expectedOptions=new String[] {
			"Download",
			"Go To File",
			"Share",
			"Get External Link",
			"Delete"
		};
		String[]fileOptions=files.verifyFileOptions_LoggedinUser(userToSelect1, prop.getProperty("fileName1"));
		Assert.assertEquals(fileOptions, expectedOptions);
	}
	
	//Verify click functionality of the "Download" option of an attachment in the file options
	@Test(priority=6,enabled=true)
	public void verifyDownloadOptionTest() throws Throwable {
		Assert.assertTrue(files.verifyDownloadOption(userToSelect1, prop.getProperty("fileName1"),prop.getProperty("fileLocation")));
	}
	
	//Verify click functionality of the "Go To File" option of an attachment in the file options
	@Test(priority=7,enabled=true)
	public void verifyGoToFileOptionTest() throws Throwable {
		files.verifyGoToFileOption(userToSelect1, prop.getProperty("fileName1"));
	}
	
	//Verify click functionality of the "Share" option of an attachment in the file options
	@Test(priority=8,enabled=true)
	public void verifyShareOptionTest() throws Throwable {
		Assert.assertTrue(files.verifyShareOption(userToSelect1, prop.getProperty("fileName1")));
	}
	
	//Verify click functionality of the "Get External Link" option of an attachment in the file options
	@Test(priority=9,enabled=true)
	public void verifyGetExternalLinkOptionTest() throws Throwable {
		Assert.assertTrue(files.verifyGetExternalLinkOption(userToSelect1, prop.getProperty("fileName1")));
	}
	
	//Verify the click functionality of the "Delete" option of an attachment in the file options
	@Test(priority=10,enabled=true)
	public void verifyDeleteOptionTest() throws Throwable {
		Assert.assertTrue(files.verifyDeleteOption(userToSelect1, prop.getProperty("fileName1")));
	}
	
	//Verify the share pop up "Send" button  functionality to share an attachment
	@Test(priority=11,enabled=true)
	public void verifyShareAttachment_SharePopup() throws Throwable {
		files.verifyShareAttachment_SharePopup(userToSelect1, prop.getProperty("fileName1"), 
				prop.getProperty("keys"), 
				prop.getProperty("user"));
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
