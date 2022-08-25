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
      | sinanFee04 | 01452   | spotify      | 121      |
      | sinanFee05 | 01563   | netflix      | 122      |
      | sinanFee06 | 02457   | amazonprime  | 133      |