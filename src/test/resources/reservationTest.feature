Feature: This tests check reservation

  Scenario: Check reservation, that was created automatically
    When we are requesting reservations
    Then reservation id should be 63
    And name should be John
    And surname should be Smith
    And departure airport should be RIX
    And arrival airport should be JFC
    And luggage count should be 2
    And discount code should be Code123
    And children count should be 1
    And flight date should be 13
    And adults count should be 2
    And seat number should be 13
