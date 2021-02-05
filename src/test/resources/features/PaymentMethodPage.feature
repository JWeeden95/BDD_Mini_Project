Feature: Payment Method Page

  Scenario: Selecting 'pay by bank wire'
    Given I am on the Payment Method Page
    When I click pay by bank wire
    Then The bank wire payment page appears

  Scenario: Clicking Continue Shopping returns user to Shipping Page
    Given I am on the Payment Method Page
    When I click on continue shopping on the Payment Method Page
    Then The user is sent back to the Shipping Page

  Scenario: Clicking Shipping Page returns user to Shipping Page
    Given I am on the Payment Method Page
    When I click on Shipping Page on the Payment Method Page
    Then The user is sent back to the Shipping Page