# new feature
# Tags: optional

Feature: Address confirmation issue15

  @addressToShipping
  Scenario: Proceeding to shipping page
    Given that I am on "http://automationpractice.com/index.php?controller=order&step=1" page
    And I have left no comment in the comment box
    And my billing information is correct
    When I click proceed to checkout from address page
    Then the next page is the shipping page, which has the url "http://automationpractice.com/index.php?controller=order"