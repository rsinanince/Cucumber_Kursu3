Feature: Citizenship with scenario outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship page

    Scenario Outline: Citizenship create
      When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
      Then Success message should be displayed

      When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
      Then Already exists message should be displayed
      And Click on close button

      When User delete the "<CitizenshipName>"
      Then Success message should be displayed

      Examples:
      | CitizenshipName | ShortName |
      | Citizennn766       | citizz52    |
      | Citizennn776       | citizz53    |
      | Citizennn786       | citizz54    |




