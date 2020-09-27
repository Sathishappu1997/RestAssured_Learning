package Test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "src/test/resources/Features/API.feature",
			glue = "StepDefinition",
			monochrome = true,
			plugin = "pretty"
		)

public class Test_Runner_Class extends AbstractTestNGCucumberTests {

}
