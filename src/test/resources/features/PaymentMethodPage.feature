Feature: Payment Method Page

  @MVP
  Scenario: Selecting 'pay by bank wire'
    Given I am on the Payment Method Page
    When I click pay by bank wire
    Then The bank wire payment page appears

  Scenario: Clicking Continue Shopping returns user to Shipping Page
    Given I am on the Payment Method Page
    When I click on continue shopping on the Payment Method Page
    Then The user is sent back to the Shipping Page From the Payment Method Page

  Scenario: Clicking Shipping Page returns user to Shipping Page
    Given I am on the Payment Method Page
    When I click on Shipping Page on the Payment Method Page
    Then The user is sent back to the Shipping Page From the Payment Method Page

  Scenario: Clicking Address Page returns user to Address Page
    Given I am on the Payment Method Page
    When I click on Address Page on the Payment Method Page
    Then The user is sent back to the Address Page From the Payment Method Page

  Scenario: Clicking Summary Page returns user to Summary Page
    Given I am on the Payment Method Page
    When I click on Summary Page on the Payment Method Page
    Then The user is sent back to the Summary Page From the Payment Method Page

  Scenario: Clicking the Home Page Icon returns user to Homepage from Payment Method Page
    Given I am on the Payment Method Page
    When I click on the Home Page Icon on the Payment Method Page
    Then The user is sent back to the Home Page from the Payment Method Page