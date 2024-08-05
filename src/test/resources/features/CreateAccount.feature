Feature: Create new account
  Scenario: Navigate to Create Account page and Create new Account
    When User click on Sign in button
    Then Validate user is in Sign in page
    When User click on Create New Account button
    Then  Validate user is in Sign Up page
    When User enter new account information and click on Sign Up button
    Then Validate new account created