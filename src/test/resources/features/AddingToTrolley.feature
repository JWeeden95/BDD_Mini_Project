# new feature
# Tags: optional

Feature: Add to Trolley

  @addToBasketFromMain
  Scenario: Adding an item to cart
    Given I have access to homePage for addCart
    When I click on the add to cart button of an item
    Then The cart total will change to 1