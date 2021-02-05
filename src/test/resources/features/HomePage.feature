# new feature
# Tags: optional

Feature: Homepage

  Scenario: Going to sign in page from home page
    Given I am on the initial home page
    When I click sign in
    Then The sign in page appears

  Scenario: Going to summary page from homepage
    Given I am on the initial home page
    And I am signed in
    And I have an item in my basket
    When I click proceed to checkout from home page
    Then The summary page appears