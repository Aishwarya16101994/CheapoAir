package com.qa.cheapoair.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	WebDriver driver;
	
	@FindBy(xpath= "//a[@title = 'Sign In']")
	WebElement signin;
	
	@FindBy(xpath = "//input[@class = 'fs-block form-control pr-4']")
	WebElement email;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement next;
	
	@FindBy(xpath = "//div[@class = 'validation-error']")
	WebElement GlobalandnoemailErr;
	
	
	
	
	
	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\Users\\sbuddhe_aditya\\Desktop\\QA AUTOMATON\\Selenium_WorkSpace\\CheapoAir\\src\\com\\qa\\cheapoair\\configuration\\configuration.properties");
		Properties prop = new Properties();
		prop.load(f);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sbuddhe_aditya\\Desktop\\QA AUTOMATON\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sbuddhe_aditya\\Desktop\\QA AUTOMATON\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	PageFactory.initElements(driver, this);
	}
	
	public void openLogin() {
		driver.get("https://www.cheapoair.ca/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.quit();
	}

	public void Login(String a) throws InterruptedException {
		signin.click();
		  email.sendKeys(a);
		  next.click();
		  	Thread.sleep(3000);
	}
	public String readGlobalError () {
		String actualErr = GlobalandnoemailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String noemailError() {
		String actualErr = GlobalandnoemailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
