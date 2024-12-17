package PageObjects.ContactUs;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsActions extends ContactUsElements {
    BrowserActions browserActions;
    Assertion assertion;

    public ContactUsActions(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        assertion = new Assertion(driver);
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        browserActions.type(NameInput, name);
        browserActions.type(EmailInput, email);
        browserActions.type(SubjectInput, subject);
        browserActions.type(MessageInput, message);
    }

  /* public void uploadFile(String filePath) {
       //browserActions.type(UploadFileInput, filePath);
        browserActions.click(FileInput);
        File fileToUpload = new File(filePath);


        if (fileToUpload.exists()) {
            fileToUpload.getAbsolutePath();
        } else {
            System.out.println("File not found: " + fileToUpload.getAbsolutePath());
            return;
        }

    }*/

    public void clickSubmitButton() {
        browserActions.click(SubmitButton);
    }

    public void acceptAlert() {
        browserActions.acceptAlert();
    }

    public void validateGetInTouchTitleIsDisplayed() {
        assertion.assertElementIsDisplayed(GetInTouchTitle);
    }

    public void validateSuccessMessageIsDisplayed() {
        assertion.assertElementTextEquals(SuccessMessage, "Success! Your details have been submitted successfully.");
    }


    public void uploadFileUsingRobot(String filePath) {
        try {
            // Click on the upload button
            browserActions.click(UploadFileButton);

            // Copy file path to clipboard
            StringSelection filePathSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

            // Use Robot to paste file path and press Enter
            Robot robot = new Robot();

            // Wait for file dialog to appear
            robot.delay(1000);

            // Simulate CTRL + V to paste
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);


            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
