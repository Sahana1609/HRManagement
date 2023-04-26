package basePackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.TimeUtils;

public class BaseHRMClass {
	public static Properties prop = new Properties();
	public static WebDriver driver;

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
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}


public static void screenshot(String Filename) {
	File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
	FileUtils.copyFile(file, new File("C:\\SHEGDE\\SAHANA\\CourseQA\\HRManagement\\src\\test\\java\\screenshots1\\screenshots1"+Filename+".jpg"));
	}
	catch (IOException e) {
		e.printStackTrace();
	}


}
}