package com.org.pages;

import com.org.utilities.CustomWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    private By firstName = By.xpath("//input[@id='accountFrm_firstname']");
    private By lastName = By.xpath("//input[@id='accountFrm_lastname']");
    private By email = By.xpath("//input[@id='accountFrm_email']");
    private By password = By.xpath("//input[@id='accountFrm_password']");
    private By confirmPassword = By.xpath("//input[@id='accountFrm_confirm']");
    private By registerBtn = By.xpath("//button[@title='Continue']");

    private By telephone = By.xpath("//input[@id='AccountFrm_telephone']");
    private By fax = By.xpath("//input[@id='AccountFrm_fax']");
    private By company = By.xpath("//input[@id='AccountFrm_company']");
    private By address1 = By.xpath("//input[@id='AccountFrm_address_1']");
    private By address2 = By.xpath("//input[@id='AccountFrm_address_2']");
    private By city = By.xpath("//input[@id='AccountFrm_city']");
    private By region = By.xpath("//select[@id='AccountFrm_zone_id']");
    private By zipCode = By.xpath("//input[@id='AccountFrm_postcode']");
    private By country = By.xpath("//select[@id='AccountFrm_country_id']");
    private By loginName = By.xpath("//input[@id='AccountFrm_loginname']");
    private By newsletterYes = By.xpath("//input[@id='AccountFrm_newsletter1']");
    private By newsletterNo = By.xpath("//input[@id='AccountFrm_newsletter0']");
    private By agreeCheckbox = By.xpath("//input[@id='AccountFrm_agree']");
    private By continueRegistrationBtn = By.xpath("//button[@title='Continue']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage clickContinueRegistration() {
        CustomWait.waitForElementVisible(driver, continueRegistrationBtn, 5).click();
        return this;
    }

    public RegistrationPage enterFirstName(String firstNameValue) {
        CustomWait.waitForElementVisible(driver, firstName, 5).sendKeys(firstNameValue);
        return this;
    }

    public RegistrationPage enterLastName(String lastNameValue) {
        CustomWait.waitForElementVisible(driver, lastName, 5).sendKeys(lastNameValue);
        return this;
    }

    public RegistrationPage enterEmail(String emailValue) {
        CustomWait.waitForElementVisible(driver, email, 5).sendKeys(emailValue);
        return this;
    }

    public RegistrationPage enterPassword(String passwordValue) {
        CustomWait.waitForElementVisible(driver, password, 5).sendKeys(passwordValue);
        return this;
    }

    public RegistrationPage enterConfirmPassword(String confirmPasswordValue) {
        CustomWait.waitForElementVisible(driver, confirmPassword, 5).sendKeys(confirmPasswordValue);
        return this;
    }

    public RegistrationPage enterTelephone(String telephoneValue) {
        CustomWait.waitForElementVisible(driver, telephone, 5).sendKeys(telephoneValue);
        return this;
    }

    public RegistrationPage enterFax(String faxValue) {
        CustomWait.waitForElementVisible(driver, fax, 5).sendKeys(faxValue);
        return this;
    }

    public RegistrationPage enterCompany(String companyValue) {
        CustomWait.waitForElementVisible(driver, company, 5).sendKeys(companyValue);
        return this;
    }

    public RegistrationPage enterAddress1(String address1Value) {
        CustomWait.waitForElementVisible(driver, address1, 5).sendKeys(address1Value);
        return this;
    }

    public RegistrationPage enterAddress2(String address2Value) {
        CustomWait.waitForElementVisible(driver, address2, 5).sendKeys(address2Value);
        return this;
    }

    public RegistrationPage enterCity(String cityValue) {
        CustomWait.waitForElementVisible(driver, city, 5).sendKeys(cityValue);
        return this;
    }

    public RegistrationPage selectRegion(String regionValue) {
        CustomWait.waitForElementVisible(driver, region, 5).sendKeys(regionValue);
        return this;
    }

    public RegistrationPage enterZipCode(String zipCodeValue) {
        CustomWait.waitForElementVisible(driver, zipCode, 5).sendKeys(zipCodeValue);
        return this;
    }

    public RegistrationPage selectCountry(String countryValue) {
        CustomWait.waitForElementVisible(driver, country, 5).sendKeys(countryValue);
        return this;
    }

    public RegistrationPage enterLoginName(String loginNameValue) {
        CustomWait.waitForElementVisible(driver, loginName, 5).sendKeys(loginNameValue);
        return this;
    }

    public RegistrationPage selectNewsletter(boolean subscribe) {
        if (subscribe) {
            driver.findElement(newsletterYes).click();
        } else {
            driver.findElement(newsletterNo).click();
        }
        return this;
    }

    public RegistrationPage agreeToPrivacyPolicy() {
        driver.findElement(agreeCheckbox).click();
        return this;
    }



    public HomePage clickOnRegister() {
        driver.findElement(registerBtn).click();
        return new HomePage(driver);
    }
}
