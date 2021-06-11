package com.cyient.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//platformName--> Android
		//broswerName---> chrome
		//deviceName--> redmi
		
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "D:\\Component\\chromedriver.exe");
		
		// send DesiredCapabilities details to the appium server
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://magento.com/");
		
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='email']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("balaji0017@gmail.com");
		driver.findElement(By.xpath("//input[@ title='Password']")).click();
		driver.findElement(By.xpath("//input[@ title='Password']")).sendKeys("balaji@12345");
		driver.findElement(By.xpath("//div[@class='login-form__bottom']//button[@id='send2']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Log Out']")));
		
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		//String actualURL=driver.getCurrentUrl();
		//System.out.println(actualURL);
		
		driver.findElementByXPath("//a[text()='Log Out']").click();
		
		driver.quit();	
	
	}

}
