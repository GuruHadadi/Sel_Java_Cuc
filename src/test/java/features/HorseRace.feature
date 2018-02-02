Feature: As a user, I want to perform betting on William Hill website

  Scenario Outline: Add stakes to multiple betting types for horse racing
    Given I am on William Hill main page
    And I click on Racing link
    And I click on any available Horse Racking Betting cell
    When I enter <bettingType> and <stake>
    And click on Add to Bet slip button
    Then the added <bettingType> and <stake> displays correctly in the betslip summary area

    Examples:
      | bettingType | stake |
      | Quinella    | 10.5  |
      | Exacta      | 21.5  |