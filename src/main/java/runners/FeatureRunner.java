package runners;

import java.io.File;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(	features = "src/main/resources/features", 
					glue = { "stepDefinitions" }, 
					tags = {"@FlightSearch"},
					plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
					monochrome = true)

public class FeatureRunner {
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(Paths.get(".").toAbsolutePath().normalize().toString()+"/extent-config.xml"));
	 }
}
