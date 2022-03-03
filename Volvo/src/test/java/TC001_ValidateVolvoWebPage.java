import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class TC001_ValidateVolvoWebPage {
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

	// To verify if Volvo logo isDisplayed() in Main page
	boolean blnIsVolvoLogoIsDisplayed = driver.findElement(By.xpath("//a[@aria-label='Volvo Homepage' and @data-track-onclick]")).isDisplayed();
	
	// Verify "Volvo" logo is displayed
	Assert.assertEquals(blnIsVolvoLogoIsDisplayed, true);
	System.out.println("=========== Logo is displayed in Main page:" + blnIsVolvoLogoIsDisplayed + "===========");
	
	// To verify if Navigation menu "Our Cars" isDisplayed() in Main page
	boolean blnOurCarsIsDisplayed = driver.findElement(By.xpath("//button[@id='nav:topNavCarMenu']/em")).isDisplayed();

	// Verify "Our Cars" menu is displayed
	Assert.assertEquals(blnOurCarsIsDisplayed, true);
	System.out.println("=========== Our cars menu is displayed in Main page:" + blnOurCarsIsDisplayed + "===========");
	
	// To verify if "Menu" menu isDisplayed() in Main page
	boolean blnMenuIsDisplayed = driver.findElement(By.xpath("//button[@id='sitenav-sidenav-toggle']/em")).isDisplayed();

	// Verify "Menu" menu is displayed
	Assert.assertEquals(blnMenuIsDisplayed, true);
	System.out.println("=========== Menu is displayed in Main page:" + blnMenuIsDisplayed + "===========");
	
	// Click Volvo logo
	driver.findElement(By.xpath("//a[@aria-label='Volvo Homepage' and @data-track-onclick]")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load

	// Validate newly loaded page
	boolean blnIsNewPageIsLoaded = driver.findElement(By.xpath("//h1[text()='For every you.']")).isDisplayed();

	// Verify if new page is loaded and text is displayed
	Assert.assertEquals(blnIsNewPageIsLoaded, true);
	System.out.println("=========== Is New page loaded and text is displayed:" + blnIsNewPageIsLoaded + "===========");

	// Back to first page
	driver.navigate().back();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);// Wait until the web page is load

	// Check if Model intro displayed
	boolean blnIsMainIntroDisplayed = driver.findElement(By.xpath("//div[@data-component='ModelIntro']//h2[text()='Ideas that change the world are often the most controversial.']")).isDisplayed();

	// Verify Model Intro is displayed
	Assert.assertEquals(blnIsMainIntroDisplayed, true);
	System.out.println("=========== Is Modal Intro displayed:" + blnIsMainIntroDisplayed + "===========");

	// Scroll to Watch story
	WebElement element = driver.findElement(By.xpath("//button[text()='watch the story']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(element);
	actions.perform();

	// Click watch story
	driver.findElement(By.xpath("//button[text()='watch the story']")).click();
    
	// To close the browser
	driver.quit();
  }
}
