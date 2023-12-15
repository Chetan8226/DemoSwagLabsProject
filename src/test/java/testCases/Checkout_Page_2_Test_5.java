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
import pages.Checkout_Page2_5;
import pages.Inventary_Page_2;
import pages.LoginPage_1;
import utility.CaptureScreenShots;

public class Checkout_Page_2_Test_5 extends TestBase
{
	LoginPage_1 Login;
	Inventary_Page_2 invent;
	Cart_3 Cart;
	Checkout_Page1_4 check_1;
	Checkout_Page2_5 check_2;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login = new LoginPage_1();
		invent = new Inventary_Page_2();
		Cart = new Cart_3();
		check_1 = new Checkout_Page1_4();
		check_2 = new Checkout_Page2_5();
		Login.loginToApplication();
		invent.add6Products();
		Cart.clickonOpenCart();
		Cart.clickCheckoutbtn();
		check_1.inputInformation();
	}
	@Test
	public void verifycheckoutOverviewLableTest()
	{
		String ExpLable="Checkout: Overview";
		String ActLable=check_2.verifycheckoutOverviewLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log("Lable of Checkout Page 2 = " + ActLable);
	}
	@Test
	public void clickOnFinishBtnTest()
	{
		String ExpURL="https://www.saucedemo.com/checkout-complete.html";
		String ActURL=check_2.clickOnFinishBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("URL of Complete Page = " + ActURL);
	}
	@Test
	public void verifyQTYLableTest()
	{
		String ExpLable="QTY";
		String ActLable=check_2.verifyQTYLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log(ActLable);
	}
	@Test
	public void verifyDescriptionLableTest()
	{
		String ExpLable="Description";
		String ActLable=check_2.verifyDescriptionLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log(ActLable);
	}
	@Test
	public void verifyPaymentInfoLableTest()
	{
		String ExpLable="Payment Information";
		String ActLable=check_2.verifyPaymentInfoLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log(ActLable);
	}
	@Test
	public void verifyShippinfInfoLableTest()
	{
		String ExpLable="Shipping Information";
		String ActLable=check_2.verifyShippinfInfoLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log(ActLable);
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
