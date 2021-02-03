Feature: Shipping confirmation

  Scenario:
  Given that I am on the shipping page
    And I have ticked the ‘agree to terms of service’ box
  When I click proceed to checkout
  Then the Payment page appears