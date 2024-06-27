Feature: Login feature

  Scenario: Positive Login Scenario
     Given I open Koel Login page
      When I enter email "demo@testpro.io"
       And I enter password "te$t$tudent"
       And I click submit
      Then I should be logged in

  Scenario Outline: Login Scenario
     Given I open Koel Login page
      When I enter email "<Email>"
       And I enter password "<Password>"
       And I click submit
      Then I should be logged in

    Examples:
      | Email                   | Password      |
      | demo@something.io       | WrongPW       |
      | demo@safadf.io          | WrongPW       |
      | dem@yaumm.io            |               |
      | ddddm@yahah.io          | WrongPW       |
      |                         |               |
