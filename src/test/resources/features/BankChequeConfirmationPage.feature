# new feature
# Tags: optional

Feature: Bank Cheque Confirmation Page

  Scenario: Clicking Back to orders from Bank Cheque Confirmation Page
    Given I am on the Bank Cheque confirmation Page
    When I click on Back to orders from Bank Cheque Confirmation Page
    Then The user is sent to the Order History Page
