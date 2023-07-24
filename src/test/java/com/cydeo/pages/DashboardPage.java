package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_count")
    public WebElement usersAmount;

    @FindBy(css = "a#navbarDropdown>span")
    public WebElement usernameLink;

    @FindBy(linkText = "Users")
    public WebElement usersLink;

    @FindBy(linkText = "Users")
    public WebElement dashboardLink;

    @FindBy(linkText = "Users")
    public WebElement booksLink;

}
