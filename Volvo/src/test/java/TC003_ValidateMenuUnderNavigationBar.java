import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC003_ValidateMenuUnderNavigationBar {
	// Initialize required variables
	WebDriver driver;
	ArrayList menuNames = new ArrayList();
	ArrayList buyMenuNames = new ArrayList();
	ArrayList ownMenuNames = new ArrayList();
	ArrayList aboutVolvoMenuNames = new ArrayList();
	ArrayList exploreMenuNames = new ArrayList();
	ArrayList moreMenuNames = new ArrayList();
	
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
	if(blnIsAcceptDisplayed==true) {
		// Click Accept button
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
	}
	
	// Click Menu in navigation bar
	driver.findElement(By.xpath("//button[@id='sitenav-sidenav-toggle']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
	
	// Check if "Volvo" logo isDisplayed() under menu
	boolean blnIsVolvoLogoDisplayed = driver.findElement(By.xpath("//a[@aria-label='Volvo Homepage'][not(contains(@data-track-onclick,'eventLabel'))]")).isDisplayed();

	// Verify "Volvo" logo is displayed
	Assert.assertEquals(blnIsVolvoLogoDisplayed, true);
	System.out.println("=========== Is Volvo logo displayed under Menu:" + blnIsVolvoLogoDisplayed + "===========");
	
	// Add all menus
	menuNames.add("Buy");
	menuNames.add("Own");
	menuNames.add("About Volvo");
	menuNames.add("Explore");
	menuNames.add("More");
    
	// Get count of Menus
	List<WebElement> lstCountOfMenus = driver.findElements(By.xpath("//button[@data-autoid='nav:sideNavLinksMenuDrawer']"));
	System.out.println("===== Count of menus: [" + lstCountOfMenus.size() + "] ======");

	// Check Menus are displayed
	veriyMenus(menuNames, lstCountOfMenus);
	
	// Click "Buy" Menu 
	driver.findElement(By.xpath("//em[normalize-space()='Buy']/parent::button")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
	
	// Add all Buy menus names
	buyMenuNames.add("Car Configurator");
	buyMenuNames.add("Fleet sales");
	buyMenuNames.add("Used cars");
	buyMenuNames.add("Diplomatic sales");
	buyMenuNames.add("Child seats");
	
	// Get count of Buy sub menus
	List<WebElement> lstCountOfBuySubMenus = driver.findElements(By.xpath("//p[text()='Buy']//following::a[@data-autoid='nav:sideNavLinksMenuItem']"));
	System.out.println("===== Count of Buy sub menus: [" + lstCountOfBuySubMenus.size() + "] ======");

	// Check "Buy" sub menus are displayed
	veriyMenus(buyMenuNames, lstCountOfBuySubMenus);

	// Click back button
	driver.findElement(By.xpath("//button[@aria-label='Go back in Site Navigation']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
	
	// Click "Own" Menu 
	driver.findElement(By.xpath("//em[normalize-space()='Own']/parent::button")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load

	// Add all Own sub menu names
	ownMenuNames.add("Support");
	ownMenuNames.add("Service & Repair");
	ownMenuNames.add("Accessories");
	ownMenuNames.add("Volvo Recall");
	ownMenuNames.add("Volvo experience");
	ownMenuNames.add("Volvo Cars app");
	ownMenuNames.add("EU emission tests");
    
	// Get Own sub menu names
	List<WebElement> lstCountOfOwnSubMenus = driver.findElements(By.xpath("//p[text()='Own']//following::a[@data-autoid='nav:sideNavLinksMenuItem']"));
	System.out.println("===== Count of Own sub menus: [" + lstCountOfOwnSubMenus.size()	+ "] ======");
    
	// Check "Own" sub menus are displayed
	veriyMenus(ownMenuNames, lstCountOfOwnSubMenus);
    
    // Click back button
 	driver.findElement(By.xpath("//button[@aria-label='Go back in Site Navigation']")).click();
 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
 	
 	// Click "About Volvo" Menu 
 	driver.findElement(By.xpath("//em[normalize-space()='About Volvo']/parent::button")).click();
 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load

 	// Add all About Volvo sub menu names
 	aboutVolvoMenuNames.add("Our story");
 	aboutVolvoMenuNames.add("Sustainability");
 	aboutVolvoMenuNames.add("Safety");
 	aboutVolvoMenuNames.add("Our news");
 	aboutVolvoMenuNames.add("Careers");
 	aboutVolvoMenuNames.add("Investors");
 	aboutVolvoMenuNames.add("Suppliers");
 	aboutVolvoMenuNames.add("Awards");
 	aboutVolvoMenuNames.add("Experience Volvo Cars");
     
 	// Get Own sub menu names
 	List<WebElement> lstCountOfABoutVolvoSubMenus = driver.findElements(By.xpath("//p[text()='About Volvo']//following::a[@data-autoid='nav:sideNavLinksMenuItem']"));
 	System.out.println("===== Count of About Volvo sub menus: [" + lstCountOfABoutVolvoSubMenus.size()	+ "] ======");
     
 	// Check "Own" sub menus are displayed
 	veriyMenus(aboutVolvoMenuNames, lstCountOfABoutVolvoSubMenus);
    
    // Click back button
 	driver.findElement(By.xpath("//button[@aria-label='Go back in Site Navigation']")).click();
 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
 	
 	// Click "Explore" Menu 
 	driver.findElement(By.xpath("//em[normalize-space()='Explore']/parent::button")).click();
 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load

 	// Add all explore sub menu names
 	exploreMenuNames.add("Recharge");
 	exploreMenuNames.add("Concepts");
 	exploreMenuNames.add("Electric cars");
 	exploreMenuNames.add("Armoured cars");
     
 	// Get Explore sub menu names
 	List<WebElement> lstCountOfExploreSubMenus = driver.findElements(By.xpath("//p[text()='Explore']//following::a[@data-autoid='nav:sideNavLinksMenuItem']"));
 	System.out.println("===== Count of Explore sub menus: [" + lstCountOfExploreSubMenus.size()	+ "] ======");
     
 	// Check "Explore" sub menus are displayed
 	veriyMenus(exploreMenuNames, lstCountOfExploreSubMenus);
     
     // Click back button
  	driver.findElement(By.xpath("//button[@aria-label='Go back in Site Navigation']")).click();
  	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
  	
  	// Click "About Volvo" Menu 
  	driver.findElement(By.xpath("//em[normalize-space()='More']/parent::button")).click();
  	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
	
    // Add all More sub menu names
  	moreMenuNames.add("Company");
  	moreMenuNames.add("Contact Us");
  	moreMenuNames.add("Careers");
  	moreMenuNames.add("Media/Press");
  	moreMenuNames.add("Lifestyle Collection");
  	moreMenuNames.add("Investor Relations");
  	moreMenuNames.add("Military Sales");
      
  	// Get More sub menu names
  	List<WebElement> lstCountOfMoreSubMenus = driver.findElements(By.xpath("//p[text()='More']//following::a[@data-autoid='nav:sideNavLinksMenuItem']"));
  	System.out.println("===== Count of More sub menus: [" + lstCountOfMoreSubMenus.size()	+ "] ======");
      
  	// Check "More" sub menus are displayed
  	veriyMenus(moreMenuNames, lstCountOfMoreSubMenus);
	
    // Click Close button
 	driver.findElement(By.xpath("//button[@data-autoid='nav:siteNavCloseIcon']")).click();
 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
 	
	driver.quit();
	
  }
    
   // Method to verify all Menus and sub menus are displayed
	public void veriyMenus(List<String> menuName, List<WebElement> countOfSubMenus) {
        
		// Iterate until all menus are verified
	    for (int i = 0; i < countOfSubMenus.size(); i++) {

			// Check if Menu is displayed
			boolean blnIsMenuDisplayed = driver.findElement(By.xpath("//em[normalize-space()='" + menuName.get(i).toString() + "']")).isDisplayed();
	
			// Verify if Menu is displayed
			Assert.assertEquals(blnIsMenuDisplayed, true);
			System.out.println("=========== Is " + menuName.get(i).toString() + " displayed under Menu:" + blnIsMenuDisplayed + "===========");
	    }
	}
 
}
