package PageObjects.PaymentPage;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;

public class PaymentPageActions extends PaymentPageElements {

    Assertion assertion;
    BrowserActions browserActions;

    public PaymentPageActions(WebDriver driver) {
        assertion = new Assertion(driver);
        browserActions = new BrowserActions(driver);
    }


    //enter card name
    public void enterCardName(String name) {
        browserActions.type(NAME_ON_CARD, name);
    }


    //enter card number
    public void enterCardNumber(int cardNumber) {
        browserActions.typeinteger(CARD_NUMBER, cardNumber);
    }


    //enter cvc
    public void enterCVC(int cvc) {
        browserActions.typeinteger(CVC, cvc);
    }


    //enter expiry day
    public void enterMonth(int month) {
        browserActions.typeinteger(EXPIRY_MONTH, month);
    }


    //enter expiry year
    public void enterYear(int year) {
        browserActions.typeinteger(EXPIRY_YEAR, year);
    }

    public void clickPayAndConfirmButton() {
        browserActions.click(PAYANDCONFIRM_BUTTON);
    }


    public void validateSuccessMessageIsDisplayed() {
        assertion.assertElementIsDisplayed(SUCCESS_MESSAGE);
    }


}




