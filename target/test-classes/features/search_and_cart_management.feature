Feature: WebstaurantStore Search and Cart Functionality

  Background:
    Given user is on WebstaurantStore homepage

  Scenario: Search for 'stainless work table' items
    When the user searches for "stainless work table"
    Then they should see only items with "Table" in the title



  Scenario: Add last found item to the cart and empty the cart
    When the user searches for "stainless work table"
    And the user navigates to the last page
    And the user adds the last item found to the cart
    And the user clicks on view cart button
    Then the last item should be in the cart
    When the user empties the cart
    Then the cart should be empty