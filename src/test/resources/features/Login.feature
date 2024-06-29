Feature: Login feature

  Scenario:
    Given I open browser
    And I open Login page
    When I enter email "kristina.sarkisyan@testpro.io"
    And I enter password "o8URUDnW"
    And I submit
    Then I am logged in

    Scenario:
      Given I open browser
      And I open Login page
      When I enter email "kristina.sarkisyan@testpro.io"
      And I enter incorrect password "incorrectPassword"
      And I submit
      Then I am not logged in

      Scenario:
        Given I open browser
        And I open Login page
        When I enter email "kristina.sarkisyan@testpro.io"
        And I enter password "o8URUDnW"
        And I submit
        When I navigate to AllSongs
        And Context click on first song
        And Choose Play Option
        Then Song is playing


