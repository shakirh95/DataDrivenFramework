package TestCaseFile;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import UtilitiesFile.ReadConfiguration;

public class BaseClass 
{
	public static WebDriver driver;
	public static Logger logger;
	ReadConfiguration readConfiguration = new ReadConfiguration();
	String Browser = readConfiguration.getBrowser();
	String URL1 = readConfiguration.getUrl();
	@BeforeClass
	void browserLunch() throws Exception
	{
		switch (Browser.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver = new EdgeDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			break;
		default:
			driver = null;
			break;
		}
		logger = LogManager.getLogger("DataDrivenFramework");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void Screenshot() throws Exception
	{
		File Source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework\\Screenshots\\Screenshot.png");
		FileUtils.copyFile(Source, Destination);
	}
}
