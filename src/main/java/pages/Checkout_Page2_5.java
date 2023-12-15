package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page2_5 extends TestBase
{
	@FindBy(xpath="//button[@name='finish']") private WebElement finishtn;//
	//Label
	@FindBy(xpath="//span[@class='title']") private WebElement checkoutOverviewLable;//
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement QTYLable;//
	@FindBy(xpath="//div[@class='cart_desc_label']")  private WebElement DescriptionLable;//
	@FindBy(xpath="//div[text()='Payment Information']") private WebElement PaymentInfoLable;//
	@FindBy(xpath="//div[text()='Shipping Information']") private WebElement ShippingInfoLable;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement PriceTotalLable;
	
	public Checkout_Page2_5()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifycheckoutOverviewLable()
	{
		return checkoutOverviewLable.getText();
	}
	public String verifyQTYLable()
	{
		return QTYLable.getText();
	}
	public String verifyDescriptionLable()
	{
		return DescriptionLable.getText();
	}
	public String verifyPaymentInfoLable()
	{
		return PaymentInfoLable.getText();
	}
	public String verifyShippinfInfoLable()
	{
		return ShippingInfoLable.getText();
	}
	public String verifyPriceTotalLable()
	{
		return PriceTotalLable.getText();
	}
	
	public String clickOnFinishBtn()
	{
		finishtn.click();
		return driver.getCurrentUrl();
	}

}
