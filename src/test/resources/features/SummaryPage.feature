# new feature
# Tags: optional

Feature: Summary confirmation

  Scenario: Clicking the checkout button on the cart Summary page
    Given I am on the order summary page
    And I have 1 item
    When I click proceed to checkout from Summary page
    Then Address page appears
#
#  Scenario:  Clicking the plus button on the order summary page
#    Given I am on the order summary page
#    And I have 1 item
#    When I click on the plus button next to the item
#    Then the total product counter should increment by 1