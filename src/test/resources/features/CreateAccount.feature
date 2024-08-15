Feature: Create new account
#  Background is used for repetitive steps in all scenarios
  Background: Setup create account scenarios
    When user click on "Sign in" link
    Then validate user is in sign in page
    When user click on "Create New Account" link
    Then validate user is in sign Up page

  @UserStory4
  Scenario: Create valid account with random email
    When user enter "Name" in "Name" field
    When user enter "random email address" in "Email" field
    When user enter "Password@123" in "Password" field
    When user enter "Password@123" in "Confirm Password" field
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page matches with given email address

  @UserStory4.1
  Scenario: Create account with existing email
    When user enter "Name" in "Name" field
    When user enter "john.doe@gmail.com" in "Email" field
    When user enter "Password@123" in "Password" field
    When user enter "Password@123" in "Confirm Password" field
    When user click on "Sign Up" button
    Then user should see error "this email is already exist, please use another email address"

  @UserStory4.2
  Scenario: Validate error on all fields when no data entered
    When user click on "Sign Up" button
    Then user should see error under each field
      | Name     | Name is a required field             |
      | Email    | Email is a required field            |
      | Password | Password is a required field         |
      | Confirm  | Confirm Password is a required field |
