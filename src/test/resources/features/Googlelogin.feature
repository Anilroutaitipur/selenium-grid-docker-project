Feature: Google Search

  Scenario: Search in Google
    Given I open Google homepage
    When I search for "Selenium Grid Docker"
    Then The page title should contain "Selenium"


