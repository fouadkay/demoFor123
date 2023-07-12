package com.cydeo.step_definitions;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LibraryLogin_StepDef {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
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
    public void i_enter_username(String string) {

    }

    @When("I enter password {string}")
    public void i_enter_password(String string) {


    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {

    }

    @When("there should be {int} users")
    public void there_should_be_users(Integer int1) {


    }




}
