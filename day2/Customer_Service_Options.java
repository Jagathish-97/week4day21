package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Customer_Service_Options {

	public static void main(String[] args) throws InterruptedException {
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
       WebElement elementLearning = dom.findElementByXPath("//span[text()='Products']");
       elementLearning.click();
       Thread.sleep(2000);
      WebElement elementServices = dom.findElementByXPath("//span[contains(text(),'Service')]");
      Actions builder = new Actions(driver);
      builder.moveToElement(elementServices).build().perform();
      WebElement elementCustomer = dom.findElementByXPath("//a[text()='Customer Service']");
      elementCustomer.click();
      //WebElement elementCustSer =dom.findElementByXPath("//a[text()='Customer Service']");
		//elementCustSer.click();
      String title = driver.getTitle();
      System.out.println(title);
      if(title.equals("Customer Service Tools from Service Cloud - Salesforce.com")){
    	  System.out.println("Customer Service Tools from Service Cloud - Salesforce.com - page Tiltle is verified");
	  }else {
		System.out.println("Customer Service Tools from Service Cloud - Salesforce.com - page title is wrong");
		System.exit(1);
	 }
     
      List<WebElement> customerServiceOptions= driver.findElements(By.xpath("//a[text()='Customer Service']/../ul/li"));
       customerServiceOptions.size();
     System.out.println(String.valueOf(customerServiceOptions.size()));
      for (WebElement we : customerServiceOptions) {
		System.out.println(we.findElement(By.tagName("a")).getText());
      }
	}
}
