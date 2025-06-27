Feature: Login Feature

  Background:
    Given user is on login page

  Scenario: Login with valid standard user credentials
    When user enters "standard_user" and "secret_sauce"
    Then user should be navigated to the products page

#  Scenario: Login with locked out user credentials
#    When user enters "locked_out_user" and "secret_sauce"
#    Then user should see an error message "Sorry, this user has been locked out."

#  Scenario: Login with problem user credentials
#    When user enters "problem_user" and "secret_sauce"
#    Then user should be navigated to the products page
#    And verify potential image or UI glitches
#
#  Scenario: Login with performance glitch user credentials
#    When user enters "performance_glitch_user" and "secret_sauce"
#    Then user should be navigated to the products page
#    And page load may be slower than usual
#
#  Scenario: Login with error user credentials
#    When user enters "error_user" and "secret_sauce"
#    Then user should be navigated to the products page
#    And application might behave unexpectedly
#
#  Scenario: Login with visual user credentials
#    When user enters "visual_user" and "secret_sauce"
#    Then user should be navigated to the products page
#    And verify visual elements rendering properly
