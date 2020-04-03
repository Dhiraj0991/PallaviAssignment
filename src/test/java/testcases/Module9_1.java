package testcases;

import java.util.ArrayList;
import java.util.Iterator;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import functions.BaseClass;
import functions.SendTestReportInEmail;
import functions.UIOperation;
import lib.TestUtil;
import lib.Utility;

public class Module9_1 extends BaseClass
{

	SendTestReportInEmail email=new SendTestReportInEmail();
	
	public Module9_1() throws Exception
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void startBrowser()
	{
		driver.get("https://www.facebook.com/");
	}
	
	@Test(dataProvider="getTestData")
	public void negativeScenariosTest(String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception
	{


		UIOperation operation = new UIOperation(driver);
		//Call perform function to perform operation on UI


		operation.perform(testcaseName,keyword, objectName,objectType,value);

	}



	@DataProvider(name="getTestData")
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> module9TestData= TestUtil.getDataFromExcelModule9_1();
		
		return module9TestData.iterator();
	}

	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			String image=Utility.captureScreenshotforReport(driver, result.getName());
			Thread.sleep(5000);
			test.pass("The Test Case is Passed", MediaEntityBuilder.createScreenCaptureFromPath(image).build());
		}
		
		
		
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			String image=Utility.captureScreenshotforReport(driver, result.getName());
			Thread.sleep(5000);
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(image).build());

				
		}
		
				
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.skip(result.getThrowable().getMessage());
		}
	}
	
	
	
	@AfterTest
	public void closeBrowser() throws Exception 
	{
		String to[] =
			{ "dheeru.nmishra@gmail.com"};
		
		email.send("subham.pmishra0991@gmail.com", to, "Automation Test Report", "Check the Report attachment.");

		
		driver.quit();
	}

}
