package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UsersStepDef {

    DashboardPage dashboardPage = new DashboardPage();


    @Given("I click on {string} link")
    public void i_click_on_link(String link) {

        switch (link.toLowerCase()){

            case "dashboard":



        }




    }



    @Then("table should have following column names:")
    public void table_should_have_following_column_names(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
