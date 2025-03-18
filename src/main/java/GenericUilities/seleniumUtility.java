package GenericUilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium tool
 * @author Lavanya.M
 */

public class seleniumUtility 
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicit wait of 10 seconds
	 * @param driver
	 */
	public void Implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will help to wait for 10 sec to be visibility
	 * @param driver
	 * @param element
	 */
	public void  elementTobevisibleexplicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will help to wait for 10 seconds for element to be Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * This method will help  DropDown by index
	 * @param element
	 * @param index
	 */
 public void handleDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
 /**
  * This method will help  DropDown by value
  * @param value
  * @param element
  */
 public void handleDropdown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
 /**
  * This method will help  DropDown by visibletext
  * @param element
  * @param visibleText
  */
 public void handleDropdown(WebElement element,String visibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
 /**
  * this method will help actions by move to element
  * @param driver
  * @param element
  */
 public void mouseOverAction(WebDriver driver,WebElement element)
	{
	 Actions act=new Actions(driver);
	 act.moveToElement(element).perform();
	}
 /**
  * this method will help actions by drag and drop
  * @param element
  * @param driver
  */
 
 public void DragandDrop(WebElement srcelement, WebElement Target,WebDriver driver)
	{
	 Actions act=new Actions(driver);
	 act.dragAndDrop(srcelement, Target).perform();
	}
 /**
  *  this method will help actions by doubleClick
  * @param element
  * @param driver
  */
 public void DoubleClick(WebElement element, WebDriver driver)
	{
	 Actions act=new Actions(driver);
	act.doubleClick(element).perform();
	}
 /**
  *  this method will help actions by contextClick
  * @param element
  * @param driver
  */
 public void ContextClick(WebElement element, WebDriver driver)
	{
	 Actions act=new Actions(driver);
	act.contextClick(element).perform();
	act.scrollToElement(element);
	}
 /**
  * This method will help to perform action on scroll to perticular web element
  * @param element
  * @param driver
  */
 public void ScrolltoElement(WebElement element, WebDriver driver)
	{
	 Actions act=new Actions(driver);
	 act.scrollToElement(element).perform();
	}
 /**
  * This method will help to perform frame based on index
  * @param element
  * @param driver
  */
 public void frameHandlingIndex(WebDriver driver,int index)
 {
	 
	 driver.switchTo().frame(index) ;
	 
 }
 /**
  * This method will help to switch the driver to frame  based on  name / id  
  * @param driver
  * @param name
  */
 public void framenameId(WebDriver driver,String name)
 {
	 driver.switchTo().frame(name);
 }
 /**
  * This method willelp to switch the driver to frame based on webelemnt
  * @param driver
  * @param element
  */
 public void frameWebElement(WebDriver driver,WebElement element)
 {
         driver.switchTo().frame(element);
 }
 /**
  * this method will help to control back to immediate parent frame
  * @param driver
  * @param element
  */
 public void parentframe(WebDriver driver,WebElement element)
 {
         driver.switchTo().parentFrame();
 }
 /**
  * this method will help to control back to main page frame
  * @param driver
  * @param element
  */
 public void frameDefaultContent(WebDriver driver,WebElement element)
 {
         driver.switchTo().defaultContent();
 }
 /**
  * this method will halp to handle windows
  * @param driver
  * @param WindowId
  */
 public void SwitchWindow(WebDriver driver,String WindowId)
 {
        driver.switchTo().window(WindowId);
 }
 
 /**This method will help to perfrom alert popups accept method
  * @param driver
  * @param element
  */
 public void handleAlertPopup(WebDriver driver)
 {
       driver.switchTo().alert().accept();
       
 }
 /**
  * This method will help to perfrom to  dissmiss the  alert popups 
  * @param driver
  * @param element
  */
public void handleAlertDismiss(WebDriver driver)
{
       driver.switchTo().alert().dismiss();
      
}
/**
 * This method will help to perfrom alert popups to capture text which is already present in the webelemnt
 * @param driver
 * @param element
 */
public String handleAlertText(WebDriver driver)
{
     return  driver.switchTo().alert().getText();
      
}
/**
 * This method will help to perfrom alert popups to enter the data into textfield
 * @param driver
 * @param element
 * @param Data
 */
public void handleAlertSendData(WebDriver driver,String Data)
{
     driver.switchTo().alert().sendKeys(Data);
      
}
/**
 * this method will help the programer to capture the screenshot and return  path to the caller
 * @param driver
 * @param ScreenshotName
 * @return
 * @throws IOException
 */
public String TakesScreenShot(WebDriver driver,String ScreenshotName) throws  IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File src=new File(".\\Screenshot\\"+ScreenshotName+".png");
	FileHandler.copy(temp, src);
	return src.getAbsolutePath();  // path for Extent reports
	
	
}
 
}
		
		

	
	
