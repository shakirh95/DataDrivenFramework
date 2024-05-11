package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass 
{
	WebDriver Currentdriver;
	public LoginClass(WebDriver Remotedriver)
	{
		Currentdriver = Remotedriver;
		PageFactory.initElements(Remotedriver, this);
	}
	@FindBy(id = "username") WebElement Username;
	@FindBy(id = "password") WebElement Password;
	@FindBy(id = "submit") WebElement Submit;
	public void User_Name(String user)
	{
		Username.sendKeys(user);
	}
	public void User_Password(String password)
	{
		Password.sendKeys(password);
	}
	public void User_Submit()
	{
		Submit.click();
	}

}
