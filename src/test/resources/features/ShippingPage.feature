Feature: Shipping confirmation

  Scenario:
    Given that I am on the shipping page
    And I have clicked the agree to terms of service box
#    When I click proceed to checkout from shipping page
#   needs to change to the above to avoid duplication issue (JF)
    When I click proceed to checkout from shipping page
    Then confirm I am on the payment confirmation page

  Scenario:
    Given that I am on the shipping page
    When I click the agree to terms of service box
    Then the agree to terms of service box should be ticked