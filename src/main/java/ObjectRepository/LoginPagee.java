package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagee {
	//create pom class for every web pages
	
		//rule2:Identify the webelements -> declaration
		@FindBy( id = "user-name")
		private WebElement usernameEdt;
		
		@FindBy( id="password")
		private WebElement passwordEdt;
		
		@FindBy( id= "login-button")
		private WebElement loginBuEdt;
		
		//rule3 :initialization
		 public LoginPagee(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }

		 
		// Rule4:utilization

		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBuEdt() {
			return loginBuEdt;
		}
		 
		//rule5:  provide Business Library gwneric method but related to scenarios
		public void LoginApp1(String USERNAME,String PASSWORD)
		{
			usernameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBuEdt.click();
		}
		

	}



