package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_3 extends TestBase
{
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement shoppingCart;
	@FindBy(xpath="//span[@class='title']") private WebElement yourCartLable;
	@FindBy(xpath="//button[@name='continue-shopping']") private WebElement continueShoppingbtn;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutbtn;
	
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedinLogo;
	
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement privacyPolicyFooter;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement cartQTYLable;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement cartDescriptionLable;
	public Cart_3()
	{
		PageFactory.initElements(driver,this);
	}
	public String clickonOpenCart()
	{
		shoppingCart.click();
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	public String verifyURLofApplication() 
	{
		return driver.getCurrentUrl();
	}
	public String verifyYourCartLable()
	{
		return yourCartLable.getText();	
	}
	public String clickContinueShoppingbtn()
	{
		continueShoppingbtn.click();
		return driver.getCurrentUrl();
	}
	public String clickCheckoutbtn()
	{
		checkoutbtn.click();
		return driver.getCurrentUrl();
	}
	public boolean verifyTwitterLogo()//
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyfacebookLogo()//
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifylinkinedLogo()//
	{
		return linkedinLogo.isDisplayed();
	}
	public String verifyPrivacyPolocyFooter()//
	{
		return privacyPolicyFooter.getText();
	}
	public String verifyCartQTYLable()
	{
		return cartQTYLable.getText();
	}
	public String verifyCartDescriptionLable()
	{
		return cartDescriptionLable.getText();
	}
	
}
