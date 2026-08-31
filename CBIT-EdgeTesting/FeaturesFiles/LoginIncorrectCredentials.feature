Feature: Login User With Incorrect Credentials

  Scenario: Login attempt with an invalid email and password
    Given I am on the Automation Exercise home page
    Then the home page should be visible successfully
    When I click on the "Signup / Login" button
    Then I should see "Login to your account"
    When I enter an incorrect email address and password
    And I click on the "Login" button
    Then I should see "Your email or password is incorrect!"
