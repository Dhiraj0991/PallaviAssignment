package testcasesnew;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import lib.ReadExcelFile;
import lib.Utility;

public class Module9_1New extends BaseClass
{
	
	SendTestReportInEmail email=new SendTestReportInEmail();
	
	public Module9_1New() throws Exception
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void startBrowser()
	{
		driver.get("https://www.facebook.com/");
	}

	@Test(dataProvider="hybridData")
	public void negativeScenariosTest(String testcaseName,String keyword,String objectName,String objectType,String value) 
	{


		UIOperation operation = new UIOperation(driver);
		//Call perform function to perform operation on UI


					try
					{
						operation.perform(testcaseName,keyword, objectName,objectType,value);
					} 
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("There is some Exception"+ e.getMessage());
					}

	}

	@DataProvider(name="hybridData")
	public Object[][] getDataFromDataprovider() 
	{
		Object[][] object = null;
		ReadExcelFile file = new ReadExcelFile();
		//Read keyword sheet


		Sheet sht = null;
		try
		{
			sht = file.readExcel("F:\\JAVA\\Selenium\\PallaviAssignment","Pallavi_Assignment_Validation_Object_Repository_New.xls", "Module9_1");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("There is some Exception"+ e.getMessage());
		}

		int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();

		object = new Object[rowCount][5];
		// object = new Object[4][5];
		for (int i = 0; i < rowCount; i++)
			// for (int i = 0; i < 4; i++)
		{
			//Loop over all the rows
			Row row = sht.getRow(i+1);
			//Create a loop to print cell values in a row

//			for (int j = 0; j < row.getLastCellNum(); j++)
			for (int j = 0; j < 5; j++)
			{


				DataFormatter fmt = new DataFormatter();
				//Print excel data in console
				object[i][j] = fmt.formatCellValue(row.getCell(j));

				/*// Only need one of these
		     		DataFormatter fmt = new DataFormatter();

		     		// Once per cell
		     		String valueAsSeenInExcel = fmt.formatCellValue(row.getCell(j));
		     		System.out.println("Reading from excel \n" + valueAsSeenInExcel);
				 */


			}

		}


		return object;
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
