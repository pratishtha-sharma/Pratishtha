package Stream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Stream1 {
	
	static WebDriver driver;
	
	@BeforeTest
	public static void browser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
	}
	
	@Test
	public static String getVegetablePrice(WebElement s) {
		
		String pricevalue = driver.findElement(By.xpath("//tr//td[2]")).getText();
		
		return pricevalue;
		
	}
	
	@Test
	public static void stream() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click on the column
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//getting all the elements in list
	    //List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));
		
		//getting text without for loop using stream
//		List<String> actualList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
//		
//		//for printing the above stream we use for each
//		//elementsList.stream().map(s->s.getText()).collect(Collectors.toList()).forEach(s->System.out.println(s));
//		
//		//sorted list
//		List<String> sortedList = actualList.stream().sorted().collect(Collectors.toList());
//		
//		Assert.assertTrue(actualList.equals(sortedList), "Passed");
//		
		//Pagination
	    
	   List<String> price;
		do {
			 List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]")); //define elementsList inside loop as when page is changed the list value changes
		price = elementsList.stream().filter(s->s.getText().contains("Guava")).map(s->getVegetablePrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
	    }while(price.size()<1);
				
	}
	


}
