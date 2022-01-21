package com.wallet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wallet.qa.base.TestBase;

public class WalletHomePage extends TestBase {
	
	
	@FindBy(xpath="(//span[contains(text(),'Your Review')]/..//following::div[@itemprop='description'])[1]")
	WebElement Validate_post;
	
	public WalletHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Method to validate posted message
	public void ValidatePost() {
		  
		  String Val = Validate_post.getText();
		  
		  Assert.assertEquals(Val,prop.getProperty("Comment")); 		
		
	}
	

}
