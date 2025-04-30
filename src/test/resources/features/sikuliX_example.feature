Feature: Google search and redirection to Panoscure site

  Scenario Outline: Search for term and navigate to result
    Given I am on Panos page
    And I refresh the page
    When I click tab "Parking Sensor"
    And I wait for 5 seconds
    And I click the video
    And I wait for 10 seconds
    #Then I should be redirected to Panoscure home page and see "<expectedText>"

    Examples:
      | searchTerm | expectedText       |
      | Home  | What's an embedded system? |