import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC004_ValidateSafetyFeatures {
	WebDriver driver;
  @Test
  public void f() {
	// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

	// Initialize web driver
	driver = new ChromeDriver();

	// To navigate to volvo URL
	driver.get("https://www.volvocars.com/intl/v/car-safety/a-million-more");

	// To Maximize the browser
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load

	// Check if Accept isDisplayed() in Main page
	boolean blnIsAcceptDisplayed = driver.findElement(By.xpath("//button[text()='Accept']")).isDisplayed();

	// If Accept button is displayed click. Else skip
	if (blnIsAcceptDisplayed == true) {
		// Click Accept button
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
	}
	
	// Check if Safety feature Header isDisplayed()
	boolean blnIsSafetyFeatureHeaderDisplayed = driver.findElement(By.xpath("//div[@data-component='TextStatement']//p")).isDisplayed();

	// Verify Safety feature Header isDisplayed()
	Assert.assertEquals(blnIsSafetyFeatureHeaderDisplayed, true);
	System.out.println("=========== Is safety feature header is displayed:" + blnIsSafetyFeatureHeaderDisplayed + "===========");
	
	// Initialize required variables
	ArrayList arrSafetyFeatures = new ArrayList();
	
	// Add all Buy menus names
	arrSafetyFeatures.add("Speed cap");
	arrSafetyFeatures.add("Highway pilot");
	arrSafetyFeatures.add("Driver monitoring cameras");
	arrSafetyFeatures.add("Care Key");
	
	// Iterate until all safety features are verified
    for (int i = 0; i < arrSafetyFeatures.size(); i++) {

		// Check if safety feature is displayed
		boolean blnIsSafetyFeatureDisplayed = driver.findElement(By.xpath("//div[@data-autoid='IconTextItem:text']//preceding::em[text()='"+ arrSafetyFeatures.get(i).toString() +"']")).isDisplayed();

		// Verify if Menu is displayed
		Assert.assertEquals(blnIsSafetyFeatureDisplayed, true);
		System.out.println("=========== Is " + arrSafetyFeatures.get(i).toString() + " displayed under Menu:" + blnIsSafetyFeatureDisplayed + "===========");
    }
    
    // Check if more car safety features link is displayed
 	boolean blnMoreCarSafetyFeatureIsDisplayed = driver.findElement(By.xpath("//a[@data-autoid='iconCallouts:cta']")).isDisplayed();
 	
 	// Verify  more car safety features link is displayed
 	Assert.assertEquals(blnMoreCarSafetyFeatureIsDisplayed, true);
 	System.out.println("===========  More car saftey features link is displayed:" + blnMoreCarSafetyFeatureIsDisplayed + "===========");
    
	driver.quit();
	
  }
}
