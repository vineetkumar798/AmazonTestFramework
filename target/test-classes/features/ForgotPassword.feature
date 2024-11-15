@ForgotPassword
Feature: Forgot Password


Background:
  Given I am on the Amazon home page

 
  Scenario: User clicks "Forgot Password" and sees the Password Assistance text
    When I click on the Sign In button on the home page
    And I enter a valid email "vineet123@gmail.com" and click on the Forgot Password link
    Then I should see the Password Assistance text on the Forgot Password page
   
   Scenario: User clicks "Forgot Password" and sees the Password Assistance text
    When I click on the Sign In button on the home page
    And I enter a valid email "Ramesh123@gmail.com" and click on the Forgot Password link
    Then I should see the Password Assistance text on the Forgot Password page
    
   Scenario: User enters an invalid email and sees an error message
    When I click on the Sign In button on the home page
    And I enter an invalid email "invalidemail@test.com" and click the Continue button
    Then I should see an error message indicating the email address is not recognized
    And I should not see the Password Assistance text on the Forgot Password page
   
   