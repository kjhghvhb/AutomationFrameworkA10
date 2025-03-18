package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test
	public void simple()
	{
		System.out.println("hi");
	}
	
	@Test(priority=1,invocationCount=1)
	public void practical()
	{
		System.out.println("hello"); 
	}
	
	@Test(priority=-1,invocationCount=1)
	public void swaglabs()                   //testcase1
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Reporter.log("swaglabs can be executed",true);
		driver.quit();
	}
	@Test(priority=-2,invocationCount=1)
	public void cricbuzz()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		Reporter.log("criccbuzz got executed", true);
		driver.quit();
	}
	

	
	
	
	
	}

