Feature: Search for products
  @UserStory7
  Scenario: Validate searched products are displayed
    When user enter "console" in search bar
    When user click on search button
    Then validate displayed products contains "console" in their title