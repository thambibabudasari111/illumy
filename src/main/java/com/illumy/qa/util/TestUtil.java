	/**
 * 
 */
package com.illumy.qa.util;





import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import java.util.List;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.illumy.qa.base.TestBase;

/**
 * @author thambibabu.dasari
 *
 */
public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=20;
	
	
	public static String FILEPATH_TO_UPLOAD = System.getProperty("user.dir")+"/src/main/java/com/illumy/qa/testdata/InputSheet.xlsx";
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/illumy/qa/testdata/InputSheet.xlsx";
			

	
	public static void scrollIntoView(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	
	public static void selectElementFromList(String xpath_Value,String userToSelect) throws Throwable {
		List<WebElement>list=driver.findElements(By.xpath(xpath_Value));
		
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			try {
				if(list.get(i).getText().contains(userToSelect)) {
					
					list.get(i).click();
					break;
			}
			
			}catch(StaleElementReferenceException e) {
				
				list=driver.findElements(By.xpath(xpath_Value));
					if(list.get(i).getText().contains(userToSelect)) {
						list.get(i).click();
						thread();
						break;
				}
			}
		}
	}
		
	public static void msgThreadListOfElements(String xpath_Value,String message) {
		String msg="";
		List<WebElement>list=driver.findElements(By.xpath(xpath_Value));
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contains(message)) {
				msg=list.get(i).getText();
			}
		}
		
		System.out.println(msg);
	}
	
	
	public static void uploadFile(String filePath) throws Throwable {
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.setAutoDelay(2000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(1000);
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
	
	
	
	public static void DesktopNotifications(String image_Path) throws Throwable {
		Screen s=new Screen();
		
		Pattern p=new Pattern(image_Path);
		s.wait(p, 2000);
		s.click();
	}
	
	
	
	public static void drawBorder(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void mousehoverActions(String xpath_Value,String userNameToSelect,WebElement element) {
		List<WebElement>list=driver.findElements(By.xpath(xpath_Value));
		for(int i=0;i<list.size();i++) {
			list.get(i).getText();
			if(list.get(i).getText().contains(userNameToSelect)) {
				Actions action=new Actions(driver);
				action.moveToElement(element).build().perform();
			}
		}
	}
	
	public static String getElementFromMsgThread(String xpath_ThreadMsgs,String subject,String textMsg) {
		String threadMsg="";
		List<WebElement>msgThread=driver.findElements(By.xpath(xpath_ThreadMsgs));
		for(int i=0;i<msgThread.size();i++) {
			msgThread.get(i).getText();
			String threadMsgs=subject+"\n"+textMsg;
			if(msgThread.get(i).getText().contains(threadMsgs)) {
				threadMsg=msgThread.get(i).getText();
			}
		}
		return threadMsg;
	}
	
	public static String randomChars(int  chars) {

		   return RandomStringUtils.random(chars,"abcdefghijklmnopqrstuvwxyz");
		 
	}
	
}
	
	

