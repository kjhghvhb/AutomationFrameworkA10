package InventoryTest;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUilities.BaseClass;
import GenericUilities.FileUtility;
import GenericUilities.seleniumUtility;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.Inventorypage;
import ObjectRepository.LoginPage;
import ObjectRepository.cartPage;

public class AddlowestPriceTocart  extends BaseClass
{
	@Test(groups="RegressionSuite")
	public void tc_002_addlowestPriceProductTocart() throws IOException
	{
	
	 
	 // String PRODUCTNAME = fuTil.readDataFromExcelFile("Products", 1, 2);
	 String SORTOPTION = fuTil.readDataFromExcelFile("Products", 7, 2);
	 String PRODUCTNAME = fuTil.readDataFromExcelFile("Products", 7, 3);
	
	  //CLICK ON PRODUCT
	  Inventorypage ip=new Inventorypage(driver);
	  String ProductAdded = ip.ClickOnProduct(driver, PRODUCTNAME);
	  
	  //ADD PRODUCT TO CART
	  InventoryItemPage iip=new InventoryItemPage(driver);  
	  iip.ClickOnAddToCartbtn();
	  
	  //NAVIGATE TO CART
	  ip.ClickonCartContainer();
	//  Assert.fail();
	  
	  // VALIDATE IN THE CART PAGE
	  cartPage cp=new cartPage(driver);
	 String ProductIncart = cp.getItemName();
	 

	 
//   if(ProductIncart.equals(ProductAdded))
//      {
//	      System.out.println("PASS");
//	     System.out.println(ProductIncart);
//	    }
//    else
//       {
//        System.out.println("FAIL");
//       }
	 
    	Assert.assertEquals(ProductIncart, ProductAdded);//only 2 arguments actual data and expected data
		
		Assert.assertTrue(ProductIncart.equals(ProductAdded));//condition with single argument
		System.out.println(ProductIncart);
		
		
		
		System.out.println("poll scm is checking");
	 
	
	}


}
