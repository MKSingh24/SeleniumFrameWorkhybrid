package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[@class='maintext']")
    private WebElement myAccountIcon;


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getMyAccountIconText(){
        return myAccountIcon.getText();
    }
    public boolean isMyAccountIconDisplayed(){
        return myAccountIcon.isDisplayed();
    }

    public boolean verifyAccountIconText(){
        String iconText = getMyAccountIconText();
        return iconText != null && !iconText.isEmpty();
    }
}
