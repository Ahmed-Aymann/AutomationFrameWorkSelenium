package Tests.TestCase24;

import Config.Config;
import PageObjects.AddProductsinCart.AddProductActions;
import PageObjects.CartPage.CartPageActions;
import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.OrderPage.OrderPageActions;
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
    OrderPageActions orderPageActions;

    String userName = Utilities.generateRandomString(7);
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


    @BeforeMethod
    public void setupTest() {
        homePageActions = new HomePageActions(driver);
        testCasesActions = new TestCasesActions(driver);
        addProductActions = new AddProductActions(driver);
        navbarActions =new NavBarActions(driver);
        cartPageActions = new CartPageActions(driver);
        signUpLoginActions = new SingUPLoginActions(driver);
        orderPageActions = new OrderPageActions(driver);
        driver.manage().window().maximize();
    }
    public void navigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }
@Test
    public void downloadInvoiceTest()
{
    //  Navigate to the URL
    navigateToUrl();

    //  Verify the homepage is visible
    homePageActions.validateHomePageTitleIsDisplayed();
    //  Click 'Products' button
    addProductActions.clickProductsButton();
    //  Hover over first product and click 'Add to cart'
    addProductActions.AddFirstProductToCart();
    //  Click 'Continue Shopping'
    addProductActions.clickContinueShopping();
    navbarActions.clickCartButton();
    // Verify that cart page is displayed
    cartPageActions.validateCarPageIsDisplayed();
    // Click Proceed To Checkout
    cartPageActions.clickProceedToCheckout();
    // Click 'Register / Login' button
    signUpLoginActions.clickRegisterLogin();
    // Fill all details in Signup and create account
    signUpLoginActions.enterSignUPNameInput(userName);
    signUpLoginActions.enterSignUPEmailInput(email);
    signUpLoginActions.clickSignUpButton();
    signUpLoginActions.chooseGenderMr();
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
    //Verify 'ACCOUNT CREATED!' and click 'Continue' button
    signUpLoginActions.checkaccountcreatedIsDisplayed();
    signUpLoginActions.checkcontinuebutton();
    // Verify ' Logged in as username' at top
    signUpLoginActions.checkuserloginIsDisplayed();
    // Click 'Cart' button
    homePageActions.clickCartButton();
    //Click 'Proceed To Checkout' button
    cartPageActions.clickProceedToCheckout();

    // Place Order
  orderPageActions.enterOrderComment("Please deliver as soon as possible.");
    orderPageActions.clickPlaceOrder();

    cartPageActions.enterPaymentDetails("Ahmed Medhat", "1234567812345678", "123", "12", "2025");
      cartPageActions.clickPayAndConfirmOrder();
      cartPageActions.verifySuccessMessage();
      cartPageActions.clickDownloadInvoice();
      cartPageActions.clickContinue();
      cartPageActions.clickDeleteAccount();
      cartPageActions.verifyAccountDeleted();
      cartPageActions.clickContinue();

    }

}
