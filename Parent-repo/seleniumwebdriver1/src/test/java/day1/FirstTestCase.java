package day1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS)	;
		
		driver.get("https://WWW.ebay.com");
		
		driver.findElement(By.id("gh-ac")).sendKeys("Book");
		
		driver.findElement(By.id("gh-btn")).click();	
			
                
     driver.findElement(By.xpath("//ul[@class='srp-results srp-list clearfix']/li[1]/div/div[2]/a")).click();
     
     String parent=driver.getWindowHandle();
     
     Set <String> windows = driver.getWindowHandles();
     
     Iterator <String> it = windows.iterator();
     
     while(it.hasNext())
     {
    	 
    	 String child_window = it.next();
     
     
     if (!parent.equals(child_window))
     {
    	 driver.switchTo().window(child_window);
    	 
    	 driver.findElement(By.xpath("//*[@id='atcBtn_btn_1']/span/span")).click();
    	 
    	 String cartno=driver.findElement(By.xpath("//*[@id='gh-cart-n']")).getText();
    	  
    	 if(Integer.parseInt(cartno)!=0) {
    		 
    		 System.out.println(cartno);
    	 }
    	 
    	 else {
    		 System.out.println("Cart No is not updated");
    		 
    	 }
    
    	     	 
     }
     
     }
               
        
    	
		  
	}

}

