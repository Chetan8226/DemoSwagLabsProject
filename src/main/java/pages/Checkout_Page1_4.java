package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page1_4 extends TestBase
{
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement titleCheckoutYourInfo;
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstNameTextBox;
	@FindBy(xpath="//input[@name='lastName']") private WebElement lastnameTextBox;
	@FindBy(xpath="//input[@name='postalCode']") private WebElement zipCodeTextBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continuebtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	
	public Checkout_Page1_4()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLofCheckoutPage1()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleofApplication()
	{
		return titleCheckoutYourInfo.getText();
	}
	public String inputInformation()
	{
		firstNameTextBox.sendKeys("Chetan");
		lastnameTextBox.sendKeys("Nannaware");
		zipCodeTextBox.sendKeys("442401");
		continuebtn.click();
		return driver.getCurrentUrl();
	}
	public String verifycancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}

}
