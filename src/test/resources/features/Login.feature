Feature: Login feature

  Scenario: Positive Login Scenario
    Given I open Koel Login Page
    When I enter email "demo@testpro.io"
    And I enter password "te$t$tudent"
    And I click submit
    Then I should be logged in
