Feature: Login feature

  Scenario: Positive Login Scenario
    Given I open Koel Login Page
    When I enter email "india.messam@testpro.io"
    And I enter password "slcTalgy"
    And I click submit
    Then I should be logged in

