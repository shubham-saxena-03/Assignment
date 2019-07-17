package stepDefinitions;

import common.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends Browser{
	
	
	@After
	public void AfterSteps(Scenario scenario) {
		driver.close();
		driver.quit();
	}

}
