package Tests.TestCase14;


import Tests.TestBase;
import Config.Config;
import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.CartPage.CartPageActions;
import PageObjects.VerifyProductquantityinCart.VerifyProductActions;
import PageObjects.DeleteAccountPage.DeleteAccountActions;
import PageObjects.PaymentPage.PaymentPageActions;
import PageObjects.SignUpLogin.SingUPLoginActions;
import Utilities.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckout extends TestBase {
    HomePageActions homePageActions;
    NavBarActions navBarActions;
    CartPageActions cartPageActions;
    VerifyProductActions verifyProductActions;
    DeleteAccountActions deleteAccountActions;
    PaymentPageActions paymentPageActions;
    SingUPLoginActions signUpLoginActions;
    String url = Config.getProperty("URL");

    @BeforeMethod
    public void setupTest() {
        homePageActions = new HomePageActions(driver);
        navBarActions = new NavBarActions(driver);
        cartPageActions = new CartPageActions(driver);
        verifyProductActions = new VerifyProductActions(driver);
        deleteAccountActions = new DeleteAccountActions(driver);
        paymentPageActions = new PaymentPageActions(driver);
        signUpLoginActions = new SingUPLoginActions(driver);

    }

    // Navigate to the application URL
    public void navigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }

    @Test
    public void PlaceOrderRegisterWhileCheckoutTest() {

        // Step1&2: Launch browser and navigate to the URL
        navigateToUrl();

        String userName = Utilities.generateRandomString(7);
        String comment = Utilities.generateRandomString(15);
        String email = Utilities.generateRandomString(7) + "@gmail.com";
        String newuserpassword = Utilities.generateRandomString(30);
        String firstname = Utilities.generateRandomString(7);
        String lastname = Utilities.generateRandomString(7);
        String company = Utilities.generateRandomString(7);
        String address = Utilities.generateRandomString(7);
        String state = Utilities.generateRandomString(7);
        String city = Utilities.generateRandomString(7);
        String zip = Utilities.generateRandomString(4);
        String number = Utilities.generateRandomString(9);


        // for payment info
        String cardName = Utilities.generateRandomString(20);
        //String cardNumber = Utilities.generateRandomString(15);
        String cardNumber = String.valueOf(Utilities.generateRandomNumber(13, 16));








        //3. Verify that home page is visible successfully
        homePageActions.validateHomePageTitleIsDisplayed();

        // 4. Add products to cart
        verifyProductActions.clickViewProduct();
        verifyProductActions.clickAddToCart();
        verifyProductActions.clickContinueShoppingButton();


        //5. Click 'Cart' button
        navBarActions.clickCartButton();

        //6. Verify that cart page is displayed
        cartPageActions.validateCarPageIsDisplayed();


        //7. Click Proceed To Checkout
        cartPageActions.clickProceedToCheckoutButton();

        //8. Click 'Register / Login' button
        cartPageActions.clickRegisterLoginButton();


        //9. Fill all details in Signup and create account
        // first signup in the New User Signup! by typing email and name then click on sign up button
        signUpLoginActions.enterSignUPNameInput(userName);
        signUpLoginActions.enterSignUPEmailInput(email);
        signUpLoginActions.clickSignUpButton();

        // second fill the rest of the info and create the account
        signUpLoginActions.enterUserNewPassword(newuserpassword);
        signUpLoginActions.selectDay();
        signUpLoginActions.selectMonth();
        signUpLoginActions.selectYear();
        signUpLoginActions.fillFirstNamefield(firstname);
        signUpLoginActions.fillLastNamefield(lastname);
        signUpLoginActions.fillCompanyfield(company);
        signUpLoginActions.fillAddressfield(address);
        signUpLoginActions.selctCountry();
        signUpLoginActions.fillStatefield(state);
        signUpLoginActions.fillCityfield(city);
        signUpLoginActions.fillZipCodefield(zip);
        signUpLoginActions.fillMobilePhonefield(number);
        signUpLoginActions.clickCreateAccountButton();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        signUpLoginActions.checkaccountcreatedIsDisplayed();
        signUpLoginActions.checkcontinuebutton();

        //11. Verify ' Logged in as username' at top
        signUpLoginActions.checkuserloginIsDisplayed();

        //12.Click 'Cart' button
        navBarActions.clickCartButton();

        //13. Click 'Proceed To Checkout' button
        cartPageActions.clickProceedToCheckoutButton();

        //14. Verify Address Details and Review Your Order
        cartPageActions.validateAddressTitleIsDisplayed();
        cartPageActions.validateAddressDetailsIsDisplayed();
        cartPageActions.validateOrderIsDisplayed();

        //15. Enter description in comment text area and click 'Place Order'
        cartPageActions.enterComment(comment);
        cartPageActions.clickPlaceOrderButton();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        paymentPageActions.enterCardName(cardName);
        paymentPageActions.enterCardNumber(cardNumber);
        paymentPageActions.enterCVC("123");
        paymentPageActions.enterMonth("10");
        paymentPageActions.enterYear("2026");

        //17. Click 'Pay and Confirm Order' button
        paymentPageActions.clickPayAndConfirmButton();

        //18. Verify success message 'Your order has been placed successfully!'
        //paymentPageActions.validateSuccessMessageIsDisplayed();

        //19. Click 'Delete Account' button
        navBarActions.clickDeleteAccountButton();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        deleteAccountActions.validateAccountDeletedMessageIsDisplayed();
        deleteAccountActions.clickContinueButton();


    }

}
