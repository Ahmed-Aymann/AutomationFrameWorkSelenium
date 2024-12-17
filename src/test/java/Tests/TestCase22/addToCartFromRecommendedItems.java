package Tests.TestCase22;

import Tests.TestBase;
import Config.Config;import PageObjects.AddToCartFromRecommendedItems.AddToCartRecommendedItemsActions;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class addToCartFromRecommendedItems extends TestBase {
    String url = Config.getProperty("URL");
    AddToCartRecommendedItemsActions addToCartRecommendedItemsActions;

    @BeforeMethod
    public void setupTest() {
        addToCartRecommendedItemsActions = new AddToCartRecommendedItemsActions(driver);
    }
    @Test
    public void addToCartRecommendedItemsActions(){
        // Step 1: Launch browser and navigate to URL
        addToCartRecommendedItemsActions.navigateToUrl(url);
        // Step 2: Scroll to the bottom of the page
        addToCartRecommendedItemsActions.scrollToRecommendedItems();
        // Step 3: Verify 'Recommended Items' are visible
        Assert.assertTrue(addToCartRecommendedItemsActions.verifyRecommendedItemsVisible(), "'Recommended Items' section is not visible.");
        // Step 4: Click 'Add to Cart' on a recommended product
        addToCartRecommendedItemsActions.clickAddToCart();
        // Step 5: Click 'View Cart' button
        addToCartRecommendedItemsActions.clickViewCart();
        // Step 6:  Verify product is displayed in cart
        Assert.assertTrue(addToCartRecommendedItemsActions.verifyProductInCart(), "Product is not displayed in the cart.");



    }

}
