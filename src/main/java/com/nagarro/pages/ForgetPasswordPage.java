package com.nagarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ForgetPasswordPage {
    WebDriver driver;

    
    @FindBy(xpath = "//*[@id='authportal-main-section']//form/h1")
    private WebElement passwordAssistanceText;
     
    @FindBy(xpath = "//*[@id='auth-error-message-box']/div/div/ul/li/span")
    private WebElement errorMessage;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPasswordAssistanceTextVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
            wait.until(ExpectedConditions.visibilityOf(passwordAssistanceText));           
            boolean isVisible = passwordAssistanceText.isDisplayed();
            System.out.println("Password Assistance text visibility: " + isVisible);
            return isVisible;
        } catch (Exception e) {
            System.out.println("Error checking visibility: " + e.getMessage());  
            return false;  
        }
    }
    
    
    public boolean isErrorMessageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
