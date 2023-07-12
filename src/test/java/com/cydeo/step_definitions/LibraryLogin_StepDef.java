package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LibraryLogin_StepDef {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
//      libraryLoginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
//      libraryLoginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
//      libraryLoginPage.signinBtn.click();

      //  libraryLoginPage.loginAsLibrarian();

        libraryLoginPage.loginAsLibrarian(ConfigurationReader.getProperty("lib22_user"),ConfigurationReader.getProperty("lib22_pass"));

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expectedURL = "dashboard";

        wait.until(ExpectedConditions.urlContains(expectedURL));

        String actualURL = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue("dashboard is not appear on URL",actualURL.contains(expectedURL));

    }


    @When("I enter username {string}")
    public void i_enter_username(String email) {
      libraryLoginPage.emailInput.sendKeys(email);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
    libraryLoginPage.passwordInput.sendKeys(password);

    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        libraryLoginPage.signinBtn.click();
    }

    @When("there should be {int} users")
    public void there_should_be_users(int expectedUserAmount) {

        //String expectedUserCount = ""+expectedUserAmount;
        String expectedUserCount = String.valueOf(expectedUserAmount);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.usersAmount));
        String actualUserCount = dashboardPage.usersAmount.getText();
        Assert.assertEquals("User count verification is failed!",expectedUserCount,actualUserCount);

    }

//    @And("there should be {string} users")
//    public void thereShouldBeUsers(String expectedUserCount) {
//
//        String actualUserCount = dashboardPage.usersAmount.getText();
//        Assert.assertEquals("User count verification is failed!",expectedUserCount,actualUserCount);
//
//    }


    @When("I login using {string} and {string}")
    public void i_login_using_and(String email, String password) {
        libraryLoginPage.loginAsLibrarian(email,password);
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedAccountName) {

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.usernameLink));
        String actualAccountName = dashboardPage.usernameLink.getText();

        Assert.assertEquals(expectedAccountName,actualAccountName);
    }



}
