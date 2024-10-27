package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	By search = By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4.product-name");
	By topDeals= By.linkText("Top Deals");
	By increment=By.xpath("//a[@class='increment']");
	By addtoCart=By.xpath("//button[contains(text(),'ADD TO CART')]");

	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	
	public String productName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDeals() {
	driver.findElement(topDeals).click();	
	}
	
	public String getLandingpagetitle() {
		return driver.getTitle();
	}
	
	public void additemtoCart(int noOfItem) {
		int i=noOfItem-1;
		while(i>0){
		driver.findElement(increment).click();
		i--;
		}
	}
	
	public void clickAddtoCartBtn() {
	driver.findElement(addtoCart).click();	
	}

}
