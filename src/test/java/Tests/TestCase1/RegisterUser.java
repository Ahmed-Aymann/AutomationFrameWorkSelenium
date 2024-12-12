package Tests.TestCase1;

import Config.Config;
import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.SignUpLogin.SingUPLoginActions;
import Tests.TestBase;
import Utilities.Utilities;
import org.testng.annotations.*;

public class RegisterUser extends TestBase {
    HomePageActions homePageActions;
    NavBarActions navBarActions;
    SingUPLoginActions singUPLoginActions;
    String url = Config.getProperty("URL");
//    @BeforeClass
//    public void setup() {
//
//    }


    public void NavigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }

    @Test
    public void RegisterUserTest() {
        homePageActions = new HomePageActions(driver);
        navBarActions = new NavBarActions(driver);
        singUPLoginActions = new SingUPLoginActions(driver);
        NavigateToUrl();
        String userName = Utilities.generateRandomString(7);
        String email = Utilities.generateRandomString(7) + "@gmail.com";
        homePageActions.validateHomePageTitleIsDisplayed();
        navBarActions.clickSignUpLoginButton();
        singUPLoginActions.validateNewUserSignUpTitleIsDisplayed();
        singUPLoginActions.enterSignUPNameInput(userName);
        singUPLoginActions.enterSignUPEmailInput(email);
        singUPLoginActions.clickSignUpButton();
    }
}
