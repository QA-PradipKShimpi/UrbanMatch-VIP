package urbanMatch;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VIPMembership 
{
	WebDriver driver;	//Class object
	
	@BeforeTest
	public void browserSetup()  
	{
		
// Browser setup	
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	
// Maximise window	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); 

//launching url
		
		driver.get("https://www.urbanmatch.in/"); 
		System.out.println("WelCome to Home Page");
	}
	
	@Test(priority=1)
	public void verifyVIPMembership() throws Exception 
	{

//Clicking on VIP Membership button
		
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
		
		System.out.println("WelCome to VIP Membership Page");
		
// Fetching Application form text
		
		List<WebElement>text=driver.findElements(By.xpath("//p[@class='TextWrapper-sc-__sc-1f8vz90-0 dMhmrl']"));
		Thread.sleep(2000);
		
		for(WebElement t:text) 
		{
			System.out.println(t.getText());
		}
		
//Start
		Thread.sleep(2000);
		System.out.println("Let's get started...");
		driver.findElement(By.xpath("//button[@data-qa='start-button']")).click();
	}
	
	@Test(priority=2)
	public void verifyStart() throws Exception 
	{
		
// Name
		
		System.out.println("1) First off, what's your full name?: Pradip K Shimpi ");
		
		driver.findElement(By.xpath("//input[@placeholder='Type your answer here...']")).sendKeys("Pradip K Shimpi",Keys.ENTER);
	
// Gender	
		
		System.out.println("2) What's your gender?: Male");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-ref='fa9e73c7-b0d1-45be-96b8-accf1025c787']//ul//li[@aria-label='Male']")).click();
			
// Date of Birth	
		
		System.out.println("3) What's your date of birth? : 01/01/2000");
		
		driver.findElement(By.name("bday-day")).sendKeys("01",Keys.TAB);
		driver.findElement(By.name("bday-month")).sendKeys("01",Keys.TAB);
		driver.findElement(By.name("bday-year")).sendKeys("2000",Keys.ENTER);
	
// Mobile Number
		
		System.out.println("4) What's your mobile number?: 9284936836");	
		
		driver.findElement(By.name("tel")).sendKeys("9284936836",Keys.ENTER);
		
// Email	
		
		System.out.println("5) What's your email address?: pradipkshimpi@gmail.com");	
		
		driver.findElement(By.name("email")).sendKeys("pradipkshimpi@gmail.com",Keys.ENTER);
		
// Country
		
		System.out.println("6) In which city and country do you currently reside?: Pune, India");
				
		driver.findElement(By.xpath("//input[@placeholder='Type your answer here...']")).sendKeys("Pune, India",Keys.ENTER);
		
// Marital status		
		
		System.out.println("7) What's your marital status?: Never Married");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-ref='5da5c3b0-6a60-4ea2-9453-648ce923973a']//ul//li//div[@aria-label='Never Married']")).click();
	
// Occupation
		
		System.out.println("8) What is your business/occupation?: QA");		
		
		driver.findElement(By.xpath("//input[@placeholder='Type your answer here...' and @class='InputField-sc-__sc-26uh88-0 cDaslz']")).sendKeys("QA",Keys.ENTER);
	
// Parents name		
		
		System.out.println("9) What's your parent/parents name?: K Shimpi");	
		
		driver.findElement(By.xpath("//div//input[@class='InputField-sc-__sc-26uh88-0 cDaslz']")).sendKeys("K Shimpi",Keys.ENTER);
		
// Family Occupation
		
		System.out.println("10) What's your family business/occupation and company name?: Profession, Company Name Private Limited");			
		
		driver.findElement(By.xpath("//div[@class='InputWrapper-sc-__sc-26uh88-1 iApDbT']//input[@placeholder='Type your answer here...' and @class='InputField-sc-__sc-26uh88-0 cDaslz']")).sendKeys("urbanmatch Pvt Ltd",Keys.ENTER);
	
// Photo		
		
		System.out.println("11) Please upload recent photos of yourself.");	
		
		
		File uploadFile = new File("E:\\JavaCodingFiles\\eclipse-workspace\\UrbanMatchMavenProject\\src\\test\\1a.png");

	    WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
	    
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Navigate to next question' and @data-tracking='footer_arrow_down']")).click();
		
// Community
		
		Thread.sleep(3000);
		System.out.println("12) What's your community/caste?: Hindu");	
		
		driver.findElement(By.xpath("//div[@class='InputWrapper-sc-__sc-26uh88-1 iApDbT']//input[@placeholder='Type your answer here...' and @class='InputField-sc-__sc-26uh88-0 cDaslz']")).sendKeys("Hindu",Keys.ENTER);

// Settle down
		
		System.out.println("13) When are you looking to settle down?: Within a year");		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-ref='7027910f-6156-48d9-8d19-b42627e22636']//ul//li[@aria-label='Within a year']")).click();
		
// Social Media link
		
		System.out.println("14) Please provide links to your social media accounts: Linkedin");	
		
		driver.findElement(By.xpath("//div[@class='InputWrapper-sc-__sc-26uh88-1 iApDbT']//input[@placeholder='Type your answer here...' and @class='InputField-sc-__sc-26uh88-0 cDaslz']")).sendKeys("https://www.linkedin.com/in/pradip-k-shimpi-7b52b6232/",Keys.ENTER);
		
// Comment
		
		System.out.println("16) Is there anything else you would like to share with us?: Hello");
		
		driver.findElement(By.xpath("//div//textarea[@class='auto-size-text-area' and @placeholder='Type your answer here...']")).sendKeys("Hello");
		
// Submit
		
		System.out.println("Clicking on submit button");
		
		//driver.findElement(By.xpath("//button[@data-qa='submit-button deep-purple-submit-button']")).click();
		
	}
	
}
