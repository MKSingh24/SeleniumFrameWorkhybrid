package com.org.test;

import com.org.base.BaseTest;
import com.org.base.DriverFactory;
import com.org.pages.LoginPage;
import com.org.utilities.ConfigReader;
import com.org.utilities.ExcelUtil;
import com.org.utilities.ExcelUtilsAsMap;
import jdk.jfr.Enabled;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {

    @Test(enabled = true)
    public void loginTest(   ) {
        LoginPage lp = new LoginPage(DriverFactory.getDriver());
        lp.enterUsername(ConfigReader.get("username"))
                .enterPassword(ConfigReader.get("password"))
                .clickOnLogin();
    }

    @Test(dataProvider = "LoginData")
    public void loginWithExcelData(String username,String password  ) {
        LoginPage lp = new LoginPage(DriverFactory.getDriver());
        lp.enterUsername(username)
                .enterPassword(password)
                .clickOnLogin();
    }

    @DataProvider(name="LoginData")
    public Object[][] LoginData() {
        return ExcelUtil.getExcelData("src/test/resources/TestData/Login.xlsx", "Login");
    }

    @Test(enabled = false)
    public void LoginWithReadExcelDataAsMap(){
        List<Map<String,String>> data=ExcelUtilsAsMap.readExcelAsMap("src/test/resources/TestData/Login.xlsx","Login");

        for(Map<String,String> e:data){
            // Reload login page for each row
            DriverFactory.getDriver().get(ConfigReader.get("url"));
            LoginPage lp = new LoginPage(DriverFactory.getDriver());
            lp.enterUsername(e.get("username"))
                    .enterPassword(e.get("password"))
                    .clickOnLogin();


        }
    }
}
