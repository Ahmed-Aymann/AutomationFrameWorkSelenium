package PageObjects.SignUpLogin;

import Assertions.Assertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.WebDriver;

public class SingUPLoginActions extends SingUPLoginElements {
    BrowserActions browserActions;
    Assertion assertion;

    private String enteredFirstName;
    private String enteredLastName;
    private String enteredAddress;
    private String enteredState;
    private String enteredCity;
    private String enteredZipCode;

    public SingUPLoginActions(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        assertion = new Assertion(driver);
    }

    public void enterSignUPNameInput(String input) {
        browserActions.type(SignUPUserNameInput, input);
    }

    public void enterSignUPEmailInput(String input) {
        browserActions.type(SignUPEmailInput, input);
    }

    public void clickSignUpButton() {
        browserActions.click(SignUpButton);
    }

    public void validateNewUserSignUpTitleIsDisplayed() {
        assertion.assertElementIsDisplayed(NewUserSignUpTitle);
    }

    public void chooseGenderMr() {browserActions.click(ChooseGenderMr);}

    public void enterUserNewPassword(String input) {
        browserActions.type(UserNewPassword, input);
    }

    public void selectDay() {browserActions.click(SelectDay);}


    public void selectMonth (){browserActions.click(SelectMonth);}
    public void selectYear (){browserActions.click(SelectYear);}
    public void fillFirstNamefield(String input) {
        enteredFirstName = input;

        browserActions.type(FillFirstName, input);
    }
    public void fillLastNamefield(String input) {
        enteredLastName = input;
        browserActions.type(FillLastName, input);
    }
    public void fillCompanyfield(String input) {

        browserActions.type(FillCompany, input);
    }
    public void fillAddressfield(String input) {
        enteredAddress=input;
        browserActions.type(FillAddress, input);
    }
    public void selctCountry() {browserActions.click(SelctCountry);}

    public void fillStatefield(String input) {
        enteredState= input;
        browserActions.type(FillState, input);
    }
    public void fillCityfield(String input) {
        enteredCity= input;
        browserActions.type(FillCity, input);
    }
    public void fillZipCodefield(String input) {
        enteredZipCode=input;
        browserActions.type(FillZipCode, input);

    }
    public void fillMobilePhonefield(String input) {
       browserActions.type(FillMobilePhone,input);
    }
    public void clickCreateAccountButton() {browserActions.click(ClickCreateAccountButton);}

    public void checkaccountcreatedIsDisplayed(){assertion.assertElementIsDisplayed(Checkaccountcreated);}
    public void checkcontinuebutton (){browserActions.click(Checkcontinuebutton);}
    public void checkuserloginIsDisplayed(){assertion.assertElementIsDisplayed(Checkuserlogin);}

    public void checkaccountdeletedIsDisplayed(){assertion.assertElementIsDisplayed(Checkaccountdeleted);}



}





















