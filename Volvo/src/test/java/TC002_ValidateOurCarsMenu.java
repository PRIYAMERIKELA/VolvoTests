import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC002_ValidateOurCarsMenu {
	// Initialize required variables
	ArrayList arrCrossOverModelUnderElectricCars = new ArrayList();
	ArrayList arrSUVsModelUnderElectricCars = new ArrayList();
	ArrayList arrSUVsModelCarsUnderHybrids = new ArrayList();
	ArrayList arrEstatesModelCarsUnderHybrids = new ArrayList();
	ArrayList arrSedansModelCarsUnderHybrids = new ArrayList();
	ArrayList arrSUVsModelCarsUnderMildHybrids = new ArrayList();
	ArrayList arrEstatesModelCarsUnderMildHybrid = new ArrayList();
	ArrayList arrSedansModelCarsUnderMildHybrid = new ArrayList();
	String strCrossOverModelUnderElectricCars = "Cross Over";
	String strSUVsModelUnderElectricCars = "SUVs of Electric Cars";
	String strSUVsModelCarsUnderHybrids = "SUVs of Hybrid";
	String strEstatesModelCarsUnderHybrids = "Estaes of Hybrid";
	String strSedansModelCarsUnderHybrids = "Sedans of Hybrid";
	String strSUVsModelCarsUnderMildHybrids = "SUVs of Mild Hybrid";
	String strEstatesModelCarsUnderMildHybrid = "Estaes of Mild Hybrid";
	String strSedansModelCarsUnderMildHybrid = "Sedans of Hybrid";
	
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
	if (blnIsAcceptDisplayed == true) {
		// Click Accept button
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
	}

	// Click "Our Cars" menu
	driver.findElement(By.xpath("//button[@id='nav:topNavCarMenu']")).click();

	// Get "Electric" sub menu 
	String strFirstSubMenuActualVaue = driver.findElement(By.xpath("//button[contains(@aria-controls,'panel-0')]/h2")).getText();
    String strFirstSubMenuExpectedValue = "Electric";
    
	// Verify "Electric" sub menu is displayed
	Assert.assertEquals(strFirstSubMenuActualVaue, strFirstSubMenuExpectedValue);
	
	// Get "Hybrids" sub menu 
	String strSecondSubMenuActualVaue = driver.findElement(By.xpath("//button[contains(@aria-controls,'panel-1')]/h2")).getText();
	String strSecondSubMenuExpectedValue = "Hybrids";

	// Verify "Hybrids" sub menu is displayed
	Assert.assertEquals(strSecondSubMenuActualVaue, strSecondSubMenuExpectedValue);

	// Get "Mild hybrids" sub menu
	String strThirdSubMenuActualVaue = driver.findElement(By.xpath("//button[contains(@aria-controls,'panel-2')]/h2")).getText();
	String strThirdSubMenuExpectedValue = "Mild hybrids";

	// Verify "Electric" sub menu is displayed
	Assert.assertEquals(strThirdSubMenuActualVaue, strThirdSubMenuExpectedValue);
	
	// Click Electric sub menu
	driver.findElement(By.xpath("//button[contains(@aria-controls,'panel-0')]")).click();
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);// Wait until the web page is load
	
	// To verify if "Cross over" model isDisplayed() in Electric sub menu page
	boolean blnCrossOverModelUnderElecticIsDisplayed = driver.findElement(By.xpath("//div[normalize-space()='Crossover']")).isDisplayed();

	// Verify "Cross over" model is displayed
	Assert.assertEquals(blnCrossOverModelUnderElecticIsDisplayed, true);
	System.out.println("=========== Cross over is displayed in electirc Sub menu:" + blnCrossOverModelUnderElecticIsDisplayed + "===========");
	
	// Get count of cars present under Cross over under electric cars model
	List<WebElement> lstCountOfCrossOverModelUnderElectricCars = driver.findElements(By.xpath("//div[contains(@id,'panel-0')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-lb')]//em"));
	System.out.println("===== Count of cars present under cross over model: ["+ lstCountOfCrossOverModelUnderElectricCars.size() +"] ======");
	
	// Get Cars list
	getCarsList(lstCountOfCrossOverModelUnderElectricCars, strCrossOverModelUnderElectricCars, arrCrossOverModelUnderElectricCars);
 
	// To verify if "SUVs" model isDisplayed() in Electric sub menu page
	boolean blnSUVsUnderElectricModelIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-0')]//a[text()='SUVs']")).isDisplayed();
	
	// Verify "SUVs" model is displayed
	Assert.assertEquals(blnSUVsUnderElectricModelIsDisplayed, true);
	System.out.println("=========== SUVs model is displayed in electirc Sub menu:" + blnSUVsUnderElectricModelIsDisplayed + "===========");
	
	// Get count of cars present in SUVs under Electric model
	List<WebElement> lstCountOfSUVsUnderElectricModelCars = driver.findElements(By.xpath("//div[contains(@id,'panel-0')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-lz')]//em"));
	System.out.println("===== Count of cars present under SUVs model: [" + lstCountOfSUVsUnderElectricModelCars.size() + "] ======");

	// Get Cars list
	getCarsList(lstCountOfSUVsUnderElectricModelCars, strSUVsModelUnderElectricCars, arrSUVsModelUnderElectricCars);
	
	// Click Hybrid sub menu
	driver.findElement(By.xpath("//button[contains(@aria-controls,'panel-1')]")).click();
	
	// To verify if "SUVs" model isDisplayed() in Hybrids sub menu page
	boolean blnSUVsHybridsModelIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-1')]//a[text()='SUVs']")).isDisplayed();

	// Verify "SUVs" model is displayed under Hybrids sub menu
	Assert.assertEquals(blnSUVsHybridsModelIsDisplayed, true);
	System.out.println("=========== SUVs model is displayed in hybrids Sub menu:" + blnSUVsHybridsModelIsDisplayed + "===========");

	// Get count of cars present under SUVs model in Hybrids sub menu
	List<WebElement> lstCountOfSUVsModelCarsUnderHybrids = driver.findElements(By.xpath("//div[contains(@id,'panel-1')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-lb')]//em"));
	System.out.println("===== Count of cars present under SUVs model: [" + lstCountOfSUVsModelCarsUnderHybrids.size() + "] ======");

	// Get Cars list
	getCarsList(lstCountOfSUVsModelCarsUnderHybrids, strSUVsModelCarsUnderHybrids, arrSUVsModelCarsUnderHybrids);
	
	// To verify if "Estates" model isDisplayed() in Hybrids sub menu page
	boolean blnEstatesModelIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-1')]//a[text()='Estates']")).isDisplayed();

	// Verify "Estates" model is displayed under Hybrids sub menu
	Assert.assertEquals(blnEstatesModelIsDisplayed, true);
	System.out.println("=========== Estates model is displayed in hybrids Sub menu:" + blnEstatesModelIsDisplayed + "===========");

	// Get count of cars present under Estates model in Hybrids sub menu
	List<WebElement> lstCountOfEstatesModelCarsUnderHybrids = driver.findElements(By.xpath("//div[contains(@id,'panel-1')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-lz')]//em"));
	System.out.println("===== Count of cars present under Estates model: [" + lstCountOfEstatesModelCarsUnderHybrids.size()	+ "] ======");

	// Get Cars list
	getCarsList(lstCountOfEstatesModelCarsUnderHybrids, strEstatesModelCarsUnderHybrids, arrEstatesModelCarsUnderHybrids);
    
	// To verify if "Sedans" model isDisplayed() in Hybrids sub menu page
	boolean blnSedansModelIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-1')]//a[text()='Sedans']")).isDisplayed();

	// Verify "Sedans" model is displayed under Hybrids sub menu
	Assert.assertEquals(blnSedansModelIsDisplayed, true);
	System.out.println("=========== Estates model is displayed in hybrids Sub menu:" + blnSedansModelIsDisplayed + "===========");

	// Get count of cars present under Sedans model in Hybrids sub menu
	List<WebElement> lstCountOfSedansModelCarsUnderHybrids = driver.findElements(By.xpath("//div[contains(@id,'panel-1')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-og')]//em"));
	System.out.println("===== Count of cars present under Estates model: ["+ lstCountOfSedansModelCarsUnderHybrids.size() + "] ======");

	// Get Cars list
	getCarsList(lstCountOfSedansModelCarsUnderHybrids, strSedansModelCarsUnderHybrids, arrSedansModelCarsUnderHybrids);
		
	// Click Mild hybrid sub menu
	driver.findElement(By.xpath("//button[contains(@aria-controls,'panel-2')]")).click();
	
	// To verify if "SUVs" model isDisplayed() in Hybrids sub menu page
	boolean blnSUVsMildHybridsModelIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-2')]//a[text()='SUVs']")).isDisplayed();

	// Verify "SUVs" model is displayed under Hybrids sub menu
	Assert.assertEquals(blnSUVsHybridsModelIsDisplayed, true);
	System.out.println("=========== SUVs model is displayed in hybrids Sub menu:" + blnSUVsMildHybridsModelIsDisplayed + "===========");

	// Get count of cars present under SUVs model in Hybrids sub menu
	List<WebElement> lstCountOfSUVsModelCarsUnderMildHybrids = driver.findElements(By.xpath("//div[contains(@id,'panel-2')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-lb')]//em"));
	System.out.println("===== Count of cars present under SUVs model: [" + lstCountOfSUVsModelCarsUnderMildHybrids.size() + "] ======");

	// Get Cars list
	getCarsList(lstCountOfSUVsModelCarsUnderMildHybrids, strSUVsModelCarsUnderMildHybrids, arrSUVsModelCarsUnderMildHybrids);
	
	// To verify if "Estates" model isDisplayed() in Mild Hybrid sub menu page
	boolean blnEstatesModelUnderMildHybridIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-2')]//a[text()='Estates']")).isDisplayed();

	// Verify "Estates" model is displayed under Mild Hybrid sub menu
	Assert.assertEquals(blnEstatesModelUnderMildHybridIsDisplayed, true);
	System.out.println("=========== Estates model is displayed in mild hybrid Sub menu:" + blnEstatesModelUnderMildHybridIsDisplayed + "===========");

	// Get count of cars present under Estates model in Mild Hybrid sub menu
	List<WebElement> lstCountOfEstatesModelCarsUnderMildHybrid = driver.findElements(By.xpath("//div[contains(@id,'panel-2')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-lz')]//em"));
	System.out.println("===== Count of cars present under Estates model: [" + lstCountOfEstatesModelCarsUnderMildHybrid.size()	+ "] ======");

	// Get Cars list
	getCarsList(lstCountOfEstatesModelCarsUnderMildHybrid, strEstatesModelCarsUnderMildHybrid, arrEstatesModelCarsUnderMildHybrid);
    
	// To verify if "Sedans" model isDisplayed() in Hybrids sub menu page
	boolean blnSedansModelUnderMildHybridIsDisplayed = driver.findElement(By.xpath("//div[@role='tabpanel' and contains(@id,'panel-2')]//a[text()='Sedans']")).isDisplayed();

	// Verify "Sedans" model is displayed under Hybrids sub menu
	Assert.assertEquals(blnSedansModelUnderMildHybridIsDisplayed, true);
	System.out.println("=========== Estates model is displayed in hybrids Sub menu:" + blnSedansModelUnderMildHybridIsDisplayed + "===========");

	// Get count of cars present under Sedans model in Hybrids sub menu
	List<WebElement> lstCountOfSedansModelCarsUnderMildHybrid = driver.findElements(By.xpath("//div[contains(@id,'panel-2')]//h4/following-sibling::div[@role='listitem'][contains(@class,'SN-og')]//em"));
	System.out.println("===== Count of cars present under Estates model: ["+ lstCountOfSedansModelCarsUnderMildHybrid.size() + "] ======");

	// Get Cars list
	getCarsList(lstCountOfSedansModelCarsUnderMildHybrid, strSedansModelCarsUnderMildHybrid, arrSedansModelCarsUnderMildHybrid);
	
	// Click Close button
	driver.findElement(By.xpath("//button[@data-autoid='nav:carMenuCloseIcon']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);// Wait until the web page is load
	
	// To close the browser
	driver.quit();
  }
  
  public static void getCarsList (List<WebElement> count, String carModel, ArrayList<String> cars ) {
		for (WebElement carNames: count) {
			String carModelName = carNames.getAttribute("innerText").toString();
			System.out.println("===== Car name : [" + carModelName + "] ======");
			cars.add(carModelName);
			System.out.println("===== Car names of ["+ carModel +"] is : [" + carModelName + "]======");
		}	  
}

}