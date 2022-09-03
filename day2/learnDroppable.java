package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class learnDroppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
		        driver.get("https://jqueryui.com/droppable/");
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		        driver.switchTo().frame(0);
		        WebElement element = driver.findElement(By.id("draggable"));
		        WebElement element2 = driver.findElement(By.id("droppable"));
		        Actions builder= new Actions(driver);
		        builder.dragAndDrop(element, element2).perform();

	}

}
