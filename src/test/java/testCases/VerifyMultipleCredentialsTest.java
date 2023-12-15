package testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage_1;
import utility.CaptureScreenShots;

public class VerifyMultipleCredentialsTest extends TestBase
{
	LoginPage_1 Login;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		Login = new LoginPage_1();
	}
	@DataProvider(name = "Credentials")
	public Object[][]getData()
	{
		return new Object[][]
				{
			            {"standard_user","secret_sauce"},
			            /*{"locked_out_user","secret_sauce"},
			            {"problem_user","secret_sauce"},
			            {"performance_glitch_user","secret_sauce"},
			            {"error_user","secret_sauce"},
			            {"visual_user","secret_sauce"},*/
			            //TestData Assignment
			            /*{"standard_user","secret_sauce"},
			            {"standard_user1","secret_sauce"},
			            {"standard_user","secret_sauce1"},
			            {"standard_user1","secret_sauce1"},*/
			
				};
	}
	@Test(dataProvider = "Credentials")
	public void loginToAppMultipleCredTest(String un,String pass) throws IOException
	{
		SoftAssert s=new SoftAssert();
		String ExpURL="https://www.saucedemo.com/inventory.html";
		String ActURL= Login.loginToAppMultipleCred(un, pass);
		s.assertEquals(ExpURL, ActURL);
		s.assertAll();
		Reporter.log("Multiple Credential Test = " + ActURL);
	}

	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShots.screenshot(it.getName());
		}
		driver.close();
	}
	

}
