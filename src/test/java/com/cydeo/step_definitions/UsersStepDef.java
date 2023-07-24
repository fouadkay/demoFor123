package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.UsersPage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UsersStepDef {

    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();


    @Given("I click on {string} link")
    public void i_click_on_link(String link) {

        BrowserUtils.waitForVisibility(dashboardPage.dashboardLink,10);

        switch (link.toLowerCase()){

            case "dashboard":
            dashboardPage.dashboardLink.click();
            break;
            case "users":
            dashboardPage.usersLink.click();
            break;
            case "books":
                dashboardPage.booksLink.click();
                break;
        }
    }


    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedTableHeaders) {

   //  List<String> actualTableHeader = new ArrayList<>();

//        for (WebElement eachHeader : usersPage.tableHeaders) {
//            actualTableHeader.add(eachHeader.getText());
//        }


        List<String> actualTableHeader = BrowserUtils.getElementsText(usersPage.tableHeaders);

        Assert.assertEquals(expectedTableHeaders,actualTableHeader);


    }





}
