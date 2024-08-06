Feature: Create new account
#  Background is used for repetitive steps in all scenarios
  Background: setup create account scenarios
    When user click on "Sign in" link
    Then validate user is in sign in page
    When user click on "Create New Account" link

  Scenario: create valid account with random email
    When user enter "Name" and "random"  and "Password@123"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

    Scenario: Create account with existing email
      When user enter "Name" and "john.doe@gmail.com"  and "Password@123"
      When user click on "Sign Up" button
      Then user should see error "this email is already exist, please use another email address"