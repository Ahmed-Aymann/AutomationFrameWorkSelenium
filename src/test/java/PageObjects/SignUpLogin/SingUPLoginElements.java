package PageObjects.SignUpLogin;

import org.openqa.selenium.By;

public class SingUPLoginElements {
    By NewUserSignUpTitle=By.xpath("//div[@class='signup-form']/h2");
    By SignUPUserNameInput=By.xpath("//input[@data-qa='signup-name']");
    By SignUPEmailInput=By.xpath("//input[@data-qa='signup-email']");
    By SignUpButton=By.xpath("//button[@data-qa='signup-button']");

    //try dynamic
    By ChooseGenderMr =By.xpath("//input[@id='id_gender1']");
   // By ChooseGenderMrs =By.xpath("//input[@id='id_gender2']");
    //
   // By UserNewName =By.xpath("//input[@data-qa='name']");
  //  By UserNewEmail =By.xpath("//input[@data-qa='email']");
    By UserNewPassword =By.xpath("//input[@data-qa='password']");
    //create dynamic
    By SelectDay =By.xpath("//select[@data-qa='days']/option[text()='3']");
    By SelectMonth =By.xpath("//select[@id='months']/option[text()='March']");
    By SelectYear =By.xpath("//select[@id='years']/option[text()='2003']");
    //dynamic
    By FillFirstName=By.xpath("//input[@id='first_name']");
    By FillLastName=By.xpath("//input[@id='last_name']");
    By FillCompany=By.xpath("//input[@id='company']");
    By FillAddress=By.xpath("//input[@id='address1']");
    By SelctCountry =By.xpath("//select[@id='country']/option[text()='Canada']");
    By FillState=By.xpath("//input[@id='state']");
    By FillCity=By.xpath("//input[@id='city']");
    By FillZipCode=By.xpath("//input[@id='zipcode']");
    By FillMobilePhone=By.xpath("//input[@data-qa='mobile_number']");
    By ClickCreateAccountButton=By.xpath("//button[@data-qa='create-account']");
    By Checkaccountcreated=By.xpath("//h2[@class='title text-center']/b");
    By Checkcontinuebutton=By.xpath("//a[@data-qa='continue-button']");
    By Checkuserlogin=By.xpath("//i[@class='fa fa-user']");
}

