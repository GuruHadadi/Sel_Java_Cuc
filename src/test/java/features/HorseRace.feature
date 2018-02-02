Feature: As a user, I go bet

  Scenario: Add money to Bet slip
    Given I am on William Hill main page
    And I click on Racing link
    And I click on Horse Racking Betting cell
    When I enter betting type and amount
    And click on Add to Bet slip
    Then the betting type and stake displays in betslip summary area
#
#    Examples:
#      | betType                                              |
#      | "Quinella"                |