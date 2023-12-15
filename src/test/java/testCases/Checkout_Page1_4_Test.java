package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_3;
import pages.Checkout_Page1_4;
import pages.Inventary_Page_2;
import pages.LoginPage_1;
import utility.CaptureScreenShots;

public class Checkout_Page1_4_Test extends TestBase
{
	LoginPage_1 Login;
	Inventary_Page_2 invent;
	Cart_3 Cart;
	Checkout_Page1_4 check_1;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login = new LoginPage_1();
		invent = new Inventary_Page_2();
		Cart = new Cart_3();
		check_1 = new Checkout_Page1_4();
		Login.loginToApplication();
		invent.add6Products();
		Cart.clickonOpenCart();
		Cart.clickCheckoutbtn();
		
	}

	@Test
	public void verifyURLofCheckoutPageTest()
	{
		String ExpURL="https://www.saucedemo.com/checkout-step-one.html";
		String ActURL=check_1.verifyURLofCheckoutPage1();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("URL of Checkout Page 1 = " + ActURL);
	}
	@Test
	public void verifyTitleofApplicationTest()
	{
		String ExpTitle="Checkout: Your Information";
		String ActTitle=check_1.verifyTitleofApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Title of Checkout Page 1 = " + ActTitle);	
	}
	@Test
	public void inputInformationTest()
	{
		String ExpURL="https://www.saucedemo.com/checkout-step-two.html";
		String ActURL=check_1.inputInformation();
		Assert.assertEquals(ExpURL,ActURL);
		Reporter.log("Title of Checkout Page 2 = " + ActURL);
	}
	@Test
	public void verifycancelBtnTest()
	{
		String ExpURL="https://www.saucedemo.com/cart.html";
		String ActURL=check_1.verifycancelBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("After click on Cancel button URL = " + ActURL);
	}
	@Test
	public void verifyontinueBtnTest() throws InterruptedException
	{
		String ExpURL="https://www.saucedemo.com/checkout-step-two.html";
		String ActURL=check_1.inputInformation();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("After click on Continue Btn URL = " + ActURL);
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
