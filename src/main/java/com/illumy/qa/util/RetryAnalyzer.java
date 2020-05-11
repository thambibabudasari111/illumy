/**
 * 
 */
package com.illumy.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author thambibabu.dasari
 *
 */
public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int retryLimit=1;
	
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}
}
