package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.reporters.jq.Main;

public class Baseclass
{
 public static void main(String[] args)
 {
	 WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Browser got Maximized", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//login to application
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Click on a product jacket
		
		String ProductTobeadded = driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).getText();
		driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).click();
		
		//add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//validate the product
		String productInCart = driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).getText();
		if(productInCart.contentEquals(ProductTobeadded))
		{
			System.out.println("pass");
			System.out.println(productInCart);
		}
		 
		else
		{
			System.out.println("Fail");
			
		}
		//logout application
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		}
}
    

