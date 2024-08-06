Feature: Security test scenarios

  Scenario: Navigate to sign in page and sign in with valid credentials and validate user successfully signed in
    When user click on "Sign in" link
    Then validate user is in "Sign in" page
    When user enters "john.doe@gmail.com" and "John@123"
    When user click on "Login" button
    Then user should be able to see account link

  Scenario Outline: Navigate to sign in page and sign in invalid credentials and validate error message displayed "wrong username or password"
    When user click on "Sign in" link
    Then validate user is in "Sign in" page
    When user enters "<username>" and "<password>"
    When user click on "Login" button
    Then user should see error "wrong username or password"
    Examples:
      | username           | password      |
      | invalid@gmail.com  | John@123      |
      | john.doe@gmail.com | WrongPassword |
      | invalid@gmail.com  | WrongPassword |