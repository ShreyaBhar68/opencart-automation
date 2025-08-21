Feature: OpenCart E-commerce Scenarios

  Scenario: User Login
    Given I am on the OpenCart homepage
    When I navigate to the Login page
    And I enter valid credentials "bharShreya37@gmail.com" and "Shreya@123"
    Then I should see the "My Account" page heading

  Scenario: Product Search
    Given I am on the OpenCart homepage
    When I search for a product "MacBook"
    Then the search results should contain the product "MacBook"

  Scenario: Add Product to Cart
    Given I am on the OpenCart homepage
    When I search for a product "iPhone"
    And I click "Add to Cart" for the "iPhone"
    Then a success message "Success: You have added iPhone to your shopping cart!" should be displayed
