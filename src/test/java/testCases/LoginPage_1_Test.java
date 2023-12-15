package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage_1;
import utility.CaptureScreenShots;
import utility.ReadData;

public class LoginPage_1_Test extends TestBase 
{
	LoginPage_1 Login;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		Login = new LoginPage_1();
	}

	@Test(priority = 1,enabled = true,groups = "Sanity")//dependsOnMethods = "verifyURLofApplicationTest")
	public void verifyTitleofApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String ExpTitle = ReadData.readexcel(0,0);//Swag Labs(0,0)
		String ActTitle = Login.verifyTitleofApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Verify After Login Title of Application = " + ActTitle);
	}

	@Test(priority = 2,enabled = true,groups = {"Sanity","Retesting"})
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String ExpURL = ReadData.readexcel(0,1);//https://www.saucedemo.com/(0,1)
		String ActURL = Login.verifyURLofApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("Verify Login URL of Application = " + ActURL);
	}

	@Test(priority = 3,enabled = true,groups = "Regression")//,dependsOnMethods = "verifyURLofApplicationTest")
	public void loginToApplicationTest() throws IOException 
	{
		String ExpURL = ReadData.readexcel(0,2);//https://www.saucedemo.com/inventory.html(0,2)
		String ActURL = Login.loginToApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("Verify After Login Inventary Page URL = " + ActURL);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShots.screenshot(it.getName());
		}
		reports.flush();
		driver.close();
	}

}
