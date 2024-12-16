package Tests.TestCase24;

import Config.Config;
import PageObjects.AddProductsinCart.AddProductActions;
import PageObjects.CartPage.CartPageActions;
import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.SignUpLogin.SingUPLoginActions;
import PageObjects.TestCase.TestCasesActions;
import Tests.TestBase;
import Utilities.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadInvoice  extends TestBase {
    HomePageActions homePageActions;
    TestCasesActions testCasesActions;
    String url = Config.getProperty("URL");// URL for the test
    AddProductActions  addProductActions;
    NavBarActions navbarActions;
    CartPageActions cartPageActions;
    SingUPLoginActions signUpLoginActions;
    @BeforeMethod
    public void setupTest() {
        homePageActions = new HomePageActions(driver);
        testCasesActions = new TestCasesActions(driver);
        addProductActions = new AddProductActions(driver);
        navbarActions =new NavBarActions(driver);
        cartPageActions = new CartPageActions(driver);
        signUpLoginActions = new SingUPLoginActions(driver);

    }
    public void navigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }
@Test
    public void downloadInvoiceTest()
{
    // Step 1: Navigate to the URL
    navigateToUrl();

    // Step 2: Verify the homepage is visible
    homePageActions.validateHomePageTitleIsDisplayed();
    // Step 3: Click 'Products' button
    addProductActions.clickProductsButton();
    // Step 4: Hover over first product and click 'Add to cart'
    addProductActions.AddFirstProductToCart();
    // Step 5: Click 'Continue Shopping'
    addProductActions.clickContinueShopping();
    navbarActions.clickCartButton();
    //step 6: Verify that cart page is displayed
    cartPageActions.validateCarPageIsDisplayed();
    //step 7 : Click Proceed To Checkout
    cartPageActions.clickProceedToCheckout();
    //step 8 : Click 'Register / Login' button
    signUpLoginActions.clickRegisterLogin();
    //step 9: Fill all details in Signup and create account
    String userName = Utilities.generateRandomString(7);
    String email = Utilities.generateRandomString(7) + "@gmail.com";
    signUpLoginActions.validateNewUserSignUpTitleIsDisplayed();
   signUpLoginActions.enterSignUPNameInput(userName);
   signUpLoginActions.enterSignUPEmailInput(email);
    signUpLoginActions.clickSignUpButton();
    //step 10:  Verify 'ACCOUNT CREATED!' and click 'Continue' button

    }

}
