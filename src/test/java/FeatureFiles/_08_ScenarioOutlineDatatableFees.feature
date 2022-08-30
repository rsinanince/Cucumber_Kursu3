#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create a Fee, delete Fee

    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialogue
      | addButton |

    And User sending the keys in Dialogue content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in the Dialogue
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialogue
      | <name> |

    And Success message should be displayed

    Examples:
      | name       | code    | intCode      | priority |
      | sinanFee07 | 01453   | spotify      | 124      |
      | sinanFee08 | 01564   | netflix      | 125      |
      | sinanFee09 | 02458   | amazonprime  | 136      |