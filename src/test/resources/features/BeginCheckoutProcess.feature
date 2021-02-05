Feature: I want to be able to begin the checkout process after adding an item to my basket

  Scenario: Begin checkout process
    Given I am on the home page
    And I have clicked add to cart
    When I click proceed to checkout from home
    Then The order summary page appears

  Scenario: Alternative begin checkout process
    Given I am on the home page
    And I have clicked add to cart
    And I have clicked continue shopping
    When I click the alternative proceed to checkout from home
    Then The order summary page appears

  Scenario: Third checkout process
    Given I am on the home page
    And I have clicked add to cart
    And I have clicked continue shopping
    When I click the cart
    Then The order summary page appears