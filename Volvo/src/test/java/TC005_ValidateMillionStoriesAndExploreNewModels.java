import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC005_ValidateMillionStoriesAndExploreNewModels {
  @Test
  public void f() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	    
		// Initialize web driver
		WebDriver driver = new ChromeDriver();
	    
		// To navigate to volvo URL
		driver.get("https://www.volvocars.com/intl/v/car-safety/a-million-more");
	    
		// To Maximize the browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
		
		// Check if Accept isDisplayed() in Main page
	    boolean blnIsAcceptDisplayed = driver.findElement(By.xpath("//button[text()='Accept']")).isDisplayed();

		// If Accept button is displayed click. Else skip
		if(blnIsAcceptDisplayed==true) {
			// Click Accept button
			driver.findElement(By.xpath("//button[text()='Accept']")).click();
		}

		// Check if One a Million header is displayed
		boolean blnIsOneAMillionIsDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='One of a million']")).isDisplayed();

		// Verify One a Million header is displayed
		Assert.assertEquals(blnIsOneAMillionIsDisplayed, true);
		System.out.println("=========== Is one a Million header displayed:" + blnIsOneAMillionIsDisplayed + "===========");
		
		// Check if Explore our new model header is displayed
		boolean blnIsExploreOurNewModelsHeaderDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='Explore our models']")).isDisplayed();

		// Verify Explore our new models header is displayed
		Assert.assertEquals(blnIsExploreOurNewModelsHeaderDisplayed, true);
		System.out.println("=========== Is Explore our new models header displayed:" + blnIsExploreOurNewModelsHeaderDisplayed + "===========");

		// Get status of Next button in Explore our new models
		String strStatusOfNextButton = driver.findElement(By.xpath("//button[@data-autoid='springCarouselNextButton']")).getAttribute("aria-disabled");
		
		// Verify Next button is enabled in Explore our new models
		Assert.assertEquals(Boolean.parseBoolean(strStatusOfNextButton), false);
		System.out.println("=========== Is Next button disabled:" + Boolean.parseBoolean(strStatusOfNextButton) + "===========");
	    
		// To close the browser
		driver.quit();
  }
}
