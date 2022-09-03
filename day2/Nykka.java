package week4.day2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get(" https://www.nykaa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
		try {
			// TODO Auto-generated method stub
	        WebElement brandMouseHoover = driver.findElement(By.xpath("//a[text()='brands']"));
	        Actions builder=new Actions(driver);
	        builder.moveToElement(brandMouseHoover).perform();
	        WebElement brands = driver.findElement(By.id("brandSearchBox"));
	        brands.sendKeys("L'Oreal paris");
	        WebElement loreal = driver.findElement(By.xpath("(//a[contains(@href,'loreal-paris')])[1]"));
	        loreal.click();
	      String tittle = driver.getTitle();
	      System.out.println(tittle);
	        driver.findElement(By.id("filter-sort")).click();
	        driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	        driver.findElement(By.id("first-filter")).click();
	        driver.findElement(By.xpath("//span[text()='Hair']")).click();
	        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	        driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
	        driver.findElement(By.xpath("//span[text()='Concern']")).click();
	        driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	        boolean displayed = driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).isDisplayed();
	        if(displayed) {
	        	System.out.println("it is displayed");
	        }else {
	        	System.out.println("not displayed");
	        }
	        driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
	         Set<String> windowHandles = driver.getWindowHandles();
	         List<String> arrayList = new ArrayList<String>(windowHandles);
	         driver.switchTo().window(arrayList.get(1));
	         WebElement scrollDD = driver.findElement(By.xpath("//select[@title='SIZE']"));
	         Select dd = new Select(scrollDD);
	         dd.selectByVisibleText("175ml");
//	         System.out.println("before sleep");
//	         Thread.sleep(5000);
//	         System.out.println("after sleep");
//	         driver.findElement(By.xpath("//option[text()='360ml']")).click();
	         
		}catch(Exception e) {
			File sc = driver.getScreenshotAs(OutputType.FILE);
		}
		finally {
			driver.close()
		}
		
	}
}
