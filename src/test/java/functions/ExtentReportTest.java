package functions;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import lib.Utility;

public class ExtentReportTest extends TestListenerAdapter
{
	
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest test;
	

	public void onStart(ITestContext testContext)
	{
		htmlReporter=new ExtentHtmlReporter("./Reports/TestReport.html");//specify location of the report

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		
		htmlReporter.config().setReportName("Automation Test Report"); // name of the report

		htmlReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name","Edureka");
		extent.setSystemInfo("Host name","Edureka");
		extent.setSystemInfo("OS","Windows 10");
		extent.setSystemInfo("Environemnt","TEST");
		extent.setSystemInfo("user","Dhiraj Mishra");

	}

	public void onTestSuccess(ITestResult result)
	{
		//test=extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		
		test=extent.createTest(result.getName()); // create new entry in th report

		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}

	public void onTestFailure(ITestResult result) 
	{
		
		test=extent.createTest(result.getName()); // create new entry in the report

		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report

	}

	public void onTestSkipped(ITestResult result)
	{
		

		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}