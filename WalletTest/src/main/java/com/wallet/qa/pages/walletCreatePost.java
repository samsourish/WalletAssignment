package com.wallet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.wallet.qa.base.TestBase;
import com.wallet.qa.util.TestUtil;

public class walletCreatePost extends TestBase{
	
	@FindBy(xpath="//span[@role='button' and text()='Select...']")
	WebElement lst_select;
	
	static By drp_select = By.xpath("//span[@role='button' and text()='Select...']");
	
	@FindBy(xpath="//li[text()='Life Insurance']")
	WebElement Dd_val;
	
	@FindBy(xpath="//textarea[@placeholder='Write your review...']")
	WebElement txt_area;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement submit;
	
	
	
	public walletCreatePost(){
			PageFactory.initElements(driver, this);
		}
	 
	 //Verify Wallethub Home page loading
	 public static Boolean verifyPageLoad() {		 
		 Boolean status = TestUtil.wait_element_located(drp_select);	
		 return status;
	 }
	
	
	 //Login to Wallethub Screen
	public WalletLoginPage CreatePost() throws InterruptedException {
	  lst_select.click();		  
	  Dd_val.click();	
	  txt_area.click();
	  txt_area.sendKeys(prop.getProperty("Comment"));	  
	  Thread.sleep(5000);	  
	  submit.click();	
	  Thread.sleep(5000);
	  return new WalletLoginPage();
	}

}
