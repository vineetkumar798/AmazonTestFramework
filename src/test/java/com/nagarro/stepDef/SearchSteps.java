package com.nagarro.stepDef;

import com.nagarro.TestRunner.Hooks;
import com.nagarro.pages.HomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    public SearchSteps() {
        homePage = new HomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        homePage.enterSearchTerm(searchTerm);
        homePage.clickSearchButton();
    }

    @Then("I should see the search results page for {string}")
    public void i_should_see_the_search_results_page(String searchTerm) {
        Assert.assertTrue(driver.getTitle().contains(searchTerm));
    }
}
