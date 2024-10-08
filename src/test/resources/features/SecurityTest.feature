Feature: Security test scenarios

@UserStory1
  Scenario: User login with valid credential successfully
    When user click on "Sign in" link
    Then validate user is in Sign in page
    When user enter "john.doe@gmail.com" in "Email" field
    When user enter "John@123" in "Password" field
    When user click on "Login" button
    Then user should be able to see "Account" link
@UserStory2,3
  Scenario Outline: User want to login with invalid credential
    When user click on "Sign in" link
    Then validate user is in Sign in page
    When user enter "<username>" in "Email" field
    When user enter "<password>" in "Password" field
    When user click on "Login" button
    Then user should see error "wrong username or password"
    Examples:
      | username           | password      |
      | invalid@gmail.com  | John@123      |
      | john.doe@gmail.com | WrongPassword |
      | invalid@gmail.com  | WrongPassword |