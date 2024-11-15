package com.nagarro.stepDef;

import com.nagarro.TestRunner.Hooks;
import com.nagarro.pages.HomePage;
import com.nagarro.pages.LoginPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @When("I click on account list")
    public void i_click_on_account_list() {
        homePage.clickOnAccountList();
    }

    @When("I enter {string} as the username")
    public void i_enter_as_the_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I click continue")
    public void i_click_continue() {
        loginPage.clickContinue();
    }

    @Then("I should be taken to the password page")
    public void i_should_be_taken_to_the_password_page() {
        loginPage.waitForPasswordField();
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
    }
    
    @Then("I should see an error message indicating invalid login")
    public void i_should_see_an_error_message_indicating_invalid_login() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),"Expected error message for invalid login is not displayed.");
                          
    }
}
