Feature: Update user info
  Scenario: Validate user successfully update user info
    When user click on "Sign in" link
    Then validate user is in sign in page
    When user enter "john.doe@gmail.com" and "John@123"
    When user click on "Login" button
    When user click on "Account" link
    Then validate user is in account page
    When user clear data and enter "JOHN DOE" in "name" field
    When user clear data and enter "random" in "phoneNumber" field
    When user click on "Update" button
    Then validate success toast message is displayed
