package InventoryTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUilities.BaseClass;
import GenericUilities.FileUtility;
import GenericUilities.seleniumUtility;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.Inventorypage;
import ObjectRepository.LoginPage;
import ObjectRepository.cartPage;

@Listeners(GenericUilities.ListenersImplementation.class)
public class AddPrpoductTocartTest extends BaseClass
{
	
	@Test(groups="SmokeSuite",retryAnalyzer =  GenericUilities.RetryAnalyserImplementation.class)
	public void tc_001_addproductToCart() throws IOException
	
	{
		//  seleniumUtility suTil=new seleniumUtility();
	//	  FileUtility fuTil=new FileUtility();
		   
	//	  String URL = fuTil.readDataFromPropertyFile("url");
	//	 String USERNAME = fuTil.readDataFromPropertyFile("username");
	//	 String PASSWORD = fuTil.readDataFromPropertyFile("password");
		 
		  String PRODUCTNAME = fuTil.readDataFromExcelFile("Products", 1, 2);
		  
		  //LAUNCH BROWSER
	//	  WebDriver driver=new ChromeDriver();
	//	  suTil.maximizewindow(driver);
	//	  suTil.Implicitwait(driver);
		  
		  //LOAD TO APP
	//	  driver.get(URL);
		  
		  //LOGIN TO APP
	//	  LoginPage lp=new LoginPage(driver);
	//	  lp.LoginApp(USERNAME, PASSWORD);
		  
		  //CLICK ON PRODUCT
		  Inventorypage ip=new Inventorypage(driver);
		  String ProductAdded = ip.ClickOnProduct(driver, PRODUCTNAME);
		  
		  //ADD PRODUCT TO CART
		  InventoryItemPage iip=new InventoryItemPage(driver);  
		  iip.ClickOnAddToCartbtn();
		  
		  //NAVIGATE TO CART
		  ip.ClickonCartContainer();
		   //Assert.fail();
		  
		  // VALIDATE IN THE CART PAGE
		  cartPage cp=new cartPage(driver);
		 String ProductIncart = cp.getItemName();
		 
		 // By using 2 Hard Assert methods  instead of using if else
		 
		Assert.assertEquals(ProductIncart, ProductAdded);//only 2 arguments actual data and expected data
		
		Assert.assertTrue(ProductIncart.equals(ProductAdded));//condition with single argument
		System.out.println(ProductIncart);
		 
		 
		 //LOGOUT
	//	 ip.logoutofApp();
	
	}
	@Test
	public void Preactise()
	{
		System.out.println("hellooooo");
	}
 
}

  

