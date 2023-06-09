package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "updatecart")
	WebElement removeBtn;
	
	@FindBy(id = "updatecart")
	WebElement updateCartBtn;

	@FindBy(id = "itemquantity11263")
	public WebElement quantityTxt;

	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckbox;
	
	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;
	
	public void RemoveProductFromCart()
	{
		clickButton(removeBtn);
	}
	
	public void UpdateProductQuantityInCart(String quantity)
	{
		//clear quantity textbox
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public void openCheckoutPage()
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}
	
	public void openCheckoutPageAsGuest()
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
		clickButton(checkoutAsGuestBtn);
	}


}
