package com.nagarro.stepDef;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.nagarro.TestRunner.Hooks;
import com.nagarro.pages.ForgetPasswordPage;
import com.nagarro.pages.HomePage;
import com.nagarro.pages.LoginPage;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;
    LoginPage loginPage;
    ForgetPasswordPage forgetPasswordPage;

    
    @When("I click on the Sign In button on the home page")
    public void i_click_on_the_sign_in_button_on_the_home_page() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    
    @When("I enter a valid email {string} and click on the Forgot Password link")
    public void i_enter_a_valid_email_and_click_on_the_forgot_password_link(String email) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(email);
        loginPage.clickContinue();
        loginPage.clickForgotPassword();
        forgetPasswordPage = new ForgetPasswordPage(driver);
    }

    
    @When("I enter an invalid email {string} and click the Continue button")
    public void i_enter_an_invalid_email_and_click_the_continue_button(String email) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(email);
        loginPage.clickContinue();
        forgetPasswordPage = new ForgetPasswordPage(driver);
    }

    
    @Then("I should see the Password Assistance text on the Forgot Password page")
    public void i_should_see_the_password_assistance_text_on_the_forgot_password_page() {
        forgetPasswordPage = new ForgetPasswordPage(driver);
        Assert.assertTrue(forgetPasswordPage.isPasswordAssistanceTextVisible(), "Password Assistance text is not visible.");
    }

    
    @Then("I should see an error message indicating the email address is not recognized")
    public void i_should_see_an_error_message_indicating_the_email_address_is_not_recognized() {
        assertTrue(forgetPasswordPage.isErrorMessageVisible(), "Expected error message not visible for invalid email.");
    }

    
    @Then("I should not see the Password Assistance text on the Forgot Password page")
    public void i_should_not_see_the_password_assistance_text_on_the_forgot_password_page() {
        Assert.assertFalse(forgetPasswordPage.isPasswordAssistanceTextVisible(), "Password Assistance text is visible when it should not be.");
    }
}
