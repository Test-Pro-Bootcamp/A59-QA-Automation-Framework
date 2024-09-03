Feature: Login feature

  Scenario: positive Login


    Given I open koel login page
    When I enter email "rfkayoub12@gmail.com"
    And I enter password "te$t$tudent"
    And I click submit
    Then I am successfully logged in