package com.org.base;

import com.org.utilities.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("url"));
//        DriverFactory.getDriver().get("https://automationteststore.com/index.php?rt=account/login");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
