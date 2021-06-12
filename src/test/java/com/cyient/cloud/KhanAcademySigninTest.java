package com.cyient.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class KhanAcademySigninTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "praveenkumar_KEzht9");
	      caps.setCapability("browserstack.key", "Pf8YyHog9jYu7BQSzKbg");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://346263554457c672435e29c6bc929af49afe8b0e");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project--KhanAcademy");
	      caps.setCapability("build", "Java Android-khanAcademy");
	      caps.setCapability("name", "first_test-khanAcademy");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);
	        

	      /* Write your Custom code here */
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        
	        driver.findElementByXPath("//*[@text='Dismiss']").click();
			
			driver.findElementByXPath("//*[@text='Profile']").click();
			
			driver.findElementByXPath("//*[@text='Sign in']").click();
			
			driver.findElementByXPath("//*[@text='Enter an e-mail address or username']").click();
			driver.findElementByXPath("//*[@text='Enter an e-mail address or username']").sendKeys("praveen@gmail.com");
			driver.findElementByXPath("//*[@text='Password']").click();
			driver.findElementByXPath("//*[@text='Password']").sendKeys("12345");
			if(driver.isKeyboardShown()) 
			{
				driver.hideKeyboard();
			}
			
			driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();
			
			String InvalidMsg=driver.findElementByXPath("//*[@text='Invalid password']").getText();
			
			System.out.println(InvalidMsg);
	        
	        
	        
	      // Invoke driver.quit() after the test is done to indicate that the test is completed.
	      driver.quit();

	}

}
