Feature: Session Validation

  Scenario: Verify session is valid after page refresh
    Given user is logged in
    When user refreshes the page
    Then user should remain on the products page

  Scenario: Verify session is invalid after logout
    Given user is logged in
    When user logs out
    Then user should be redirected to the login page
