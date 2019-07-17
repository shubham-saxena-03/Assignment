package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Command;

public class FlightSearchPage {

	private WebDriver driver;
	private Command command = new Command();

	public FlightSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	/* Region WebElements and Locators */
	private WebElement Input_Departure() {
		return driver.findElement(By.xpath("//input[@name='Departure airport']"));
	}

	private WebElement Input_Arrival() {
		return driver.findElement(By.xpath("//input[@name='Arrival airport']"));
	}

	private WebElement DropdownLink() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> dds = driver.findElements(By.xpath("//div[contains(@class,'dropdown__link ')]"));
		WebElement Desired = null;
		for(WebElement el : dds) {
			if(el.isDisplayed()) {
				Desired = el;
				break;
			}
		}
		return Desired;
	}

	private WebElement Input_OneWay() {
		return driver.findElement(By.xpath("//input[contains(@class,'checkbox__input js-one-way control__one-way')]"));
	}
	
	private WebElement Date(int month, int date, int year) {
		String locator = "//a[@data-month='"+(month-1)+"'][@data-year='"+year+"'][@data-date='"+date+"']";
		return driver.findElement(By.xpath(locator));
	}
	
	private WebElement Button_Submit() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	private WebElement Row_FlightSearchResult() {
		return driver.findElement(By.xpath("//div[@class='ts-fbr-flight-list-row__header-core']"));
	}
	
	/* End Region WebElements Locators */

	/**
	 * Function to navigate to Emirates Web Application
	 */
	public void navigateToEmirates() {
		driver.get("https://www.emirates.com/ae/english/");
	}

	/**
	 * Function to set the given departure location
	 * @param DepartFrom
	 * @throws Exception
	 */
	public void setDeparture(String DepartFrom) throws Exception {
		try {
			Input_Departure().clear();
			Input_Departure().sendKeys(DepartFrom);
			DropdownLink().click();
		} catch (Exception e) {
			throw new Exception("Unable to set the Departure." + e.getMessage());
		}
	}

	/**
	 * Function to set the given Arrival Location
	 * @param ArriveAt
	 * @throws Exception
	 */
	public void setArrival(String ArriveAt) throws Exception {
		try {
			Input_Arrival().clear();
			Input_Arrival().sendKeys(ArriveAt);
			DropdownLink().click();
		} catch (Exception e) {
			throw new Exception("Unable to set the Arrival." + e.getMessage());
		}
	}
	
	/**
	 * Function to set the Journey type based on the given argument
	 * @param JourneyType
	 * @throws Exception
	 */
	public void setJournryType(String JourneyType) throws Exception {
		try {
			if(JourneyType.equalsIgnoreCase("one way")) {
				Input_OneWay().click();
			}
		}catch (Exception e) {
			throw new Exception("Unable to set the Journey type."+e.getMessage());
		}
	}
	
	/**
	 * Function to set the arrival or departure date based on given arguments
	 * @param date
	 * @param month
	 * @param year
	 * @throws Exception
	 */
	public void setArrivalorDepartureDate(int date, int month, int year) throws Exception {
		try {
			Date(month, date, year).click();
		}catch (Exception e) {
			throw new Exception("Unable to set the arrival or departure date"+e.getMessage());
		}
	}
	
	/**
	 * Function to click the submit button and initialize the search
	 * @throws Exception
	 */
	public void initializeSeach() throws Exception {
		try {
			Button_Submit().click();
			command.isWebElementExists(driver, Row_FlightSearchResult(), 60);
		}catch(Exception e) {
			throw new Exception("Unable to initialize the Flight Search"+e.getMessage());
		}
	}

}
