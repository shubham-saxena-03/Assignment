package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(	features = "src/main/resources/features", 
					glue = { "stepDefinitions" }, 
					tags = {"@OneWay"},
					monochrome = true)

public class FeatureRunner {

}
