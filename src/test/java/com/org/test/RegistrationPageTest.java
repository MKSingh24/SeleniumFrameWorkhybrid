package com.org.test;

import com.org.base.BaseTest;
import com.org.base.DriverFactory;
import com.org.pages.RegistrationPage;
import com.org.utilities.ConfigReader;
import com.org.utilities.ExcelUtil;
import com.org.utilities.ExcelUtilsAsMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class RegistrationPageTest extends BaseTest {

    @Test(enabled = true)
    public void registrationTest() {
        RegistrationPage rp = new RegistrationPage(DriverFactory.getDriver());
        rp.clickContinueRegistration();
        rp.enterFirstName(ConfigReader.get("firstName"))
                .enterLastName(ConfigReader.get("lastName"))
                .enterEmail(ConfigReader.get("email"))
                .enterPassword(ConfigReader.get("password"))
                .enterConfirmPassword(ConfigReader.get("password"))
                .agreeToPrivacyPolicy()
                .clickOnRegister();
    }

    @Test(dataProvider = "RegistrationData")
    public void registrationWithExcelData(String firstName, String lastName, String email, String password) {
        RegistrationPage rp = new RegistrationPage(DriverFactory.getDriver());
        rp.clickContinueRegistration();
        rp.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .agreeToPrivacyPolicy()
                .clickOnRegister();
    }

    @DataProvider(name = "RegistrationData")
    public Object[][] RegistrationData() {
        return ExcelUtil.getExcelData("src/test/resources/TestData/Registration.xlsx", "Registration");
    }

    @Test(enabled = false)
    public void registrationWithReadExcelDataAsMap() {
        List<Map<String, String>> data = ExcelUtilsAsMap.readExcelAsMap("src/test/resources/TestData/Registration.xlsx", "Registration");

        for (Map<String, String> e : data) {
            // Reload registration page for each row
            DriverFactory.getDriver().get(ConfigReader.get("url"));
            RegistrationPage rp = new RegistrationPage(DriverFactory.getDriver());
            rp.clickContinueRegistration();
            rp.enterFirstName(e.get("firstName"))
                    .enterLastName(e.get("lastName"))
                    .enterEmail(e.get("email"))
                    .enterPassword(e.get("password"))
                    .enterConfirmPassword(e.get("password"))
                    .agreeToPrivacyPolicy()
                    .clickOnRegister();
        }
    }
}
