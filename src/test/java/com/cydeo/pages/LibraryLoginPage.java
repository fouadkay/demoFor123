package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="inputEmail")
    public WebElement emailInput;

    @FindBy(id="inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signinBtn;


    public void loginAsLibrarian(){
       emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
       passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
       signinBtn.click();
    }

    public void loginAsLibrarian(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signinBtn.click();
    }

}
