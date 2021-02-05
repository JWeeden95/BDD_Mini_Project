# new feature
# Tags: optional

Feature: Summary confirmation

  Scenario: Clicking the checkout button on the cart Summary page
    Given I am on the order summary page
    And I have 1 item
    When I click proceed to checkout from Summary page
    Then Address page appears

  Scenario:  Clicking the plus button on the summary page
    Given I am on the order summary page
    And I have 1 item
    When I click on the plus button next to the item
    Then the total product counter should be 2

  Scenario:  Clicking the minus button on the summary page
    Given I am on the order summary page and i have 2 items in the basket
    When I click on the minus button next to the item
    Then the total product counter should be 1