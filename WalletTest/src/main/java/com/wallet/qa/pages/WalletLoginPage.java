package com.wallet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallet.qa.base.TestBase;
import com.wallet.qa.util.TestUtil;

public class WalletLoginPage extends TestBase {
	

	
	@FindBy(xpath="//a[text()='Login']")
	WebElement tab_Login;
	
	
	@FindBy(xpath="//input[@aria-label='email address']")
	WebElement txt_un;
	
	static By txt_Username = By.xpath("//input[@aria-label='email address']");
	
	@FindBy(xpath="//input[@id='pw1-ipt']")
	WebElement txt_pwd;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement btn_Login;
	
	public WalletLoginPage(){
		PageFactory.initElements(driver, this);
	}	
	
	 public static Boolean verifyPageLoad() {		 
		 Boolean status = TestUtil.wait_element_located(txt_Username);	
		 return status;
	 }
	
	 //Method to login to wallethub Application
	public void Login() throws InterruptedException {		
		 txt_un.sendKeys(prop.getProperty("wh_un"));
		  txt_pwd.sendKeys(prop.getProperty("wh_pwd"));
		  btn_Login.click();		  
		  Thread.sleep(5000);		
	}

}
