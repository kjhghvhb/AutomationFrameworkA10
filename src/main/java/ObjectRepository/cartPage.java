
package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage
{
	@FindBy(className="inventory_item_name")
	private WebElement ItemInfo;
	
	@FindBy(xpath="//button[.='Remove']")
	private WebElement removeItem;
	
	public cartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getItemInfo() {
		return ItemInfo;
	}

	public WebElement getRemoveItem() {
		return removeItem;
	}
	 
	public String getItemName()
	{
		return ItemInfo.getText();
	}
	public void ClickOnRemoveBtn()
	{
		removeItem.click();
	}

}
