Feature: Login feature

    Scenario: Positive Login Scenario
      Given I open Koel Login Page
      When I enter email "leon.poyau+2@testpro.io"
      And I enter password "N6wWY2Rx"
      And I click submit
      Then I should be logged in

    # Scenario Outline allows us to test with multiple test data (all negative in this case)
    Scenario Outline: Negative Login Scenario
      Given I open Koel Login Page
      When I enter email "<Email>"
      And I enter password "<Password>"
      And I click submit
      Then I should not be logged in

    Examples:
      | Email                   | Password  |
      | len.poyau+2@testpro.i   | N6wWY2Rx |
      | leon.poyau+2@testpro.io | N6wW2Rx  |
      |                         | N6wWY2Rx |
      | leon.poyau+2@testpro.io |          |
      |                         |          |