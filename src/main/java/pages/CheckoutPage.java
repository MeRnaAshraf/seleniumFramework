package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postCodeTxt;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
	WebElement continueBtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingMethodRdo;
	
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement continueShippingBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement continuePaymentBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement continueInfoBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement ThankYoulbl;
	
	@FindBy(css = "div.title")
	public WebElement successMessage;
	
	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;
	
	public void RegisteredUserCheckoutProduct(String countryName, String address, String postcode, String phone, String city, String productName) throws InterruptedException
	{
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}
	
	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}
	
	public void viewOrderDetails() throws InterruptedException
	{
		clickButton(orderDetailsLink);
		Thread.sleep(1000);
	}
	
	public void CheckoutProduct(String firstName, String lastName, String countryName, String email, String address, String postcode, String phone, String city, String productName) throws InterruptedException
	{
		setTextElementText(fnTxt, firstName);
		setTextElementText(lnTxt, lastName);
		setTextElementText(emailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}

}
