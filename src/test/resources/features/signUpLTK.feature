@SignUp
Feature: Users should be able to sign up and redirected to the discovery page

  Background: For each scenario user is on LTK sign up page
    Given user is  on the ltk sign up page

  Scenario: Sign up as a new user and verify that the user is redirected to discover home page

    When user sign up as a new user with valid email format
    And user should be able to continue creating a new valid password
    Then user should be redirected to discover home page


  Scenario: Signup as a new user with invalid email format and verify user is not able to continue

    When User enters invalid email format
    Then User should be able to see "Enter your email" message

  Scenario: Signup as a new user with empty email format and verify user is not able to continue

    When User enters empty email format
    Then User should not not be able to click continue


