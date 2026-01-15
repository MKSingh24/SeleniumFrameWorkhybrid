package com.org.pages;

import com.org.utilities.CustomWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By userName=By.xpath("//input[@id='loginFrm_loginname']");
//    private By password=By.id("loginFrm_password");
    private By password=By.cssSelector("input#loginFrm_password");
    private By loginBtn=By.xpath("//button[@class='btn btn-orange pull-right' and @title='Login']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage enterUsername(String username){
//        driver.findElement(userName).sendKeys(username);
        CustomWait.waitForElementVisible(driver,userName,5).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public HomePage clickOnLogin(){
        driver.findElement(loginBtn).click();
        return new HomePage(driver);


    }

}
