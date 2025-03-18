package GenericUilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.Inventorypage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public FileUtility fuTil=new FileUtility();
	public seleniumUtility suTil=new seleniumUtility();
	public JavaUtility juTil=new JavaUtility();
	//for Listenrs
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public  void bSConfig()
	{
		System.out.println("database connect succfully");
	}
	//@Parameters("browser")
	//@BeforeTest
     @BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String Bvalue*/) throws IOException
	{
		String URL = fuTil.readDataFromPropertyFile("url");
		driver=new ChromeDriver();
		
		/*Cross Browser Execution*/
		/*if(Bvalue.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(Bvalue.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
	
		/*======================================*/
		
		suTil.maximizewindow(driver);
		suTil.Implicitwait(driver);
		driver.get(URL);
		System.out.println("Browser launch Succsfully");
		
		
		sdriver=driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bMConfig() throws IOException
	{
		String USERNAME = fuTil.readDataFromPropertyFile("username");
		String PASSWORD = fuTil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(USERNAME, PASSWORD);
		System.out.println("login to app Succsfully");	
	}

	@AfterMethod(alwaysRun=true)
	public void aMConfig()
	{
		Inventorypage ip=new Inventorypage(driver);
		ip.logoutofApp();
		System.out.println("logout to app Succsfully");	
	}
	//@AfterTest
    @AfterClass(alwaysRun=true)
	public void aCConfig()
	{
		driver.quit();
		System.out.println("browser closure Succsfully");	
	}
	@AfterSuite(alwaysRun=true)
	public void aSConfig()
	{
		System.out.println("database closure  Succsfully");	
	}
	
	
}
