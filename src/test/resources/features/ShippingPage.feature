Feature: Shipping confirmation

  Scenario:
    Given that I am on the shipping page and checkbox is checked
#    When I click proceed to checkout from shipping page
#   needs to change to the above to avoid duplication issue (JF)
    When I click proceed to checkout from shipping page
    Then confirm I am on the payment confirmation page

  Scenario: Click agree terms of service
    Given that I am on the shipping page
    When I click the agree to terms of service box
    Then the agree to terms of service box should be ticked

  Scenario: Continue shopping from shipping page
    Given that I am still on the shipping page
    When I click the Continue shopping button
    Then I go to the address page

  Scenario: Go to homepage from shipping page
    Given I am on the shipping page again
    When I click the home icon on shipping page
    Then I go to the home page