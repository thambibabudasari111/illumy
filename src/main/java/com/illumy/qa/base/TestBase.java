/**
 * 
 */
package com.illumy.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.illumy.qa.util.TestUtil;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author thambibabu.dasari
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static NgWebDriver ngWebDriver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static JavascriptExecutor jsExecutor;
	
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/illumy/qa/config/config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String randomEmail(int length) {

		   return RandomStringUtils.random( length, "1234567890");
		 
	}
	
	public static void initialization() {
		
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			Map<String,Object>prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications",1);
			//1-Allow , 2-Block, 0-Default
			options.setExperimentalOption("prefs", prefs);
			
			driver=new ChromeDriver(options);
			
			
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}	
	

	public static void getSysInfo() {
	
	extent=new ExtentReports(System.getProperty("user.dir")+"/Reports/illumyReports.html",true);
	extent.addSystemInfo("Host Name", "NEOBRIC-NEO204");
	extent.addSystemInfo("User Name", "Thambi Babu Dasari");
	extent.addSystemInfo("Environment", "Stage");
	}
	
	public static void failedTestsScreenshots(String testMethodName) {
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileHandler.copy(scrFile,new File(System.getProperty("user.dir")+"/FailedTestsScreenshots/"+testMethodName+"_"+".jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyyMMdd_hh mm ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+screenshotName+"_" + dateName+".jpg";
		File finalDestination=new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}
	
	public static void testStart(ITestResult result) {
		extentTest=extent.startTest(result.getMethod().getMethodName());
	}
	
	
	public static void getTestStatus(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS : "+result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS : "+result.getName());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED BECAUSE OF : "+result.getThrowable());
			
			String screenshotPath=TestBase.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS : "+result.getName());
		}
		extent.endTest(extentTest);
	}
	
	public static void endReport() {
		extent.flush();
		extent.close();
	}
	
	public static void thread() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	
}
