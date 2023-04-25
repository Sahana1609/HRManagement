package sel;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class Browse {

	public static void main(String[] args) {
		//Step 1 open the browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");


		//type url

		ChromeDriver driver=new ChromeDriver(op);

		driver.get("https://www.roicians.com/contact-us/");
		
		//locate firstname column
		
		driver.findElement(By.id("text-77525447616")).sendKeys("Roicians");
		driver.findElement(By.id("text-77525447616")).sendKeys("Roicians");
		
		
	

	}

}
