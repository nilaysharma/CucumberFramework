package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	By Cart=By.xpath("//img[@alt='Cart']");
	By Checkout=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By ApplyBtton=By.xpath("//button[contains(text(),'Apply')]");
	By PlaceOrderBtn=By.xpath("//button[contains(text(),'Place Order')]");
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
		
	public void checkOutItems() {
		driver.findElement(Cart).click();	
		driver.findElement(Checkout).click();	
		}
	
	public Boolean VerifyApplyBtn() {
		return driver.findElement(ApplyBtton).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrderBtn() {
		return driver.findElement(PlaceOrderBtn).isDisplayed();
	}
}
