package com.qa.cheapoair.tests;

import org.testng.annotations.Test;

import com.qa.cheapoair.data.LoginExcelData;
import com.qa.cheapoair.pages.LoginPages;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  
	WebDriver driver;
	LoginPages lp = new LoginPages();
	LoginExcelData dp = new LoginExcelData();
	
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 lp.openBrowser();
	 lp.openLogin();
  }

  @Test (priority = 1)
  public void incorrectemail() throws InterruptedException {
	  lp.Login(dp.wrongEmail);
	  	String expectedErr = dp.GlobalErr;
	  	String actualErr = lp.readGlobalError();
	  	System.out.println(lp.readGlobalError());
	  	Assert.assertEquals(dp.GlobalErr, lp.readGlobalError());
  }
  
  @Test (priority = 2)
  public void emailwithspecialcharactor() throws InterruptedException {
	 lp.Login(dp.Emailwithspecialchar);
	  	String expectedErr = dp.GlobalErr;
	  	String actualErr = lp.readGlobalError();
	  	System.out.println(lp.readGlobalError());
	  	Assert.assertEquals(dp.GlobalErr, lp.readGlobalError());
  }
  
  @Test (priority = 3)
  public void noemail() throws InterruptedException {
	 lp.Login("");
	  	String expectedErr = dp.emptyemailErr;
	  	String actualErr = lp.noemailError();//driver.findElement(By.xpath("//div[@xpath = '1']")).getText();
	  	System.out.println(lp.noemailError());
	  	Assert.assertEquals(dp.emptyemailErr, lp.noemailError());
  }
  
  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }

}
