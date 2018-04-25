Feature: This tests check reservation

  Scenario: Check reservation, that was created automatically
    When we are requesting reservations
    And name is John
    And surname is Smith
    And departure airport is RIX
    And arrival airport is JFC
    And luggage count is 2
    And discount code is Code123
    And children count is 1
    And flight date is 13
    And adults count is 2
    And seat number is 13
    Then reservation should be in list
