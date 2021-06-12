package com.cyient.nativeapptest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallAppTest {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		
		cap.setCapability("app", "C:\\Users\\pk59159\\Downloads\\Khan Academy_v6.3.0_apkpure.com.apk");
		
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Dismiss']").click();
		
		driver.findElementByXPath("//*[@text='Profile']").click();
		
		
		
		
		
	}

}
