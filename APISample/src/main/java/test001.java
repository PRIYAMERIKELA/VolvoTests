import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class test001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.volvocars.com/intl/v/car-safety/a-million-more");
		
		driver.manage().window().maximize();
		
		// to verify if an element is present on page with isDisplayed()
	    boolean logo = driver.findElement(By.xpath("//a[@aria-label=\"Volvo Homepage\" and @data-track-onclick]"))
	      .isDisplayed();
	    
	    Assert.assertEquals(logo, true);
	    
	    driver.close();
		
		
	}

}
