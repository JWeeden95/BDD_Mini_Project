# new feature
# Tags: optional

Feature: Sign in page

  Scenario: Signing into your account
    Given I am on the sign in page
    And I have filled in the correct username and password
    When I press enter
    Then my account page appears