package practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class voylla {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebElement product;
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.get("https://www.voylla.com/jewellery?sort=pop&utm_campaign=Campaign-050219-700-Brand&utm_source=Adwords-Search-Campaign-050219-700-Brand-Adgroup-050219-710-VoyllaExactMatch&utm_medium=Adgroup-050219-710-VoyllaExactMatch&gclid=Cj0KCQiAw_H-BRD-ARIsALQE_2NxPZGP8xSQ51LzWAqE5RQ5fmes0atwv5mKUU6I83_kRte9DKOnocYaAiF7EALw_wcB");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-name-text truncate']/span"));

		for(int i=0; i<productList.size(); i++) {

			String Text = productList.get(i).getText();
			System.out.println(Text);

			  //if(Text.equals("Bagh-E-Fiza Floral Motifs Necklace")) {  
				if(Text.equals("Moksha Tribal Hoop Earrings")) {
					driver.findElement(By.id("listing-prd-img1060618048")).click();
					System.out.println("****Coming out of the loop.****");
					break;
				}

		}

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentid = it.next();
		String childid1 = it.next();
		//String childid2 = it.next();
		driver.switchTo().window(childid1);

		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@id='buy-now-btn']")).click();  //click on buy now button
		Thread.sleep(3000);

		//click on place order button
		driver.findElement(By.xpath("//button[@class='place-order-hollow-btn sec-color cursor-pointer']")).click();

		//fill the form
		driver.findElement(By.id("addr-name")).sendKeys("Priya Sharma");
		driver.findElement(By.id("addr-phone")).sendKeys("9999977777");
		driver.findElement(By.id("addr-pincode")).sendKeys("302018");
		driver.findElement(By.id("addr-address")).sendKeys("90 B");
		driver.findElement(By.id("addr-house-no")).sendKeys("Ridhi Sidhi");
		driver.findElement(By.id("addr-landmark")).sendKeys("Near Ridhi Sidhi Sweets");
		driver.findElement(By.id("addr-email")).sendKeys("priya@mailinator.com");
		driver.findElement(By.id("save-addr-btn")).click();

		Thread.sleep(3000);

		//cash on delivery
		driver.findElement(By.xpath("//span[contains(text(),'Pay COD(Cash On Delivery)')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'NO')]")).click();







		//driver.quit();
	}

}
