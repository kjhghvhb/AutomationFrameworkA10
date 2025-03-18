package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dependsonmethods {

	@Test
	public void createAccount()
	{
		Reporter.log("account created successsfully",true);
	}
	@Test
	public void EditAccount()
	{
		Reporter.log("account edited successfully",true);
	}
	
	@Test(dependsOnMethods = {"EditAccount","createAccount"})
	public void DeleteAccount()
	{
		Reporter.log("account deleted succefulyy", true);
	}
	
}
