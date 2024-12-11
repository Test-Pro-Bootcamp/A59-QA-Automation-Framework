Feature: login feature

  Scenario: login scenario

    Given I open login page
    When I enter login email "apurva.singh@testpro.io"
    And  login password"te$tpro$tudent1"
    And I Submit
    Then I am logged in.

    Scenario Outline: Negative login scenario
      Given I open login page
      When I enter login email "<email>"
      And  login password"<password>"
      And I Submit
      Then I should not get log in


      Examples:
      |email                        |password       |
      |invalid @testpro.io          |te$tpro$tudent1|
      |valid@testpro.io             |invalid pass   |
      |valid@testpro.io             |               |
      |                             |invalid pass   |