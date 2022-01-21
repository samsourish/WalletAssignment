package com.wallet.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.wallet.qa.base.TestBase;
import com.wallet.qa.util.*;
public class walletLandingPage extends TestBase{
	
	@FindBy(xpath="//h1[text()='Test Insurance Company']")
	WebElement wh_header;
	
	By wb_Recent = By.xpath("(//span[text()='Most Recent'])[1]");
	
	@FindBy(xpath="(//div[@class='rating-box-wrapper'])[3]//*[local-name()='svg']")
	List<WebElement> rating;	
	
	
	 public walletLandingPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 public Boolean verifyPageLoad() {		 
		 Boolean status = TestUtil.wait_element_located(wb_Recent);			
		 return status;
	 }
	
	//Method to verify stars lit up and to select rating
	 public walletCreatePost CreateRating(int RatingVal) throws InterruptedException {
		 
		 Reporter.log("Navigated to Wallet hub Landing Page");
		 Actions ac = new Actions(driver);	
		 		 		 		 
		 for(int i=0;i<=RatingVal-1;i++)
		 {
		  ac.moveToElement(rating.get(i)).build().perform();
		  
		  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		  jsExecutor.executeScript("arguments[0].style.border='2px solid red'", rating.get(i)); 		  
		  Thread.sleep(5000);		  
		  List<WebElement> l = driver.findElements(By.xpath("((//div[@class='rating-box-wrapper'])[3]//*[local-name()='svg'])["+(i+1)+"]//*[local-name()='path']"));
		  int n = l.size();
		  Reporter.log("The rating star"+  (i+1) +" got highlighted");
		  Assert.assertEquals(n,2,+n); 				
			}		 
		 
		  rating.get(RatingVal-1).click();	
		  Reporter.log("Clicked on the Fourth star");
		  return new walletCreatePost();
		 }
	 
	
		 		 
	}
