Feature: Update user info
  Background: Setup update user info scenarios
    When user click on "Sign in" link
    Then validate user is in sign in page
    When user enter "john.doe@gmail.com" in "Email" field
    When user enter "John@123" in "Password" field
    When user click on "Login" button
    Then user should be able to see "Account" link
    When user click on "Account" link
    Then validate user is in account page

  @UserStory5
  Scenario: User update personal info successfully
    When user enter "JOHN DOE" in "Name" field
    When user enter "random phone number" in "Phone Number" field
    When user click on "Update" button
    Then validate success toast message is "Personal Information Updated Successfully"
    Then validate account name is "JOHN DOE"

    @UserStory6
    Scenario: User change password and reverts it back successfully
      When user enter "John@123" in "Previous Password" field
      When user enter "Johndoe$123" in "New Password" field
      When user enter "Johndoe$123" in "Confirm Password" field
      When user click on "Change Password" button
      Then validate success toast message is "Password Updated Successfully"
      When user enter "Johndoe$123" in "Previous Password" field
      When user enter "John@123" in "New Password" field
      When user enter "John@123" in "Confirm Password" field
      When user click on "Change Password" button
      Then validate success toast message is "Password Updated Successfully"

