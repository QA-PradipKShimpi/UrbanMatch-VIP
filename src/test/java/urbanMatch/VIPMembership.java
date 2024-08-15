package urbanMatch;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VIPMembership 
{
	WebDriver driver;
	
	@BeforeTest
	public void browserSetup() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.urbanmatch.in/");
	}
	
	@Test(priority=1)
	public void verifyVIPMembership() 
	{
		driver.findElement(By.xpath("//a[text()='Apply for VIP membership']")).click();
		
		String homePage = driver.getWindowHandle();
		System.out.println("HomePage id is: "+homePage);
		
		Set<String>newWindow=driver.getWindowHandles();
		System.out.println("NewTab id is: "+newWindow);
		
		for(String i:newWindow) 
		{
			if(!homePage.equals(i)) 
			{
				driver.switchTo().window(i);	// switch to new window	
			}
			
		}
		
		System.out.println("I am on a new window");
		
		List<WebElement>text=driver.findElements(By.xpath("//p[@class='TextWrapper-sc-__sc-1f8vz90-0 dMhmrl']"));
		
		for(WebElement i:text) 
		{
			System.out.println("text is: "+i.getText());
		}
		
		driver.findElement(By.xpath("//button[@data-qa='start-button']")).click();
	}
	
	@Test(priority=2)
	public void verifyStart() 
	{
		System.out.println("hii");
		
	}
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
