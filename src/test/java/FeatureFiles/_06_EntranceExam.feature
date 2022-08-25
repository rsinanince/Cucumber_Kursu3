# 1 sınav girişi yapınız
# girişi siliniz

  Feature: Entrance Exam Functionality

    Background:
      Given Navigate to basqar
      When Enter username and password and click login button
      Then User should login successfully

      Scenario: Create and Delete an Exam
        And Click on the element in the left Nav
          | entranceExamsOne|
          | setupTwo        |
          | entranceExamsTwo|

        And Click on the element in the Dialogue
          | addButton       |

        And User sending the keys in Dialogue content
          | nameInput | sinanNat05 |

        And Click on the element in the Form Content
          | academicPeriod  |
          | academicPeriod1 |
          | gradeLevel      |
          | gradeLevel2     |

        And Click on the element in the Dialogue
          | saveButton      |

        Then Success message should be displayed

        And Click on the element in the left Nav
          | entranceExamsOne |
          | setupTwo         |
          | entranceExamsTwo |

        And User delete item from Dialogue
          | sinanNat05 |

        Then Success message should be displayed

