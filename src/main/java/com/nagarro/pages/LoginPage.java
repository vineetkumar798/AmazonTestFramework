package com.nagarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "ap_email")
    WebElement usernameField;

    @FindBy(id = "continue")
    WebElement continueButton;
    
    @FindBy(xpath = "//div[@id=\"auth-email-invalid-claim-alert\"]/div/div")
    private WebElement errorMessage;
    
    @FindBy(id = "ap_password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//*[@id='auth-fpp-link-bottom']")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void clickContinue() {
        continueButton.click();
    }
    
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));       
        return errorMessage.isDisplayed();
    }
    
    public void waitForPasswordField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField));  
    }
    
    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }
    
    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }
    
}
