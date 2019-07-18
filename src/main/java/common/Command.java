package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	public boolean isWebElementExists(WebDriver driver, By locator, int Timeout) {
		try {
			int timeElapsed = 0;
			WebElement desiredElement = null;
			while(timeElapsed < Timeout) {
				timeElapsed += 1;
				desiredElement = driver.findElement(locator);
				if(desiredElement.isDisplayed()) {
					break;
				}
			}
			if(desiredElement!= null) {
				return desiredElement.isDisplayed();
			}else {throw new Exception("");}
		} catch (Exception e) {
			return false;
		}

	}
}
