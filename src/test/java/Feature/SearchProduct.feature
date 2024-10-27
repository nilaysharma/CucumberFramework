Feature: Search and place the order for products
@OffersPage
Scenario Outline: User experience for search product both in home and offers page

Given User is on Greenkart landing page
When User searched with shortname <Name> and extracted the actual name of the product
Then User searched with <Name> shortname on offers page
And validate that shortname on productPage matches with offer page

Examples:
|Name|
|Tom|
|Beet|