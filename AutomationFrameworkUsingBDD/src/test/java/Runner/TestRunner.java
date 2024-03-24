package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue={"StepDefinition"}, 
		//tags="@Regression",
		plugin = {"pretty","html:target/Automationreports.html"}
		)

public class TestRunner {

}