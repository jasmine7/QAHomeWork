Feature: This tests are created weather testing.

  Scenario: Testing coordinates
    When we are requesting weather
    Then LON should be -0.13
    And LAT should 51.51