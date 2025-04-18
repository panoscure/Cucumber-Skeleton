Feature: Google search and redirection to Panoscure site

  Scenario Outline: Search for term and navigate to result
    Given I am on Panos page
    And I refresh the page
    When I search for "<searchTerm>"
    #And I click on the result linking to "panoscure.synology.me:8080"
    Then I should be redirected to Panoscure home page and see "<expectedText>"

    Examples:
      | searchTerm | expectedText       |
      | Home  | What's an embedded system? |
      | synology   | About the AVR microcontroller|
