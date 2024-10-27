Feature: Search and place the order for products
@PlaceOrder
Scenario Outline: User experience for search product both in home and offers page

Given User is on Greenkart landing page
When User searched with shortname <Name> and extracted the actual name of the product
And Added "3" items of the selected product to cart
Then User proceeds out to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
|Name|
|Tom|
#|Beet|