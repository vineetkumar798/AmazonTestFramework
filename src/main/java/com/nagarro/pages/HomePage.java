package com.nagarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "nav-link-accountList")
    WebElement accountList;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;
    
    @FindBy(xpath = "//*[@id='nav-signin-tooltip']/a/span")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAccountList() {
        accountList.click();
    }

    public void enterSearchTerm(String term) {
        searchBox.sendKeys(term);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
    
    public void clickSignIn() {
        signInButton.click();
    }
}
