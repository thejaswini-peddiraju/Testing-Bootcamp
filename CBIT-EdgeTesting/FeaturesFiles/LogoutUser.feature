Feature: Logout User

  Scenario: Login and then log out
    Given I am on the Automation Exercise home page
    Then the home page should be visible successfully
    When I click on the "Signup / Login" button
    Then I should see "Login to your account"
    When I enter the registered email address and correct password
    And I click on the "Login" button
    Then I should see "Logged in as"
    When I click on the "Logout" link
    Then I should be navigated to the login page
