Feature: This tests are created weather testing.

  Scenario: Testing coordinates
    When we are requesting weather
    Then LON should be -0.13
    And LAT should 51.51

  Scenario: Testing city
    When we are requesting weather
    Then city NAME should be London
    And city ID should be 2643743

  Scenario: Testing country
    When we are requesting weather
    Then country should be GB

  Scenario: Testing max and min temperatures
    When we are requesting weather
    Then max temperature should be greater than min temperature