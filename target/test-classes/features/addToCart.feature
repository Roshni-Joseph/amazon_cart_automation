Feature: Add to cart feature in Amazon

  Scenario: Verify item is added to cart when add to cart button is clicked
    Given the user selects the item
    When the user clicks add to cart button
    Then the item is added to cart

#  Scenario: Verify the price is doubled when quantity is incremented by two
#    Given the user has an item in the cart
#    When the user increases the quantity to two
#    Then the price is doubled
  @smoke
  Scenario: Verify the subtotal is shown when new item is added to cart
    Given the user navigate to amazon website
    When the user selects the items and click add to cart button
    Then the items are added to cart and subtotal is shown

#  Scenario: Verify item can be deleted from cart and price is decreased
#    Given the cart contain two items
#    When the user clicks on delete button for first item
#    Then the item is removed from cart and price is decreased
#
#  Scenario: Verify the cart is empty when the left item is removed
#    Given the cart contain one item
#    When the user clicks on delete button
#    Then the cart is empty
