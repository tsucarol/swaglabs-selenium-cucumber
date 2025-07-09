Feature: Buy Products Online

Scenario Outline: Unsuccessful login
    Given I am on the login page "https://www.saucedemo.com/"
    When I enter "<username>" and "<password>"
    And I click the Login button
    Then I should see an error message "<error_message>"
Examples:
| username                | password     | error_message                                                             |
| locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
| standard_user           | test123      | Epic sadface: Username and password do not match any user in this service |
| incorrect_user          | secret_sauce | Epic sadface: Username and password do not match any user in this service |

Scenario Outline: Login successfully
    Given I am on the login page "https://www.saucedemo.com/"
    When I enter "<username>" and "<password>"
    And I click the Login button
    Then I should be redirected to the inventory page
Examples:
| username      | password     |
| standard_user | secret_sauce |

################################################################################################################################
   
@cart
Scenario Outline: Adding products to cart from inventory page
    Given I am on the inventory page "https://www.saucedemo.com/inventory.html"
    And I reset the app state
    When I click Add to cart for the product "<product>" 
    Then the button for "<product>" should change to Remove
    And the cart counter should show "<expected_count>" item(s)
Examples:
| product                  | expected_count |
| Sauce Labs Backpack      | 1              |
| Sauce Labs Bike Light    | 1              |
| Sauce Labs Fleece Jacket | 1              |
| Sauce Labs Bolt T-Shirt  | 1              |

@cart
Scenario: Cart page
    Given I am on the cart page "https://www.saucedemo.com/cart.html"
    When I click Checkout button
    Then I should be redirected to the pre-checkout page 