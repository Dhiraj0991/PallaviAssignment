package functions;

import static org.testng.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import lib.Utility;

public class UIOperation
{
	public static WebDriver driver;
	public static SoftAssert assertion;
	public static WebElement element;

	public UIOperation(WebDriver driver)
	{
		this.driver = driver;

	}

	public void perform(String testcaseName, String operation, String objectName, String objectType, String value)
			throws Exception

	{

		switch (operation)
		{

		case "NAVIGATEBACK":
			driver.navigate().back();
			break;

		case "STATICWAIT":
			long l = Long.parseLong(value);

			Thread.sleep(l);

			break;

		case "SETTEXT":

			switch (objectType)
			{

			case "id":
				driver.findElement(By.id(objectName)).sendKeys(value, Keys.TAB);
				break;

			case "name":
				driver.findElement(By.name(objectName)).sendKeys(value, Keys.TAB);
				break;

			case "xpath":

				driver.findElement(By.xpath(objectName)).sendKeys(value, Keys.TAB);
				break;

			case "css":
				driver.findElement(By.cssSelector(objectName)).sendKeys(value, Keys.TAB);
				break;
			}
			break;

		case "CLICK":

			switch (objectType)
			{

			case "id":

				driver.findElement(By.id(value)).click();
				String path=Utility.getScreenshot(driver, "ScreenCapture");
				assertion.assertTrue(path.contains("ScreenCapture"));
				break;

			case "name":

				driver.findElement(By.name(value)).click();
				path=Utility.getScreenshot(driver, "ScreenCapture");
				assertion.assertTrue(path.contains("ScreenCapture"));
				break;

			case "link":

				driver.findElement(By.linkText(value)).click();
				path=Utility.getScreenshot(driver, "ScreenCapture");
				assertion.assertTrue(path.contains("ScreenCapture"));
				break;

			case "partiallink":

				driver.findElement(By.partialLinkText(value)).click();
				path=Utility.getScreenshot(driver, "ScreenCapture");
				assertion.assertTrue(path.contains("ScreenCapture"));
				break;

			case "xpath":
				driver.findElement(By.xpath(value)).click();
				path=Utility.getScreenshot(driver, "ScreenCapture");
				assertion.assertTrue(path.contains("ScreenCapture"));
				break;

			case "css":

				driver.findElement(By.cssSelector(value)).click();
				path=Utility.getScreenshot(driver, "ScreenCapture");
				assertion.assertTrue(path.contains("ScreenCapture"));
				break;

			}
			break;

		case "GETTEXTVALIDATION":
			String ActualVal = null;
			switch (objectType)
			{
			case "xpath":
				ActualVal = driver.findElement(By.xpath(objectName)).getText().trim();
				assertion = new SoftAssert();
				assertion.assertEquals(ActualVal, value.trim());
				assertion.assertAll();
				break;
			}

			
			
			
		case "SELECT":
			switch (objectType)
			{

			case "xpath":
				driver.findElement(By.xpath(objectName)).click();
				Select selectfromdropdown = new Select(driver.findElement(By.xpath(objectName)));
				selectfromdropdown.selectByVisibleText((value));
				break;

			case "css":
				Select selectfromdropdown1 = new Select(driver.findElement(By.cssSelector(objectName)));
				selectfromdropdown1.selectByVisibleText(value);
				break;

			case "id":
				Select selectfromdropdown2 = new Select(driver.findElement(By.id(objectName)));
				selectfromdropdown2.selectByVisibleText((value));
				break;

			case "name":
				driver.findElement(By.name(value)).click();
				break;
			}
			break;
		}
	}

}
