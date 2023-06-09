package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterartionPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{

	HomePage homeObject;
	UserRegisterartionPage registerObject;
	LoginPage loginObject;
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    homeObject = new HomePage(driver);
	    homeObject.openRegisterationPage();
	}
	
	@When("I click on register link")
	public void i_click_on_register_link() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * registerObject = new UserRegisterartionPage(driver);
	 * registerObject.userRegisteration("Merna", "Ashraf", "test2@gmail.com",
	 * "123456"); }
	 */
	
	@When("I entered the {string}, {string}, {string}, {string}")
	public void i_entered_the(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegisterartionPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
	}
	
	@Then("The registeration page displayed successfully {string}, {string}")
	public void the_registeration_page_displayed_successfully(String email, String password) {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		registerObject.userLogout();
	}

}
