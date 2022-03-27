package demoJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TC001_TestMainPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
				
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://www.volvocars.com/intl/v/car-safety/a-million-more");
				
				driver.manage().window().maximize();
			
				Thread.sleep(100);		
				driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("20000");
				
				
//				System.out.println("==========="+map+"===========");
//				System.out.println("==========="+map.put(laptopDescription, laptopPrice)+"=========");
				
				driver.quit();	
	}

}
