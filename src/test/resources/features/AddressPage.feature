# new feature
# Tags: optional

Feature: Address page functionality

  @addressToShipping
  Scenario: Proceeding to shipping page
    Given that I am on the Address page
    And I have left no comment in the comment box
    And my billing information is correct
    When I click proceed to checkout from address page
    Then I'm taken to the shipping page

    @addressChange
    Scenario: Change shipping address
      Given that I am on the Address page for Change
      And I have left no comment in the comment box
      And My shipping Address is my Billing Address button checked
      When I change my address
      Then My address for both billing and shipping changed to selected

      @shippingAddressOnlyChange
      Scenario: Make shipping address different from billing
        Given that I am on the Address page to change just shipping address
        And I have left no comment in the comment box
        And My shipping Address isn't my billing address
        When I change my shipping address
        Then I will have a different shipping address

        @billingChangeOnly
        Scenario: Change just the billing address
          Given I am signed in on the address page
          And My shipping Address is my Billing Address button unchecked
          When I change my billing address
          Then My billing address doesn't change

