Feature: Create new account
#  Background is used for repetitive steps in all scenarios
  Background: setup create account scenarios
    When user click on "Sign in" link
    Then validate user is in sign in page
    When user click on "Create New Account" link

  Scenario: using Map as Data Table
    When user enter new account info using Map Data
      | name     | Ali          |
      | email    | random       |
      | password | Password@123 |

    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

  Scenario: using list as Data Table
    When user enter new account info using Map Data
      | Ali          |
      | random       |
      | Password@123 |

    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match
