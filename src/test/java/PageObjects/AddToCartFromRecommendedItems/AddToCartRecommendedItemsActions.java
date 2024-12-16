package PageObjects.AddToCartFromRecommendedItems;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;

public class AddToCartRecommendedItemsActions extends AddToCartRecommendedItemsElements{
    BrowserActions browserActions;
    Assertion assertion;
    public AddToCartRecommendedItemsActions(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        assertion = new Assertion(driver);
    }
    // Navigate to url
    public void navigateToUrl(String url){
        browserActions.navigateToURl(url);
    }
    // Scroll to 'Recommended Items'
    public void scrollToRecommendedItems(){
        browserActions.scrollTillElement(recommendedItemsSection);
    }
    // Verify 'Recommended Items' are visible
    public boolean verifyRecommendedItemsVisible(){
        return browserActions.waitUntilElementIsReady(recommendedItemsSection).isDisplayed();
    }
    // Click 'Add to Cart' on a recommended product
    public void clickAddToCart(){
        browserActions.click(addToCartButton);
    }
    // Click 'View Cart' button
    public void clickViewCart(){
        browserActions.click(viewCartButton);
    }
    // Verify product is displayed in cart
    public boolean verifyProductInCart(){
        return browserActions.waitUntilElementIsReady(productInCart).isDisplayed();

    }



}
