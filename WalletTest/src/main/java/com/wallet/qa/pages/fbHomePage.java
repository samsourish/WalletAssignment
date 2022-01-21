package com.wallet.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallet.qa.base.TestBase;
import com.wallet.qa.util.TestUtil;

public class fbHomePage extends TestBase{
	
	
	@FindBy(xpath="//span[contains(text(),'on your mind')]")
	WebElement txt_CreatePost;
	
	static By txt_CP = By.xpath("//span[contains(text(),'on your mind')]");
	
	@FindBy(xpath="//div[@class='_1mf _1mj']")
	WebElement txt_CreatePost1;
	
	@FindBy(xpath="//span[text()='Post']")
	WebElement btn_post;
	
	@FindBy(xpath="(//div[@aria-label='Account'])[1]")
	WebElement Account;
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement Logout;
	
	
	public fbHomePage(){
		
		PageFactory.initElements(driver, this);				
	}
	
	
/*	public boolean verifyCreatePost(){
		return txt_CreatePost.isDisplayed();
	}*/
	
	 public static Boolean verifyCreatePost() {		 
		 Boolean status = TestUtil.wait_element_located(txt_CP);	
		 return status;
	 }
	
	//Posting the message in the Facebook
	public void CreatePost() throws InterruptedException{
		txt_CreatePost.click();
		txt_CreatePost1.click();
		txt_CreatePost1.sendKeys(prop.getProperty("Message"));
		btn_post.click();
		}
	
	//Logout from the Facebook
	public fblogin logout() throws InterruptedException {
		Account.click();
		Thread.sleep(2000);
		Logout.click();
		Thread.sleep(5000);
		return new fblogin();	
	}
	


}
