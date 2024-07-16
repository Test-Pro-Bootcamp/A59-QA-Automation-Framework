Feature: LoginInvalidEmail feature

  Scenario: Negative Login Scenario
    Given I open Koel Login Page
    When I enter invalid email "alekseikoksharov@testproio"
    And I enter password "ak1234!@#$"
    And I click submit
    Then I should be staying in Login Page
