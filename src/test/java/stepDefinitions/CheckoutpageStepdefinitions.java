package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CheckoutpageStepdefinitions {

	public WebDriver d;
	public String landingPageproductName;
	public String offerPageproductName;
	public CheckoutPage checkoutpage;
	TestContextSetup testcontextsetup;

	public CheckoutpageStepdefinitions(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		this.checkoutpage=testcontextsetup.pageobjectmanager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_ability() {
		
		assertTrue(checkoutpage.VerifyApplyBtn());
		assertTrue(checkoutpage.VerifyPlaceOrderBtn());
	}
	
	@Then("^User proceeds out to Checkout and validate the (.+) items in checkout page$")
	public void user_proceed_to_checkout_item(String name){
	checkoutpage.checkOutItems();	
	}
	

}
