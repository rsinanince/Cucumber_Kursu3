Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

    Scenario: Create Country
      And Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | countries   |

    And Click on the element in the Dialogue
      | addButton   |

    And User sending the keys in Dialogue content
      | nameInput | sinanCountry1 |
      | codeInput | 456987        |

    And Click on the element in the Dialogue
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialogue
      | sinanCountry1 |

    And Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element in the left Nav
    | setupOne      |
    | parameters    |
    | nationalities |

    And Click on the element in the Dialogue
    | addButton     |

    And User sending the keys in Dialogue content
    | nameInput | sinanNat51 |

    And Click on the element in the Dialogue
    | saveButton  |

    And Success message should be displayed

    And User delete item from Dialogue
      | sinanNat51 |

    And Success message should be displayed

  Scenario: Create a Fee, delete Fee

    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | fees          |

    And Click on the element in the Dialogue
      | addButton     |

    And User sending the keys in Dialogue content
      | nameInput       | sinanFee01 |
      | codeInput       | sinanFee02 |
      | integrationCode | sinanFee03 |
      | priorityCode    | sinanFee04 |

    And Click on the element in the Dialogue
      | saveButton  |

    And Success message should be displayed

    And User delete item from Dialogue
      | sinanFee01 |

    And Success message should be displayed

    #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyor.
    #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.