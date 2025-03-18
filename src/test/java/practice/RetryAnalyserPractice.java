package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
	@Test(retryAnalyzer =  GenericUilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		System.out.println("hi");
	}
	@Test(retryAnalyzer =  GenericUilities.RetryAnalyserImplementation.class)
	public void sample1()
	{
		Assert.fail();
		System.out.println("hello"); 
	}


}
