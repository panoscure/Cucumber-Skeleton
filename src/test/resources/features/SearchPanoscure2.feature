Feature: Panoscure Site Click Tabs and verify text 2

  Scenario Outline: Search for term and navigate to result
    Given I am on Panos page
    And I refresh the page
    And I click tab "LCD Connection"
    And I click tab "Keypad Conn."
    And I click tab "Joystick conn."
    And I click tab "Contact"
    And I click tab "Home"
    When I search for "<searchTerm>"
    #And I click on the result linking to "panoscure.synology.me:8080"
    Then I should be redirected to Panoscure home page and see "<expectedText>"

    Examples:
      | searchTerm | expectedText       |
      | Home  | What's an embedded system? |
      | Home   | What's an embedded system?|
