package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUilities.seleniumUtility;

public class Inventorypage extends seleniumUtility {

	//Declaration
	@FindBy(className="product_sort_container") 
	private WebElement SortDropDown;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement MenuBtn;
	
	@FindBy(linkText = "Logout") 
	private WebElement logoutLink;
	
	@FindBy(id="shopping_cart_container")
	private WebElement CartContainerbtn;
	
	//Initialzation
	public Inventorypage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilizaTION
	public WebElement getSortDropDown() {
		return SortDropDown;
	}

	public WebElement getMenuBtn() {
		return MenuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getCartContainer() {
		return CartContainerbtn;
	}
	//bUSINESS LIBRARY
	/**
	 * This method will click on product read from excel file and return details to caller
	 * @param driver
	 * @param PRODUCTNAME
	 * @return
	 */
	public String ClickOnProduct(WebDriver driver,String PRODUCTNAME) 
	{
		WebElement PROD = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String ProductDetails = PROD.getText();
		PROD.click();
		return ProductDetails;
	
	}
	/**
	 * This method will help to click on cart container
	 */
	
	public void ClickonCartContainer()
	{
		CartContainerbtn.click();
		
	}
	/**
	 * this mwthod help to perform  logout operation
	 */
	public void logoutofApp()
	{
		MenuBtn.click();
		logoutLink.click();
	}
	/**
	 * Thismethod will help to sort the product and then click on required product
	 * @param driver
	 * @param PRODUCTNAME
	 * @param SORTOPTION
	 * @return
	 */
	public String ClickonSortedProduct(WebDriver driver,String PRODUCTNAME,String SORTOPTION)
	{
		handleDropdown(SORTOPTION, SortDropDown);
		WebElement PROD = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String ProductDetails = PROD.getText();
		PROD.click();
		return ProductDetails;
	}
	
	//"//div[.='"+PRODUCTNAME+"']")
	
}
