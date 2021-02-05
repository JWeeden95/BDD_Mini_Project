Feature: Order confirmed

#Given that I am on the bank wire page
#When I click confirm order
#Then the order confirmation page appears

  Scenario: can I confirm order
    Given that I am on the bank wire page
    When I click confirm order
    Then the order confirmation page appears

#    Scenario: can I go back to payment method when on bank wire payment page
#      Given that I am on the bank wire page
#      When I click other payment methods
#      Then payment method page appears when coming from bank wire payment page