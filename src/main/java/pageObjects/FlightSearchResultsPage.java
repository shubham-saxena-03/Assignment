package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightSearchResultsPage{

	private WebDriver driver;
	
	public FlightSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/* Region WebElements and Locators */
	
	private List<WebElement> Rows_FlightSearchResults(){
		return driver.findElements(By.xpath("//div[@class='ts-fbr-flight-list-row__header-core']"));
	}

	/* End Region WebElements Locators */
	
	/**
	 * Function to check if Flight results found.
	 * @return
	 */
	public boolean DoesFlightResultsFound() {
		List<WebElement> searchResults = Rows_FlightSearchResults();
		if(searchResults.size() >0) {
			return true;
		}else {
			return false;
		}
	}
}
