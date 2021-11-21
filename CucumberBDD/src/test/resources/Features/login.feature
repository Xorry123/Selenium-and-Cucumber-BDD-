Feature: feature to test login functionality

  Scenario: check login with valid credentials
    Given user is on login page
    When user enters valid login details
    And clicks login button
    Then user navigated to home page
