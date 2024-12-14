package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;
	public static Logger logger = LoggerFactory.getLogger(BaseClass.class); // Initialize the logger

	public static WebDriver initilizeBrowser() throws IOException {
		if (driver == null) { // Check if driver is already initialized
			p = getProperties();

			String executionEnv = p.getProperty("execution_env");
			String browser = p.getProperty("browser").toLowerCase();
			String os = p.getProperty("os").toLowerCase();

			if (executionEnv.equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();

				// Set platform
				switch (os) {
				case "windows":
					capabilities.setPlatform(Platform.WINDOWS);
					break;
				case "mac":
					capabilities.setPlatform(Platform.MAC);
					break;
				case "linux":
					capabilities.setPlatform(Platform.LINUX);
					break;
				default:
					System.out.println("No matching OS");
					return null;
				}

				// Set browser
				switch (browser) {
				case "chrome":
					capabilities.setBrowserName("chrome");
					break;
				case "edge":
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				case "firefox":
					capabilities.setBrowserName("firefox");
					break;
				default:
					System.out.println("No matching browser");
					return null;
				}

				// Initialize Remote WebDriver

				
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
				
			} else if (executionEnv.equalsIgnoreCase("local")) {
				// Local browser setup
				switch (browser) {
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				default:
					System.out.println("No matching browser");
					driver = null;
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			}
		}
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;
	}

	// Provide the getLogger() method to access the logger
	public static Logger getLogger() {
		return logger;
	}

	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}

	public static String randomNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(4);

		return (str + num);
	}

	public static String randomAlphaNumeric1() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(4);

		return (str + num);
	}
//	public String captureScreen(String tname) throws IOException {
//
//		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//
//		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
//		File targetFile = new File(targetFilePath);
//
//		sourceFile.renameTo(targetFile);
//
//		return targetFilePath;
//
//	}
}
