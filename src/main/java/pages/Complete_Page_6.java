package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Complete_Page_6 extends TestBase
{
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement CheckoutCompleteLable;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement PonyExpressIMG;
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement ThankYouForHeader;
	@FindBy(xpath="//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']") private WebElement CompleteText;
	@FindBy(xpath="//button[@class='btn btn_primary btn_small']") private WebElement BackHomeBtn;
	public Complete_Page_6()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheckoutCompleteLable()
	{
		return CheckoutCompleteLable.getText();
	}
	public boolean verifyPonyExpressIMG()
	{
		return PonyExpressIMG.isDisplayed();
	}
	public String verifyThankYouForHeader()
	{
		return ThankYouForHeader.getText();
	}
	public String verifyCompleteText()
	{
		return CompleteText.getText();
	}
	public String clickOnBackHomeBtn()
	{
		BackHomeBtn.click();
		return driver.getCurrentUrl();
	}
	

}
