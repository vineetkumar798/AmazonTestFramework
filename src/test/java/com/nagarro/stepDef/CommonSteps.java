package com.nagarro.stepDef;

import com.nagarro.TestRunner.Hooks;
import com.nagarro.pages.HomePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    @Given("I am on the Amazon home page")
    public void i_am_on_the_amazon_home_page() {
        homePage = new HomePage(driver);
    }
}
