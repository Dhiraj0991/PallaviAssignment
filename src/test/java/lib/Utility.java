package lib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Utility {

	
	public static void highLightElementcaptureScreenshot(WebDriver driver, WebElement element) throws Exception
	{
		
		for (int i = 0; i < 2; i++)
        {
		JavascriptExecutor js=(JavascriptExecutor)driver; 

	
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: blue;  border: 2px solid blue;");
        if (element.getAttribute("style") != null)
        {
            Thread.sleep(2000);
        }
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
    }
		

	}
	
	public static String getScreenshot(WebDriver driver,String screenshotName)
	{

		
		int i =0;
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		String path="./Screenshots/"+new SimpleDateFormat("yyyy_MM_dd__hh_mm").format(new Date())+screenshotName+(++i)+ ".png";
	
		File destination= new File(path);
		try 
		{
			Thread.sleep(1000);
			FileUtils.copyFile(source, destination);
		} 
		catch (Exception e) {

			System.out.println("Error while highlighting/Capturing Screenshot of Element"+e.getMessage());
		} 
		return path;
	}
	
	
	public static String captureScreenshotforReport(WebDriver driver,String screenshotName)
	{

		
		int i =0;
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File source= ts.getScreenshotAs(OutputType.FILE);
		
//		String path="./Screenshots/"+new SimpleDateFormat("yyyy_MM_dd__hh_mm").format(new Date())+screenshotName+(++i)+ ".png";
		String path= System.getProperty("user.dir")+"/Screenshots/"+new SimpleDateFormat("yyyy_MM_dd__hh_mm").format(new Date())+screenshotName+(++i)+ ".png";
		File destination= new File(path);
		try 
		{
			Thread.sleep(1000);
			FileUtils.copyFile(source, destination);
		} 
		catch (Exception e) {

			System.out.println("Error while highlighting/Capturing Screenshot of Element"+e.getMessage());
		} 
		return path;
	}
}
