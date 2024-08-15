Feature: Search for products and order items
  @UserStory7
  Scenario: User search for products
    When user enter "console" in search bar
    When user click on search button
    Then validate displayed products contains "console" in their title

    @UserStory8
    Scenario: User add product to cart and delete cart item
      When user click on "Sign in" link
      Then validate user is in sign in page
      When user enter "john.doe@gmail.com" in "Email" field
      When user enter "John@123" in "Password" field
      When user click on "Login" button
      Then user should be able to see "Account" link
      When user enter "TV" in search bar
      When user click on search button
      Then validate displayed products contains "TV" in their title
      When user click on a product
      Then validate user is in product page
      When user click on Add to Cart button
      Then validate item is added to the cart
      When user click on Cart button
      Then validate only one item is in the cart
      When user delete item from the cart
      Then validate item is deleted from the cart
