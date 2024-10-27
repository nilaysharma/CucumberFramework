package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LandingpageStepdefinitions {

	public WebDriver d;
	public String landingPageproductName;
	public String offerPageproductName;
	public LandingPage lp;
	TestContextSetup testcontextsetup;

	public LandingpageStepdefinitions(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		this.lp = testcontextsetup.pageobjectmanager.getLandingPage();
	}

	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
//		System.setProperty("webdriver.gecko.drive
		Assert.assertTrue(lp.getLandingpagetitle().contains("GreenKart"));
	}

	@When("^User searched with shortname (.+) and extracted the actual name of the product$")
	public void user_searched_with_shortname_and_extracted_the_actual_name_of_the_product(String string)
			throws InterruptedException {
		
		lp.searchItem(string);
		Thread.sleep(2000);
		testcontextsetup.landingPageproductName = lp.productName().split("-")[0].trim();
		System.out.println("Product name is:-" + testcontextsetup.landingPageproductName);
	}
	
	@When("Added {string} items of the selected product to cart")
	public void addItems(String quantity) {
	lp.additemtoCart(Integer.parseInt(quantity));
	lp.clickAddtoCartBtn();
	}
}
