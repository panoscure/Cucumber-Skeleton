Feature: Get Sensor Info API

  Scenario Outline: Validate sensor info for given terminal and conditions
    When I call the sensor info API with terminal_id "<terminal_id>" and terminal_ip "<terminal_ip>"
    Then the crontab value should be less than or equal to "<max_crontab>"
    And the secondary_url should not be empty
    And the response message should be "<expected_message>"

    Examples:
      | terminal_id            | terminal_ip     | max_crontab | expected_message         |
      | ESP32c04e3080ca2c      | 192.168.2.10    | 5           | Data Successfully Sent   |
      | ESP327821848e59ec      | 192.168.2.11    | 5           | Data Successfully Sent   |