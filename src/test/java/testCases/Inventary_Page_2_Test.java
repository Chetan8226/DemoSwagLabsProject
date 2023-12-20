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
import pages.Inventary_Page_2;
import pages.LoginPage_1;
import utility.CaptureScreenShots;
import utility.ReadData;

public class Inventary_Page_2_Test extends TestBase
{
	LoginPage_1 Login;
	Inventary_Page_2 invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		Login = new LoginPage_1();
		invent = new Inventary_Page_2();
		Login.loginToApplication();
	}
	@Test(groups = "Sanity")
	public void verifytitleofInventaryPageTest() 
	{
		String ExpTitle = "Swag Labs";
		String ActTitle = Login.verifyTitleofApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Logo Of Inventary Page = " + ActTitle);
	}
	@Test
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String ExpLable=ReadData.readexcel(0,3);//Products(0,3)
		String ActLable=invent.verifyProductLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log("Product Labels Of Inventary Page = " + ActLable);
	}
	@Test(groups = "Retesting")
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Twitter Logo = " + result);
	}
	@Test
	public void verifyfacebookLogoTest()
	{
		boolean result=invent.verifyfacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Facebook Logo = " + result);
	}
	@Test
	public void verifylinkinedLogoTest()
	{
		boolean result=invent.verifylinkinedLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Linkined Logo = " + result);
	}
	@Test(groups = {"Retesting","Regression"})
	public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String ExpCount=ReadData.readexcel(0,4);//6(0,4)
		String ActCount=invent.add6Products();
		Assert.assertEquals(ExpCount, ActCount);
		Reporter.log("Total Product Add To Cart = " + ActCount);
	}
	@Test(groups = {"Retesting","Regression"})
	public void remove2Products() throws EncryptedDocumentException, IOException
	{
		String ExpCount=ReadData.readexcel(0,5);//4(0,5)
		String ActCount=invent.remove2Products();
		Assert.assertEquals(ExpCount,ActCount);
		Reporter.log("Count of Product After Removing = " + ActCount);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShots.screenshot(it.getName());
		}
		driver.close();
	}
	

}
