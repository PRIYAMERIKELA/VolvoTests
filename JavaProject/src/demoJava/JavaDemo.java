package demoJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
	
		Thread.sleep(100);		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a//span[text()='Computers & Gaming']")));
		action.build().perform();
		Thread.sleep(10);
		
		driver.findElement(By.xpath("(//div[contains(@class,'leftNavigationRightBlock')]//p//span[text()='View All'])[4]")).click();
		Thread.sleep(1000);
		
		WebElement fromPrice = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromPrice.click();
		fromPrice.clear();
		fromPrice.sendKeys("20000");
		
		WebElement toPrice = driver.findElement(By.xpath("//input[@name='toVal']"));
		toPrice.click();
		toPrice.clear();
		toPrice.sendKeys("70000");
		
		driver.findElement(By.xpath("//div[normalize-space()='GO']")).click();
		Thread.sleep(1000);
		
		List<WebElement> countOfLaptopsDescription = driver.findElements(By.xpath("//p[normalize-space(@class)='product-title']"));
		System.out.println("===== Count of laptops description: ["+ countOfLaptopsDescription.size() +"] ======");
		
		List<WebElement> countOfLaptopsPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println("===== Count of laptops Price: ["+ countOfLaptopsPrice.size() +"] ======");
		
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		ArrayList laptopDescription = new ArrayList();
		ArrayList laptopPrice = new ArrayList();
		
		for(WebElement laptops: countOfLaptopsDescription){
			String laptopsDescription = laptops.getAttribute("title").toString();
			System.out.println("===== laptops descriprtion : ["+ laptopsDescription +"] ======");
			laptopDescription.add(laptopsDescription);
		}
		
		for(WebElement laptops: countOfLaptopsPrice){
			String laptopsPrice = laptops.getText().toString();
			System.out.println("===== laptops Price : ["+ laptopsPrice +"] ======");
			laptopPrice.add(laptopsPrice);
		}
		
		map.put(laptopDescription, laptopPrice);
		
		System.out.println("==========="+map+"===========");
		System.out.println("==========="+map.put(laptopDescription, laptopPrice)+"=========");
		
		driver.quit();	
		//String[] myStringArray = new String[]{"Buy", "Own", "c"};
	}

}

