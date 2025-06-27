Feature: Checkout Flow

  Scenario: Complete checkout with 2 items
    Given user is logged in for checkout
    When user adds backpack and bike light and proceeds to checkout
    And user fills in checkout form
    Then summary should contain two items and pricing should be shown
    And user finishes the checkout
