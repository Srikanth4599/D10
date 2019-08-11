

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropHandling {

	WebDriver d;		
	@Test 
	public void sampleElement() throws Exception {
   	   
		//maximize the Window Automatically.
		d.manage().window().maximize();

		//Delete All cookies 
		d.manage().deleteAllCookies();

		//Handling DragAndDrop Actions.
	    //Create Actions class Object.

		d.get("http://jqueryui.com/droppable/");	
	
		//Switch to Frame If it is Present.
		d.switchTo().frame(0);
		
		Actions action=new Actions(d);
		
		//Go to Element and click on hold
		action.clickAndHold(d.findElement(By.xpath("//*[@id='draggable']")))
     	.moveToElement(d.findElement(By.xpath("//*[@id='droppable']")))
		.release()
		.build()
		.perform();
		
		System.out.println("Done");
		System.out.println("Done");
        Thread.sleep(3000);
        
	}

@BeforeTest
public void beforeTest() {
			//Launch the Firefox Browser.
		System.setProperty("webdriver.gecko.driver", "D:\\selenium driver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

@AfterTest
public void afterTest() throws InterruptedException {
	d.quit();
     }
  }
