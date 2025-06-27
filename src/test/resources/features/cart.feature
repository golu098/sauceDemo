Feature: Cart Functionality

  Scenario: Add and remove items from cart
    Given user is logged in on cart page
    When user adds backpack and bike light to cart
    Then cart should show 2 items

    When user navigates to the cart
    Then both backpack and bike light should be in the cart

    When user removes backpack
    Then only bike light should remain in the cart

    When user removes bike light
    Then cart should be empty
