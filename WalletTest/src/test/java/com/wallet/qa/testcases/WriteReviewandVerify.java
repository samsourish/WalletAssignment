package com.wallet.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallet.qa.base.TestBase;
import com.wallet.qa.pages.*;
import com.wallet.qa.util.*;
public class WriteReviewandVerify extends TestBase {
	
	walletLandingPage walletLandingPage; 
	walletCreatePost walletCreatePost; 
	WalletLoginPage walletLoginPage;
	WalletHomePage WalletHomePage;
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.get(prop.getProperty("url1"));
		walletLandingPage = new walletLandingPage();		
	}
	
	@Test
	public void writeReview() throws Exception {
		
		//Verify the home page after launching Application
		Boolean result = walletLandingPage.verifyPageLoad();
		TestUtil.takeScreenshot();
		if(result == false)
		{
			Reporter.log("Wallet Home Page not loaded");	
			return;
		}
		
		//calling method to validate the stars and for selecting rating
		walletCreatePost = walletLandingPage.CreateRating(Integer.parseInt(prop.getProperty("Rating")));
		TestUtil.takeScreenshot();
		result = walletLandingPage.verifyPageLoad();
		if(result == false)
		{
			Reporter.log("Wallet Create Post Page not loaded");	
			return;
		}	
		Reporter.log("Wallet Create Post Page loaded");	
		
		// Calling method for creating the post
		walletLoginPage = walletCreatePost.CreatePost();
		TestUtil.takeScreenshot();
		System.out.println(walletLoginPage);
		result= walletLoginPage.verifyPageLoad();
		if(result == false)
		{
			Reporter.log("Login Page not loaded");	
			Assert.fail("Login Page not loaded due to exception");
			return;
		}	
		Reporter.log("Login Page loaded");
		
		//Login to Wallethub 
		walletLoginPage.Login();
		TestUtil.takeScreenshot();
		
		//Method for validating the review
		WalletHomePage.ValidatePost();	
		TestUtil.takeScreenshot();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
