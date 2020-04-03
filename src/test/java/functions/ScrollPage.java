package functions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScrollPage 
{
	static WebDriver driver;
	
	public void scrollPageDown() throws Exception
	{	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,400)");


	}
	
	public void scrollPageUp() throws Exception
	{	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,-400)");


	}
}
