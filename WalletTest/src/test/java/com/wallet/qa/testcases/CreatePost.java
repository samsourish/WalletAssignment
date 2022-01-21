package com.wallet.qa.testcases;

import com.wallet.qa.util.*;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallet.qa.base.TestBase;
import com.wallet.qa.pages.fblogin;

import jdk.internal.org.jline.utils.Log;

import com.wallet.qa.pages.fbHomePage;

public class CreatePost extends TestBase{
	
	fblogin fblogin;
	fbHomePage fbHomePage;
	public CreatePost(){
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.get(prop.getProperty("url"));
		fblogin = new fblogin();	
	}
	
	@Test()
	public void CreatePost() throws Exception{
		
		String title =  fblogin.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up","Home Page displayed");
		Reporter.log("Home Page displayed");
		TestUtil.takeScreenshot();
		
		fbHomePage = fblogin.login(prop.getProperty("facebook_UN"), prop.getProperty("facebook_pwd"));
		Boolean flag = fbHomePage.verifyCreatePost();
		Assert.assertTrue(flag);
		Reporter.log("Facebook Home Page displayed");
		TestUtil.takeScreenshot();
		
		fbHomePage.CreatePost();
		flag = fbHomePage.verifyCreatePost();
		Assert.assertTrue(flag);
		
		fblogin = fbHomePage.logout();
		title =  fblogin.validateLoginPageTitle();
		TestUtil.takeScreenshot();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
