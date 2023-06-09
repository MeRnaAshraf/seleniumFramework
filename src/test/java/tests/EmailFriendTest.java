package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterartionPage;

public class EmailFriendTest extends TestBase{

	HomePage homeObject;
	UserRegisterartionPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject; 
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	
	// 1- User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterartionPage(driver);
		registerObject.userRegisteration("Merna", "Ashraf", "merna10@gmail.com", "123456");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("merna10@gmail.com", "123456");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	// 2- Search For Product
	@Test(priority = 3)
	public void UserSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);

		} catch (Exception e) {
			System.out.println("Error occurred " + e.getMessage());
		}
	}
	
	// 3- Email to Friend
	@Test(priority = 4)
	public void RegisteredUserCanSendProductToFriend()
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend("test@test.com", "Hello my friend, check this product");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}
	
	// 4- User Logout
	@Test(priority = 5)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}

}
