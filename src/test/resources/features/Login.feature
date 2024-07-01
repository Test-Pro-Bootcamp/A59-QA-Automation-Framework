Feature: Login feature

  Scenario: Positive Login Scenario
     Given I open Koel Login page
      When I enter email "demo@testpro.io"
       And I enter password "te$t$tudent"
       And I click submit
      Then I should be logged in

  Scenario: Login incorrect password
     Given I open Koel Login page
      When I enter email "demo@class.com"
       And I enter password "te1t9tudent"
       And I click submit
      Then I am still at the Login page

  Scenario: Login Not existing email
     Given I open Koel Login page
      When I enter email "demo@class.com"
       And I enter password "te$t$tudent"
       And I click submit
      Then I am still at the Login page

  Scenario: Empty Login and Password
     Given I open Koel Login page
      When I enter email " "
       And I enter password " "
       And I click submit
      Then I am still at the Login page

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
