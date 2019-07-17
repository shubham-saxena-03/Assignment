package stepDefinitions;

import org.junit.Assert;

import common.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.FlightSearchPage;
import pageObjects.FlightSearchResultsPage;

public class FlightSearchSteps extends Browser {

	FlightSearchPage flightSearch = new FlightSearchPage(driver);
	FlightSearchResultsPage searchResultsPage = new FlightSearchResultsPage(driver);
	
	@Given("^User is on the Emirates Web Application$")
	public void user_is_on_the_emirates_page() {
		flightSearch.navigateToEmirates();
	}
	
	@When("^I set (.*) as departure city$")
	public void Set_departure_city(String City) throws Exception {
		flightSearch.setDeparture(City);
	}
	
	@When("^I set (.*) as arrival city$")
	public void set_arrival_city(String City) throws Exception {
		flightSearch.setArrival(City);
	}
	
	@When("^I set the Detarture date as (.*)/(.*)/(.*) in dd-mm-yyyy format$")
	public void set_departure_date(int date, int month, int year) throws Exception {
		flightSearch.setArrivalorDepartureDate(date, month, year);
	}
	
	@When("^I set the Return date as (.*)/(.*)/(.*) in dd-mm-yyyy format$")
	public void set_return_date(int date, int month, int year) throws Exception {
		flightSearch.setArrivalorDepartureDate(date, month, year);
	}
	
	@When("^I set (.*) as journey type$")
	public void set_journeytype(String journeyType) throws Exception {
		flightSearch.setJournryType(journeyType);
	}
	
	@When("^I initialize the search$")
	public void initialize_the_search() throws Exception {
		flightSearch.initializeSeach();
	}
	
	@When("^I should see flight search results$")
	public void I_should_see_search_results() throws Exception {
		boolean result = searchResultsPage.DoesFlightResultsFound();
		Assert.assertTrue("No flight result found with given search criteria.", result);
	}
}
