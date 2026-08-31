Feature: Register User
  As a new visitor
  I want to create an account on Automation Exercise
  So that I can use the site as a registered user

  Scenario: Register a new user successfully
    Given I am on the Automation Exercise home page
    Then the home page should be visible successfully
    When I click on the "Signup / Login" button
    Then I should see "New User Signup!"
    When I enter a unique name and email address
    And I click on the "Signup" button
    Then I should see "ENTER ACCOUNT INFORMATION"
    When I fill in the account information details
    And I check the "Sign up for our newsletter!" checkbox
    And I check the "Receive special offers from our partners!" checkbox
    And I fill in the address information details
    And I click on the "Create Account" button
    Then I should see "ACCOUNT CREATED!"
    When I click on the "Continue" button
    Then I should see "Logged in as"
    When I click on the "Delete Account" button
    Then I should see "ACCOUNT DELETED!"
    When I click on the "Continue" button
