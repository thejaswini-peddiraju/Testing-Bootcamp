Feature: Register User With Existing Email

  Scenario: Attempt to sign up using an email that is already registered
    Given I am on the Automation Exercise home page
    Then the home page should be visible successfully
    When I click on the "Signup / Login" button
    Then I should see "New User Signup!"
    When I enter the already-registered name and email address
    And I click on the "Signup" button
    Then I should see "Email Address already exist!"
