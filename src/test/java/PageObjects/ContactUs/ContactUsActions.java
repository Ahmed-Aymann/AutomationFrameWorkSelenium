package PageObjects.ContactUs;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

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

    public void uploadFileUsingRobot(String filePath) {
        try {

            browserActions.click(FileInput);

            Robot robot = new Robot();
            robot.setAutoDelay(2000);

            StringSelection fileLocation = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileLocation, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println("Error during file upload: " + e.getMessage());
        }
    }

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
}
