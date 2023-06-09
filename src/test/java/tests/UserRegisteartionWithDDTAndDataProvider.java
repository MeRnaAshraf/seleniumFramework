package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterartionPage;

public class UserRegisteartionWithDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegisterartionPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"Merna", "Ashraf", "test5@gmail.com", "123456"},
			{"Moataz", "Nabil", "test6@gmail.com", "123456"}
		};
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterartionPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
