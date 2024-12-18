package PageObjects.CartPage;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;




public class CartPageActions extends CartPageElements{


    Assertion assertion;
    BrowserActions browserActions;
    public CartPageActions(WebDriver driver){
        assertion = new Assertion(driver);
        browserActions = new BrowserActions(driver);
    }






    public void validateCarPageIsDisplayed() {
        assertion.assertElementIsDisplayed(CART_INFO);
    }


    public void clickRemoveButton() {
        browserActions.click(REMOVE_BUTTON);
    }

    public void validateDeletionMessageIsDisplayed() {
        assertion.assertElementIsDisplayed(MESSAGE_OF_EMPTY_CART);
    }
    public void verifyCartPageIsDisplayed() {
        assertion.assertElementIsDisplayed(VerifyCartPage);


    }

}
