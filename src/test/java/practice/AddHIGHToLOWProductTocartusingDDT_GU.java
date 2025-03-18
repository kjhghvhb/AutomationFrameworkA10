package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUilities.FileUtility;
import GenericUilities.JavaUtility;
import GenericUilities.seleniumUtility;
import ObjectRepository.LoginPagee;

public class AddHIGHToLOWProductTocartusingDDT_GU  {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileUtility FUtil=new FileUtility();
		seleniumUtility SUtil=new seleniumUtility();
		JavaUtility JUtil=new JavaUtility();
		
		//read the data into property file -common data
		String URL = FUtil.readDataFromPropertyFile("url");
		String USERNAME = FUtil.readDataFromPropertyFile("username");
		String PASSWORD = FUtil.readDataFromPropertyFile("password");

		//read the data into Excel file 
		String SORTOPTION = FUtil.readDataFromExcelFile("Sheet1", 1,2);
		String PRODUCTNAME = FUtil.readDataFromExcelFile("Sheet1",1,3);
		System.out.println(PRODUCTNAME);

		// Launch the browser
		WebDriver driver = new ChromeDriver();
		SUtil.maximizewindow(driver);
		SUtil.Implicitwait(driver);

		// Load the Application
		driver.get(URL);

		// Login to Application
	//	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	//	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	//	driver.findElement(By.name("login-button")).click();
		
		LoginPagee lp=new LoginPagee(driver);
	//	lp.getUsernameEdt().sendKeys(USERNAME);
	//	lp.getPasswordEdt().sendKeys(PASSWORD);
	//	lp.getLoginBuEdt().click();
		lp.LoginApp1(USERNAME, PASSWORD);

		// Sort the page for lowest Price
		WebElement prodSort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		
		SUtil.handleDropdown(prodSort,SORTOPTION);
		//Select sel = new Select(prodSort);
		//sel.selectByVisibleText(SORTOPTION);

		Thread.sleep(1000);

		// Click on the Highest price Product
		WebElement Product = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String productToBeAdded = Product.getText();
		Product.click();

		// Add the product To Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate To Cart and Validate
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productToBeAdded.equals(productInCart)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		} else {
			System.out.println("FAILS");
		}

		// Logout of Application
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();

	}



	}


