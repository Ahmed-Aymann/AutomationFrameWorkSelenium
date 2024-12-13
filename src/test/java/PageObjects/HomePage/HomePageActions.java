package PageObjects.HomePage;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;

public class HomePageActions extends HomePageElements {
    BrowserActions browserActions;
    Assertion assertion;

    public HomePageActions(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        assertion = new Assertion(driver);
    }

    public void navigateToHomePage(String url) {
        browserActions.navigateToURl(url); // Open the given URL
    }

    public void validateHomePageTitleIsDisplayed() {
        assertion.assertElementIsDisplayed(homePageHeader); // Validate that the home page header is displayed
    }
}
