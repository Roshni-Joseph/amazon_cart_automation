Feature: Add to cart feature in Amazon

  Scenario: Verify item is added to cart when add to cart button is clicked
    Given the user selects the item
    When the user clicks add to cart button
    Then the item is added to cart

#  Scenario: Verify the subtotal is shown when new item is added to cart
#    Given the user navigate to amazon website
#    When the user selects the items and click add to cart button
#    Then the items are added to cart and subtotal is shown

  Scenario: Verify item can be deleted from cart
    Given the cart contain two items
    When the user clicks on delete button for first item
    Then the item is removed from cart and it is empty

  Scenario: Verify items "No Results" is displayed for invalid product name
  Given user navigate to amazon website
  When the user search for invalid item name
  Then "No Results" is displayed

  Scenario: Verify the cart is empty and cart icon is zero when no items are added
    Given user navigate to amazon website
    When the user clicks on cart icon
    Then the cart is empty and icon is zero

  Scenario: Verify the cart icon number is increased when item is added
    Given the user navigate to amazon website
    When the user selects the item and click add to cart button
    Then the cart icon number is one

  Scenario: Verify add to cart button
    Given user open amazon website
    When the user add item to cart
    Then the item is displayed in cart

  Scenario Outline: Verify the products are displayed when user search for different products
    Given the user navigates to amazon website
    When user search for product as "<itemname>"
    Then the products are displayed as "<result>"
    Examples:
      |itemname|result|
      |mobiles|\"mobiles\"|
      |toys|\"toys\"|



