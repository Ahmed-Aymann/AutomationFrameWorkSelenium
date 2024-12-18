package Tests.TestCase23;

import Config.Config;
import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.SignUpLogin.SingUPLoginActions;
import PageObjects.AddProductsinCart.AddProductActions;
import PageObjects.VerifyProduct.VerifyProductActions;
import PageObjects.CartPage.CartPageActions;
import Tests.TestBase;
import Utilities.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verifyproduct extends TestBase {
    HomePageActions homePageActions;
    NavBarActions navBarActions;
    SingUPLoginActions singUPLoginActions;
    AddProductActions addProductActions;
    CartPageActions cartPageActions;
    VerifyProductActions verifyProductActions;
    String url = Config.getProperty("URL");

    @BeforeMethod
    public void setupTest() {
        homePageActions = new HomePageActions(driver);
        navBarActions = new NavBarActions(driver);
        singUPLoginActions = new SingUPLoginActions(driver);
        addProductActions = new AddProductActions(driver);
        cartPageActions = new CartPageActions(driver);
        verifyProductActions = new VerifyProductActions(driver);
    }


    public void NavigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }

    @Test
    public void verifyproductTest() {

        NavigateToUrl();
        String userName = Utilities.generateRandomString(7);
        String email = Utilities.generateRandomString(7) + "@gmail.com";
        //  String newusername = Utilities.generateRandomString(7);
        // String newuseremail = Utilities.generateRandomString(7) + "@gmail.com";
        String newuserpassword = Utilities.generateRandomString(30);
        String firstname = Utilities.generateRandomString(7);
        String lastname = Utilities.generateRandomString(7);
        String company = Utilities.generateRandomString(7);
        String address = Utilities.generateRandomString(7);
        String state = Utilities.generateRandomString(7);
        String city = Utilities.generateRandomString(7);
        String zip = Utilities.generateRandomString(4);
        String number = Utilities.generateRandomString(9);


        homePageActions.validateHomePageTitleIsDisplayed();
        navBarActions.clickSignUpLoginButton();
        singUPLoginActions.validateNewUserSignUpTitleIsDisplayed();
        singUPLoginActions.enterSignUPNameInput(userName);
        singUPLoginActions.enterSignUPEmailInput(email);
        singUPLoginActions.clickSignUpButton();
        singUPLoginActions.chooseGenderMr();

        singUPLoginActions.enterUserNewPassword(newuserpassword);
        singUPLoginActions.selectDay();
        singUPLoginActions.selectMonth();
        singUPLoginActions.selectYear();
        singUPLoginActions.fillFirstNamefield(firstname);
        singUPLoginActions.fillLastNamefield(lastname);
        singUPLoginActions.fillCompanyfield(company);
        singUPLoginActions.fillAddressfield(address);
        singUPLoginActions.selctCountry();
        singUPLoginActions.fillStatefield(state);
        singUPLoginActions.fillCityfield(city);
        singUPLoginActions.fillZipCodefield(zip);
        singUPLoginActions.fillMobilePhonefield(number);
        singUPLoginActions.clickCreateAccountButton();
        singUPLoginActions.checkaccountcreatedIsDisplayed();
        singUPLoginActions.checkcontinuebutton();
        singUPLoginActions.checkuserloginIsDisplayed();

        String registereddeliveryAddress = firstname + " " + lastname + ", " +
                city + " " + address + " " + state + " " + zip;

        String registeredbillingAddress = firstname + " " + lastname + ", " +
                city + " " + address + " " + state + " " + zip;


        addProductActions.clickProductsButton();
        addProductActions.AddFirstProductToCart();
        addProductActions.clickContinueShopping();
        addProductActions.addSecondProductToCart();
        addProductActions.clickViewCartButton();
        cartPageActions.verifyCartPageIsDisplayed();
        verifyProductActions.clickCheckOutBUTTON();


        String actualDeliveryAddress = verifyProductActions.getDeliveryAddress();
        verifyProductActions.checkDeliveryAddress(registereddeliveryAddress);

        System.out.println("Registered Delivery Address: " + registereddeliveryAddress);
        System.out.println("Delivery Address: " + actualDeliveryAddress);
        System.out.println("Test Passed: Delivery address matches the registered address.");

        System.out.println("////////////////////////////////////////////////////////////////////");


        String actualBillingAddress = verifyProductActions.getBillingAddress();
        verifyProductActions.checkBillingAddress(registeredbillingAddress);

        System.out.println("Registered Billing Address: " + registeredbillingAddress);
        System.out.println("Billing Address: " + actualBillingAddress);
        System.out.println("Test Passed: billing address matches the registered address.");
        navBarActions.clickDeleteAccountButton();
        singUPLoginActions.checkaccountdeletedIsDisplayed();


    }
}






