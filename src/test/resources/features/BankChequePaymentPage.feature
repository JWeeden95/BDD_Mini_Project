Feature: Bank Cheque Payment Page

  Scenario: Clicking I confirm my order from Bank Cheque Payment Page
    Given I am on the Bank Cheque Payment Page
    When I click on confirm my order from Bank Cheque Payment Page
    Then The Cheque Payment Confirmation Page Appears

  Scenario:Clicking Other Payment Methods from Bank Cheque Payment Page
    Given I am on the Bank Cheque Payment Page
    When I click on Other payment methods on Bank Cheque Payment Page
    Then The user is sent back to the Payment Methods Page from Bank Cheque Payment Page