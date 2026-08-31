Feature: Login User With Correct Credentials

  Scenario: Login with a valid, already-registered account
    Given I am on the Automation Exercise home page
    Then the home page should be visible successfully
    When I click on the "Signup / Login" button
    Then I should see "Login to your account"
    When I enter the registered email address and correct password
    And I click on the "Login" button
    Then I should see "Logged in as"
    When I click on the "Delete Account" button
    Then I should see "ACCOUNT DELETED!"
    When I click on the "Continue" button
