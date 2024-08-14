Feature: Update user info
  Scenario: Validate user successfully update user info
    When user click on "Sign in" link
    Then validate user is in sign in page
    When user enter "john.doe@gmail.com" in "Email" field
    When user enter "John@123" in "Password" field
    When user click on "Login" button
    Then user should be able to see "Account" link
    When user click on "Account" link
    Then validate user is in account page
    When user enter "JOHN DOE" in "Name" field
    When user enter "random phone number" in "Phone Number" field
    When user click on "Update" button
    Then validate success toast message is displayed
    Then validate account name is "JOHN DOE"
