package Tests.TestCase2;

import Config.Config;
import PageObjects.HomePage.HomePageActions;
import PageObjects.NavBar.NavBarActions;
import PageObjects.ContactUs.ContactUsActions;
import Tests.TestBase;
import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ContactUs extends TestBase {
    HomePageActions homePageActions;
    NavBarActions navBarActions;
    ContactUsActions contactUsActions;
    String url = Config.getProperty("URL");

    @BeforeMethod
    public void setupTest() {
        homePageActions = new HomePageActions(driver);
        navBarActions = new NavBarActions(driver);
        contactUsActions = new ContactUsActions(driver);
    }
    public void navigateToUrl() {
        homePageActions.navigateToHomePage(url);
    }

    @Test
    public void ContactUsFormTest() {
        // Step 1: Navigate to the URL
        navigateToUrl();

        // Step 2: Verify the homepage is visible
        homePageActions.validateHomePageTitleIsDisplayed();

        // Step 3: Click on the 'Contact Us' button
        navBarActions.clickContactUsButton();

        // Step 4: Verify 'GET IN TOUCH' is visible
        contactUsActions.validateGetInTouchTitleIsDisplayed();

        // Step 5: Fill in the contact form details
        String name = Utilities.generateRandomString(7);
        String email = Utilities.generateRandomString(7) + "@gmail.com";
        String subject = "Test Subject";
        String message = "This is a test message.";
        contactUsActions.fillContactForm(name, email, subject, message);

        // Step 6: Upload file
        String filePath = "C:/Users/lenovo/IdeaProjects/AutomationFrameWorkSelenium/arget/images.png"; // put the path of the file u uploaded in the target file

        // Checking if the file exists before proceeding
        if (new File(filePath).exists()) {
            contactUsActions.uploadFileUsingRobot(filePath); // Call the upload method
            System.out.println("File uploaded successfully!");
        } else {
            System.out.println("File not found: " + filePath);
        }

        // Step 7: Submit the form
        contactUsActions.clickSubmitButton();

        // Step 8: Handle alert (Click OK button)
        contactUsActions.acceptAlert();

        // Step 9: Verify success message is displayed
        contactUsActions.validateSuccessMessageIsDisplayed();

        // Step 10: Navigate back to the home page and verify
        navBarActions.clickHomeButton();
        homePageActions.validateHomePageTitleIsDisplayed();
    }
}
