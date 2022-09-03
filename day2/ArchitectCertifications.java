package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
       driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
       String text = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']")).getText();
       System.out.println(text);
       List<WebElement> elementCertification1 = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
       int size = elementCertification1.size();
       System.out.println(size);
       for(int c=1;c<=size;c++) {
    	   String text2 = driver.findElement(By.xpath("(//div[@class='credentials-card ']//div[3]/a)["+c+"]")).getText();
    	   System.out.println(text2);
    	   }
       
    	 driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
    	 List<WebElement> elementCertification2 = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
         int size1 = elementCertification2.size();
         System.out.println(size1);
         for(int i=1;i<=size1;i++) {
      	   String text3 = driver.findElement(By.xpath("(//div[@class='credentials-card ']//div[3]/a)["+i+"]")).getText();
      	   System.out.println(text3);
    	
       
	}


	}
	}

