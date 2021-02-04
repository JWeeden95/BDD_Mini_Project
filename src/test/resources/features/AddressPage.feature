# new feature
# Tags: optional

Feature: Address confirmation issue15

  @addressToShipping
  Scenario: Proceeding to shipping page
    Given that I am on the Address page
    And I have left no comment in the comment box
    And my billing information is correct
    When I click proceed to checkout from address page
    Then I'm taken to the shipping page