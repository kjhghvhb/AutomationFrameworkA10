package GenericUilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 *  This class provides implementation to ITestListener interface of TestNG
 *  @author Lavanya
 */
public class ListenersImplementation implements ITestListener
{

	
	 ExtentReports report;
	 ExtentTest test;


	public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
	
		System.out.println(MethodName+ "-@Test  Execution  start");
		
		//Intimate the start of @Test to Extent Reports
		 test = report.createTest(MethodName);
	}


	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		
		System.out.println(MethodName+ "-@Test  Execution  Pass");
		
		//Intimate extent reports @Test is PASS - log the status
		test.log(Status.PASS, MethodName+"-@Test Execution is pass");
	}
		

	public void onTestFailure(ITestResult result) 
	{
        String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+ "-@Test  Execution  Fail");
		
		//Capture the  exception
		System.out.println(result.getThrowable());
		
		
		// Log the status as Fail in Extent reports
		test.log(Status.FAIL, MethodName+"-@Test Execution is Fail");
		
		//Log the Exception in Extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture Screenshot
		seleniumUtility s=new seleniumUtility();
		JavaUtility j=new JavaUtility();
		
		//Capture screenshotname
		String ScreenShotName = MethodName+"-"+j.getSystemDateInFormat();
		try {
			String path = s.TakesScreenShot(BaseClass.sdriver, ScreenShotName);
			//Attach the screenshot to extent report
		   	test.addScreenCaptureFromPath(path);
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	}


	public void onTestSkipped(ITestResult result)
	{
       String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+ "-@Test  Execution Skip");
		
		//Capture the  exception
		System.out.println(result.getThrowable());
		
		// Log the Status as SKIP in Extent Reports
		test.log(Status.SKIP, MethodName+ "-@Test is execution Skip");

		// Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
	}
	
	public void onStart(ITestContext context) 
	{
        
		  System.out.println( "-suite  Execution Started");
		  
		  //configuration of Extent Reports
		  ExtentSparkReporter esr=new ExtentSparkReporter(".\\Extent Reports\\Report -"+new JavaUtility().getSystemDateInFormat() + ".html");
		  esr.config().setDocumentTitle("Sauce Labs Execution Report");
		  esr.config().setReportName("Execution report");
		  esr.config().setTheme(Theme.DARK);
		  
		  //Load the basic configuration to extent reports class
		  report=new ExtentReports();
		  report.attachReporter(esr);
		  report.setSystemInfo("BaseBrowser","Chrome Driver");
		  report.setSystemInfo("Base Platform","windows");
		  report.setSystemInfo("Base url","Testing Environment");
		  report.setSystemInfo("Reporter name","Lavanya");
			  
	}


	public void onFinish(ITestContext context)
	{
		
		 System.out.println("-suite  Execution Finished");
		 //flush the reports
		 report.flush();
		
	}


}
