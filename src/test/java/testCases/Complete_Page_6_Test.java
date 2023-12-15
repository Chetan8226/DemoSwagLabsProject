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
import pages.Complete_Page_6;
import pages.Inventary_Page_2;
import pages.LoginPage_1;
import utility.CaptureScreenShots;

public class Complete_Page_6_Test extends TestBase
{
	LoginPage_1 Login;
	Inventary_Page_2 invent;
	Cart_3 Cart;
	Checkout_Page1_4 check_1;
	Checkout_Page2_5 check_2;
	Complete_Page_6 complete;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login = new LoginPage_1();
		invent = new Inventary_Page_2();
		Cart = new Cart_3();
		check_1 = new Checkout_Page1_4();
		check_2 = new Checkout_Page2_5();
		complete = new Complete_Page_6();
		Login.loginToApplication();
		invent.add6Products();
		Cart.clickonOpenCart();
		Cart.clickCheckoutbtn();
		check_1.inputInformation();
		check_2.clickOnFinishBtn();
	}
	@Test
	public void verifyCheckoutCompleteLableTest()
	{
		String ExpLable="Checkout: Complete!";
		String ActLable=complete.verifyCheckoutCompleteLable();
		Assert.assertEquals(ExpLable, ActLable);
		Reporter.log("Visibiliti of Checkout Complete Lable = " + ActLable);
	}
	@Test
	public void verifyPonyExpressIMGTest()
	{
		boolean result=complete.verifyPonyExpressIMG();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of PonnyExpressIMG = " + result);
	}
	@Test
	public void verifyThankYouForHeaderTest()
	{
		String ExpHeader="Thank you for your order!";
		String ActHeader=complete.verifyThankYouForHeader();
		Assert.assertEquals(ExpHeader, ActHeader);
		Reporter.log("Visibility of Header Text = " + ActHeader);
	}
	@Test
	public void verifyCompleteTextTest()
	{
		String ExpText="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String ActText=complete.verifyCompleteText();
		Assert.assertEquals(ExpText, ActText);
		Reporter.log("Visibility of Complete text = " + ActText);
	}
	@Test
	public void clickOnBackHomeBtnTest()
	{
		String ExpURL="https://www.saucedemo.com/inventory.html";
		String ActURL=complete.clickOnBackHomeBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log("After Click On Back To Home Btn URL = " + ActURL);
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
