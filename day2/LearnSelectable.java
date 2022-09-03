package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/selectable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame(0);
        WebElement element1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement element3= driver.findElement(By.xpath("//li[text()='Item 3']"));
        WebElement element5= driver.findElement(By.xpath("//li[text()='Item 5']"));
        WebElement element7= driver.findElement(By.xpath("//li[text()='Item 7']"));
        
        Actions builder = new Actions(driver);
       // builder.keyDown(Keys.CONTROL).click(element1).click(element3).click(element5).click(element7).keyUp(Keys.CONTROL).perform();
      builder.clickAndHold(element1).moveToElement(element5).release().perform(); 
    //  builder.keyDown(keys.)
	}

}
