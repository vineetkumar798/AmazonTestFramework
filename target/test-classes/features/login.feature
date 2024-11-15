@LoginTest
Feature: Amazon Login

Background:
  Given I am on the Amazon home page

Scenario: Login with valid username
    When I click on account list
    And I enter "vineet123@gmail.com" as the username
    And I click continue
    Then I should be taken to the password page
   
Scenario: Unsuccessful login attempt
    When I click on account list
    And I enter "invaliduser" as the username
    And I click continue
    Then I should see an error message indicating invalid login

