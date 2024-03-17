Feature: WebstaurantStore Search and Cart Functionality

  Background:
    Given user is on WebstaurantStore homepage

  Scenario: Search for 'stainless work table' items
    When the user searches for "stainless work table"
    Then they should see only items with "Table" in the title
