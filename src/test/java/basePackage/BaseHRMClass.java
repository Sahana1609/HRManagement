package basePackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.*;

import Utility.TimeUtils;

public class BaseHRMClass {
	public static Properties prop = new Properties();
	public static WebDriver driver;

//	Properties prop=new Properties();
//	WebDriver driver;

	// Step 1
	public BaseHRMClass() {

		try {
			FileInputStream file = new FileInputStream(
					"C:\\SHEGDE\\SAHANA\\CourseQA\\HRManagement\\src\\test\\java\\environmentvariables\\config.properties");

			prop.load(file);

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException a) {
			a.printStackTrace();
		}
	}

	// Step 2
	@SuppressWarnings("deprecation")
	public static void initiate() {
		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SHEGDE\\SAHANA\\CourseQA\\HRManagement\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}