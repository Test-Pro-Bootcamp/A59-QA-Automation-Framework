Feature: Login feature
# This is comment
  Scenario: Positive Login Scenario
    Given I open Koel Login Page
    When I enter email "aleksei.koksharov@testpro.io"
    And I enter password "ak1234!@#$"
    And I click submit
    Then I should be logged in

    Scenario Outline: Login Scenario
      Given I open Koel Login Page
      When I enter email "<Email>"
      And I enter password "<Password>"
      And I click submit
      Then I should be logged in
      Examples:
        | Email |                      Password|
        | alekseikoksharov@testproio   |ak1234!@#$|
        | aleksei.koksharov@testpro.io |ak1234    |
        |                              |ak1234!@#$|
        | aleksei.koksharov@testpro.io |          |
        | aleksei.koksharov@tro.io     |ak14!@#$  |