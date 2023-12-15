package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.Handle_DropDown_List;

public class Inventary_Page_2 extends TestBase
{
	//Object Repository
	@FindBy(xpath="//span[@class='title']") private WebElement productLable;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement privacyPolicyLable;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement shoppingCart;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDown;
	//element added
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement t_ShirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement oneSideProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement testAlltheThingsProduct;
	//element remove
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeOneSideProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLightProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removet_ShirtsProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeTestallThingsProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackPackProduct;
	@FindBy(xpath="remove-sauce-labs-fleece-jacket") private WebElement removeFleeJacketProduct;

	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedinLogo;
	
	
	//Constructor
	public Inventary_Page_2()  // Constructor
	{
		PageFactory.initElements(driver, this);
	}
	public String verifytitleofInventaryPage()//
	{
		return driver.getTitle();
	}
	public String verifyProductLable()//
	{
		return productLable.getText();
	}
	public String verifyPrivacyPolocyLabel()//
	{
		return privacyPolicyLable.getText();
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
	public void clickonshoppingCart()
	{
		shoppingCart.click();
	}
	public String add6Products()
	{
		Handle_DropDown_List.handleSelectClass(dropDown,"Price (low to high)");
		backPackProduct.click();
		bikeLightProduct.click();
		t_ShirtProduct.click();
		fleeceJacketProduct.click();
		oneSideProduct.click();
		testAlltheThingsProduct.click();
		return cartCount.getText();
		
	}
	public String remove2Products()
	{
		add6Products();
		removeOneSideProduct.click();
		removeBikeLightProduct.click();
		return cartCount.getText();
		
	}

}
