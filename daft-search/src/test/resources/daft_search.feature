@regression @search
Feature: Property search and filter

  Scenario: Launch application
    Given I have navigated to Daft web application at https://www.daft.ie/

  Scenario: Search for a Sale Ad
    When I search the term Dublin County using the homepage search tool
    Then Properties for Sale in Dublin (County) should be displayed in the search result

  Scenario: Apply search filter and verify result
    When I apply the keyword filter, garage to the search result
    Then the number of filtered results should be less than total number of results before the filtering
    Then the URL of the result page should contain the search query: terms=garage
    And the term, garage should be contained in any of the results, when opened
    And the browser should close


