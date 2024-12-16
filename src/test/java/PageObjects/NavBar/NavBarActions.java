package PageObjects.NavBar;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;

public class NavBarActions extends NavBarElements {
    BrowserActions browserActions;
    Assertion assertion;

    public NavBarActions(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        assertion = new Assertion(driver);
    }
    public void clickSignUpLoginButton(){
        browserActions.click(SignUpLoginButton);
    }
    public void clickProductButton(){
        browserActions.click(ProductButton);
    }






}
