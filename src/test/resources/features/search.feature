@SearchTest
Feature: Search functionality on Amazon

Background:
  Given I am on the Amazon home page

Scenario: Search for electronics
    When I search for "laptop"
    Then I should see the search results page for "laptop"

Scenario: Search for books
    When I search for "books"
    Then I should see the search results page for "books"
