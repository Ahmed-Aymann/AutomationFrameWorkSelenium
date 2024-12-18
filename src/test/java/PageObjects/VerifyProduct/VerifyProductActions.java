package PageObjects.VerifyProduct;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;




public class VerifyProductActions extends VerifyProductElements {

    Assertion assertion;
    BrowserActions browserActions;
    public VerifyProductActions(WebDriver driver){
        assertion = new Assertion(driver);
        browserActions = new BrowserActions(driver);
    }

    public void  clickCheckOutBUTTON(){browserActions.click(ProceedToCheckOutBUTTON);}
    public String getDeliveryAddress() {
        return browserActions.getText(CheckDeliveryAddress);
    }

    public String getBillingAddress() {
        return browserActions.getText(CheckBillingAddress);
    }



    public void checkDeliveryAddress(String registeredDeliveryAddress) {
        String actualDeliveryAddress = getDeliveryAddress();
        assertion.assertEquals(actualDeliveryAddress, registeredDeliveryAddress, "Delivery address does not match the registered address!");
    }

    public void checkBillingAddress(String registeredBillingAddress) {
        String actualBillingAddress = getBillingAddress();
        assertion.assertEquals(actualBillingAddress, registeredBillingAddress, "Billing address does not match the registered address!");
    }


}








