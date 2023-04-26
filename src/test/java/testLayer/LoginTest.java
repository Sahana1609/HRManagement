package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pompackage.PomLogin;
import basePackage.BaseHRMClass;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {

	PomLogin Log;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("Login");
		
		Log = new PomLogin();
	}

	@Test(priority = 1)
	public void Title() {
		String actual = Log.verify();
		System.out.println("actual");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(actual, "OrangeHRM");

	}

	@DataProvider
	public Object[][] Details() {
		Object result[][] = ExcelSheet.readdata("sheet1");
		return result;
	}

	@Test(priority = 2, dataProvider = "Details")
	public void Login(String name, String password) {
		try {
			Thread.sleep(1000);
			Log.typeusername(name);
			Thread.sleep(1000);
			Log.typepassword(password);
			Thread.sleep(1000);
			Log.clickbtn();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
