package stepDefinitions;

//import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.mongodb.MapReduceCommand.OutputType;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

	public TestContextSetup testcontextsetup;

	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}

	@After
	public void afterScenario() throws IOException {
		testcontextsetup.testbase.webDriverManager().quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver=testcontextsetup.testbase.webDriverManager();
		if(scenario.isFailed()) {
			
		File srcPath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte [] filecontent=FileUtils.readFileToByteArray(srcPath);
		scenario.attach(filecontent, "image/png", "image");
				}
	}
}
