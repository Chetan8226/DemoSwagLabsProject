package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage_1 extends TestBase 
{
	// object repository (repository means where we can store all elements)
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userTextBox;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@name='login-button']") private WebElement loginBtn;

	public LoginPage_1() // user defined class constructor
	{
		PageFactory.initElements(driver, this);
	}

	public String loginToApplication() throws IOException 
	{
		logger=reports.createTest("Login To Sauce Lab Application");
		userTextBox.sendKeys(ReadData.readPropertiesFile("UserName"));
		logger.log(Status.INFO,"User Name Is Entered");
		passwordTextBox.sendKeys(ReadData.readPropertiesFile("Password"));
		logger.log(Status.INFO,"Password is Entered");
		loginBtn.click();
		logger.log(Status.INFO,"Login Butten is Clicked");
		logger.log(Status.PASS,"Login is Successful");
		return driver.getCurrentUrl();
	}
	//verify Multiple Credential Method
	public String loginToAppMultipleCred(String un,String pass) throws IOException
	{
		userTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	//UserName= standard_user
	//Password= secret_sauce

	public String verifyTitleofApplication() 
	{
		return driver.getTitle();
	}

	public String verifyURLofApplication() 
	{
		return driver.getCurrentUrl();
	}

}
