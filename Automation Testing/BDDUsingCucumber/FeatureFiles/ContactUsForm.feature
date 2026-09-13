Feature: Automation Exercise Contact Us Form

Scenario: Checking Contact Us Form Functionalities

Given User Should Launch Chrome browser
When User Should Navigate to url 'http://automationexercise.com'
Then User Should Verify that home page is visible successfully
Then User Should Click on 'Contact Us' button
Then User Should Verify 'GET IN TOUCH' is visible
Then User Should Enter name, email, subject and message
Then User Should Upload file
Then User Should Click 'Submit' button
Then User Should Click 'OK' button
Then User Should Verify success message 'Success! Your details have been submitted successfully.' is visible
Then User Should Click 'Home' button
Then User Should Verify that user is landed on home page successfully