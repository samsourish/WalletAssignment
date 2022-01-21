package com.wallet.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.wallet.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	//Method to wait check webelement presence 
	
public static boolean wait_element_located(By e1) {	
	WebDriverWait wait = new WebDriverWait (driver, 20);
	
	try
	 {
		wait.until(ExpectedConditions.presenceOfElementLocated(e1));	
		 System.out.println("wait3");
		return true;
	 }	
	catch (TimeoutException e)
	 {
		 System.out.println("wait4");
		return false;
		
	 }
						
}

//Method to save Take Screenshot
public static void takeScreenshot() throws Exception {
	String timeStamp;
	File screenShotName;
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	screenShotName = new File(System.getProperty("user.dir")+ "/Screenshot/"+timeStamp+".png");
	FileUtils.copyFile(scrFile, screenShotName);	 
	Reporter.log("<br><img src='"+screenShotName+"' height='300' width='600'/><br>");  
 
}


}

