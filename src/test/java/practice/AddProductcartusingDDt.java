package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class AddProductcartusingDDt {

	public static void main(String[] args) throws IOException {
		
		//Read Required Data
		//propertyFile
		//open the doc in java readable format
		
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		
		// create file type object
		Properties prop=new Properties();
		
		//load the file input stream
		prop.load(fis);
		
		// to read data from property file
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//Read the data from excel sheet
		//Open the doc in java readable format
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Create a workbook
		Workbook wb=WorkbookFactory.create(fise);
		
		//Navigate to sheet
		Sheet sh = wb.getSheet("Products");
		
		//Navigate to Row
		 Row rw = sh.getRow(1);
		
		 //Navigate to cell
		 Cell cl = rw.getCell(2);
		 
		 //Capture the data inside the cell
		 String PRODUCTNAME = cl.getStringCellValue();
		 System.out.println(PRODUCTNAME);
		 
		// Launch the Browser
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			//login to application
			
			driver.get(URL);
			driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			driver.findElement(By.id("password")).sendKeys(PASSWORD);
			driver.findElement(By.id("login-button")).click();
			
			//Click on a product jacket
			
			String ProductTobeadded = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
			driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
			
			//add to cart
			driver.findElement(By.id("add-to-cart")).click();
			
			//navigate to cart
			driver.findElement(By.id("shopping_cart_container")).click();
			
			//validate the product
			String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
			if(productInCart.equals(ProductTobeadded))
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
			driver.close();
	}

}
