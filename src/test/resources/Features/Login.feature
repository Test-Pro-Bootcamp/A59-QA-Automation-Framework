Feature: Login feature
  #hash allows for comments
  Scenario: Positive Login Scenario
    Given I open Koel Login Page
    When I enter email "giovanna.silva@testpro.io"
    And I enter password "ShakaMaya1302!"
    And I click submit
    Then I should be logged in
