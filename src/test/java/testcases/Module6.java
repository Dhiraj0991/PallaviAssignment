package testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import functions.BaseClass;
import functions.SendTestReportInEmail;
import functions.UIOperation;
import lib.TestUtil;
import lib.Utility;

public class Module6 extends BaseClass
{

	SendTestReportInEmail email=new SendTestReportInEmail();
	public SoftAssert assertion;
	
	public String actualresponse;
	public String expectedrespose;
	
	public Module6() throws Exception
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Test
	public void testLinks() throws Exception
	{
		// 1. Get all the  Footer links
		
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='pageFooterChildren']//li//a"));
//		links.addAll(driver.findElements(By.tagName("img")));
		
		
		System.out.println("Size of full Links: "+ links.size());
		
		List<WebElement> activeLinks= new ArrayList<WebElement>();
		
		links.removeAll(driver.findElements(By.xpath("//div[@id='pageFooterChildren']//li//a[contains(text(),'Settings')]")));
		links.removeAll(driver.findElements(By.xpath("//div[@id='pageFooterChildren']//li//a[contains(text(),'Activity log')]")));
		

		
		// 2. Iterate over active links
		
		for(int i=0;i<links.size();i++)
		{
			
				if (links.get(i).getAttribute("href") != null)
				{
					activeLinks.add(links.get(i));
				}
				
//				if (links.get(i).getAttribute("href") != null && (! links.get(i).getAttribute("accesskey").contains("6")) && (! links.get(i).getAttribute("accesskey").contains("7")))
//				{
//					activeLinks.add(links.get(i));
//				}
			
			
			
		}
		
		System.out.println("Size of active Links: "+ activeLinks.size());
		
		
		//3. Check the href url httpconnection api
		
		for(int j=0; j< activeLinks.size();j++)
		{
			HttpURLConnection connection=(HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			actualresponse=connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(activeLinks.get(j).getAttribute("href")+" ------> "+ actualresponse);
			
			
		}
		
		
		expectedrespose="OK";
		
		assertion.assertEquals(actualresponse, expectedrespose);
		assertion.assertAll();
		
		
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
			{ "priya.dmishra0991@gmail.com" ,"dheeru.nmishra@gmail.com"};
		
		email.send("subham.pmishra0991@gmail.com", to, "Automation Test Report", "Check the Report attachment.");

		
		
		driver.quit();
	}

}


