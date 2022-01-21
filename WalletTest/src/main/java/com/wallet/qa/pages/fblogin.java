package com.wallet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallet.qa.base.TestBase;

public class fblogin extends TestBase {
	
	
	  @FindBy(id="email")
	  WebElement username;
	  
	  @FindBy(id="pass")
	  WebElement password;
	  
	  @FindBy(xpath="//button[@name='login']")
	  WebElement btn_submit;
	  
	  public fblogin(){
			PageFactory.initElements(driver, this);
		}
	
	  //Validate Facebook title
	  public String validateLoginPageTitle(){
			return driver.getTitle();
		}
	 
	  //Login to Facebbok
	  public fbHomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			btn_submit.click();
			return new fbHomePage();
		}
	  
	  
	  
	  
	

}
