# Is not taken into account for this kata : the stock management, the client management and the different products categories.

Feature: Pricing goods strategy
As a merchant
I want to give products different prices
In order to increase chances of purchase

    Scenario: Fix pricing
        Given I have a product costing $3.00
        When a client purchase 1 product
        Then he pays $3.00

    Scenario: Price depends on weight
        Given I have a product costing $2.00 per pound
        When a client purchase 10 ounces of this product
        Then he pays $1.25

    Scenario Outline: Several purchase gives a reduction
        Given I have <in stock> products
        When a client buys <purchase> products
        Then the total price should be <price>
        Examples:
            | in stock | purchase | price |
            | 10       | 3        | 2.50  |
            | 10       | 1        | 1.00  |

    Scenario Outline: Several purchase gives a product for free
        Given I have <in stock> products
        When a client buys <purchase> products
        Then the total price should be <price>
        Examples:
            | in stock | purchase | price |
            | 10       | 3        | 2.00  |
            | 10       | 1        | 1.00  |