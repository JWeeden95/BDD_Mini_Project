# new feature
# Tags: optional

Feature: Sign in page

  Scenario: Signing into your account
    Given I am on the sign in page
    And I have filled in the correct username and password
    When I press enter
    Then my account page appears

  Scenario: Incorrect username
    Given I am on the sign in page
    And I fill in the incorrect username but correct password
    When I press enter
    Then the authentication page appears

  Scenario: Incorrect password
    Given I am on the sign in page
    And I fill in the correct username but incorrect password
    When I press enter
    Then the authentication page appears

  Scenario: Incorrect username and password
    Given I am on the sign in page
    And I fill in the incorrect username and password
    When I press enter
    Then the authentication page appears