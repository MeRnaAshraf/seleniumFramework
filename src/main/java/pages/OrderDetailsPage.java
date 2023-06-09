package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	private WebElement pdfInvoiceLink;

	@FindBy(css = "a.button-2.print-order-button")
	private WebElement printInvoiceLink;
	
	public void PrintOrderDetails()
	{
		clickButton(printInvoiceLink);
	}
	
	public void DownloadPDFInvoice() throws InterruptedException
	{
		clickButton(pdfInvoiceLink);
		Thread.sleep(2000);
	}

}
