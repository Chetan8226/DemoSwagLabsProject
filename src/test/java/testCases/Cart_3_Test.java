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
import pages.Cart_3;
import utility.CaptureScreenShots;
import utility.ReadData;

public class Cart_3_Test extends TestBase
{
	LoginPage_1 Login;
	Inventary_Page_2 invent;
	Cart_3 Cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login = new LoginPage_1();
		invent = new Inventary_Page_2();
		Cart = new Cart_3();
		Login.loginToApplication();
		invent.add6Products();
		invent.clickonshoppingCart();
	}
	@Test
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String ExpTitle = ReadData.readexcel(0,0);//Swag Labs(0,0)
		String ActTitle = Cart.verifyTitleOfApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Logo of Cart Page= " + ActTitle);
	}

	@Test
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String ExpURL ="https://www.saucedemo.com/cart.html";
		String ActURL =Cart.verifyURLofApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("Verify URL of Cart Page = " + ActURL);
	}
	@Test
	public void verifyYourCartLableTest()
	{
		String ExpLabel="Your Cart";
		String ActLable=Cart.verifyYourCartLable();
		Assert.assertEquals(ExpLabel, ActLable);
		Reporter.log("Verify Your Cart Lable= " + ActLable);
	}
	@Test
	public void clickContinueShoppingbtnTest()
	{
		String ExpURL="https://www.saucedemo.com/inventory.html";
		String ActURL=Cart.clickContinueShoppingbtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("Verify After Click on Con Shopping btn URL = " + ActURL);
	}
	@Test
	public void clickCheckoutbtnTest()
	{
		String ExpURL="https://www.saucedemo.com/checkout-step-one.html";
		String ActURL=Cart.clickCheckoutbtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("Varify After Click on Checkoutbtn URL = " + ExpURL);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result=Cart.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Twitter Logo = " + result);
	}
	@Test
	public void verifyfacebookLogoTest()
	{
		boolean result=Cart.verifyfacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Facebook Logo = " + result);
	}
	@Test
	public void verifylinkinedLogoTest()
	{
		boolean result=Cart.verifylinkinedLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Linkined Logo = " + result);
	}
	@Test
	public void verifyPrivacyPolocyFooterTest()
	{
		String ExpFooter="© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String ActFooter=Cart.verifyPrivacyPolocyFooter();
		Assert.assertEquals(ExpFooter, ActFooter);
		Reporter.log("Visibility of Privacy Policy Footer of Your Cart Page = " + ExpFooter);
	}
	@Test
	public void verifyCartQTYLableTest()
	{
		String ExpLable="QTY";
		String ActLable=Cart.verifyCartQTYLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log("Verify Cart Page QTY Lable = " + ActLable);
	}
	@Test
	public void verifyCartDescriptionLableTest()
	{
		String ExpLable="Description";
		String ActLable=Cart.verifyCartDescriptionLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log("Verify Cart Page Description Lable = " + ActLable);
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
