# new feature
# Tags: optional

Feature: Order History

  Scenario: Checking Order has been confirmed
    Given I am on the Bank Cheque Confirmation Page
    And I have the order reference
    When I click go to Order History Page
    Then The order reference should be there
