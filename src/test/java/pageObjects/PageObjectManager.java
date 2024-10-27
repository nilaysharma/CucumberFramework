package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
 LandingPage landingpage;
 OfferPage offerpage;
 CheckoutPage checkoutpage;
 WebDriver driver;
 
 public PageObjectManager(WebDriver driver) {
	 this.driver= driver;
 }
 public LandingPage getLandingPage() {
	 landingpage=new LandingPage(driver);
	 return landingpage;
 } 
 
 public OfferPage getOfferPage() {
	 offerpage = new OfferPage(driver);
	 return offerpage;
 }
 
 public CheckoutPage getCheckoutPage() {
	 checkoutpage=new CheckoutPage(driver);
	 return checkoutpage;
 }
 
}
