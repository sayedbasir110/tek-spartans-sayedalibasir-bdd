Feature: Security test scenarios

  Scenario: Validate successful login when user enters valid credentials
    When user click on "Sign in" link
    Then validate user is in "Sign in" page
    When user enters "john.doe@gmail.com" and "John@123"
    When user click on "Login" button
    Then user should be able to see account link

  Scenario Outline: Validate error when user enters invalid credentials
    When user click on "Sign in" link
    Then validate user is in "Sign in" page
    When user enters "<username>" and "<password>"
    When user click on "Login" button
    Then user should see error "wrong username or password!"
    Examples:
      | username           | password      |
      | invalid@gmail.com  | John@123      |
      | john.doe@gmail.com | WrongPassword |
      | invalid@gmail.com  | WrongPassword |