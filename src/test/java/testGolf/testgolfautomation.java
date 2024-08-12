package testGolf;



import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testgolfautomation {
	
	public static void main (String args[]) throws InterruptedException {
		
	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\ChromeDriver.exe");
       // Instantiate a ChromeDriver class.
	 //  ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	  //  WebDriver	driver = new ChromeDriver(options);
	   WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get("https://ogr.golfez.in/");

       WebElement ID = driver.findElement(By.id("txtUserName"));
       
       ID.sendKeys("8669600470");
       
       WebElement pass = driver.findElement(By.id("txtPassword"));
        
       pass.sendKeys("6Anstead7!");
       
       
       WebElement login = driver.findElement(By.id("btnLogin"));
       
       login.click();
       
       
       
       Thread.sleep(3000);

        WebElement dateBox = driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
     //  dateBox.click();

        //Fill date as mm/dd/yyyy as 09/25/2013
     //  
     
       dateBox.sendKeys(Keys.CONTROL + "a");
       dateBox.sendKeys(Keys.DELETE);
        
     dateBox.sendKeys("02-Aug-2024");
        
        
   //  dateBox.sendKeys(Keys.ENTER);
  //    dateBox.click();
       
      WebElement timeclick = driver.findElement(By.xpath("//h6[text()='Course Timing 06.20 AM - 06.30 PM']"));
      
      timeclick.click();
      
      Thread.sleep(2000);
      String[] times = {
              "6:04 AM", "6:12 AM", "6:20 AM", "6:28 AM", "6:36 AM", "6:44 AM",
              "6:52 AM", "7:00 AM", "7:08 AM", "7:16 AM", "7:24 AM", "7:32 AM",
              "7:40 AM", "7:48 AM"
          };
      // Replace with your actual locator strategy to find elements
    List<WebElement> elementsList = driver.findElements(By.xpath("//table[@id='tblTeeTime']//tr"));

    // List to store clickable elements
    List<WebElement> clickableElements = new ArrayList<>();
    boolean containsTime = false;
    // Iterate through each WebElement and check if it's clickable
    for (WebElement element : elementsList) {
        try {
            // Attempt to click on the element
            boolean containsAvailable = element.getText().contains("Available");
          

        	// System.out.println("Ni: " + element.getText());
            if(containsAvailable)
            {
            	try
            	{
            		for (String time : times) {
                        if (element.getText().contains(time)) {
                            containsTime = true;
                      	  System.out.println("Available Elements: " + element.getText());
                     	 // If no exception is thrown, element is  
                     		element.click();
                     	 clickableElements.add(element);
                            break; // Exit loop if one time is found
                        }
                    }
            		
            	if(containsTime)
            	 break;
            	
            	} catch(org.openqa.selenium.WebDriverException e)
            	{
            		
            	}
            	
            }
            // Perform additional actions if needed after clicking
            // For example, navigate to a new page or perform some verification
            // driver.navigate().to("https://example.com/newpage");

        } catch (org.openqa.selenium.WebDriverException e) {
            // Handle WebDriverException (e.g., element not interactable, element not found)
            System.out.println("Element not clickable: " + element.getText());
            // You can log the error or handle it as per your application's requirement
        }
    }

    // Print out the clickable elements (or perform further actions)
    for (WebElement clickableElement : clickableElements) {
        System.out.println("Clickable Element: " + clickableElement.getText());
    }
//
//      
//                WebElement Time = driver.findElement(By.xpath("//td[text()='6:36 AM']"));
//        
//        		Time.click();
    if(containsTime)
    {
        		Thread.sleep(3000);
        		String myWindowHandle = driver.getWindowHandle();
        		driver.switchTo().window(myWindowHandle);
                 WebElement selectmember = driver.findElement(By.id("select2-ddlMember-container"));
        		
                 selectmember.click();
       		
       		WebElement Member = driver.findElement(By.className("select2-search__field"));  		
//        		
        		Member.sendKeys("Sonali Mundkur (RE510)");
//        		
        		Member.sendKeys(Keys.ARROW_DOWN);
        		Member.sendKeys(Keys.ENTER);

       		WebElement Add = driver.findElement(By.id("btnAddMember"));
//        		
        		Add.click();
//        		
               WebElement cash = driver.findElement(By.id("redioCashCard"));
        		
        		cash.click();
//        		
//        		
              WebElement Payment = driver.findElement(By.id("btnSave"));
//        		
       	Payment.click();
        		
        		 // WebElement Makepayment = driver.findElement(By.xpath("//button[text()='Make Payment']"));
        	      
        		 // Makepayment.click();
    }
        	      
        		
        		
}
}