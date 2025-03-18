package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertpracitse 

{
	@Test
	public void sample()
	{
    	System.out.println("step 1");
    	Assert.assertEquals(0, 1);
    	System.out.println("step 2");
    	System.out.println("step 3");
    	System.out.println("step 4");
		
	}
  
    @Test
	  public void sample1()
    {
    	SoftAssert sa=new SoftAssert();
    	Assert.assertEquals(1, 2);
    	System.out.println("step 2");
    	System.out.println("step 3");
    	Assert.assertEquals("b", "a");
    	
    	System.out.println("step 4");
    	sa.assertAll();
    	
    }

}
