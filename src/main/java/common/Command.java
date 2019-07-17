package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Command{

//	private WebDriver driver;
	
//	public Command() {
//		this.driver = super.getDriver();
//	}
	
	/**
	 * Function to wait for the visibility of given element till defined timeout
	 * @param ele
	 * @param Timeout
	 * @return
	 */
	public boolean isWebElementExists(WebDriver driver, WebElement ele, int Timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Timeout);
					wait.until(ExpectedConditions.visibilityOf(ele));
			return ele.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
}
