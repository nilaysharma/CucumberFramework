package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class OfferpageStepdefinitions {

	String offerPageproductName;
	TestContextSetup testcontextsetup;
	PageObjectManager pageobjectmanager;
	
	public OfferpageStepdefinitions(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}

	@Then("^User searched with (.+) shortname on offers page$")
	public void user_searched_with_same_shortname_on_offers_page_to_check_if_product_exists(String name)
			throws InterruptedException { 
		switchtoOfferPage();
		OfferPage op = testcontextsetup.pageobjectmanager.getOfferPage();
		op.searchItem(name);
//		testcontextsetup.d.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
		Thread.sleep(2000);
		offerPageproductName = op.productName();
		System.out.println("offerPageproductName is:-" + offerPageproductName);
	}

	public void switchtoOfferPage() throws InterruptedException {
		LandingPage landingpage = testcontextsetup.pageobjectmanager.getLandingPage();
		landingpage.selectTopDeals();
		testcontextsetup.genericutils.switchTochildWindow();
		Thread.sleep(2000);
	}

	@Then("validate that shortname on productPage matches with offer page")
	public void validate_that_shortname_on_productPage_matches_with_offer_page() {
		Assert.assertEquals(testcontextsetup.landingPageproductName, offerPageproductName);
	}
}
