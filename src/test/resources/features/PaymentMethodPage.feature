Feature: Payment Method Page


  Scenario: Selecting 'pay by bank wire'
    Given I am on the Payment Method Page
    When I click pay by bank wire
    Then The bank wire payment page appears