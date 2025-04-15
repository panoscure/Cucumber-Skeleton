Feature: Google Search

  Scenario: User searches for a term on Google
    Given the user opens the Google homepage
    When the user searches for "OpenAI"
    Then the search results are displayed