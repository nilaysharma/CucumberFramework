package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.Timeout;

public class TestBase {

	public WebDriver driver;

	public WebDriver webDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
//		using system here as it is all maven thing are stored here
		String maven_browser = System.getProperty("browser");

		String browser = maven_browser != null ? maven_browser : browser_properties;

		if (driver == null) {

			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;
	}

}
