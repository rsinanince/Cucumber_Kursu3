Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | states      |
    Then Send the query to database "select * from States" and control match