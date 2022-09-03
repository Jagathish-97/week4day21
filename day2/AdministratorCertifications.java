package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // to sign in
        driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Password#123");
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral navButton newWindow uiButton']")).click();
        Set<String> windowHandle = driver.getWindowHandles();
        List<String> list = new ArrayList<String>(windowHandle);
       driver.switchTo().window(list.get(1));
       driver.findElement(By.xpath("//button[text()='Confirm']")).click();
       driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();
       Thread.sleep(2000);
       
       Shadow dom = new Shadow (driver);
       WebElement elementLearning = dom.findElementByXPath("//span[text()='Learning']");
       elementLearning.click();
       WebElement elementLearningOnTrial = dom.findElementByXPath("//span[text()='Learning on Trailhead']/parent::div");
       elementLearningOnTrial.click();
       WebElement elementCertification = dom.findElementByXPath("//a[text()='Salesforce Certification']");
     
      elementCertification.click();
      String title = driver.getTitle();
      if(title.contains("Certification-Administration Overview")) {
    	  System.out.println("landed on certificationpage");
    	 }else {
    		 System.out.println("wrongPage");
    	 }
     boolean displayed = driver.findElement(By.xpath("//a[text()='Administrator']/preceding::a[1]")).isDisplayed();
      
       if(displayed==true) {
    	   System.out.println("available");
       }else {
    	   System.out.println("not available");
       }
       driver.close();
        }

}
