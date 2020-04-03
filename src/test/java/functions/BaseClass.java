
package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass extends ExtentReportTest
{

	public WebDriver driver;

	public BaseClass() throws Exception
	{

		Properties prop = new Properties();
		File src = new File("./Configuration/config.properties");

		FileInputStream ip = new FileInputStream(src);

		prop.load(ip);

		String browserName = prop.getProperty("browser");
//		String url=prop.getProperty("URL");

		if (browserName.equals("Chrome"))
		{

			String downloadFilePath = "C:\\Users\\DHIRAJ-MISHRA\\Desktop\\Music Assignment";

			HashMap<String, Object> chromePref = new HashMap<String, Object>();

			chromePref.put("profile.default_content_settings.popup", 0);
			chromePref.put("download.default_directory", downloadFilePath);

			System.setProperty("webdriver.chrome.driver", "chromedriver_80.exe");

			ChromeOptions opt = new ChromeOptions();

			opt.addArguments("--disable-notifications");

			opt.setExperimentalOption("prefs", chromePref);
			driver = new ChromeDriver(opt);

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//		driver.get(url);
		}

		if (browserName.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver",
					"F:\\JAVA\\Selenium\\Jar-Files\\FirefoxDriver\\New folder\\geckodriver.exe");

			System.setProperty("webdriver.ie.driver",
					"F:\\JAVA\\Selenium\\Jar-Files\\IEBrowser\\IEBrowser64_New\\IEDriverServer.exe");

			driver = new FirefoxDriver();

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get(url);
		}

	}

	public WebDriver getdriver()
	{
		if (driver == null)
		{
			ChromeOptions opt = new ChromeOptions();

			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
			return driver;
		} else
		{
			return driver;
		}
	}
}
