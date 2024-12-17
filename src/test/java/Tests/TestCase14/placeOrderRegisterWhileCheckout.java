package Tests.TestCase14;


import Tests.TestBase;
import Config.Config;

import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.CartPage.CartPageActions;
import PageObjects.VerifyProductquantityinCart.VerifyProductActions;
import PageObjects.DeleteAccountPage.DeleteAccountActions;
import PageObjects.PaymentPage.PaymentPageActions;
import PageObjects.


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class placeOrderRegisterWhileCheckout extends TestBase {
    HomePageActions homePageActions;
    NavBarActions navBarActions;
    CartPageActions cartPageActions;
    VerifyProductActions verifyProductActions;
    DeleteAccountActions deleteAccountActions;
    PaymentPageActions paymentPageActions;



    String url = Config.getProperty("URL");

    @BeforeMethod
    public void setupTest() {
        homePageActions = new HomePageActions(driver);
        navBarActions = new NavBarActions(driver);
        cartPageActions = new CartPageActions(driver);
        verifyProductActions = new VerifyProductActions(driver);
        deleteAccountActions = new DeleteAccountActions(driver);
        paymentPageActions = new PaymentPageActions(driver);
    }

    // Navigate to the application URL
    public void navigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }

    @Test
    public void PlaceOrderRegisterWhileCheckoutTest() {
        // Step1&2: Launch browser and navigate to the URL
        navigateToUrl();



       //3. Verify that home page is visible successfully
        homePageActions.validateHomePageTitleIsDisplayed();

       // 4. Add products to cart
        verifyProductActions.clickAddToCart();
        verifyProductActions.clickContinueShoppingButton();


        //5. Click 'Cart' button
        navBarActions.clickCartButton();

        //6. Verify that cart page is displayed
        cartPageActions.validateCarPageIsDisplayed();


        //7. Click Proceed To Checkout
        cartPageActions.clickProceedToCheckoutButton();

        //8. Click 'Register / Login' button



        //9. Fill all details in Signup and create account







 /*





10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button*/
}
